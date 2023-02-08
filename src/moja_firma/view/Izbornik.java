/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moja_firma.view;

import AppPackage.AnimationClass;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.ImageIcon;
import moja_firma.model.Osoba;
import moja_firma.utility.Pomocno;
/**
 *
 * @author Dubravka
 */

public class Izbornik extends javax.swing.JFrame {
    
    
        AnimationClass AC = new AnimationClass() ;
       int width = (Toolkit.getDefaultToolkit().getScreenSize().width/2)-475;
       int height = (Toolkit.getDefaultToolkit().getScreenSize().height/2)-483;

    /**
     * Creates new form Izbornik
     */
    public Izbornik() {
        initComponents();
        setLocation(width, height);
        setSize(950,965);       
        setTitle("MOJA FIRMA ");
        jLabel1.setIcon(new javax.swing.ImageIcon("slike" + File.separator + "Pozadine" + File.separator + "NestoPlavoV.png" )); // NOI18N
        SlideShow();
           
       if(Pomocno.getOsoba().getUloga().equals(Osoba.ADMINISTRATOR)){
           osoblje.setVisible(true);
       }else{
           osoblje.setVisible(false);
       }
       
        SatNit t = new SatNit(datum);
        t.start();
       // ili  new SatNit(datum).start();
    }
    public void SlideShow(){
        new Thread(){
             int count;
             
            @Override
            public void run(){
                try{
                    while (true) {                        
                        switch(count){
                            case 0:
                                
                                ImageIcon II = new ImageIcon(getClass().getResource("/slike1/slike/Slideshow/1.png"));
                                slide1.setIcon(II);
                                
                                Thread.sleep(3000);
                                
                                AC.jLabelXLeft(230,-490,10,12,slide1);
                                 AC.jLabelXLeft(950,230,10,12,slide2);
                                 
                                 count = 1;
                                break;
                               
                            case 1:
                                ImageIcon II2 = new ImageIcon(getClass().getResource("/slike1/slike/Slideshow/2.png"));
                                slide2.setIcon(II2);
                                
                                Thread.sleep(3000);
                                
                                AC.jLabelXRight(-490,230,10,12,slide1);
                                 AC.jLabelXRight(230,950,10,12,slide2);
                                 
                                 count = 2;
                                break;
                                
                            case 2:
                                ImageIcon II3 = new ImageIcon(getClass().getResource("/slike1/slike/Slideshow/3.png"));
                                slide1.setIcon(II3);
                                
                                Thread.sleep(3000);
                                
                                AC.jLabelXLeft(230,-490,10,12,slide1);
                                 AC.jLabelXLeft(950,230,10,12,slide2);
                                 
                                 count = 3;
                                break;
                                
                            case 3:
                                ImageIcon II4 = new ImageIcon(getClass().getResource("/slike1/slike/Slideshow/4.png"));
                                slide2.setIcon(II4);
                                
                                Thread.sleep(3000);
                                
                                AC.jLabelXRight(-490,230,10,12,slide1);
                                 AC.jLabelXRight(230,950,10,12,slide2);
                                 
                                 count = 4;
                                break;
                                
                            case 4:
                                ImageIcon II5 = new ImageIcon(getClass().getResource("/slike1/slike/Slideshow/5.png"));
                                slide1.setIcon(II5);
                                
                                Thread.sleep(3000);
                                
                                AC.jLabelXLeft(230,-490,10,12,slide1);
                                 AC.jLabelXLeft(950,230,10,12,slide2);
                                 
                                 count = 5;
                                break;
                                      
                            case 5:
                                ImageIcon II6 = new ImageIcon(getClass().getResource("/slike1/slike/Slideshow/6.png"));
                                slide2.setIcon(II6);
                                
                                Thread.sleep(3000);
                                
                                AC.jLabelXRight(-490,230,10,12,slide1);
                                 AC.jLabelXRight(230,950,10,12,slide2);
                                 
                                 count = 0;
                                break;
                           /*     
                            case 6:
                                ImageIcon II7 = new ImageIcon(getClass().getResource("slike" + File.separator + "Slideshow" + File.separator + "7.png"));
                                slide1.setIcon(II7);
                                
                                Thread.sleep(3000);
                                
                                AC.jLabelXLeft(230,-490,20,6,slide1);
                                 AC.jLabelXLeft(950,230,20,6,slide2);
                                 
                                 count = 7;
                                break;
                                
                            case 7:
                                ImageIcon II8 = new ImageIcon(getClass().getResource("slike" + File.separator + "Slideshow" + File.separator + "8.png"));
                                slide2.setIcon(II8);
                                
                                Thread.sleep(3000);
                                
                                AC.jLabelXRight(-490,230,20,6,slide1);
                                 AC.jLabelXRight(230,950,20,6,slide2);
                                 
                                 count = 8;
                                break;
                                
                            case 8:
                                ImageIcon II9 = new ImageIcon(getClass().getResource("slike" + File.separator + "Slideshow" + File.separator + "9.png"));
                                slide1.setIcon(II9);
                                
                                Thread.sleep(3000);
                                
                                AC.jLabelXLeft(230,-490,20,6,slide1);
                                 AC.jLabelXLeft(950,230,20,6,slide2);
                                 
                                 count = 9;
                                break;
                                
                            case 9:
                                ImageIcon II10 = new ImageIcon(getClass().getResource("slike" + File.separator + "Slideshow" + File.separator + "10.png"));
                                slide2.setIcon(II10);
                                
                                Thread.sleep(3000);
                                
                                AC.jLabelXRight(-490,230,20,6,slide1);
                                 AC.jLabelXRight(230,950,20,6,slide2);
                                 
                                 count = 0;
                                break;                          
              */
                        }
                    }
 
                }catch(Exception e){
                     e.printStackTrace();
                }
            }
        
        }.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        datum = new javax.swing.JLabel();
        osoblje = new javax.swing.JButton();
        materijali = new javax.swing.JButton();
        proizvodi = new javax.swing.JButton();
        proizvodi1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        slide1 = new javax.swing.JLabel();
        slide2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IZBORNIK");
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(950, 965));
        setResizable(false);
        getContentPane().setLayout(null);

