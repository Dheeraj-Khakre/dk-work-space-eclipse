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
   if(session!=null){
	   out.println(" name of user is "+session.getAttribute("name"));
	   out.println("<br>"+" email of user is "+session.getAttribute("email"));

	   out.println("<br>"+" number of user is "+session.getAttribute("no."));

   }
      

%>
</body>
</html>