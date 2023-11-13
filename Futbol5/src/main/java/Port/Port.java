/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Port;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Kevin Esguerra Cardona
 */
public abstract class Port {
    protected Connection port;

    public Port() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/futbol5";
            String username = "root";
            String password = "";

            port = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("DB Connector Error (1)"); // Agregar cod (1) de error a la documentación "readme.md"
        } catch (SQLException e) {
            System.out.println("DB Connection Error: " + e.getMessage());
        }
    }
}
