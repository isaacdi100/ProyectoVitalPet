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
import modelo.detalleventa;
import java.sql.*;
import modelo.clientes;

import modelo.ventas;
import modelo.conexionBase;
import modelo.producto;

/**
 *
 * @author alexa
 */
public class ventasDAO {
    conexionBase cn = new conexionBase ();
    Connection con ;
    PreparedStatement ps ;
    ResultSet rs ;
    
    
    
    public int insertarVenta(ventas v){
        int idVenta = 0;
        
        String sql = "INSERT INTO ventas (fecha_venta , total_venta , forma_pago fk_id_usu)VALUES(?,?,?,?)";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, new java.sql.Date(v.getFechaVenta().getTime()));
            ps.setDouble(2,v.getTotalVenta());
            ps.setString(3, v.getFormaPago());
            ps.setInt(4, v.getId_usu());
            
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()){
                idVenta =rs.getInt(1);
                
            }
            
            
        }catch(Exception e ){
            System.out.println("Error"+ e.toString());
            
        }
        return idVenta;
    }
    public clientes buscarCliente(String cedula){
        clientes c = null ;
        String sql = "SELECT * FROM clientes where cedula_usu=? and rol_usu='cliente' and estado_usu='activo'";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cedula);
            rs = ps.executeQuery();
            if(rs.next()){
                c=new clientes();
                c.setId(rs.getInt("id_usu"));
                c.setNombre(rs.getString("nombre_usu"));
                c.setApellido(rs.getString("apellido_usu"));
                c.setCedula(rs.getString("cedula_usu"));
                
            }
        }catch(Exception e ){
            System.out.println("Error"+e.toString());
        }
        return c ;
    }
     public producto buscarProducto(String nombre){
        producto p = null;
        String sql = "select * from productos where nombre_prod=? and estado_prod='activo'";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            if(rs.next()){
                p = new producto();
                p.setIdPro(rs.getInt("id_prod"));
                p.setNombrePro(rs.getString("nombre_prod"));
                p.setPrecioPro(rs.getDouble("precio_prod"));
                p.setStockPro(rs.getInt("stock_prod"));
            }
            
        }catch(Exception e){
            System.out.println("error"+e.toString());
            
        }
        return p;
    }
     public boolean agregarDetalleVenta(detalleventa d){
        String sql = "INSERT INTO DETALLE_VENTA (cantidad, precio, subtotal,  fk_id_prod, fk_id_venta )"+
                "VALUES(?,?,?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, d.getCantidad());
            ps.setDouble(2, d.getPrecioUnitario());
            ps.setDouble(3, d.getSubtotal());
            ps.setInt(5, d.getIdProducto());
            ps.setInt(6, d.getIdVenta());
            
            ps.executeUpdate();
            return true;
            
        }catch(Exception e){
            System.out.println("error"+e.toString());
            return false;
        }
        
        
    }
    
     public List<ventas> listarVentas(){

    List<ventas> lista = new ArrayList<>();

    String sql = "SELECT v.id_venta, " +
            "v.fk_id_usu, " +
            "CONCAT(u.nombre_usu,' ',u.apellido_usu) AS cliente, " +
            "v.fecha_venta, " +
            "v.total_venta, " +
            "p.id_prod, " +
            "p.nombre_prod, " +
            "dv.cantidad, " +
            "dv.precio, " +
            "dv.subtotal, " +
            "dv.iva " +
            "FROM ventas v " +
            "INNER JOIN usuarios u ON v.fk_id_usu = u.id_usu " +
            "INNER JOIN detalle_venta dv ON v.id_venta = dv.fk_id_venta " +
            "INNER JOIN productos p ON dv.fk_id_prod = p.id_prod " +
            "ORDER BY v.id_venta DESC";


    try {

        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();


        int ventaActual = -1;
        ventas v = null;


        while(rs.next()){

            int idVenta = rs.getInt("id_venta");


            // Si es una venta nueva
            if(idVenta != ventaActual){

                v = new ventas();

                v.setIdVenta(idVenta);
                v.setId_usu(rs.getInt("fk_id_usu"));
                v.setNombreCliente(rs.getString("cliente"));
                v.setFechaVenta(rs.getDate("fecha_venta"));
                v.setTotalVenta(rs.getDouble("total_venta"));

                v.setDetalles(new ArrayList<>());


                lista.add(v);

                ventaActual = idVenta;
            }


            // Agregar detalle de producto
            detalleventa d = new detalleventa();

            d.setIdProducto(rs.getInt("id_prod"));
            d.setNombreProd(rs.getString("nombre_prod"));
            d.setCantidad(rs.getInt("cantidad"));
            d.setPrecio(rs.getDouble("precio"));
            d.setSubtotal(rs.getDouble("subtotal"));
            d.setIva(rs.getDouble("iva"));
            d.setIdVenta(idVenta);

            v.getDetalles().add(d);

        }


    } catch(Exception e){

        System.out.println("Error listar ventas: " + e);

    }


    return lista;
}
}


    
   