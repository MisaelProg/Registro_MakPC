/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso;
import com.sun.awt.AWTUtilities;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Misael
 */
public class Listado_Pc extends javax.swing.JFrame {
    int x, y;
    static Connection conn = null;
    static Statement st = null;
    static ResultSet rs = null;
    static ResultSet rs1 = null;

    DefaultTableModel tablapc = new DefaultTableModel();
    DefaultComboBoxModel marca = new DefaultComboBoxModel();
    /**
     * Creates new form Listado_Pc
     */
    public Listado_Pc() {
        initComponents();
        this.setLocationRelativeTo(null);
        buttontransparente();
        tabpc.setModel(tablapc);
        cbopc.setModel(marca);
        String titulos[] = {"Codigo Pc", "Marca", "Procesador", "Caracte.", "Modelo", "Placa"
                , "Marca Ram", "Alm. Ram", "Marca Disco", "Alm. Disco", "Fuente", "Volteos"
                , "Marca Tar. Vid", "Alm. Tar. Vid"};
        tablapc.setColumnIdentifiers(titulos);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 27, 27);
        AWTUtilities.setWindowShape(this, forma);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Recursos/logo.png")));
        String datos[] = new String[14];
        try {
            conn = Acceso.Enlace(conn);
            rs = Acceso.ObtenerVistaPc(rs);
            while (rs.next()) {
                rs1 = Acceso.ObtenerVistaPc(rs1);
            }
            while (rs1.next()) {
                datos[0] = rs1.getString(1);
                datos[1] = rs1.getString(2);
                datos[2] = rs1.getString(3);
                datos[3] = rs1.getString(4);
                datos[4] = rs1.getString(5);
                datos[5] = rs1.getString(6);
                datos[6] = rs1.getString(7);
                datos[7] = rs1.getString(8);
                datos[8] = rs1.getString(9);
                datos[9] = rs1.getString(10);
                datos[10] = rs1.getString(11);
                datos[11] = rs1.getString(12);
                datos[12] = rs1.getString(13);
                datos[13] = rs1.getString(14);
                
                tablapc.addRow(datos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error BD" + e.getMessage());
        }
         try
        {
            conn = Acceso.Enlace(conn);
            rs = Acceso.obtenerMarcaDispositivo(rs);
            while (rs.next())
            {
                marca.addElement(rs.getString(1));
            }  
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Error BD"+e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btncerrar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabpc = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cbopc = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 10));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel1.setText("LISTADO DE PC");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, -1, -1));

        btncerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cerrar.png"))); // NOI18N
        btncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrarActionPerformed(evt);
            }
        });
        jPanel2.add(btncerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 10, 50, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 120));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 10));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabpc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabpc);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1290, 190));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 1330, 230));

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel2.setText("MARCA DE PC:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        cbopc.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jPanel1.add(cbopc, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 200, -1));

        jButton2.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jButton2.setText("BUSCAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 153));
        jButton1.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("MOSTRAR TODO EL LISTADO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 460, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Logo_MakPc_Form.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 140, 130, 130));

        jButton3.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jButton3.setText("AGREGAR PC");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 190, 240, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String num;
        int f, i;

        num=(String)cbopc.getSelectedItem();
        try {
            boolean encuentra = false;
            conn = Acceso.Enlace(conn);
            rs = Acceso.obtenerVistaPcPorMarca(rs, num);
            String datos[] = new String[14];
            f = tablapc.getRowCount();
            if (f > 0) {
                for (i = 0; i < f; i++) {
                    tablapc.removeRow(0);
                }
            }
            while (rs.next()) {
                datos[0] = (String) rs.getString(1);
                datos[1] = (String) rs.getString(2);
                datos[2] = (String) rs.getString(3);
                datos[3] = (String) rs.getString(4);
                datos[4] = (String) rs.getString(5);
                datos[5] = (String) rs.getString(6);
                datos[6] = (String) rs.getString(7);
                datos[7] = (String) rs.getString(8);
                datos[8] = (String) rs.getString(9);
                datos[9] = (String) rs.getString(10);
                datos[10] = (String) rs.getString(11);
                datos[11] = (String) rs.getString(12);
                datos[12] = (String) rs.getString(13);
                datos[13] = (String) rs.getString(14);
                tablapc.addRow(datos);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String datos[] = new String[14];
        int f,i;

        try {

            conn = Acceso.Enlace(conn);
            rs = Acceso.ObtenerVistaPc(rs);
            f = tablapc.getRowCount();
            if (f > 0) {
                for (i = 0; i < f; i++) {
                    tablapc.removeRow(0);
                }
            }

            while (rs.next()) {
                rs1 = Acceso.ObtenerVistaPc(rs1);
            }
            while (rs1.next()) {
                datos[0] = rs1.getString(1);
                datos[1] = rs1.getString(2);
                datos[2] = rs1.getString(3);
                datos[3] = rs1.getString(4);
                datos[4] = rs1.getString(5);
                datos[5] = rs1.getString(6);
                datos[6] = rs1.getString(7);
                datos[7] = rs1.getString(8);
                datos[8] = rs1.getString(9);
                datos[9] = rs1.getString(10);
                datos[10] = rs1.getString(11);
                datos[11] = rs1.getString(12);
                datos[12] = rs1.getString(13);
                datos[13] = rs1.getString(14);

                tablapc.addRow(datos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error BD" + e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        FrmPc pc = new FrmPc();
        pc.show();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarActionPerformed

        super.dispose();
    }//GEN-LAST:event_btncerrarActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        Point p = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(p.x - x, p.y - y);
    }//GEN-LAST:event_jPanel1MouseDragged

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
            java.util.logging.Logger.getLogger(Listado_Pc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listado_Pc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listado_Pc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listado_Pc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Listado_Pc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncerrar;
    private javax.swing.JComboBox cbopc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabpc;
    // End of variables declaration//GEN-END:variables
}
