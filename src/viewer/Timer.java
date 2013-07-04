/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viewer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Júlio
 */
public class Timer extends Thread {
    public JLabel label;
    private Date date;
    private DateFormat formato;
    
    public Timer(){
        label = new JLabel();
        formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    }
    
    @Override
    public void run(){
        while(true){
            try{
                date = new Date();
                label.setText(formato.format(date));
                Timer.sleep(1000);
            }catch(InterruptedException e){
                JOptionPane.showMessageDialog(null, "Erro no relógio do sistema", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
}
