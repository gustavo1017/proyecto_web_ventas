/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ventas.entidades.Distrito;
import ventas.servicios.DistritoService;
import ventas.servicios.impl.DistritoServiceImpl;

/**
 *
 * @author Emaravi
 */
@WebServlet(name = "DistritoServlet", urlPatterns = {"/distritoController"})
public class DistritoServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id=request.getParameter("txtCodigo");
        String nombre=request.getParameter("txtNombre");
        String vendedor=request.getParameter("txtVendedor");
        String accion=request.getParameter("accion");
        
        DistritoService servicio = new DistritoServiceImpl();
        
        switch(accion){
            case "insertar":{
                servicio.grabar(new Distrito(id, nombre, vendedor));
                break;
            }
            case "eliminar":{
                servicio.borrar(new Distrito(id, nombre, vendedor));
                break;
            }
            case "actualizar":{
                servicio.actualizar(new Distrito(id, nombre, vendedor));
                break;
            }
            default:{
                
            }
        }
        response.sendRedirect("distritoMan.jsp");
        
    }

    
}
