package javaDB;

import java.sql.*;
import java.util.ArrayList; 

public class query1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//you will need to load the JDBC driver for your database using below line
		Class.forName("com.mysql.cj.jdbc.Driver");
		//establish a connection to the database using drivermanager.getconnection()
		//this method takes a url that specifies the database to connnect and username password for database user
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","master#123");
		//once you have a connection to the database,you can create a statenment object to execute sql commands
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from customers");  
		ArrayList<String> al=new ArrayList<String>();
		while(rs.next()) {
			//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			al.add(rs.getString(2));
			
			//System.out.println(rs.getString(2));
		}
		System.out.println(al);
		System.out.println(al.size());
		  
		con.close();  

	}

}
