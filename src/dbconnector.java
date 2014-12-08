

import java.sql.*;
import javax.swing.*;

public class dbconnector {

	Connection conn=null;
	public static Connection dbConnect()
	{
		try 
		{
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\siddiqui\\workspace\\Login\\second.sqlite");
			return conn;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}
}
