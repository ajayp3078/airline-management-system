package airline_management_system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BoardingPass extends JFrame implements ActionListener{
	
	JButton flights, fetchButton,bookflight;
	JTextField tfpnr;
	JLabel lbladhaar,lblname,lblsrc,lbldest,lblDEST,lblDATE,lbldate,lblFNAME,lblFCODE,lblnationality,lblgender,lblsource,lbldestination,lblfname,lblfcode,lbladdress,tfname, tfaddress, tfnationality,tfgender, tfsource, tfdestination, tffname, tffcode;
	Choice source,destination;
	JDateChooser dcdate;

	BoardingPass(){
		
		setLayout(null);	
		getContentPane().setBackground(Color.white);
		
		JLabel heading = new JLabel("AIR INDIA");
		heading.setBounds(380,10,450,40);
		heading.setFont(new Font("Tahoma",Font.PLAIN, 32));
		add(heading);
		
		JLabel subheading = new JLabel("Boarding Pass");
		subheading.setBounds(360,50,300,30);
		subheading.setFont(new Font("Tahoma",Font.PLAIN, 24));
		subheading.setForeground(Color.blue);
		add(subheading);
		
		lbladhaar = new JLabel("PNR DETAILS :");
		lbladhaar.setBounds(60,100,150,25);
		lbladhaar.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lbladhaar);
		
		tfpnr = new JTextField();
		tfpnr.setBounds(220,100,150,25);
		add(tfpnr);
		
		fetchButton = new JButton("Enter");
		fetchButton.setBackground(Color.black);
		fetchButton.setForeground(Color.white);
		fetchButton.setBounds(380,100,125,25);
		fetchButton.addActionListener(this);
		add(fetchButton);
		
		lblname = new JLabel("NAME :");
		lblname.setBounds(60,140,150,25);
		lblname.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lblname);
		
		tfname = new JLabel();
		tfname.setBounds(220,140,150,25);
		tfname.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(tfname);
		
		lblnationality = new JLabel("NATIONALITY :");
		lblnationality.setBounds(60,180,150,25);
		lblnationality.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lblnationality);
		
		tfnationality = new JLabel();
		tfnationality.setBounds(220,180,150,25);
		tfnationality.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(tfnationality);
		
		lbladdress = new JLabel("SRC :");
		lbladdress.setBounds(60,220,150,25);
		lbladdress.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lbladdress);

		lblsrc = new JLabel();
		lblsrc.setBounds(220,220,150,25);
		lblsrc.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lblsrc);
		
		lblDEST = new JLabel("DEST :");
		lblDEST.setBounds(300,220,150,25);
		lblDEST.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lblDEST);
		
		lbldest = new JLabel();
		lbldest.setBounds(400,220,100,25);
		lbldest.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lbldest);
		
		lblFNAME = new JLabel("FLIGHT NAME :");
		lblFNAME.setFont(new Font("Tahoma",Font.PLAIN, 16));
		lblFNAME.setBounds(60,260,150,25);
		add(lblFNAME);
		
		lblfname = new JLabel();
		lblfname.setFont(new Font("Tahoma",Font.PLAIN, 16));
		lblfname.setBounds(220,260,150,25);
		add(lblfname);
		
		lblFCODE = new JLabel("FLIGHT CODE :");
		lblFCODE.setFont(new Font("Tahoma",Font.PLAIN, 16));
		lblFCODE.setBounds(60,300,150,25);
		add(lblFCODE);
		
		lblfcode = new JLabel();
		lblfcode.setFont(new Font("Tahoma",Font.PLAIN, 16));
		lblfcode.setBounds(220,300,150,25);
		add(lblfcode);
		
		lblDATE = new JLabel("DATE OF TRAVEL :");
		lblDATE.setFont(new Font("Tahoma",Font.PLAIN, 16));
		lblDATE.setBounds(60,340,150,25);
		add(lblDATE);
		
		lbldate = new JLabel();
		lbldate.setFont(new Font("Tahoma",Font.PLAIN, 16));
		lbldate.setBounds(220,340,150,25);
		add(lbldate);
			
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline_management_system/icons/airindia.png"));
		Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel lblimage = new JLabel(i3);
		lblimage.setBounds(600,0,300,300);
		add(lblimage);
		
		
		setSize(1000,450);
		setLocation(300,150);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(fetchButton==e.getSource()) {
			String pnr = tfpnr.getText();
			try {
				Conn c = new Conn();
				String query = "select * from reservation where pnr = '"+pnr+"'";
				ResultSet rs = c.s.executeQuery(query);
				if(rs.next()) {
					tfname.setText(rs.getString("name"));
					tfnationality.setText(rs.getString("nationality"));
					lblsrc.setText(rs.getString("source"));
					lbldest.setText(rs.getString("destination"));
					lblfname.setText(rs.getString("flightname"));
					lblfcode.setText(rs.getString("flightcode"));
					lbldate.setText(rs.getString("dateOfTravel"));
				}else {
					JOptionPane.showMessageDialog(null,"Not valid PNR");
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		new BoardingPass();
	}
	
}

// queries
//create table reservation(PNR varchar(20),TICKET varchar(20),adhaar varchar(20),name varchar(20),address varchar(50),nationality varchar(20),gender varchar(20),source varchar(20),destination varchar(20),flightname varchar(20),flightcode varchar(20),dateOfTravel varchar(20));
