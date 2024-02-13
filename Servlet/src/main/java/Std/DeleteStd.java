package Std;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@WebServlet("/deletestddata")
public class DeleteStd extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  PrintWriter out = response.getWriter();
		   response.setContentType("text/html");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/dk", "root", "zxcvbnm#321");
		String sql = "delete from std where id =?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,Integer.parseInt(request.getParameter("id")));
		  int x =  ps.executeUpdate();
		  if(x>0) {
			  out.print("deleted opration done ...");
			 
		  }else {
			  out.print("user not exist ....");
			  
		  }
		
	
	}catch (ClassNotFoundException e) {
		e.getStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
