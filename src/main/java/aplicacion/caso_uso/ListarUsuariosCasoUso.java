package aplicacion.caso_uso;

import dominio.modelo.Usuario;
import dominio.puertos.UsuarioRepository;
import java.util.List;

public class ListarUsuariosCasoUso {
    private final UsuarioRepository repository;

    public ListarUsuariosCasoUso(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> ejecutar() {
        return this.repository.listarTodos();
    }
}