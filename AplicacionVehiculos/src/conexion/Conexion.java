
package conexion;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Conexion {
    
    Connection con = null;
    Statement st = null;
    
    public Conexion(){
        try{
            String rutafile = "./dbVehiculos.accdb";
            String Url= "jdbc:ucanaccess://" + rutafile;
            con = DriverManager.getConnection(Url);
            st = con.createStatement();
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Conexión erronea: " + e);
        }
    }
    
    public Connection getConnection(){
        return con;
    }
    
    public void Desconexion(){
        try {
            con.close();
            System.exit(0);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
