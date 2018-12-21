
import com.security.Base64;
import java.io.PrintStream;
import java.sql.*;
import java.util.ResourceBundle;
import sfmshub.coms.core.utils.InputOutput;
import sfmshub.coms.core.utils.*;

public class InsertDataIntoTBSI {

	public static void main(String args[]) throws Exception {
		Connection aCon = null;
		PreparedStatement tbsbStmt = null;
		ResultSet rs = null;
		Statement statement = null;
		try {

			ResourceBundle rsBundle = ResourceBundle.getBundle("jdbc");
			String userId = rsBundle.getString("jdbc.username").trim();
			String pwd = new String(InputOutput.outputByte(rsBundle.getString("jdbc.password")));
			String driverClass = rsBundle.getString("jdbc.driverClassName").trim();

			String dbURL = rsBundle.getString("jdbc.url").trim();

			Class.forName(driverClass);
			aCon = DriverManager.getConnection(dbURL, userId, pwd);
			System.out.println("got the DB connection");
			statement = aCon.createStatement();
			System.out.println(" got the stmt");

			String s4 = "SELECT MHI_RCVR_ADDRS,MHI_SNDR_REF FROM mhi_msg_hdr_inter WHERE MHI_RCVR_ADDRS like 'BARB%' AND  TO_CHAR(mhi_crtn_date,'yyyy/MM/dd') in ('2018/12/12') and mhi_msg_stat=10";

			tbsbStmt = aCon.prepareStatement("INSERT INTO TBSI_TO_BE_SENT_INT VALUES (?,?,1,1,?)");

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

		} catch (Exception exception) {
			if (aCon != null)
				aCon.rollback();
			System.out.println(" Exception occurred ***" + exception + "***");
			exception.printStackTrace();
		} finally {

			try {

				if (rs != null)
					rs.close();
				System.out.println(" Successfully closed  result set");
				if (tbsbStmt != null)
					tbsbStmt.close();
				System.out.println(" Successfully closed  preparestatement");

				if (statement != null)
					statement.close();
				System.out.println(" Successfully closed statement");
				if (aCon != null)
					aCon.close();

				System.out.println(" Successfully closed connection");

			} catch (Exception e) {

				e.printStackTrace();

			}

		}
	}
}
