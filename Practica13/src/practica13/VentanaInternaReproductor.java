/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica13;
import java.awt.Graphics;
import java.io.File;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import sm.cvr.iu.Lienzo2d;
import sm.cvr.iu.Lienzo2dImage;
import sm.sound.SMClipPlayer;

/**
 *
 * @author Ainokila
 */
public class VentanaInternaReproductor extends javax.swing.JInternalFrame {
    
    private class ManejadorAudio implements LineListener {
        @Override
        public void update(LineEvent event) {
            if (event.getType() == LineEvent.Type.START) {
            //TODO
            }
            if (event.getType() == LineEvent.Type.STOP) {
                stop.setSelected(true);
                if(player!=null){
                    player.stop();
                }
            }
            if (event.getType() == LineEvent.Type.CLOSE) {
            //TODO
            }
        }
    }
    
    private Principal parent;
    private SMClipPlayer player;
    /**
     * Creates new form VentanaInterna
     */
    public VentanaInternaReproductor(Principal padre,File f) {
        super(f.getName(),
          true, //resizable
          true, //closable
          true, //maximizable
          true);//iconifiable
                
        //this.setSize(0, 0);
        this.parent=padre;
        
        initComponents();
        this.player = new SMClipPlayer(f);
        player.addLineListener(new ManejadorAudio());
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotones = new javax.swing.ButtonGroup();
        play = new javax.swing.JToggleButton();
        stop = new javax.swing.JToggleButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setAutoscrolls(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        grupoBotones.add(play);
        play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica13/iconos/PlayDisabled_48x48.png"))); // NOI18N
        play.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/practica13/iconos/PlayPressed_48x48.png"))); // NOI18N
        play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playMouseClicked(evt);
            }
        });
        getContentPane().add(play, new java.awt.GridBagConstraints());

        grupoBotones.add(stop);
        stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica13/iconos/StopDisabled_48x48.png"))); // NOI18N
        stop.setSelected(true);
        stop.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/practica13/iconos/StopNormalRed_48x48.png"))); // NOI18N
        stop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopMouseClicked(evt);
            }
        });
        getContentPane().add(stop, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        if(player!=null){
            player.stop();
        }
    }//GEN-LAST:event_formInternalFrameClosed

    private void playMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMouseClicked
        if(player!=null) player.play();
    }//GEN-LAST:event_playMouseClicked

    private void stopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopMouseClicked
      if(player!=null) player.pause();
    }//GEN-LAST:event_stopMouseClicked

    //Cuando se activa la ventana cargamos la info
    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
       
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JToggleButton play;
    private javax.swing.JToggleButton stop;
    // End of variables declaration//GEN-END:variables
}