package studentmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentForm extends JFrame implements ActionListener {
	JLabel lblName,lblSurname,lblStudentnumber,lblDepartment,lblEmail;
	JTextField txtName,txtSurname,txtDepartment,txtStudentnumber,txtEmail;
	JTable tblGrader;
	JPanel leftPanel,rightPanel;
	
	public StudentForm() {
		setTitle("Student Panel");
		setSize(600,420);
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		leftPanel=new JPanel();
		leftPanel.setLayout(new GridBagLayout());
		leftPanel.setBackground(Color.blue);
		GridBagConstraints gbc= new GridBagConstraints();
		leftPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,3),"Student Information"));
		
		
		rightPanel=new JPanel();
		rightPanel.setLayout(new BorderLayout());
		rightPanel.setBackground(Color.blue);
		rightPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,3),"Grader List"));
		String[] columnNames = {"Course", "Midterm", "Final","Letter Grade"};

		Object[][] data = {
		    {"Math", 80, 90,"AA"},
		    {"Physics", 70, 85,"BA"}
		};

		tblGrader = new JTable(data, columnNames);
		//tblGrader.setBackground(Color.BLUE);
		//tblGrader.setForeground(Color.WHITE);
		tblGrader.setSelectionBackground(Color.YELLOW);
		tblGrader.setGridColor(Color.BLACK);

		JScrollPane scrollPane = new JScrollPane(tblGrader);
		scrollPane.getViewport().setBackground(Color.BLUE);
		

		
		rightPanel.add(scrollPane, BorderLayout.CENTER);
		
		
		
		
		lblName=new JLabel("Name: ");
		txtName=new JTextField(12);
		gbc.insets=new Insets(10,5,5,10); //(top, left, bottom, right)
		gbc.anchor=GridBagConstraints.NORTHWEST; 
		gbc.gridx=0;
		gbc.gridy=0;
		leftPanel.add(lblName,gbc);
		
		gbc.gridx=1;
		gbc.gridy=0;
		leftPanel.add(txtName,gbc);
		
		lblSurname=new JLabel("Surname: ");
		txtSurname=new JTextField(12);
		
		gbc.gridx=0;
		gbc.gridy=1;
		leftPanel.add(lblSurname,gbc);
		
		gbc.gridx=1;
		gbc.gridy=1;
		leftPanel.add(txtSurname,gbc);
		
		lblStudentnumber=new JLabel("Student Number: ");
		txtStudentnumber=new JTextField(12);
		
		gbc.gridx=0;
		gbc.gridy=2;
		leftPanel.add(lblStudentnumber,gbc);
		
		gbc.gridx=1;
		gbc.gridy=2;
		leftPanel.add(txtStudentnumber,gbc);
		
		
		lblDepartment=new JLabel("Department: ");
		txtDepartment=new JTextField(12);
		
		gbc.gridx=0;
		gbc.gridy=3;
		leftPanel.add(lblDepartment,gbc);
		
		gbc.gridx=1;
		gbc.gridy=3;
		
		leftPanel.add(txtDepartment,gbc);
		
		lblEmail=new JLabel("Email: ");
		txtEmail=new JTextField(12);
		
		gbc.gridx=0;
		gbc.gridy=4;
		leftPanel.add(lblEmail,gbc);
		
		gbc.gridx=1;
		gbc.gridy=4;
		gbc.weighty=1;
		leftPanel.add(txtEmail,gbc);
		
		JLabel photoLabel = new JLabel("Photo");
		photoLabel.setPreferredSize(new Dimension(120, 150));
		photoLabel.setBackground(Color.white);
		photoLabel.setOpaque(true);
		photoLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		photoLabel.setHorizontalAlignment(JLabel.CENTER);

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.insets=new Insets(0,5,5,10);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		gbc.weighty = 2;

		leftPanel.add(photoLabel, gbc);
		
		
		
		
		add(leftPanel,BorderLayout.WEST);
		add(rightPanel,BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
}
