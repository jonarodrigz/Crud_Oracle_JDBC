<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <div>
            <h3>Actualizar Persona</h3>
        </div>
        <div>
            <form action="Controlador" method="POST">
                <label>ID:</label>
                <input type="text" name="txtid" value="${persona.getId()}"> <br>
                <label>NOMBRE:</label>
                <input type="text" name="txtnombre" value="${persona.getNombre()}"><br>
                <label>APELLIDO:</label>
                <input type="text" name="txtapellido" value="${persona.getApellido()}"><br>
                <label>EMAIL:</label>
                <input type="email" name="txtemail" value="${persona.getEmail()}"><br>
                <label>TELEFONO:</label>
                <input type="text" name="txttelefono" value="${persona.getTelefono()}"><br>
                
                <input type="submit" name="accion"  value="Actualizar">
            </form>
        </div>
    </center>
</body>
</html>
