package airline_management_system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class CancelTicket extends JFrame implements ActionListener{
	
	JButton flights, fetchButton,bookflight;
	JTextField tfadhaar;
	JLabel lbladhaar,lblname,lblnationality,lblgender,lblsource,lbldestination,lblfname,lblfcode,lbldate,lbladdress,tfname, tfaddress, tfnationality,tfgender, tfsource, tfdestination, tffname, tffcode;
	JDateChooser dcdate;

	CancelTicket(){
		
		setLayout(null);	
		getContentPane().setBackground(Color.white);
		
		JLabel heading = new JLabel("CANCELLATION");
		heading.setBounds(400,20,500,40);
		heading.setFont(new Font("Tahoma",Font.PLAIN, 32));
		heading.setForeground(Color.blue);
		add(heading);
		
		lbladhaar = new JLabel("PNR Number");
		lbladhaar.setBounds(60,80,150,25);
		lbladhaar.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lbladhaar);
		
		tfadhaar = new JTextField();
		tfadhaar.setBounds(220,80,150,25);
		add(tfadhaar);
		
		fetchButton = new JButton("Show Details");
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
		
		
		lblnationality = new JLabel("Cancellation No");
		lblnationality.setBounds(60,180,150,25);
		lblnationality.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lblnationality);
		
		tfnationality = new JLabel();
		tfnationality.setBounds(220,180,150,25);
		add(tfnationality);
		
		lbladdress = new JLabel("Flight Code");
		lbladdress.setBounds(60,230,150,25);
		lbladdress.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lbladdress);

		tfaddress = new JLabel();
		tfaddress.setBounds(220,230,150,25);
		add(tfaddress);
		
		lblfname = new JLabel("Date");
		lblfname.setBounds(60,280,150,25);
		lblfname.setFont(new Font("Tahoma",Font.PLAIN, 16));
		add(lblfname);
		
		tffname = new JLabel();
		tffname.setBounds(220,280,150,25);
		add(tffname);
	
		flights = new JButton("Cancel");
		flights.setBounds(220,330,120,25);
		flights.setBackground(Color.black);
		flights.setForeground(Color.white);
		flights.addActionListener(this);
		add(flights);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline_management_system/icons/cancel.jpg"));
		Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel lblimage = new JLabel(i3);
		lblimage.setBounds(400,0,700,700);
		add(lblimage);
		
		
		setSize(1100,700);
		setLocation(200,50);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String pnr = tfadhaar.getText();
		String name = tfname.getText();
		String fcode = tfaddress.getText();
		String date = tffname.getText();
		Random random = new Random();
		String ranCancellationNum = Integer.toString(random.nextInt(1000000));
		
		if(e.getSource()==fetchButton) {
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery("select * from reservation where PNR = '"+pnr+"'");
				if(rs.next()) {
					tfname.setText(rs.getString("name"));
					tfnationality.setText(ranCancellationNum);
					tfaddress.setText(rs.getString("flightcode"));
					tffname.setText(rs.getString("dateOfTravel"));
				}else {
					JOptionPane.showMessageDialog(null, "No PNR found");
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}else if(e.getSource()==flights) {
			try {
				if(pnr.equals("")) {
					JOptionPane.showMessageDialog(null,"Please enter PNR");
					return;
				}
				Conn c= new Conn();
				String cancelQry = "insert into cancel values ('"+pnr+"','"+ranCancellationNum+"','"+name+"','"+fcode+"', '"+date+"')";
				c.s.executeUpdate(cancelQry);
				String query = "delete from reservation where PNR = '"+pnr+"'";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Ticket cancelled successfully");
				return;
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}		
			
	
	public static void main(String[] args) {
		new CancelTicket();
	}
	
}