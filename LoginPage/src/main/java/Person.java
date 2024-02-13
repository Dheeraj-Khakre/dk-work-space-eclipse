
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


public class Person extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

    String name=req.getParameter("name");
    int age = Integer.parseInt(req.getParameter("age"));
    
    String email=req.getParameter("email");
    String password=req.getParameter("password");
    res.setContentType("text/html");
    PrintWriter out= res.getWriter();
    String sql="insert into person(name, age ,email,password) values(?,?,?,?)";
    try {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/dk?user=root&password=zxcvbnm#321");
    	PreparedStatement ps = con.prepareStatement(sql);	
    	ps.setString(1,name);
    	ps.setInt(2,age);
    	//ps.setString(3,number);
    	ps.setString(3,email);
    	ps.setString(4,password);
    	  int x= ps.executeUpdate();
    	  ps.close();
    	  con.close();
    	  if(x>0)
    	out.print("<h3> person data added succefully</h3>");
    	  else {
    		  out.println("<h3> person data not added</h3>");
    	  }
    	
    	
    }
    catch (ClassNotFoundException | SQLException e) {
    	

    e.getMessage();
    e.getStackTrace();
	}
		
	}

}
