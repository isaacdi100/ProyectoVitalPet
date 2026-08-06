/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.mascotasDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.mascotas;
import mvcguifinal.menu_mascotas;



/**
 *
 * @author DELL
 */
public class mascotasController {
    private menu_mascotas vista;
    private mascotasDAO dao;
    
    public mascotasController(menu_mascotas vista){
        this.vista = vista;
        dao = new mascotasDAO();
        
        
}
    //INSERTAR
    public void insertarMascotas(){
        mascotas m = new mascotas();
        m.setNombre_mas(vista.txtNombreMa.getText());
        m.setRaza_mas(vista.txtRazaMa.getText());
        m.setFecha_nacimiento_mas(vista.txtNacimientoMa.getText());
        m.setSexo_mas(vista.cbxSexoMa.getSelectedItem().toString());
        m.setId_especie(Integer.parseInt(vista.txtIdEspecie.getText()));
        m.setId_cliente(Integer.parseInt(vista.txtIdCliente.getText()));
        
        if (dao.insertarMacotas(m)) {
            JOptionPane.showMessageDialog(null, "Mascota Agregada");
            ListarMascotas();
            
    }else{
            JOptionPane.showMessageDialog(null, "Error al insertar mascota");
        }
    }
    //LISTAR
    public void ListarMascotas(){
        DefaultTableModel modelo = (DefaultTableModel) vista.tblMascotas.getModel();
        modelo.setRowCount(0);
        List<mascotas>lista = dao.ListarMascotas();
        for(mascotas m : lista){
            Object[] fila ={
                m.getId_mas(),
                m.getNombre_mas(),
                m.getRaza_mas(),
                m.getFecha_nacimiento_mas(),
                m.getSexo_mas(),
                m.getId_especie(),
                m.getId_cliente()
            };
            modelo.addRow(fila);
            
        }
    }
 //ELIMINAR
    public void eliminarMascotas(){
        int fila = vista.tblMascotas.getSelectedRow();
        if (fila == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
           
        }else{
            int opc = JOptionPane.showConfirmDialog(null, "¿Deseas Eliminar esta mascota?", "Confirmar Accion", JOptionPane.YES_NO_OPTION);
            if (opc == JOptionPane.YES_OPTION){
                return;
            }else{
                int id_mas = Integer.parseInt(vista.tblMascotas.getValueAt(fila, 0).toString());
                if (dao.eliminarMascotas(id_mas)){
                    JOptionPane.showMessageDialog(null, "Eliminado con exito");
                    ListarMascotas();
                    LimpiarTextos();
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Error al eliminar");
                }
               
            }
        }
      
    }
    //ACTUALIZAR
    public void actualizarMascotas(){
        int fila =vista.tblMascotas.getSelectedRow();
        if (fila == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para actualizar");
            return;
        }
        if (vista.txtIdEspecie.getText().trim().isEmpty() || vista.txtIdCliente.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Los campos id_especie e id_cliente no pueden estar vacios");
            return;
    }
            mascotas m= new mascotas();
            m.setId_mas(Integer.parseInt(vista.tblMascotas.getValueAt(fila, 0).toString()));
            m.setNombre_mas(vista.txtNombreMa.getText());
            m.setRaza_mas(vista.txtRazaMa.getText());
            m.setFecha_nacimiento_mas(vista.txtNacimientoMa.getText());
            m.setSexo_mas(vista.cbxSexoMa.getSelectedItem().toString());
            m.setId_especie(Integer.parseInt(vista.txtIdEspecie.getText().trim()));
            m.setId_cliente(Integer.parseInt(vista.txtIdCliente.getText().trim()));
            
            if (dao.actualizarMascotas(m)){
                JOptionPane.showMessageDialog(null, "Mascota Actualizada correctamente");
                ListarMascotas();
               LimpiarTextos();
            }else{
                JOptionPane.showMessageDialog(null, "Error al actualizar");
            }   
        }
    //LIMPIAR
    public void LimpiarTextos(){
        vista.txtNombreMa.setText("");
        vista.txtRazaMa.setText("");
        vista.txtNacimientoMa.setText("");
        vista.cbxSexoMa.setSelectedIndex(0);
        vista.txtIdEspecie.setText("");
        vista.txtIdCliente.setText("");
    }
}

                
    
    
