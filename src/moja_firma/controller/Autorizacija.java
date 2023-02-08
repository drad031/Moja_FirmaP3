/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moja_firma.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import moja_firma.model.Osoba;
import moja_firma.utility.Baza;
import moja_firma.utility.Pomocno;

/**
 *
 * @author Dubravka
 */
public class Autorizacija {
    
    private PreparedStatement komanda;
    
    public Osoba autoriziraj(String korisnicko_ime,String lozinka){
        Osoba o = null;
        
        try {
            komanda = Baza.getVeza().prepareStatement("select * from osoba where binary korisnicko_ime=? and lozinka=md5(?)");
            komanda.setString(1, korisnicko_ime);
            komanda.setString(2, lozinka);
            ResultSet rs = komanda.executeQuery();
            while(rs.next()){
                o = new Osoba();
                o.setSifraOsobe(rs.getInt("sifra"));
                o.setKorisnicko_ime(rs.getString("korisnicko_ime"));
                o.setLozinka(rs.getString("lozinka"));
                    try {
                     o.setUloga(rs.getString("uloga"));
                    
               
               } catch (Exception e) {
                     o.setUloga(Osoba.KORISNICKO_IME);
                 }
            }
        } catch (Exception e) {
        }
        if (o!=null) {
            Pomocno.setOsoba(o);
        }
        return o;
    }
    
}
