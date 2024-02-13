package Std;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

@WebServlet("/updateSTDinfro")
public class UpdaateUser extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  PrintWriter out = response.getWriter();
		   response.setContentType("text/html");
		   HttpSession session = request.getSession();
		   

		try {
			Class.forName("com.mysql.cj.jdbc.D"
					+ "river");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/dk", "root", "zxcvbnm#321");
		String sql = "select id from std where id = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,Integer.parseInt(request.getParameter("id")));
		ResultSet r   =  ps.executeQuery();
		  if(r.next()) {
			     session.setAttribute("id",Integer.parseInt(request.getParameter("id")) );
			 
			 RequestDispatcher rd = request.getRequestDispatcher("updateOFuseInfo.html");
			 rd.forward(request, response);
			 
		  }else {
			  out.print("user not exist ....");
			  RequestDispatcher rd = request.getRequestDispatcher("updatestd.html");
				 rd.forward(request, response);
			  
		  }
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
		
			// TODO: handle exception
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
}
