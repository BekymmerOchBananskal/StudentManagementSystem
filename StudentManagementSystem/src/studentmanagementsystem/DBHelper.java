package studentmanagementsystem;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DBHelper {
	
	public static void createTable() {
		
	
		String users="CREATE TABLE IF NOT EXISTS users("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+"email TEXT NOT NULL UNIQUE,"
				+"password TEXT NOT NULL,"
				+"role TEXT NOT NULL"
				+");";
		String students = "CREATE TABLE IF NOT EXISTS students("
	            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
	            + "user_id INTEGER,"
	            + "name TEXT NOT NULL,"
	            + "surname TEXT NOT NULL,"
	            + "student_number TEXT NOT NULL UNIQUE,"
	            + "department TEXT NOT NULL,"
	            + "email TEXT,"
	            + "photo_path TEXT,"
	            + "FOREIGN KEY(user_id) REFERENCES users(id)"
	            + ");";
		String teachers = "CREATE TABLE IF NOT EXISTS teachers("
	            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
	            + "user_id INTEGER,"
	            + "name TEXT NOT NULL,"
	            + "surname TEXT NOT NULL,"
	            + "email TEXT,"
	            + "FOREIGN KEY(user_id) REFERENCES users(id)"
	            + ");";
	
	    String courses = "CREATE TABLE IF NOT EXISTS courses("
	            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
	            + "course_name TEXT NOT NULL"
	            + ");";
	
	    String grades = "CREATE TABLE IF NOT EXISTS grades("
	            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
	            + "student_id INTEGER,"
	            + "course_id INTEGER,"
	            + "midterm INTEGER,"
	            + "final INTEGER,"
	            + "letter_grade TEXT,"
	            + "FOREIGN KEY(student_id) REFERENCES students(id),"
	            + "FOREIGN KEY(course_id) REFERENCES courses(id)"
	            + ");";
	    
	    try(Connection conn=DBConnection.connect();){
	    	
	    	if (conn == null) {
	    	      System.out.println("Database connection failed!");
	    	      return;
	    	 }
	    	Statement stmt=conn.createStatement();
	    	stmt.execute(users);
	    	stmt.execute(students);
	    	stmt.execute(teachers);
	    	stmt.execute(courses);
	    	stmt.execute(grades);
	    	
	    	System.out.println("Tables created successfully.");
	    }
	    catch(Exception err) {
	    	err.printStackTrace();
	    }
	    
	    
 }
	public static boolean checkLogin(String email, String password,String role) {
		String sql="SELECT * FROM users WHERE email=? AND password=? AND role=?";
		
		try(Connection conn=DBConnection.connect();PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setString(1,email);
			pstmt.setString(2, password);
			pstmt.setString(3, role);
			
			ResultSet rs=pstmt.executeQuery();
			
			return rs.next();
		}
		catch(Exception err) {
			err.printStackTrace();
			return false;
		}
	}
	
	
}
