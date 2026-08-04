/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.ventasDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ventas;
import mvcguifinal.menu_ventas;


/**
 *
 * @author alexa
 */
public class ventasController {
    private menu_ventas vista ;
    private ventasDAO dao ;
    
    public ventasController(menu_ventas vista){
        this.vista = vista;
        dao = new ventasDAO ();
    }
    public void  insertarVentas(){
        ventas v = new ventas();
        v.setFechaVenta(vista.txtFechaVenta.getText());
        v.setTotalVenta(Double.parseDouble(vista.txtTotalventa.getText()));
        v.setFormaPago((String) vista.cbxFormaPago.getSelectedItem());
        
        
        if (dao.insertarVenta(v)!=null){
            JOptionPane.showMessageDialog(null,"Venta agregada");
            
            
        }else{
            JOptionPane.showMessageDialog(null,"Error");
        }
        
        
    }
    
    
}
