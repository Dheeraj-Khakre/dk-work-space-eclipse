package dk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/hello")
public class S1 extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("servlet running sucessfully .... ");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<h1> this is my first servlet </h1>");
		out.println("<h2> welcome to dk mid night world ..  </h2>");
		String Fname = req.getParameter("Fname");
		String Lname = req.getParameter("Lname");
		String email = req.getParameter("email");
		//String dob=req.getParameter("DOB");
		String country = req.getParameter("country");
		String password = req.getParameter("psw");
		String city = req.getParameter("city");
		String  number = req.getParameter("number");
		Cookie c1= new Cookie("name", Fname+Lname);
		c1.setMaxAge(180);
		Cookie c2= new Cookie("email", email);
		c2.setMaxAge(180);
		Cookie c3 = new Cookie("number", number);
		c3.setMaxAge(180);
		res.addCookie(c1);
		res.addCookie(c2);
		res.addCookie(c3);
		

		
		
		
		try {


			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/library", "root", "zxcvbnm#321");
			String sql = "insert into users values(?,?,?,?,current_timestamp,?,?,?,current_timestamp)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, Fname);
			ps.setString(2, Lname);
			ps.setString(3, email);
			ps.setString(4, number);
		//	ps.setDate(5, DOB);
			ps.setString(5, password);
			ps.setString(6, country);
			ps.setString(7, city);
			int x = ps.executeUpdate();
			if (x > 0) out.println("data entered sucessfully");
			else out.println("data entered un-sucessfully");
			RequestDispatcher rs = req.getRequestDispatcher("cookiesdata");
			rs.include(req, res);
		} catch (SQLException | ClassNotFoundException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
			out.println("data entered un-sucessfully");
		
		}
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
