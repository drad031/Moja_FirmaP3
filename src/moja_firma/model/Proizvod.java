/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moja_firma.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import moja_firma.utility.Pomocno;

/**
 *
 * @author Dubravka
 */
public class Proizvod extends Osoba{
    
    
    private int sifra;
    private List<Materijal> materijali;
    private List<Rad> radovi;
    private String nazivpr;
    private String dimenzija;
    private String kolicinapr;
    private String grupaproizvoda;
    private Date datumproizvodnje;
    private Date rokizrade;
    private String sirovinskisastav;
    private BigDecimal cijena;
    private String formatdatuma;
       
    @Override
    public String getFormatDatuma() {
         if(formatdatuma==null)
            return Pomocno.FORMAT_DATUM_UNOS;
        return formatdatuma;
    }

    /**
     *
     * @param formatdatuma
     */
    @Override
    public void setFormatDatuma(String formatdatuma) {
        this.formatdatuma = formatdatuma;
    }
    
    
      public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }
    
    public String getNazivpr() {
        return nazivpr;
    }

    public void setNazivpr(String nazivpr) {
        this.nazivpr = nazivpr;
    }
    
   
    public String getKolicinapr() {
        return kolicinapr;
    }

    public void setKolicina(String kolicinapr) {
        this.kolicinapr = kolicinapr;
    }

    public String getGrupaproizvoda() {
        return grupaproizvoda;
    }

    public void setGrupaproizvoda(String grupaproizvoda) {
        this.grupaproizvoda = grupaproizvoda;
    }

    public Date getDatumproizvodnje() {
        return datumproizvodnje;
    }

    public void setDatumproizvodnje(Date datumproizvodnje) {
        this.datumproizvodnje = datumproizvodnje;
    }

    public Date getRokizrade() {
        return rokizrade;
    }

    public void setRokizrade(Date rokizrade) {
        this.rokizrade = rokizrade;
    }

    public String getSirovinskisastav() {
        return sirovinskisastav;
    }

    public void setSirovinskisastav(String sirovinskisastav) {
        this.sirovinskisastav = sirovinskisastav;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

   
    public List<Materijal> getMaterijali() {
        return materijali;
    }

    public void setMaterijali(List<Materijal> materijali) {
        this.materijali = materijali;
    }

    public List<Rad> getRadovi() {
        return radovi;
    }

    public void setRadovi(List<Rad> radovi) {
        this.radovi = radovi;
    }

    public String getDimenzija() {
        return dimenzija;
    }

    public void setDimenzija(String dimenzija) {
        this.dimenzija = dimenzija;
    }

    @Override
      public String toString(){
        return getSifra()+" "+this.nazivpr;
    }
    
    public String getSifraNaziv(){
        return getSifra()+"  "+getNazivpr();
    }
   
    
 
} 
    
    
    

