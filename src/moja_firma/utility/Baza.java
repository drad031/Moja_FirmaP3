/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moja_firma.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dubravka
 */
public class Baza {
    
    private static Connection veza;
    
    public static Connection getVeza(){
        if(veza==null){
            System.out.println("Spajam se na bazu");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                veza=DriverManager.getConnection("jdbc:mysql://localhost/moja_firma?"
              + "user=edunova&password=edunova&useUnicode=yes&characterEncoding=utf8");
            } catch (ClassNotFoundException | SQLException e) {
                Logger.getLogger(Baza.class.getName()).log(Level.SEVERE , null,e);
            }
        }
        try {
            if(veza.isClosed()){
                veza=null;
                getVeza();
            }
        } catch (SQLException e) {
             Logger.getLogger(Baza.class.getName()).log(Level.SEVERE , null,e);
        }
        return veza;
    }
    
}
