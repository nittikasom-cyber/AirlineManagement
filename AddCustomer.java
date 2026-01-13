package airlinemanagementsystem;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.ImageIcon;
public class AddCustomer extends JFrame implements ActionListener{
	
	JTextField tfname,tfphoneno,tfaadhar,tfnationality,tfaddress;
	JRadioButton rbmale,rbfemale;
	
	public AddCustomer()
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel heading=new JLabel("ADD CUSTOMER DETAILS");
		heading.setBounds(230,20,500,35);
		heading.setFont(new Font("Tahoma",Font.PLAIN,32));
		heading.setForeground(Color.blue);
		add(heading);
		
		JLabel lblname=new JLabel("Name");
		lblname.setBounds(60,90,150,25);
		lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(lblname);
		
		tfname=new JTextField();
		tfname.setBounds(200,90,200,25);
		add(tfname);
		
		JLabel lblnationality=new JLabel("Nationality");
		lblnationality.setBounds(60,150,150,25);
		lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(lblnationality);
		
	    tfnationality=new JTextField();
		tfnationality.setBounds(200,150,200,25);
		add(tfnationality);
		
		JLabel lblaadhar=new JLabel("Aadhar Number");
		lblaadhar.setBounds(60,210,150,25);
		lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(lblaadhar);
		
		tfaadhar=new JTextField();
		tfaadhar.setBounds(200,210,200,25);
		add(tfaadhar);
		
		JLabel lbladdress=new JLabel("Address");
		lbladdress.setBounds(60,270,150,25);
		lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(lbladdress);
		
	    tfaddress=new JTextField();
		tfaddress.setBounds(200,270,200,25);
		add(tfaddress);
		
		JLabel lblgender=new JLabel("Gender");
		lblgender.setBounds(60,330,150,25);
		lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(lblgender);
		
		ButtonGroup gendergroup=new ButtonGroup();
		
	    rbmale=new JRadioButton("Male");
		rbmale.setBounds(200,330,75,25);
		rbmale.setBackground(Color.white);
		add(rbmale);

	    rbfemale=new JRadioButton("Female");
		rbfemale.setBounds(320,330,75,25);
		rbfemale.setBackground(Color.white);
		add(rbfemale);
		
		gendergroup.add(rbmale);
		gendergroup.add(rbfemale);
		
		JLabel lblphoneno=new JLabel("Phone Number");
		lblphoneno.setBounds(60,390,150,25);
		lblphoneno.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(lblphoneno);
		
	    tfphoneno=new JTextField();
		tfphoneno.setBounds(200,390,200,25);
		add(tfphoneno);
		
		JButton save=new JButton("SAVE");
		save.setBackground(Color.GREEN);
		save.setForeground(Color.WHITE);
		save.setBounds(240,450,100,30);
		save.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		save.setFocusable(false);
		save.addActionListener(this);
		add(save);
		
		ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/images/human.jpeg"));
		JLabel lblimage=new JLabel(image);
		lblimage.setBounds(450,30,348,500);
		add(lblimage);
		
		setSize(900,600);
		setLocation(250,100);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String name=tfname.getText();
		String nationality=tfnationality.getText();
		String phone=tfphoneno.getText();
		String address=tfaddress.getText();
		String aadhar=tfaadhar.getText();
		
		String gender=null;
		if(rbmale.isSelected()) {
			gender="Male";
		}
		else {
			gender="female";
		}
		try
		{
			Conn  c= new Conn();
			
			String query="INSERT INTO passenger(NAME,NATIONALITY,PHONE,ADDRESS,AADHAR,GENDER)VALUES('"+name+"','"+nationality+"','"+phone+"','"+address+"','"+aadhar+"','"+gender+"')";
			int rn=c.stmt.executeUpdate(query);
			if(rn>0)
			{
			JOptionPane.showMessageDialog(null,"Customer Details Added Successfully!");
			setVisible(false);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String[] args)
	{
	  new AddCustomer();	
	}

}
