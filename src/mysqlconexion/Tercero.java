/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqlconexion;
import Terceros.*;
import java.sql.*;
import javax.swing.JOptionPane;



public class Tercero extends TerceroPOA {
  Conexion obConexion = new Conexion();

    @Override
    public boolean insertarTercero(String nombre, String apellido, String telefono) {
       boolean resultado = false;
        try {
           String sql="insert into terceros (nombres,apellidos,telefono) values('"+nombre+"','"+apellido+"','"+telefono+"')"; 
           obConexion.conectar();
           Statement st = obConexion.conex.createStatement();
           int valor = st.executeUpdate(sql);
            if (valor>0) {
             resultado = true;
             
            }
            //cerrar las conexiones 
            obConexion.conex.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ocurrio un error al insertar "+e.getMessage());
        }
       
       
       return resultado;

    }

    @Override
    public boolean actualizarTercero(int id, String nombre, String apellido, String telefono) {
         boolean resultado = false;
        try {
            String sql="update terceros set nombres = '"+nombre+"','"+apellido+"','"+telefono+"' where id = '"+id+"' ";
            Statement st= obConexion.conex.createStatement();
            int valor = st.executeUpdate(sql);
            if (valor>0) {
                resultado = true;
            }
            
            obConexion.conex.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ocurrio un error al actualizar "+e.getMessage());
        }
       
       
       return resultado;
        
        
    }

    @Override
    public boolean eliminarTercero(int id) {
         boolean resultado = false;
        try {
            String sql = "delete from terceros where id = "+id;
            Statement st= obConexion.conex.createStatement();
            int valor = st.executeUpdate(sql);
            if (valor>0) {
                resultado = true;
            }
            
            obConexion.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ocurrio un error al eliminar "+e.getMessage());
        }
       
       
       return resultado;
    }

    @Override
    public String consultarTercero(int id) {
        String resultado ="";
        try {
            String sqlConsultar = "select*from terceros id = "+id;
            obConexion.conectar();
            Statement st = obConexion.conex.createStatement();
            ResultSet rs  = st.executeQuery(sqlConsultar);
            while (rs.next()) {
               resultado += rs.getString(2)+"-"
               +rs.getString(3)+"-"
               +rs.getString(4);
                
            }
            
            rs.close(); // resultado de la consultad del Query
            obConexion.conex.close();
            
            
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
        }
        return resultado;
    }

    @Override
    public void shoutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // creado un metodo propio
    public ResultSet cargarTercero(){
       ResultSet resultado = null;
        try {
            String sql = "Select Nombres, Apellidos, Telefono from Terceros";
            obConexion.conectar(); // abrimos la conexion
            Statement st = obConexion.conex.createStatement();//encargado de la consulta
            resultado = st.executeQuery(sql);
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
        }
       return resultado;
    }
  
}
