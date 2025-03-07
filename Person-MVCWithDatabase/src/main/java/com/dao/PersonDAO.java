package com.dao;

import com.model.Person;
import com.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDAO {

    public void savePerson(Person person) {
        String query = "INSERT INTO persons (name, age, phoneNumber, emailId, bloodGroup) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, person.getName());
            stmt.setInt(2, person.getAge());
            stmt.setString(3, person.getPhoneNumber());
            stmt.setString(4, person.getEmailId());
            stmt.setString(5, person.getBloodGroup());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
