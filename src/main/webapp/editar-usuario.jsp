<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Usuario</title>
</head>
<body>
    <h2>Editar Usuario</h2>
    <form action="usuarios" method="post">
        <!-- Campo oculto para enviar el ID -->
        <input type="hidden" name="id" value="${usuario.id}">

        <label>Nombre Completo:</label>
        <input type="text" name="nombre" value="${usuario.nombre}" required><br>

        <label>Correo Electrónico:</label>
        <input type="email" name="email" value="${usuario.email}" required><br>

        <label>Contraseña:</label>
        <input type="password" name="password" value="${usuario.password}" required><br>

        <label>Tipo de Usuario:</label>
        <select name="tipo">
            <option value="CLIENTE" ${usuario.tipo == 'CLIENTE' ? 'selected' : ''}>Cliente</option>
            <option value="ADMIN" ${usuario.tipo == 'ADMIN' ? 'selected' : ''}>Administrador</option>
        </select><br><br>

        <button type="submit">Actualizar</button>
        <a href="usuarios">Cancelar</a>
    </form>
</body>
</html>
