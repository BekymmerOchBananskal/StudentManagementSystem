package studentmanagementsystem;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentListForm extends JFrame implements ActionListener{
	JLabel lblName,lblSurname,lblStudentnumber,lblDepartment,lblMidterm,lblFinal,lblLettergrade;
	JTextField txtName,txtSurname,txtStudentnumber,txtDepartment,txtMidterm,txtFinal,txtLettergrade;
	JPanel leftPanel,rightPanel,gradePanel,bottomPanel;
	DefaultTableModel model;
	JTable table;
	JButton update,delete;
	
	
	public StudentListForm() {
		setSize(850,600);
		setTitle("Student List");
		setResizable(false);
		setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        model = new DefaultTableModel();
        table = new JTable(model);
        
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Surname");
        model.addColumn("Student Number");
        model.addColumn("Department");
        model.addColumn("Email");
        model.addColumn("PhotoPath");
        
        table.getColumnModel().getColumn(0).setPreferredWidth(20);   // ID
        table.getColumnModel().getColumn(1).setPreferredWidth(60);
        table.getColumnModel().getColumn(2).setPreferredWidth(60);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(150);
        table.getColumnModel().getColumn(5).setPreferredWidth(150);
        table.getColumnModel().getColumn(6).setMinWidth(0);
        table.getColumnModel().getColumn(6).setMaxWidth(0);
        table.getColumnModel().getColumn(6).setWidth(0);
        
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
		
        
        lblMidterm=new JLabel("Midterm: ");
        txtMidterm=new JTextField(4);
        gbc.gridx = 0;
        gbc.gridy = 6;
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
        txtFinal=new JTextField(4);
        gbc.gridx=2;
        gbc.gridy=0;
        gradePanel.add(lblFinal,gbc);
        
        gbc.gridx=3;
        gbc.gridy=0;
        gradePanel.add(txtFinal,gbc);
        
        lblLettergrade=new JLabel("Letter Grade: ");
        txtLettergrade=new JTextField(4);
        
        gbc.gridx=1;
        gbc.gridy=1;
        
        gradePanel.add(lblLettergrade,gbc);
        
        gbc.gridx=2;
        gbc.gridy=1;
        
        gradePanel.add(txtLettergrade,gbc);
        
        JComboBox<String> comboCourses = new JComboBox<>();
        comboCourses.setPreferredSize(new Dimension(180, 30));
        
        gbc.gridx=1;
        gbc.gridy=2;
        gbc.gridwidth=2;
        gradePanel.add(comboCourses,gbc);
        
        
        bottomPanel=new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 5));
        bottomPanel.setBackground(Color.blue);
        update=new JButton("Update");
        delete=new JButton("Delete");
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.gridx=0;
        gbc.gridy=7;
        leftPanel.add(bottomPanel,gbc);
        
        bottomPanel.add(update);
        bottomPanel.add(delete);
        
        
        
        
        
        
        rightPanel=new JPanel(new BorderLayout());
        rightPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3),
                "Student List "));
        
       rightPanel.add(new JScrollPane(table));
        
        
        
        
        
        add(leftPanel,BorderLayout.WEST);
        add(rightPanel,BorderLayout.CENTER);
        
        StudentDBO.getAllStudents(model);
        StudentDBO.fillCoursesCombo(comboCourses);
        
        comboCourses.addActionListener(e -> {
        String selected = comboCourses.getSelectedItem().toString();
        

        String id =
                selected.split(" - ")[0];

        System.out.println(id);
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int selectedRow = table.getSelectedRow();

                if (selectedRow != -1) {
                    txtName.setText(model.getValueAt(selectedRow, 1).toString());
                    txtSurname.setText(model.getValueAt(selectedRow, 2).toString());
                    txtStudentnumber.setText(model.getValueAt(selectedRow, 3).toString());
                    txtDepartment.setText(model.getValueAt(selectedRow, 4).toString());
                    String photoPath =
                            model.getValueAt(selectedRow, 6).toString();

                    ImageIcon imageIcon =
                            new ImageIcon(photoPath);
                    Image img = imageIcon.getImage().getScaledInstance(
                            photoLabel.getWidth(),
                            photoLabel.getHeight(),
                            Image.SCALE_SMOOTH
                    );
                    photoLabel.setIcon(new ImageIcon(img));


                }
            }
        });
        
        setVisible(true);
        
	}
	
	 @Override
	    public void actionPerformed(ActionEvent e) {
		 
	 }
}
