package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection conexion;
    String url= "jdbc:oracle:thin:@localhost:1521:orcl";
    String user="jona";
    String pasword = "12345";
    
    public Connection conectar(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexion = DriverManager.getConnection(url, user, pasword);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return conexion;
    }
    
}
