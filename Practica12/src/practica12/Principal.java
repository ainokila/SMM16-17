/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica12;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.RescaleOp;
import java.awt.image.WritableRaster;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import sm.cvr.iu.*;
import sm.image.TintOp;

/**
 *
 * @author Ainokila
 */
public class Principal extends javax.swing.JFrame {

    EnumHerramienta herramientaActiva;
    EnumColor colorActivo;
    
    BufferedImage imgSource;
    int rotaAnterior;
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        inicializa();
    }

    private void inicializa(){
        
        //Color
        herramientaActiva = EnumHerramienta.LAPIZ;
        colorActivo = EnumColor.NEGRO;
        this.grosor.setValue(1);
        
        this.btn_punto.setSelected(true);
        
        
        this.selector_color.removeAllItems();

        this.selector_color.addItem("Negro");
        this.selector_color.addItem("Rojo");
        this.selector_color.addItem("Azul");
        this.selector_color.addItem("Blanco");
        this.selector_color.addItem("Amarillo");
        this.selector_color.addItem("Verde");
        
        this.selector_color.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //Cambiar color
                
                switch ((String)selector_color.getSelectedItem()){
                    case "Negro":
                         for(JInternalFrame i: escritorio.getAllFrames())
                             if(i.isSelected())
                            ((VentanaInterna)i).getLienzo().setColor(EnumColor.NEGRO);
                         colorActivo = EnumColor.NEGRO;
                        break;
                    case "Rojo":
                         for(JInternalFrame i: escritorio.getAllFrames())
                             if(i.isSelected())
                            ((VentanaInterna)i).getLienzo().setColor(EnumColor.ROJO);
                         colorActivo = EnumColor.ROJO;
                        break;
                    case "Azul":
                         for(JInternalFrame i: escritorio.getAllFrames())
                             if(i.isSelected())
                            ((VentanaInterna)i).getLienzo().setColor(EnumColor.AZUL);
                         colorActivo = EnumColor.AZUL;
                        break;
                    case "Blanco":
                         for(JInternalFrame i: escritorio.getAllFrames())
                             if(i.isSelected())
                            ((VentanaInterna)i).getLienzo().setColor(EnumColor.BLANCO);
                         colorActivo = EnumColor.BLANCO;
                        break;
                    case "Amarillo":
                         for(JInternalFrame i: escritorio.getAllFrames())
                             if(i.isSelected())
                            ((VentanaInterna)i).getLienzo().setColor(EnumColor.AMARILLO); 
                         colorActivo = EnumColor.AMARILLO;
                        break;
                    case "Verde":
                         for(JInternalFrame i: escritorio.getAllFrames())
                             if(i.isSelected())
                            ((VentanaInterna)i).getLienzo().setColor(EnumColor.VERDE);
                         colorActivo = EnumColor.VERDE;
                        break;
             }
            }
        });
        
        //GROSOR
            grosor.addChangeListener(new ChangeListener(){

            @Override
            public void stateChanged(ChangeEvent e) {
                int valor = 1;

           try{
               valor = (int)grosor.getValue();
           }catch(Exception eX){
               System.err.println("Error excepcion");
           }
            System.out.println("valor");

           if(valor<=0){
               valor = 1;
           }
           
           if(valor>=21){
               valor = 20;
           }

           grosor.setValue(valor);
           for(JInternalFrame i: escritorio.getAllFrames()){
               if(i.isSelected())
                    ((VentanaInterna)i).getLienzo().setGrosor(valor);                
            }
        }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        herramientas = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        brillo = new javax.swing.JSlider();
        jPanel11 = new javax.swing.JPanel();
        filtro = new javax.swing.JComboBox<>();
        jPanel14 = new javax.swing.JPanel();
        sinusoidal = new javax.swing.JButton();
        sepia = new javax.swing.JButton();
        tintar = new javax.swing.JButton();
        ecualizar = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        contraste = new javax.swing.JButton();
        iluminar = new javax.swing.JButton();
        oscurecer = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        bands = new javax.swing.JButton();
        espacioColor = new javax.swing.JComboBox<>();
        jPanel15 = new javax.swing.JPanel();
        sliderRotar = new javax.swing.JSlider();
        rota90 = new javax.swing.JButton();
        rota180 = new javax.swing.JButton();
        rota270 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        escalaMas = new javax.swing.JButton();
        escalaMenos = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jSlider1 = new javax.swing.JSlider();
        jPanel9 = new javax.swing.JPanel();
        estado = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        btn_nuevo = new javax.swing.JButton();
        btn_abrir = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btn_punto = new javax.swing.JToggleButton();
        btn_linea = new javax.swing.JToggleButton();
        btn_rectangulo = new javax.swing.JToggleButton();
        btn_elipse = new javax.swing.JToggleButton();
        btn_edicion = new javax.swing.JToggleButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        selector_color = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        grosor = new javax.swing.JSpinner();
        btn_relleno = new javax.swing.JToggleButton();
        btn_transparencia = new javax.swing.JToggleButton();
        btn_alisar = new javax.swing.JToggleButton();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        nuevo = new javax.swing.JMenuItem();
        abrir = new javax.swing.JMenuItem();
        guardar = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        barraEstado = new javax.swing.JCheckBoxMenuItem();
        barraFormas = new javax.swing.JCheckBoxMenuItem();
        barraAtributos = new javax.swing.JCheckBoxMenuItem();
        imagen = new javax.swing.JMenu();
        tamNuevaImagen = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("File");
        jMenuBar4.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar4.add(jMenu8);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);
        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Brillo"));
        jPanel12.setPreferredSize(new java.awt.Dimension(130, 70));

        brillo.setMaximum(255);
        brillo.setMinimum(-255);
        brillo.setValue(0);
        brillo.setPreferredSize(new java.awt.Dimension(100, 26));
        brillo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                brilloStateChanged(evt);
            }
        });
        brillo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                brilloFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                brilloFocusLost(evt);
            }
        });
        jPanel12.add(brillo);

        jPanel10.add(jPanel12);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));
        jPanel11.setPreferredSize(new java.awt.Dimension(100, 70));
        jPanel11.setLayout(new java.awt.CardLayout());

        filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Media", "Binomial", "Enfoque", "Relieve", "Laplaciano" }));
        filtro.setPreferredSize(new java.awt.Dimension(50, 20));
        filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroActionPerformed(evt);
            }
        });
        jPanel11.add(filtro, "card2");

        jPanel10.add(jPanel11);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("      "));
        jPanel14.setMinimumSize(new java.awt.Dimension(160, 70));
        jPanel14.setPreferredSize(new java.awt.Dimension(250, 70));
        jPanel14.setRequestFocusEnabled(false);

        sinusoidal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/sinusoidal.png"))); // NOI18N
        sinusoidal.setPreferredSize(new java.awt.Dimension(49, 25));
        sinusoidal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sinusoidalMouseClicked(evt);
            }
        });
        sinusoidal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinusoidalActionPerformed(evt);
            }
        });
        jPanel14.add(sinusoidal);

        sepia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/sepia.png"))); // NOI18N
        sepia.setPreferredSize(new java.awt.Dimension(49, 25));
        sepia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sepiaMouseClicked(evt);
            }
        });
        jPanel14.add(sepia);

        tintar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/tintar.png"))); // NOI18N
        tintar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tintar.setPreferredSize(new java.awt.Dimension(49, 25));
        tintar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tintarMouseClicked(evt);
            }
        });
        jPanel14.add(tintar);

        ecualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/ecualizar.png"))); // NOI18N
        ecualizar.setPreferredSize(new java.awt.Dimension(49, 25));
        ecualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ecualizarMouseClicked(evt);
            }
        });
        jPanel14.add(ecualizar);

        jPanel10.add(jPanel14);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Contraste"));
        jPanel13.setPreferredSize(new java.awt.Dimension(160, 70));
        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.LINE_AXIS));

        contraste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/contraste.png"))); // NOI18N
        contraste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contrasteMouseClicked(evt);
            }
        });
        jPanel13.add(contraste);

        iluminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/iluminar.png"))); // NOI18N
        iluminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iluminarMouseClicked(evt);
            }
        });
        jPanel13.add(iluminar);

        oscurecer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/oscurecer.png"))); // NOI18N
        oscurecer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oscurecerMouseClicked(evt);
            }
        });
        jPanel13.add(oscurecer);

        jPanel10.add(jPanel13);

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Color"));
        jPanel17.setToolTipText("");
        jPanel17.setPreferredSize(new java.awt.Dimension(160, 70));

        bands.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/bandas.png"))); // NOI18N
        bands.setPreferredSize(new java.awt.Dimension(49, 25));
        bands.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bandsMouseClicked(evt);
            }
        });
        jPanel17.add(bands);

        espacioColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RGB", "YCC", "GREY" }));
        espacioColor.setSelectedIndex(-1);
        espacioColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                espacioColorActionPerformed(evt);
            }
        });
        jPanel17.add(espacioColor);

        jPanel10.add(jPanel17);

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Rotación"));

        sliderRotar.setMaximum(360);
        sliderRotar.setValue(0);
        sliderRotar.setPreferredSize(new java.awt.Dimension(100, 26));
        sliderRotar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderRotarStateChanged(evt);
            }
        });
        sliderRotar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sliderRotarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                sliderRotarFocusLost(evt);
            }
        });
        jPanel15.add(sliderRotar);

        rota90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/rotacion90.png"))); // NOI18N
        rota90.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rota90MouseClicked(evt);
            }
        });
        jPanel15.add(rota90);

        rota180.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/rotacion180.png"))); // NOI18N
        rota180.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rota180MouseClicked(evt);
            }
        });
        jPanel15.add(rota180);

        rota270.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/rotacion270.png"))); // NOI18N
        rota270.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rota270MouseClicked(evt);
            }
        });
        jPanel15.add(rota270);

        jPanel10.add(jPanel15);

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Escala"));

        escalaMas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/aumentar.png"))); // NOI18N
        escalaMas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                escalaMasMouseClicked(evt);
            }
        });
        jPanel16.add(escalaMas);

        escalaMenos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/disminuir.png"))); // NOI18N
        escalaMenos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                escalaMenosMouseClicked(evt);
            }
        });
        jPanel16.add(escalaMenos);

        jPanel10.add(jPanel16);

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder("Umbralización"));
        jPanel18.setPreferredSize(new java.awt.Dimension(130, 70));

        jSlider1.setPreferredSize(new java.awt.Dimension(100, 26));
        jPanel18.add(jSlider1);

        jPanel10.add(jPanel18);

        jPanel8.add(jPanel10, java.awt.BorderLayout.LINE_START);

        jPanel7.add(jPanel8, java.awt.BorderLayout.PAGE_START);

        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        estado.setText("Estado");
        jPanel9.add(estado);

        jPanel7.add(jPanel9, java.awt.BorderLayout.PAGE_END);

        jPanel6.add(jPanel7, java.awt.BorderLayout.PAGE_END);

        jPanel5.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.BorderLayout());

        jToolBar2.setRollover(true);

        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/nuevo.png"))); // NOI18N
        btn_nuevo.setFocusable(false);
        btn_nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_nuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_nuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_nuevoMouseClicked(evt);
            }
        });
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        jToolBar2.add(btn_nuevo);

        btn_abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/abrir.png"))); // NOI18N
        btn_abrir.setFocusable(false);
        btn_abrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_abrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_abrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_abrirMouseClicked(evt);
            }
        });
        btn_abrir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_abrirKeyPressed(evt);
            }
        });
        jToolBar2.add(btn_abrir);

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/guardar.png"))); // NOI18N
        btn_guardar.setFocusable(false);
        btn_guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_guardarMouseClicked(evt);
            }
        });
        jToolBar2.add(btn_guardar);
        jToolBar2.add(jSeparator1);

        herramientas.add(btn_punto);
        btn_punto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/punto.png"))); // NOI18N
        btn_punto.setFocusable(false);
        btn_punto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_punto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_punto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_puntoActionPerformed(evt);
            }
        });
        jToolBar2.add(btn_punto);

        herramientas.add(btn_linea);
        btn_linea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/linea.png"))); // NOI18N
        btn_linea.setFocusable(false);
        btn_linea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_linea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_linea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lineaActionPerformed(evt);
            }
        });
        jToolBar2.add(btn_linea);

        herramientas.add(btn_rectangulo);
        btn_rectangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/rectangulo.png"))); // NOI18N
        btn_rectangulo.setFocusable(false);
        btn_rectangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_rectangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_rectangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rectanguloActionPerformed(evt);
            }
        });
        jToolBar2.add(btn_rectangulo);

        herramientas.add(btn_elipse);
        btn_elipse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/elipse.png"))); // NOI18N
        btn_elipse.setFocusable(false);
        btn_elipse.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_elipse.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_elipse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elipseActionPerformed(evt);
            }
        });
        jToolBar2.add(btn_elipse);

        herramientas.add(btn_edicion);
        btn_edicion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/seleccion.png"))); // NOI18N
        btn_edicion.setFocusable(false);
        btn_edicion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_edicion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_edicion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_edicionMouseClicked(evt);
            }
        });
        btn_edicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edicionActionPerformed(evt);
            }
        });
        jToolBar2.add(btn_edicion);
        jToolBar2.add(jSeparator2);

        selector_color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selector_colorActionPerformed(evt);
            }
        });
        jToolBar2.add(selector_color);
        jToolBar2.add(jSeparator3);

        grosor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grosorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                grosorMouseEntered(evt);
            }
        });
        jToolBar2.add(grosor);

        btn_relleno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/rellenar.png"))); // NOI18N
        btn_relleno.setFocusable(false);
        btn_relleno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_relleno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_relleno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_rellenoMouseClicked(evt);
            }
        });
        jToolBar2.add(btn_relleno);

        btn_transparencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/transparencia.png"))); // NOI18N
        btn_transparencia.setFocusable(false);
        btn_transparencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_transparencia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_transparencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_transparenciaMouseClicked(evt);
            }
        });
        btn_transparencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transparenciaActionPerformed(evt);
            }
        });
        jToolBar2.add(btn_transparencia);

        btn_alisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/alisar.png"))); // NOI18N
        btn_alisar.setFocusable(false);
        btn_alisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_alisar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_alisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_alisarMouseClicked(evt);
            }
        });
        jToolBar2.add(btn_alisar);

        jPanel4.add(jToolBar2, java.awt.BorderLayout.PAGE_START);

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        escritorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                escritorioMouseClicked(evt);
            }
        });
        jPanel2.add(escritorio, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jMenu3.setText("Archivo");

        nuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK));
        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/nuevo.png"))); // NOI18N
        nuevo.setText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        jMenu3.add(nuevo);

        abrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/abrir.png"))); // NOI18N
        abrir.setText("Abrir");
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });
        jMenu3.add(abrir);

        guardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK));
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica12/iconos/guardar.png"))); // NOI18N
        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jMenu3.add(guardar);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edicion");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });

        barraEstado.setSelected(true);
        barraEstado.setText("Barra Estado");
        barraEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barraEstadoMouseClicked(evt);
            }
        });
        barraEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barraEstadoActionPerformed(evt);
            }
        });
        jMenu4.add(barraEstado);

        barraFormas.setSelected(true);
        barraFormas.setText("Barra de Formas");
        barraFormas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barraFormasMouseClicked(evt);
            }
        });
        barraFormas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barraFormasActionPerformed(evt);
            }
        });
        jMenu4.add(barraFormas);

        barraAtributos.setSelected(true);
        barraAtributos.setText("Barra de Atributos");
        barraAtributos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barraAtributosMouseClicked(evt);
            }
        });
        barraAtributos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barraAtributosActionPerformed(evt);
            }
        });
        jMenu4.add(barraAtributos);

        jMenuBar2.add(jMenu4);

        imagen.setText("Imagen");

        tamNuevaImagen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        tamNuevaImagen.setText("Tamaño nueva imagen");
        imagen.add(tamNuevaImagen);

        jMenuBar2.add(imagen);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selector_colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selector_colorActionPerformed
        System.out.println("practica8.Principal.selector_colorActionPerformed()");
    }//GEN-LAST:event_selector_colorActionPerformed

    private void btn_transparenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transparenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_transparenciaActionPerformed

    private void btn_puntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_puntoActionPerformed
        for(JInternalFrame i: this.escritorio.getAllFrames()){
            if(i.isSelected()){
                ((VentanaInterna)i).getLienzo().setHerramienta(EnumHerramienta.LAPIZ);
                ((VentanaInterna)i).getLienzo().setEditar(false);
            }

        }
        this.estado.setText(EnumHerramienta.LAPIZ.toString());
        this.herramientaActiva = EnumHerramienta.LAPIZ;
    }//GEN-LAST:event_btn_puntoActionPerformed

    private void btn_lineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lineaActionPerformed
       for(JInternalFrame i: this.escritorio.getAllFrames()){
           if(i.isSelected()){
                ((VentanaInterna)i).getLienzo().setHerramienta(EnumHerramienta.LINEA);
                ((VentanaInterna)i).getLienzo().setEditar(false);
           }
        }
       this.estado.setText(EnumHerramienta.LINEA.toString());
       this.herramientaActiva = EnumHerramienta.LINEA;
    }//GEN-LAST:event_btn_lineaActionPerformed

    private void btn_rectanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rectanguloActionPerformed
        for(JInternalFrame i: this.escritorio.getAllFrames()){
            if(i.isSelected()){
                ((VentanaInterna)i).getLienzo().setHerramienta(EnumHerramienta.RECTANGULO);
                ((VentanaInterna)i).getLienzo().setEditar(false);
            }
        }
        this.estado.setText(EnumHerramienta.RECTANGULO.toString());
        this.herramientaActiva = EnumHerramienta.RECTANGULO;
    }//GEN-LAST:event_btn_rectanguloActionPerformed

    private void btn_elipseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elipseActionPerformed
        for(JInternalFrame i: this.escritorio.getAllFrames()){
            if(i.isSelected()){
                ((VentanaInterna)i).getLienzo().setHerramienta(EnumHerramienta.CIRCULO);
                ((VentanaInterna)i).getLienzo().setEditar(false);
            }
        }
        this.estado.setText(EnumHerramienta.CIRCULO.toString());
        this.herramientaActiva = EnumHerramienta.CIRCULO;
    }//GEN-LAST:event_btn_elipseActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
          aniadeInternalFrame();
          
    }//GEN-LAST:event_nuevoActionPerformed

    private void aniadeInternalFrame(){
        VentanaInterna v = new VentanaInterna(this);
        
        v.getLienzo().setLienzo(EnumHerramienta.LAPIZ, EnumColor.NEGRO,1, false,false,false,false);
        this.escritorio.add(v);
        

        
        v.setVisible(true);
        
        BufferedImage img;
        
        img = new BufferedImage(v.getLienzo().getWidth(),v.getLienzo().getHeight(),BufferedImage.TYPE_INT_RGB);
        ((Lienzo2dImage)v.getLienzo()).setImage(img);
        
        Graphics2D g2 = img.createGraphics();
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, img.getWidth(), img.getHeight());
        

       
        
        
    }
    //No Actualiza herramientas al seleccionar el nuevo lienzo
    private void escritorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_escritorioMouseClicked
    }//GEN-LAST:event_escritorioMouseClicked

    private void grosorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grosorMouseClicked
        
    }//GEN-LAST:event_grosorMouseClicked

    private void grosorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grosorMouseEntered
       
    }//GEN-LAST:event_grosorMouseEntered

    private void btn_rellenoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_rellenoMouseClicked

        for(JInternalFrame i: this.escritorio.getAllFrames()){
            if(i.isSelected())
                ((VentanaInterna)i).getLienzo().setRellenar(btn_relleno.isSelected());
        }
 

    }//GEN-LAST:event_btn_rellenoMouseClicked

    private void btn_transparenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_transparenciaMouseClicked
        for(JInternalFrame i: this.escritorio.getAllFrames()){
            if(i.isSelected()){
                ((VentanaInterna)i).getLienzo().setTransparencia(btn_transparencia.isSelected());
                ((VentanaInterna)i).getLienzo().repaint();
            }
        }
    }//GEN-LAST:event_btn_transparenciaMouseClicked

    private void btn_alisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_alisarMouseClicked
        for(JInternalFrame i: this.escritorio.getAllFrames()){
            if(i.isSelected()){
                ((VentanaInterna)i).getLienzo().setAlisado(btn_alisar.isSelected());
                ((VentanaInterna)i).getLienzo().repaint();
            }
        }
    }//GEN-LAST:event_btn_alisarMouseClicked

    private void btn_edicionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edicionMouseClicked
        for(JInternalFrame i: this.escritorio.getAllFrames()){
            if(i.isSelected()){
                ((VentanaInterna)i).getLienzo().setHerramienta(EnumHerramienta.NINGUNO);
                ((VentanaInterna)i).getLienzo().setEditar(btn_edicion.isSelected());
                ((VentanaInterna)i).getLienzo().repaint();
            }
        }
        this.estado.setText("Edicionf");
    }//GEN-LAST:event_btn_edicionMouseClicked

    private JInternalFrame getInternalActivo() {                                         
        for(JInternalFrame i: this.escritorio.getAllFrames()){
            if(i.isSelected()){
                return i;
            }
        }
        return null;
    } 
    private void btn_nuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevoMouseClicked
        aniadeInternalFrame();
    }//GEN-LAST:event_btn_nuevoMouseClicked

    private void btn_abrirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_abrirKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_abrirKeyPressed

    private void btn_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_guardarMouseClicked
        guardar();
    }//GEN-LAST:event_btn_guardarMouseClicked

    private void btn_abrirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_abrirMouseClicked
        abrir();
    }//GEN-LAST:event_btn_abrirMouseClicked

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        abrir();
    }//GEN-LAST:event_abrirActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        guardar();
    }//GEN-LAST:event_guardarActionPerformed

    private void btn_edicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edicionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_edicionActionPerformed

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu4MouseClicked

    private void barraAtributosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraAtributosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_barraAtributosMouseClicked

    private void barraFormasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraFormasMouseClicked

    }//GEN-LAST:event_barraFormasMouseClicked

    private void barraEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraEstadoMouseClicked

    }//GEN-LAST:event_barraEstadoMouseClicked

    private void barraFormasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barraFormasActionPerformed
        boolean state = barraFormas.isSelected();
        this.btn_punto.setVisible(state);
        this.btn_linea.setVisible(state);
        this.btn_rectangulo.setVisible(state);
        this.btn_elipse.setVisible(state);
        this.btn_edicion.setVisible(state);
    }//GEN-LAST:event_barraFormasActionPerformed

    private void barraEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barraEstadoActionPerformed
        this.estado.setVisible(barraEstado.isSelected());
        this.repaint();
    }//GEN-LAST:event_barraEstadoActionPerformed

    private void barraAtributosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barraAtributosActionPerformed
        boolean state = barraAtributos.isSelected();
        this.btn_alisar.setVisible(state);
        this.btn_relleno.setVisible(state);
        this.btn_transparencia.setVisible(state);
        this.grosor.setVisible(state);
        this.selector_color.setVisible(state);
    }//GEN-LAST:event_barraAtributosActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void brilloStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_brilloStateChanged
        
        if(imgSource != null){
             VentanaInterna vi = (VentanaInterna) (escritorio.getSelectedFrame());
             if(vi!=null){
                try{
                    RescaleOp rop = new RescaleOp(1.0F, brillo.getValue(), null);
                    rop.filter(imgSource, ((Lienzo2dImage)vi.getLienzo()).getImage());
                    vi.getLienzo().repaint();
                } catch(IllegalArgumentException e){
                    System.err.println(e.getLocalizedMessage());
                }
             }      
 
        }
      
        
    }//GEN-LAST:event_brilloStateChanged

    private void brilloFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brilloFocusGained
          
        VentanaInterna selec = (VentanaInterna) escritorio.getSelectedFrame();
        
        if(selec != null){
             ColorModel cm = ((Lienzo2dImage)selec.getLienzo()).getImage().getColorModel();
             WritableRaster raster = ((Lienzo2dImage)selec.getLienzo()).getImage().copyData(null);
             boolean alfaPre = ((Lienzo2dImage)selec.getLienzo()).getImage().isAlphaPremultiplied();
             imgSource = new BufferedImage(cm,raster,alfaPre,null); 

        }
    }//GEN-LAST:event_brilloFocusGained

    private void brilloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brilloFocusLost
        imgSource = null;
               
    }//GEN-LAST:event_brilloFocusLost

    private void filtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroActionPerformed
        VentanaInterna selec = (VentanaInterna) escritorio.getSelectedFrame();
        
        if(selec != null){
             ((Lienzo2dImage)selec.getLienzo()).aplicaFiltro(filtro.getSelectedItem().toString());
        }     

    }//GEN-LAST:event_filtroActionPerformed

    private void contrasteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contrasteMouseClicked
        VentanaInterna selec = (VentanaInterna) escritorio.getSelectedFrame();
        
        if(selec != null){
             ((Lienzo2dImage)selec.getLienzo()).contraste();
        }     }//GEN-LAST:event_contrasteMouseClicked

    private void iluminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iluminarMouseClicked
        VentanaInterna selec = (VentanaInterna) escritorio.getSelectedFrame();
        
        if(selec != null){
             ((Lienzo2dImage)selec.getLienzo()).iluminar();
        } 
    }//GEN-LAST:event_iluminarMouseClicked

    private void oscurecerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oscurecerMouseClicked
        VentanaInterna selec = (VentanaInterna) escritorio.getSelectedFrame();
        
        if(selec != null){
             ((Lienzo2dImage)selec.getLienzo()).oscurecer();
        }
     }//GEN-LAST:event_oscurecerMouseClicked

    private void sinusoidalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sinusoidalMouseClicked
        VentanaInterna selec = (VentanaInterna) escritorio.getSelectedFrame();
        
        if(selec != null){
             ((Lienzo2dImage)selec.getLienzo()).sinusoidal();
        }    }//GEN-LAST:event_sinusoidalMouseClicked

    private void rota90MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rota90MouseClicked
        VentanaInterna selec = (VentanaInterna) escritorio.getSelectedFrame();
        
        if(selec != null){
             ((Lienzo2dImage)selec.getLienzo()).rota(90);
        } 
    }//GEN-LAST:event_rota90MouseClicked

    private void rota180MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rota180MouseClicked
        VentanaInterna selec = (VentanaInterna) escritorio.getSelectedFrame();
        
        if(selec != null){
             ((Lienzo2dImage)selec.getLienzo()).rota(180);
        } 
    }//GEN-LAST:event_rota180MouseClicked

    private void rota270MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rota270MouseClicked
        VentanaInterna selec = (VentanaInterna) escritorio.getSelectedFrame();
        
        if(selec != null){
             ((Lienzo2dImage)selec.getLienzo()).rota(270);
        } 
    }//GEN-LAST:event_rota270MouseClicked

    private void escalaMasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_escalaMasMouseClicked
        VentanaInterna selec = (VentanaInterna) escritorio.getSelectedFrame();
        
        if(selec != null){
             ((Lienzo2dImage)selec.getLienzo()).escala(1.25f,1.25f);
        }     
    }//GEN-LAST:event_escalaMasMouseClicked

    private void escalaMenosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_escalaMenosMouseClicked
        VentanaInterna selec = (VentanaInterna) escritorio.getSelectedFrame();
        
        if(selec != null){
             ((Lienzo2dImage)selec.getLienzo()).escala(0.75f,0.75f);
        }     
    }//GEN-LAST:event_escalaMenosMouseClicked

    private void sliderRotarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sliderRotarFocusGained
        VentanaInterna selec = (VentanaInterna) escritorio.getSelectedFrame();
        
        if(selec != null){
             ColorModel cm = ((Lienzo2dImage)selec.getLienzo()).getImage().getColorModel();
             WritableRaster raster = ((Lienzo2dImage)selec.getLienzo()).getImage().copyData(null);
             boolean alfaPre = ((Lienzo2dImage)selec.getLienzo()).getImage().isAlphaPremultiplied();
             imgSource = new BufferedImage(cm,raster,alfaPre,null); 

        }

    }//GEN-LAST:event_sliderRotarFocusGained

    private void sliderRotarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sliderRotarFocusLost
        imgSource=null;
    }//GEN-LAST:event_sliderRotarFocusLost
 
    public void rota(int grados,BufferedImage img){
        double r = Math.toRadians(grados);
        Point p = new Point(img.getWidth()/2, img.getHeight()/2);
        AffineTransform at = AffineTransform.getRotateInstance(r,p.x,p.y);
        
        try{
            AffineTransformOp atop = new AffineTransformOp(at,AffineTransformOp.TYPE_BILINEAR);
            BufferedImage imgdest = atop.filter( img, null);
            //setImage(imgdest);
            VentanaInterna selec = (VentanaInterna) (escritorio.getSelectedFrame());
            if(selec!=null){
                ((Lienzo2dImage)selec.getLienzo()).setImage(imgdest);
                ((Lienzo2dImage)selec.getLienzo()).repaint();
            }

        }catch(Exception e){
            System.err.println("Error "+e.getMessage());
        }        
    }
    
    private void sliderRotarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderRotarStateChanged
        int rotar = sliderRotar.getValue()-rotaAnterior;
        VentanaInterna selec = (VentanaInterna) (escritorio.getSelectedFrame());
        try{
            rota(sliderRotar.getValue(),imgSource);
        } catch(IllegalArgumentException e){
            System.err.println(e.getLocalizedMessage());
        }
        rotaAnterior = sliderRotar.getValue();
                   
 
        
    }//GEN-LAST:event_sliderRotarStateChanged

    private void sinusoidalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinusoidalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sinusoidalActionPerformed

    private void bandsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bandsMouseClicked
        VentanaInterna selec = (VentanaInterna) (escritorio.getSelectedFrame());

        if(selec!=null){
            
            BufferedImage src = ((Lienzo2dImage)selec.getLienzo()).getImage();

            //Creamos el modelo de color de la nueva imagen basado en un espcio de color GRAY
            ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
            ComponentColorModel cm = new ComponentColorModel(cs, false, false,
            Transparency.OPAQUE,
            DataBuffer.TYPE_BYTE);
            //Creamos el nuevo raster a partir del raster de la imagen original
            for(int band = 0; band<src.getRaster().getNumBands();band++){
                
                int bandList[] = {band};
                WritableRaster bandRaster = (WritableRaster)src.getRaster().createWritableChild(0,0,
                src.getWidth(), src.getHeight(), 0, 0, bandList);
                //Creamos una nueva imagen que contiene como raster el correspondiente a la banda
                BufferedImage imgBanda = new BufferedImage(cm, bandRaster, false, null);
                
                VentanaInterna vi = new VentanaInterna(this);
                ((Lienzo2dImage)vi.getLienzo()).setImage(imgBanda);
                this.escritorio.add(vi);
                vi.setTitle(selec.getTitle()+" {"+band+"} ");
                vi.setVisible(true);
                vi.setResizable(true);
                
            }            
            
        }
        

    }//GEN-LAST:event_bandsMouseClicked

    private void espacioColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_espacioColorActionPerformed
        String opt = espacioColor.getSelectedItem().toString();
        ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_sRGB);

        switch(opt){
            case "RGB":
                cs = ColorSpace.getInstance(ColorSpace.CS_sRGB);
                break;
            case "YCC":
                cs = ColorSpace.getInstance(ColorSpace.CS_PYCC);
                break;
            case "GREY":
                cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
                break;
                
        }
        
        VentanaInterna selec = (VentanaInterna) (escritorio.getSelectedFrame());

        if(selec!=null){
            
            BufferedImage src = ((Lienzo2dImage)selec.getLienzo()).getImage();
            BufferedImage imgOut;
            
            //if (src.getColorModel().getColorSpace().isCS_sRGB()) {
                ColorConvertOp cop = new ColorConvertOp(cs, null);
                imgOut = cop.filter(src, null);
                
                VentanaInterna vi = new VentanaInterna(this);
                ((Lienzo2dImage)vi.getLienzo()).setImage(imgOut);
                this.escritorio.add(vi);
                vi.setTitle(selec.getTitle()+" ["+opt+"] ");
                vi.setVisible(true);
                vi.setResizable(true);

                
//}
        }
        

        

    }//GEN-LAST:event_espacioColorActionPerformed

    private void tintarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tintarMouseClicked

        VentanaInterna selec = (VentanaInterna) (escritorio.getSelectedFrame());

        if(selec!=null){
            ((Lienzo2dImage)(selec.getLienzo())).tintaImagen();
        }
                    
    }//GEN-LAST:event_tintarMouseClicked

    private void ecualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ecualizarMouseClicked

        VentanaInterna selec = (VentanaInterna) (escritorio.getSelectedFrame());

        if(selec!=null){
            ((Lienzo2dImage)(selec.getLienzo())).ecualizaImagen();
        }
    }//GEN-LAST:event_ecualizarMouseClicked

    private void sepiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sepiaMouseClicked
        VentanaInterna selec = (VentanaInterna) (escritorio.getSelectedFrame());

        if(selec!=null){
            ((Lienzo2dImage)(selec.getLienzo())).sepiaImagen();
        }
    }//GEN-LAST:event_sepiaMouseClicked

    
    
    
    private void guardar(){
        JFileChooser dlg = new JFileChooser();
        int resp = dlg.showOpenDialog(this);
        if( resp == JFileChooser.APPROVE_OPTION) {
            
            try {
                VentanaInterna activa = ((VentanaInterna)getInternalActivo());
                BufferedImage img = ((Lienzo2dImage)(activa.getLienzo())).getImage(true);
                if (img != null) {
                    File f = dlg.getSelectedFile();
                    ImageIO.write(img, "jpg", f);
                    activa.setTitle(f.getName());
                }
                }catch (Exception ex) {
                    System.err.println("Error al guardar la imagen");
                }

        }
    }

    private void abrir(){
        
        JFileChooser dlg = new JFileChooser();
        int resp = dlg.showOpenDialog(this);
        if( resp == JFileChooser.APPROVE_OPTION) {
            try{
                File f = dlg.getSelectedFile();
                BufferedImage img = ImageIO.read(f);
                VentanaInterna vi = new VentanaInterna(this);
                ((Lienzo2dImage)vi.getLienzo()).setImage(img);
                this.escritorio.add(vi);
                vi.setTitle(f.getName());
                vi.setVisible(true);

                
                
                }catch(Exception ex){
                    System.err.println(ex.toString());
                }

        }
    }
    
   public void setEstado(String sta){
       this.estado.setText(sta);
   }
    
   public void setLapiz(boolean state){
       this.btn_punto.setSelected(state);
   }
   
   public void setLine(boolean state){
       this.btn_linea.setSelected(state);
   }
   
   public void setRectangulo(boolean state){
       this.btn_rectangulo.setSelected(state);
   }
   
   public void setElipse(boolean state){
       this.btn_elipse.setSelected(state);
   }
   
   public void setEdicion(boolean state){
       this.btn_edicion.setSelected(state);
   }
   
   public void setColor(String color){
       //this.selector_color.setSelectedIndex();
       String c = "Negro";
       int pos = 0;
       
        for(JInternalFrame i: this.escritorio.getAllFrames()){
            if(i.isSelected()){
                c = ((VentanaInterna)i).getLienzo().getColor().toString();
            }
        }
        
        switch(c){
            case "Negro":
                pos = 0;      
                break;
            case "Rojo":
                pos = 1;
                break;
            case "Azul":
                pos = 2;
                break;
            case "Blanco":
                pos = 3;
                break;
            case "Amarillo":
                pos = 4;
                break;
            case "Verde":
                pos = 5;
                break;
        }
        this.selector_color.setSelectedIndex(pos);   
   }
   
   public void setGrosor(int gro){
       this.grosor.setValue(gro);
   }
   
   public void setRelleno(boolean state){
       this.btn_relleno.setSelected(state);
   }
   
   public void setTransparencia(boolean state){
       this.btn_transparencia.setSelected(state);
   }
   
      public void setAlisar(boolean state){
       this.btn_alisar.setSelected(state);
   }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrir;
    private javax.swing.JButton bands;
    private javax.swing.JCheckBoxMenuItem barraAtributos;
    private javax.swing.JCheckBoxMenuItem barraEstado;
    private javax.swing.JCheckBoxMenuItem barraFormas;
    private javax.swing.JSlider brillo;
    private javax.swing.JButton btn_abrir;
    private javax.swing.JToggleButton btn_alisar;
    private javax.swing.JToggleButton btn_edicion;
    private javax.swing.JToggleButton btn_elipse;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JToggleButton btn_linea;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JToggleButton btn_punto;
    private javax.swing.JToggleButton btn_rectangulo;
    private javax.swing.JToggleButton btn_relleno;
    private javax.swing.JToggleButton btn_transparencia;
    private javax.swing.JButton contraste;
    private javax.swing.JButton ecualizar;
    private javax.swing.JButton escalaMas;
    private javax.swing.JButton escalaMenos;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JComboBox<String> espacioColor;
    private javax.swing.JLabel estado;
    private javax.swing.JComboBox<String> filtro;
    private javax.swing.JSpinner grosor;
    private javax.swing.JMenuItem guardar;
    private javax.swing.ButtonGroup herramientas;
    private javax.swing.JButton iluminar;
    private javax.swing.JMenu imagen;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JMenuItem nuevo;
    private javax.swing.JButton oscurecer;
    private javax.swing.JButton rota180;
    private javax.swing.JButton rota270;
    private javax.swing.JButton rota90;
    private javax.swing.JComboBox<String> selector_color;
    private javax.swing.JButton sepia;
    private javax.swing.JButton sinusoidal;
    private javax.swing.JSlider sliderRotar;
    private javax.swing.JMenuItem tamNuevaImagen;
    private javax.swing.JButton tintar;
    // End of variables declaration//GEN-END:variables

 

        



}
