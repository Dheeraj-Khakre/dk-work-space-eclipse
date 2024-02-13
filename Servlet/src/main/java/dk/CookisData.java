package dk;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;
@WebServlet("/cookiesdata")
public class CookisData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           
           Cookie []cookies = request.getCookies();
           for(Cookie c:cookies) {
        	    System.out.println(c.getValue());
           }
	}

}
