package com.petra.controwell.model.data.bdstruct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.petra.controwell.model.data.conf.Proper;

/**
 * Declaracion de la clase Conexion se utiliza para realizar la conexion a una
 * base de de datos
 *
 * @author Angello Morales
 * @version 27/07/2018
 */
public class Conexion {

    //Variable para extraer la informacion del archivo conf.properties
    private final Proper propiedad = new Proper();
    
    //Variables para conectar a la BD modificar segun la BD
    private final String USERNAME = "root";
    private final String PASSWORD = "Controwell.2020";

    //ubicacion de la BD lectura del archivo conf.properties 
    private final String HOST = propiedad.getProp().getProperty("server.HOST");
    private final String PORT = propiedad.getProp().getProperty("server.PORT");

    //Nombre de la base de datos
    private final String DATABASE = propiedad.getProp().getProperty("server.DATABASE");
// deprecate    private final String CLASSNAME = "com.mysql.jdbc.Driver";     //Alternativo org.gjt.mm.mysql.Driver
    private final String CLASSNAME = "com.mysql.cj.jdbc.Driver";

    //Cadena de conexion
    //private final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
	private final String URL = String.format(
			"jdbc:mysql://%s:%s/%s?useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=EST", HOST, PORT, DATABASE);//serverTimezone=UTC;CST;EST;GMT
    
    //objeto conexion
    private Connection conexion = null;

    public Connection conectar() {
        try {

            // ejecutar DRIVER MSQL para crear conexion
            Class.forName(CLASSNAME);

            //establecer conexion
            conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            if (conexion == null) {
                System.out.println("error de conexion");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("ERROR " + e);
        }
        return conexion;
    }

    public Connection getConexion() {
        return conexion;
    }

}
