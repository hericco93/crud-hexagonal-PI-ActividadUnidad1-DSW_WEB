package infraestructura.web;

import aplicacion.caso_uso.CrearUsuarioCasoUso;
import aplicacion.caso_uso.ListarUsuariosCasoUso;
import dominio.modelo.Usuario;
import infraestructura.persistencia.UsuarioRepositoryJDBC;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {

    private CrearUsuarioUseCase crearUsuarioCasoUso;
    private ListarUsuariosUseCase listarUsuariosCasoUso;

    @Override
    public void init() throws ServletException {
        // Inyección manual de dependencias segun la arquitectura hexagonal
        UsuarioRepositoryJDBC repository = new UsuarioRepositoryJDBC();
        this.crearUsuarioUseCase = new CrearUsuarioUseCase(repository);
        this.listarUsuariosUseCase = new ListarUsuariosUseCase(repository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");

        if ("nuevo".equals(accion)) {
            req.getRequestDispatcher("/crear-usuario.jsp").forward(req, resp);
        } else {
            List<Usuario> lista = listarUsuariosUseCase.ejecutar();
            req.setAttribute("usuarios", lista);
            req.getRequestDispatcher("/listar-usuarios.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String tipo = req.getParameter("tipo");

        Usuario usuario = new Usuario(0, nombre, email, password, tipo);
        crearUsuarioUseCase.ejecutar(usuario);

        resp.sendRedirect(req.getContextPath() + "/usuarios");
    }
}