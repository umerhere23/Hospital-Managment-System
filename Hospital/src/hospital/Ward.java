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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ward extends Hospital {
    public String fetchAllWards() {
    String wardsData = "";
    try (Connection conn = getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM Ward")) {
        while (rs.next()) {
            int wardId = rs.getInt("ward_id");
            String name = rs.getString("name");
            int hospitalId = rs.getInt("hospital_id");
            wardsData += "---------------\n Ward ID: " + wardId + "\n Name: " + name + "\n Hospital ID: " + hospitalId + "\n-------------";
        }
    } catch (SQLException e) {
        System.err.println("Error fetching wards: " + e.getMessage());
    }
    return wardsData;
}
}