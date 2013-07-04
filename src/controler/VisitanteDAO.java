/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Visitante;

/**
 *
 * @author julio.nogueira
 */
public class VisitanteDAO {
    private Connection connection = Conexao.getInstance();
    
    public void insertVisitante(Visitante v){
        String sql = "INSERT INTO VISITANTE (NOME, TELEFONE, EMAIL) VALUES (?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, v.getNome());
            pstmt.setString(2, v.getTelefone());
            pstmt.setString(3, v.getEmail());
            pstmt.execute();      
            JOptionPane.showMessageDialog(null, "Visitante inserido com sucesso", "OK", JOptionPane.INFORMATION_MESSAGE);
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void removeVisitante(Visitante v){
        String sql = "DELETE FROM VISITANTE WHERE NOME = ? AND TELEFONE = ? AND EMAIL = ?";
        PreparedStatement pstmt;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, v.getNome());
            pstmt.setString(2, v.getTelefone());
            pstmt.setString(3, v.getEmail());
            pstmt.execute();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateVisitante(Visitante v){
        String sql = "UPDATE VISITANTE SET NOME = ?, TELEFONE = ?, EMAIL = ? WHERE IDVISTANTE = ?";
        PreparedStatement pstmt;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, v.getNome());
            pstmt.setString(2, v.getTelefone());
            pstmt.setString(3, v.getEmail());
            pstmt.setInt(4, v.getIdVisitante());
            pstmt.execute();
            pstmt.close();
        } catch (Exception e) {
        }
    }
    public int selectVisitante(Visitante v){
        String sql = "SELECT IDVISITANTE FROM VISITANTE WHERE NOME = ? AND TELEFONE = ? AND EMAIL = ?";
        PreparedStatement pstmt;
        ResultSet rs;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, v.getNome());
            pstmt.setString(2, v.getTelefone());
            pstmt.setString(3, v.getEmail());
            rs = pstmt.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
//    public ArrayList<String> selectVisitante(String stg01){
//        String sql ="SELECT NOME FROM VISITANTE WHERE NOME LIKE = ?";
//        PreparedStatement pstmt;
//        ResultSet rs;
//        ArrayList<String> arrayNome = null;
//        try{
//            pstmt = connection.prepareStatement(sql);
//            pstmt.setString(1, stg01+"%");
//            rs = pstmt.executeQuery();
//            while (rs.next()) {
//                arrayNome = new ArrayList<String>();
//                arrayNome.add(rs.getString(1));
//            }
//            return arrayNome;
//        }catch(SQLException e){
//            JOptionPane.showMessageDialog(null, "Erro na seleção dos nomes existentes no banco", "Erro", JOptionPane.ERROR_MESSAGE);
//        }
//        return null;
//    }
}
