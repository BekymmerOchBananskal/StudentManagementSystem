package studentmanagementsystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DBConnection {
	public static Connection connect() {
		Connection conn=null;
		
		try {
			String url ="jdbc:sqlite:student_management.db";
			conn=DriverManager.getConnection(url);
			
		}
		catch(SQLException err) {
			err.getMessage();
			return null;
		}
		return conn;
	}
}
