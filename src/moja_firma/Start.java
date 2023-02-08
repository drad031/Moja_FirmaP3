/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moja_firma;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import moja_firma.view.Autorizacija;
import moja_firma.view.Pozdrav;

/**
 *
 * @author Dubravka
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          SimpleDateFormat df = new SimpleDateFormat("dd.MM.YYYY.");
         try {
             Date sad = new Date();
             String s = df.format(sad);
             System.out.println(s);
             Date d = df.parse(s);
                 
            System.out.println(df.format(d));
        } catch (ParseException ex) {
            //Logger.getLogger(Klijenti.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Pozdrav().setVisible(true);
    }
    
}
