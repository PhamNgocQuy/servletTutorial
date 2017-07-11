package com.haku.servlet;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/other/forwardDemo")
public class ForwardDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ForwardDemoServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			
		String forward = request.getParameter("forward");
		ServletOutputStream outputStream = response.getOutputStream();
		outputStream.println(forward);
		if ("true".equals(forward)) {
	        System.out.println("Forward to ShowMeServlet");
	 
	        // Có thể gửi dữ liệu sang trang mới.
	        request.setAttribute(Constants.ATTRIBUTE_USER_NAME_KEY,
	                "Hi, I'm Tom come from Walt Disney !");
	 
	        RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/showMe");
	        request.setAttribute("a","aaaa");
	        dispatcher.forward(request, response);
	 
	        return;
	    }
		outputStream.println("<h3>Text of ForwardDemoServlet</h3>");
		outputStream.println("- servletPath=" + request.getServletPath());
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
		
	}

}
