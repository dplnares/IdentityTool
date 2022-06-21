package Modelo;

import Configuracion.Conexion;
import Entidad.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Interface.ValidarUsuario;
import Interface.CRUDUsuario;


public class UsuarioDAO implements CRUDUsuario, ValidarUsuario{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    Usuario usu=new Usuario();
    
    @Override
    public List listar() {
        ArrayList<Usuario>list=new ArrayList<>();
        String sql="select * from login";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Usuario usu=new Usuario();
                usu.setIdUsuario(rs.getInt("idUsuario"));
                usu.setNombre(rs.getString("nombre"));
                usu.setApellido(rs.getString("apellido"));
                usu.setUsuario(rs.getString("usuario"));
                usu.setPassword(rs.getString("password"));
                usu.setEmail(rs.getString("email"));
                usu.setTipo(rs.getString("tipo"));
                           
                list.add(usu);
            }
        } catch (Exception e) {
        }
        return list;
    }
 
   @Override
    public Usuario list(String id) {
        String sql="select * from login where idUsuario="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);  
            rs=ps.executeQuery();
            while(rs.next()){                
                usu.setIdUsuario(rs.getInt("idUsuario"));
                usu.setNombre(rs.getString("nombre"));
                usu.setApellido(rs.getString("apellido"));
                usu.setUsuario(rs.getString("usuario"));
                usu.setPassword(rs.getString("password"));
                usu.setEmail(rs.getString("email"));
                usu.setTipo(rs.getString("tipo"));
            }
        } catch (Exception e) {
        }
        return usu;
    }
    
    @Override
    public Usuario select(String usuario) {
        String sql="select * from login where usuario='"+usuario+"'";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);  
            rs=ps.executeQuery();
            while(rs.next()){                
                usu.setIdUsuario(rs.getInt("idUsuario"));
                usu.setNombre(rs.getString("nombre"));
                usu.setApellido(rs.getString("apellido"));
                usu.setUsuario(rs.getString("usuario"));
                usu.setPassword(rs.getString("password"));
                usu.setEmail(rs.getString("email"));
                usu.setTipo(rs.getString("tipo"));
            }
        } catch (Exception e) {
        }
        return usu;
    }
    
    @Override
    public Usuario selectNombre(String nombre) {
        String sql="select * from login where nombre='"+nombre+"'";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);  
            rs=ps.executeQuery();
            while(rs.next()){                
                usu.setIdUsuario(rs.getInt("idUsuario"));
                usu.setNombre(rs.getString("nombre"));
                usu.setApellido(rs.getString("apellido"));
                usu.setUsuario(rs.getString("usuario"));
                usu.setPassword(rs.getString("password"));
                usu.setEmail(rs.getString("email"));
                usu.setTipo(rs.getString("tipo"));
            }
        } catch (Exception e) {
        }
        return usu;
    }

    @Override
    public boolean add(Usuario usu) {
       String sql="insert into login(nombre, apellido, usuario, clave, email, tipo) values('"+usu.getNombre()+"','"+usu.getApellido()+"','"+usu.getUsuario()+"','"+usu.getPassword()+"','"+usu.getEmail()+"', 'Usuario')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Usuario usu) {
        String sql="update login set usuario='"+usu.getNombre()+"', apellido='"+usu.getApellido()+", usuario='"+usu.getUsuario()+"', clave='"+usu.getPassword()+"', email='"+usu.getEmail()+"', tipo='"+usu.getTipo()+"'";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql="delete from login where idUsuario="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public int validar(Usuario usu) {
        int r=0;
        String sql="Select * from login where usuario=? and clave=? ";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, usu.getUsuario());
            ps.setString(2, usu.getPassword());
            rs=ps.executeQuery();
            while (rs.next()) {      
                r=r+1;
                usu.setUsuario(rs.getString("usuario"));
                usu.setPassword(rs.getString("clave"));
                usu.setTipo(rs.getString("tipo"));
            }
            if(r==1){
                if(usu.getTipo().equals("Administrador")){
                    return 1;
                }
                else{
                    return 2;
                }
            }else{
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }
}
