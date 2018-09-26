/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ventas.daos.DistritoDao;
import ventas.entidades.Distrito;
import ventas.util.DbConection;

/**
 *
 * @author Alumno
 */
public class DistritoDaoImplPst implements DistritoDao{

    private Connection cn=null;
    private PreparedStatement pst;
    private ResultSet rs;
   
    @Override
    public List<Distrito> findAll() {
        List<Distrito> lista=new ArrayList<>();
        try{
            cn = DbConection.getInstance().getConnection();
            pst = cn.prepareStatement("select * from tb_distrito");
            rs = pst.executeQuery();
            while(rs.next()){
                lista.add(new Distrito(rs.getString(1),rs.getString(2),rs.getString(3)));
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
        return lista;
    }

    @Override
    public void create(Distrito distrito) {
        try{
            cn = DbConection.getInstance().getConnection();
            pst = cn.prepareStatement("insert into tb_distrito values (?,?,?)");
            pst.setString(1,distrito.getId());
            pst.setString(2,distrito.getNombre());
            pst.setString(3,distrito.getVendedor());
            int reg = pst.executeUpdate();
            System.out.println(" Registros insertado: " + reg);
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
    }

    @Override
    public Distrito find(String id) {
        Distrito distrito= null;
        try{
            cn = DbConection.getInstance().getConnection();
            pst = cn.prepareStatement("select * from tb_distrito where cod_dis=?");
            pst.setString(1,id);
            rs = pst.executeQuery();
            if(rs.next()){
                distrito = new Distrito(rs.getString(1),rs.getString(2),rs.getString(3));
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
        return distrito;
    }


    @Override
    public void update(Distrito distrito) {
        try{
            cn = DbConection.getInstance().getConnection();
            pst = cn.prepareStatement("update tb_distrito set nom_dis=?, cod_ven=? where cod_dis=?");
            int reg = pst.executeUpdate();
            pst.setString(3,distrito.getId());
            pst.setString(1,distrito.getNombre());
            pst.setString(2,distrito.getVendedor()); 
            System.out.println(" Registros actualizado: " + reg);
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
    }

    @Override
    public void delete(Distrito distrito) {
        try{
            cn = DbConection.getInstance().getConnection();
            pst = cn.prepareStatement("delete from tb_distrito where cod_dis=?");
            int reg = pst.executeUpdate();
              pst.setString(3,distrito.getId());
            System.out.println(" Registros eliminado: " + reg);
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
    }
    
}
