/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moja_firma.view;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import moja_firma.controller.ObradaMaterijala;
import moja_firma.model.Materijal;
import moja_firma.utility.Pomocno;
import org.imgscalr.Scalr;

/**
 *
 * @author Dubravka
 */
public class Materijali extends Upozorenja {
    
     int width = (Toolkit.getDefaultToolkit().getScreenSize().width/2)-475;
     int height = (Toolkit.getDefaultToolkit().getScreenSize().height/2)-220;
     private ObradaMaterijala obradaMaterijala;
     private Materijal odabrano;

    /**
     * Creates new form Materijali
     */
    public Materijali() {
        initComponents();
         setLocation(width, height);
          obradaMaterijala=new ObradaMaterijala();
          jLabel8.setIcon(new javax.swing.ImageIcon("slike" + File.separator + "Pozadine" + File.separator + "NestoPlavoV.png" ));
        lista.setModel(new DefaultListModel<Materijali>());
       setTitle("Materijali moje firme " );
    }
      
    private void cistiPolja(){
        
         nazivmat.setText("");
        dobavljac.setText("");
        cijenamat.setText("");
        kolicina.setText("");
        
        datumkupnje.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        nazivmat = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        dobavljac = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cijenamat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        kolicina = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        datumkupnje = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        uvjet = new javax.swing.JTextField();
        akcijaTrazi = new javax.swing.JButton();
        akcijaPromijeni = new javax.swing.JButton();
        akcijaObrisi = new javax.swing.JButton();
        akcijaDodajNovi = new javax.swing.JButton();
        akcijaOdustani = new javax.swing.JButton();
        slika = new javax.swing.JLabel();
        akcijaPromijeniSliku = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MATERIJAL");
        setMinimumSize(new java.awt.Dimension(950, 650));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lista.setBackground(new java.awt.Color(204, 255, 255));
        lista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listaKeyPressed(evt);
            }
        });
        lista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lista);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 137, 212, 490));

        jLabel1.setText("Naziv");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 60, 20));

        nazivmat.setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().add(nazivmat, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 370, 30));

        jLabel2.setText("Dobavlja??");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 102, -1));

        dobavljac.setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().add(dobavljac, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 370, 30));

        jLabel3.setText("Cijena materijala");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 120, -1));

        cijenamat.setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().add(cijenamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 370, 30));

        jLabel4.setText("Koli??ina");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 64, -1));

        kolicina.setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().add(kolicina, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 370, 30));

        jLabel5.setText("Datum kupnje");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 88, -1));

        datumkupnje.setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().add(datumkupnje, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, 370, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Uvjet(* za sve)");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        uvjet.setBackground(new java.awt.Color(204, 255, 255));
        uvjet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                uvjetKeyPressed(evt);
            }
        });
        getContentPane().add(uvjet, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 126, -1));

        akcijaTrazi.setBackground(new java.awt.Color(0, 204, 204));
        akcijaTrazi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        akcijaTrazi.setText("TRA??I");
        akcijaTrazi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        akcijaTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                akcijaTraziActionPerformed(evt);
            }
        });
        getContentPane().add(akcijaTrazi, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 80, -1));

        akcijaPromijeni.setBackground(new java.awt.Color(0, 204, 204));
        akcijaPromijeni.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        akcijaPromijeni.setText("PROMIJENI");
        akcijaPromijeni.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        akcijaPromijeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                akcijaPromijeniActionPerformed(evt);
            }
        });
        getContentPane().add(akcijaPromijeni, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 49));

        akcijaObrisi.setBackground(new java.awt.Color(0, 204, 204));
        akcijaObrisi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        akcijaObrisi.setText("OBRI??I");
        akcijaObrisi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        akcijaObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                akcijaObrisiActionPerformed(evt);
            }
        });
        getContentPane().add(akcijaObrisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 240, 49));

        akcijaDodajNovi.setBackground(new java.awt.Color(0, 204, 204));
        akcijaDodajNovi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        akcijaDodajNovi.setText("DODAJ NOVI");
        akcijaDodajNovi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        akcijaDodajNovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                akcijaDodajNoviActionPerformed(evt);
            }
        });
        getContentPane().add(akcijaDodajNovi, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 240, 49));

        akcijaOdustani.setBackground(new java.awt.Color(0, 204, 204));
        akcijaOdustani.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        akcijaOdustani.setText("ODUSTANI");
        akcijaOdustani.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        akcijaOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                akcijaOdustaniActionPerformed(evt);
            }
        });
        getContentPane().add(akcijaOdustani, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 230, 49));

        slika.setText("Slika materijala");
        getContentPane().add(slika, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 250, 268));

        akcijaPromijeniSliku.setBackground(new java.awt.Color(0, 204, 204));
        akcijaPromijeniSliku.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        akcijaPromijeniSliku.setText("PROIJENI SLIKU");
        akcijaPromijeniSliku.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        akcijaPromijeniSliku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                akcijaPromijeniSlikuActionPerformed(evt);
            }
        });
        getContentPane().add(akcijaPromijeniSliku, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 360, 199, 46));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pozadine/NestoPlavoV.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uvjetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uvjetKeyPressed
        if(evt.getKeyCode()==
            KeyEvent.VK_ENTER){
            akcijaTraziActionPerformed(null);
        }
    }//GEN-LAST:event_uvjetKeyPressed

    private void akcijaTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_akcijaTraziActionPerformed

        cistiPolja();

        List<Materijal> entiteti = obradaMaterijala.
        dohvati(uvjet.getText());

        DefaultListModel<Materijal> m = new DefaultListModel<>();
        for (Materijal materijal : entiteti) {
            m.addElement(materijal);
        }
        lista.setModel(m);

    }//GEN-LAST:event_akcijaTraziActionPerformed
                                      
    private void akcijaPromijeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_akcijaPromijeniActionPerformed
           if(odabrano==null){
            return;
        }
        reset();
        //kontorle
        if(nazivmat.getText().trim().isEmpty()){
            greska(nazivmat, "Obavezno naziv");
            return;
        }
          if(dobavljac.getText().trim().isEmpty()){
            greska(dobavljac, "Obavezno dobavlja??");
            return;
        }
       
        if(cijenamat.getText().trim().isEmpty()){
            greska(cijenamat, "Obavezno cijena");
            return;
        }
          if(kolicina.getText().trim().isEmpty()){
            greska(kolicina, "Obavezno koli??ina");
            return;
        }
     
        odabrano.setNaziv(nazivmat.getText().trim());
        odabrano.setDobavljac(dobavljac.getText().trim());
        odabrano.setCijenamat(new BigDecimal(cijenamat.getText()));
        odabrano.setKolicina(new BigDecimal(kolicina.getText()));
        

        //promjena u bazi
        if(!obradaMaterijala.promjeni(odabrano)){
            return;
        }

        //dodavanje/postavljanje
        //nekada ne radi dobro
        lista.repaint();
        cistiPolja();
    }//GEN-LAST:event_akcijaPromijeniActionPerformed

    private void akcijaOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_akcijaOdustaniActionPerformed
       dispose();
    
    }//GEN-LAST:event_akcijaOdustaniActionPerformed

    private void akcijaDodajNoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_akcijaDodajNoviActionPerformed
         reset();
        if(nazivmat.getText().trim().isEmpty()){
            greska(nazivmat, "Obavezno naziv");
            return;
        }
          if(dobavljac.getText().trim().isEmpty()){
            greska(dobavljac, "Obavezno dobavlja??");
            return;
        }
       
        if(cijenamat.getText().trim().isEmpty()){
            greska(cijenamat, "Obavezno cijena");
            return;
        }
          if(kolicina.getText().trim().isEmpty()){
            greska(kolicina, "Obavezno koli??ina");
            return;
        }
           if(datumkupnje.getText().trim().isEmpty()){
            greska(datumkupnje, "Obavezno datum");
            return;
        }
        

        Materijal o = new Materijal();
        o.setNaziv(nazivmat.getText().trim());
        o.setDobavljac(dobavljac.getText().trim());
        o.setCijenamat(new BigDecimal(cijenamat.getText().trim()));
        o.setKolicina(new BigDecimal(kolicina.getText().trim()));
        o.setDatumkupnje(null);
       
        o=obradaMaterijala.dodaj(o);
         if(o==null){
            //obavijest
            return;
        }

        DefaultListModel<Materijal> m =(DefaultListModel<Materijal>) lista.getModel();
        m.addElement(o);
        cistiPolja();

    }//GEN-LAST:event_akcijaDodajNoviActionPerformed

    private void akcijaObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_akcijaObrisiActionPerformed
           odabrano = (Materijal) lista.getSelectedValue();
        if(odabrano==null){
            return;
        }
        if(JOptionPane.showConfirmDialog(getParent(), "Jeste li sigurni da ??elite obrisati " + odabrano.getNaziv() + "?","Brisanje materijala",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.NO_OPTION){
           return;
       }
       
       if(!obradaMaterijala.obrisi(odabrano)){
           return;
       }
       
       DefaultListModel<Materijal> m = (DefaultListModel<Materijal>) lista.getModel();
       m.removeElement(odabrano);
        lista.repaint();
       cistiPolja();
                                               

    }//GEN-LAST:event_akcijaObrisiActionPerformed

    private void listaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaValueChanged
          reset();
        odabrano = (Materijal) lista.getSelectedValue();
        if(odabrano==null){
            return;
        }
        nazivmat.setText(odabrano.getNaziv());
        dobavljac.setText(odabrano.getDobavljac());
        cijenamat.setText(String.valueOf(odabrano.getCijenamat()));
        kolicina.setText(String.valueOf(odabrano.getKolicina()));
          SimpleDateFormat df = new SimpleDateFormat(Pomocno.FORMAT_DATUM_IZVJESTAJ);
        try {
            datumkupnje.setText(df.format(odabrano.getDatumkupnje()));
        } catch (Exception e) {
            datumkupnje.setText("");
        }
        ucitajSliku();

    }//GEN-LAST:event_listaValueChanged

    private void listaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listaKeyPressed
          if(evt.getKeyCode()==
                KeyEvent.VK_ENTER){
            listaValueChanged(null);
        }
    }//GEN-LAST:event_listaKeyPressed

    private void akcijaPromijeniSlikuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_akcijaPromijeniSlikuActionPerformed
           if(odabrano==null){
           return;
       }
        
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Slike", "jpg", "png", "gif", "jpeg");
        
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home"));
        fileChooser.setFileFilter(filter);
        
        int returnVal = fileChooser.showOpenDialog(getRootPane());
        
        if(returnVal==JFileChooser.APPROVE_OPTION){
            
            BufferedImage novaSlika=null;
            try {
                novaSlika = ImageIO.read(fileChooser.getSelectedFile());
                File dat = new File("slike" + File.separator + "materijali" + File.separator + odabrano.getSifra() + ".png");
                if(dat.exists()){
                    dat.renameTo(new File("slike" + File.separator + "materijali" + File.separator + odabrano.getSifra() + "_ " + new Date().getTime() +".png"));
                }
                ImageIO.write(novaSlika, "png", dat);
            } catch (IOException ex) {
                Logger.getLogger(Proizvodi.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            ucitajSliku();
            
        }
    }//GEN-LAST:event_akcijaPromijeniSlikuActionPerformed
   private void ucitajSliku(){
         File sp = new File("slike" + File.separator + "materijali" + File.separator + odabrano.getSifra() + ".png");
       if(!sp.exists()){
           sp=new File("slike" + File.separator + "materijali" + File.separator + "nepoznato.png");
       }
        BufferedImage slikaSdiska;
        try {
            slikaSdiska = ImageIO.read(sp);
             BufferedImage manjaslika =
  Scalr.resize(slikaSdiska, Scalr.Method.QUALITY, Scalr.Mode.AUTOMATIC,
               slika.getWidth(), slika.getHeight(), Scalr.OP_ANTIALIAS);
        slika.setIcon(new ImageIcon(manjaslika));
        } catch (IOException ex) {
            Logger.getLogger(Proizvodi.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    /**
     * @param args the command line arguments
     */
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton akcijaDodajNovi;
    private javax.swing.JButton akcijaObrisi;
    private javax.swing.JButton akcijaOdustani;
    private javax.swing.JButton akcijaPromijeni;
    private javax.swing.JButton akcijaPromijeniSliku;
    private javax.swing.JButton akcijaTrazi;
    private javax.swing.JTextField cijenamat;
    private javax.swing.JTextField datumkupnje;
    private javax.swing.JTextField dobavljac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kolicina;
    private javax.swing.JList lista;
    private javax.swing.JTextField nazivmat;
    private javax.swing.JLabel slika;
    private javax.swing.JTextField uvjet;
    // End of variables declaration//GEN-END:variables
}
