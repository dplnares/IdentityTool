package ControladorUsuario;

import ControladorUsuario.*;
import Entidad.Usuario;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Modelo.UsuarioDAO;

public class actualizarAccion extends AccionUsuario {
    public String Comando(HttpServletRequest request, HttpServletResponse
                response) throws ServletException, IOException 
    {
        Usuario u = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        String nom=request.getParameter("nombre");
        String ape=request.getParameter("apellido");
        String usuario=request.getParameter("usuario");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        u.setNombre(nom);
        u.setApellido(ape);
        u.setUsuario(usuario);
        u.setPassword(password);
        u.setEmail(email);
        dao.edit(u);
        request.getRequestDispatcher("/listarUsuario.jsp").forward(request, response);
        
        return "";
    }
}
