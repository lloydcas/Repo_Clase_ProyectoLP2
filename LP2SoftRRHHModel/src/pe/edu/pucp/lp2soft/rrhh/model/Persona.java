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
public class Persona {
    private int idPersona;
    private String DNI;
    private String nombre;
    private String apellidoPaterno;
    private char genero;
    private Date fechaNacimiento;

    public Persona() {
    }

    public Persona(int idPersona, String DNI, String nombre, String apellidoPaterno, char genero, Date fechaNacimiento) {
        this.idPersona = idPersona;
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
}
