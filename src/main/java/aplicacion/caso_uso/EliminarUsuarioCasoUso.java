package aplicacion.caso_uso;

import dominio.puertos.UsuarioRepository;

public class EliminarUsuarioCasoUso {
    private final UsuarioRepository usuarioRepository;

    public EliminarUsuarioCasoUso(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void ejecutar(int id) {
        usuarioRepository.eliminar(id);
    }
}