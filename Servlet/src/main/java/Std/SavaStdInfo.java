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

@WebServlet("/addstddata")
public class SavaStdInfo extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   PrintWriter out = response.getWriter();
		   response.setContentType("text/html");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/dk", "root", "zxcvbnm#321");
		String sql = "insert into std values(?,?,?,?,?)";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, Integer.parseInt(request.getParameter("id")));
		ps.setString(2, request.getParameter("name"));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(request.getParameter("yop"), dtf);
		Date DOB = Date.valueOf(date);
		
		ps.setDate(3, DOB);
		ps.setInt(4, Integer.parseInt(request.getParameter("age")));
		ps.setString(5, request.getParameter("no"));
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
