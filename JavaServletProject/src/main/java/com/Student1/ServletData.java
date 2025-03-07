package com.Student1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletData")
public class ServletData extends HttpServlet 
{
    private static final long serialVersionUID = 1L;

    private Connection initializeDatabase() throws SQLException, ClassNotFoundException 
    {
        String dbDriver = "com.mysql.cj.jdbc.Driver";
        String dbURL = "jdbc:mysql://127.0.0.1:3306/JavaIsoft_DB";
        String dbUsername = "root";
        String dbPassword = "root";

        Class.forName(dbDriver);
        return DriverManager.getConnection(dbURL, dbUsername, dbPassword);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentName = request.getParameter("studentName");
        String age = request.getParameter("age");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String fee = request.getParameter("fee");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Connection con = initializeDatabase();
            PreparedStatement st = con.prepareStatement("INSERT INTO StudentTable (studentName, age, email, phone, fee) VALUES (?, ?, ?, ?, ?)");
            st.setString(1, studentName);
            st.setInt(2, Integer.parseInt(age));
            st.setString(3, email);
            st.setString(4, phone);
            st.setBigDecimal(5, new java.math.BigDecimal(fee));
            st.executeUpdate();

            st.close();
            con.close();

            out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css'>");
            out.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css'>");
            out.println("<style>");
            out.println("body { background: #3333ff; font-family: Arial, sans-serif; display: flex; justify-content: center; align-items: center; min-height: 100vh; padding: 10px; }");
            out.println(".container { width: 100%; max-width: 500px; padding: 30px; background: rgb(230, 230, 230); border-radius: 10px; box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2); animation: fadeIn 0.8s ease; }");
            out.println("@keyframes fadeIn { from { opacity: 0; transform: translateY(-20px); } to { opacity: 1; transform: translateY(0); } }");
            out.println(".btn-custom { background-color: #6c63ff; color: white; border: none; padding: 10px 20px; border-radius: 5px; transition: all 0.3s ease; }");
            out.println(".btn-custom:hover { background-color: #5548c8; transform: scale(1.05); }");
            out.println(".alert-custom { background-color: #d4edda; color: #155724; padding: 10px; border-radius: 5px; text-align: center; font-weight: bold; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<div class='alert-custom'>");
            out.println("<b>Successfully Inserted!</b>");
            out.println("</div>");
            out.println("<div class='d-flex justify-content-between mt-4'>");
            out.println("<button onclick=\"location.href='Post.html'\" class='btn-custom'><i class='fas fa-plus-circle'></i> ADD STUDENT</button>");
            out.println("<button onclick=\"location.href='Get.html'\" class='btn-custom'><i class='fas fa-search'></i> GET BY STUDENT ID</button>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } 
        catch (Exception e) 
        {
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css'>");
            out.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container mt-5'>");
            out.println("<div class='alert alert-danger text-center'>");
            out.println("<b>Error occurred:</b> " + e.getMessage());
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String studentId = request.getParameter("searchStudentId");

        try 
        {
            Connection con = initializeDatabase();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM StudentTable WHERE studentId=?");
            ps.setString(1, studentId);

            ResultSet rs = ps.executeQuery();

            out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css'>");
            out.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css'>");
            out.println("<style>");
            out.println("body { background: #3333ff; font-family: Arial, sans-serif; display: flex; justify-content: center; align-items: center; min-height: 100vh; padding: 10px; }");
            out.println(".container { max-width: 900px; margin-top: 50px; padding: 30px; background: rgb(230, 230, 230); border-radius: 10px; box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2); }");
            out.println(".table-custom { background-color: #ffffff; border-radius: 10px; padding: 15px; }");
            out.println(".table-blue th { background-color: #6c63ff; color: white; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");

            if (!rs.isBeforeFirst())
            {
                out.println("<div class='alert alert-warning text-center'>");
                out.println("No student found with ID: " + studentId);
                out.println("</div>");
            } 
            else 
            {
                out.println("<div class='table-responsive table-custom'>");
                out.println("<table class='table table-striped table-bordered table-blue'>");
                out.println("<thead>");
                out.println("<tr>");
                out.println("<th>Student Name</th>");
                out.println("<th>Age</th>");
                out.println("<th>Email</th>");
                out.println("<th>Phone</th>");
                out.println("<th>Fee</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");

                while (rs.next()) 
                {
                    out.println("<tr>");
                    out.println("<td>" + rs.getString("studentName") + "</td>");
                    out.println("<td>" + rs.getInt("age") + "</td>");
                    out.println("<td>" + rs.getString("email") + "</td>");
                    out.println("<td>" + rs.getString("phone") + "</td>");
                    out.println("<td>" + rs.getBigDecimal("fee") + "</td>");
                    out.println("</tr>");
                }
                out.println("</tbody>");
                out.println("</table>");
                out.println("</div>");
            }

            ps.close();
            con.close();
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

        } 
        catch (Exception e)
        {
            out.println("<div class='alert alert-danger'>");
            out.println("Error: " + e.getMessage());
            out.println("</div>");
        } 
        finally 
        {
            out.close();
        }
    }
}