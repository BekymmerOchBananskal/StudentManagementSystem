package studentmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {
	
	JTextField emailField;
	JPasswordField passwordField;
	JLabel lblEmail,lblPassword;
	JButton btnLogin;
	JRadioButton stuRadio,tecRadio;
	
	public LoginForm() {
		setTitle("Login");
		setSize(300,200);
		setResizable(false);
		getContentPane().setBackground(Color.BLUE);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc= new GridBagConstraints(); //her elemanın nereye gideceğini söyleyen ayar nesnesi
		gbc.insets=new Insets(5,5,5,5); //(top, left, bottom, right)elemanların etrafında boşluk bırakır. dış boşluk
		gbc.anchor=GridBagConstraints.NORTHWEST; // elemanı hücre içinde sola yaslar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.weighty=0.1;
		gbc.weightx=0;
		add(new JLabel(),gbc);
		
		lblEmail=new JLabel("Email: ");
		emailField=new JTextField(15);
		
		lblPassword=new JLabel("Password: ");
		passwordField=new JPasswordField (15);
		
		tecRadio=new JRadioButton("Teacher");
		tecRadio.setBackground(Color.blue);

	    stuRadio=new JRadioButton("Student");
		stuRadio.setBackground(Color.blue);
		
		ButtonGroup group = new ButtonGroup();
		group.add(stuRadio);
		group.add(tecRadio);

		
		
		btnLogin=new JButton("Login");
		btnLogin.addActionListener(this);
		
		
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.weighty=0;
		gbc.weightx=0;
		add(lblEmail,gbc);
		
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.weightx=0;
		add(emailField,gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.weightx=0;
		add(lblPassword,gbc);
		
		gbc.gridx=1;
		gbc.gridy=2;
		gbc.weightx=0;
		add(passwordField,gbc);
		
		gbc.gridx=1;
		gbc.gridy=3;
		gbc.insets=new Insets(5,0,5,5);
		gbc.anchor=gbc.anchor=GridBagConstraints.WEST;
		add(tecRadio,gbc);
		
		gbc.gridx=1;
		gbc.gridy=3;
		gbc.anchor = GridBagConstraints.EAST;
		add(stuRadio,gbc);
				
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weightx = 0;
		gbc.weighty = 0.5;
		gbc.anchor = GridBagConstraints.EAST;

		add(btnLogin, gbc);

		
		
		
		
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnLogin) {
			
			String email=emailField.getText();
			String password=new String(passwordField.getPassword());
			String role="";
			
			if(stuRadio.isSelected()) {
				role="student";
			}
			else if(tecRadio.isSelected()) {
				role="teacher";
			}
			else {
			    JOptionPane.showMessageDialog(this, "Please select a role");
			    return;
			}
			boolean result=DBHelper.checkLogin(email, password,role);
			
			if(result&&role.equals("student")) {
	            JOptionPane.showMessageDialog(this, "Login successful");
	            StudentForm s=new StudentForm();
	            dispose();
	            
	        } else if(result&&role.equals("teacher")){
	            JOptionPane.showMessageDialog(this, "Login successful");
	            TeacherForm t=new TeacherForm();
	            dispose();
	            
	        }
	        else {
	        	JOptionPane.showMessageDialog(this, "Login failed");
			
			}
		}
	}
}

