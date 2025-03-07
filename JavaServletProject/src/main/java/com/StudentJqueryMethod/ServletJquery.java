package com.StudentJqueryMethod;

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

@WebServlet("/ServletJquery")
public class ServletJquery extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Connection initializeDatabase() throws SQLException, ClassNotFoundException {
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

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            Connection con = initializeDatabase();
            PreparedStatement st = con.prepareStatement(
                "INSERT INTO StudentTable (studentName, age, email, phone, fee) VALUES (?, ?, ?, ?, ?)");
            st.setString(1, studentName);
            st.setInt(2, Integer.parseInt(age));
            st.setString(3, email);
            st.setString(4, phone);
            st.setBigDecimal(5, new java.math.BigDecimal(fee));
            st.executeUpdate();

            st.close();
            con.close();

            out.write("{\"status\":\"success\",\"message\":\"Student data inserted successfully!\"}");
        } catch (Exception e) {
            out.write("{\"status\":\"error\",\"message\":\"Error occurred: " + e.getMessage() + "\"}");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String studentId = request.getParameter("searchStudentId");

        try {
           
            //System.out.println("Searching for student with ID: " + studentId);
            
            if (studentId == null || studentId.trim().isEmpty()) {
                out.write("{\"status\":\"error\",\"message\":\"Student ID is missing.\"}");
                return;
            }

            Connection con = initializeDatabase();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM StudentTable WHERE studentId=?");
            ps.setString(1, studentId);

            ResultSet rs = ps.executeQuery();
            String result = "";

            if (!rs.isBeforeFirst()) {
                result = "{\"status\":\"error\",\"message\":\"No student found with ID: " + studentId + "\"}";
            } else {
                result = "{\"status\":\"success\",\"data\":[";

                boolean firstRow = true;
                while (rs.next()) {
                    if (!firstRow) {
                        result += ",";
                    }
                    result += "{";
                    result += "\"studentName\":\"" + rs.getString("studentName") + "\",";
                    result += "\"age\":" + rs.getInt("age") + ",";
                    result += "\"email\":\"" + rs.getString("email") + "\",";
                    result += "\"phone\":\"" + rs.getString("phone") + "\",";
                    result += "\"fee\":\"" + rs.getBigDecimal("fee") + "\"";
                    result += "}";
                    firstRow = false;
                }
                result += "]}";
            }

            out.write(result);
            System.out.println(result);

            ps.close();
            con.close();
        } catch (Exception e) {
         
            e.printStackTrace();
            out.write("{\"status\":\"error\",\"message\":\"Error: " + e.getMessage() + "\"}");
        } finally {
            out.close();
        }
    }

}
