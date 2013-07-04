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
import model.Usuario;

/**
 *
 * @author julio.nogueira
 */
public class UsuarioDAO {
    
    private Connection connection = Conexao.getInstance();
    
    public boolean verficaUsuario(Usuario u){
        String sql = "SELECT * FROM USUARIO WHERE LOGIN = ? AND PASSWORD = ?";
        PreparedStatement pstmt;
        ResultSet rs;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, u.getLogin());
            pstmt.setString(2, u.getPassword());
            rs = pstmt.executeQuery();
            while(rs.next()){
                JOptionPane.showMessageDialog(null, "Bem-Vindo");
                return true;
            }
            pstmt.close();
            JOptionPane.showMessageDialog(null, "Dados inválidos ou usuário inexistente", "Confirme os dados", JOptionPane.WARNING_MESSAGE);
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro, contate o Administrador", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    public Usuario selectUsuario(int i){
        String sql = "SELECT * FROM USUARIO WHERE IDUSUARIO = ?";
        PreparedStatement pstmt;
        ResultSet rs;
        Usuario u = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, i);
            rs = pstmt.executeQuery();
            while (rs.next()) {                
                u = new Usuario();
                u.setIdUsuario(rs.getInt(1));
                u.setLogin(rs.getString(2));
                u.setPassword(rs.getString(3));
            }
            pstmt.close();
            return u;
        } catch (Exception e) {
        }
        return null;
    }
    public void removeUsuario(Usuario u){
        String sql = "DELETE FROM USUARIO WHERE IDUSUARIO = ?";
        PreparedStatement pstmt;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, u.getIdUsuario());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Usuário deletado", "Delete", JOptionPane.INFORMATION_MESSAGE);
            pstmt.close();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Não foi possível realizar a deleção", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void updateUsuario(Usuario u){
      String sql = "UPDATE USUARIO SET LOGIN = ?, PASSWORD =? WHERE IDUSUARIO = ?";
      PreparedStatement pstmt;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, u.getLogin());
            pstmt.setString(2, u.getPassword());
            pstmt.setInt(3, u.getIdUsuario());
            pstmt.execute();
            pstmt.close();
            JOptionPane.showMessageDialog(null, "Usuário Alterado com sucesso","Atualização", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Não foi possível realizar a atualização", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
      
    }
    public void insertUsuario(Usuario u){
        String sql = "INSERT INTO USUARIO VALUES (NULL, ?, ?)";
        PreparedStatement pstmt;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, u.getLogin());
            pstmt.setString(2, u.getPassword());
            pstmt.execute();
            pstmt.close();
            JOptionPane.showMessageDialog(null, "Usuário inserido com sucesso","Inserção", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Não foi possível realizar a atualização", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}