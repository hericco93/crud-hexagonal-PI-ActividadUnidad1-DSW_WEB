package aplicacion.caso_uso;

import dominio.modelo.Usuario;
import dominio.puertos.UsuarioRepository;

public class CrearUsuarioCasoUso {
    private final UsuarioRepository repository;

    public CrearUsuarioCasoUso(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void ejecutar(Usuario usuario) {
        this.repository.guardar(usuario);
    }
}
