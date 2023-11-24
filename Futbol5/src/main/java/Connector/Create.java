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
 * @author Kevin Esguerra Cardona
 */
public class Create {

    public static void toInsert(String name, String subscriptionType) {
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
}