        jToolBar1.setBackground(new java.awt.Color(0, 204, 204));
        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setRollover(true);
        jToolBar1.add(datum);

        getContentPane().add(jToolBar1);
        jToolBar1.setBounds(0, 880, 950, 30);

        osoblje.setBackground(new java.awt.Color(0, 204, 204));
        osoblje.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        osoblje.setText("OSOBLJE");
        osoblje.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        osoblje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                osobljeActionPerformed(evt);
            }
        });
        getContentPane().add(osoblje);
        osoblje.setBounds(0, 210, 230, 49);

        materijali.setBackground(new java.awt.Color(0, 204, 204));
        materijali.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        materijali.setText("MATERIJALI");
        materijali.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        materijali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materijaliActionPerformed(evt);
            }
        });
        getContentPane().add(materijali);
        materijali.setBounds(230, 210, 240, 49);

        proizvodi.setBackground(new java.awt.Color(0, 204, 204));
        proizvodi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        proizvodi.setText("PROIZVODI");
        proizvodi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        proizvodi.setMaximumSize(new java.awt.Dimension(113, 25));
        proizvodi.setMinimumSize(new java.awt.Dimension(113, 25));
        proizvodi.setPreferredSize(new java.awt.Dimension(113, 25));
        proizvodi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proizvodiActionPerformed(evt);
            }
        });
        getContentPane().add(proizvodi);
        proizvodi.setBounds(710, 210, 240, 49);

        proizvodi1.setBackground(new java.awt.Color(0, 204, 204));
        proizvodi1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        proizvodi1.setText("RADOVI");
        proizvodi1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        proizvodi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radovi1ActionPerformed(evt);
            }
        });
        getContentPane().add(proizvodi1);
        proizvodi1.setBounds(470, 210, 240, 49);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pozadine/NestoPlavoV.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setMaximumSize(new java.awt.Dimension(994, 959));
        jLabel1.setMinimumSize(new java.awt.Dimension(994, 959));
        jLabel1.setPreferredSize(new java.awt.Dimension(994, 959));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 260, 950, 630);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pozadine/Zeleni Z.png"))); // NOI18N
        logo.setOpaque(true);
        getContentPane().add(logo);
        logo.setBounds(0, 0, 230, 210);

        slide1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slideshow/1.png"))); // NOI18N
        slide1.setOpaque(true);
        getContentPane().add(slide1);
        slide1.setBounds(230, 0, 720, 210);

        slide2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slideshow/2.png"))); // NOI18N
        slide2.setOpaque(true);
        getContentPane().add(slide2);
        slide2.setBounds(950, 0, 720, 210);

        jMenuBar1.setBackground(new java.awt.Color(0, 204, 204));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(98, 27));

        jMenu1.setBackground(new java.awt.Color(0, 204, 204));
        jMenu1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu1.setText("HOME");
        jMenu1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jMenuItem1.setBackground(new java.awt.Color(0, 204, 204));
        jMenuItem1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem1.setText("Izlaz");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(0, 204, 204));
        jMenu2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu2.setText("FIRMA");
        jMenu2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jMenuItem2.setBackground(new java.awt.Color(0, 204, 204));
        jMenuItem2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem2.setText("Podaci o firmi");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void osobljeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osobljeActionPerformed
       new Osoblje().setVisible(true);
                 
    }//GEN-LAST:event_osobljeActionPerformed

    private void materijaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materijaliActionPerformed
       new Materijali().setVisible(true);
              
    }//GEN-LAST:event_materijaliActionPerformed

    private void proizvodiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proizvodiActionPerformed
        new Proizvodi().setVisible(true);
       
    }//GEN-LAST:event_proizvodiActionPerformed

    private void radovi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radovi1ActionPerformed
        new Radovi().setVisible(true);
        
    }//GEN-LAST:event_radovi1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       new Podaci_o_firmri().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel datum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel logo;
    private javax.swing.JButton materijali;
    private javax.swing.JButton osoblje;
    private javax.swing.JButton proizvodi;
    private javax.swing.JButton proizvodi1;
    private javax.swing.JLabel slide1;
    private javax.swing.JLabel slide2;
    // End of variables declaration//GEN-END:variables

  
}
