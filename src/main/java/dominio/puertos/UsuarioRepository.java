package dominio.puertos;

import dominio.modelo.Usuario;
import java.util.List;

public interface UsuarioRepository {
    void guardar(Usuario usuario);
    List<Usuario> listarTodos();
    Usuario obtenerPorId(int id);
    void actualizar(Usuario usuario);
    void eliminar(int id);
}