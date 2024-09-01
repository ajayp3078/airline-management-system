package airline_management_system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener{
	
	JMenuItem flightDetails,customerDetails,reservationDetails,bookFlight,journeyDetails,ticketCancellation,boardingPass;

	public Home(){
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline_management_system/icons/front.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(0,0,1600,800);
		add(image);
		
		JLabel heading = new JLabel("AIR INDIA WELCOMES YOU");
		heading.setBounds(500,40,500,40);
		heading.setForeground(Color.BLUE);
		heading.setFont(new Font("Tahoma", Font.PLAIN, 36));
		image.add(heading);
		
		// for making menu
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		JMenu details = new JMenu("Details");
		menubar.add(details);
		
		flightDetails = new JMenuItem("Flight Details");
		flightDetails.addActionListener(this);
		details.add(flightDetails);
		
		customerDetails = new JMenuItem("Add Customer Details");
		customerDetails.addActionListener(this);
		details.add(customerDetails);
		
		reservationDetails = new JMenuItem("Reservation Details");
		reservationDetails.addActionListener(this);
		details.add(reservationDetails);
		
		bookFlight = new JMenuItem("Book Flight");
		bookFlight.addActionListener(this);
		details.add(bookFlight);
		
		journeyDetails = new JMenuItem("Journey Details");
		journeyDetails.addActionListener(this);
		details.add(journeyDetails);
		
		ticketCancellation = new JMenuItem("Cancel Ticket");
		ticketCancellation.addActionListener(this);
		details.add(ticketCancellation);
		
		JMenu ticket = new JMenu("Ticket");
		menubar.add(ticket);
		
		boardingPass = new JMenuItem("Boarding Pass");
		boardingPass.addActionListener(this);
		ticket.add(boardingPass);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);		// for full screen
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String text = e.getActionCommand();
		
		if(text.equals("Flight Details")) {
			new FlightInfo().setVisible(true);
		}
		else if(text.equals("Add Customer Details")) {
			new AddCustomer().setVisible(true);
		}
		else if(text.equals("Reservation Details")) {
//			new AddCustomer().setVisible(true);
		}
		else if(text.equals("Book Flight")) {
			new BookFlight().setVisible(true);
		}
		else if(text.equals("Journey Details")) {
			new JourneyDetails().setVisible(true);
		}
		else if(text.equals("Cancel Ticket")) {
			new CancelTicket().setVisible(true);
		}
		else if(text.equals("Boarding Pass")) {
			new BoardingPass().setVisible(true);
		}
		
	}

	public static void main(String[] args) {
		new Home();
	}

}





