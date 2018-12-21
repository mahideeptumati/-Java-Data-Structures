import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import sfmshub.coms.core.utils.InputOutput;
import sfmshub.coms.core.utils.*;


public class  UpdateHUBBR_SENT
{



	public static void main(String args[])
			throws Exception
	{
		Connection connection =null;
		PreparedStatement pStmnt1=null;
		int i;
		try{


			ResourceBundle rsBundle = ResourceBundle.getBundle("jdbc");
			// Changes done for HUB Porting - Start
			String userId = rsBundle.getString("jdbc.username").trim();
			String pwd = new String(InputOutput.outputByte(rsBundle.getString("jdbc.password")));
			// Changes done for HUB Porting - end
			String driverClass = rsBundle.getString("jdbc.driverClassName").trim();

			String dbURL = rsBundle.getString("jdbc.url").trim();

			Class.forName(driverClass);
			connection = DriverManager.getConnection(dbURL, userId, pwd);
			
			connection.setAutoCommit(false);
			System.out.println(" got the DB connection");
		
		
			String UPDATE_MHI_SQL_Oracle ="update mhi_msg_hdr_inter set mhi_msg_stat =10 where TO_CHAR(mhi_crtn_date,'YYYY-MM-DD')='2018-12-12' and mhi_next_addrs like 'BARB%' and MHI_SNDR_REF='201812121749RBIP0NEFTSC788368086'";
					

			pStmnt1 = connection.prepareStatement(UPDATE_MHI_SQL_Oracle);



			i = pStmnt1.executeUpdate();


			if (i == 1)
				System.out.println("Succesfully updated  msg with sndrref  201812121749RBIP0NEFTSC788368086");
			else
				System.out.println("Couldnot update msg with sndrref ");


			connection.commit();


		}
		catch(Exception exception){
			connection.rollback();
			System.out.println(" Exception occured ***" + exception + "***");
			exception.printStackTrace();
		}finally {

			try {
				
				if( pStmnt1!=null)
					pStmnt1.close();


				if(connection!=null )
					connection.close();
				
				

			}catch (Exception e) {

				e.printStackTrace();				

			}

		}
	}
}


