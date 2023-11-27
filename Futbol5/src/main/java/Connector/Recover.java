/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connector;

import Models.Player;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class for recovering (querying) data from the database.
 * 
 * @author Kevin Esguerra Cardona
 */
public class Recover {
    
    public static Player toSelectByID(int Id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Player player = new Player();
        
        try {
            // Obtener la conexion utilizando el método de la clase Connector
            connection = Connector.getConnection();
            
            // Consulta SQL para obtener un registro por ID
            String sqlSelect = "SELECT * FROM players WHERE ID = ?";
            
            // Crear una declaración preparada
            preparedStatement = connection.prepareStatement(sqlSelect);
            
            // Configurar los parámetros
            preparedStatement.setString(1, String.valueOf(Id));
            
            // Ejecutar la declaración
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                // Obtener datos
                String name = resultSet.getString("Name");
                String subscriptionType = resultSet.getString("SubscriptionType");
                
                // Cargar los datos en la clase Player
                player.setId(Id);
                player.setName(name);
                player.setSubscriptionType(subscriptionType);
            } else {
                // Lanzar una excepción si no se encuentra el registro
                throw new SQLException("No record found with ID: " + Id);
            }
            
        } catch (SQLException e) {
        } finally {
            // Cerra la conexión y la declaración
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
        
        return player;
    }
    
    // New method to retrieve the count of players
    public static int getPlayerCount() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Obtener la conexión utilizando el método de la clase Connector
            connection = Connector.getConnection();

            // Consulta SQL para obtener la cantidad actual de jugadores
            String sqlCountPlayers = "SELECT COUNT(*) AS playerCount FROM players";

            // Crear una declaración preparada
            preparedStatement = connection.prepareStatement(sqlCountPlayers);

            // Ejecutar la declaración
            resultSet = preparedStatement.executeQuery();

            // Obtener la cantidad actual de jugadores
            if (resultSet.next()) {
                return resultSet.getInt("playerCount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión y la declaración
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
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

        return 0; // Return 0 if an error occurs
    }
}
