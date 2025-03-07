package JsonFromData;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@WebServlet("/StudentRegisterServlet")
public class StudentRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter out = response.getWriter();

        try {
            // Read JSON request body and map it to a Student object
            Student student = mapper.readValue(request.getInputStream(), Student.class);

            // Basic validation for the fields (e.g., empty fields)
            if (student.getStudentName() == null || student.getEmail() == null || student.getPassword() == null) {
                ObjectNode errorResponse = mapper.createObjectNode();
                errorResponse.put("status", "failure");
                errorResponse.put("message", "All fields are required.");
                out.print(errorResponse.toString());
                return;
            }

            // Database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaIsoft_DB", "root", "root");

            // Insert the student into the database
            String query = "INSERT INTO students (student_id, student_name, student_age, email, password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, student.getStudentId());
            pst.setString(2, student.getStudentName());
            pst.setInt(3, student.getStudentAge());
            pst.setString(4, student.getEmail());
            pst.setString(5, student.getPassword());

            ObjectNode jsonResponse = mapper.createObjectNode();
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                jsonResponse.put("status", "success");
                jsonResponse.put("message", "Registration successful!");
            } else {
                jsonResponse.put("status", "failure");
                jsonResponse.put("message", "Registration failed. Please try again.");
            }

            out.print(jsonResponse.toString());
            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            ObjectNode errorResponse = mapper.createObjectNode();
            errorResponse.put("status", "error");
            errorResponse.put("message", "An error occurred: " + e.getMessage());
            out.print(errorResponse.toString());
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter out = response.getWriter();

        try {
            // Database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/JavaIsoft_DB", "root", "root");

            // Fetch all students from the database
            String query = "SELECT student_id, student_name, student_age, email, password FROM students";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            // Create a list to hold student objects
            ArrayList<Student> students = new ArrayList<>();

            // Iterate through the result set and add students to the list
            while (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getInt("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setStudentAge(rs.getInt("student_age"));
                student.setEmail(rs.getString("email"));
                student.setPassword(rs.getString("password"));
                students.add(student);
            }

            // Convert the list of students to JSON and send the response
            String jsonResponse = mapper.writeValueAsString(students);
            out.print(jsonResponse);

            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();

            // Send error response in JSON format
            ObjectNode errorResponse = mapper.createObjectNode();
            errorResponse.put("status", "error");
            errorResponse.put("message", "An error occurred: " + e.getMessage());
            out.print(errorResponse.toString());
        }
    }
}
