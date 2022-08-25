/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JButton;
import javax.swing.border.Border;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Misael
 */
public class Iterinario_Registro extends javax.swing.JFrame implements Printable {

    static Connection conn = null;
    static Statement st = null;
    static ResultSet rs = null;
    static ResultSet rs1 = null;
    static ResultSet rs2 = null;
    static ResultSet rs3 = null;
    static ResultSet rs4 = null;
    static ResultSet rs5 = null;
    static ResultSet rs6 = null;
    static ResultSet rs7 = null;
    static ResultSet rs8 = null;
    static ResultSet rs9 = null;
    static ResultSet rs10 = null;

    // DefaultComboBoxModel tipodispositivo = new DefaultComboBoxModel();
    DefaultComboBoxModel marcalaptop = new DefaultComboBoxModel();
    DefaultComboBoxModel marcaprocesador = new DefaultComboBoxModel();
    DefaultComboBoxModel marcadisco = new DefaultComboBoxModel();
    DefaultComboBoxModel marcaram = new DefaultComboBoxModel();
    DefaultComboBoxModel marcaplaca = new DefaultComboBoxModel();
    DefaultComboBoxModel marcatarvi = new DefaultComboBoxModel();
    DefaultComboBoxModel marcaimpresora = new DefaultComboBoxModel();
    DefaultComboBoxModel dispo = new DefaultComboBoxModel();

    public int simple;

    public void setSimple(int sim) {
        simple = sim;
    }

    /**
     * Creates new form Iterinario_Registro
     */
    public Iterinario_Registro() {
        initComponents();
        buttontransparente();
        txtcodigoiterinario.setEnabled(true);
        txtcodigoiterinario.setEditable(true);
        btnguardar.setEnabled(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Recursos/logo.png")));
        setVisible(true);

        pimpresora.setVisible(false);
       //pdatos.setVisible(false);
        //paccesorios.setVisible(false);
        setTitle("Registro de servicio técnico de Mak-Pc Enterprises Sac");
        //  cbotipodis.setModel(tipodispositivo);
        cbomarca_dispositivo.setModel(marcalaptop);
        cboprocesador.setModel(marcaprocesador);
        cbodisco.setModel(marcadisco);
        cbomarram.setModel(marcaram);
        cboplaca.setModel(marcaplaca);
        cbotarvide.setModel(marcatarvi);
        cbomarcaimpresora.setModel(marcaimpresora);
        cbotipodis.setModel(dispo);

        try {
            conn = Acceso.Enlace(conn);
            rs = Acceso.obtenerMarcaDispositivo(rs);
            while (rs.next()) {
                marcalaptop.addElement(rs.getString(1));
            }
            rs1 = Acceso.obtenerMarcaProcesador(rs1);
            while (rs1.next()) {
                marcaprocesador.addElement(rs1.getString(1));
            }

            rs2 = Acceso.obtenerTipoDisco(rs2);
            while (rs2.next()) {
                marcadisco.addElement(rs2.getString(1));
            }
            rs3 = Acceso.obtenerMarcaRam(rs3);
            while (rs3.next()) {
                marcaram.addElement(rs3.getString(1));
            }
            rs4 = Acceso.obtenerMarcaPlaca(rs4);
            while (rs4.next()) {
                marcaplaca.addElement(rs4.getString(1));
            }
            rs5 = Acceso.obtenerMarcaTarjetVideo(rs5);
            while (rs5.next()) {
                marcatarvi.addElement(rs5.getString(1));
            }
            rs10 = Acceso.obtenerMarcaImpresora(rs10);

            while (rs10.next()) {
                marcaimpresora.addElement(rs10.getString(1));
            }
            rs10 = Acceso.obtenerTipoDispo(rs10);

            while (rs10.next()) {
                dispo.addElement(rs10.getString(1));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error BD" + e.getMessage());
        }

        //this.setExtendedState(MAXIMIZED_BOTH);
        //Crea boton.
        JButton myButton = new JButton("my button");
        this.setLocationRelativeTo(null);
        //Define 40 como Radio.
        myButton.setBorder(new RoundedBorder(80));
        txtfecha.setText(fechaActual());
        txtfecha_entrega.setText(fechaDevolver());
    }

    public void borrarnoverlaptop() {
        cbotarvide.removeAll();
        cboalmatarvi.removeAll();
        cboalmatarvi.removeAll();
        cbofuenpo.removeAll();
        cbowafupo.removeAll();
       // txtotros.setText("");

    }

    public void Noverlaptop(boolean lt, boolean a, boolean n, boolean f, boolean t, boolean d, boolean w, boolean k, boolean p, boolean cp, boolean cknf, boolean cknp, boolean cknv) {
        lbltarjetavideo.setVisible(lt);
        cbotarvide.setVisible(a);
        cboalmatarvi.setVisible(n);
        //lbl.setVisible(f);
        cbofuenpo.setVisible(t);
        cbowafupo.setVisible(d);
        lblplaca.setVisible(w);
        cboplaca.setVisible(k);
        cbnofuente.setVisible(cknf);
        cbnoplaca.setVisible(cknp);
        cbnotarjeta.setVisible(cknv);

    }

    public void buttontransparente() {
        btncerrar.setOpaque(false);
        btncerrar.setContentAreaFilled(false);
        btncerrar.setBorderPainted(false);
    }

    public void cargarcodigo()//ESTE ES UN GENERADOR DE CODIGOS AUTOMATICOS PROFE, ESTUVE INVESTIGANDO PARA QUE NO ESTE PONIENDO A CADA RATO ESPERO LE GUSTE
    {

        int j;
        String num = "";
        String c = "";
        String SQL = "select max(id_ite) from nuevo_ite";
        try {
            conn = GenerarCodigo.Enlace(conn);
            st = conn.createStatement();
            rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }

            if (c == null) {
                txtcodigoiterinario.setText("000001");
            } else {
                char r1 = c.charAt(2);
                char r2 = c.charAt(3);
                char r3 = c.charAt(4);
                char r4 = c.charAt(5);
                String r = "";
                r = "" + r1 + r2 + r3 + r4;

                j = Integer.parseInt(r);
                GenerarCodigo gen = new GenerarCodigo();
                gen.generar(j);
                txtcodigoiterinario.setText("00" + gen.serie());

            }

        } catch (Exception e) {
        }

    }

    public static String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-MM-dd");

        return formatoFecha.format(fecha);
    }

