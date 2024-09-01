package airline_management_system;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener{
	
	JButton save;
	JTextField tfnationality,tfadhaar,tfaddress,tfphone,tfname;
	JRadioButton rbmale, rbfemale;

	AddCustomer(){
		
		setLayout(null);	
		getContentPane().setBackground(Color.white);
		
		JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
		heading.setBounds(230,20,500,35);
		heading.setFont(new Font("Tahoma",Font.PLAIN, 32));
		heading.setForeground(Color.blue);
		add(heading);
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(60,80,150,25);
		lblname.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(220,80,150,25);
		add(tfname);
		
		JLabel lblnationality = new JLabel("Nationality");
		lblnationality.setBounds(60,130,150,25);
		lblnationality.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lblnationality);
		
		tfnationality = new JTextField();
		tfnationality.setBounds(220,130,150,25);
		add(tfnationality);
		
		JLabel lbladhaar = new JLabel("Adhaar");
		lbladhaar.setBounds(60,180,150,25);
		lbladhaar.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lbladhaar);
		
		tfadhaar = new JTextField();
		tfadhaar.setBounds(220,180,150,25);
		add(tfadhaar);
		
		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(60,230,150,25);
		lbladdress.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lbladdress);
		
		tfaddress = new JTextField();
		tfaddress.setBounds(220,230,150,25);
		add(tfaddress);
		
		JLabel lblgender = new JLabel("Gender");
		lblgender.setBounds(60,280,150,25);
		lblgender.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lblgender);
		
		rbmale = new JRadioButton("Male");
		rbmale.setBackground(Color.white);
		rbmale.setBounds(220,280,60,30);
		add(rbmale);
		
		rbfemale = new JRadioButton("Female");
		rbfemale.setBackground(Color.white);
		rbfemale.setBounds(300,280,100,30);
		add(rbfemale);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(rbmale);
		gendergroup.add(rbfemale);
		
		JLabel lblphone = new JLabel("Phone");
		lblphone.setBounds(60,330,150,25);
		lblphone.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lblphone);
		
		tfphone = new JTextField();
		tfphone.setBounds(220,330,150,25);
		add(tfphone);
		
		save = new JButton("Save");
		save.setBounds(220,380,150,30);
		save.setBackground(Color.black);
		save.setForeground(Color.white);
		save.addActionListener(this);
		add(save);
		
		ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airline_management_system/icons/emp.png"));
		JLabel lblimage = new JLabel(image);
		lblimage.setBounds(450,80,280,400);
		add(lblimage);
		
		
		setSize(900,600);
		setLocation(300,150);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = tfname.getText();
		String nationality = tfnationality.getText();
		String adhaar = tfadhaar.getText();
		String address = tfaddress.getText();
		String phone = tfphone.getText();
		String gender = null;
		
		if(name.equals("") || name.equals("") || adhaar.equals("") || address.equals("") || phone.equals("") && e.getSource()==save) {
			JOptionPane.showMessageDialog(null, "Please fill all fields");
			return;
		}
		
		if(rbmale.isSelected()) {
			gender="Male";
		}else if(rbfemale.isSelected()){
			gender="Female";
		}
		
		try {
			if(e.getSource()==save) {
				Conn c = new Conn();
				String query = "insert into passenger values('"+name+"','"+nationality+"','"+adhaar+"','"+address+"','"+phone+"','"+gender+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Details saved successfully");
				setVisible(false);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new AddCustomer();
	}
	
}
