package ControladorUsuario;

import ControladorUsuario.*;
import Entidad.Usuario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Modelo.UsuarioDAO;

public class ingresarAccion extends AccionUsuario {
    public String Comando(HttpServletRequest request, HttpServletResponse
                response) throws ServletException, IOException 
    {
        int r = 0;
        Usuario u = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        String usuario=request.getParameter("usuario");
        String password=request.getParameter("password");
        u.setUsuario(usuario);
        u.setPassword(password);
        r=dao.validar(u);
        if(r==1){
            request.getSession().setAttribute("login", usuario);
            request.getRequestDispatcher("indexAdmin.html").forward(request, response);
        }else{
            if(r==2){
                request.getSession().setAttribute("login", usuario);
                request.getRequestDispatcher("indexUser.html").forward(request, response);
            }
            else{
                request.getRequestDispatcher("signin.html").forward(request, response);
            }
        }
        
        return "";
    }
}
