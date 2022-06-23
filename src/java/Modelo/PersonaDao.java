package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDao {
    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection conexion;
    
    public List listar(){
        List<Persona> lista = new ArrayList<>();
        String sql = "select * from personas";
        try {
            conexion=c.conectar();
            ps=conexion.prepareStatement(sql);
            rs = ps.executeQuery();
             while (rs.next()) {
                Persona p = new Persona();
                p.setId(rs.getString(1));
                p.setNombre(rs.getString(2));
                p.setApellido(rs.getString(3));
                p.setEmail(rs.getString(4));
                p.setTelefono(rs.getString(5));
                lista.add(p);
                   System.out.println(p);    
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return lista;
    }
    
    public boolean agregar(Persona p){
        boolean resultado= false;
        String sql = "insert into personas (id, nombre,apellido, email, telefono) values (?,?,?,?,?)";
        try {
            conexion=c.conectar();
            ps = conexion.prepareStatement(sql);
            ps.setString(1, p.getId());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getApellido());
            ps.setString(4, p.getEmail());
            ps.setString(5, p.getTelefono());
            if(ps.executeUpdate()==1){
                resultado = true;
            }else{
                resultado = false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return resultado;
    }
    
    public Persona listarById(String id){
        Persona p = new Persona();
        String sql = "select * from personas where id="+id;
        
        try {
            conexion= c.conectar();
            ps=conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                p.setId(rs.getString(1));
                p.setNombre(rs.getString(2));
                p.setApellido(rs.getString(3));
                p.setEmail(rs.getString(4));
                p.setTelefono(rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
    
    public boolean actualizar(Persona p){
        boolean resultado = false;
         String sql = "update personas set nombre=?, apellido=?, email=?, telefono=? where id="+p.getId();
         
         try {
            conexion=c.conectar();
            ps=conexion.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setString(3, p.getEmail());
            ps.setString(4, p.getTelefono());
            
            if(ps.executeUpdate()==1){
                resultado= true;
            }else{
                resultado=false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return resultado;
    }
    
    public void eliminar(String id){
          String sql = "delete from personas where id="+id;
        try {
            conexion=c.conectar();
            ps=conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        
           }
}
