package airline_management_system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	
	JButton submit,close,reset;
	JTextField tfusername, tfpassword;
	
	
	public Login(){
		
		setTitle("Login");
		
		setLayout(null);
		
		getContentPane().setBackground(Color.white);		// for whole frame
		
		JLabel lblusername = new JLabel("Username:");
		lblusername.setBounds(20,20,100,20);
		add(lblusername);
		
		JLabel lblpassword = new JLabel("Password:");
		lblpassword.setBounds(20,60,100,20);
		add(lblpassword);
		
		tfusername = new JTextField();
		tfusername.setBounds(130,20,200,20);
		add(tfusername);
		
		tfpassword = new JPasswordField();
		tfpassword.setBounds(130,60,200,20);
		add(tfpassword);
		
		reset = new JButton("Reset");
		reset.setBounds(40,120,120,20);
		reset.addActionListener(this);
		add(reset);
		
		submit = new JButton("Submit");
		submit.setBounds(190,120,120,20);
		submit.addActionListener(this);
		add(submit);
		
		close = new JButton("Close");
		close.setBounds(120,160,120,20);
		close.addActionListener(this);
		add(close);
		
		
		setSize(400,250);
		setLocation(600,250);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit) {
			String username = tfusername.getText();
			String password = tfpassword.getText();
			
			try {
				Conn c = new Conn();
				String query = "select * from login where username='"+username+"' and password='"+password+"'";
				ResultSet rs = c.s.executeQuery(query);
				if(rs.next()) {
					new Home().setVisible(true);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid username and password");
					setVisible(false);
				}
			}catch(Exception ex) {
				System.out.println(ex);
			}
			
		}else if(e.getSource()==close) {
			setVisible(false);
		}else if(e.getSource()==reset) {
			tfusername.setText("");
			tfpassword.setText("");
		}
	}

	public static void main(String[] args) {
		new Login();
	}

}






