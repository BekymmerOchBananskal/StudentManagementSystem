package studentmanagementsystem;
import java.sql.Connection;
import java.sql.Statement;


public class DBHelper {
	
	public static void createTable() {
		
	
		String users="CREATE TABLE IF NOT EXISTS users("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+"email TEXT NOT NULL,"
				+"password TEXT NOT NULL"
				+");";
		String students = "CREATE TABLE IF NOT EXISTS students("
	            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
	            + "name TEXT NOT NULL,"
	            + "surname TEXT NOT NULL,"
	            + "depermant TEXT NOT NULL,"
	            + "email TEXT"
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
	    	stmt.execute(courses);
	    	stmt.execute(grades);
	    }
	    catch(Exception err) {
	    	err.printStackTrace();
	    }
 }
}
