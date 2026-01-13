package airlinemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener{
	
	JButton reset,submit,close;
	JTextField tfusername;
	JPasswordField pfpassword;
	public Home() //constructor
	{
	     setLayout(null);
	     getContentPane().setBackground(new Color(0,0,128));
	     ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/indigo1.jpeg"));
	     JLabel image=new JLabel(i1);
	     image.setBounds(290, 150,700,500);
	     add(image);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setVisible(true);
		
		JLabel heading=new JLabel("INDIGO WELCOMES YOU...");
		heading.setBounds(430, 40, 1000, 40);
		heading.setForeground(Color.white);
		heading.setFont(new Font("Tahoma",Font.PLAIN,36));
		add(heading);
		
		
		
		JMenuBar menubar=new JMenuBar();
		setJMenuBar(menubar);
		
		JMenu details=new JMenu("Details");
		menubar.add(details);
		
		
		JMenuItem flightDetails=new JMenuItem("Flight Details");
		flightDetails.addActionListener(this);
		details.add(flightDetails);
		
		
		JMenuItem customerDetails=new JMenuItem("Add Customer Details");
		customerDetails.addActionListener(this);
		details.add(customerDetails);
		
		JMenuItem bookFlight=new JMenuItem("Book Flight");
		details.add(bookFlight);
		
		JMenuItem JourneyDetails=new JMenuItem("Journey Details");
		details.add(JourneyDetails);
		
		JMenuItem ticketCancellation=new JMenuItem("Cancel Ticket");
		details.add(ticketCancellation);
		
		//Boarding Pass
		
		JMenu ticket=new JMenu("Ticket");
		menubar.add(ticket);
		
		
		JMenuItem boardingPass=new JMenu("Boarding Pass");
	    ticket.add(boardingPass);
		
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		
	}
	
	// @override
	public void actionPerformed(ActionEvent ae)
	{
	
		String text=ae.getActionCommand();
		
		if (text.equals("Add Customer Details")) {
            new AddCustomer();
        } else if (text.equals("Flight Details")) {
            new Flightinfo();
        } else if (text.equals("Book Flight")) {
            new BookFlight();
        } else if (text.equals("Journey Details")) {
            new JourneyDetails();
        } else if (text.equals("Cancel Ticket")) {
            new Cancel();
        }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
            new Home();
	}

}