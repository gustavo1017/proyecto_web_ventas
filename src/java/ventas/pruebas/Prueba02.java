/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.pruebas;

import ventas.entidades.Distrito;
import ventas.servicios.DistritoService;
import ventas.servicios.impl.DistritoServiceImpl;

/**
 *
 * @author Alumno
 */
public class Prueba02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // insertar un registro 
        DistritoService servicio = new DistritoServiceImpl();
        Distrito distrito = new Distrito("D99","Dis97","V03");
        servicio.grabar(distrito);
        
        for(Distrito d: servicio.listar()){
            System.out.print(d.getId()+"\t");
            System.out.print(d.getNombre()+"\t");
            System.out.println(d.getVendedor());
        }
    }
    
}
