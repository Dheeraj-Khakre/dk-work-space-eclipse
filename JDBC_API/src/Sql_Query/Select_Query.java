package Sql_Query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import SQL_Login_Project.Login;

public class Select_Query {

	public static void main(String[] args) {
		 //  Login.main(null);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//jdbc:mysql://localHost:3306/dk","root","zxcvbnm#321")
			Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/dk","root","zxcvbnm#321");
			
			PreparedStatement ps = con.prepareStatement("select * from users");
			ResultSet result = ps.executeQuery() ;
			while (result.next()) {
				System.out.println("your name : " + result.getString("Fname")+" "+result.getString("Lname") );
				System.out.println("your Email : " + result.getString("email"));
				System.out.println("your number : " + result.getString("number"));
				System.out.println("your birth date : " + result.getString("DOB"));
				System.out.println("your password : " + result.getString("password"));
				System.out.println("your  country: " + result.getString("country"));
				System.out.println("your city  : " + result.getString("city"));
				System.out.println(" ------------------//------------------------");


			}
			
			System.out.println(" Update Query //.......");
			System.out.println("enter your  existing number ");
			String email =  new  java.util.Scanner(System.in).next();
			System.out.println("enter your  changing  number ");
			String num =  new  java.util.Scanner(System.in).next();
			PreparedStatement ps2 =con.prepareStatement("update  users set number =? where email =?");
			ps2.setString(1, num);
			ps2.setString(2, email);
		int	 x = ps2.executeUpdate();
			 if(x>0) {
				 System.out.println(" change has updated ");
			 }else System.out.println("change has not execute .. try again");
			
			
			 System.out.println(" delete query //......");
			 System.out.println("enter email id");
			 PreparedStatement ps3 = con.prepareStatement("delete from users where email=?");
			 			  email =  new  java.util.Scanner(System.in).next();
			   ps3.setString(1, email);
			x=   ps3.executeUpdate();
			 if(x>0) {
				 System.out.println(" tuple is delelted  ");
			 }else System.out.println("delete  is not execute .. try again");
			
			ps.close();
			ps2.close();
			con.close();
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
