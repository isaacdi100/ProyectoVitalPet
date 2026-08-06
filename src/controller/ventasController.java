/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import modelo.ventas;
import modelo.detalleventa;
import dao.ventasDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.clientes;
import modelo.producto;




/**
 *
 * @author alexa
 */
public class ventasController {
    private ventasDAO dao ;
    private List<detalleventa> listaDetalle;
    public ventasController(){
    dao = new ventasDAO();
    listaDetalle = new ArrayList<>();
} 
// Buscar cliente
    public clientes buscarCliente(String cedula) {
        return dao.buscarCliente(cedula);
    }

    // Buscar producto
    public producto buscarProducto(String nombre) {
        return dao.buscarProducto(nombre);
    }
    public void agregarProducto(int idProducto, int cantidad, double precio){
        detalleventa d = new detalleventa();
        d.setIdProducto(idProducto);
        d.setCantidad(cantidad);
        d.setPrecio(precio);
        d.setSubtotal(cantidad*precio);
        listaDetalle.add(d);
    }
    public double calcularTotal(){
        double total = 0;
        double iva = 0;
        for(detalleventa d : listaDetalle){
            total +=d.getSubtotal();
            iva = total*0.15;
        }
        return total;
    }
    public void registrarVenta(int idCliente){
        ventas v = new ventas();
        v.setFechaVenta(new Date());
        v.setTotalVenta(calcularTotal());
        v.setId_usu(idCliente);
        int idVenta = dao.insertarVenta(v);
        if (idVenta> 0){
            for(detalleventa d : listaDetalle){
                d.setIdVenta(idVenta);
                dao.agregarDetalleVenta(d);
            }
            JOptionPane.showMessageDialog(null, "venta registrada");
        }
        else{
            JOptionPane.showMessageDialog(null, "error al guardar venta");
        }
    }
    public List<detalleventa> getListaDetalle(){
        return listaDetalle;
    }
    public List<ventas> listarVentas(){

    return dao.listarVentas();

}

    public List<detalleventa> ListarDetalles() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

    
 

    
    
