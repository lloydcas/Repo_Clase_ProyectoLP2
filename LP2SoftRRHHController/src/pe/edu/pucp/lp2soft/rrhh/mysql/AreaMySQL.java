/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.lp2soft.rrhh.mysql;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import pe.edu.pucp.lp2soft.config.DBManager;
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
    private CallableStatement cs;

    @Override
    public ArrayList<Area> listarTodas() {
        //Devolvera una lista de areas
        ArrayList<Area>areas = new ArrayList<>();
        try
        {   
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_AREAS_TODAS()}");
            rs = cs.executeQuery();
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

    
   /*@Override
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
*/
   @Override
   public int insertar(Area area){
       int resultado = 0;
       try{
           con = DBManager.getInstance().getConnection();
           cs = con.prepareCall("{call INSERTAR_AREA(?,?)}");
           cs.registerOutParameter("_id_area",java.sql.Types.INTEGER);//Si es una salida de dato OUT
           cs.setString("_nombre",area.getNombre());//Si es un ingreso de dato IN
           cs.executeUpdate();
           area.setIdArea(cs.getInt("_id_area"));
           resultado = 1;
       }catch(Exception ex){
           System.out.println(ex.getMessage());
           
       }finally{
           try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
       }
       return resultado;
   }
    
    
    @Override
    public int modificar(Area area) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_AREA(?,?)}");
            cs.setInt("_id_area", area.getIdArea());
            cs.setString("_nombre",area.getNombre());
            cs.executeUpdate();
            resultado = 1;    
        }catch(Exception ex){
           System.out.println(ex.getMessage());            
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());} 
        }
        return resultado;
    }

    @Override
    public int eliminar(int idArea) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_AREA(?)}");
            cs.setInt("_id_area", idArea);
            cs.executeUpdate();
            resultado = 1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
       return resultado;     
    }

    @Override
    public Area listarPorId(int idArea) {
        Area area = null;
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call BUSCAR_AREA_POR_ID(?)}");
            cs.setInt("_id_area", idArea);
            rs = cs.executeQuery();
            if(rs.next()){
                area = new Area();
                area.setIdArea(idArea);
                area.setNombre(rs.getString("nombre"));
                area.setActivo(true);
            }
            resultado = 1;
            
        }catch(Exception ex){
            
        }finally{
            
        }
        return area;
    }
    
}
