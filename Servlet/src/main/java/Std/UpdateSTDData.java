package Std;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;

@WebServlet("/updatestdinfodata")
public class UpdateSTDData extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   PrintWriter out = response.getWriter();
		   response.setContentType("text/html");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/dk", "root", "zxcvbnm#321");
         String sql = "update std set name =?,yop=?,age=?,moNo=? where id =?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, request.getParameter("name"));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(request.getParameter("yop"), dtf);
		Date DOB = Date.valueOf(date);
		
		ps.setDate(2, DOB);
		ps.setInt(3, Integer.parseInt(request.getParameter("age")));
		ps.setString(4, request.getParameter("no"));
		   HttpSession session = request.getSession(false);
		   int id = (int) session.getAttribute("id");
		ps.setInt(5,id );
		int x= ps.executeUpdate();
		if(x>0) {
			out.print("data enter secceseefully");
			
		}else {
			out.print("something is wronge ...");
		}
		} catch (ClassNotFoundException | SQLException e) {

         
			e.printStackTrace();
			
			
		}
	
	}


}
