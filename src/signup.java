import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

import javax.swing.*;

public class signup extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField un;
	private JPasswordField ps;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
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
	Connection connect=null;
	public signup() {
		connect=dbconnector.dbConnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(191, 123, 71, 14);
		contentPane.add(lblName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(191, 159, 71, 14);
		contentPane.add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(191, 190, 71, 14);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(324, 120, 120, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		un = new JTextField();
		un.setBounds(324, 156, 120, 20);
		contentPane.add(un);
		un.setColumns(10);
		
		ps = new JPasswordField();
		ps.setBounds(324, 187, 120, 20);
		contentPane.add(ps);
		
		JButton btnSignUp = new JButton("Sign Up!");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try 
				{
					String q="insert into logindata (name,username,password) values (?, ?, ?) ";
					PreparedStatement pst=connect.prepareStatement(q);
					pst.setString(1, name.getText());
					pst.setString(2, un.getText());
					pst.setString(3, ps.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Successfully Registered");
					pst.close();
				
					
				}
				
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnSignUp.setBounds(255, 246, 89, 23);
		contentPane.add(btnSignUp);
	}

}
