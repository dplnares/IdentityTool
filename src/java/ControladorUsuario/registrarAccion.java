package ControladorUsuario;

import ControladorUsuario.*;
import Modelo.UsuarioDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Entidad.Usuario;

public class registrarAccion extends AccionUsuario {
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
        dao.add(u);
        request.getRequestDispatcher("index.html").forward(request, response);
        
        return "";
    }
}
