package aplicacion.caso_uso;

import dominio.modelo.Usuario;
import dominio.puertos.UsuarioRepository;

public class ActualizarUsuarioCasoUso {
    private final UsuarioRepository usuarioRepository;

    public ActualizarUsuarioCasoUso(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void ejecutar(Usuario usuario) {
        usuarioRepository.actualizar(usuario);
    }
}
