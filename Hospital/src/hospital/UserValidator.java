/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

/**
 *
 * @author Administrator
 */
import java.sql.*;

public class UserValidator extends Hospital{
 public static boolean validateAdmin(String name, String pass) {
        // Set the database credentials
        String url = "jdbc:mysql://localhost:3306/hospital";
        String user = "root";
        String password = "";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Create a connection to the database
            Connection conn = DriverManager.getConnection(url, user, password);

            // Prepare a statement to query the database for the admin's name and id
            String sql = "SELECT * FROM admin WHERE name=? AND password=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, pass);

            // Execute the query and check if any results were returned
            ResultSet result = statement.executeQuery();
            boolean isValid = result.next();

            // Close the connection and return the result
            conn.close();
            return isValid;

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found.");
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }

        // If an exception occurred or no results were returned, return false
        return false;
    }
public boolean validatePatient(int patient_Id, String password) {
    boolean isValid = false;
    String query = "SELECT * FROM Patient WHERE patient_id=? AND password=?";
    try (Connection conn = getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setInt(1, patient_Id);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();
        isValid = rs.next();
    } catch (SQLException e) {
        System.err.println("Error validating patient: " + e.getMessage());
    }
    return isValid;
}
}
