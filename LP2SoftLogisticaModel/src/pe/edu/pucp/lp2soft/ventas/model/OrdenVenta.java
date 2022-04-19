/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.lp2soft.ventas.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.lp2soft.gestionclientes.model.Cliente;
import pe.edu.pucp.lp2soft.rrhh.model.Empleado;

/**
 *
 * @author CASTILLO RAMOS LLOYD ERWIN || 20142280
 */
public class OrdenVenta {
    private int idOrdenVenta;
    private double total;
    private Date fechaHora;
    private boolean activo;
    private Empleado empleado;
    private Cliente cliente;
    private ArrayList<LineaOrdenVenta>lineasOrdenVentas;

    public OrdenVenta(int idOrdenVenta, Date fechaHora) {
        this.idOrdenVenta = idOrdenVenta;
        this.fechaHora = fechaHora;
    }

    public int getIdOrdenVenta() {
        return idOrdenVenta;
    }

    public void setIdOrdenVenta(int idOrdenVenta) {
        this.idOrdenVenta = idOrdenVenta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<LineaOrdenVenta> getLineasOrdenVentas() {
        return lineasOrdenVentas;
    }

    public void setLineasOrdenVentas(ArrayList<LineaOrdenVenta> lineasOrdenVentas) {
        this.lineasOrdenVentas = lineasOrdenVentas;
    }
    public void calcularTotalySubtotales(){
        this.total = 0;
        for(LineaOrdenVenta lov : lineasOrdenVentas){
            total = total + lov.calcularSubtotal();
        }
    }
    
    public String devolverReporte(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String reporte = "";
        reporte = reporte + "Orden Venta N°. " + idOrdenVenta + "\n";
        reporte = reporte + "Fecha de Venta: " + sdf.format(fechaHora) + "\n";
        reporte = reporte + "---------------------------------------------------------" + "\n";
        reporte = reporte + "Cliente: " + cliente.getDNI() + " - " + cliente.getNombre() + 
                " " + cliente.getApellidoPaterno() + "\n";
        reporte = reporte + "Empleado: " + empleado.getDNI() + " - " + empleado.getNombre() +
                " " + empleado.getApellidoPaterno() + "\n";
        reporte = reporte + "---------------------------------------------------------" + "\n";
        for(LineaOrdenVenta lov : lineasOrdenVentas){
            reporte = reporte + lov.imprimirLinea() + "\n";
        }
        reporte = reporte + "---------------------------------------------------------" + "\n";
        reporte = reporte + "TOTAL: S/. " + total;
        return reporte;
    }    
}
