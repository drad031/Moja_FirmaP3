/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moja_firma.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import moja_firma.model.Materijal;
import moja_firma.model.Proizvod;
import moja_firma.model.Rad;
import moja_firma.utility.Baza;

/**
 *
 * @author Dubravka
 */
public class ObradaProizvoda {
    
        private PreparedStatement komanda;

    public List<Proizvod> dohvati(String uvjet) {
        List<Proizvod> l = new ArrayList<>();
        try {
            komanda = Baza.getVeza().prepareStatement("select * from proizvod where nazivpr like ?");
             komanda.setString(1, "%" + uvjet + "%");
             
            
            ResultSet rs = komanda.executeQuery();
            Proizvod o;
          
            while (rs.next()) {
                o = new Proizvod();
                o.setSifra(rs.getInt("sifra"));
                o.setNazivpr(rs.getString("nazivpr"));
                o.setDimenzija(rs.getString("dimenzija"));
                o.setKolicina(rs.getString("kolicinapr"));
                o.setGrupaproizvoda(rs.getString("grupaproizvoda"));
                   try {
                     o.setDatumproizvodnje(new Date(rs.getDate("datumproizvodnje").getTime()));
                } catch (Exception e) {
                    o.setDatumproizvodnje(null);
                }
                   try {
                     o.setRokizrade(new Date(rs.getDate("rokizrade").getTime()));
                } catch (Exception e) {
                    o.setRokizrade(null);
                }
                o.setSirovinskisastav(rs.getString("sirovinskisastav"));
                o.setCijena(rs.getBigDecimal("cijena"));
                
        
                l.add(o);
            }  
            
             rs.close();
            ObradaMaterijala om =  new ObradaMaterijala();
            for (Proizvod proizvod : l) {
                proizvod.setMaterijali(om.dohvatiPoSifriProizvoda(proizvod.getSifra()));
            }
            
              rs.close();
            ObradaRada or =  new ObradaRada();
            for (Proizvod proizvod : l) {
               proizvod.setRadovi(or.dohvatiPoSifriProizvoda(proizvod.getSifra()));
            }
            
            
        } catch (Exception e) {
            Logger.getLogger(ObradaProizvoda.class.getName()).log(Level.SEVERE, null, e);
        }

        return l;
    }
    
    
       public Proizvod dodaj(Proizvod o) {
        try {
            Connection veza = Baza.getVeza();
            veza.setAutoCommit(false);
            komanda = veza.prepareStatement("insert into proizvod (nazivpr,dimenzija,kolicinapr, "
                    + " grupaproizvoda,datumproizvodnje,rokizrade, "
                    + " sirovinskisastav,cijena "
                    +") values (?,?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            komanda.setString(1, o.getNazivpr());
            komanda.setString(2, o.getDimenzija());
            komanda.setString(3, o.getKolicinapr());
            komanda.setString(4, o.getGrupaproizvoda());
              if(o.getDatumproizvodnje()==null){
                komanda.setDate(5, null);
            }else{
                 komanda.setDate(5,new java.sql.Date(o.getDatumproizvodnje().getTime()));
            }
                if(o.getRokizrade()==null){
                komanda.setDate(6, null);
            }else{
                 komanda.setDate(6,new java.sql.Date(o.getRokizrade().getTime()));
            }
            komanda.setString(7, o.getSirovinskisastav());
            komanda.setBigDecimal(8,o.getCijena());
            komanda.executeUpdate();
            
            ResultSet rs = komanda.getGeneratedKeys();
            rs.next();
            o.setSifra(rs.getInt(1));

            
            komanda = veza.prepareStatement("insert into clan (proizvod,materijal)"
                    + " values (?,?)");
            for (Materijal p  : o.getMaterijali()) {
            komanda.setInt(1, o.getSifra());
            komanda.setInt(2, p.getSifra());
            komanda.executeUpdate();
            }                  
             
            komanda = veza.prepareStatement("insert into clan1 (proizvod,rad)"
                    + " values (?,?)");
            for (Rad r  : o.getRadovi()) {
            komanda.setInt(1, o.getSifra());
            komanda.setInt(2, r.getSifra());
            komanda.executeUpdate();
            }                  
                    
            veza.commit();

        } catch (Exception e) {
            Logger.getLogger(ObradaProizvoda.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        return o;
    }
      public boolean promjeni(Proizvod o) {
        boolean vrati = false;
        try {
            Connection veza = Baza.getVeza();
            veza.setAutoCommit(false);
            komanda = veza.prepareStatement("update proizvod set  nazivpr=?,"
                    + " dimenzija=?, kolicinapr=?, grupaproizvoda=?, datumproizvodnje=?,"
                    + " rokizrade=?, sirovinskisastav=?, cijena=?"
                    + " where sifra=?");
            komanda.setInt(1, o.getSifra());
            komanda.setString(2, o.getNazivpr());
            komanda.setString(3, o.getDimenzija());
            komanda.setString(4, o.getKolicinapr());
            komanda.setString(5, o.getGrupaproizvoda());
            if(o.getDatumproizvodnje()==null){
                komanda.setDate(6, null);
            }else{
                komanda.setDate(6,new java.sql.Date(o.getDatumproizvodnje().getTime()));
            }
                  if(o.getRokizrade()==null){
                komanda.setDate(7, null);
            }else{
                komanda.setDate(7,new java.sql.Date(o.getRokizrade().getTime()));
            }
            komanda.setString(8, o.getSirovinskisastav());
            komanda.setBigDecimal(9,o.getCijena());
            
             if(komanda.executeUpdate()<1){
                vrati=false;
             }
            komanda = veza.prepareStatement("delete from clan where proizvod=?");
            komanda.setInt(1, o.getSifra());
            komanda.executeUpdate();
           
            komanda = veza.prepareStatement("insert into clan (proizvod,materijal) values (?,?)");
            for (Materijal p  : o.getMaterijali()) {
                komanda.setInt(1, o.getSifra());
            komanda.setInt(2, p.getSifra());
             if(komanda.executeUpdate()<1){
                vrati=false;
            }
            }  
              komanda = veza.prepareStatement("insert into clan1 (proizvod,rad) values (?,?)");
            for (Rad r  : o.getRadovi()) {
                komanda.setInt(1, o.getSifra());
            komanda.setInt(2, r.getSifra());
             if(komanda.executeUpdate()<1){
                vrati=false;
            }
            }            

            veza.commit();

            if (komanda.executeUpdate() == 1) {
                vrati = true;
            }

        } catch (Exception e) {
            Logger.getLogger(ObradaProizvoda.class.getName()).log(Level.SEVERE, null, e);
        }

        return vrati;
    }
        public boolean obrisi(Proizvod o) {
        boolean vrati = true;
        try {
            Connection veza = Baza.getVeza();
            veza.setAutoCommit(false);
            komanda = veza.prepareStatement("delete from clan1 where proizvod=?");
            komanda.setInt(1, o.getSifra());            
            komanda.executeUpdate();
            
            komanda = veza.prepareStatement("delete from clan where proizvod=?");            
            komanda.setInt(1, o.getSifra());            
            komanda.executeUpdate();
            
            komanda = veza.prepareStatement("delete from proizvod where sifra=?");
            komanda.setInt(1, o.getSifra());
          
             if(komanda.executeUpdate()<1){
                vrati=false;
            }
            
            veza.commit();
            
        } catch (Exception e) {
            Logger.getLogger(ObradaProizvoda.class.getName()).log(Level.SEVERE, null, e);
        }
        return vrati;
    }
    
}
