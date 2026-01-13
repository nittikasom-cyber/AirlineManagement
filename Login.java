package airlinemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	
	JButton reset,submit,close;
	JTextField tfusername;
	JPasswordField pfpassword;
	public Login() //constructor
	{
		getContentPane().setBackground(Color.darkGray);
		setLayout(null);
		
		//JLabel for text
		//for username
		JLabel lblusername = new JLabel();
		lblusername.setText("Username");
		lblusername.setForeground(Color.orange);
		lblusername.setBounds(20, 20, 100, 20);
		add(lblusername);
		
		//textfield
		tfusername=new JTextField();
		tfusername.setBounds(130,20,200,20);
		add(tfusername);
		
		//for password
		JLabel lblpassword = new JLabel();
		lblpassword.setText("Password");
		lblpassword.setForeground(Color.orange);
		lblpassword.setBounds(20, 60, 100, 20);
		add(lblpassword);
		
		//textfield
	    pfpassword=new JPasswordField();
		pfpassword.setBounds(130,60,200,20);
		add(pfpassword);
		
		
		//for reset
	    reset = new JButton();
		reset.setText("Reset");
		reset.setForeground(Color.BLACK);
		reset.setBounds(40, 120, 120, 20);
		reset.addActionListener(this);
		add(reset);
		
		//for submit
	    submit = new JButton();
		submit.setText("Submit");
		submit.setForeground(Color.BLACK);
		submit.setBounds(300, 120, 120, 20);
		submit.addActionListener(this);
		add(submit);
		
		//for close
	    close = new JButton();
		close.setText("Close");
		close.setForeground(Color.BLACK);
		close.setBounds(170, 160, 120, 20);
		close.addActionListener(this);
		add(close);
		
		setSize(500,250);
		setLocation(400,250);
		setVisible(true);
	}
	
	// @override
	public void actionPerformed(ActionEvent ae)
	{
		//Connection conn=null;
		if(ae.getSource()==submit)
		{
			String username = tfusername.getText();
			@SuppressWarnings("deprecation")
			String password = pfpassword.getText();
			
			try
			{
				
			Conn  c= new Conn();
				
		   String query="SELECT * FROM LOGIN WHERE USERNAME = '"+username+"'AND PASSWORD = '"+password+"'";
		   ResultSet rs =c.stmt.executeQuery(query);
				if(rs.next())
				{
					new Home();
					//System.out.println("Valid");
					setVisible(false);
				}
				else
				{
				  JOptionPane.showMessageDialog(null,"Invalid Username or Pssword");
				  setVisible(false);
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
		else if(ae.getSource()==close)
		{
			setVisible(false);
		}
		else if(ae.getSource()==reset)
		{
			tfusername.setText("");
			pfpassword.setText("");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
            new Login();
	}

}