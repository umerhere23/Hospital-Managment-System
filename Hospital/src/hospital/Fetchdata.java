/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author omerj
 */
public class Fetchdata extends Hospital {
   public String fetchPatientData(int patient_Id) {
    String patientsData = "";
    try (Connection conn = getConnection();
         PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Patient WHERE patient_id=?")) {
        pstmt.setInt(1, patient_Id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String address = rs.getString("address");
            String phone = rs.getString("phone");
            String dob = rs.getString("dob");
            int gpId = rs.getInt("gp_id");
            String patientDetails = "---------------------------\n" + 
                                    "Patient ID: " + patient_Id + 
                                    "\n First Name: " + firstName + 
                                    "\n Last Name: " + lastName + 
                                    "\n Address: " + address + 
                                    "\n Phone: " + phone + 
                                    "\n DOB: " + dob + 
                                    "\n GP ID: " + gpId +
                                    "\n---------------------------\n";
            patientsData += patientDetails;
        } else {
            System.out.println("No patient found with ID " + patient_Id);
        }
    } catch (SQLException e) {
        System.err.println("Error fetching patient: " + e.getMessage());
    }
    return patientsData;
}

}
