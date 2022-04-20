/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.lp2soft.rrhh.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import pe.edu.pucp.lp2soft.rrhh.dao.EmpleadoDAO;
import pe.edu.pucp.lp2soft.rrhh.model.Empleado;

/**
 *
 * @author CASTILLO RAMOS LLOYD ERWIN || 20142280
 */
public class EmpleadoMySQL implements EmpleadoDAO{
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    /*@Override
    public int insertar(Empleado empleado) {
        int resultado = 0;
        try{
            //Registramos el Driver de conneccion
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://database-lp2.coxaebd8y8cd.us-east-1.rds.amazonaws.com:3306/lp2",
                    "admin", "lp220221");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //Ejecutar una instruccion en MySQL
            String sql = "INSERT INTO persona(DNI,nombre,apellido_paterno,genero,fecha_nacimiento) "
                    + "VALUES ('"+empleado.getDNI()+"','"+empleado.getNombre()+"',"
                    + "'"+empleado.getApellidoPaterno()+"','"+empleado.getGenero()+"',"
                    + "'"+sdf.format(empleado.getFechaNacimiento())+"')";
            st = con.createStatement();
            st.executeUpdate(sql);
            sql = "SELECT @@last_insert_id as id";
            rs = st.executeQuery(sql);
            rs.next();
            //Ejecutar una instrucción para los datos propios del empleado
            sql = "INSERT INTO empleado(id_empleado,fid_area,fid_cuenta_usuario,cargo,sueldo,activo) "
                    + "values("+empleado.getIdPersona()+","
                    + empleado.getArea().getIdArea() + "," + empleado.getCuentaUsuario().getIdCuentaUSuario() + ","
                    + "'" + empleado.getCargo() + "'," + empleado.getSueldo()
                    +",1)";
            
            resultado = st.executeUpdate(sql);
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }finally
        {
         try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}   
        }
        return resultado;
    }*/
    
    @Override
    public int insertar(Empleado empleado){
        int resultado = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://database-lp2.coxaebd8y8cd.us-east-1.rds.amazonaws.com:3306/lp2",
                    "admin", "lp220221");
            String sql = "INSERT INTO persona(DNI,nombre,"
                    + "apellido_paterno,genero,fecha_nacimiento) "
                    + "VALUES(?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, empleado.getDNI());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getApellidoPaterno());
            ps.setString(4, String.valueOf(empleado.getGenero()));
            ps.setDate(5, new java.sql.Date(
                    empleado.getFechaNacimiento().getTime()));
            ps.executeUpdate();
            sql = "SELECT @@last_insert_id as id";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            empleado.setIdPersona(rs.getInt("id"));
            sql = "INSERT INTO empleado(id_empleado,fid_area,"
                    + "fid_cuenta_usuario,cargo,sueldo,activo) "
                    + "VALUES(?,?,?,?,?,?);";
            ps = con.prepareStatement(sql);
            ps.setInt(1, empleado.getIdPersona());
            ps.setInt(2, empleado.getArea().getIdArea());
            ps.setInt(3, empleado.getCuentaUsuario().getIdCuentaUSuario());
            ps.setString(4, empleado.getCargo());
            ps.setDouble(5, empleado.getSueldo());
            ps.setBoolean(6, true);
            resultado = ps.executeUpdate();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }
}
