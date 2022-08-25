/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso;

import java.sql.*;
import javax.swing.*;
import com.sun.awt.AWTUtilities;
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
public class FrmLaptop extends javax.swing.JFrame {

    int x, y;

    static Connection conn = null;
    static Statement st = null;
    static ResultSet rs = null;
    static ResultSet rs1 = null;
    static ResultSet rs2 = null;
    static ResultSet rs3 = null;

    DefaultComboBoxModel marcalaptop = new DefaultComboBoxModel();
    DefaultComboBoxModel marcaprocesador = new DefaultComboBoxModel();
    DefaultComboBoxModel marcadisco = new DefaultComboBoxModel();
    DefaultComboBoxModel marcaram = new DefaultComboBoxModel();

    /**
     * Creates new form FrmLaptop
     */
    public FrmLaptop() {
        initComponents();
        cbomarca_dispositivo.setModel(marcalaptop);
        cboprocesador.setModel(marcaprocesador);
        cbodisco.setModel(marcadisco);
        cbomarram.setModel(marcaram);
        btnguardar.setEnabled(false);
        btncancelar.setVisible(false);
        buttontransparente();
        setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 27, 27);
        AWTUtilities.setWindowShape(this, forma);
        buttontransparente();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Recursos/logo.png")));
        noeditable(false, false, false, false, false, false, false, false, false, false, false, false);
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
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error BD" + e.getMessage());
        }
    }

    public void noeditable(boolean c, boolean i, boolean d, boolean l, boolean nu, boolean qw, boolean ae, boolean di, boolean ra, boolean mo, boolean ad, boolean yt) {
        cbomarca_dispositivo.setEnabled(false);
        cboprocesador.setEnabled(false);
        cbodisco.setEnabled(false);
        cboalmadisco.setEnabled(false);
        txtcarapro.setEnabled(false);
        txtmodelolaptop.setEnabled(false);
        cbomarram.setEnabled(false);
        cboalmaram.setEnabled(false);
        cbopantalla.setEnabled(false);
        chknodisco.setEnabled(false);
        chknoram.setEnabled(false);
        chknopantalla.setEnabled(false);

    }

    public void editable(boolean c, boolean i, boolean d, boolean l, boolean nu, boolean qw, boolean ae, boolean di, boolean ra, boolean mo, boolean ad, boolean yt) {
        cbomarca_dispositivo.setEnabled(true);
        cboprocesador.setEnabled(true);
        cbodisco.setEnabled(true);
        cboalmadisco.setEnabled(true);
        txtcarapro.setEnabled(true);
        txtmodelolaptop.setEnabled(true);
        cbomarram.setEnabled(true);
        cboalmaram.setEnabled(true);
        cbopantalla.setEnabled(true);
        chknodisco.setEnabled(true);
        chknoram.setEnabled(true);
        chknopantalla.setEnabled(true);

    }

    public void cargarcodigo()//ESTE ES UN GENERADOR DE CODIGOS AUTOMATICOS PROFE, ESTUVE INVESTIGANDO PARA QUE NO ESTE PONIENDO A CADA RATO ESPERO LE GUSTE
    {

        int j;
        String num = "";
        String c = "";
        String SQL = "select max(id_laptop) from laptop";
        try {
            conn = GenerarCodigo.Enlace(conn);
            st = conn.createStatement();
            rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }

            if (c == null) {
                txtidlaptop.setText("000001");
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
                txtidlaptop.setText("00" + gen.serie());

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

        jLabel35 = new javax.swing.JLabel();
        pdatos = new javax.swing.JPanel();
        cbomarca_dispositivo = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        txtmodelolaptop = new javax.swing.JTextField();
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
        chknoram = new javax.swing.JCheckBox();
        chknopantalla = new javax.swing.JCheckBox();
        cbopantalla = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btncancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btncerrar = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtidlaptop = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        btnnuevoregi = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel35.setText("DATOS DEL DISPOSITIVO - \"LAPTOP\"");
        getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, -1, -1));

        pdatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 10));
        pdatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbomarca_dispositivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbomarca_dispositivoActionPerformed(evt);
            }
        });
        pdatos.add(cbomarca_dispositivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 140, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Modelo:");
        pdatos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));
        pdatos.add(txtmodelolaptop, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 140, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Procesador:");
        pdatos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, -1));

        cboprocesador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboprocesadorActionPerformed(evt);
            }
        });
        pdatos.add(cboprocesador, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 140, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Carac. Procesador:");
        pdatos.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
        pdatos.add(txtcarapro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 140, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Disco:");
        pdatos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, -1, -1));

        pdatos.add(cbodisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 140, -1));

        cboalmadisco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "120GB", "250GB", "450GB", "500GB", "1TB", "2TB" }));
        pdatos.add(cboalmadisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 40, 140, -1));

        chknodisco.setText("No");
        chknodisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chknodiscoActionPerformed(evt);
            }
        });
        pdatos.add(chknodisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 40, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Memoria RAM:");
        pdatos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, -1, -1));

        pdatos.add(cbomarram, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 80, 140, -1));

        cboalmaram.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2GB", "4GB", "6GB", "8GB", "16GB", "32GB", "64GB" }));
        pdatos.add(cboalmaram, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 80, 140, -1));

        chknoram.setText("No");
        chknoram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chknoramActionPerformed(evt);
            }
        });
        pdatos.add(chknoram, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 80, -1, -1));

        chknopantalla.setText("No");
        chknopantalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chknopantallaActionPerformed(evt);
            }
        });
        pdatos.add(chknopantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, -1));

        cbopantalla.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Ninguna>", "10\"", "11.1\"", "12.3\"", "13\"", "14\"", "14.1\"", "15\"", "15.6\"", "17.1\"" }));
        pdatos.add(cbopantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 140, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Pantalla:");
        pdatos.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Marca:");
        pdatos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

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
        pdatos.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 140, 140, 30));

        getContentPane().add(pdatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1160, 200));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 10));
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

        btncerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cerrar.png"))); // NOI18N
        btncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btncerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 10, 50, 30));

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/logo_agua.png"))); // NOI18N
        jPanel1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, 510));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("COPIAR CODIGO -->");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txtidlaptop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidlaptopActionPerformed(evt);
            }
        });
        jPanel1.add(txtidlaptop, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 110, -1));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("CNT + C");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

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
        jPanel1.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 120, 30));

        btnnuevoregi.setFont(new java.awt.Font("Swis721 Blk BT", 1, 14)); // NOI18N
        btnnuevoregi.setForeground(new java.awt.Color(0, 0, 153));
        btnnuevoregi.setText("Nuevo Registro");
        btnnuevoregi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoregiActionPerformed(evt);
            }
        });
        jPanel1.add(btnnuevoregi, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, -1, -1));

        btnbuscar.setFont(new java.awt.Font("Swis721 Blk BT", 1, 14)); // NOI18N
        btnbuscar.setForeground(new java.awt.Color(0, 0, 153));
        btnbuscar.setText("Buscar Registro");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 130, -1, -1));

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
        jPanel1.add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 400, 120, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 510));

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

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        btnnuevoregi.setEnabled(true);
        noeditable(false, false, false, false, false, false, false, false, false, false, false, false);
        int resp;

        resp = JOptionPane.showConfirmDialog(null, "¿Desea grabar el registro?", "Pregunta", 0);
        if (resp == 0) {
            try {
                conn = Acceso.Enlace(conn);
                st = Acceso.sta(st);
                rs = Acceso.EnlLaptop(rs);
                //variables
                String comando, cod, idmarca, marcadisposi = "", idproce, marcaproce = "", iddisc, marcadis = "", almadisc,
                        carpro, modelo, idra, marra = "", alra, pantalla;
                //variables
                cod = txtidlaptop.getText();
                idmarca = (String) cbomarca_dispositivo.getSelectedItem();
                rs = Acceso.obtenerCodMarcaDispositivo(rs, idmarca);
                if (rs.next()) {
                    marcadisposi = rs.getString(1);
                }
                idproce = (String) cboprocesador.getSelectedItem();
                rs1 = Acceso.obtenerCodMarcaProcesador(rs1, idproce);
                if (rs1.next()) {
                    marcaproce = rs1.getString(1);
                }
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

                carpro = txtcarapro.getText();
                modelo = txtmodelolaptop.getText();
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

                pantalla = (String) cbopantalla.getSelectedItem();

                //COMANDOS
                comando = "INSERT INTO laptop VALUES('" + cod + "','" + marcadisposi + "','" + marcaproce + "','" + marcadis + "',"
                        + "'" + almadisc + "','" + carpro + "','" + modelo + "','" + marra + "','" + alra + "','" + pantalla + "')";
                st.executeUpdate(comando);
                btnnuevoregi.setEnabled(true);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Demasiados Caracteres, resume mejor");
                JOptionPane.showMessageDialog(null, "Error " + e.toString());
                return;

            }
            btnguardar.setEnabled(false);

        } else {
            editable(true, true, true, true, true, true, true, true, true, true, true, true);
            btnnuevoregi.setEnabled(false);
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnnuevoregiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoregiActionPerformed
        cargarcodigo();
        txtcarapro.setText("");
        txtmodelolaptop.setText("");
        btncancelar.setVisible(true);
        btnguardar.setEnabled(true);
        editable(true, true, true, true, true, true, true, true, true, true, true, true);
        btnnuevoregi.setEnabled(false);
    }//GEN-LAST:event_btnnuevoregiActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed

        String BuscarLaptop;//BUSCAMOS LOS CLIENTES EN LA BASE DE DATOS SEGUN SUS CODIGOS
        editable(true, true, true, true, true, true, true, true, true, true, true, true);
        if (btnnuevoregi.isEnabled()) {
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
                        txtmodelolaptop.setText((String) rs.getString(7));
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

    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        int resp;
        noeditable(false, false, false, false, false, false, false, false, false, false, false, true);
        resp = JOptionPane.showConfirmDialog(null, "¿Desea modificar el registro?", "Pregunta", 0);
        if (resp == 0) {
            try {
                conn = Acceso.Enlace(conn);
                st = Acceso.sta(st);
                rs = Acceso.EnlLaptop(rs);

                String comando, cod, idmarca, marcadisposi = "", idproce, marcaproce = "", iddisc, marcadis = "", almadisc,
                        carpro, modelo, idra, marra = "", alra, pantalla;
                //variables
                cod = txtidlaptop.getText();
                idmarca = (String) cbomarca_dispositivo.getSelectedItem();
                rs = Acceso.obtenerCodMarcaDispositivo(rs, idmarca);
                if (rs.next()) {
                    marcadisposi = rs.getString(1);
                }
                idproce = (String) cboprocesador.getSelectedItem();
                rs1 = Acceso.obtenerCodMarcaProcesador(rs1, idproce);
                if (rs1.next()) {
                    marcaproce = rs1.getString(1);
                }
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

                carpro = txtcarapro.getText();
                modelo = txtmodelolaptop.getText();
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

                pantalla = (String) cbopantalla.getSelectedItem();

                comando = "UPDATE laptop SET id_marca_dispositivo='" + marcadisposi + "', id_procesador='" + marcaproce + "',id_disco='" + marcadis + "'"
                        + ",alma_disco='" + almadisc + "',carac_procesador='" + carpro + "',modelo='" + modelo + "',id_ram='" + marra + "'"
                        + ",alma_ram='" + alra + "',pantalla='" + pantalla + "'";
                comando = comando + " WHERE id_laptop=" + cod;
                st.executeUpdate(comando);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "¡Hey eso no puedes hacer!, verifica no cambiar el codigo de la Laptop");
                return;
                // JOptionPane.showMessageDialog(null, "Error "+e.toString());
            }
        }
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void chknodiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chknodiscoActionPerformed
        if (chknodisco.isSelected()) {
            cbodisco.setEnabled(false);
            cboalmadisco.setEnabled(false);

        } else {
            cbodisco.setEnabled(true);
            cboalmadisco.setEnabled(true);

        }
    }//GEN-LAST:event_chknodiscoActionPerformed

    private void chknoramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chknoramActionPerformed
        if (chknoram.isSelected()) {
            cbomarram.setEnabled(false);
            cboalmaram.setEnabled(false);

        } else {
            cbomarram.setEnabled(true);
            cboalmaram.setEnabled(true);
        }
    }//GEN-LAST:event_chknoramActionPerformed

    private void chknopantallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chknopantallaActionPerformed
        if (chknopantalla.isSelected()) {
            cbopantalla.setEnabled(false);

        } else {
            cbopantalla.setEnabled(true);

        }
    }//GEN-LAST:event_chknopantallaActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        int resp;
        resp = JOptionPane.showConfirmDialog(null, "¿Desea cancelar el proceso?", "Pregunta", 0);
        if (resp == 0) {
            txtidlaptop.setText("");
            btnbuscar.setEnabled(true);
            btnnuevoregi.setEnabled(true);
            btnguardar.setEnabled(false);

            noeditable(true, false, false, false, false, false, false, false, false, false, false, false);
            btncancelar.setVisible(false);
        }

    }//GEN-LAST:event_btncancelarActionPerformed

    private void txtidlaptopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidlaptopActionPerformed
       String BuscarLaptop;//BUSCAMOS LOS CLIENTES EN LA BASE DE DATOS SEGUN SUS CODIGOS
        editable(true, true, true, true, true, true, true, true, true, true, true, true);
        if (btnnuevoregi.isEnabled()) {
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
                        txtmodelolaptop.setText((String) rs.getString(7));
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
    }//GEN-LAST:event_txtidlaptopActionPerformed

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
            java.util.logging.Logger.getLogger(FrmLaptop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLaptop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLaptop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLaptop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLaptop().setVisible(true);
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
    private javax.swing.JComboBox cboalmadisco;
    private javax.swing.JComboBox cboalmaram;
    private javax.swing.JComboBox cbodisco;
    private javax.swing.JComboBox cbomarca_dispositivo;
    private javax.swing.JComboBox cbomarram;
    private javax.swing.JComboBox cbopantalla;
    private javax.swing.JComboBox cboprocesador;
    private javax.swing.JCheckBox chknodisco;
    private javax.swing.JCheckBox chknopantalla;
    private javax.swing.JCheckBox chknoram;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pdatos;
    private javax.swing.JTextField txtcarapro;
    private javax.swing.JTextField txtidlaptop;
    private javax.swing.JTextField txtmodelolaptop;
    // End of variables declaration//GEN-END:variables
}
