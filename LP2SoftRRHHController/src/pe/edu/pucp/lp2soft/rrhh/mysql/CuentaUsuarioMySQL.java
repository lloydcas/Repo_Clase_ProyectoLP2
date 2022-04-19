/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.lp2soft.rrhh.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import pe.edu.pucp.lp2soft.rrhh.dao.CuentasUsuarioDAO;
import pe.edu.pucp.lp2soft.rrhh.model.CuentaUsuario;

/**
 *
 * @author CASTILLO RAMOS LLOYD ERWIN || 20142280
 */
public class CuentaUsuarioMySQL implements CuentasUsuarioDAO{
    private Connection con;
    private Statement st;
    private ResultSet rs;

    @Override
    public int insertar(CuentaUsuario cuentaUsuario) {
        int resultado = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://database-lp2.coxaebd8y8cd.us-east-1.rds.amazonaws.com:3306/lp2",
                    "admin", "lp220221");
            //Ejecutar una instruccion en MySQL 
            st = con.createStatement();
            String sql = "INSERT INTO cuenta_usuario(username,password,activo) "
                    + "values('"+cuentaUsuario.getUsername()+"','"
                    +cuentaUsuario.getPassword()+"',1)";
            resultado = st.executeUpdate(sql);
            sql = "SELECT @@last_insert_id AS id";
            rs = st.executeQuery(sql);
            rs.next();
            cuentaUsuario.setIdCuentaUSuario(rs.getInt("id"));
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }
    
}
