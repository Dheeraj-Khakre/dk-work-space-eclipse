<%@page import="java.sql.ResultSet"%>
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
<style>
body {
	background-color: #282828;
	color: white;
	font-family: Arial, sans-serif; table { width : 100%;
	border-collapse: collapse; th , td { border : 1px solid #ddd;
	padding: 8px;
}

th {
	background-color: olive;
	color: white;
}
tr{
background-color: olive;
	color: black;
}
</style>
</head>
<body>
	<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/dk", "root", "zxcvbnm#321");
	PreparedStatement ps = con.prepareStatement("select * from std");
	ResultSet result = ps.executeQuery();
	%>
	<table  style="color: black;" border=1 width=80% height=20%>
		<th>id</th>
		<th>name</th>
		<th>year of pass out</th>
		<th>age</th>
		<th>number</th>
		<th>delete</th>
		<%
		int i=1;
		while (result.next()) {
		%>
		<tr>
		       <td>
				<%
				out.print(result.getInt("id") );
				%>
			</td>
			<td>
				<%
				out.print(result.getString("name"));
				%>
			</td>
			<td>
				<%
				out.print(result.getDate("yop"));
				%>
			</td>
			<td>
				<%
				out.print(result.getString("age"));
				%>
			</td>
			<td>
				<%
				out.print(result.getString("moNo"));
				%>
			</td>
			<td>
				<a href="delete.jsp?id=<%= result.getInt("id")%>">delete</a>
			</td>

		</tr>

		<%
		}
		%>
	</table>


</body>
</html>