/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class for creating (inserting) a player record in the database.
 * 
 * @author Kevin Esguerra Cardona
 */
public class Create {

    public static void toInsert(String name, String subscriptionType) {
        // Validate the name before proceeding
        if (!isValidName(name)) {
            throw new IllegalArgumentException("Invalid name format. Please provide a complete person name.");
        }
        
        // Validate the status before proceeding
        if (!isValidStatus(subscriptionType)) {
            throw new IllegalArgumentException("Invalid status value. Please provide a valid status value.");
        }
        
        // Validate the amount of players
        if (!isValidPlayerAmount()) {
            throw new IllegalStateException("Cannot add more players. The maximum limit (20) has been reached.");
        }
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Obtener la conexión utilizando el método de la clase Connector
            connection = Connector.getConnection();

            // Consulta SQL para insertar un nuevo registro
            String sqlInsert = "INSERT INTO players (Name, SubscriptionType) VALUES (?, ?)";

            // Crear una declaración preparada
            preparedStatement = connection.prepareStatement(sqlInsert);

            // Configurar los parámetros
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, subscriptionType);

            // Ejecutar la declaración
            int filasAfectadas = preparedStatement.executeUpdate();

            // Verificar si la inserción fue exitosa
            if (filasAfectadas <= 0) {
                throw new SQLException("Record was not created");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la declaración y la conexión
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Validation method for the name field
    private static boolean isValidName(String name) {
        // Simple validation for a complete person name (can be adjusted based on requirements)
        return name != null && name.matches("^[A-Za-z]+\\s+[A-Za-z]+(\\s+[A-Za-z]+)*\\s*$");
    }

    // Validation method for the status field
    private static boolean isValidStatus(String subscriptionType) {
        return subscriptionType.toLowerCase().equals("frequent") || subscriptionType.toLowerCase().equals("occasional");
    }

    // Validation method for the amount of players
    private static boolean isValidPlayerAmount() {
        int currentPlayers = Recover.getPlayerCount();
        return currentPlayers < 20; // Check if the player count is less than 20
    }
}
