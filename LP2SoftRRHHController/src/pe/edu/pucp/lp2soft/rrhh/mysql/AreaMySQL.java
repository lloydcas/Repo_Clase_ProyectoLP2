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
import java.util.ArrayList;
import pe.edu.pucp.lp2soft.rrhh.dao.AreaDAO;
import pe.edu.pucp.lp2soft.rrhh.model.Area;

/**
 *
 * @author CASTILLO RAMOS LLOYD ERWIN || 20142280
 */
public class AreaMySQL implements AreaDAO{
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;

    @Override
    public ArrayList<Area> listarTodas() {
        //Devolvera una lista de areas
        ArrayList<Area>areas = new ArrayList<>();
        try
        {   
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://database-lp2.coxaebd8y8cd.us-east-1.rds.amazonaws.com:3306/lp2",
                    "admin", "lp220221");
            st = con.createStatement();
            String sql = "SELECT*FROM area WHERE activo = 1";
            rs = st.executeQuery(sql);
            while(rs.next())
            {
               
                Area area = new Area();
                area.setIdArea(rs.getInt("id_area"));
                area.setNombre(rs.getString("nombre"));
                area.setActivo(true);
                areas.add(area);
            }
            
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally
        {
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
          return areas;
    }

    /*@Override
    public int insertar(Area area) {
        int resultado = 0;
        try{
            //Registramos el Driver de conneccion
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://database-lp2.coxaebd8y8cd.us-east-1.rds.amazonaws.com:3306/lp2",
                    "admin", "lp220221");
            //Ejecutar una instruccion en MySQL
            String sql = "INSERT INTO area(nombre,activo) "+
                         "VALUES('"+area.getNombre()+"',1)";
            //Creamos un objecto statement
            st = con.createStatement();
            //Ejecutamos la instruccion SQL rn la base de datos
            resultado = st.executeUpdate(sql);
            //Capturamos el id generado por la base de datos
            sql = "SELECT @@last_insert_id as id";
            rs = st.executeQuery(sql);
            rs.next();
            area.setIdArea(rs.getInt("id"));
            
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
        
    }*/

    
   public int insertar(Area area) {
        int resultado = 0;
        try{
            //Registramos el Driver de conneccion
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://database-lp2.coxaebd8y8cd.us-east-1.rds.amazonaws.com:3306/lp2",
                    "admin", "lp220221");
                    
            String sql = "INSERT INTO area(nombre, activo) VALUES (?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, area.getNombre());
            ps.setBoolean(2, true);
            resultado = ps.executeUpdate();
            sql = "SELECT @@last_insert_id as id";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            area.setIdArea(rs.getInt("id"));
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }
    
    
    
    @Override
    public int modificar(Area area) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(int idArea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Area listarPorId(int idArea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
