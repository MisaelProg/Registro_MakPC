/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso;

import com.sun.awt.AWTUtilities;
import java.sql.*;
import javax.swing.*;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JOptionPane;

/**
 *
 * @author Misael
 */
public class FrmPc extends javax.swing.JFrame {

    int x, y;
    static Connection conn = null;
    static Statement st = null;
    static ResultSet rs = null;
    static ResultSet rs1 = null;
    static ResultSet rs2 = null;
    static ResultSet rs3 = null;
    static ResultSet rs4 = null;
    static ResultSet rs5 = null;

    DefaultComboBoxModel marcapc = new DefaultComboBoxModel();
    DefaultComboBoxModel marcaprocesadorpc = new DefaultComboBoxModel();
    DefaultComboBoxModel marcadiscopc = new DefaultComboBoxModel();
    DefaultComboBoxModel marcarampc = new DefaultComboBoxModel();
    DefaultComboBoxModel marcaplacapc = new DefaultComboBoxModel();
    DefaultComboBoxModel marcatarvipc = new DefaultComboBoxModel();

    /**
     * Creates new form FrmPc
     */
    public FrmPc() {
        initComponents();
        cbomarca_dispositivo.setModel(marcapc);
        cboprocesador.setModel(marcaprocesadorpc);
        cbodisco.setModel(marcadiscopc);
        cbomarram.setModel(marcarampc);
        cboplaca.setModel(marcaplacapc);
        cbotarvide.setModel(marcatarvipc);
        setLocationRelativeTo(null);
        btncancelar.setVisible(false);
        btnguardar.setEnabled(false);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 27, 27);
        AWTUtilities.setWindowShape(this, forma);
        buttontransparente();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Recursos/logo.png")));
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

