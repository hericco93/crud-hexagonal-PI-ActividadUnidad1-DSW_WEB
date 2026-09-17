package aplicacion.caso_uso;

import dominio.modelo.Usuario;
import dominio.puertos.UsuarioRepository;

public class ObtenerUsuarioCasoUso {
    private final UsuarioRepository usuarioRepository;

    public ObtenerUsuarioCasoUso(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario ejecutar(int id) {
        return usuarioRepository.obtenerPorId(id);
    }
}