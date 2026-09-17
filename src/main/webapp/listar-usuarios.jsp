<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="dominio.modelo.Usuario" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestión de Usuarios</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; background-color: #f4f4f9; }
        h2 { color: #333; }
        table { width: 100%; border-collapse: collapse; margin-top: 15px; background: #fff; }
        th, td { padding: 10px; border: 1px solid #ccc; text-align: left; }
        th { background-color: #007bff; color: white; }
        .btn { display: inline-block; padding: 8px 12px; background: #28a745; color: white; text-decoration: none; border-radius: 4px; }
        .btn:hover { background: #218838; }
        a.action-link { text-decoration: none; color: #007bff; margin-right: 5px; }
        a.action-link.delete { color: #dc3545; }
    </style>
</head>
<body>

    <h2>Lista de Usuarios</h2>
    <a href="crear-usuario.jsp" class="btn">+ Nuevo Usuario</a>
    <br><br>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Email</th>
                <th>Tipo</th>
                <th>Acciones</th> <!-- 1. Agregado encabezado -->
            </tr>
        </thead>
        <tbody>
            <%
                List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
                if (usuarios != null && !usuarios.isEmpty()) {
                    for (Usuario u : usuarios) {
            %>
                <tr>
                    <td><%= u.getId() %></td>
                    <td><%= u.getNombre() %></td>
                    <td><%= u.getEmail() %></td>
                    <td><%= u.getTipo() %></td>

                    <td>
                        <a href="usuarios?accion=editar&id=<%= u.getId() %>" class="action-link">Editar</a> |
                        <a href="usuarios?accion=eliminar&id=<%= u.getId() %>" class="action-link delete" onclick="return confirm('¿Desea eliminar este usuario?');">Eliminar</a>
                    </td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="5" style="text-align: center;">No hay usuarios registrados.</td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
