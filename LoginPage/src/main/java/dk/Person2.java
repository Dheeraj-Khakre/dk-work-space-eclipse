package dk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Person2
 */
@WebServlet("/data")
public class Person2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Person2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
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
