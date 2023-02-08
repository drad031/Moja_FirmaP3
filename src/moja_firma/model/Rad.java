/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moja_firma.model;

import java.math.BigDecimal;

/**
 *
 * @author Dubravka
 */
public class Rad extends Osoba{
    
    private int sifra;
    private String nazivrada;
    private BigDecimal cijenarada;
    private BigDecimal kolicina;

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public String getNazivrada() {
        return nazivrada;
    }

    public void setNazivrada(String nazivrada) {
        this.nazivrada = nazivrada;
    }

    public BigDecimal getCijenarada() {
        return cijenarada;
    }

    public void setCijenarada(BigDecimal cijenarada) {
        this.cijenarada = cijenarada;
    }

    public BigDecimal getKolicina() {
        return kolicina;
    }

    public void setKolicina(BigDecimal kolicina) {
        this.kolicina = kolicina;
    }

    @Override
    public String toString() {
        return getNazivrada(); 
    }
    
    
}
