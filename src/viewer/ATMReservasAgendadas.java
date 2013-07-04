/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viewer;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.TabelaReserva;

/**
 *
 * @author Júlio
 */
public class ATMReservasAgendadas extends AbstractTableModel{
    
    public List<TabelaReserva> list;
    
    public ATMReservasAgendadas(List list){
        this.list = list;
    }
    
    final String columnName [] = {"ID","Nome Visitante","Email","Quarto","Data de Entrada"};

    @Override
    public String getColumnName(int column) {
        return columnName[column]; 
    }
    
      
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return list.get(rowIndex).getId();
            case 1: return list.get(rowIndex).getVisitante();
            case 2: return list.get(rowIndex).getEmail();
            case 3: return list.get(rowIndex).getQuarto();
            case 4: return list.get(rowIndex).getData_entrada();
        }
        return null;
    }
    
}
