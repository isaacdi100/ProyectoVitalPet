/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.ventas;
import modelo.conexionBase;


/**
 *
 * @author alexa
 */
public class ventasDAO {
    conexionBase cn = new conexionBase ();
    Connection con ;
    PreparedStatement ps ;
    ResultSet rs ;
    
    
    public Boolean insertarVenta(ventas v){
        String sql = "INSERT INTO ventas (fecha_venta , total_venta , forma_pago)VALUES(?,?,?)";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, v.getFechaVenta());
            ps.setString(2,v.getTotalVenta());
            ps.setString(3, v.getFormaPago());
            
            ps.executeUpdate();
            return true ;
            
            
        }catch(Exception e ){
            System.out.println("Error"+ e.toString());
            return false;
        }
    }
    public boolean eliminarVnetas (int id_venta){
        String sql ="DELETE FROM ventas Where id_venta =?";
        try{
            con = cn.getConnection();
            ps= con.prepareStatement(sql);
            ps.setInt(1,id_venta);
            ps.executeUpdate();
            return true ;
            
        }catch(Exception e ){
            System.out.println("Error"+e.toString());
            return false ;
        }
    }
}


