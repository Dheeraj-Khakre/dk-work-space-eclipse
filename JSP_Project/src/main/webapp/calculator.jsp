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
      String n1=request.getParameter("n1");
      String n2=request.getParameter("n2");
      String op= request.getParameter("oper");
      float ans=0;
      try{
      if(op.equals("+")){
    	 // out.print(Integer.parseInt(n1)+Integer.parseInt(n2));
    	 ans=Integer.parseInt(n1)+Integer.parseInt(n2);
      }else  if(op.equals("-")){
    	 // out.print(Integer.parseInt(n1)-Integer.parseInt(n2));
    	  ans=Integer.parseInt(n1)-Integer.parseInt(n2);
      }else  if(op.equals("*")){
    	 // out.print(Integer.parseInt(n1)*Integer.parseInt(n2));
    	  ans=Integer.parseInt(n1)*Integer.parseInt(n2);
      }else{
    	//  out.print(Float.parseFloat(n1)/Float.parseFloat(n2));
    	  ans=Float.parseFloat(n1)/Float.parseFloat(n2);
      }
      }catch(Exception e){
    	  out.print("something is going wronge");
      }



%>
<form action="calculator.jsp">
		 
		 <div>
			 enter number : <input type="number" name="n1"required>
		 </div>
		  <div>
			 enter number : <input type="number" name="n2"required>
		 </div>
		  <div>
			 output  : <input type="number" name="n2" value="<%=ans%>" disabled>
		 </div>
		  <div>
			  <input type="radio" name="oper" value="+">addition
		 </div>
		  <div>
			  <input type="radio" name="oper" value="-">subtraction
		 </div> <div>
			  <input type="radio" name="oper" value="*">multiplication
		 </div> <div>
			  <input type="radio" name="oper" value="/">division
		 </div>
		  <div>
			  <input type="submit">
		 </div>
		
	</form>

</body>
</html>