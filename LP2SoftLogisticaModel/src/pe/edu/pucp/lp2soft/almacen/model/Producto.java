/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.lp2soft.almacen.model;

import java.util.ArrayList;
import pe.edu.pucp.lp2soft.ventas.model.OrdenVenta;

/**
 *
 * @author CASTILLO RAMOS LLOYD ERWIN || 20142280
 */
public class Producto {
    private int idProducto;
    private String nombre;
    private String unidadMedida;
    private double precio;
    private boolean  activo;
    private ArrayList<OrdenVenta>ordenesVenta;

    public Producto(int idProducto, String nombre, String unidadMedida, double precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public ArrayList<OrdenVenta> getOrdenesVenta() {
        return ordenesVenta;
    }

    public void setOrdenesVenta(ArrayList<OrdenVenta> ordenesVenta) {
        this.ordenesVenta = ordenesVenta;
    }
    
    
}
