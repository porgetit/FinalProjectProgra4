/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author 57312
 */
public class Update {
    public static void toUpdate(int Id, String Name, String SubscriptionType){
        // Validate the name before proceeding
        if (!isValidName(Name)) {
            throw new IllegalArgumentException("Invalid name format. Please provide a complete person name.");
        }
        
        // Validate the status before proceeding
        if (!isValidStatus(SubscriptionType)) {
            throw new IllegalArgumentException("Invalid status value. Please provide a valid status value.");
        }
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            // Obtener la conexión utilizando el método de la clase Connector
            connection = Connector.getConnection();
            
            // Consulta SQL para actualizar un nuevo registro
            String sqlUpdate = "UPDATE players SET Name = ?, SubscriptionType = ? WHERE players.ID = ?";
            
            // Crear una declaración preparada
            preparedStatement = connection.prepareStatement(sqlUpdate);
            
            // Validar parámetros (puedes ajustar según la lógica de tu aplicación)
            if (Name != null && SubscriptionType != null) {
                // Configurar parámetros
                preparedStatement.setString(1, Name);
                preparedStatement.setString(2, SubscriptionType);
                preparedStatement.setInt(3, Id);
                
                // Ejecutar la declaración
                int filasAfectadas = preparedStatement.executeUpdate();
                
                // Verificar si la actualización fue exitosa
                if (filasAfectadas <= 0) {
                    throw new SQLException("No se actualizó el registro");
                }
            } else {
                throw new IllegalArgumentException("Name y SubscriptionType no pueden ser nulos");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Re-lanzar la excepción para que sea manejada en un nivel superior si es necesario
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

    private static boolean isValidStatus(String subscriptionType) {
        return subscriptionType.toLowerCase().equals("frequent") || subscriptionType.toLowerCase().equals("occasional");
    }
}
