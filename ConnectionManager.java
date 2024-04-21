package project;
import java.sql.*;

public class connection 
{
	public static Connection getCon()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bms","root","Saibunty@1");
			return con;
		}
		
		catch(Exception e) 
		{
			e.printStackTrace(); 
			return null;
		}
	}
}
