package airlinemanagementsystem;

import java.sql.*;
public class Conn {
	
	Connection c;
	Statement stmt;
	ResultSet rs;
	public Conn() {
		
		try 
		{
			String driver="oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
					
		   String url="jdbc:oracle:thin:@localhost:1521:xe";
		   String userid_db="system";
		   String password_db="nittika";
				    
		   c=DriverManager.getConnection(url,userid_db,password_db);
				
		   stmt=c.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		//return c;
	}

}
