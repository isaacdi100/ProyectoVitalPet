/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.detalleventaDAO;
import java.util.List;
import modelo.detalleventa;

/**
 *
 * @author AEINK
 */
public class detalleventasController {

    private detalleventaDAO dao;

    public detalleventasController() {
        dao = new detalleventaDAO();
    }

    public boolean registrarDetalle(detalleventa d) {
        return dao.insertarDetalle(d);
    }
    public List<detalleventa> listarDetalles() {
    return dao.ListarDetalles();
}
}
   
