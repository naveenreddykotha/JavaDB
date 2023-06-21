package javaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Connetiondb {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		// TODO Auto-generated method stub
		String username = null;
		String password = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails","root","master#123");
		//once you have a connection to the database,you can create a statenment object to execute sql commands
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from credentails");
		while(rs.next()) {
			username=rs.getString(1);
			password=rs.getString(2);
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			signInpage(username,password);
		}
		con.close();
//		signInpage(username,password);

	}
	public static void signInpage(String username,String password) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(username);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		String text= driver.findElement(By.tagName("p")).getText();
		System.out.println(text);
		Assert.assertEquals(text,"You are successfully logged in.");
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		driver.close();
	}

}
