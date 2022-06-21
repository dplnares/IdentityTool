package ControladorUsuario;

import ControladorUsuario.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class listarAccion extends AccionUsuario {

    public String Comando(HttpServletRequest request, HttpServletResponse
                response) throws ServletException, IOException 
    {
        request.getRequestDispatcher("/listarUsuarios.jsp").forward(request, response);
        
        return "";
        
        
    }
}
