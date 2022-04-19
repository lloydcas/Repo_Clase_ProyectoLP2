/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.lp2soft.ventas.model;

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
    
}
