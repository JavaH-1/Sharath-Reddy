package com.ServeltFiles;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class firstTime
 */
@WebServlet("/FirstProgram")
public class FirstProgram extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		response.getWriter().println("<html><body>");
		response.getWriter().println("<h2>Welcome! Please enter your name:</h2>");
		response.getWriter().println("<form action='FirstProgram' method='post'>");
		response.getWriter().println("Name: <input type='text' name='username'><br><br>");
		response.getWriter().println("<input type='submit' value='Submit'>");
		response.getWriter().println("</form>");
		response.getWriter().println("</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("username");
		response.setContentType("text/html");
		response.getWriter().println("<html><body>");
		if (username == null || username.trim().isEmpty()) 
		{
			response.getWriter().println("<h2>Name is required! Please go back and try again.</h2>");
		} 
		else 
		{
			response.getWriter().println("<h2>Hello, " + username + "!</h2>");
			response.getWriter().println("<p>Welcome to the simple servlet demo for first-time users.</p>");
		}
		response.getWriter().println("</body></html>");
	}
}