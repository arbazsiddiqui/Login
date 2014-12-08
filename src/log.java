import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.sql.*;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class log {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					log window = new log();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection connect=null;
	private JTextField un;
	private JPasswordField ps;
	public log() {
		initialize();
		connect=dbconnector.dbConnect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 632, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(171, 85, 71, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(171, 128, 73, 14);
		frame.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					String query="Select * from logindata where username=?  and password=? ";
					PreparedStatement pst=connect.prepareStatement(query);
					pst.setString(1, un.getText());
					pst.setString(2, ps.getText());
					ResultSet rs=pst.executeQuery();
					int count=0;
					while(rs.next())
					{
						count++;
					}
					if(count==0)
					{
						JOptionPane.showMessageDialog(null, "Username or Password incorrect. Try again !");
						
					}
					if(count==1)
					{
						JOptionPane.showMessageDialog(null, "Logged in !");
						
					}
					rs.close();
					pst.close();
				
					
				}
				
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnLogin.setBounds(227, 182, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		un = new JTextField();
		un.setBounds(293, 82, 139, 20);
		frame.getContentPane().add(un);
		un.setColumns(10);
		
		ps = new JPasswordField();
		ps.setBounds(293, 125, 139, 20);
		frame.getContentPane().add(ps);
		
		JLabel lblNotAMember = new JLabel("Not a member?");
		lblNotAMember.setBounds(238, 277, 89, 14);
		frame.getContentPane().add(lblNotAMember);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				signup sign=new signup();
				sign.setVisible(true);
				
			}
		});
		btnSignUp.setBounds(227, 324, 89, 23);
		frame.getContentPane().add(btnSignUp);
	}
}
