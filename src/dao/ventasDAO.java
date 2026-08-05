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
            ps.setDouble(2,v.getTotalVenta());
            ps.setString(3, v.getFormaPago());
            
            ps.executeUpdate();
            return true ;
            
            
        }catch(Exception e ){
            System.out.println("Error"+ e.toString());
            return false;
        }
    }
    public List<ventas>  ListarVentas(){
        List <ventas> lista = new ArrayList();
        String sql = "SELECTED * FROM ventas ";
        try{
            con = cn.getConnection ();
            ps= con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                ventas v = new ventas();
                v.setIdVenta(rs.getInt("id_venta"));
                v.setFechaVenta(rs.getString("fecha_venta"));
                v.setTotalVenta(rs.getDouble ("total_venta"));
                v.setFormaPago(rs.getString("forma_pago"));
                
                lista.add(v);
                
            }
        }catch(Exception e ){
            System.out.println(e);
        }
        return lista ;
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
    public boolean actualizarVentas(ventas v ){
        String sql="UPDATE ventas SET fecha_venta =? , total_vcenta=? forma_pago =? WHERE id_venta=?";
        try{
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, v.getFechaVenta());
            ps.setDouble(2, v.getTotalVenta());
            ps.setString(3, v.getFormaPago());
            ps.setInt(0, v.getIdVenta());
        }catch(Exception e){
            System.out.println("Error"+e.toString());
        }
        return false ;
    }
}


