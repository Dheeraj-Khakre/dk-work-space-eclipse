package Sql_Query;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class MYSQL_Insert_Query {
    
	 public static void main(String[] args) {
		try {
			String sql_Query="select * from person ";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dk", "root", "zxcvbnm#321");
			PreparedStatement ps = con.prepareStatement(sql_Query);
			ResultSet set = ps.executeQuery();
			while(set.next()) {
				String name = set.getString("name");
				int age = set.getInt("age");
				String email = set.getString("email");
				String psw = set.getString("psw");
				Date   date = set.getDate("date");

              System.out.println("name "+name);
              System.out.println("age "+age);
              System.out.println("email "+email);
              System.out.println("password "+psw);
              System.out.println("login date "+date);
			}
			
			
		} catch (Exception e) {

                 e.getStackTrace();
                 
		}
	}
	
	
}