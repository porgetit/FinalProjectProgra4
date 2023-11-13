/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Port;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Kevin Esguerra Cardona
 */
public class Create extends Port {
    
    private String sqlStatement;
    
    public Create() throws SQLException {
        super();
        sqlStatement = "INSERT INTO Players (name, email, matches, absences, infractions) VALUES (?, ?, 0, 0, 0)";
    }
    
    public void toInsert(String name, String email) throws SQLException {
        PreparedStatement pst = port.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, name);
        pst.setString(2, email);
        pst.executeUpdate();
        
        // Obteniendo la clave primaria generada (ID) si es necesario
        ResultSet generatedKeys = pst.getGeneratedKeys();
        if (generatedKeys.next()) {
            int id = generatedKeys.getInt(1); // ID generado
            System.out.println("Registro insertado con ID: " + id);
        }
    }
    
}
