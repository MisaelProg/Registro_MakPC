/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Misael
 */
public class Acceso {
   
    
    static Connection conn = null;
    static Statement st = null;
    static ResultSet rs = null;

    static String bd = "makpc";
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/" + bd;

    public static Connection Enlace(Connection conn) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return conn;
    }

    public static Statement sta(Statement st) throws SQLException {
        conn = Enlace(conn);
        st = conn.createStatement();
        return st;
    }
    public static Connection conectar() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url, login, password);
            System.out.println("conexion establecida");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return conexion;
    }

    
    
    
    
    
    //OBTERNER VISTAS POR ALGUN DATO
    
    
    
    public static ResultSet obtenerVistaClientePorNumeroDocumento(ResultSet rs, String nom) throws SQLException{
        st = sta(st);
        String sql;
        sql="select * from cliente where numero_documento = ?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1, nom);
        rs=ps.executeQuery();
        return rs;
    }
    public static ResultSet obtenerVistaIterinarioPorDni(ResultSet rs, String nom) throws SQLException{
        st = sta(st);
        String sql;
        sql="select * from v_busqueda_iteri where numero_documento = ?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1, nom);
        rs=ps.executeQuery();
        return rs;
    }
     public static ResultSet obtenerVistaRegistPorDni(ResultSet rs, String nom) throws SQLException{
        st = sta(st);
        String sql;
        sql="select * from v_busqueda_iteri where numero_documento = ? ";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1, nom);
        rs=ps.executeQuery();
        return rs;
    }
     public static ResultSet obtenerVistaImpresoraPorMarca(ResultSet rs, String nom) throws SQLException{
        st = sta(st);
        String sql;
        sql="select * from v_impresora where marca_impresora = ? ";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1, nom);
        rs=ps.executeQuery();
        return rs;
    }
     public static ResultSet obtenerVistaPcPorMarca(ResultSet rs, String nom) throws SQLException{
        st = sta(st);
        String sql;
        sql="select * from v_pc where des_marca_dispositivo = ? ";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1, nom);
        rs=ps.executeQuery();
        return rs;
    }
     public static ResultSet obtenerVistaLaptopPorMarca(ResultSet rs, String nom) throws SQLException{
        st = sta(st);
        String sql;
        sql="select * from v_laptop where des_marca_dispositivo = ? ";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1, nom);
        rs=ps.executeQuery();
        return rs;
    }
    

     //OBTENER CODIGOS
    public static ResultSet obtenerCodTipDis(ResultSet rs, String nom) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select id_dis from dispositivo where tipo_dis='" + nom + "'";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerCodMarcImp(ResultSet rs, String nom) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select id_marca_impresora from marca_impresora where marca_impresora='" + nom + "'";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerCodMarDis(ResultSet rs, String nom) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select id_dis	 from dispositivo where tipo_dis='" + nom + "'";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerCodRam(ResultSet rs, String nom) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select id_ram from  memoria_ram where marca_ram='" + nom + "'";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerCodPlaca(ResultSet rs, String nom) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select id_placa	from   placa where marca_pla='" + nom + "'";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerCodDisco(ResultSet rs, String nom) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select id_disco	from  disco where marca_disco='" + nom + "'";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerCodProcesa(ResultSet rs, String nom) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select id_procesador from  procesador where des_pro='" + nom + "'";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerCodAcces(ResultSet rs, String nom) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select id_accesorio from  accesorios where des_acce='" + nom + "'";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerCodColor(ResultSet rs, String nom) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select id_color from   color where des_color='" + nom + "'";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerCodTarjetVideo(ResultSet rs, String nom) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select id_tarjetavi from  tarjeta_vi where marca_tarjetavi='" + nom + "'";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerCodMarcaDispositivo(ResultSet rs, String nom) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select id_marca_dispositivo from  dispositivo_marcas where des_marca_dispositivo='" + nom + "'";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerCodMarcaProcesador(ResultSet rs, String nom) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select id_procesador from  procesador where des_pro='" + nom + "'";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerCodMarcaDisco(ResultSet rs, String nom) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select id_disco from  disco where marca_disco='" + nom + "'";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerCodMarcaRam(ResultSet rs, String nom) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select id_ram from  memoria_ram where marca_ram='" + nom + "'";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerCodMarcaPlaca(ResultSet rs, String nom) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select id_placa from  placa where marca_pla='" + nom + "'";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerCodMarcaTarjetVideo(ResultSet rs, String nom) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select id_tarjetavi from  tarjeta_vi where marca_tarjetavi='" + nom + "'";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerCodMarcaAccesorio(ResultSet rs, String nom) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select id_accesorio from  accesorios where des_acce='" + nom + "'";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerCodNombreColor(ResultSet rs, String nom) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select id_color from  color where des_color ='" + nom + "'";
        rs = st.executeQuery(sql);
        return rs;
    }

    //OBTERNER NOMBRES
    public static ResultSet obtenerMarcaImpresora(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select marca_impresora from marca_impresora";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerMarcaDispositivo(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select des_marca_dispositivo from dispositivo_marcas";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerMarcaProcesador(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select des_pro from procesador";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerTipoDisco(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select marca_disco from disco";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerMarcaRam(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select marca_ram from memoria_ram";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerMarcaPlaca(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select marca_pla from placa";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerMarcaTarjetVideo(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select marca_tarjetavi from tarjeta_vi";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerMarcaAccesorios(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select des_acce from accesorios";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerNombreColor(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select des_color from color";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerTipoDispo(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select tipo_dis from dispositivo";
        rs = st.executeQuery(sql);
        return rs;
    }

     //VISTAS
    public static ResultSet ObtenerVistaImpresora(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select * from v_impresora order by id_impresora asc";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet ObtenerVistaLaptop(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select * from v_laptop order by id_laptop asc";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet ObtenerVistaPc(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select * from v_pc order by id_pc asc";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet ObtenerVistaAccesorios(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select * from v_accesorios";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerVistaNombreDispositivo(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select * from v_nombre_dispositivo";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerVistaMarcaDispositivo(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select * from v_marca_dispositivo";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerVistaMarcaram(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select * from v_marca_ram";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerVistaMarcaplaca(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select * from v_marca_placa";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerVistaMarcadisco(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select * from v_nombre_disco";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerVistaMarcaprocesador(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select * from v_marca_procesador";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerVistaMarcamonitor(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select * from v_marca_monitor";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerVistaMarcatarjetavi(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select * from v_marca_tarjeta_video";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerVistaaccesorios(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select * from v_accesorios";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerVistacolores(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select * from v_colores";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerVistamarcaimpresora(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select * from v_marca_impresora";
        rs = st.executeQuery(sql);
        return rs;
    }

    public static ResultSet obtenerVistaCliente(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select * from v_clientes";
        rs = st.executeQuery(sql);
        return rs;
    }
    
    public static ResultSet obtenerVistaClienteyIterinario(ResultSet rs) throws SQLException {
        st = sta(st);
        String sql;
        sql = "select * from v_busqueda_iteri order by id_ite asc";
        rs = st.executeQuery(sql);
        return rs;
    }

    //ACCESOS
    public static ResultSet EnlIterinario(ResultSet rs) throws SQLException {
        st = sta(st);
        rs = st.executeQuery("select * from nuevo_ite");
        return rs;
    }

    public static ResultSet EnlCliente(ResultSet rs) throws SQLException {
        st = sta(st);
        rs = st.executeQuery("select * from cliente");
        return rs;
    }

    public static ResultSet EnlImpresora(ResultSet rs) throws SQLException {
        st = sta(st);
        rs = st.executeQuery("select * from impresora");
        return rs;
    }

    public static ResultSet EnlLaptop(ResultSet rs) throws SQLException {
        st = sta(st);
        rs = st.executeQuery("select * from laptop");
        return rs;
    }

    public static ResultSet EnlPc(ResultSet rs) throws SQLException {
        st = sta(st);
        rs = st.executeQuery("select * from laptop");
        return rs;
    }

    public static ResultSet EnlAccesorios(ResultSet rs) throws SQLException {
        st = sta(st);
        rs = st.executeQuery("select * from nueva_acce");
        return rs;
    }
     public static ResultSet EnlUsuario(ResultSet rs) throws SQLException {
        st = sta(st);
        rs = st.executeQuery("select * from usuario");
        return rs;
    }

}
