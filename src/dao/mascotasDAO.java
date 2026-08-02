/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import  java.sql.PreparedStatement;
import  java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 import modelo.conexionBase;
import modelo.mascotas;


/**
 *
 * @author DELL
 */
public class mascotasDAO {
    conexionBase cn = new conexionBase();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
//INSERTAR    
public boolean insertarMacotas(mascotas m){
    String sql = "INSERT INTO mascotas (id_mas,nombre_mas,raza_mas,fecha_nacimiento_mas,sexo_mas,id_especie,id_cliente)VALUES(?,?,?,?,?,?,?)";
    try{
        con =cn.getConnection();
        ps =con.prepareStatement(sql);
        ps.setInt(1, m.getId_mas());
        ps.setString(2, m.getNombre_mas());
        ps.setString(3, m.getRaza_mas());
        ps.setString(4, m.getFecha_nacimiento_mas());
        ps.setString(5, m.getSexo_mas());
        ps.setInt(6, m.getId_especie());
        ps.setInt(7, m.getId_cliente());
        
        ps.executeUpdate();
        return true;
        
    }catch(SQLException e){
        System.out.println("error"+ e.toString());
        return false;
    }      
}
//LISTAR
public List<mascotas>ListarMascotas(){
    List<mascotas> lista = new ArrayList<>();
    String sql= "SELECT * FROM mascotas";
    try{
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
            mascotas m =new mascotas();
            m.setId_mas(rs.getInt("id_mas"));
            m.setNombre_mas(rs .getString("nombre_mas"));
            m.setRaza_mas(rs .getString("raza_mas"));
            m.setFecha_nacimiento_mas(rs .getString("fecha_nacimiento_mas"));
            m.setSexo_mas(rs .getString("sexo_mas"));
            m.setId_especie(rs.getInt("id_especie"));
            m.setId_cliente(rs.getInt("id_cliente"));
            lista.add(m);
            
        }
    }catch(Exception ex){
        System.out.println(ex);
    }
    return lista;
    
}
//ELIMINAR
public boolean eliminarMacotas(int id_mas){
    String  sql = "DELETE FROM mascotas WHERE id_mas = ? ";
    try{
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, id_mas);
        ps.executeUpdate();
        
        return true;
    }catch(Exception ex){
        System.out.println("error"+ ex.toString());
        return false;
    }
}
//ACTUALIZAR
public boolean actualizarMascotas(mascotas m){
    String sql = "UPDATE mascotas SET nombre_mas=?, raza_mas=?, fecha_nacimiento_mas=?, sexo_mas=?, id_especie=?, id_cliente=? WHERE id_mas=?";
    try{
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, m.getNombre_mas());
        ps.setString(2, m.getRaza_mas());
        ps.setString(3, m.getFecha_nacimiento_mas());
        ps.setString(4, m.getSexo_mas());
        ps.setInt(5, m.getId_especie());
        ps.setInt(6, m.getId_cliente());
        ps.setInt(7, m.getId_mas());
        
        ps.executeUpdate();
        return true;
    }catch(Exception ex){
        System.out.println("error"+ ex.toString());
    }
    return false;
   }   
    
}
