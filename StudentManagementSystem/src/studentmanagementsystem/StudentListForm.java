package studentmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentListForm extends JFrame implements ActionListener{
	JLabel lblName,lblSurname,lblStudentnumber,lblDepartment,lblMidterm,lblFinal,lblLettergrade;
	JTextField txtName,txtSurname,txtStudentnumber,txtDepartment,txtMidterm,txtFinal,txtLettergrade;
	JPanel leftPanel,rightPanel,gradePanel;
	
	public StudentListForm() {
		setSize(500,600);
		setTitle("Student List");
		setResizable(false);
		setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        leftPanel=new JPanel();
        leftPanel.setLayout(new GridBagLayout());
        leftPanel.setBackground(Color.blue);

        GridBagConstraints gbc = new GridBagConstraints();
        leftPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3),
                "Student Info "));
        
        leftPanel.setBackground(Color.blue);
        
        gradePanel=new JPanel();
        gradePanel.setLayout(new GridBagLayout());
        gradePanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3),
                "Grade Panel "));

        lblName = new JLabel("Name: ");
        txtName = new JTextField(15);

        gbc.insets = new Insets(10, 5, 5, 10);
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        leftPanel.add(lblName, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        leftPanel.add(txtName, gbc);

        lblSurname = new JLabel("Surname: ");
        txtSurname = new JTextField(15);

        gbc.gridx = 0;
        gbc.gridy = 1;
        leftPanel.add(lblSurname, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        leftPanel.add(txtSurname, gbc);

        lblStudentnumber = new JLabel("Student Number: ");
        txtStudentnumber = new JTextField(15);

        gbc.gridx = 0;
        gbc.gridy = 2;
        leftPanel.add(lblStudentnumber, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1;
        leftPanel.add(txtStudentnumber, gbc);

        lblDepartment = new JLabel("Department: ");
        txtDepartment = new JTextField(15);

        gbc.gridx = 0;
        gbc.gridy = 3;
        leftPanel.add(lblDepartment, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weighty = 1;
        
        leftPanel.add(txtDepartment, gbc);
        
        lblMidterm=new JLabel("Midterm: ");
        txtMidterm=new JTextField(2);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth=2;
        
        
        
        leftPanel.add(gradePanel, gbc);
        gbc.insets = new Insets(10, 0, 5, 15);//(top, left, bottom, right)
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=1;
        gradePanel.add(lblMidterm,gbc);
        
        gbc.gridx=1;
        gbc.gridy=0;
        gradePanel.add(txtMidterm,gbc);
        
        lblFinal=new JLabel("Final: ");
        txtFinal=new JTextField(2);
        gbc.gridx=2;
        gbc.gridy=0;
        gradePanel.add(lblFinal,gbc);
        
        gbc.gridx=3;
        gbc.gridy=0;
        gradePanel.add(txtFinal,gbc);
        
        lblLettergrade=new JLabel("Letter Grade: ");
        txtLettergrade=new JTextField(2);
        
        gbc.gridx=1;
        gbc.gridy=1;
        
        gradePanel.add(lblLettergrade,gbc);
        
        gbc.gridx=2;
        gbc.gridy=1;
        
        gradePanel.add(txtLettergrade,gbc);
        
        
        
        
        
        rightPanel=new JPanel();
        rightPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3),
                "Student List "));
        
       
        
        
        
        
        
        add(leftPanel,BorderLayout.WEST);
        add(rightPanel,BorderLayout.CENTER);
        
        
        setVisible(true);
	}
	
	 @Override
	    public void actionPerformed(ActionEvent e) {
		 
	 }
}
