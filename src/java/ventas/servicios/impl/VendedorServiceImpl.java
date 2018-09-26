package ventas.servicios.impl;

import ventas.daos.VendedorDao;
import ventas.daos.impl.VendedorDaoImpl;
import ventas.entidades.Vendedor;
import ventas.servicios.VendedorService;


public class VendedorServiceImpl implements VendedorService{

    private VendedorDao dao;
    
    public VendedorServiceImpl() {
        dao = new VendedorDaoImpl();
    }
    
    @Override
    public Vendedor ingresar(String usu, String pas) {
        return dao.validar(usu, pas);
    }
    
}
