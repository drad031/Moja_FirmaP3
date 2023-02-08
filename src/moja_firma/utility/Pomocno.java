/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moja_firma.utility;

import java.util.ArrayList;
import java.util.List;
import moja_firma.model.Osoba;

/**
 *
 * @author Dubravka
 */
public class Pomocno {
 //datum
       public static final String FORMAT_DATUM_IZVJESTAJ="dd. MMMM YYYY.";
        public static final String FORMAT_DATUM_UNOS="dd.MM.YYYY.";
        public static final String FORMAT_DATUM_VRIJEME="dd.MM.YYYY. HH:mm:ss";
        private static Osoba osoba;

    public static Osoba getOsoba() {
        return osoba;
    }

 /* public static void setOperater(Osoba osoba) {
        Pomocno.osoba = osoba;
    } */ 
    public static void setOsoba(Osoba o){
        osoba=o;
    }
  
    
    public static List<Uloga> ulogeUSustavu(){
        List<Uloga> l = new ArrayList<>();
        l.add(new Uloga("administrator", "Administrator"));
        l.add(new Uloga("autor", "Autor"));
        l.add(new Uloga("uposlenik", "Uposlenik"));
        l.add(new Uloga("vanjski_suradnik", "Vanjski suradnik"));
        l.add(new Uloga("narucitelj", "Naručitelj"));
        return l;
    }
}
