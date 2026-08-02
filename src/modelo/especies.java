/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ASUS
 */
public class especies {
    
    private int idEsp;
    private String nombreEsp;
    private String descripcionEsp;

    public especies() {
    }

    public int getIdEsp() {
        return idEsp;
    }

    public String getNombreEsp() {
        return nombreEsp;
    }

    public String getDescripcionEsp() {
        return descripcionEsp;
    }

    public void setIdEsp(int idEsp) {
        this.idEsp = idEsp;
    }

    public void setNombreEsp(String nombreEsp) {
        this.nombreEsp = nombreEsp;
    }

    public void setDescripcionEsp(String descripcionEsp) {
        this.descripcionEsp = descripcionEsp;
    }
    
}
