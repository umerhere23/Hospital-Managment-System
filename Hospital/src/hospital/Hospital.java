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
import java.sql.SQLException;

public class Hospital {
    private final String url = "jdbc:mysql://localhost:3306/hospital";
    private final String username = "root";
    private final String password = "";
    
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}

