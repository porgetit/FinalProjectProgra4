/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Kevin Esguerra Cardona
 */
public class Connector {

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        String jdbcUrl = "jdbc:mysql://localhost/futbol5";
        String user = "root";
        String pass = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            // Manejar la excepción apropiadamente, lanzar o registrar
            throw new SQLException("Error al obtener la conexión", e);
        }

        return connection;
    }
}
