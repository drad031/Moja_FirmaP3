/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moja_firma.model;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;

/**
 *
 * @author Dubravka
 */
public class Materijal {
    
    
    private int sifra;    
    private String nazivmat;
    private String dobavljac;
    private BigDecimal cijenamat;
    private BigDecimal kolicinamt;
    private Date datumkupnje;

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return nazivmat;
    }

    public void setNaziv(String naziv) {
        this.nazivmat = naziv;
    }

    public String getDobavljac() {
        return dobavljac;
    }

    public void setDobavljac(String dobavljac) {
        this.dobavljac = dobavljac;
    }

    public BigDecimal getCijenamat() {
        return cijenamat;
    }

    public void setCijenamat(BigDecimal cijenamat) {
        this.cijenamat = cijenamat;
    }

    public BigDecimal getKolicina() {
        return kolicinamt;
    }

    public void setKolicina(BigDecimal kolicina) {
        this.kolicinamt = kolicina;
    }

    public Date getDatumkupnje() {
        return datumkupnje;
    }

    public void setDatumkupnje(Date datumkupnje) {
        this.datumkupnje = datumkupnje;
    }
    
    @Override
    public String toString(){
        return nazivmat;
    }
}
