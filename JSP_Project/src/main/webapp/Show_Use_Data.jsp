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
	Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/library", "root", "zxcvbnm#321");
	PreparedStatement ps = con.prepareStatement("select * from users");
	ResultSet result = ps.executeQuery();
	%>
	<table  style="color: black;" border=1 width=80% height=20%>
		<th>NO</th>
		<th>email</th>
		<th>name</th>
		<th>number</th>
		<th>birth date</th>
		<th>city</th>
		<th>country</th>
		<th>delete</th>
		<%
		int i=1;
		while (result.next()) {
		%>
		<tr>
		     <td><%out.print(i++); %> </td>
			<td>
				<%
				out.print(result.getString("email") + " " + result.getString("Lame"));
				%>
			</td>
			<td>
				<%
				out.print(result.getString("Fname"));
				%>
			</td>
			<td>
				<%
				out.print(result.getString("number"));
				%>
			</td>
			<td>
				<%
				out.print(result.getString("DOB"));
				%>
			</td>
			<td>
				<%
				out.print(result.getString("city"));
				%>
			</td>
			<td>
				<%
				out.print(result.getString("country"));
				%>
			</td>
			<td>
				
				<a href="deleteuser.jsp?email=<%=result.getString("email") %>">delete</a>
			</td>


		</tr>

		<%
		}
		%>
	</table>


</body>
</html>