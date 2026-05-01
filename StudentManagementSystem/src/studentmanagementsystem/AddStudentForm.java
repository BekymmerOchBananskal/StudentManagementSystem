package studentmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentForm extends JFrame implements ActionListener{
	JLabel lblName,lblSurname,lblStudentnumber,lblDepartment,lblEmail,lblPhoto;
	JTextField txtName,txtSurname,txtDepartment,txtStudentnumber,txtEmail;
	JPanel panel,bottomPanel;
	JButton btnSave,btnMainPage;
	
	public AddStudentForm(){
		setTitle("Add Student Panel");
		setSize(400,520);
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel=new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.blue);
		GridBagConstraints gbc= new GridBagConstraints();
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,3),"Add Student "));
		
		lblName=new JLabel("Name: ");
		txtName=new JTextField(18);
		gbc.insets=new Insets(10,0,5,20); //(top, left, bottom, right)
		gbc.anchor=GridBagConstraints.NORTHWEST; 
		gbc.gridx=0;
		gbc.gridy=0;
		panel.add(lblName,gbc);
		
		gbc.gridx=1;
		gbc.gridy=0;
		
		panel.add(txtName,gbc);
		
		lblSurname=new JLabel("Surname: ");
		txtSurname=new JTextField(18);
		
		gbc.gridx=0;
		gbc.gridy=1;
		panel.add(lblSurname,gbc);
		
		gbc.gridx=1;
		gbc.gridy=1;
		panel.add(txtSurname,gbc);
		
		lblStudentnumber=new JLabel("Student Number: ");
		txtStudentnumber=new JTextField(18);
		
		gbc.gridx=0;
		gbc.gridy=2;
		panel.add(lblStudentnumber,gbc);
		
		gbc.gridx=1;
		gbc.gridy=2;
		gbc.weightx=1;
		panel.add(txtStudentnumber,gbc);
		
		
		lblDepartment=new JLabel("Department: ");
		txtDepartment=new JTextField(18);
		
		gbc.gridx=0;
		gbc.gridy=3;
		panel.add(lblDepartment,gbc);
		
		gbc.gridx=1;
		gbc.gridy=3;
		
		panel.add(txtDepartment,gbc);
		
		lblEmail=new JLabel("Email: ");
		txtEmail=new JTextField(18);
		
		gbc.gridx=0;
		gbc.gridy=4;
		panel.add(lblEmail,gbc);
		
		gbc.gridx=1;
		gbc.gridy=4;
		gbc.weighty=1;
		panel.add(txtEmail,gbc);
		
		lblPhoto=new JLabel("Photo: ");
		JLabel photoLabel = new JLabel("Photo");
		photoLabel.setPreferredSize(new Dimension(120, 150));
		photoLabel.setBackground(Color.white);
		photoLabel.setOpaque(true);
		photoLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		photoLabel.setHorizontalAlignment(JLabel.CENTER);
		
		gbc.gridx=0;
		gbc.gridy=5;
		panel.add(lblPhoto,gbc);
		
		gbc.gridx=1;
		gbc.gridy=5;
		
		gbc.gridwidth=2;
		panel.add(photoLabel,gbc);
		
		
		
		
		add(panel,BorderLayout.CENTER);
		
		bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 50, 5));
		bottomPanel.setBackground(Color.blue);

		btnSave = new JButton("Save");
		btnMainPage = new JButton("Back");

		bottomPanel.add(btnSave);
		bottomPanel.add(btnMainPage);

		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.EAST;

		panel.add(bottomPanel, gbc);
		
		
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {}
	
	

}
