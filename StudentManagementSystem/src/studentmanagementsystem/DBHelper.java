package studentmanagementsystem;
import java.sql.Connection;
import java.sql.Statement;


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
	    
	    try(Connection conn=DBConnection.connect();Statement stmt=conn.createStatement()){
	    	stmt.execute(users);
	    	stmt.execute(students);
	    	stmt.execute(teachers);
	    	stmt.execute(courses);
	    	stmt.execute(grades);
	    }
	    catch(Exception err) {
	    	err.printStackTrace();
	    }
	    
	    
 }
	public static boolean checkLogin(String email, String password,String role) {
		return false;
	}
	
	
}
