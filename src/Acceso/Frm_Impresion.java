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
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JButton;
import javax.swing.border.Border;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Misael
 */
public class Frm_Impresion extends javax.swing.JFrame implements Printable {

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

      // public int simple;
    DefaultComboBoxModel marcalaptop = new DefaultComboBoxModel();
    DefaultComboBoxModel marcaprocesador = new DefaultComboBoxModel();
    DefaultComboBoxModel marcadisco = new DefaultComboBoxModel();
    DefaultComboBoxModel marcaram = new DefaultComboBoxModel();
    DefaultComboBoxModel marcaplaca = new DefaultComboBoxModel();
    DefaultComboBoxModel marcatarvi = new DefaultComboBoxModel();
    DefaultComboBoxModel marcaimpresora = new DefaultComboBoxModel();
    DefaultComboBoxModel dispo = new DefaultComboBoxModel();

    
    DefaultComboBoxModel marcapc = new DefaultComboBoxModel();
    DefaultComboBoxModel marcaprocesadorpc = new DefaultComboBoxModel();
    DefaultComboBoxModel marcadiscopc = new DefaultComboBoxModel();
    DefaultComboBoxModel marcarampc = new DefaultComboBoxModel();
    DefaultComboBoxModel marcaplacapc = new DefaultComboBoxModel();
    DefaultComboBoxModel marcatarvipc = new DefaultComboBoxModel();
    /**
     * Creates new form Frm_Impresion
     */
    public Frm_Impresion() {
        initComponents();
        buttontransparente();
        this.setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Recursos/logo.png")));
        cbomarca_dispositivo.setModel(marcalaptop);
        cboprocesador.setModel(marcaprocesador);
        cbodisco.setModel(marcadisco);
        cbomarca_dispositivopc.setModel(marcalaptop);
        cboprocesadorpc.setModel(marcaprocesador);
        cbodiscopc.setModel(marcadisco);
        cbomarram.setModel(marcaram);
        cbomarrampc.setModel(marcaram);
        cboplacapc.setModel(marcaplaca);
        cbotarvidepc.setModel(marcatarvi);
        cbomarcaimpresora.setModel(marcaimpresora);
        
        cbomarca_dispositivopc.setModel(marcapc);
        cboprocesadorpc.setModel(marcaprocesadorpc);
        cbodiscopc.setModel(marcadiscopc);
        cbomarrampc.setModel(marcarampc);
        cboplacapc.setModel(marcaplacapc);
        cbotarvidepc.setModel(marcatarvipc);
//         txti.setText(String.valueOf(simple));
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
        
        try {
            conn = Acceso.Enlace(conn);
            rs = Acceso.obtenerMarcaDispositivo(rs);
            while (rs.next()) {
                marcapc.addElement(rs.getString(1));
            }
            rs1 = Acceso.obtenerMarcaProcesador(rs1);
            while (rs1.next()) {
                marcaprocesadorpc.addElement(rs1.getString(1));
            }

            rs2 = Acceso.obtenerTipoDisco(rs2);
            while (rs2.next()) {
                marcadiscopc.addElement(rs2.getString(1));
            }
            rs3 = Acceso.obtenerMarcaRam(rs3);
            while (rs3.next()) {
                marcarampc.addElement(rs3.getString(1));
            }
            rs4 = Acceso.obtenerMarcaPlaca(rs4);
            while (rs4.next()) {
                marcaplacapc.addElement(rs4.getString(1));
            }
            rs5 = Acceso.obtenerMarcaTarjetVideo(rs5);
            while (rs5.next()) {
                marcatarvipc.addElement(rs5.getString(1));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error BD" + e.getMessage());
        }

    }

    public void buttontransparente() {
        btncerrar.setOpaque(false);
        btncerrar.setContentAreaFilled(false);
        btncerrar.setBorderPainted(false);
    }
    public int print(Graphics graf, PageFormat pagfor, int index) throws PrinterException {

        if (index > 0) {
            return NO_SUCH_PAGE;

        }
        Graphics2D hub = (Graphics2D) graf;
        hub.translate(pagfor.getImageableX() + 20, pagfor.getImageableY() + 200);
        hub.scale(0.5, 0.5);

        this.panel.printAll(graf);
        return PAGE_EXISTS;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtdnicli = new javax.swing.JTextField();
        txtnomite = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtcelular = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtcodcliente = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtfecha_entrega = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        pdatos = new javax.swing.JPanel();
        cbomarca_dispositivo = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        txtmodelo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboprocesador = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        txtcarapro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbodisco = new javax.swing.JComboBox();
        cboalmadisco = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cbomarram = new javax.swing.JComboBox();
        cboalmaram = new javax.swing.JComboBox();
        cbopantalla = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtidlaptop = new javax.swing.JTextField();
        lbl2 = new javax.swing.JLabel();
        pdatos1 = new javax.swing.JPanel();
        cbomarca_dispositivopc = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        txtmodelo1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cboprocesadorpc = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        txtcarapro1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cbodiscopc = new javax.swing.JComboBox();
        cboalmadisco1 = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        cbomarrampc = new javax.swing.JComboBox();
        cboalmaram1 = new javax.swing.JComboBox();
        cbopantalla1 = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        cbofuenpo1 = new javax.swing.JComboBox();
        cbowafupo1 = new javax.swing.JComboBox();
        lblplaca1 = new javax.swing.JLabel();
        cboplacapc = new javax.swing.JComboBox();
        lbltarjetavideo1 = new javax.swing.JLabel();
        cbotarvidepc = new javax.swing.JComboBox();
        cboalmatarvi1 = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        lblfuen2 = new javax.swing.JLabel();
        lblcodi1 = new javax.swing.JLabel();
        txtidpc = new javax.swing.JTextField();
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
        lblfuen4 = new javax.swing.JLabel();
        txtidimpresora = new javax.swing.JTextField();
        paccesorios = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtdesacce = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        cbored = new javax.swing.JComboBox();
        cbobateria = new javax.swing.JComboBox();
        cbobluetooth = new javax.swing.JComboBox();
        cbowebcam = new javax.swing.JComboBox();
        cbocargador = new javax.swing.JComboBox();
        cboco = new javax.swing.JComboBox();
        cboa = new javax.swing.JComboBox();
        txtidaccesorios = new javax.swing.JTextField();
        lbl1 = new javax.swing.JLabel();
        txti = new javax.swing.JTextField();
        ptotal = new javax.swing.JPanel();
        txtcambiosite = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtacuentaite = new javax.swing.JTextField();
        txttotalite = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txtsaldoite = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtobservacionite = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        cboestado = new javax.swing.JComboBox();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        btncerrar = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelMousePressed(evt);
            }
        });
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 14)); // NOI18N
        jLabel1.setText("DATOS DEL REGISTRO");
        panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("RUT: 00000000000");
        panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Codigo Iterinario:");
        panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 4));
        jPanel4.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jPanel4ComponentAdded(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel16.setText("Señor(es):");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel30.setText("DNI:");
        jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        txtdnicli.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        txtdnicli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdnicliActionPerformed(evt);
            }
        });
        jPanel4.add(txtdnicli, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 70, -1));

        txtnomite.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jPanel4.add(txtnomite, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 170, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel4.setText("Celular:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, -1));

        txtcelular.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jPanel4.add(txtcelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 100, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel5.setText("Codigo:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel29.setText("DATOS DEL CLIENTE");
        jPanel4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtcodcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodclienteActionPerformed(evt);
            }
        });
        jPanel4.add(txtcodcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 70, -1));

        panel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 380, 90));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 4));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel6.setText("Fecha:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        txtfecha.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        txtfecha.setEnabled(false);
        txtfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaActionPerformed(evt);
            }
        });
        jPanel2.add(txtfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 110, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel31.setText("Fecha Entrega:");
        jPanel2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        txtfecha_entrega.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jPanel2.add(txtfecha_entrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 110, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel37.setText("FECHAS Y ENTREGAS");
        jPanel2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        panel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 40, 230, 90));

        pdatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 4));
        pdatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbomarca_dispositivo.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        cbomarca_dispositivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbomarca_dispositivoActionPerformed(evt);
            }
        });
        pdatos.add(cbomarca_dispositivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 100, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel13.setText("Modelo:");
        pdatos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtmodelo.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        pdatos.add(txtmodelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 100, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel7.setText("Procesador:");
        pdatos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        cboprocesador.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        cboprocesador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboprocesadorActionPerformed(evt);
            }
        });
        pdatos.add(cboprocesador, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 100, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel10.setText("Carac. Procesador:");
        pdatos.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, -1));

        txtcarapro.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        pdatos.add(txtcarapro, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 100, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel9.setText("Disco:");
        pdatos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, -1, -1));

        cbodisco.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        pdatos.add(cbodisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, 100, -1));

        cboalmadisco.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        cboalmadisco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "120GB", "250GB", "450GB", "500GB", "1TB", "2TB" }));
        pdatos.add(cboalmadisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, 100, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel8.setText("Memoria RAM:");
        pdatos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, -1, -1));

        cbomarram.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        pdatos.add(cbomarram, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 100, -1));

        cboalmaram.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        cboalmaram.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2GB", "4GB", "6GB", "8GB", "16GB", "32GB", "64GB" }));
        pdatos.add(cboalmaram, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 70, 100, -1));

        cbopantalla.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        cbopantalla.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Ninguna>", "10\"", "11.1\"", "12.3\"", "13\"", "14\"", "14.1\"", "15\"", "15.6\"", "17.1\"" }));
        pdatos.add(cbopantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 100, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel12.setText("Pantalla:");
        pdatos.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel11.setText("Marca:");
        pdatos.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("DATOS DEL DISPOSITIVO");
        pdatos.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtidlaptop.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        txtidlaptop.setText("000001");
        txtidlaptop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidlaptopActionPerformed(evt);
            }
        });
        pdatos.add(txtidlaptop, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 50, -1));

        lbl2.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        lbl2.setText("CODIGO LAPOTP");
        pdatos.add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, -1, -1));

        panel.add(pdatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 980, 130));

        pdatos1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 4));
        pdatos1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbomarca_dispositivopc.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        cbomarca_dispositivopc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbomarca_dispositivopcActionPerformed(evt);
            }
        });
        pdatos1.add(cbomarca_dispositivopc, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 100, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel14.setText("Modelo:");
        pdatos1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        txtmodelo1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        pdatos1.add(txtmodelo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 100, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel15.setText("Procesador:");
        pdatos1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        cboprocesadorpc.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        cboprocesadorpc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboprocesadorpcActionPerformed(evt);
            }
        });
        pdatos1.add(cboprocesadorpc, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 100, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel17.setText("Carac. Procesador:");
        pdatos1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, -1));

        txtcarapro1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        pdatos1.add(txtcarapro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 100, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel18.setText("Disco:");
        pdatos1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, -1, -1));

        cbodiscopc.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        pdatos1.add(cbodiscopc, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, 100, -1));

        cboalmadisco1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        cboalmadisco1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "120GB", "250GB", "450GB", "500GB", "1TB", "2TB" }));
        pdatos1.add(cboalmadisco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, 100, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel19.setText("Memoria RAM:");
        pdatos1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, -1, -1));

        cbomarrampc.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        pdatos1.add(cbomarrampc, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, 100, -1));

        cboalmaram1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        cboalmaram1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2GB", "4GB", "6GB", "8GB", "16GB", "32GB", "64GB" }));
        pdatos1.add(cboalmaram1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 60, 100, -1));

        cbopantalla1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        cbopantalla1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Ninguna>", "10\"", "11.1\"", "12.3\"", "13\"", "14\"", "14.1\"", "15\"", "15.6\"", "17.1\"" }));
        pdatos1.add(cbopantalla1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 100, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel20.setText("Pantalla:");
        pdatos1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        cbofuenpo1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        cbofuenpo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "REAL", "COMERCIAL" }));
        pdatos1.add(cbofuenpo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 100, -1));

        cbowafupo1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        cbowafupo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "300W", "350W", "460W", "500W", "600W", "800W" }));
        pdatos1.add(cbowafupo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 90, 100, -1));

        lblplaca1.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        lblplaca1.setText("Placa Madre:");
        pdatos1.add(lblplaca1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        cboplacapc.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        pdatos1.add(cboplacapc, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 100, -1));

        lbltarjetavideo1.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        lbltarjetavideo1.setText("Tarjeta de Video:");
        pdatos1.add(lbltarjetavideo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        cbotarvidepc.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        pdatos1.add(cbotarvidepc, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 100, -1));

        cboalmatarvi1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        cboalmatarvi1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2GB", "4GB", "6GB", "8GB", "16GB", "32GB", "64GB" }));
        pdatos1.add(cboalmatarvi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 100, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel21.setText("Marca:");
        pdatos1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("DATOS DEL DISPOSITIVO");
        pdatos1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblfuen2.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        lblfuen2.setText("Fuente de Poder:");
        pdatos1.add(lblfuen2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, -1, -1));

        lblcodi1.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        lblcodi1.setText("PEGAR CODIGO PC:");
        pdatos1.add(lblcodi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, -1, -1));

        txtidpc.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        txtidpc.setText("000001");
        txtidpc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidpcActionPerformed(evt);
            }
        });
        pdatos1.add(txtidpc, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 50, -1));

        panel.add(pdatos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 980, 150));

        pimpresora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 4));
        pimpresora.setForeground(new java.awt.Color(0, 0, 102));
        pimpresora.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel38.setText("DATOS DE LA IMPRESORA");
        pimpresora.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel39.setText("Marca:");
        pimpresora.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel40.setText("Descripción:");
        pimpresora.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, -1, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel41.setText("Modelo:");
        pimpresora.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel42.setText("Tipo de Impresión:");
        pimpresora.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel43.setText("Fallos:");
        pimpresora.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, -1));

        cbotipimp.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        cbotipimp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SISTEMA CONTINUO", "TONER", "CARTUCHO", "OTRO", " " }));
        pimpresora.add(cbotipimp, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 150, -1));

        cbomarcaimpresora.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        pimpresora.add(cbomarcaimpresora, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 90, -1));

        txtdesimp.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        pimpresora.add(txtdesimp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 200, -1));

        txtmodeloim.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        pimpresora.add(txtmodeloim, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 90, -1));

        txtfallosimp.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        txtfallosimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfallosimpActionPerformed(evt);
            }
        });
        pimpresora.add(txtfallosimp, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 200, -1));

        lblfuen4.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        lblfuen4.setText("PEGAR CODIGO:");
        pimpresora.add(lblfuen4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, -1, -1));

        txtidimpresora.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        txtidimpresora.setText("000001");
        txtidimpresora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidimpresoraActionPerformed(evt);
            }
        });
        pimpresora.add(txtidimpresora, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 130, -1));

        panel.add(pimpresora, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 980, 100));

        paccesorios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 5));
        paccesorios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel22.setText("Cargador:");
        paccesorios.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel23.setText("Bateria:");
        paccesorios.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel24.setText("Web Cam:");
        paccesorios.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel25.setText("Bluetooth");
        paccesorios.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel27.setText("Accesorios:");
        paccesorios.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel26.setText("Descripcion:");
        paccesorios.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));

        txtdesacce.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        paccesorios.add(txtdesacce, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 110, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel28.setText("Red:");
        paccesorios.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, -1, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel32.setText("Color:");
        paccesorios.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));

        cbored.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        cbored.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CABLE", "WIFI", "AMBOS" }));
        paccesorios.add(cbored, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, 90, -1));

        cbobateria.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        cbobateria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));
        paccesorios.add(cbobateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 60, -1));

        cbobluetooth.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        cbobluetooth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));
        paccesorios.add(cbobluetooth, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, -1, -1));

        cbowebcam.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        cbowebcam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));
        paccesorios.add(cbowebcam, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        cbocargador.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        cbocargador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));
        paccesorios.add(cbocargador, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        cboco.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        cboco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SIN COLOR", "ROJO", "AZUL", "AMARILLO", "NEGRO", "OTRO" }));
        cboco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbocoActionPerformed(evt);
            }
        });
        paccesorios.add(cboco, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 90, -1));

        cboa.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        cboa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SIN ACCESORIO", "MALETINES", "BOLSO", "MOCHILA", "OTRO" }));
        paccesorios.add(cboa, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 90, -1));

        txtidaccesorios.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        txtidaccesorios.setText("000001");
        paccesorios.add(txtidaccesorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, 130, -1));

        lbl1.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        lbl1.setText("CODIGO");
        paccesorios.add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, -1, -1));

        panel.add(paccesorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 980, 90));

        txti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtiActionPerformed(evt);
            }
        });
        panel.add(txti, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 120, -1));

        ptotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 4));
        ptotal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtcambiosite.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        ptotal.add(txtcambiosite, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 300, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel33.setText("Debe:");
        ptotal.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, -1, -1));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel34.setText("Cancela:");
        ptotal.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, -1, -1));

        txtacuentaite.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        txtacuentaite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtacuentaiteActionPerformed(evt);
            }
        });
        ptotal.add(txtacuentaite, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 90, -1));

        txttotalite.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        ptotal.add(txttotalite, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 90, -1));

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel44.setText("Observaciones:");
        ptotal.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        txtsaldoite.setEditable(false);
        txtsaldoite.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        ptotal.add(txtsaldoite, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 60, 90, -1));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel45.setText("Total:");
        ptotal.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, -1, -1));

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel46.setText("Cambios Realizados:");
        ptotal.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        txtobservacionite.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        ptotal.add(txtobservacionite, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 300, -1));

        jButton1.setText("IMPRIMIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IMPRIME(evt);
            }
        });
        ptotal.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 40, -1, -1));

        panel.add(ptotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 650, 980, 90));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel48.setText("ESTADO:");
        panel.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));

        cboestado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "LOCAL", "LIMA" }));
        cboestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboestadoActionPerformed(evt);
            }
        });
        panel.add(cboestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 120, -1));

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setText("TIPO:");
        panel.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, -1, -1));

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel50.setText("TIPO:");
        panel.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, -1, -1));

        btncerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cerrar.png"))); // NOI18N
        btncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrarActionPerformed(evt);
            }
        });
        panel.add(btncerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, 50, 30));

        jPanel3.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, 750));

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Logo_MakPc_Form.png"))); // NOI18N
        jPanel3.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, 130));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 850));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtdnicliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdnicliActionPerformed

    }//GEN-LAST:event_txtdnicliActionPerformed

    private void jPanel4ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jPanel4ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4ComponentAdded

    private void txtfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaActionPerformed

    private void cbomarca_dispositivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbomarca_dispositivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbomarca_dispositivoActionPerformed

    private void cboprocesadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboprocesadorActionPerformed

    }//GEN-LAST:event_cboprocesadorActionPerformed

    private void txtidlaptopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidlaptopActionPerformed

    }//GEN-LAST:event_txtidlaptopActionPerformed

    private void cbomarca_dispositivopcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbomarca_dispositivopcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbomarca_dispositivopcActionPerformed

    private void cboprocesadorpcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboprocesadorpcActionPerformed

    }//GEN-LAST:event_cboprocesadorpcActionPerformed

    private void txtidpcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidpcActionPerformed

    }//GEN-LAST:event_txtidpcActionPerformed

    private void txtfallosimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfallosimpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfallosimpActionPerformed

    private void txtidimpresoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidimpresoraActionPerformed

    }//GEN-LAST:event_txtidimpresoraActionPerformed

    private void cbocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbocoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbocoActionPerformed

    private void txtacuentaiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtacuentaiteActionPerformed

    }//GEN-LAST:event_txtacuentaiteActionPerformed

    private void txtiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtiActionPerformed
        String BuscarLaptop;
        if (txti.isEnabled()) {
            try {
                conn = Acceso.Enlace(conn);
                rs = Acceso.EnlIterinario(rs);
                BuscarLaptop = txti.getText();
                boolean encuentra = false;
                while (rs.next()) {
                    if (BuscarLaptop.equals(rs.getString(1))) {
                        txtcodcliente.setText((String) rs.getString(2));
                        jLabel49.setText((String) rs.getString(3));
                        cboestado.setSelectedItem((String) rs.getString(4));
                        txtfecha.setText((String) rs.getString(5));
                        txtfecha_entrega.setText((String) rs.getString(6));
                        txtidpc.setText((String) rs.getString(7));
                        txtidlaptop.setText((String) rs.getString(8));
                        txtidimpresora.setText((String) rs.getString(9));
                        txtidaccesorios.setText((String) rs.getString(10));
                        txtobservacionite.setText((String) rs.getString(11));
                        txtcambiosite.setText((String) rs.getString(12));
                        txttotalite.setText((String) rs.getString(13));
                        txtacuentaite.setText((String) rs.getString(14));
                        txtsaldoite.setText((String) rs.getString(15));

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

    }//GEN-LAST:event_txtiActionPerformed

    private void cboestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboestadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboestadoActionPerformed

    private void btncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarActionPerformed

        super.dispose();

    }//GEN-LAST:event_btncerrarActionPerformed

    private void panelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_panelMousePressed

    private void txtcodclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodclienteActionPerformed
        String b, b1, b2;
        String BuscarLaptop;

        if (txtcodcliente.isEnabled()) {
            try {
                conn = Acceso.Enlace(conn);
                rs = Acceso.obtenerVistaCliente(rs);
                b = txtcodcliente.getText();

                boolean encuentra = false;
                while (rs.next()) {
                    if (b.equals(rs.getString(1))) //&& b1.equals(rs.getString(2)) && b2.equals(rs.getString(3)))
                    {
                        txtnomite.setText((String) rs.getString(2));
                        txtdnicli.setText((String) rs.getString(3));
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

        if (txtidpc.isEnabled()) {
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
                        cboplacapc.setSelectedItem((String) rs.getString(6));
                        cbomarram.setSelectedItem((String) rs.getString(7));
                        cboalmaram.setSelectedItem((String) rs.getString(8));
                        cbodisco.setSelectedItem((String) rs.getString(9));
                        cboalmadisco.setSelectedItem((String) rs.getString(10));
                        cbofuenpo1.setSelectedItem((String) rs.getString(11));
                        cbowafupo1.setSelectedItem((String) rs.getString(12));
                        cbotarvidepc.setSelectedItem((String) rs.getString(13));
                        cboalmatarvi1.setSelectedItem((String) rs.getString(14));
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
        if (txtidlaptop.isEnabled()) {
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
        if (txtidimpresora.isEnabled()) {
            try {
                conn = Acceso.Enlace(conn);
                rs = Acceso.ObtenerVistaImpresora(rs);
                BuscarLaptop = txtidimpresora.getText();
                boolean encuentra = false;
                while (rs.next()) {
                    if (BuscarLaptop.equals(rs.getString(1))) {
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
        if (txtidaccesorios.isEnabled()) {
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
    }//GEN-LAST:event_txtcodclienteActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Impresion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Impresion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Impresion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Impresion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Impresion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncerrar;
    private javax.swing.JComboBox cboa;
    private javax.swing.JComboBox cboalmadisco;
    private javax.swing.JComboBox cboalmadisco1;
    private javax.swing.JComboBox cboalmaram;
    private javax.swing.JComboBox cboalmaram1;
    private javax.swing.JComboBox cboalmatarvi1;
    private javax.swing.JComboBox cbobateria;
    private javax.swing.JComboBox cbobluetooth;
    private javax.swing.JComboBox cbocargador;
    private javax.swing.JComboBox cboco;
    private javax.swing.JComboBox cbodisco;
    private javax.swing.JComboBox cbodiscopc;
    private javax.swing.JComboBox cboestado;
    private javax.swing.JComboBox cbofuenpo1;
    private javax.swing.JComboBox cbomarca_dispositivo;
    private javax.swing.JComboBox cbomarca_dispositivopc;
    private javax.swing.JComboBox cbomarcaimpresora;
    private javax.swing.JComboBox cbomarram;
    private javax.swing.JComboBox cbomarrampc;
    private javax.swing.JComboBox cbopantalla;
    private javax.swing.JComboBox cbopantalla1;
    private javax.swing.JComboBox cboplacapc;
    private javax.swing.JComboBox cboprocesador;
    private javax.swing.JComboBox cboprocesadorpc;
    private javax.swing.JComboBox cbored;
    private javax.swing.JComboBox cbotarvidepc;
    private javax.swing.JComboBox cbotipimp;
    private javax.swing.JComboBox cbowafupo1;
    private javax.swing.JComboBox cbowebcam;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lblcodi1;
    private javax.swing.JLabel lblfuen2;
    private javax.swing.JLabel lblfuen4;
    private javax.swing.JLabel lblplaca1;
    private javax.swing.JLabel lbltarjetavideo1;
    private javax.swing.JPanel paccesorios;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel pdatos;
    private javax.swing.JPanel pdatos1;
    private javax.swing.JPanel pimpresora;
    private javax.swing.JPanel ptotal;
    private javax.swing.JTextField txtacuentaite;
    private javax.swing.JTextField txtcambiosite;
    private javax.swing.JTextField txtcarapro;
    private javax.swing.JTextField txtcarapro1;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtcodcliente;
    private javax.swing.JTextField txtdesacce;
    private javax.swing.JTextField txtdesimp;
    private javax.swing.JTextField txtdnicli;
    private javax.swing.JTextField txtfallosimp;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txtfecha_entrega;
    private javax.swing.JTextField txti;
    private javax.swing.JTextField txtidaccesorios;
    private javax.swing.JTextField txtidimpresora;
    private javax.swing.JTextField txtidlaptop;
    private javax.swing.JTextField txtidpc;
    private javax.swing.JTextField txtmodelo;
    private javax.swing.JTextField txtmodelo1;
    private javax.swing.JTextField txtmodeloim;
    private javax.swing.JTextField txtnomite;
    private javax.swing.JTextField txtobservacionite;
    private javax.swing.JTextField txtsaldoite;
    private javax.swing.JTextField txttotalite;
    // End of variables declaration//GEN-END:variables
}
