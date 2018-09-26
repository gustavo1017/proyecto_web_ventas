/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.daos.impl;

import ventas.daos.DistritoDao;
import static ventas.util.Util.STM;
import static ventas.util.Util.PST;
import static ventas.util.Util.CST;
/**
 *
 * @author Alumno
 */
public class DaoFactory {
    
    private DaoFactory() {
    }
    
    public static DaoFactory getInstance() {
        return DaoFactoryHolder.INSTANCE;
    }
    
    private static class DaoFactoryHolder {

        private static final DaoFactory INSTANCE = new DaoFactory();
    }
    
    public DistritoDao getDistritoDao(int tipo){
        switch(tipo){
            case STM: return new DistritoDaoImplStm();
            case PST: return new DistritoDaoImplPst();
            case CST: return new DistritoDaoImplCst();
            default:return null;
        }
    }
    
}
