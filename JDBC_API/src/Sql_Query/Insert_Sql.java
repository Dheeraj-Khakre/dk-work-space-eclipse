package Sql_Query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insert_Sql {
	
	static Scanner cs = new Scanner(System.in);
	 
	     
	
public static void main(String[] args) {
	   
	String sql ="insert into dk values(?,?,?,?)"; 
	try {
		
		Class.forName("mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/dk","root","zxcvbnm#@321");
		PreparedStatement ps = con.prepareStatement(sql);
		  ps.setString(1, "asb");
		
	} catch (Exception e) {
		
	}
}

}
