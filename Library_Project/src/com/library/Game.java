package com.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Game { 
	 static   Scanner sc= new Scanner(System.in);
	 public static void main(String[] args) throws SQLException {
		 System.out.println("enter id and user name ");
		 int id = sc.nextInt();
		 String username = sc.next();
		 int health =3;
		 int score = 0;
		
		 Random random = new Random();
		 
		  StringBuffer  sys_no = new StringBuffer("[");
		  StringBuffer usrNo = new StringBuffer("[");
		   while(true) {
			   System.out.println("enter  one number");
			   int randomNum = random.nextInt(9) + 1;
			   int no = sc.nextInt();
			    sys_no.append(randomNum+",");
			    usrNo.append(no+",");
			   
			   
			   if(no==randomNum) {
				   score+=10;
			   }else {
				   health--;
				   
			   }
			   if(health==0) {
				   break;
			   }
		   }
		   sys_no.append("]");
		   usrNo.append("]");
		   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dk", "root", "zxcvbnm#321");


		
			PreparedStatement ps = con.prepareStatement("insert  into userScore values(?,?,?,?,?, current_timestamp)");
			
			
			ps.setInt(1, id);
			ps.setString(2, username);
			ps.setString(3, sys_no.toString());
			ps.setString(4, usrNo.toString());
			ps.setInt(5, score);
			ps.executeUpdate();
		
		   System.out.println("user data ");
		      ps = con.prepareStatement("select * from userScore where id = ?");
		      ps.setInt(1, id);
		      ResultSet r=  ps.executeQuery();
		        if(r.next()) {
		        	System.out.println(" id   ,  system_genrated_digit ,  user attempt , total score  ,  date time");
		        	System.out.println(r.getInt("id")+ " , "+r.getString("username")+" , "+r.getString("sys_gerrete_digit")+" , "+r.getString("user_attempted_no")+" ,"+r.getInt("total_score")+" , "+ r.getDate("create_at"));
		        }
		      
			
		   } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
	}

}
