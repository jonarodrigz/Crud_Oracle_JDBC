<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h3>Formulario Personas</h3>
            <form action="Controlador" method="POST">
                <input type="submit" name ="accion" value="Listar">
                <input type="submit" name ="accion" value="Nuevo">
            </form>
            <hr>
        </div>
        <div>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOMBRE</th>
                        <th>APELLIDO</th>
                        <th>EMAIL</th>
                        <th>TELEFONO</th>
                         <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="dato" items="${datos}">
                    <tr>
                        <td>${dato.getId()}</td>
                        <td>${dato.getNombre()}</td>
                        <td>${dato.getApellido()}</td>
                        <td>${dato.getEmail()}</td>
                        <td>${dato.getTelefono()}</td>
                        <td>
                            <form action="Controlador" method="POST">
                                <input type="hidden" name="id" value="${dato.getId()}">
                                <input type="submit" name="accion" value="Editar">
                                <input type="submit" name="accion" value="Eliminar">
                            </form>
                        </td>
                    </tr>
                 </c:forEach>
                </tbody>
            </table>

        </div>
    </center>
    </body>
</html>
