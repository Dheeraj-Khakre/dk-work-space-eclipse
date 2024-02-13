package dk;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
@webServlet("/DK")
public class InputServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {


		String name = req.getParameter("name");
		String age = req.getParameter("age");
		 PrintWriter out = response.getWriter();
         res.setContentType("text/html");
         out.print("<h1> hello dk mid night sky </h1>");
         out.print("<h1>name = "+name+" </h1>");
         out.print("<h1>age = "+age+" </h1>"); 
	}

}
