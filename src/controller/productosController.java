package controller;

import dao.productosDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.producto;
import mvcguifinal.menu_productos;

/**
 *
 * @author alexa
 */
public class productosController {
    private menu_productos vista;
    private productosDAO dao;

    public productosController(menu_productos vista) {
        this.vista = vista;
        dao = new productosDAO();
    }

    public void insertarProductos() {
        producto p = new producto();
        p.setNombrePro(vista.txtNombrePro.getText());
        p.setCategoriaPro(vista.cbxCategoriaPro.getSelectedItem().toString());
        p.setPrecioPro(Double.parseDouble(vista.txtPrecioPro.getText()));
        p.setStockPro(Integer.parseInt(vista.txtStockPro.getText()));
        p.setFechaVencimientoPro(vista.txtVencimientoPro.getText());

        if (dao.insertarProductos(p)) {
            JOptionPane.showMessageDialog(null, "Producto Agregado");
            ListarProductos();
        } else {
            JOptionPane.showMessageDialog(null, "Error al agregar producto");
        }
    }

    public void ListarProductos() {
        DefaultTableModel modelo = (DefaultTableModel) vista.tblProductos.getModel();
        modelo.setRowCount(0);
        List<producto> lista = dao.ListarProductos();
        for (producto p : lista) {
            Object[] fila = {
                p.getIdPro(),
                p.getNombrePro(),
                p.getCategoriaPro(),
                p.getPrecioPro(),
                p.getStockPro(),
                p.getFechaVencimientoPro()
            };
            modelo.addRow(fila);
        }
    }

    public void eliminarProductos() {
        int fila = vista.tblProductos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
        } else {
            int opc = JOptionPane.showConfirmDialog(null, "¿Deseas Eliminar este registro?", "Confirmar Accion", JOptionPane.YES_NO_OPTION);
            if (opc != JOptionPane.YES_OPTION) {
                return;
            } else {
                int id_pro = Integer.parseInt(vista.tblProductos.getValueAt(fila, 0).toString());
                if (dao.eliminarProductos(id_pro)) {
                    JOptionPane.showMessageDialog(null, "Eliminado con exito");
                    ListarProductos();
                }
            }
        }
    }

    public void actualizarProductos() {
        int fila = vista.tblProductos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
            return;
        }
        producto p = new producto();
        p.setIdPro(Integer.parseInt(vista.tblProductos.getValueAt(fila, 0).toString()));
        p.setNombrePro(vista.txtNombrePro.getText());
        p.setCategoriaPro(vista.cbxCategoriaPro.getSelectedItem().toString());
        p.setPrecioPro(Double.parseDouble(vista.txtPrecioPro.getText()));
        p.setStockPro(Integer.parseInt(vista.txtStockPro.getText()));
        p.setFechaVencimientoPro(vista.txtVencimientoPro.getText());

        if (dao.actualizarProductos(p)) {
            JOptionPane.showMessageDialog(null, "Producto Actualizado");
            ListarProductos();
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar");
        }
    }
}