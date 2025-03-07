package com.EmployeeDataToTable;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeDataServlet
 */

//@WebServlet("/EmployeeDataServlet")
//public class EmployeeDataServlet extends HttpServlet 
//{
//	private static final long serialVersionUID = 1L;
//
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
//	{
//
//		Employee emp = new Employee();  
//
//		emp.setName(request.getParameter("name"));
//		emp.setAge(request.getParameter("age"));
//		emp.setEmailId(request.getParameter("emailid"));
//
//		System.out.println("Employee Data:" + emp);
//
//	}
//}

@WebServlet("/EmployeeDataServlet")
public class EmployeeDataServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");

		Employee emp = new Employee();//object  

		emp.setEmployeeId(request.getParameter("employeeId"));
		emp.setName(request.getParameter("name"));
		emp.setAge(request.getParameter("age"));
		emp.setEmailId(request.getParameter("emailid"));
		emp.setPhoneNumber(request.getParameter("phoneNumber"));
		emp.setBloodGroup(request.getParameter("bloodGroup"));
		emp.setJobType(request.getParameter("jobType"));

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang='en'>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		out.println("<title>Employee Data</title>");
		out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
		out.println("<style>");
		out.println("body { background-color: #f8f9fa; font-family: Arial, sans-serif; }");
		out.println("h1 { margin-top: 20px; font-size: 2rem; font-weight: bold; color: #343a40; }");
		out.println(".card-container { margin: 30px auto; max-width: 90%; padding: 20px; }");
		out.println(".table-container { padding: 20px; }");
		out.println("table { width: 100%; }");
		out.println("th { background-color: #28a745; color: white; font-weight: bold; text-align: center; }");
		out.println("td { text-align: center; vertical-align: middle; }");
		out.println(".table-bordered { border: 1px solid #ddd; }");
		out.println(".table-striped tbody tr:nth-of-type(odd) { background-color: #f9f9f9; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container'>");
		out.println("<h1 class='text-center'>Employee Data</h1>");
		out.println("<div class='card card-container'>");
		out.println("<div class='card-body table-container'>");
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Employee ID</th>");
		out.println("<th>Name</th>");
		out.println("<th>Age</th>");
		out.println("<th>Email ID</th>");
		out.println("<th>Phone Number</th>");
		out.println("<th>Blood Group</th>");
		out.println("<th>Job Type</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		out.println("<tr>");
		out.println("<td>" + emp.getEmployeeId() + "</td>");
		out.println("<td>" + emp.getName() + "</td>");
		out.println("<td>" + emp.getAge() + "</td>");
		out.println("<td>" + emp.getEmailId() + "</td>");
		out.println("<td>" + emp.getPhoneNumber() + "</td>");
		out.println("<td>" + emp.getBloodGroup() + "</td>");
		out.println("<td>" + emp.getJobType() + "</td>");
		out.println("</tr>");
		out.println("</tbody>");
		out.println("</table>");
		out.println("</div>"); 
		out.println("</div>");
		out.println("</div>");
		out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js'></script>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}
}
