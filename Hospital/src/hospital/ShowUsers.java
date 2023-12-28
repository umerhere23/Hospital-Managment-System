/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author omerj
 */
public class ShowUsers  extends Hospital{
   public String fetchAllPatients() {
    String patientsData = "";
    try (Connection conn = getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM Patient")) {
        while (rs.next()) {
            int patientId = rs.getInt("patient_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String address = rs.getString("address");
            String phone = rs.getString("phone");
            String dob = rs.getString("dob");
            int gpId = rs.getInt("gp_id");
           String patientDetails = "---------------------------\n" + 
                                    "Patient ID: " + patientId + 
                                    "\n First Name: " + firstName + 
                                    "\n Last Name: " + lastName + 
                                    "\n Address: " + address + 
                                    "\n Phone: " + phone + 
                                    "\n DOB: " + dob + 
                                    "\n GP ID: " + gpId +
                                    "\n---------------------------\n";
            patientsData += patientDetails;        }
    } catch (SQLException e) {
        System.err.println("Error fetching patients: " + e.getMessage());
    }
    return patientsData;
}
   public String fetchAllGPs() {
    String gpData = "";
    try (Connection conn = getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM GP")) {
        while (rs.next()) {
            int gpId = rs.getInt("gp_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String address = rs.getString("address");
            String phone = rs.getString("phone");
            String gpDetails = "---------------------------\n" + 
                                "GP ID: " + gpId + 
                                "\n First Name: " + firstName + 
                                "\n Last Name: " + lastName + 
                                "\n Address: " + address + 
                                "\n Phone: " + phone + 
                                "\n---------------------------\n";
            gpData += gpDetails;
        }
    } catch (SQLException e) {
        System.err.println("Error fetching GPs: " + e.getMessage());
    }
    return gpData;
}
   public String fetchAllDoctors() {
    String doctorsData = "";
    try (Connection conn = getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM doctor")) {
        while (rs.next()) {
            int doctorId = rs.getInt("doctor_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String address = rs.getString("address");
            String phone = rs.getString("phone");
            String specialty = rs.getString("specialty");
            String doctorDetails = "---------------------------\n" + 
                                    "Doctor ID: " + doctorId + 
                                    "\n First Name: " + firstName + 
                                    "\n Last Name: " + lastName + 
                                    "\n Address: " + address + 
                                    "\n Phone: " + phone + 
                                    "\n Specialization: " + specialty +
                                    "\n---------------------------\n";
            doctorsData += doctorDetails;
        }
    } catch (SQLException e) {
        System.err.println("Error fetching doctors: " + e.getMessage());
    }
    return doctorsData;
}
   public String fetchAllConsultants() {
    String consultantsData = "";
    try (Connection conn = getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM Consultant")) {
        while (rs.next()) {
            int consultantId = rs.getInt("consultant_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String address = rs.getString("address");
            String phone = rs.getString("phone");
            String specialty = rs.getString("specialty");
            String consultantDetails = "---------------------------\n" + 
                                    "Consultant ID: " + consultantId + 
                                    "\n First Name: " + firstName + 
                                    "\n Last Name: " + lastName + 
                                    "\n Address: " + address + 
                                    "\n Phone: " + phone + 
                                    "\n specialty: " + specialty +
                                    "\n---------------------------\n";
            consultantsData += consultantDetails;
        }
    } catch (SQLException e) {
        System.err.println("Error fetching consultants: " + e.getMessage());
    }
    return consultantsData;
}
}
