package studentmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherForm extends JFrame implements ActionListener{
	JButton btnAddStudent,btnStudentsList;
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
		btnAddStudent.addActionListener(this);
		btnStudentsList=new JButton("Students List");
		btnStudentsList.addActionListener(this);
		
		Dimension size = new Dimension(120, 30);

		btnAddStudent.setPreferredSize(size);
		btnStudentsList.setPreferredSize(size);
		
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=2;
		panel.add(btnAddStudent,gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.gridwidth=2;
		panel.add(btnStudentsList,gbc);
		
		
		
		add(panel);
		
		
		
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAddStudent) {
			new AddStudentForm();
			dispose();
		}
		if(e.getSource()==btnStudentsList) {
			new StudentListForm();
			dispose();
		}
		
	}
}
