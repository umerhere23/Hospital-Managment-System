/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

/**
 *
 * @author omerj
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Addrecord extends Hospital {
    public boolean addNewPatient(int patient_id,String firstName, String lastName, String address, String phone, String dob, int gpId,String password) {
        boolean success = false;
        String sql = "INSERT INTO Patient ( patient_id,first_name, last_name, address, phone, dob, gp_id,password) VALUES (?,?, ?, ?, ?, ?, ?,?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                        pstmt.setInt(1, patient_id);

            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, address);
            pstmt.setString(5, phone);
            pstmt.setString(6, dob);
            pstmt.setInt(7, gpId);
            pstmt.setString(8, password);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
                System.out.println("New patient added successfully");
            } else {
                System.out.println("Failed to add new patient");
            }
        } catch (SQLException e) {
            System.err.println("Error adding new patient: " + e.getMessage());
        }
        return success;
    }
   public boolean updatePatientRecord(String patient_Id, String firstName, String lastName, String address, String phone, String selectedDate, String gpId) {
    boolean success = false;
    String sql = "UPDATE Patient SET first_name=?, last_name=?, address=?, phone=?, dob=?, gp_id=? WHERE patient_id=?";
    try (Connection conn = getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, firstName);
        pstmt.setString(2, lastName);
        pstmt.setString(3, address);
        pstmt.setString(4, phone);
        pstmt.setString(5, selectedDate);
        pstmt.setString(6, gpId);
        pstmt.setString(7, patient_Id);
        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            success = true;
            System.out.println("Patient record updated successfully");
        } else {
            System.out.println("Failed to update patient record");
        }
    } catch (SQLException e) {
        System.err.println("Error updating patient record: " + e.getMessage());
    }
    return success;
}


}
