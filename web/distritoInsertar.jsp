<%@page import="ventas.entidades.Distrito"%>
<%
    HttpSession websesion = request.getSession();
    if(websesion.getAttribute("nombre")==null){
        response.sendRedirect("error.jsp");
    }

    String sNombre = (String)websesion.getAttribute("nombre");
    String sApellido = (String)websesion.getAttribute("apellido");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido  <%= sNombre %> <%= sApellido %>!!!!!!</title>
    </head>
    <body>
        <h1>Crear Distrito!</h1>
        <form action="distritoController">
            Codigo:<input name="txtCodigo"/><br/>
            Nombre<input name="txtNombre"/><br/>
            Vendedor:<input name="txtVendedor"/><br/>
            <input type="hidden" name="accion" value="insertar"/>
            <input type="submit" value="Grabar"/>
        </form>
        <a href="distritoMan.jsp">volver</a>
    </body>
</html>
