<%@page import="ventas.servicios.impl.DistritoServiceImpl"%>
<%@page import="ventas.servicios.DistritoService"%>
<%@page import="ventas.entidades.Distrito"%>
<%
    HttpSession websesion = request.getSession();
    if(websesion.getAttribute("nombre")==null){
        response.sendRedirect("error.jsp");
    }

    String sNombre = (String)websesion.getAttribute("nombre");
    String sApellido = (String)websesion.getAttribute("apellido");
    
    String disCodigo = request.getParameter("disId");
    
    DistritoService servicio = new DistritoServiceImpl();
    Distrito distrito = servicio.buscar(disCodigo);

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido  <%= sNombre %> <%= sApellido %>!!!!!!</title>
    </head>
    <body>
        <h1>Actualizar Distrito!</h1>
        <form action="distritoController">
           Codigo:<input name="txtCodigo" value="<%= distrito.getId() %>" readonly="true"/><br/>
            Nombre<input name="txtNombre" value="<%= distrito.getNombre()%>"/><br/>
            Vendedor:<input name="txtVendedor" value="<%= distrito.getVendedor() %>"/><br/>
            <input type="hidden" name="accion" value="actualizar"/>
            <input type="submit" value="Actualizar"/>
        </form>
        <a href="distritoMan.jsp">volver</a>
    </body>
</html>
