package studentmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddStudentForm extends JFrame implements ActionListener {

    JLabel lblName, lblSurname, lblStudentnumber, lblDepartment, lblEmail, lblPhoto, photoLabel;
    JTextField txtName, txtSurname, txtDepartment, txtStudentnumber, txtEmail;
    JPanel panel, bottomPanel;
    JButton btnSave, btnMainPage, btnAddPic;

    String fPath = null;
    File file;

    public AddStudentForm() {

        setTitle("Add Student Panel");
        setSize(400, 520);
        setResizable(false);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.blue);

        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3),
                "Add Student "
        ));

        lblName = new JLabel("Name: ");
        txtName = new JTextField(18);

        gbc.insets = new Insets(10, 5, 5, 10);
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblName, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(txtName, gbc);

        lblSurname = new JLabel("Surname: ");
        txtSurname = new JTextField(18);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblSurname, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(txtSurname, gbc);

        lblStudentnumber = new JLabel("Student Number: ");
        txtStudentnumber = new JTextField(18);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lblStudentnumber, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1;
        panel.add(txtStudentnumber, gbc);

        lblDepartment = new JLabel("Department: ");
        txtDepartment = new JTextField(18);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(lblDepartment, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(txtDepartment, gbc);

        lblEmail = new JLabel("Email: ");
        txtEmail = new JTextField(18);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(lblEmail, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weighty = 1;
        panel.add(txtEmail, gbc);

        lblPhoto = new JLabel("Photo: ");
        photoLabel = new JLabel("Photo");
        photoLabel.setPreferredSize(new Dimension(120, 150));
        photoLabel.setBackground(Color.white);
        photoLabel.setOpaque(true);
        photoLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        photoLabel.setHorizontalAlignment(JLabel.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(lblPhoto, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panel.add(photoLabel, gbc);

        add(panel, BorderLayout.CENTER);

        bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 5));
        bottomPanel.setBackground(Color.blue);

        btnSave = new JButton("Save");
        btnSave.addActionListener(this);

        btnMainPage = new JButton("Back");
        btnMainPage.addActionListener(this);

        btnAddPic = new JButton("Add Picture");
        btnAddPic.addActionListener(this);

        bottomPanel.add(btnSave);
        bottomPanel.add(btnAddPic);
        bottomPanel.add(btnMainPage);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.EAST;

        panel.add(bottomPanel, gbc);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnMainPage) {
            new TeacherForm();
            dispose();
        }

        else if (e.getSource() == btnAddPic) {
            JFileChooser jfc = new JFileChooser();

            if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                file = jfc.getSelectedFile();

                ImageIcon icon = new ImageIcon(file.getAbsolutePath());
                Image img = icon.getImage().getScaledInstance(
                        photoLabel.getWidth(),
                        photoLabel.getHeight(),
                        Image.SCALE_SMOOTH
                );

                fPath = file.getAbsolutePath();
                photoLabel.setIcon(new ImageIcon(img));
            }
        }

        else if (e.getSource() == btnSave) {
            String name = txtName.getText();
            String surname = txtSurname.getText();
            String studentNumber = txtStudentnumber.getText();
            String department = txtDepartment.getText();
            String email = txtEmail.getText();

            if (fPath == null) {
                JOptionPane.showMessageDialog(this, "Fotoğraf seçilmedi! Fotoğraf olmadan kayıt yapılacak.");
            }

            try (Connection conn = DBConnection.connect()) {

                if (conn == null) {
                    JOptionPane.showMessageDialog(this, "Database connection failed!");
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
                    JOptionPane.showMessageDialog(this, "Student user id alınamadı!");
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

                JOptionPane.showMessageDialog(this, "Student added successfully!");

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Student could not be added!");
            }
        }
    }
}