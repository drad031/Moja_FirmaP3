/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moja_firma.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import moja_firma.model.Materijal;
import moja_firma.utility.Baza;

/**
 *
 * @author Dubravka
 */
public class ObradaMaterijala {
    
      private PreparedStatement komanda;
    
     public List<Materijal> dohvati(String uvjet){
         List<Materijal> l = new ArrayList<>();
         try {
             komanda = Baza.getVeza().prepareStatement("select * from materijal where nazivmat like ?");
             komanda.setString(1, "%" + uvjet + "%");
             
                  ResultSet rs = komanda.executeQuery();
            Materijal o;
            while (rs.next()) {
                o = new Materijal();               
                o.setSifra(rs.getInt("sifra"));                
                 o.setNaziv(rs.getString("nazivmat"));
                 o.setDobavljac(rs.getString("dobavljac"));
                 o.setCijenamat(rs.getBigDecimal("cijenamat"));
                 o.setKolicina(rs.getBigDecimal("kolicinamat"));
                  try {
                     o.setDatumkupnje(new Date(rs.getDate("datumkupnje").getTime()));
                } catch (Exception e) {
                    o.setDatumkupnje(null);
                }
               
                 l.add(o);
             }
               

        } catch (Exception e) {
            Logger.getLogger(ObradaMaterijala.class.getName()).log(Level.SEVERE, null, e);
        }

        return l;
    }    
    
        public List<Materijal> dohvatiPoSifriProizvoda(int sifra) {
       List<Materijal> l = new ArrayList<>();
         try {
             komanda = Baza.getVeza().prepareStatement("select a.* from materijal a inner join clan b on "
                     + "a.sifra=b.materijal where b.proizvod=?");
             komanda.setInt(1, sifra);
                ResultSet rs = komanda.executeQuery();
            Materijal o;
            while (rs.next()) {
                o = new Materijal();               
                o.setSifra(rs.getInt("sifra"));                
                 o.setNaziv(rs.getString("nazivmat"));
                 o.setDobavljac(rs.getString("dobavljac"));
                 o.setCijenamat(rs.getBigDecimal("cijenamat"));
                 o.setKolicina(rs.getBigDecimal("kolicinamat"));
                  try {
                     o.setDatumkupnje(new Date(rs.getDate("datumkupnje").getTime()));
                } catch (Exception e) {
                    o.setDatumkupnje(null);
                }
               
                 l.add(o);
             }              
       
           
        } catch (Exception e) {
            Logger.getLogger(ObradaMaterijala.class.getName()).log(Level.SEVERE, null, e);
        }

        return l;
    }
             
     
      
     public Materijal dodaj(Materijal o){
          try {
               Connection veza = Baza.getVeza();
            veza.setAutoCommit(false);
             komanda = Baza.getVeza().prepareStatement("insert into materijal (nazivmat,dobavljac,"
                     + "cijenamat,kolicinamat,datumkupnje"
                     + ") values (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
             
          komanda.setString(1, o.getNaziv());
             komanda.setString(2, o.getDobavljac());
             komanda.setBigDecimal(3,o.getCijenamat());
             komanda.setBigDecimal(4, o.getKolicina());
                if(o.getDatumkupnje()==null){
                komanda.setDate(5, null);
            }else{
                 komanda.setDate(5,new java.sql.Date(o.getDatumkupnje().getTime()));
            }
                        
             komanda.executeUpdate();          
              ResultSet rs = komanda.getGeneratedKeys();
                rs.next();
                o.setSifra(rs.getInt(1));

         } catch (Exception e) {
              Logger.getLogger(ObradaMaterijala.class.getName()).log(Level.SEVERE, null, e);
         } 
         return o;
     }
     
     public boolean promjeni(Materijal o){
         boolean vrati=false;
         try {
             
                  komanda = Baza.getVeza().prepareStatement("update materijal set  nazivmat=?, "
                          + "dobavljac=?, "
                     + "cijenamat=?, kolicinamat=?, datumkupnje=?  where sifra=?");
             komanda.setInt(1, o.getSifra());           
            komanda.setString(2, o.getNaziv());
             komanda.setString(3, o.getDobavljac());
             komanda.setBigDecimal(4,o.getCijenamat());
             komanda.setBigDecimal(5, o.getKolicina());
            
            if(o.getDatumkupnje()==null){
                komanda.setDate(6, null);
            }else{
                komanda.setDate(6,new java.sql.Date(o.getDatumkupnje().getTime()));
            }
                             
                         
             if(komanda.executeUpdate()==1){
                 vrati=true;
             }
             

         } catch (Exception e) {
              Logger.getLogger(ObradaMaterijala.class.getName()).log(Level.SEVERE, null, e);
         } 
         
         
         return vrati;
     }
     
     public boolean obrisi(Materijal o){
          boolean vrati=false;
         try {
                  komanda = Baza.getVeza().prepareStatement("delete from materijal "
                          + " where sifra=?");
             komanda.setInt(1, o.getSifra()); 
             if(komanda.executeUpdate()==1){
                 vrati=true;
             }
         } catch (Exception e) {
              Logger.getLogger(ObradaMaterijala.class.getName()).log(Level.SEVERE, null, e);
         } 
         return vrati;
     }

   
}

    

