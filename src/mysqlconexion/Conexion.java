package mysqlconexion;
import java.sql.*;

public class Conexion{
    public Connection conex;
    
    public Connection conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conex = DriverManager.getConnection("jdbc:mysql://localhost/ConexionCorba","root","");
            System.out.println("ConexionEstablecida.");
            
        } catch (Exception e) {
        }
        return conex;
    }
}
