/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.lp2soft.rrhh.model;

/**
 *
 * @author CASTILLO RAMOS LLOYD ERWIN || 20142280
 */
public class CuentaUsuario {
    private int idCuentaUSuario;
    private String username;
    private String password;
    private boolean activo;
    private Empleado empleado;

    public CuentaUsuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getIdCuentaUSuario() {
        return idCuentaUSuario;
    }

    public void setIdCuentaUSuario(int idCuentaUSuario) {
        this.idCuentaUSuario = idCuentaUSuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    
    
}
