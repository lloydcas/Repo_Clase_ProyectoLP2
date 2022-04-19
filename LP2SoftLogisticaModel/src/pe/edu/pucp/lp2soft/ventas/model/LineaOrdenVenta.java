/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.lp2soft.ventas.model;

import pe.edu.pucp.lp2soft.almacen.model.Producto;

/**
 *
 * @author CASTILLO RAMOS LLOYD ERWIN || 20142280
 */
public class LineaOrdenVenta {
    private int idOrdenVenta;
    private int cantidad;
    private double subtotal;
    private boolean  activo;
    private Producto producto;

    public LineaOrdenVenta(Producto producto,int cantidad) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getIdOrdenVenta() {
        return idOrdenVenta;
    }

    public void setIdOrdenVenta(int idOrdenVenta) {
        this.idOrdenVenta = idOrdenVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
     public double calcularSubtotal(){
        subtotal = cantidad * producto.getPrecio();
        return subtotal;
    }
    
    public String imprimirLinea(){
        return producto.getNombre() + " " + producto.getUnidadMedida() + " - "+
                "S/. " + producto.getPrecio() + " x " + cantidad + " unid. - S/." + 
                subtotal;
    }   
    
    
}
