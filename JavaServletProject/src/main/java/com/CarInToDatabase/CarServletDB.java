package com.CarInToDatabase;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CarServletDB")
public class CarServletDB extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String carName = request.getParameter("carName");
        String brand = request.getParameter("brand");
        int yearOfManufacture = Integer.parseInt(request.getParameter("yearOfManufacture"));
        String fuelType = request.getParameter("fuelType");
        String transmissionType = request.getParameter("transmissionType");
        int engineCapacity = Integer.parseInt(request.getParameter("engineCapacity"));
        double price = Double.parseDouble(request.getParameter("price"));
        String color = request.getParameter("color");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/JavaIsoft_DB", "root", "root");

            String query = "INSERT INTO Cars (carName, brand, yearOfManufacture, fuelType, transmissionType, engineCapacity, price, color) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, carName);
            ps.setString(2, brand);
            ps.setInt(3, yearOfManufacture);
            ps.setString(4, fuelType);
            ps.setString(5, transmissionType);
            ps.setInt(6, engineCapacity);
            ps.setDouble(7, price);
            ps.setString(8, color);

            int result = ps.executeUpdate();

            if (result > 0) {
                out.println("<h3>Car added successfully!</h3>");
                out.println("<button onclick=\"location.href='CarDetailsForm.html'\" style=\"padding: 10px 20px; background-color: "
						+ "blue; color: white; border: none; border-radius: 5px; cursor: pointer;\">ADD ANOTHER CAR</button>");
            } else {
                out.println("<h3>Error adding car. Please try again.</h3>");
            }

            ps.close();
            con.close();

        } catch (ClassNotFoundException e) {
            out.println("<h3>JDBC Driver not found!</h3>");
            e.printStackTrace(out);
        } catch (Exception e) {
            out.println("<h3>Database Error!</h3>");
            e.printStackTrace(out);
        }
    }
}