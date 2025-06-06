package Modelo.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexiondb {

    Connection conectar = null;

    String usuario = "root";
   //  String pass = "75000454jd";
    String pass = "180701";
    String bd = "sistemaIncidencias";
    String ip = "127.0.0.1";
    String puerto = "3306";

    String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd;

    public Connection establecerConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, pass);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se conecto a la BD correctamente" + e.toString());
        }
        return conectar;
    }

    public void cerrarConexion() {

        try {
            if (conectar != null && !conectar.isClosed()) {
                conectar.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo cerrar la Conexion");
        }

    }
}
