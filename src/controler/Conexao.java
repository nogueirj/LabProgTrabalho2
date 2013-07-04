/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author julio.nogueira
 */
public class Conexao {
    private static Connection connection;
    
    private Conexao(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/hoteldb","root","chocolate25");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexao"+ ex.getErrorCode());
        }
    }
    
    public static synchronized Connection getInstance(){
        if (connection == null){
            new Conexao();
        }
        return connection;
    }
    
}