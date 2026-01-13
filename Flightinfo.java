package airlinemanagementsystem;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class Flightinfo extends JFrame{
	public Flightinfo() {
		
		setLayout(null);
		
		JTable table=new JTable();
		
		try {
			
			Conn c=new Conn();
			
			ResultSet rs=c.stmt.executeQuery("SELECT * FROM flight");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			}
		catch(Exception e){
			System.out.println(e);
		}
		
		JScrollPane jsp = new JScrollPane(table);
		
		jsp.setBounds(0,0,800,500);
		add(jsp);
		
		//getContentPane().setBackground(new Color(0,0,128));
		setSize(800,400);
		setLocation(300,200);
		setVisible(true);
		
		
	}

	public static void main(String[] args)
	{
		new Flightinfo();
	}
}
