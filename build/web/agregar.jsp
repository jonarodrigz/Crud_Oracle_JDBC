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
            <h3>Agregar Persona</h3>
        </div>
        <div>
            <form action="Controlador" method="POST">
                <label>ID:</label>
                <input type="text" name="txtid"> <br>
                <label>NOMBRE:</label>
                <input type="text" name="txtnombre"><br>
                <label>APELLIDO:</label>
                <input type="text" name="txtapellido"><br>
                <label>EMAIL:</label>
                <input type="email" name="txtemail"><br>
                <label>TELEFONO:</label>
                <input type="text" name="txttelefono"><br>
                
                <input type="submit" name="accion"  value="Guardar">
            </form>
        </div>
    </center>
</body>
</html>
