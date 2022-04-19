/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.lp2soft.rrhh.model;

import java.util.Date;

/**
 *
 * @author CASTILLO RAMOS LLOYD ERWIN || 20142280
 */
public class Empleado extends Persona{
    private String cargo;
    private double sueldo;
    private boolean activo;
    private CuentaUsuario cuentaUsuario;
    private Area area;

    public Empleado(int idPersona, String DNI, String nombre, 
           String apellidoPaterno, char genero, Date fechaNacimiento,
           String cargo, double sueldo, boolean activo, CuentaUsuario cuentaUsuario, Area area) {
        super(idPersona, DNI, nombre, apellidoPaterno, genero, fechaNacimiento);
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.activo = activo;
        this.cuentaUsuario = cuentaUsuario;
        this.area = area;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public CuentaUsuario getCuentaUsuario() {
        return cuentaUsuario;
    }

    public void setCuentaUsuario(CuentaUsuario cuentaUsuario) {
        this.cuentaUsuario = cuentaUsuario;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
    
    
}
