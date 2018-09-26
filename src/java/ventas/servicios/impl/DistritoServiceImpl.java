/*

 */
package ventas.servicios.impl;

import java.util.List;
import ventas.daos.DistritoDao;
import ventas.daos.impl.DaoFactory;
import ventas.entidades.Distrito;
import ventas.servicios.DistritoService;
import ventas.util.Util;

/**
 *
 * @author Emaravi
 */
public class DistritoServiceImpl implements DistritoService{
    private DistritoDao dao;
    public DistritoServiceImpl() {
        //dao = new DistritoDaoImplStm();
        dao = DaoFactory.getInstance().getDistritoDao(Util.opc);
    }
    
    @Override
    public void grabar(Distrito distrito) {
        dao.create(distrito);
    }

    @Override
    public Distrito buscar(String id) {
        return dao.find(id);
    }

    @Override
    public List<Distrito> listar() {
        return dao.findAll();
    }

    @Override
    public void actualizar(Distrito distrito) {
        dao.update(distrito);
    }

    @Override
    public void borrar(Distrito distrito) {
        dao.delete(distrito);
    }
    
}
