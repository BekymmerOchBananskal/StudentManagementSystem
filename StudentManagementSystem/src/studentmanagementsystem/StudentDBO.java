package studentmanagementsystem;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDBO {
	
	public static void insertStudent(String name,String surname,String studentNumber,String department,String email,String fPath) {
		try (Connection conn = DBConnection.connect()) {

            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Database connection failed!");
                return;
            }

            String userSql = "INSERT INTO users(email, password, role) VALUES (?, ?, ?)";

            PreparedStatement userStmt = conn.prepareStatement(
                    userSql,
                    Statement.RETURN_GENERATED_KEYS
            );

            userStmt.setString(1, email);
            userStmt.setString(2, studentNumber);
            userStmt.setString(3, "student");

            userStmt.executeUpdate();

            ResultSet generatedKeys = userStmt.getGeneratedKeys();

            int studentUserId = -1;

            if (generatedKeys.next()) {
                studentUserId = generatedKeys.getInt(1);
            }

            if (studentUserId == -1) {
                JOptionPane.showMessageDialog(null, "Student user id alınamadı!");
                return;
            }

            String studentSql = "INSERT INTO students(user_id, name, surname, student_number, department, email, photo_path) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement studentStmt = conn.prepareStatement(studentSql);

            studentStmt.setInt(1, studentUserId);
            studentStmt.setString(2, name);
            studentStmt.setString(3, surname);
            studentStmt.setString(4, studentNumber);
            studentStmt.setString(5, department);
            studentStmt.setString(6, email);

            if (fPath != null) {
                studentStmt.setString(7, fPath);
            } else {
                studentStmt.setNull(7, java.sql.Types.VARCHAR);
            }

            studentStmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Student added successfully!");

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Student could not be added!");
        }
    }
		
}

