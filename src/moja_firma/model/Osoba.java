/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moja_firma.model;

import java.util.Date;
import moja_firma.utility.Pomocno;

/**
 *
 * @author Dubravka
 */
public class Osoba {
    
    public static final String ADMINISTRATOR="administrator";
    public static final String KORISNICKO_IME="korisnicko_ime";
    
    private int sifraOsobe;
    private String ime;
    private String prezime;
    private String uloga;
    private String korisnicko_ime;
    private String lozinka;
    private String lozinkaMD5;
    private String naziv;
    private String oib;
    private String telefon;
    private String mob;
    private String email;
    private String adresa;
    private String iban;
    private Date datumrodenja;
    private String formatdatuma;
    private boolean aktivan;   
    private String primjedba;
    
    
    public String getFormatDatuma() {
         if(formatdatuma==null)
            return Pomocno.FORMAT_DATUM_UNOS;
        return formatdatuma;
    }

    public void setFormatDatuma(String formatdatuma) {
        this.formatdatuma = formatdatuma;
    }
    
    public Date getDatumrodenja() {
        return datumrodenja;
    }

    public void setDatumrodenja(Date datumrodenja) {
        this.datumrodenja = datumrodenja;
    }
 
    public int getSifraOsobe() {
        return sifraOsobe;
    }

    public void setSifraOsobe(int sifraOsobe) {
        this.sifraOsobe = sifraOsobe;
    }
 
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUloga() {
         if(uloga==null)
          return Osoba.KORISNICKO_IME;
         return uloga;
         }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }
        
    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getLozinkaMD5() {
        return lozinkaMD5;
    }

    public void setLozinkaMD5(String lozinkaMD5) {
        this.lozinkaMD5 = lozinkaMD5;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

      public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
    
    public boolean isAktivan() {
        return aktivan;
    }

    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

    public String getPrimjedba() {
        return primjedba;
    }

    public void setPrimjedba(String primjedba) {
        this.primjedba = primjedba;
    }
   
    
    @Override
    public String toString(){
        return getIme()+" "+this.prezime;
    }
    
    public String getImePrezime(){
        return getIme()+" "+getPrezime();
    }
   
}
