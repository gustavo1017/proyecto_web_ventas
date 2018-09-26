package ventas.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ventas.entidades.Vendedor;
import ventas.servicios.DistritoService;
import ventas.servicios.VendedorService;
import ventas.servicios.impl.DistritoServiceImpl;
import ventas.servicios.impl.VendedorServiceImpl;

/**
 *
 * @author Emaravi
 */
@WebServlet(name = "VendedorServlet", urlPatterns = {"/vendedorController"})
public class VendedorServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String sUsuario = request.getParameter("txtUsuario");
        String sPassword =request.getParameter("txtPassword");
        
        VendedorService servicio = new VendedorServiceImpl();
        Vendedor vendedor = servicio.ingresar(sUsuario, sPassword);
        
        DistritoService serviciod = new DistritoServiceImpl();
        
        HttpSession sesion = request.getSession();
        
        if(vendedor!=null){
            sesion.setAttribute("nombre",vendedor.getNombre());
            sesion.setAttribute("apellido",vendedor.getApellido());
            sesion.setAttribute("lista", serviciod.listar());
            response.sendRedirect("principal.jsp");
        }else{
            response.sendRedirect("error.jsp");
        }
        
    }

 

}
