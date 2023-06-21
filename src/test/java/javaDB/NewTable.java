package javaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class NewTable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails","root","master#123");
		//once you have a connection to the database,you can create a statenment object to execute sql commands
		Statement stmt=con.createStatement();
		//stmt.execute("create table employees(emp_id int,emp_name varchar(100),location varchar(100))");
		//stmt.execute("insert into employees values(1,'john','USA')");
		stmt.execute("update employees set location='london' where emp_name='john'");
		con.close();

	}

}
