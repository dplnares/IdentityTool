package ControladorUsuario;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.ServletException;

public abstract class AccionUsuario {
    public abstract String Comando(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
    
    public static AccionUsuario getAccion(String valor){
        AccionUsuario accion = null;
        
        if(valor.equals("registrar")){
            accion = new registrarAccion();
        }
        else{
            if(valor.equals("listar")){
                accion = new listarAccion();
            }
            else{
                if(valor.equals("actualizar")){
                    accion = new actualizarAccion();
                }
                else{
                    if(valor.equals("eliminar")){
                        accion = new eliminarAccion();
                    }
                    else{
                        if(valor.equals("Ingresar")){
                            accion = new ingresarAccion();
                        }
                        else{
                            if(valor.equals("agregar")){
                                accion = new agregarAccion();
                            }
                        }
                    }
                }
            }
        }
        return accion;
    }
}
