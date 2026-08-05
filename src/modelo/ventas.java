/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author alexa
 */
public class ventas {
    private int idVenta;
    private String fechaVenta;
    private Double totalVenta ;
    private String formaPago ;
    
    public ventas(){}
    public ventas(int idVenta , String fechaVenta ,Double totalVenta, String formaPago){
        this.idVenta=idVenta ;
        this.fechaVenta=fechaVenta;
        this.totalVenta=totalVenta;
        this.formaPago=formaPago ;
        
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setFechaVenta(String fechaVenta) {
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

    public String getFechaVenta() {
        return fechaVenta;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public String getFormaPago() {
        return formaPago;
    }
    
    
    
}
