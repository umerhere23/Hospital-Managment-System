/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author omerj
 */
public class DeletUser extends Hospital{
 public boolean deleteRecord(String userType, int userId) {
    boolean success = false;
    String tableName = "";
    String idColumnName = "";
    
    // Determine the table name and ID column name based on the user type
    switch (userType) {
        case "Patient":
            tableName = "Patient";
            idColumnName = "patient_id";
            break;
        case "Consultant":
            tableName = "Consultant";
            idColumnName = "consultant_id";
            break;
        case "Doctor":
            tableName = "Doctor";
            idColumnName = "doctor_id";
            break;
        case "GP":
            tableName = "GP";
            idColumnName = "gp_id";
            break;
        default:
            System.err.println("Invalid user type");
            return false;
    }
    
    // Delete the record from the database using a prepared statement
    String sql = "DELETE FROM " + tableName + " WHERE " + idColumnName + "=?";
    try (Connection conn = getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, userId);
        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            success = true;
            JOptionPane.showMessageDialog(null, "Record deleted successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Record not found");
        }
    } catch (SQLException e) {
        System.err.println("Error deleting record: " + e.getMessage());
    }
    
    return success;
}   
}
