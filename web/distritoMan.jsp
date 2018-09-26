<%@page import="ventas.servicios.impl.DistritoServiceImpl"%>
<%@page import="ventas.servicios.DistritoService"%>
<%@page import="ventas.entidades.Distrito"%>
<%@page import="java.util.List"%>
<%
    HttpSession websesion = request.getSession();
    if(websesion.getAttribute("nombre")==null){
        response.sendRedirect("error.jsp");
    }

    String sNombre = (String)websesion.getAttribute("nombre");
    String sApellido = (String)websesion.getAttribute("apellido");
   // List<Distrito> milista = (List<Distrito>)websesion.getAttribute("lista");
   DistritoService servicio = new DistritoServiceImpl();
   List<Distrito> milista = servicio.listar();
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido  <%= sNombre %> <%= sApellido %>!!!!!!</title>
    </head>
    <body>
        <h1>Mantenimiento de Distritos</h1>
        <a href="distritoInsertar.jsp">Nuevo Distrito</a>
        <table border="1">
            <tr>
                <th>id</th>
                <th>nombre</th>
                <th>id de vendedor</th>
                <th>Eliminar</th>
                <th>Actualizar</th>
            </tr>
            <%for(Distrito d:milista){%>
            <tr>
                <td><%= d.getId() %></td>
                <td><%= d.getNombre()%></td>
                <td><%= d.getVendedor()%></td>
                <td><a href="distritoEliminar.jsp?disId=<%= d.getId() %>">X</a></td>
                <td><a href="distritoActualizar.jsp?disId=<%= d.getId() %>">A</a></td>
            </tr>
            <%}%>
        </table>
        
        
    </body>
</html>