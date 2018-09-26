package ventas.daos.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import ventas.daos.VendedorDao;
import ventas.entidades.Vendedor;
import ventas.util.DbConection;

public class VendedorDaoImpl implements VendedorDao{
    private Connection cn=null;
    private CallableStatement cst;
    private ResultSet rs;
    
    @Override
    public Vendedor validar(String us, String ps) {
        Vendedor vendedor= null;
        try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_validar_vendedor(?,?)}");
            cst.setString(1,us);
            cst.setString(2,ps);
            rs = cst.executeQuery();
            if(rs.next()){
                vendedor = new Vendedor(rs.getString(1),
                                        rs.getString(2),
                                        rs.getString(3),
                                        rs.getDouble(4),
                                        rs.getString(5),
                                        rs.getString(6),
                                        rs.getString(7),
                                        rs.getString(8));
            }
            cn.close();
        }catch(SQLException ex){
            System.out.println("codigo : "+ex.getErrorCode());
            System.out.println("mensaje : "+ex.getMessage());
            System.out.println("estado : "+ex.getSQLState());
            try {
                cn.close();
                System.out.println("conexion cerrada en el catch");
            } catch (SQLException ex1) {
                System.out.println("No se pudo cerrar la conexion");
            }
        }
        return vendedor;
    }
    
}
