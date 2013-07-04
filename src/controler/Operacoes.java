/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Júlio
 */
public class Operacoes {
    public static Date formatarData(String stg01){
        Date date = null;
        DateFormat formato;
        try {
            formato = new SimpleDateFormat("dd/MM/yyyy");
            date = new Date(formato.parse(stg01).getTime());
            return date;
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro na formatação de data", "Erro Data", JOptionPane.ERROR_MESSAGE);
        }
        return date;
    }    
    public static String formataInverso(Date dateS){
        String data = dateS.toString();
        StringTokenizer token = new StringTokenizer(data, "-");
        String ano = token.nextToken();
        String mes = token.nextToken();
        String dia = token.nextToken();
        String dataF = dia+"/"+mes+"/"+ano;
        return dataF;
    }
}