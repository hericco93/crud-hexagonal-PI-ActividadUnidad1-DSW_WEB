<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Crear Usuario</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; background-color: #f4f4f9; }
        .form-container { width: 400px; background: #fff; padding: 20px; border-radius: 6px; box-shadow: 0 2px 5px rgba(0,0,0,0.2); }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input, select { width: 100%; padding: 8px; box-sizing: border-box; }
        button { padding: 10px 15px; background: #007bff; color: white; border: none; border-radius: 4px; cursor: pointer; }
        button:hover { background: #0069d9; }
        a { text-decoration: none; color: #6c757d; margin-left: 10px; }
    </style>
</head>
<body>

<div class="form-container">
    <h2>Registrar Usuario</h2>
    <form action="usuarios" method="post">
        <div class="form-group">
            <label for="nombre">Nombre Completo:</label>
            <input type="text" id="nombre" name="nombre" required>
        </div>
        <div class="form-group">
            <label for="email">Correo Electrónico:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="password">Contraseña:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div class="form-group">
            <label for="tipo">Tipo de Usuario:</label>
            <select id="tipo" name="tipo">
                <option value="CLIENTE">Cliente</option>
                <option value="ADMIN">Administrador</option>
            </select>
        </div>
        <button type="submit">Guardar</button>
        <a href="usuarios">Cancelar</a>
    </form>
</div>

</body>
</html>
