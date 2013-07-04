/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import model.Quarto;

/**
 *
 * @author Júlio
 */
public class QuartoDAO {
    private Connection connection;
    
    public QuartoDAO(){
        connection = Conexao.getInstance();
    }
    
    public Vector selectQuarto(){
        String SQL = "SELECT IDQUARTO FROM QUARTO";
        PreparedStatement pstmt;
        ResultSet rs;
        Vector<Integer> arrayQ = new Vector<>();
        try {
            pstmt = connection.prepareStatement(SQL);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                arrayQ.add(rs.getInt(1));
            }
            return arrayQ;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na Seleção", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    public Quarto selectQuarto(int i){
        String sql = "SELECT * FROM QUARTO WHERE IDQUARTO = ?";
        PreparedStatement pstmt;
        ResultSet rs;
        Quarto q = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, i);
            rs = pstmt.executeQuery();
            while(rs.next()){
                q = new Quarto();
                q.setIdQuarto(rs.getInt(1));
                q.setDescricaoQuarto(rs.getString(2));
                q.setTipo(rs.getInt(3));
                q.setCapacidade(rs.getInt(4));
            }
            pstmt.close();
            return q;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na Seleção", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
