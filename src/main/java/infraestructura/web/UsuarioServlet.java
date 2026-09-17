package infraestructura.web;

import aplicacion.caso_uso.CrearUsuarioCasoUso;
import aplicacion.caso_uso.ListarUsuariosCasoUso;
import dominio.modelo.Usuario;
import infraestructura.persistencia.UsuarioRepositoryJDBC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {

    private CrearUsuarioCasoUso crearUsuarioCasoUso;
    private ListarUsuariosCasoUso listarUsuariosCasoUso;

    @Override
    public void init() throws ServletException {
        // Inyección manual de dependencias segun la arquitectura hexagonal
        UsuarioRepositoryJDBC repository = new UsuarioRepositoryJDBC();
        this.crearUsuarioCasoUso = new CrearUsuarioCasoUso(repository);
        this.listarUsuariosCasoUso = new ListarUsuariosCasoUso(repository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");

        if ("nuevo".equals(accion)) {
            req.getRequestDispatcher("/crear-usuario.jsp").forward(req, resp);
        } else {
            List<Usuario> lista = listarUsuariosCasoUso.ejecutar();
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
        crearUsuarioCasoUso.ejecutar(usuario);

        resp.sendRedirect(req.getContextPath() + "/usuarios");
    }
}