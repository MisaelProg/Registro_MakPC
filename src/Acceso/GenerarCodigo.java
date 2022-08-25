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
public class GenerarCodigo {
    static Connection conn=null;
    static Statement st=null;
    static ResultSet rs=null;
    
    static String bd="makpc";
    static String login="root";
    static String password="";
    static String url="jdbc:mysql://localhost/"+bd;
       
    private int dato;
    private final int cont=1;
    private String num="";
    public static Connection Enlace(Connection conn) throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,e);
        }
        return conn;
    }
    
    public static Statement sta(Statement st) throws SQLException{
       conn = Enlace(conn);
       st = conn.createStatement();
       return st;
    }
    
    public void generar(int dato)
    {
        
        this.dato = dato;
        if((this.dato>=1000) || (this.dato<1000))
        {
            int can=cont+this.dato;
            num = "" + can;
        }
        if((this.dato>=100) || (this.dato<100))
        {
            int can=cont+this.dato;
            num = "0" + can;
        }
        if((this.dato>=9) || (this.dato<100))
        {
            int can=cont+this.dato;
            num = "00" + can;
        }
        if(this.dato<9)
        {
            int can=cont+this.dato;
            num = "000" + can;
        }
        
    }
    
   public String serie()
   {
       return this.num;
       
   }
}
