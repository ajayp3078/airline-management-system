package airline_management_system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener{
	
	JButton flights, fetchButton,bookflight;
	JTextField tfadhaar;
	JLabel lbladhaar,lblname,lblnationality,lblgender,lblsource,lbldestination,lblfname,lblfcode,lbldate,lbladdress,tfname, tfaddress, tfnationality,tfgender, tfsource, tfdestination, tffname, tffcode;
	Choice source,destination;
	JDateChooser dcdate;

	BookFlight(){
		
		setLayout(null);	
		getContentPane().setBackground(Color.white);
		
		JLabel heading = new JLabel("Book Flight");
		heading.setBounds(300,20,500,40);
		heading.setFont(new Font("Tahoma",Font.PLAIN, 32));
		heading.setForeground(Color.blue);
		add(heading);
		
		lbladhaar = new JLabel("Adhaar");
		lbladhaar.setBounds(60,80,150,25);
		lbladhaar.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lbladhaar);
		
		tfadhaar = new JTextField();
		tfadhaar.setBounds(220,80,150,25);
		add(tfadhaar);
		
		fetchButton = new JButton("Fetch");
		fetchButton.setBackground(Color.black);
		fetchButton.setForeground(Color.white);
		fetchButton.setBounds(380,80,125,25);
		fetchButton.addActionListener(this);
		add(fetchButton);
		
		lblname = new JLabel("Name");
		lblname.setBounds(60,130,150,25);
		lblname.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lblname);
		
		tfname = new JLabel();
		tfname.setBounds(220,130,150,25);
		add(tfname);
		
		
		lblnationality = new JLabel("Nationality");
		lblnationality.setBounds(60,180,150,25);
		lblnationality.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lblnationality);
		
		tfnationality = new JLabel();
		tfnationality.setBounds(220,180,150,25);
		add(tfnationality);
		
		lbladdress = new JLabel("Address");
		lbladdress.setBounds(60,230,150,25);
		lbladdress.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lbladdress);

		tfaddress = new JLabel();
		tfaddress.setBounds(220,230,150,25);
		add(tfaddress);
		
		lblfname = new JLabel("Flight Name");
		lblfname.setBounds(60,430,150,25);
		lblfname.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lblfname);
		
		tffname = new JLabel();
		tffname.setBounds(220,430,150,25);
		add(tffname);
		
		lblgender = new JLabel("Gender");
		lblgender.setBounds(60,280,150,25);
		lblgender.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lblgender);
		
		tfgender = new JLabel();
		tfgender.setBounds(220,280,150,25);
		add(tfgender);
		
		lblfcode = new JLabel("Flight Code");
		lblfcode.setBounds(60,480,150,25);
		lblfcode.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lblfcode);
		
		tffcode = new JLabel();
		tffcode.setBounds(220,480,150,25);
		add(tffcode);
		
//		labelfcode = new JLabel();
//		labelfcode.setBounds(220,530,150,25);
//		labelfcode.setFont(new Font("Tahoma",Font.PLAIN, 16));
//		add(labelfcode);
		
		lbldate = new JLabel("Date of Travel");
		lbldate.setBounds(60,530,150,25);
		lbldate.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lbldate);
		
		dcdate = new JDateChooser();
		dcdate.setBounds(220,530,150,25);
		add(dcdate);
		
		lblsource = new JLabel("Source");
		lblsource.setBounds(60,330,150,25);
		lblsource.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lblsource);
		
		source = new Choice();
		source.setBounds(220,330,150,25);
		add(source);
		
		lbldestination = new JLabel("Destination");
		lbldestination.setBounds(60,380,150,25);
		lbldestination.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lbldestination);
		
		destination = new Choice();
		destination.setBounds(220,380,150,25);
		add(destination);
		
		bookflight = new JButton("Book Flight");
		bookflight.setBackground(Color.black);
		bookflight.setForeground(Color.white);
		bookflight.setBounds(220,580,150,25);
		bookflight.addActionListener(this);
		add(bookflight);
		
		try {
			Conn c = new Conn();
			String query = "select * from flight";
			ResultSet rs = c.s.executeQuery(query);
			
			while(rs.next()) {
				source.add(rs.getString("source"));
				destination.add(rs.getString("destination"));	// added dest column from table to dest choice
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		flights = new JButton("Fetch Flights");
		flights.setBounds(380,380,120,25);
		flights.setBackground(Color.black);
		flights.setForeground(Color.white);
		flights.addActionListener(this);
		add(flights);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline_management_system/icons/details.jpg"));
		Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel lblimage = new JLabel(i3);
		lblimage.setBounds(550,80,500,410);
		add(lblimage);
		
		
		setSize(1100,700);
		setLocation(200,50);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(fetchButton==e.getSource()) {
			String adhaar = tfadhaar.getText();
			try {
				Conn c = new Conn();
				String query = "select * from passenger where adhaar = '"+adhaar+"'";
				ResultSet rs = c.s.executeQuery(query);
				if(rs.next()) {
					tfname.setText(rs.getString("name"));
					tfnationality.setText(rs.getString("nationality"));
					tfaddress.setText(rs.getString("address"));
					tfgender.setText(rs.getString("gender"));
				}else {
					JOptionPane.showMessageDialog(null,"Please enter correct adhaar");
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		} else if(flights==e.getSource()) {
			String src = source.getSelectedItem();
			String dest = destination.getSelectedItem();
			try {
				Conn c = new Conn();
				String query = "select * from flight where source = '"+src+"' and destination = '"+dest+"'";
				ResultSet rs = c.s.executeQuery(query);
				if(rs.next()) {
					tffname.setText(rs.getString("f_name"));
					tffcode.setText(rs.getString("f_code"));
				}else {
					JOptionPane.showMessageDialog(null,"No flights");
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}else if (e.getSource()==bookflight){
			Random random = new Random();
			int ran = random.nextInt(1000000);
			
			
			String adhaar = tfadhaar.getText();
			String name = tfname.getText();
			String address = tfaddress.getText();
			String nationality = tfnationality.getText();
			String gender = tfgender.getText();
			String src = source.getSelectedItem();
			String dest = destination.getSelectedItem();
			String fname = tffname.getText();
			String fcode = tffcode.getText();
			String dateOfTravel = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
			
			try {
				Conn c = new Conn();
				String query = "insert into reservation values ('PNR-"+random.nextInt(1000000)+"','TIC-"+random.nextInt(10000)+"','"+adhaar+"','"+name+"', '"+address+"', '"+nationality+"', '"+gender+"','"+src+"','"+dest+"','"+fname+"','"+fcode+"', '"+dateOfTravel+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");
				setVisible(false);

			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		new BookFlight();
	}
	
}

// queries
//create table reservation(PNR varchar(20),TICKET varchar(20),adhaar varchar(20),name varchar(20),address varchar(50),nationality varchar(20),gender varchar(20),source varchar(20),destination varchar(20),flightname varchar(20),flightcode varchar(20),dateOfTravel varchar(20));
