package studentmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {
	
	JTextField emailField,passwordField;
	JLabel lblEmail,lblPassword;
	JButton btnLogin;
	
	public LoginForm() {
		setTitle("Login");
		setSize(300,200);
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
		emailField=new JTextField(12);
		
		lblPassword=new JLabel("Password: ");
		passwordField=new JTextField(12);
		
		
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
				
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.weightx = 0;
		gbc.weighty = 0.5;
		gbc.anchor = GridBagConstraints.EAST;

		add(btnLogin, gbc);

		
		
		
		
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}

