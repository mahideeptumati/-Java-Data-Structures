import com.security.Base64;
import java.io.PrintStream;
import java.sql.*;
import java.util.ResourceBundle;
import sfmshub.coms.core.utils.InputOutput;
import sfmshub.coms.core.utils.*;

public class UpdateHUBBR {

	public static void main(String args[]) throws Exception {
		Connection aCon = null;
		try {

			ResourceBundle rsBundle = ResourceBundle.getBundle("jdbc");
			String userId = rsBundle.getString("jdbc.username").trim();
			String pwd = new String(InputOutput.outputByte(rsBundle.getString("jdbc.password")));
			String driverClass = rsBundle.getString("jdbc.driverClassName").trim();

			String dbURL = rsBundle.getString("jdbc.url").trim();

			Class.forName(driverClass);
			aCon = DriverManager.getConnection(dbURL, userId, pwd);
			System.out.println("got the DB connection");
			Statement statement = aCon.createStatement();
			System.out.println(" got the stmt");

			PreparedStatement tbsbStmt = null;

			String s4 = "SELECT MHI_RCVR_ADDRS,MHI_SNDR_REF FROM mhi_msg_hdr_inter WHERE MHI_SNDR_REF in('201812121749RBIP0NEFTSC788368086') and MHI_RCVR_ADDRS like 'BARB%' AND  TO_CHAR(mhi_crtn_date,'yyyy/MM/dd') in ('2018/12/12') and mhi_msg_stat=10";

			tbsbStmt = aCon.prepareStatement("INSERT INTO TBSI_TO_BE_SENT_INT VALUES (?,?,1,1,?)");
			ResultSet rs = null;

			String rcvrAddress = "";
			String sndrRefNo;
			int p = 0;
			aCon.setAutoCommit(false);

			rs = statement.executeQuery(s4);

			while (rs.next()) {

				rcvrAddress = rs.getString(1);
				sndrRefNo = rs.getString(2);


				tbsbStmt.setString(1, rcvrAddress);
				tbsbStmt.setString(2, sndrRefNo);

				tbsbStmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

				tbsbStmt.executeUpdate();

				p++;

			}
			System.out.println(" Successfully sent BARB messages for date 12th December count " + p);
			aCon.commit();
			statement.close();
			if (rs != null)
				rs.close();

			System.out.println(" Successfully closed statement");
			aCon.close();
			System.out.println(" Successfully closed connection");
		} catch (Exception exception) {
			if(aCon!=null)
				aCon.rollback();
			System.out.println(" Exception occurred ***" + exception + "***");
			exception.printStackTrace();
		}
	}
}
