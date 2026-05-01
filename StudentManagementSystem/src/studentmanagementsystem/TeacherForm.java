package studentmanagementsystem;
import javax.swing.*;
import java.awt.*;

public class TeacherForm extends JFrame{
	JButton btnAddStudent,btnStudentsList,btnEditStudent,btnDeleteStudent;
	JPanel panel;
	
	
	public TeacherForm() {
		setSize(300,300);
		setTitle("Teacher Panel");
		setResizable(false);
		panel=new JPanel(new GridBagLayout());
		panel.setBackground(Color.BLUE);
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,3),"Teacher Panel"));
		GridBagConstraints gbc= new GridBagConstraints();
		gbc.insets=new Insets(5,5,5,5); //(top, left, bottom, right)elemanların etrafında boşluk bırakır. dış boşluk
		gbc.anchor=GridBagConstraints.CENTER; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		btnAddStudent=new JButton("Add Student");
		btnStudentsList=new JButton("Students List");
		btnEditStudent=new JButton("Edit Student");
		btnDeleteStudent=new JButton("Delete Student");
		Dimension size = new Dimension(120, 30);

		btnAddStudent.setPreferredSize(size);
		btnStudentsList.setPreferredSize(size);
		btnEditStudent.setPreferredSize(size);
		btnDeleteStudent.setPreferredSize(size);
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=2;
		panel.add(btnAddStudent,gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.gridwidth=2;
		panel.add(btnStudentsList,gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridwidth=2;
		panel.add(btnEditStudent,gbc);
		
		
		gbc.gridx=0;
		gbc.gridy=3;
		gbc.gridwidth=2;
		panel.add(btnDeleteStudent,gbc);
		
		add(panel);
		
		setVisible(true);
	}
}
