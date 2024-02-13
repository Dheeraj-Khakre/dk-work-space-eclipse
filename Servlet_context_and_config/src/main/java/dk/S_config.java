package dk;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class S_config extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		     ServletConfig sf =  getServletConfig(); 
		            String url=  sf.getInitParameter("url");
		            String name = sf.getInitParameter("name");
		            System.out.println(name);
		            System.out.println("servlet config :"+url);
		             ServletContext sc = getServletContext();
		          String   url2=  sc.getInitParameter("url2");
		          System.out.println("servlet context :"+url2);
		          String   name1=  sc.getInitParameter("name1");
		          System.out.println("servlet context :"+name1);
		    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
