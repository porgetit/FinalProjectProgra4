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
public class Delete {
    public static void toDelete(int Id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            // Obtener la conexión de la clase Connector
            connection = Connector.getConnection();
            
            // Consulta SQL para eliminar un registro
            String sqlDelete = "DELETE FROM players WHERE players.ID = ?";
            
            // Crear una declaración preparada
            preparedStatement = connection.prepareStatement(sqlDelete);
            
            // Configurar los parámetros
            preparedStatement.setString(1, String.valueOf(Id));
            
            // Ejecutar la declaración
            int filasAfectadas = preparedStatement.executeUpdate();
            
            // Verificar si la eliminación fu exitosa
            if (filasAfectadas <= 0) {
                throw new SQLException("The record was not deleted");
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
}
