<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	   out.println("<h1> this is my first jsp </h1>");
		String Fname = request.getParameter("Fname");
		String Lname = request.getParameter("Lname");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String password = request.getParameter("psw");
		String city = request.getParameter("city");
		String number = request.getParameter("number");
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/library", "root", "zxcvbnm#321");
			String sql = "insert into users values(?,?,?,?,current_timestamp,?,?,?,current_timestamp)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, Fname);
			ps.setString(2, Lname);
			ps.setString(3, email);
			ps.setString(4, number);
			ps.setString(5, password);
			ps.setString(6, country);
			ps.setString(7, city);
			int x = ps.executeUpdate();
			if (x > 0){
				out.println("data entered sucessfully");
				session.setAttribute("name", Fname+Lname);
				session.setAttribute("email", email);
				session.setAttribute("no.", number);
				RequestDispatcher rd = request.getRequestDispatcher("SessionData.jsp");
				rd.include(request, response);
			}
			else  {
				out.println("data  is not entered ");
				session.setAttribute("name", Fname+Lname);
				session.setAttribute("email", email);
				session.setAttribute("no.", number);
				RequestDispatcher rd = request.getRequestDispatcher("SessionData.jsp");
				rd.include(request, response);
			}
		} catch (SQLException s) {

			s.printStackTrace();
			out.println("data entered un-sucessfully");

		}
		
	%>
	

</body>
</html>