/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;
import java.awt.Graphics;
import practicaFinal.Principal;
import sm.cvr.iu.Lienzo2d;

/**
 *
 * @author Ainokila
 */
public class VentanaInternaImagen extends javax.swing.JInternalFrame {

    private Lienzo2d lienzo2d1;
    private static int numeroVentana = 0;
    
    private Principal parent;
    /**
     * Creates new form VentanaInterna
     */
    public VentanaInternaImagen(Principal padre) {
        super("Lienzo " + (++numeroVentana),
          true, //resizable
          true, //closable
          true, //maximizable
          true);//iconifiable
        
        this.setLocation(numeroVentana*30, numeroVentana*30);
        
        //this.setSize(0, 0);
        
        this.parent=padre;
        initComponents();
        inicializa();

    }
    
    
    private void inicializa(){
        
        lienzo2d1 = new Lienzo2d(this);
        //setPreferredSize(new Dimension(500,500));

        javax.swing.GroupLayout lienzo2d1Layout = new javax.swing.GroupLayout(lienzo2d1);
        lienzo2d1.setLayout(lienzo2d1Layout);
        lienzo2d1Layout.setHorizontalGroup(
            lienzo2d1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 462, Short.MAX_VALUE)
        );
        lienzo2d1Layout.setVerticalGroup(
            lienzo2d1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lienzo2d1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lienzo2d1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setAutoscrolls(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
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
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public Lienzo2d getLienzo(){
      return lienzo2d1;
    }
    
    public Principal getParentPrincipal(){
        return parent;
    }
    
    
    
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        numeroVentana--;
    }//GEN-LAST:event_formInternalFrameClosed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        parent.setPositionMouse(evt.getPoint().x, evt.getPoint().y);
    }//GEN-LAST:event_formMouseMoved

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
    }//GEN-LAST:event_formMouseReleased

    //Cuando se activa la ventana cargamos la info
    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
        System.out.println(lienzo2d1.getHerramienta().toString());
        switch(lienzo2d1.getHerramienta()){
            case LAPIZ: 
                parent.setLapiz(true); 
                break;
            case LINEA: 
                parent.setLine(true);
                break;
            case RECTANGULO: 
                parent.setRectangulo(true);
                break;
            case CIRCULO: 
                parent.setElipse(true);
                break;
            case CURVA: 
                parent.setCurva(true);
                break;
            case TEXTO: 
                parent.setTexto(true);
                break;
            case NINGUNO: break;
        }
        
        parent.setEstado(lienzo2d1.getHerramienta().toString());
        
        parent.setColor(lienzo2d1.getColor().toString());
        parent.setGrosor(lienzo2d1.getGrosor());
        parent.setRelleno(lienzo2d1.getRellenar());
        parent.setAlisar(lienzo2d1.getAlisado());
        parent.setTransparencia(lienzo2d1.getTransparencia());
        
    }

    @Override
    public void paint(Graphics g){
       super.paint(g);
       //this.padre.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
