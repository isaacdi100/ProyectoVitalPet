/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author AEINK
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import modelo.conexionBase;
import modelo.detalleventa;

public class detalleventaDAO {

    conexionBase cn = new conexionBase();
    Connection con;
    PreparedStatement ps;

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

}