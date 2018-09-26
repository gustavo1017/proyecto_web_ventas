<%@page import="ventas.entidades.Distrito"%>
<%@page import="java.util.List"%>
<%
    HttpSession websesion = request.getSession();
    if(websesion.getAttribute("nombre")==null){
        response.sendRedirect("error.jsp");
    }

    String sNombre = (String)websesion.getAttribute("nombre");
    String sApellido = (String)websesion.getAttribute("apellido");
    List<Distrito> milista = (List<Distrito>)websesion.getAttribute("lista");

%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Intranet de Ventas</title>
    </head>
    <body>
        <h1>Bienvenido  <%= sNombre %> <%= sApellido %>!!!!!!</h1>
        <a href="distritoMan.jsp">Mantenimiento de Distritos</a>
        
        
    </body>
</html>
