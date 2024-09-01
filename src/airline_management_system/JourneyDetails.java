package airline_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;


public class JourneyDetails extends JFrame implements ActionListener{
	
	JTextField tfpnr;
	JButton show;
	JTable table;
	
	JourneyDetails() {
		
		setLayout(null);
		getContentPane().setBackground(Color.white);
		
		JLabel lblpnr = new JLabel("PNR Details");
		lblpnr.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblpnr.setBounds(50,50,100,25);
		add(lblpnr);
		
		tfpnr = new JTextField();
		tfpnr.setBounds(180,50,120,25);
		add(tfpnr);
		
		show = new JButton("Show Details");
		show.setBackground(Color.black);
		show.setForeground(Color.white);
		show.setBounds(320,50,120,25);
		show.addActionListener(this);
		add(show);
		
		table = new JTable();
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0,120,800,150);
		jsp.setBackground(Color.white);
		add(jsp);
		
		setSize(800,500);
		setLocation(400,150);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(show==e.getSource()) {
		try {
			Conn c = new Conn();
			String pnr = tfpnr.getText();
			ResultSet rs = c.s.executeQuery("select * from reservation where PNR = '"+pnr+"'");
			if(rs.isBeforeFirst()) {
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}else {
				JOptionPane.showMessageDialog(null,"No PNR found");
				return;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
		
	}
	
	public static void main(String[] args) {
		new JourneyDetails();
	}

}
