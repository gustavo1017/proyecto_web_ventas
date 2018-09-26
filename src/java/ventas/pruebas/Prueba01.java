package ventas.pruebas;

import ventas.daos.DistritoDao;
import ventas.daos.impl.DistritoDaoImplCst;
import ventas.daos.impl.DistritoDaoImplPst;
import ventas.daos.impl.DistritoDaoImplStm;
import ventas.entidades.Distrito;

/**
 *
 * @author Alumno
 */
public class Prueba01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO Mostrar los datos de la tabla distrito.
        DistritoDao dao = new DistritoDaoImplPst();
        for(Distrito distrito:dao.findAll()){
            System.out.print(distrito.getId()+"\t");
            System.out.println(distrito.getNombre());
        }
    }
    
}
