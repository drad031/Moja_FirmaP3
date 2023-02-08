/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moja_firma.view;

import AppPackage.AnimationClass;
import javax.swing.ImageIcon;

/**
 *
 * @author Dubravka
 */
public class SlideS extends javax.swing.JFrame {
 AnimationClass AC = new AnimationClass() ;
    /**
     * Creates new form SlideS
     */
    public SlideS() {
        initComponents();
        setLocationRelativeTo(null);
         SlideShow();
    }
  public void SlideShow(){
        new Thread(){
             int brojac;
             
            @Override
            public void run(){
                try{
                    while (true) {                        
                        switch(brojac){
                            case 0:
                                
                              ImageIcon II = new ImageIcon(getClass().getResource("/slike1/slike/Slideshow/1.png"));
                                slide1.setIcon(II);
                                
                                Thread.sleep(3000);
                                
                                AC.jLabelXLeft(0,-720,10,12,slide1);
                                 AC.jLabelXLeft(720,0,10,12,slide2);
                                 
                                 brojac = 1;
                                break;
                               
                             case 1:
                                ImageIcon II2 = new ImageIcon(getClass().getResource("/slike1/slike/Slideshow/2.png"));
                                slide2.setIcon(II2);
                                
                                Thread.sleep(3000);
                                
                                AC.jLabelXRight(-720,0,10,12,slide1);
                                 AC.jLabelXRight(0,720,10,12,slide2);
                                 
                                 brojac = 2;
                                break;                                     
                           
                              case 2:
                                
                              ImageIcon II3 = new ImageIcon(getClass().getResource("/slike1/slike/Slideshow/3.png"));
                                slide1.setIcon(II3);
                                
                                Thread.sleep(3000);
                                
                                AC.jLabelXLeft(0,-720,10,12,slide1);
                                 AC.jLabelXLeft(720,0,10,12,slide2);
                                 
                                 brojac = 3;
                                break;
                                  
                           
                            case 3:
                                ImageIcon II4 = new ImageIcon(getClass().getResource("/slike1/slike/Slideshow/4.png"));
                                slide2.setIcon(II4);
                                
                                Thread.sleep(3000);
                                
                                AC.jLabelXRight(-720,0,10,12,slide1);
                                 AC.jLabelXRight(0,720,10,12,slide2);
                                 
                                 brojac = 4;
                                break;                                     
                           
                           case 4:
                                
                              ImageIcon II5 = new ImageIcon(getClass().getResource("/slike1/slike/Slideshow/5.png"));
                                slide1.setIcon(II5);
                                
                                Thread.sleep(3000);
                                
                                AC.jLabelXLeft(0,-720,10,12,slide1);
                                 AC.jLabelXLeft(720,0,10,12,slide2);
                                 
                                 brojac = 5;
                                break;
                               
                            case 5:
                                ImageIcon II6 = new ImageIcon(getClass().getResource("/slike1/slike/Slideshow/6.png"));
                                slide2.setIcon(II6);
                                
                                Thread.sleep(3000);
                                
                                AC.jLabelXRight(-720,0,10,12,slide1);
                                 AC.jLabelXRight(0,720,10,12,slide2);
                                 
                                 brojac = 0;
                                break;
                           /*     
                           case 6:
                              ImageIcon II7 = new ImageIcon(getClass().getResource("/slike1/slike/Slideshow/7.png"));
                                slide1.setIcon(II7);
                                
                                Thread.sleep(3000);
                                
                                AC.jLabelXLeft(0,-720,15,10,slide1);
                                 AC.jLabelXLeft(720,0,15,10,slide2);
                                 
                                 brojac = 7;
                                break;
                               
                             case 7:
                                ImageIcon II8 = new ImageIcon(getClass().getResource("/slike1/slike/Slideshow/8.png"));
                                slide2.setIcon(II8);
                                
                                Thread.sleep(3000);
                                
                                AC.jLabelXRight(-720,0,15,10,slide1);
                                 AC.jLabelXRight(0,720,15,10,slide2);
                                 
                                 brojac = 8;
                                break;                                     
                           
                              case 8:
                              ImageIcon II9 = new ImageIcon(getClass().getResource("/slike1/slike/Slideshow/9.png"));
                                slide1.setIcon(II9);
                                
                                Thread.sleep(3000);
                                
                                AC.jLabelXLeft(0,-720,15,10,slide1);
                                 AC.jLabelXLeft(720,0,15,10,slide2);
                                 
                                 brojac = 9;
                                break;
                               
                            case 9:
                                ImageIcon II10 = new ImageIcon(getClass().getResource("/slike1/slike/Slideshow/10.png"));
                                slide2.setIcon(II10);
                                
                                Thread.sleep(3000);
                                
                                AC.jLabelXRight(-720,0,15,10,slide1);
                                 AC.jLabelXRight(0,720,15,10,slide2);
                                 
                                 brojac = 0;
                                break;   */                      
              
                        }
                    }
 
                }catch(Exception e){
                    System.out.printf("nešto ne valja", e ); 
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

        slide1 = new javax.swing.JLabel();
        slide2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImages(null);
        setMaximumSize(new java.awt.Dimension(720, 210));
        setMinimumSize(new java.awt.Dimension(720, 210));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(720, 210));
        setResizable(false);
        getContentPane().setLayout(null);

        slide1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slideshow/1.png"))); // NOI18N
        slide1.setOpaque(true);
        getContentPane().add(slide1);
        slide1.setBounds(0, 0, 720, 210);

        slide2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slideshow/2.png"))); // NOI18N
        slide2.setOpaque(true);
        getContentPane().add(slide2);
        slide2.setBounds(720, 0, 720, 210);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel slide1;
    private javax.swing.JLabel slide2;
    // End of variables declaration//GEN-END:variables
}
