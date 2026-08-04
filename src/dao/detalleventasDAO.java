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

import modelo.conexionBase;
import modelo.detalleventa;

/**
 *
 * @author AEINK
 */
public class detalleventasDAO {

    conexionBase cn = new conexionBase();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // INSERTAR
    public boolean insertarDetalle(detalleventa d) {

        String sql = "INSERT INTO detalle_ventas(id_venta,id_producto,cantidad,precio_unitario,subtotal) VALUES(?,?,?,?,?)";

        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, d.getIdVenta());
            ps.setInt(2, d.getIdProducto());
            ps.setInt(3, d.getCantidad());
            ps.setDouble(4, d.getPrecioUnitario());
            ps.setDouble(5, d.getSubtotal());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {

            System.out.println("Error " + e.toString());
            return false;

        }
    }

    // LISTAR
    public List<detalleventa> listarDetalles() {

        List<detalleventa> lista = new ArrayList<>();

        String sql = "SELECT * FROM detalle_ventas";

        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                detalleventa d = new detalleventa();

                d.setIdDetalle(rs.getInt("id_detalle"));
                d.setIdVenta(rs.getInt("id_venta"));
                d.setIdProducto(rs.getInt("id_producto"));
                d.setCantidad(rs.getInt("cantidad"));
                d.setPrecioUnitario(rs.getDouble("precio_unitario"));
                d.setSubtotal(rs.getDouble("subtotal"));

                lista.add(d);
            }

        } catch (Exception e) {

            System.out.println(e.toString());

        }

        return lista;
    }

    // BUSCAR
    public detalleventa buscarDetalle(int idDetalle) {

        detalleventa d = null;

        String sql = "SELECT * FROM detalle_ventas WHERE id_detalle=?";

        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, idDetalle);

            rs = ps.executeQuery();

            if (rs.next()) {

                d = new detalleventa();

                d.setIdDetalle(rs.getInt("id_detalle"));
                d.setIdVenta(rs.getInt("id_venta"));
                d.setIdProducto(rs.getInt("id_producto"));
                d.setCantidad(rs.getInt("cantidad"));
                d.setPrecioUnitario(rs.getDouble("precio_unitario"));
                d.setSubtotal(rs.getDouble("subtotal"));
            }

        } catch (Exception e) {

            System.out.println(e.toString());

        }

        return d;
    }

    // ACTUALIZAR
    public boolean actualizarDetalle(detalleventa d) {

        String sql = "UPDATE detalle_ventas SET id_venta=?, id_producto=?, cantidad=?, precio_unitario=?, subtotal=? WHERE id_detalle=?";

        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, d.getIdVenta());
            ps.setInt(2, d.getIdProducto());
            ps.setInt(3, d.getCantidad());
            ps.setDouble(4, d.getPrecioUnitario());
            ps.setDouble(5, d.getSubtotal());
            ps.setInt(6, d.getIdDetalle());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {

            System.out.println("Error " + e.toString());
            return false;

        }
    }

    // ELIMINAR
    public boolean eliminarDetalle(int idDetalle) {

        String sql = "DELETE FROM detalle_ventas WHERE id_detalle=?";

        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, idDetalle);

            ps.executeUpdate();

            return true;

        } catch (Exception e) {

            System.out.println("Error " + e.toString());
            return false;

        }
    }
}