    public void cargarcodigo()//ESTE ES UN GENERADOR DE CODIGOS AUTOMATICOS PROFE, ESTUVE INVESTIGANDO PARA QUE NO ESTE PONIENDO A CADA RATO ESPERO LE GUSTE
    {

        int j;
        String num = "";
        String c = "";
        String SQL = "select max(id_pc) from pc";
        try {
            conn = GenerarCodigo.Enlace(conn);
            st = conn.createStatement();
            rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }

            if (c == null) {
                txtidpc.setText("000001");
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
                txtidpc.setText("00" + gen.serie());

            }

        } catch (Exception e) {
        }

    }

    public void buttontransparente() {
        btncerrar.setOpaque(false);
        btncerrar.setContentAreaFilled(false);
        btncerrar.setBorderPainted(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        chknodisco = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        cbomarram = new javax.swing.JComboBox();
        cboalmaram = new javax.swing.JComboBox();
        chknoprocesador = new javax.swing.JCheckBox();
        lblfuen = new javax.swing.JLabel();
        cbofuenpo = new javax.swing.JComboBox();
        cbowafupo = new javax.swing.JComboBox();
        chknofuente = new javax.swing.JCheckBox();
        lblplaca = new javax.swing.JLabel();
        cboplaca = new javax.swing.JComboBox();
        chknoplaca = new javax.swing.JCheckBox();
        lbltarjetavideo = new javax.swing.JLabel();
        cbotarvide = new javax.swing.JComboBox();
        cboalmatarvi = new javax.swing.JComboBox();
        cbnotarjeta = new javax.swing.JCheckBox();
        chknoram = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        btncancelar = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        txtidpc = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        btncerrar = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnnuevoregi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pdatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 10));
        pdatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbomarca_dispositivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbomarca_dispositivoActionPerformed(evt);
            }
        });
        pdatos.add(cbomarca_dispositivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 140, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Modelo:");
        pdatos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 30, -1, -1));
        pdatos.add(txtmodelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 30, 200, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Procesador:");
        pdatos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));

        cboprocesador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboprocesadorActionPerformed(evt);
            }
        });
        pdatos.add(cboprocesador, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 140, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Carac. Procesador:");
        pdatos.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, -1, -1));
        pdatos.add(txtcarapro, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, 140, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Disco:");
        pdatos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 80, -1, -1));

        pdatos.add(cbodisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 80, 140, -1));

        cboalmadisco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "120GB", "250GB", "450GB", "500GB", "1TB", "2TB" }));
        pdatos.add(cboalmadisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 80, 140, -1));

        chknodisco.setText("No");
        pdatos.add(chknodisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 80, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Memoria RAM:");
        pdatos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, -1, -1));

        pdatos.add(cbomarram, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 140, -1));

        cboalmaram.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2GB", "4GB", "6GB", "8GB", "16GB", "32GB", "64GB" }));
        pdatos.add(cboalmaram, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 140, -1));

        chknoprocesador.setText("No");
        pdatos.add(chknoprocesador, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, -1, -1));

        lblfuen.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblfuen.setText("Fuente de Poder:");
        pdatos.add(lblfuen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        cbofuenpo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SIN FUENTE", "REAL", "COMERCIAL" }));
        pdatos.add(cbofuenpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 140, -1));

        cbowafupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "300W", "350W", "460W", "500W", "600W", "800W" }));
        pdatos.add(cbowafupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 140, -1));

        chknofuente.setText("No");
        pdatos.add(chknofuente, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, -1, -1));

        lblplaca.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblplaca.setText("Placa Madre:");
        pdatos.add(lblplaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        pdatos.add(cboplaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 140, -1));

        chknoplaca.setText("No");
        pdatos.add(chknoplaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

        lbltarjetavideo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbltarjetavideo.setText("Tarjeta de Video:");
        pdatos.add(lbltarjetavideo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, -1, -1));

        pdatos.add(cbotarvide, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 140, -1));

        cboalmatarvi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2GB", "4GB", "6GB", "8GB", "16GB", "32GB", "64GB" }));
        pdatos.add(cboalmatarvi, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, 140, -1));

        cbnotarjeta.setText("No");
        pdatos.add(cbnotarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 130, -1, -1));

        chknoram.setText("No");
        pdatos.add(chknoram, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Marca:");
        pdatos.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        btncancelar.setBackground(new java.awt.Color(0, 204, 255));
        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CANCELAR.png"))); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.setToolTipText("");
        btncancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        pdatos.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 160, 140, 30));

        getContentPane().add(pdatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 1180, 220));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel35.setText("DATOS DEL DISPOSITIVO - \"PC\"");
        getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, -1, -1));

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/logo_agua.png"))); // NOI18N
        getContentPane().add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, -1, 510));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 10));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("COPIAR CODIGO -->");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txtidpc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidpcActionPerformed(evt);
            }
        });
        jPanel1.add(txtidpc, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 110, -1));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("CNT + C");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        btncerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cerrar.png"))); // NOI18N
        btncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btncerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 10, 50, 30));

        btnbuscar.setFont(new java.awt.Font("Swis721 Blk BT", 1, 14)); // NOI18N
        btnbuscar.setForeground(new java.awt.Color(0, 0, 153));
        btnbuscar.setText("Buscar Registro");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 110, -1, -1));

        btnmodificar.setBackground(new java.awt.Color(0, 204, 255));
        btnmodificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/modificar_pequeño.png"))); // NOI18N
        btnmodificar.setText("Modificar");
        btnmodificar.setToolTipText("");
        btnmodificar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 400, 120, 30));

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
        jPanel1.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 120, 30));

        btnnuevoregi.setFont(new java.awt.Font("Swis721 Blk BT", 1, 14)); // NOI18N
        btnnuevoregi.setForeground(new java.awt.Color(0, 0, 153));
        btnnuevoregi.setText("Nuevo Registro");
        btnnuevoregi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoregiActionPerformed(evt);
            }
        });
        jPanel1.add(btnnuevoregi, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbomarca_dispositivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbomarca_dispositivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbomarca_dispositivoActionPerformed

    private void cboprocesadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboprocesadorActionPerformed

    }//GEN-LAST:event_cboprocesadorActionPerformed

    private void btncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btncerrarActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        Point p = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(p.x - x, p.y - y);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed

        String BuscarLaptop;//BUSCAMOS LOS CLIENTES EN LA BASE DE DATOS SEGUN SUS CODIGOS
        //  editable(true,true,true,true,true,true,true,true,true,true,true,true);
        if (btnnuevoregi.isEnabled()) {
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
                    txtidpc.setText("NO EXISTE");

                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR BD" + e.getMessage());
            }
        }

    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        int resp;
        // noeditable(false,false,false,false,false,false,false,false,false,false,false,true);
        resp = JOptionPane.showConfirmDialog(null, "¿Desea modificar el registro?", "Pregunta", 0);
        if (resp == 0) {
            try {
                conn = Acceso.Enlace(conn);
                st = Acceso.sta(st);
                rs = Acceso.EnlPc(rs);
                //variables
                String comando, cod, idmarca, marcadisposi = "", idproce, marcaproce = "",
                        carpro, modelo, idpla, marpla = "", idra, marra = "", alra, iddisc, marcadis = "", almadisc,
                        marpoder, watspoder, idtarvi, martarvi = "", almatarvi;
                //variables
                cod = txtidpc.getText();
                //MARCA
                idmarca = (String) cbomarca_dispositivo.getSelectedItem();
                rs = Acceso.obtenerCodMarcaDispositivo(rs, idmarca);
                if (rs.next()) {
                    marcadisposi = rs.getString(1);
                }
                //PROCESADOR
                idproce = (String) cboprocesador.getSelectedItem();
                rs1 = Acceso.obtenerCodMarcaProcesador(rs1, idproce);
                if (rs1.next()) {
                    marcaproce = rs1.getString(1);
                }
                //CARACTERISTICA
                carpro = txtcarapro.getText();
                //MODELO
                modelo = txtmodelo.getText();
                 //PLACA MADRE

                idpla = (String) cboplaca.getSelectedItem();
                rs4 = Acceso.obtenerCodMarcaPlaca(rs4, idpla);
                if (rs4.next()) {
                    marpla = rs4.getString(1);
                }

                 //MEMORIA RAM
                if (chknoram.isSelected()) {
                    idra = (String) cbomarram.getSelectedItem();
                    rs3 = Acceso.obtenerCodMarcaRam(rs3, idra);
                    if (rs3.next()) {
                        marra = rs3.getString(1);
                    }
                    alra = "SIN RAM";
                } else {

                    idra = (String) cbomarram.getSelectedItem();
                    rs3 = Acceso.obtenerCodMarcaRam(rs3, idra);
                    if (rs3.next()) {
                        marra = rs3.getString(1);
                    }

                    alra = (String) cboalmaram.getSelectedItem();
                }
                //DISCO
                if (chknodisco.isSelected()) {
                    iddisc = (String) cbodisco.getSelectedItem();
                    rs2 = Acceso.obtenerCodMarcaDisco(rs2, iddisc);
                    if (rs2.next()) {
                        marcadis = rs2.getString(1);
                    }
                    almadisc = "SIN DISCO";
                } else {

                    iddisc = (String) cbodisco.getSelectedItem();
                    rs2 = Acceso.obtenerCodMarcaDisco(rs2, iddisc);
                    if (rs2.next()) {
                        marcadis = rs2.getString(1);
                    }
                    almadisc = (String) cboalmadisco.getSelectedItem();
                }
                //FUENTE
                if (chknofuente.isSelected()) {
                    marpoder = "SIN FUENTE";
                    watspoder = "SIN FUENTE";
                } else {
                    marpoder = (String) cbofuenpo.getSelectedItem();
                    watspoder = (String) cbowafupo.getSelectedItem();
                }
                //VIDEO
                if (cbnotarjeta.isSelected()) {
                    idtarvi = (String) cbotarvide.getSelectedItem();
                    rs5 = Acceso.obtenerCodMarcaTarjetVideo(rs5, idtarvi);
                    if (rs5.next()) {
                        martarvi = rs5.getString(1);
                    }
                    almatarvi = "SIN VIDEO";
                } else {

                    idtarvi = (String) cbotarvide.getSelectedItem();
                    rs5 = Acceso.obtenerCodMarcaTarjetVideo(rs5, idtarvi);
                    if (rs5.next()) {
                        martarvi = rs5.getString(1);
                    }
                    almatarvi = (String) cboalmatarvi.getSelectedItem();
                }

                comando = "UPDATE pc SET id_marca_dispositivo='" + marcadisposi + "', id_procesador='" + marcaproce + "',cararac_procesador='" + carpro + "'"
                        + ",modelo ='" + modelo + "',id_placa='" + marpla + "',id_ram ='" + marra + "',alma_ram='" + alra + "'"
                        + ",id_disco='" + marcadis + "',alma_disco='" + almadisc + "',fuente_poder='" + marpoder + "',wats_poder='" + watspoder + "',id_tarjetavi='" + martarvi + "'"
                        + ",alma_tarjetatavi='" + almatarvi + "'";
                comando = comando + " WHERE id_pc=" + cod;
                st.executeUpdate(comando);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "¡Hey eso no puedes hacer!, verifica no cambiar el codigo de la Laptop");
                JOptionPane.showMessageDialog(null, "Error " + e.toString());
                return;
                // JOptionPane.showMessageDialog(null, "Error "+e.toString());
            }
        }
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        btnnuevoregi.setEnabled(true);
        //  noeditable(false,false,false,false,false,false,false,false,false,false,false,false);
        int resp;

        resp = JOptionPane.showConfirmDialog(null, "¿Desea grabar el registro?", "Pregunta", 0);
        if (resp == 0) {
            try {
                conn = Acceso.Enlace(conn);
                st = Acceso.sta(st);
                rs = Acceso.EnlPc(rs);
                //variables
                String comando, cod, idmarca, marcadisposi = "", idproce, marcaproce = "",
                        carpro, modelo, idpla, marpla = "", idra, marra = "", alra, iddisc, marcadis = "", almadisc,
                        marpoder, watspoder, idtarvi, martarvi = "", almatarvi;
                //variables
                cod = txtidpc.getText();
                //MARCA
                idmarca = (String) cbomarca_dispositivo.getSelectedItem();
                rs = Acceso.obtenerCodMarcaDispositivo(rs, idmarca);
                if (rs.next()) {
                    marcadisposi = rs.getString(1);
                }
                //PROCESADOR
                idproce = (String) cboprocesador.getSelectedItem();
                rs1 = Acceso.obtenerCodMarcaProcesador(rs1, idproce);
                if (rs1.next()) {
                    marcaproce = rs1.getString(1);
                }
                //CARACTERISTICA
                carpro = txtcarapro.getText();
                //MODELO
                modelo = txtmodelo.getText();
                 //PLACA MADRE

                idpla = (String) cboplaca.getSelectedItem();
                rs4 = Acceso.obtenerCodMarcaPlaca(rs4, idpla);
                if (rs4.next()) {
                    marpla = rs4.getString(1);
                }

                 //MEMORIA RAM
                if (chknoram.isSelected()) {
                    idra = (String) cbomarram.getSelectedItem();
                    rs3 = Acceso.obtenerCodMarcaRam(rs3, idra);
                    if (rs3.next()) {
                        marra = rs3.getString(1);
                    }
                    alra = "SIN RAM";
                } else {

                    idra = (String) cbomarram.getSelectedItem();
                    rs3 = Acceso.obtenerCodMarcaRam(rs3, idra);
                    if (rs3.next()) {
                        marra = rs3.getString(1);
                    }

                    alra = (String) cboalmaram.getSelectedItem();
                }
                //DISCO
                if (chknodisco.isSelected()) {
                    iddisc = (String) cbodisco.getSelectedItem();
                    rs2 = Acceso.obtenerCodMarcaDisco(rs2, iddisc);
                    if (rs2.next()) {
                        marcadis = rs2.getString(1);
                    }
                    almadisc = "SIN DISCO";
                } else {

                    iddisc = (String) cbodisco.getSelectedItem();
                    rs2 = Acceso.obtenerCodMarcaDisco(rs2, iddisc);
                    if (rs2.next()) {
                        marcadis = rs2.getString(1);
                    }
                    almadisc = (String) cboalmadisco.getSelectedItem();
                }
                //FUENTE
                if (chknofuente.isSelected()) {
                    marpoder = "SIN FUENTE";
                    watspoder = "SIN FUENTE";
                } else {
                    marpoder = (String) cbofuenpo.getSelectedItem();
                    watspoder = (String) cbowafupo.getSelectedItem();
                }
                //VIDEO
                if (cbnotarjeta.isSelected()) {
                    idtarvi = (String) cbotarvide.getSelectedItem();
                    rs5 = Acceso.obtenerCodMarcaTarjetVideo(rs5, idtarvi);
                    if (rs5.next()) {
                        martarvi = rs5.getString(1);
                    }
                    almatarvi = "SIN VIDEO";
                } else {

                    idtarvi = (String) cbotarvide.getSelectedItem();
                    rs5 = Acceso.obtenerCodMarcaTarjetVideo(rs5, idtarvi);
                    if (rs5.next()) {
                        martarvi = rs5.getString(1);
                    }
                    almatarvi = (String) cboalmatarvi.getSelectedItem();
                }

                //COMANDOS
                comando = "INSERT INTO pc VALUES('" + cod + "','" + marcadisposi + "','" + marcaproce + "','" + carpro + "',"
                        + "'" + modelo + "','" + marpla + "','" + marra + "','" + alra + "','" + marcadis + "','" + almadisc + "'"
                        + ",'" + marpoder + "','" + watspoder + "','" + martarvi + "','" + almatarvi + "')";
                st.executeUpdate(comando);
                btnnuevoregi.setEnabled(true);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Demasiados Caracteres, resume mejor");
                JOptionPane.showMessageDialog(null, "Error " + e.toString());
                return;

            }
            btnguardar.setEnabled(false);

        } else {
            //  editable(true,true,true,true,true,true,true,true,true,true,true,true);
            btnnuevoregi.setEnabled(false);
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnnuevoregiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoregiActionPerformed
        cargarcodigo();
        txtcarapro.setText("");
        txtmodelo.setText("");
        btncancelar.setVisible(true);
        btnguardar.setEnabled(true);
        // editable(true,true,true,true,true,true,true,true,true,true,true,true);
        btnnuevoregi.setEnabled(false);
    }//GEN-LAST:event_btnnuevoregiActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        int resp;
        resp = JOptionPane.showConfirmDialog(null, "¿Desea cancelar el proceso?", "Pregunta", 0);
        if (resp == 0) {
            txtidpc.setText("");
            btnbuscar.setEnabled(true);
            btnnuevoregi.setEnabled(true);
            btnguardar.setEnabled(false);

            //noeditable(true,false,false,false,false,false,false,false,false,false,false,false);
            btncancelar.setVisible(false);
        }
    }//GEN-LAST:event_btncancelarActionPerformed

    private void txtidpcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidpcActionPerformed
        String BuscarLaptop;//BUSCAMOS LOS CLIENTES EN LA BASE DE DATOS SEGUN SUS CODIGOS
        //  editable(true,true,true,true,true,true,true,true,true,true,true,true);
        if (btnnuevoregi.isEnabled()) {
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
                    txtidpc.setText("NO EXISTE");

                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR BD" + e.getMessage());
            }
        }
    }//GEN-LAST:event_txtidpcActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btncerrar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevoregi;
    private javax.swing.JCheckBox cbnotarjeta;
    private javax.swing.JComboBox cboalmadisco;
    private javax.swing.JComboBox cboalmaram;
    private javax.swing.JComboBox cboalmatarvi;
    private javax.swing.JComboBox cbodisco;
    private javax.swing.JComboBox cbofuenpo;
    private javax.swing.JComboBox cbomarca_dispositivo;
    private javax.swing.JComboBox cbomarram;
    private javax.swing.JComboBox cboplaca;
    private javax.swing.JComboBox cboprocesador;
    private javax.swing.JComboBox cbotarvide;
    private javax.swing.JComboBox cbowafupo;
    private javax.swing.JCheckBox chknodisco;
    private javax.swing.JCheckBox chknofuente;
    private javax.swing.JCheckBox chknoplaca;
    private javax.swing.JCheckBox chknoprocesador;
    private javax.swing.JCheckBox chknoram;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblfuen;
    private javax.swing.JLabel lblplaca;
    private javax.swing.JLabel lbltarjetavideo;
    private javax.swing.JPanel pdatos;
    private javax.swing.JTextField txtcarapro;
    private javax.swing.JTextField txtidpc;
    private javax.swing.JTextField txtmodelo;
    // End of variables declaration//GEN-END:variables
}
