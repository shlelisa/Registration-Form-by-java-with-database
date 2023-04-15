package javaRegistrationForm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.*;// we import all sql query

import java.awt.event.ActionEvent;

public class RegistrationForm extends JFrame {

	private JPanel contentPane;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField age;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationForm frame = new RegistrationForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrationForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 485);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 255, 0));
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Simple Registration Form");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setBounds(350, 35, 278, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setForeground(new Color(0, 255, 0));
		lblNewLabel_1.setBounds(135, 143, 180, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lastName = new JLabel("Last Name");
		lastName.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lastName.setForeground(new Color(0, 255, 0));
		lastName.setBounds(135, 200, 180, 14);
		contentPane.add(lastName);
		
		JLabel sa = new JLabel("Age");
		sa.setFont(new Font("Times New Roman", Font.BOLD, 25));
		sa.setForeground(new Color(0, 255, 0));
		sa.setBounds(135, 248, 180, 30);
		contentPane.add(sa);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/javaregistrationform","root","");
					String query="INSERT INTO registrationform(fristname,lastname,age) values(?,?,?)";
					PreparedStatement ps= conn.prepareStatement(query);
					
					
					
					ps.setString(1, firstname.getText());
					ps.setString(2, lastname.getText());
					ps.setInt(3, Integer.parseInt(age.getText()));//because of we use setInt the age is integer
					

					int result=ps.executeUpdate();
					JOptionPane.showMessageDialog(btnNewButton, result+ " rows inserted");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.setForeground(new Color(0, 255, 0));
		btnNewButton.setBounds(288, 334, 133, 23);
		contentPane.add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				firstname.setText("");
				lastname.setText("");
				age.setText("");
				
				
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnClear.setForeground(new Color(0, 255, 0));
		btnClear.setBounds(464, 334, 133, 23);
		contentPane.add(btnClear);
		
		firstname = new JTextField();
		firstname.setBounds(363, 137, 126, 20);
		contentPane.add(firstname);
		firstname.setColumns(10);
		
		lastname = new JTextField();
		lastname.setBounds(363, 194, 126, 20);
		contentPane.add(lastname);
		lastname.setColumns(10);
		
		age = new JTextField();
		age.setBounds(363, 242, 126, 20);
		contentPane.add(age);
		age.setColumns(10);
	}
}
