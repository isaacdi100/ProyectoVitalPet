/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author alexa
 */
public class ventas {
    private int idVenta;
    private Date fechaVenta;
    private Double totalVenta ;
    private String formaPago ;
    private int Id_usu;
    private String nombreCliente;
    
    
    private List<detalleventa> detalles ;

    public void setDetalles(List<detalleventa> detalles) {
        this.detalles = detalles;
    }

    public List<detalleventa> getDetalles() {
        return detalles;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }
    

    public int getId_usu() {
        return Id_usu;
    }

    public void setId_usu(int getId_usu) {
        this.Id_usu = getId_usu;
    }
    
    public ventas(){}
    public ventas(int idVenta , Date fechaVenta ,Double totalVenta, String formaPago){
        this.idVenta=idVenta ;
        this.fechaVenta=fechaVenta;
        this.totalVenta=totalVenta;
        this.formaPago=formaPago ;
        
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public String getFormaPago() {
        return formaPago;
    }

  
    
    
}
