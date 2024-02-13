package cookies;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/logininfo")
public class LoginInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       	
	    Cookie email = new Cookie("email", request.getParameter("email"));
	    email.setMaxAge(48*60);
     	
	    Cookie psw = new Cookie("psw", request.getParameter("psw"));
	   psw .setMaxAge(48*60);
	    response.addCookie(email);
	response.addCookie(psw);
	    RequestDispatcher rd = request.getRequestDispatcher("home.html");
	    rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
