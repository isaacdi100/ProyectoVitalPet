/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.detalleventasDAO;
import java.util.List;
import modelo.detalleventa;

/**
 *
 * @author AEINK
 */
public class detalleventascontroller {

    private detalleventasDAO dao;

    public detalleventascontroller() {
        dao = new detalleventasDAO();
    }

    // Registrar detalle
    public boolean registrarDetalle(detalleventa d) {
        return dao.insertarDetalle(d);
    }

    // Listar detalles
    public List<detalleventa> listarDetalles() {
        return dao.listarDetalles();
    }

    // Eliminar detalle
    public boolean eliminarDetalle(int idDetalle) {
        return dao.eliminarDetalle(idDetalle);
    }

    // Actualizar detalle
    public boolean actualizarDetalle(detalleventa d) {
        return dao.actualizarDetalle(d);
    }

    // Buscar detalle
    public detalleventa buscarDetalle(int idDetalle) {
        return dao.buscarDetalle(idDetalle);
    }
}
