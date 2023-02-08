/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moja_firma.utility;

/**
 *
 * @author Edunova
 */
public class Uloga{ 
    
    private String baza;
    private String korisnik;

    public Uloga(String baza, String korisnik) {
        this.baza = baza;
        this.korisnik = korisnik;
    }
    
    

    public String getBaza() {
        return baza;
    }

    public void setBaza(String baza) {
        this.baza = baza;
    }

    public String getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(String korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    public String toString() {
    return korisnik;
    }
    
    
    
}
