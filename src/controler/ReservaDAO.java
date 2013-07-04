/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Reserva;
import model.TabelaReserva;

/**
 *
 * @author julio.nogueira
 */
public class ReservaDAO {
    private Connection connection = Conexao.getInstance();
    
        public void insertReserva(Reserva r){
        String sql = "INSERT INTO RESERVA (IDVISITANTE, IDQUARTO, DATA_ENTRADA, DATA_SAIDA, PAGAMENTO, STATUS, OBSERVACAO) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, r.getIdVisitante());
            pstmt.setInt(2, r.getIdQuarto());
            pstmt.setDate(3, r.getData_entrada());
            pstmt.setDate(4, r.getData_saida());
            pstmt.setDouble(5, r.getPagamento());
            pstmt.setBoolean(6, r.isStatus());
            pstmt.setString(7, r.getObservacao());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Reserva inserida com sucesso", "Inserção", JOptionPane.INFORMATION_MESSAGE);
            pstmt.close();
        } catch (SQLException e) {
            
        }
    }
    public void cancelReserva(TabelaReserva tr){
        String sql = "DELETE FROM RESERVA WHERE CODRESERVA = ?";
        PreparedStatement pstmt;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, tr.getId());
            pstmt.execute();
            pstmt.close();
            JOptionPane.showMessageDialog(null, "Reserva cancelada com sucesso", "Cancelamento de Reserva", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List selectReserva(){
        String sql = "SELECT R.CODRESERVA, V.NOME, V.EMAIL, R.IDQUARTO, R.DATA_ENTRADA "
                + "FROM VISITANTE V, RESERVA R "
                + "WHERE R.IDVISITANTE = V.IDVISITANTE";
        PreparedStatement pstmt;
        ResultSet rs;
        List<TabelaReserva> list = new ArrayList<>();
        try{
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
               TabelaReserva t = new TabelaReserva();
               t.setId(rs.getInt(1));
               t.setVisitante(rs.getString(2));
               t.setEmail(rs.getString(3));
               t.setQuarto(rs.getInt(4));
               t.setData_entrada(rs.getDate(5));
               list.add(t);
            }
            return list;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro na seleção"+e.getErrorCode(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return null;
        
    }
}
