/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moja_firma.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import moja_firma.model.Osoba;
import moja_firma.utility.Baza;

/**
 *
 * @author Dubravka
 */
public class ObradaOsoblja {
    
      private PreparedStatement komanda;
    
      public List<Osoba> dohvati(String uvjet){
         List<Osoba> l = new ArrayList<>();
  
        try {
            komanda = Baza.getVeza().prepareStatement("select * from osoba where uloga = ?");
            komanda.setString(1,  uvjet );
            ResultSet rs = komanda.executeQuery();
            Osoba o;
            while(rs.next()){
                o=new Osoba();
                o.setUloga(rs.getString("uloga"));
                o.setSifraOsobe(rs.getInt("sifra"));
                o.setIme(rs.getString("ime"));
                o.setPrezime(rs.getString("prezime"));
                o.setKorisnicko_ime(rs.getString("korisnicko_ime"));
                o.setLozinkaMD5(rs.getString("lozinka"));
                o.setOib(rs.getString("oib"));
                o.setTelefon(rs.getString("telefon"));
                o.setMob(rs.getString("mob"));
                o.setAdresa(rs.getString("adresa"));
                o.setEmail(rs.getString("email"));
                o.setIban(rs.getString("iban"));
                o.setAktivan(rs.getBoolean("aktivan"));
                o.setPrimjedba(rs.getString("primjedba"));
                  try {
                     o.setDatumrodenja(new Date(rs.getDate("datumrodenja").getTime()));
                } catch (Exception e) {
                    o.setDatumrodenja(null);
                }
                l.add(o);
                
            }
        } catch (Exception e) {
              Logger.getLogger(ObradaOsoblja.class.getName()).log(Level.SEVERE, null, e);
        }        
        return l ;
    }
      /**
      * Metoda za provjeru korisničkog imena u bazi
      * @param korisnik tekst za koji vršimo provjeru
      * @return true ako korisnik ne postoji, false ako korisnik postoji
      */
     public boolean provjeraKorisnika(String korisnicko_ime){
         try {
             komanda = Baza.getVeza().prepareStatement("select sifra from osoba where korisnicko_ime=?");
             komanda.setString(1, korisnicko_ime);
             ResultSet rs = komanda.executeQuery();
             return !rs.next();
             
         } catch (Exception e) {
              Logger.getLogger(ObradaOsoblja.class.getName()).log(Level.SEVERE, null, e);
         }
         return false;
     }
     
     public Osoba dodaj(Osoba o){
         try {
             komanda = Baza.getVeza().prepareStatement("insert into osoba (uloga,korisnicko_ime,"
                     + " lozinka,ime,prezime,"
                     + " naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba)"
                     + " values (?,?,md5(?),?,?,?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
             komanda.setString(1, o.getUloga());
             komanda.setString(2, o.getKorisnicko_ime());
             komanda.setString(3, o.getLozinka());
             komanda.setString(4, o.getIme());
             komanda.setString(5, o.getPrezime());
             komanda.setString(6, o.getNaziv());
             komanda.setString(7,o.getOib());
             komanda.setString(8,o.getTelefon());
             komanda.setString(9, o.getMob());
             komanda.setString(10, o.getEmail());
             komanda.setString(11, o.getAdresa());
             komanda.setString(12, o.getIban());
              if(o.getDatumrodenja()==null){
                komanda.setDate(13, null);
            }else{
                 komanda.setDate(13,new java.sql.Date(o.getDatumrodenja().getTime()));
            }
             komanda.setBoolean(14, o.isAktivan());
             komanda.setString(15, o.getPrimjedba());
             komanda.executeUpdate(); 
             ResultSet rs = komanda.getGeneratedKeys();
             rs.next();
             o.setSifraOsobe(rs.getInt(1));
             
         } catch (Exception e) {
             Logger.getLogger(ObradaOsoblja.class.getName()).log(Level.SEVERE, null, e);
         }
         return o;
     }
     
     public boolean promijeni(Osoba o){
           boolean vrati = false;
         try {
          
             if(o.getLozinka().length()>0){
                 komanda = Baza.getVeza().prepareStatement("update osoba set korisnicko_ime=?, "
                         + " lozinka=md5(?),ime=?,prezime=?, naziv=?, oib=?, telefon=?, mob=?,"
                         + " email=?, adresa=?, iban=?, datumrodenja=?, aktivan=?, primjedba=?,"
                         + " uloga=? where sifra=?");
                 komanda.setInt(1, o.getSifraOsobe());
                 komanda.setString(2, o.getKorisnicko_ime());
                 komanda.setString(3, o.getLozinka());
                 komanda.setString(4, o.getIme());
                 komanda.setString(5, o.getPrezime());
                 komanda.setString(6, o.getNaziv());
                 komanda.setString(7,o.getOib());
                 komanda.setString(8,o.getTelefon());
                 komanda.setString(9, o.getMob());
                 komanda.setString(10, o.getEmail());
                 komanda.setString(11, o.getAdresa());
                 komanda.setString(12, o.getIban());
                 if(o.getDatumrodenja()==null){
                 komanda.setDate(13, null);
                 }else{
                 komanda.setDate(13,new java.sql.Date(o.getDatumrodenja().getTime()));
                 }
                 komanda.setString(14, o.getPrimjedba());
                 komanda.setBoolean(15, o.isAktivan());                 
                 komanda.setString(16, o.getUloga());
                 
           }else{
                 komanda = Baza.getVeza().prepareStatement("update osoba set korisnicko_ime=?, "
                         + " ime=?,prezime=?, naziv=?, oib=?, telefon=?, mob=?,"
                         + " email=?, adresa=?, iban=?, datumrodenja=?, aktivan=?, primjedba=?,"
                         + " uloga=? where sifra=?");
                 komanda.setString(1, o.getKorisnicko_ime());
                 komanda.setString(2, o.getIme());
                 komanda.setString(3, o.getPrezime());
                  komanda.setString(4, o.getNaziv());
                 komanda.setString(5,o.getOib());
                 komanda.setString(6,o.getTelefon());
                 komanda.setString(7, o.getMob());
                 komanda.setString(8, o.getEmail());
                 komanda.setString(9, o.getAdresa());
                 komanda.setString(10, o.getIban());
                 if(o.getDatumrodenja()==null){
                 komanda.setDate(11, null);
                 }else{
                 komanda.setDate(11,new java.sql.Date(o.getDatumrodenja().getTime()));
                 }
                 komanda.setString(12, o.getPrimjedba());
                 komanda.setBoolean(13, o.isAktivan());
                 komanda.setString(14, o.getUloga());
                 komanda.setInt(15, o.getSifraOsobe());
             
         }
             if (komanda.executeUpdate()==1) {
                 vrati= true;
                 
             }
             
         } catch (Exception e) {
              Logger.getLogger(ObradaOsoblja.class.getName()).log(Level.SEVERE, null, e);
             
         }return vrati;
     
     }
   
     public boolean obrisi(Osoba o){
         boolean vrati= false;
         try {
             komanda= Baza.getVeza().prepareStatement("delete from osoba where sifra=?");
             komanda.setInt(1, o.getSifraOsobe());
             if(komanda.executeUpdate()==1){
                 vrati= true;
                 
             }
         } catch (Exception e) {
               Logger.getLogger(ObradaOsoblja.class.getName()).log(Level.SEVERE, null, e);
         }
         return vrati;
     }
    
    
    
}
