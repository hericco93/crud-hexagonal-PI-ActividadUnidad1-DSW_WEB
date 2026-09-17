package infraestructura.web;

import aplicacion.caso_uso.CrearUsuarioCasoUso;
import aplicacion.caso_uso.ListarUsuariosCasoUso;
import aplicacion.caso_uso.ActualizarUsuarioCasoUso;
import aplicacion.caso_uso.EliminarUsuarioCasoUso;
import aplicacion.caso_uso.ObtenerUsuarioCasoUso;
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
    private ObtenerUsuarioCasoUso obtenerUsuarioCasoUso;
    private ActualizarUsuarioCasoUso actualizarUsuarioCasoUso;
    private EliminarUsuarioCasoUso eliminarUsuarioCasoUso;

    @Override
    public void init() throws ServletException {
        UsuarioRepositoryJDBC repository = new UsuarioRepositoryJDBC();

        this.crearUsuarioCasoUso = new CrearUsuarioCasoUso(repository);
        this.listarUsuariosCasoUso = new ListarUsuariosCasoUso(repository);
        this.obtenerUsuarioCasoUso = new ObtenerUsuarioCasoUso(repository);
        this.actualizarUsuarioCasoUso = new ActualizarUsuarioCasoUso(repository);
        this.eliminarUsuarioCasoUso = new EliminarUsuarioCasoUso(repository);
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

        if ("eliminar".equals(accion)) {
            int id = Integer.parseInt(req.getParameter("id"));
            eliminarUsuarioCasoUso.ejecutar(id);
            resp.sendRedirect(req.getContextPath() + "/usuarios");
            return;
        }

        if ("editar".equals(accion)) {
            int id = Integer.parseInt(req.getParameter("id"));
            Usuario usuario = obtenerUsuarioCasoUso.ejecutar(id);
            req.setAttribute("usuario", usuario);
            req.getRequestDispatcher("/editar-usuario.jsp").forward(req, resp);
            return;
        }

        // Listar por defecto
        List<Usuario> lista = listarUsuariosCasoUso.ejecutar();
        req.setAttribute("usuarios", lista);
        req.getRequestDispatcher("/listar-usuarios.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        String nombre = req.getParameter("nombre");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String tipo = req.getParameter("tipo");

        if (idStr != null && !idStr.trim().isEmpty()) {
            // Actualizar existente (editar-usuario.jsp envía el ID)
            int id = Integer.parseInt(idStr);
            Usuario usuario = new Usuario(id, nombre, email, password, tipo);
            actualizarUsuarioCasoUso.ejecutar(usuario);
        } else {
            // Crear nuevo (crear-usuario.jsp no envía campo ID)
            Usuario usuario = new Usuario(0, nombre, email, password, tipo);
            crearUsuarioCasoUso.ejecutar(usuario);
        }

        resp.sendRedirect(req.getContextPath() + "/usuarios");
    }
}