    public static String fechaDevolver() {
        Date fechaD = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-MM-");

        return formatoFecha.format(fechaD);
    }

    @Override
    public int print(Graphics graf, PageFormat pagfor, int index) throws PrinterException {

        if (index > 0) {
            return NO_SUCH_PAGE;

        }
        Graphics2D hub = (Graphics2D) graf;
        hub.translate(pagfor.getImageableX() + 20, pagfor.getImageableY() + 200);
        hub.scale(0.45, 0.45);

        panel.printAll(graf);
        return PAGE_EXISTS;

    }

    class RoundedBorder implements Border {

        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        panel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtdnicli = new javax.swing.JTextField();
        txtnomite = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtcelular = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        lblcodcli = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        pdatos = new javax.swing.JPanel();
        cbomarca_dispositivo = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        txtmodelo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cboprocesador = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        txtcarapro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbodisco = new javax.swing.JComboBox();
        cboalmadisco = new javax.swing.JComboBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        cbomarram = new javax.swing.JComboBox();
        cboalmaram = new javax.swing.JComboBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        cbopantalla = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        cbofuenpo = new javax.swing.JComboBox();
        cbowafupo = new javax.swing.JComboBox();
        cbnofuente = new javax.swing.JCheckBox();
        lblplaca = new javax.swing.JLabel();
        cboplaca = new javax.swing.JComboBox();
        cbnoplaca = new javax.swing.JCheckBox();
        lbltarjetavideo = new javax.swing.JLabel();
        cbotarvide = new javax.swing.JComboBox();
        cboalmatarvi = new javax.swing.JComboBox();
        cbnotarjeta = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lblfuen1 = new javax.swing.JLabel();
        btnagregarpc = new javax.swing.JButton();
        lblcodi = new javax.swing.JLabel();
        txtidpc = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        txtidlaptop = new javax.swing.JTextField();
        lbl2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ptotal = new javax.swing.JPanel();
        txtcambiosite = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtacuentaite = new javax.swing.JTextField();
        txttotalite = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtsaldoite = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtobservacionite = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblcodigoite = new javax.swing.JLabel();
        lblhora2 = new javax.swing.JLabel();
        btncerrar = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtfecha_entrega = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbotipodis = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        cboestado = new javax.swing.JComboBox();
        paccesorios = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtdesacce = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbored = new javax.swing.JComboBox();
        cbobateria = new javax.swing.JComboBox();
        cbobluetooth = new javax.swing.JComboBox();
        cbowebcam = new javax.swing.JComboBox();
        cbocargador = new javax.swing.JComboBox();
        cboco = new javax.swing.JComboBox();
        cboa = new javax.swing.JComboBox();
        txtidaccesorios = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        lbl1 = new javax.swing.JLabel();
        btnagregarimpresora1 = new javax.swing.JButton();
        pimpresora = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        cbotipimp = new javax.swing.JComboBox();
        cbomarcaimpresora = new javax.swing.JComboBox();
        txtdesimp = new javax.swing.JTextField();
        txtmodeloim = new javax.swing.JTextField();
        txtfallosimp = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        lblfuen4 = new javax.swing.JLabel();
        txtidimpresora = new javax.swing.JTextField();
        btnagregarimpresora = new javax.swing.JButton();
        txtcodigoiterinario = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 10));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 4));
        jPanel4.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jPanel4ComponentAdded(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Señor(es):");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("DNI:");
        jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtdnicli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdnicliActionPerformed(evt);
            }
        });
        jPanel4.add(txtdnicli, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 160, -1));
        jPanel4.add(txtnomite, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 410, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Celular:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));
        jPanel4.add(txtcelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 160, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Codigo:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        jButton5.setBackground(new java.awt.Color(204, 255, 204));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/bucar_pequeño.png"))); // NOI18N
        jButton5.setText("Buscar");
        jButton5.setToolTipText("");
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 110, 30));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("DATOS DEL CLIENTE");
        jPanel4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblcodcli.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel4.add(lblcodcli, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        jButton7.setBackground(new java.awt.Color(204, 255, 204));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/agregar_pequeño.png"))); // NOI18N
        jButton7.setText("Agregar");
        jButton7.setToolTipText("");
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 110, 30));

        panel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 650, 110));

        pdatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 4));
        pdatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbomarca_dispositivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbomarca_dispositivoActionPerformed(evt);
            }
        });
        pdatos.add(cbomarca_dispositivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 140, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Modelo:");
        pdatos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
        pdatos.add(txtmodelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 140, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Procesador:");
        pdatos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, -1));

        cboprocesador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboprocesadorActionPerformed(evt);
            }
        });
        pdatos.add(cboprocesador, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 140, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Carac. Procesador:");
        pdatos.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));
        pdatos.add(txtcarapro, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 140, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Disco:");
        pdatos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, -1, -1));

        pdatos.add(cbodisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 140, -1));

        cboalmadisco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "120GB", "250GB", "450GB", "500GB", "1TB", "2TB" }));
        pdatos.add(cboalmadisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 40, 140, -1));

        jCheckBox13.setText("No");
        pdatos.add(jCheckBox13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 40, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Memoria RAM:");
        pdatos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, -1, -1));

        pdatos.add(cbomarram, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 80, 140, -1));

        cboalmaram.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2GB", "4GB", "6GB", "8GB", "16GB", "32GB", "64GB" }));
        pdatos.add(cboalmaram, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 80, 140, -1));

        jCheckBox14.setText("No");
        pdatos.add(jCheckBox14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 80, -1, -1));

        jCheckBox15.setText("No");
        pdatos.add(jCheckBox15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, -1));

        cbopantalla.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Ninguna>", "10\"", "11.1\"", "12.3\"", "13\"", "14\"", "14.1\"", "15\"", "15.6\"", "17.1\"" }));
        pdatos.add(cbopantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 140, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Pantalla:");
        pdatos.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        cbofuenpo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "REAL", "COMERCIAL" }));
        pdatos.add(cbofuenpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 120, 140, -1));

        cbowafupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "300W", "350W", "460W", "500W", "600W", "800W" }));
        pdatos.add(cbowafupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 120, 140, -1));

        cbnofuente.setText("No");
        pdatos.add(cbnofuente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 120, -1, -1));

        lblplaca.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblplaca.setText("Placa Madre:");
        pdatos.add(lblplaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, -1));

        pdatos.add(cboplaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 140, -1));

        cbnoplaca.setText("No");
        pdatos.add(cbnoplaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, -1, -1));

        lbltarjetavideo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbltarjetavideo.setText("Tarjeta de Video:");
        pdatos.add(lbltarjetavideo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        pdatos.add(cbotarvide, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 140, -1));

        cboalmatarvi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2GB", "4GB", "6GB", "8GB", "16GB", "32GB", "64GB" }));
        pdatos.add(cboalmatarvi, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 140, -1));

        cbnotarjeta.setText("No");
        pdatos.add(cbnotarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Marca:");
        pdatos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("DATOS DEL DISPOSITIVO");
        pdatos.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblfuen1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblfuen1.setText("Fuente de Poder:");
        pdatos.add(lblfuen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, -1, -1));

        btnagregarpc.setBackground(new java.awt.Color(204, 255, 204));
        btnagregarpc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnagregarpc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/agregar_pequeño.png"))); // NOI18N
        btnagregarpc.setText("+");
        btnagregarpc.setToolTipText("");
        btnagregarpc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnagregarpc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarpcActionPerformed(evt);
            }
        });
        pdatos.add(btnagregarpc, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 70, 30));

        lblcodi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblcodi.setText("PEGAR CODIGO PC:");
        pdatos.add(lblcodi, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, -1, -1));

        txtidpc.setText("000001");
        txtidpc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidpcActionPerformed(evt);
            }
        });
        pdatos.add(txtidpc, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, 130, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("LLAMAR INFORMACION");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        pdatos.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 160, -1, -1));

        txtidlaptop.setText("000001");
        txtidlaptop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidlaptopActionPerformed(evt);
            }
        });
        pdatos.add(txtidlaptop, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 160, 130, -1));

        lbl2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl2.setText("PEGAR CODIGO LAPTOP:");
        pdatos.add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 160, -1, -1));

        panel.add(pdatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 1160, 200));

        ptotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 4));
        ptotal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        ptotal.add(txtcambiosite, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 470, -1));

        jLabel32.setText("Debe:");
        ptotal.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 90, -1, -1));

        jLabel25.setText("Cancela:");
        ptotal.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 60, -1, -1));

        txtacuentaite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtacuentaiteActionPerformed(evt);
            }
        });
        ptotal.add(txtacuentaite, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 60, 110, -1));
        ptotal.add(txttotalite, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, 110, -1));

        jLabel21.setText("Observaciones:");
        ptotal.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        txtsaldoite.setEditable(false);
        ptotal.add(txtsaldoite, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 90, 110, -1));

        jLabel24.setText("Total:");
        ptotal.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, -1, -1));

        jLabel23.setText("Cambios Realizados:");
        ptotal.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        ptotal.add(txtobservacionite, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 470, -1));

        btnguardar.setBackground(new java.awt.Color(0, 204, 255));
        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/guardar_pequeño.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.setToolTipText("");
        btnguardar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        ptotal.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 120, 30));

        btnnuevo.setBackground(new java.awt.Color(0, 204, 0));
        btnnuevo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/agregar_pequeño.png"))); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        ptotal.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IMPRIME(evt);
            }
        });
        ptotal.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 110, 30));

        jScrollPane1.setViewportView(ptotal);

        panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 570, 1160, 140));

        lblcodigoite.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        panel.add(lblcodigoite, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 20, -1, -1));

        lblhora2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblhora2.setText("CODIGO:");
        panel.add(lblhora2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 50, -1, -1));

        btncerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cerrar.png"))); // NOI18N
        btncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrarActionPerformed(evt);
            }
        });
        panel.add(btncerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 10, 50, 30));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/logo_titulo.png"))); // NOI18N
        panel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel14.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        jLabel14.setText("MAK-PC ENTERPRISES SAC\"");
        panel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, -1, -1));

        jLabel28.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        jLabel28.setText("\"REGISTRO DE SOPORTE TÉCNICO DE ");
        panel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Fecha:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        txtfecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtfecha.setEnabled(false);
        txtfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaActionPerformed(evt);
            }
        });
        jPanel1.add(txtfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 110, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Fecha Entrega:");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        jPanel1.add(txtfecha_entrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 110, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("FECHAS Y ENTREGAS");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 80, 230, 110));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("ESTADO:");
        panel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 160, -1, -1));

        cbotipodis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", " " }));
        cbotipodis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotipodisActionPerformed(evt);
            }
        });
        panel.add(cbotipodis, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, 120, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("TIPO:");
        panel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, -1, -1));

        cboestado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "LOCAL", "LIMA" }));
        cboestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboestadoActionPerformed(evt);
            }
        });
        panel.add(cboestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 160, 120, -1));

        paccesorios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 5));
        paccesorios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Cargador:");
        paccesorios.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Bateria:");
        paccesorios.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Web Cam:");
        paccesorios.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Bluetooth");
        paccesorios.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Accesorios:");
        paccesorios.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Descripcion:");
        paccesorios.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));
        paccesorios.add(txtdesacce, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 110, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Red:");
        paccesorios.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 30, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Color:");
        paccesorios.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, -1, -1));

        cbored.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CABLE", "WIFI", "AMBOS" }));
        paccesorios.add(cbored, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 30, 90, -1));

        cbobateria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));
        paccesorios.add(cbobateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 60, -1));

        cbobluetooth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));
        paccesorios.add(cbobluetooth, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, -1, -1));

        cbowebcam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));
        paccesorios.add(cbowebcam, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        cbocargador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));
        paccesorios.add(cbocargador, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        cboco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SIN COLOR", "ROJO", "AZUL", "AMARILLO", "NEGRO", "OTRO" }));
        cboco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbocoActionPerformed(evt);
            }
        });
        paccesorios.add(cboco, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 90, -1));

        cboa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SIN ACCESORIO", "MALETINES", "BOLSO", "MOCHILA", "OTRO" }));
        paccesorios.add(cboa, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 90, -1));

        txtidaccesorios.setText("000001");
        txtidaccesorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidaccesoriosActionPerformed(evt);
            }
        });
        paccesorios.add(txtidaccesorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 90, 130, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("LLAMAR INFORMACION");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        paccesorios.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 90, -1, -1));

        lbl1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl1.setText("PEGAR CODIGO:");
        paccesorios.add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 90, -1, -1));

        btnagregarimpresora1.setBackground(new java.awt.Color(204, 255, 204));
        btnagregarimpresora1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnagregarimpresora1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/agregar_pequeño.png"))); // NOI18N
        btnagregarimpresora1.setText("+");
        btnagregarimpresora1.setToolTipText("");
        btnagregarimpresora1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnagregarimpresora1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarimpresora1ActionPerformed(evt);
            }
        });
        paccesorios.add(btnagregarimpresora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 60, 30));

        panel.add(paccesorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 1160, 130));

        pimpresora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 4));
        pimpresora.setForeground(new java.awt.Color(0, 0, 102));
        pimpresora.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("DATOS DE LA IMPRESORA");
        pimpresora.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("Marca:");
        pimpresora.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("Descripción:");
        pimpresora.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, -1, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("Modelo:");
        pimpresora.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("Tipo de Impresión:");
        pimpresora.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("Fallos:");
        pimpresora.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        cbotipimp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SISTEMA CONTINUO", "TONER", "CARTUCHO", "OTRO", " " }));
        pimpresora.add(cbotipimp, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 150, -1));

        pimpresora.add(cbomarcaimpresora, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 90, -1));
        pimpresora.add(txtdesimp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 350, -1));
        pimpresora.add(txtmodeloim, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 90, -1));

        txtfallosimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfallosimpActionPerformed(evt);
            }
        });
        pimpresora.add(txtfallosimp, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 260, -1));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton8.setText("LLAMAR INFORMACION");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        pimpresora.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 130, -1, -1));

        lblfuen4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblfuen4.setText("PEGAR CODIGO:");
        pimpresora.add(lblfuen4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, -1, -1));

        txtidimpresora.setText("000001");
        txtidimpresora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidimpresoraActionPerformed(evt);
            }
        });
        pimpresora.add(txtidimpresora, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, 130, -1));

        btnagregarimpresora.setBackground(new java.awt.Color(204, 255, 204));
        btnagregarimpresora.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnagregarimpresora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/agregar_pequeño.png"))); // NOI18N
        btnagregarimpresora.setText("+");
        btnagregarimpresora.setToolTipText("");
        btnagregarimpresora.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnagregarimpresora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarimpresoraActionPerformed(evt);
            }
        });
        pimpresora.add(btnagregarimpresora, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 70, 30));

        panel.add(pimpresora, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 1020, 220));

        txtcodigoiterinario.setEditable(false);
        txtcodigoiterinario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtcodigoiterinario.setEnabled(false);
        panel.add(txtcodigoiterinario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 50, 120, -1));

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 1290, 730));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 10));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnagregarimpresoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarimpresoraActionPerformed
        FrmImpresora form12 = new FrmImpresora();
        form12.show();
    }//GEN-LAST:event_btnagregarimpresoraActionPerformed

    private void txtidimpresoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidimpresoraActionPerformed
        String Buscarcliente;//BUSCAMOS LOS CLIENTES EN LA BASE DE DATOS SEGUN SUS CODIGOS
        if (btnnuevo.isEnabled()) {
            try {
                conn = Acceso.Enlace(conn);
                rs = Acceso.ObtenerVistaImpresora(rs);
                Buscarcliente = txtidimpresora.getText();
                boolean encuentra = false;
                while (rs.next()) {
                    if (Buscarcliente.equals(rs.getString(1))) {
                        cbomarcaimpresora.setSelectedItem((String) rs.getString(2));
                        cbotipimp.setSelectedItem((String) rs.getString(3));
                        txtdesimp.setText((String) rs.getString(4));
                        txtmodeloim.setText((String) rs.getString(5));
                        txtfallosimp.setText((String) rs.getString(6));
                        //editable(true,true,true,true,true,true);
                        encuentra = true;
                        break;
                    }
                }
                if (encuentra == false)//SI NO SE ENCUENTRA EL CODIGO DEBERAN SALDRA EL MENSAJE DE NO EXISTEN DATOS
                {
                    JOptionPane.showMessageDialog(null, "No se hallan datos, corrija el codigo");
                    txtidimpresora.setText("000001");

                    // editable(true,true,true,true,true,true);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR BD" + e.getMessage());
            }
        }
    }//GEN-LAST:event_txtidimpresoraActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String Buscarcliente;//BUSCAMOS LOS CLIENTES EN LA BASE DE DATOS SEGUN SUS CODIGOS
        if (btnnuevo.isEnabled()) {
            try {
                conn = Acceso.Enlace(conn);
                rs = Acceso.ObtenerVistaImpresora(rs);
                Buscarcliente = txtidimpresora.getText();
                boolean encuentra = false;
                while (rs.next()) {
                    if (Buscarcliente.equals(rs.getString(1))) {
                        cbomarcaimpresora.setSelectedItem((String) rs.getString(2));
                        cbotipimp.setSelectedItem((String) rs.getString(3));
                        txtdesimp.setText((String) rs.getString(4));
                        txtmodeloim.setText((String) rs.getString(5));
                        txtfallosimp.setText((String) rs.getString(6));
                        //editable(true,true,true,true,true,true);
                        encuentra = true;
                        break;
                    }
                }
                if (encuentra == false)//SI NO SE ENCUENTRA EL CODIGO DEBERAN SALDRA EL MENSAJE DE NO EXISTEN DATOS
                {
                    JOptionPane.showMessageDialog(null, "No se hallan datos, corrija el codigo");
                    txtidimpresora.setText("000001");

                    // editable(true,true,true,true,true,true);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR BD" + e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txtfallosimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfallosimpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfallosimpActionPerformed

    private void btnagregarimpresora1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarimpresora1ActionPerformed
        FrmAccesorio form13 = new FrmAccesorio();
        form13.show();
    }//GEN-LAST:event_btnagregarimpresora1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String BuscarLaptop;//BUSCAMOS LOS CLIENTES EN LA BASE DE DATOS SEGUN SUS CODIGOS
        //editable(true,true,true,true,true,true,true,true,true,true,true,true);

        if (btnnuevo.isEnabled()) {
            try {
                conn = Acceso.Enlace(conn);
                rs = Acceso.EnlAccesorios(rs);
                BuscarLaptop = txtidaccesorios.getText();
                boolean encuentra = false;
                while (rs.next()) {
                    if (BuscarLaptop.equals(rs.getString(1))) {

                        cbocargador.setSelectedItem((String) rs.getString(2));
                        cbowebcam.setSelectedItem((String) rs.getString(3));
                        cbobateria.setSelectedItem((String) rs.getString(4));
                        cbobluetooth.setSelectedItem((String) rs.getString(5));
                        cbored.setSelectedItem((String) rs.getString(6));
                        cboa.setSelectedItem((String) rs.getString(7));
                        txtdesacce.setText((String) rs.getString(8));
                        cboco.setSelectedItem((String) rs.getString(9));

                        encuentra = true;
                        break;
                    }
                }
                if (encuentra == false)//SI NO SE ENCUENTRA EL CODIGO DEBERAN SALDRA EL MENSAJE DE NO EXISTEN DATOS
                {
                    JOptionPane.showMessageDialog(null, "No se hallan datos, corrija el codigo");
                    txtidaccesorios.setText("000001");

                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR BD" + e.getMessage());
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtidaccesoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidaccesoriosActionPerformed
        String BuscarLaptop;//BUSCAMOS LOS CLIENTES EN LA BASE DE DATOS SEGUN SUS CODIGOS
        //editable(true,true,true,true,true,true,true,true,true,true,true,true);

        if (btnnuevo.isEnabled()) {
            try {
                conn = Acceso.Enlace(conn);
                rs = Acceso.EnlAccesorios(rs);
                BuscarLaptop = txtidaccesorios.getText();
                boolean encuentra = false;
                while (rs.next()) {
                    if (BuscarLaptop.equals(rs.getString(1))) {

                        cbocargador.setSelectedItem((String) rs.getString(2));
                        cbowebcam.setSelectedItem((String) rs.getString(3));
                        cbobateria.setSelectedItem((String) rs.getString(4));
                        cbobluetooth.setSelectedItem((String) rs.getString(5));
                        cbored.setSelectedItem((String) rs.getString(6));
                        cboa.setSelectedItem((String) rs.getString(7));
                        txtdesacce.setText((String) rs.getString(8));
                        cboco.setSelectedItem((String) rs.getString(9));

                        encuentra = true;
                        break;
                    }
                }
                if (encuentra == false)//SI NO SE ENCUENTRA EL CODIGO DEBERAN SALDRA EL MENSAJE DE NO EXISTEN DATOS
                {
                    JOptionPane.showMessageDialog(null, "No se hallan datos, corrija el codigo");
                    txtidaccesorios.setText("NO EXISTE");

                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR BD" + e.getMessage());
            }
        }
    }//GEN-LAST:event_txtidaccesoriosActionPerformed

    private void cbocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbocoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbocoActionPerformed

    private void cboestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboestadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboestadoActionPerformed

    private void cbotipodisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotipodisActionPerformed
        int contenedor;//esta variable de memoria me ayudara a codificar el combobox y
        //En cada case asignarle valor que se añadira a las listas

        contenedor = cbotipodis.getSelectedIndex();
        switch (contenedor) {
            case 0:
                Noverlaptop(true, true, true, true, true, true, true, true, true, true, true, true, true);
                pdatos.setVisible(true);
                paccesorios.setVisible(true);
                pimpresora.setVisible(false);
                lblcodi.setEnabled(true);
                txtidpc.setEnabled(true);
                lbl2.setEnabled(false);
                txtidlaptop.setEnabled(false);

                break;
            case 1:

                Noverlaptop(false, false, false, false, false, false, false, false, false, false, false, false, false);
                pdatos.setVisible(true);
                paccesorios.setVisible(true);
                pimpresora.setVisible(false);
                lblcodi.setEnabled(false);
                txtidpc.setEnabled(false);
                lbl2.setEnabled(true);
                txtidlaptop.setEnabled(true);

                break;
            case 2:
                pdatos.setVisible(false);
                paccesorios.setVisible(false);
                pimpresora.setVisible(true);
                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
        }
    }//GEN-LAST:event_cbotipodisActionPerformed

    private void txtfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaActionPerformed

    private void btncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarActionPerformed

        super.dispose();
    }//GEN-LAST:event_btncerrarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        btnguardar.setEnabled(true);
        btnnuevo.setEnabled(false);
        cargarcodigo();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        int resp;

        resp = JOptionPane.showConfirmDialog(null, "¿Desea grabar el registro?", "Pregunta", 0);
        if (resp == 0) {
            try {
                conn = Acceso.Enlace(conn);
                st = Acceso.sta(st);
                rs = Acceso.EnlIterinario(rs);
                //variables
                String comando, cod, cliente, iddis, dispositivo = "", estado, fecha_ingreso, fecha_entrega, pc, laptop,
                        impresora, accesor, observacion, cambios;
                double total, cuenta, saldo;

                cod = txtcodigoiterinario.getText();
                cliente = lblcodcli.getText();
                iddis = (String) cbotipodis.getSelectedItem();
                rs10 = Acceso.obtenerCodTipDis(rs10, iddis);
                if (rs10.next()) {
                    dispositivo = rs10.getString(1);
                }

                estado = (String) cboestado.getSelectedItem();
                fecha_ingreso = txtfecha.getText();
                fecha_entrega = txtfecha_entrega.getText();

                pc = txtidpc.getText();
                laptop = txtidlaptop.getText();
                impresora = txtidimpresora.getText();
                accesor = txtidaccesorios.getText();
                observacion = txtobservacionite.getText();

                cambios = txtcambiosite.getText();
                total = Double.parseDouble(String.valueOf(txttotalite.getText()));
                cuenta = Double.parseDouble(String.valueOf(txtacuentaite.getText()));
                saldo = Double.parseDouble(String.valueOf(txtsaldoite.getText()));

                //COMANDOS
                comando = "INSERT INTO nuevo_ite VALUES('" + cod + "','" + cliente + "','" + dispositivo + "','" + estado + "','" + fecha_ingreso + "','" + fecha_entrega + "','" + pc + "','" + laptop + "'"
                        + ",'" + impresora + "','" + accesor + "','" + observacion + "','" + cambios + "','" + total + "','" + cuenta + "','" + saldo + "')";
                st.executeUpdate(comando);
                JOptionPane.showMessageDialog(null, "La informacion se guardo con exito");
                btnguardar.setEnabled(false);
                btnnuevo.setEnabled(true);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "La informacion se guardo con exito");
            }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtacuentaiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtacuentaiteActionPerformed
        double total, cancela, debe;
        total = Double.parseDouble(String.valueOf(txttotalite.getText()));
        cancela = Double.parseDouble(String.valueOf(txtacuentaite.getText()));

        debe = total - cancela;

        txtsaldoite.setText(String.valueOf(debe));
    }//GEN-LAST:event_txtacuentaiteActionPerformed

    private void txtidlaptopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidlaptopActionPerformed
        String BuscarLaptop;
        if (btnnuevo.isEnabled()) {
            try {
                conn = Acceso.Enlace(conn);
                rs = Acceso.ObtenerVistaLaptop(rs);
                BuscarLaptop = txtidlaptop.getText();
                boolean encuentra = false;
                while (rs.next()) {
                    if (BuscarLaptop.equals(rs.getString(1))) {
                        cbomarca_dispositivo.setSelectedItem((String) rs.getString(2));
                        cboprocesador.setSelectedItem((String) rs.getString(3));
                        cbodisco.setSelectedItem((String) rs.getString(4));
                        cboalmadisco.setSelectedItem((String) rs.getString(5));
                        txtcarapro.setText((String) rs.getString(6));
                        txtmodelo.setText((String) rs.getString(7));
                        cbomarram.setSelectedItem((String) rs.getString(8));
                        cboalmaram.setSelectedItem((String) rs.getString(9));
                        cbopantalla.setSelectedItem((String) rs.getString(10));
                        encuentra = true;
                        break;
                    }
                }
                if (encuentra == false)//SI NO SE ENCUENTRA EL CODIGO DEBERAN SALDRA EL MENSAJE DE NO EXISTEN DATOS
                {
                    JOptionPane.showMessageDialog(null, "No se hallan datos, corrija el codigo");
                    txtidlaptop.setText("000001");

                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR BD" + e.getMessage());
            }
        }
    }//GEN-LAST:event_txtidlaptopActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int contenedor;//esta variable de memoria me ayudara a codificar el combobox y
        //En cada case asignarle valor que se añadira a las listas
        String BuscarLaptop;
        contenedor = cbotipodis.getSelectedIndex();
        switch (contenedor) {
            case 0:
            //BUSCAMOS LOS CLIENTES EN LA BASE DE DATOS SEGUN SUS CODIGOS
                //  editable(true,true,true,true,true,true,true,true,true,true,true,true);
                if (btnnuevo.isEnabled()) {
                    try {
                        conn = Acceso.Enlace(conn);
                        rs = Acceso.ObtenerVistaPc(rs);
                        BuscarLaptop = txtidpc.getText();
                        boolean encuentra = false;
                        while (rs.next()) {
                            if (BuscarLaptop.equals(rs.getString(1))) {
                                cbomarca_dispositivo.setSelectedItem((String) rs.getString(2));
                                cboprocesador.setSelectedItem((String) rs.getString(3));
                                txtcarapro.setText((String) rs.getString(4));
                                txtmodelo.setText((String) rs.getString(5));
                                cboplaca.setSelectedItem((String) rs.getString(6));
                                cbomarram.setSelectedItem((String) rs.getString(7));
                                cboalmaram.setSelectedItem((String) rs.getString(8));
                                cbodisco.setSelectedItem((String) rs.getString(9));
                                cboalmadisco.setSelectedItem((String) rs.getString(10));
                                cbofuenpo.setSelectedItem((String) rs.getString(11));
                                cbowafupo.setSelectedItem((String) rs.getString(12));
                                cbotarvide.setSelectedItem((String) rs.getString(13));
                                cboalmatarvi.setSelectedItem((String) rs.getString(14));
                                encuentra = true;
                                break;
                            }
                        }
                        if (encuentra == false)//SI NO SE ENCUENTRA EL CODIGO DEBERAN SALDRA EL MENSAJE DE NO EXISTEN DATOS
                        {
                            JOptionPane.showMessageDialog(null, "No se hallan datos, corrija el codigo");
                            txtidpc.setText("000001");

                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "ERROR BD" + e.getMessage());
                    }
                }

                break;
            case 1:

            //BUSCAMOS LOS CLIENTES EN LA BASE DE DATOS SEGUN SUS CODIGOS
                //editable(true,true,true,true,true,true,true,true,true,true,true,true);
                if (btnnuevo.isEnabled()) {
                    try {
                        conn = Acceso.Enlace(conn);
                        rs = Acceso.ObtenerVistaLaptop(rs);
                        BuscarLaptop = txtidlaptop.getText();
                        boolean encuentra = false;
                        while (rs.next()) {
                            if (BuscarLaptop.equals(rs.getString(1))) {
                                cbomarca_dispositivo.setSelectedItem((String) rs.getString(2));
                                cboprocesador.setSelectedItem((String) rs.getString(3));
                                cbodisco.setSelectedItem((String) rs.getString(4));
                                cboalmadisco.setSelectedItem((String) rs.getString(5));
                                txtcarapro.setText((String) rs.getString(6));
                                txtmodelo.setText((String) rs.getString(7));
                                cbomarram.setSelectedItem((String) rs.getString(8));
                                cboalmaram.setSelectedItem((String) rs.getString(9));
                                cbopantalla.setSelectedItem((String) rs.getString(10));
                                encuentra = true;
                                break;
                            }
                        }
                        if (encuentra == false)//SI NO SE ENCUENTRA EL CODIGO DEBERAN SALDRA EL MENSAJE DE NO EXISTEN DATOS
                        {
                            JOptionPane.showMessageDialog(null, "No se hallan datos, corrija el codigo");
                            txtidlaptop.setText("NO EXISTE");

                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "ERROR BD" + e.getMessage());
                    }
                }

                break;
            case 2:

                break;

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtidpcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidpcActionPerformed
        String BuscarLaptop;
        if (btnnuevo.isEnabled()) {
            try {
                conn = Acceso.Enlace(conn);
                rs = Acceso.ObtenerVistaPc(rs);
                BuscarLaptop = txtidpc.getText();
                boolean encuentra = false;
                while (rs.next()) {
                    if (BuscarLaptop.equals(rs.getString(1))) {
                        cbomarca_dispositivo.setSelectedItem((String) rs.getString(2));
                        cboprocesador.setSelectedItem((String) rs.getString(3));
                        txtcarapro.setText((String) rs.getString(4));
                        txtmodelo.setText((String) rs.getString(5));
                        cboplaca.setSelectedItem((String) rs.getString(6));
                        cbomarram.setSelectedItem((String) rs.getString(7));
                        cboalmaram.setSelectedItem((String) rs.getString(8));
                        cbodisco.setSelectedItem((String) rs.getString(9));
                        cboalmadisco.setSelectedItem((String) rs.getString(10));
                        cbofuenpo.setSelectedItem((String) rs.getString(11));
                        cbowafupo.setSelectedItem((String) rs.getString(12));
                        cbotarvide.setSelectedItem((String) rs.getString(13));
                        cboalmatarvi.setSelectedItem((String) rs.getString(14));
                        encuentra = true;
                        break;
                    }
                }
                if (encuentra == false)//SI NO SE ENCUENTRA EL CODIGO DEBERAN SALDRA EL MENSAJE DE NO EXISTEN DATOS
                {
                    JOptionPane.showMessageDialog(null, "No se hallan datos, corrija el codigo");
                    txtidpc.setText("000001");

                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR BD" + e.getMessage());
            }
        }
    }//GEN-LAST:event_txtidpcActionPerformed

    private void btnagregarpcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarpcActionPerformed
        int contenedor;
        contenedor = cbotipodis.getSelectedIndex();
        if (contenedor == 0) {
            FrmPc form2 = new FrmPc();
            form2.show();
        } else if (contenedor == 1) {
            FrmLaptop form3 = new FrmLaptop();
            form3.show();

        }
    }//GEN-LAST:event_btnagregarpcActionPerformed

    private void cboprocesadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboprocesadorActionPerformed

    }//GEN-LAST:event_cboprocesadorActionPerformed

    private void cbomarca_dispositivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbomarca_dispositivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbomarca_dispositivoActionPerformed

    private void jPanel4ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jPanel4ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4ComponentAdded

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        FrmCliente form1 = new FrmCliente();
        form1.show();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String b, b1, b2;

        if (btnnuevo.isEnabled()) {
            try {
                conn = Acceso.Enlace(conn);
                rs = Acceso.obtenerVistaCliente(rs);
                b = txtdnicli.getText();

                boolean encuentra = false;
                while (rs.next()) {
                    if (b.equals(rs.getString(3))) //&& b1.equals(rs.getString(2)) && b2.equals(rs.getString(3)))
                    {
                        lblcodcli.setText((String) rs.getString(1));
                        txtnomite.setText((String) rs.getString(2));
                        txtcelular.setText((String) rs.getString(4));

                        encuentra = true;
                        break;
                    }
                }
                if (encuentra = false) {
                    JOptionPane.showMessageDialog(null, "Digitaste mal el numero");
                    txtnomite.setText("NO EXISTE");

                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR BD" + e.getMessage());
            }

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtdnicliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdnicliActionPerformed
        String b, b1, b2;

        if (btnnuevo.isEnabled()) {
            try {
                conn = Acceso.Enlace(conn);
                rs = Acceso.obtenerVistaCliente(rs);
                b = txtdnicli.getText();

                boolean encuentra = false;
                while (rs.next()) {
                    if (b.equals(rs.getString(3))) //&& b1.equals(rs.getString(2)) && b2.equals(rs.getString(3)))
                    {
                        lblcodcli.setText((String) rs.getString(1));
                        txtnomite.setText((String) rs.getString(2));
                        txtcelular.setText((String) rs.getString(4));

                        encuentra = true;
                        break;
                    }
                }
                if (encuentra = false) {
                    JOptionPane.showMessageDialog(null, "Digitaste mal el numero");
                    txtnomite.setText("NO EXISTE");

                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR BD" + e.getMessage());
            }

        }
    }//GEN-LAST:event_txtdnicliActionPerformed

    private void IMPRIME(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IMPRIME
        try {
            PrinterJob gap = PrinterJob.getPrinterJob();
            gap.setPrintable(this);
            boolean top = gap.printDialog();
            if (top) {

                gap.print();
            }
        } catch (PrinterException pex) {
            JOptionPane.showMessageDialog(null, "Hubo un problema", "El error es: " + pex, JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_IMPRIME

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Iterinario_Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Iterinario_Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Iterinario_Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Iterinario_Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Iterinario_Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregarimpresora;
    private javax.swing.JButton btnagregarimpresora1;
    private javax.swing.JButton btnagregarpc;
    private javax.swing.JButton btncerrar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JCheckBox cbnofuente;
    private javax.swing.JCheckBox cbnoplaca;
    private javax.swing.JCheckBox cbnotarjeta;
    private javax.swing.JComboBox cboa;
    private javax.swing.JComboBox cboalmadisco;
    private javax.swing.JComboBox cboalmaram;
    private javax.swing.JComboBox cboalmatarvi;
    private javax.swing.JComboBox cbobateria;
    private javax.swing.JComboBox cbobluetooth;
    private javax.swing.JComboBox cbocargador;
    private javax.swing.JComboBox cboco;
    private javax.swing.JComboBox cbodisco;
    private javax.swing.JComboBox cboestado;
    private javax.swing.JComboBox cbofuenpo;
    private javax.swing.JComboBox cbomarca_dispositivo;
    private javax.swing.JComboBox cbomarcaimpresora;
    private javax.swing.JComboBox cbomarram;
    private javax.swing.JComboBox cbopantalla;
    private javax.swing.JComboBox cboplaca;
    private javax.swing.JComboBox cboprocesador;
    private javax.swing.JComboBox cbored;
    private javax.swing.JComboBox cbotarvide;
    private javax.swing.JComboBox cbotipimp;
    private javax.swing.JComboBox cbotipodis;
    private javax.swing.JComboBox cbowafupo;
    private javax.swing.JComboBox cbowebcam;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lblcodcli;
    private javax.swing.JLabel lblcodi;
    private javax.swing.JLabel lblcodigoite;
    private javax.swing.JLabel lblfuen1;
    private javax.swing.JLabel lblfuen4;
    private javax.swing.JLabel lblhora2;
    private javax.swing.JLabel lblplaca;
    private javax.swing.JLabel lbltarjetavideo;
    private javax.swing.JPanel paccesorios;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel pdatos;
    private javax.swing.JPanel pimpresora;
    private javax.swing.JPanel ptotal;
    private javax.swing.JTextField txtacuentaite;
    private javax.swing.JTextField txtcambiosite;
    private javax.swing.JTextField txtcarapro;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtcodigoiterinario;
    private javax.swing.JTextField txtdesacce;
    private javax.swing.JTextField txtdesimp;
    private javax.swing.JTextField txtdnicli;
    private javax.swing.JTextField txtfallosimp;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txtfecha_entrega;
    private javax.swing.JTextField txtidaccesorios;
    private javax.swing.JTextField txtidimpresora;
    private javax.swing.JTextField txtidlaptop;
    private javax.swing.JTextField txtidpc;
    private javax.swing.JTextField txtmodelo;
    private javax.swing.JTextField txtmodeloim;
    private javax.swing.JTextField txtnomite;
    private javax.swing.JTextField txtobservacionite;
    private javax.swing.JTextField txtsaldoite;
    private javax.swing.JTextField txttotalite;
    // End of variables declaration//GEN-END:variables
}
