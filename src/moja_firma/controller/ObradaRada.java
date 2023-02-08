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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import moja_firma.model.Rad;
import moja_firma.utility.Baza;

/**
 *
 * @author Dubravka
 */
public class ObradaRada {
    
    private PreparedStatement komanda;


    public List<Rad> dohvati(String uvjet) {
        List<Rad> l = new ArrayList<>();
        try {
            komanda = Baza.getVeza().prepareStatement("select a.sifra as sifraosobe, a.ime,"
                    + " a.prezime,a.uloga,a.korisnicko_ime, b.sifra, b.nazivrada, b.cijenarada,"
                    + " b.kolicina from osoba a inner join rad b "
                    + "on a.sifra=b.osoba where concat(b.nazivrada) like ?");
            komanda.setString(1, "%" + uvjet + "%");

            ResultSet rs = komanda.executeQuery();
            Rad o;
            while (rs.next()) {
                o = new Rad();
                o.setSifraOsobe(rs.getInt("sifraosobe"));
                o.setSifra(rs.getInt("sifra"));
                o.setIme(rs.getString("ime"));
                o.setPrezime(rs.getString("prezime"));
                o.setUloga(rs.getString("uloga"));
                o.setKorisnicko_ime(rs.getString("korisnicko_ime"));
                o.setNazivrada(rs.getString("nazivrada"));
                o.setCijenarada(rs.getBigDecimal("cijenarada"));
                o.setKolicina(rs.getBigDecimal("kolicina"));
               

                l.add(o);
            }
        } catch (Exception e) {
            Logger.getLogger(ObradaRada.class.getName()).log(Level.SEVERE, null, e);
        }

        return l;
    }
      public Rad dodaj(Rad o) {
        try {
            Connection veza = Baza.getVeza();
            veza.setAutoCommit(false);
            komanda = veza.prepareStatement("insert into osoba (ime,prezime,uloga,korisnicko_ime"
                    + ") values (?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);

            komanda.setString(1, o.getIme());
            komanda.setString(2, o.getPrezime());
            komanda.setString(3, o.getUloga());
            komanda.setString(4, o.getKorisnicko_ime());
            
            komanda.executeUpdate();
            
            ResultSet rs = komanda.getGeneratedKeys();
            rs.next();
            o.setSifraOsobe(rs.getInt(1));

            komanda = veza.prepareStatement("insert into rad (osoba,nazivrada,cijenarada,kolicina"
                    + ") values (?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

            komanda.setInt(1, o.getSifraOsobe());
            komanda.setString(2, o.getNazivrada());
            komanda.setBigDecimal(3,o.getCijenarada());
            komanda.setBigDecimal(4,o.getKolicina());
            
            komanda.executeUpdate();
            rs = komanda.getGeneratedKeys();
            rs.next();
            o.setSifra(rs.getInt(1));

            veza.commit();

        } catch (Exception e) {
            Logger.getLogger(ObradaRada.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        return o;
    }
    
    public boolean promjeni(Rad o) {
        boolean vrati = false;
        try {
            Connection veza = Baza.getVeza();
            veza.setAutoCommit(false);
            komanda = veza.prepareStatement("update rad set nazivrada=?, cijenarada=?, kolicina=? "
                    + " where sifra=?");
            komanda.setString(1, o.getNazivrada());
            komanda.setBigDecimal(2,o.getCijenarada());
            komanda.setBigDecimal(3, o.getKolicina());
            komanda.setInt(4, o.getSifra());
            komanda.executeUpdate();

            komanda = veza.prepareStatement("update osoba set ime=?,"
                    + " prezime=?, uloga=?, korisnicko_ime=? where sifra=?");
            komanda.setString(1, o.getIme());
            komanda.setString(2, o.getPrezime());
            komanda.setString(3, o.getUloga());
            komanda.setInt(4, o.getSifraOsobe());
            komanda.setString(5,o.getKorisnicko_ime());
            komanda.executeUpdate();

            veza.commit();

            if (komanda.executeUpdate() == 1) {
                vrati = true;
            }

        } catch (Exception e) {
            Logger.getLogger(ObradaRada.class.getName()).log(Level.SEVERE, null, e);
        }

        return vrati;
    }
    
    
      public boolean obrisi(Rad o) {
        boolean brisiRad = false;
        boolean brisiOsoba = false;
        try {
            Connection veza = Baza.getVeza();
            veza.setAutoCommit(false);
            komanda = veza.prepareStatement("delete from rad "
                    + " where sifra=?");
            komanda.setInt(1, o.getSifra());
            
            
            
            if (komanda.executeUpdate() == 1) {
                brisiRad = true;
            }
            komanda = veza.prepareStatement("delete from osoba "
                    + " where sifra=?");
            komanda.setInt(1, o.getSifraOsobe());
            
            
            
            if (komanda.executeUpdate() == 1) {
                brisiOsoba = true;
            }
            
            
            veza.commit();
            
        } catch (Exception e) {
            Logger.getLogger(ObradaRada.class.getName()).log(Level.SEVERE, null, e);
        }
        return brisiOsoba && brisiRad;
    }

    public List<Rad> dohvatiPoSifriProizvoda(int sifra) {
        List<Rad> l = new ArrayList<>();
         try {
             komanda = Baza.getVeza().prepareStatement("select a.* from rad a inner join clan1 b on "
                     + "a.sifra=b.rad where b.proizvod=?");
             komanda.setInt(1, sifra);
             
             ResultSet rs = komanda.executeQuery();
             Rad o;
             while(rs.next()){
                 o=new Rad();
                 o.setSifra(rs.getInt("sifra"));
                 o.setNazivrada(rs.getString("nazivrada"));
                 o.setCijenarada(rs.getBigDecimal("cijenarada"));
                 o.setKolicina(rs.getBigDecimal("kolicina"));
                 
            
                 l.add(o);
             }
         } catch (Exception e) {
              Logger.getLogger(ObradaMaterijala.class.getName()).log(Level.SEVERE, null, e);
         } 
         
         return l;
    }
    
    
}
