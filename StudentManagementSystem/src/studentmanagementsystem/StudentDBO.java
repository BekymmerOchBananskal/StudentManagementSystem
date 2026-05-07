package studentmanagementsystem;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public static void getAllStudents(DefaultTableModel model) {
		try (Connection conn = DBConnection.connect()) {

            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Database connection failed!");
                return;
            }
            
            String sql="SELECT * FROM students";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
            	Object[] row = {
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("student_number"),
                        rs.getString("department"),
                        rs.getString("email"),
                        rs.getString("photo_path")
                    };
            	 model.addRow(row);
            }
		}
		catch(SQLException  err) {
			JOptionPane.showMessageDialog(null, "Veriler alınamadı: " + err.getMessage());
		}
	}
	public static void fillCoursesCombo(JComboBox<String> comboCourses) {
		try (Connection conn = DBConnection.connect()) {

            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Database connection failed!");
                return;
            }
            
            String sql="SELECT * FROM courses";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
            	comboCourses.addItem(rs.getInt("id") + " - " +
                        rs.getString("course_name"));
            }
		
		}
		catch(SQLException err) {
			JOptionPane.showMessageDialog(null, "Veriler alınamadı: " + err.getMessage());
		}
		
  }
}

