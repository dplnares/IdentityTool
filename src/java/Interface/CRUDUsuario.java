package Interface;

import Entidad.Usuario;
import java.util.List;

public interface CRUDUsuario {
    public List listar();
    public Usuario list(String id);
    public Usuario select(String usuario);
    public Usuario selectNombre(String nombre);
    public boolean add(Usuario usu);
    public boolean edit(Usuario usu);
    public boolean eliminar(int id);
    
}
