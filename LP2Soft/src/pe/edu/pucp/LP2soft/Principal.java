/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.LP2soft;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import pe.edu.pucp.lp2soft.almacen.model.Producto;
import pe.edu.pucp.lp2soft.gestionclientes.model.Categoria;
import pe.edu.pucp.lp2soft.gestionclientes.model.Cliente;
import pe.edu.pucp.lp2soft.rrhh.dao.AreaDAO;
import pe.edu.pucp.lp2soft.rrhh.dao.CuentasUsuarioDAO;
import pe.edu.pucp.lp2soft.rrhh.dao.EmpleadoDAO;
import pe.edu.pucp.lp2soft.rrhh.model.Area;
import pe.edu.pucp.lp2soft.rrhh.model.CuentaUsuario;
import pe.edu.pucp.lp2soft.rrhh.model.Empleado;
import pe.edu.pucp.lp2soft.rrhh.mysql.AreaMySQL;
import pe.edu.pucp.lp2soft.rrhh.mysql.CuentaUsuarioMySQL;
import pe.edu.pucp.lp2soft.rrhh.mysql.EmpleadoMySQL;
import pe.edu.pucp.lp2soft.ventas.model.LineaOrdenVenta;
import pe.edu.pucp.lp2soft.ventas.model.OrdenVenta;
/**
 *
 * @author CASTILLO RAMOS LLOYD ERWIN || 20142280
 */
public class Principal {
    public static void main(String[] args)throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        //Se crea la venta
        OrdenVenta venta1 = new OrdenVenta(1,sdf.parse("13-04-2022"));
        //Se crea un cliente
        Cliente cliente1 = 
        new Cliente(1,"28732829", "JUAN", "PEREZ", 'M',
            sdf.parse("01-01-1998"),3000.00,Categoria.Clasico);
        //Se crea un empleado
        Empleado empleado1 = 
                new Empleado(1, "72625210", "MARIA", "FERNANDEZ", 'F', 
                sdf.parse("15-08-1994"),"CAJERA",4000.00); 
        //Se asocia al empleado que registró la venta
        venta1.setEmpleado(empleado1);
        //Se asocia al cliente que efectuó la venta
        venta1.setCliente(cliente1);
        //Se crean productos   
        Producto prod1 = new Producto(1,"Coca cola","1L",3.00);
        Producto prod2 = new Producto(2,"Lavavajillas Sapolio","400 grs",7.50);
        //Se crean las lineas de la venta
        LineaOrdenVenta lov1 = new LineaOrdenVenta(prod1,3);
        LineaOrdenVenta lov2 = new LineaOrdenVenta(prod2,2);
        //Se asocian las lineas a la venta
        venta1.setLineasOrdenVentas(new ArrayList<>());
        venta1.getLineasOrdenVentas().add(lov1);
        venta1.getLineasOrdenVentas().add(lov2);
        //Se calculan los subtotales y el total
        venta1.calcularTotalySubtotales();
        //Se genera un reporte
        String reporte = venta1.devolverReporte();
        //Se imprime el reporte
        System.out.println(reporte);   
        
        //Creamos una cuenta de usuario
        CuentaUsuario cu1 = new CuentaUsuario("mfernandez","123456");
        //Creamos un dao de coneccion para gestionar cuentas;
        CuentasUsuarioDAO daoCuentaUsuario = new CuentaUsuarioMySQL();
        //Insertamos la cuenta de usuario
        int resultado = daoCuentaUsuario.insertar(cu1);
           if(resultado == 1)
            System.out.println("Se ha insertado correctamente la cuenta de usuario");
           else
            System.out.println("Ha ocurrido un error al momento de insertar la cuenta de usuario"); 
      
        //Creamos un area   
        Area area1 = new Area("VENTAS");
        AreaDAO daoArea = new AreaMySQL();
        resultado = daoArea.insertar(area1);
           if(resultado == 1)
            System.out.println("Se ha insertado correctamente el area");
           else
            System.out.println("Ha ocurrido un error al momento de insertar el area"); 
       
       //Asosciamos el area y la cuenta del usuario al empleado que quremos registrar;
       empleado1.setArea(area1);
       empleado1.setCuentaUsuario(cu1);
       
        EmpleadoDAO daoEmpleado = new EmpleadoMySQL();
        resultado = daoEmpleado.insertar(empleado1);
        
           if(resultado == 1)
            System.out.println("Se ha insertado correctamente el empleado");
           else
            System.out.println("Ha ocurrido un error al momento de insertar el empleado");         
    }
}
