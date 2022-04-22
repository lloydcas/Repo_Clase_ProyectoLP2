/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.lp2soft.config;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author CASTILLO RAMOS LLOYD ERWIN || 20142280
 */
public class DBManager {
    private static DBManager dbManager;
    private String url = "jdbc:mysql://database-lp2.coxaebd8y8cd.us-east-1.rds.amazonaws.com:3306/lp2";
    private String user = "admin";
    private String password = "lp220221";
    private Connection con;
    
    
    public Connection getConnection()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);            
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return con;
        
    }
    
    
    private synchronized static void createInstance()
    {
        if(dbManager == null)
            dbManager = new DBManager();
    }
    
    public static DBManager getInstance(){
        if(dbManager == null)
            createInstance();
        return dbManager;
    }
}
