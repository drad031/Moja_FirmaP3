/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moja_firma.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import moja_firma.utility.Pomocno;

/**
 *
 * @author Dubravka
 */
public class SatNit extends  Thread{
      
    JLabel datum;
    
    public SatNit( JLabel datum){
        this.datum=datum;
    }

    public void run() {
        SimpleDateFormat df = new SimpleDateFormat(Pomocno.FORMAT_DATUM_VRIJEME);
                while (true) {
                    try {
                        datum.setText(df.format(new Date()));
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Izbornik.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
    }
    
}
