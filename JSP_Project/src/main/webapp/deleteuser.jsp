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
	//int id = Integer.parseInt(request.getParameter("id"));

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/library", "root", "zxcvbnm#321");
		String sql = "delete from users where email =?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,request.getParameter("email"));
		int x = ps.executeUpdate();
		if (x > 0) {
			out.print("deleted opration done ...");
			RequestDispatcher rd = request.getRequestDispatcher("Show_Use_Data.jsp");
			rd.forward(request, response);

		} else {
			out.print("user not exist ....");

		}

	} catch (ClassNotFoundException e) {
		e.getStackTrace();
	}
	%>

</body>
</html>