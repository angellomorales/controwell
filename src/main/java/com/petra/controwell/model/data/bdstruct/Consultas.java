package com.petra.controwell.model.data.bdstruct;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

/**
 * Declaracion de la clase Consultas que hereda de la clase Conexion
 *
 * @author Angello Morales
 * @version 2/10/2019 Se utiliza para realizar consultas o registrar datos en
 * una BD
 */
public class Consultas extends Conexion {

    public final String TIPO_DOUBLE = "Double";
    public final String TIPO_INT = "Integer";
    public final String TIPO_STRING = "String";
    public final String TIPO_DATE = "Date";
    public final String TIPO_TIME = "Time";
    public final String TIPO_BOOLEAN = "Boolean";

    /**
     *
     * @param query String consulta de tipo "SELECT* FROM aforotk WHERE nivel=?
     * AND idTanque=?" unicamente
     * @param arrayVar arreglo donde se contiene las variable relacionadas al
     * caracter ? de la consulta, se debe relacionar a los metodos getter de la
     * tabla a consultar agregar en el mismo orden de la consulta
     * @return ResultSet con el resultado de la consulta que se asignara a los
     * metodos setter de la tabla
     * @throws SQLException
     */
    public ResultSet readSQL(String query, ArrayList arrayVar) throws SQLException {
        PreparedStatement sentencia;
        ResultSet rs;
        int conteo = 0;

        try {
            sentencia = conectar().prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

            //ajusta parametros relacionados al simbolo "?" agregar los diferentes tipos que
            //se requieran (char, short....etc)
            //sentencia.setDouble(posicionArraylist,variable del arraylist);// es la variable de la consulta con valor ?
            for (Object obj : arrayVar) {
                
//                if (obj == null) {
//                    break;
//                }
                
                switch (obj.getClass().getSimpleName()) {
                    case TIPO_DOUBLE:
                        sentencia.setDouble(conteo + 1, (double) arrayVar.get(conteo));
                        break;
                    case TIPO_INT:
                        sentencia.setInt(conteo + 1, (int) arrayVar.get(conteo));
                        break;
                    case TIPO_STRING:
                        sentencia.setString(conteo + 1, (String) arrayVar.get(conteo));
                        break;
                    case TIPO_DATE:
                        sentencia.setDate(conteo + 1, (Date) arrayVar.get(conteo));
                        break;
                    case TIPO_TIME:
                        sentencia.setTime(conteo + 1, (Time) arrayVar.get(conteo));
                        break;
                    case TIPO_BOOLEAN:
                        boolean vIn = (boolean) arrayVar.get(conteo);
                        byte vOut = (byte) (vIn ? 1 : 0);
                        sentencia.setByte(conteo + 1, vOut);
                        break;
                    default:
                        throw new AssertionError();
                }
                conteo++;
            }

            //ejecuta la consulta
            rs = sentencia.executeQuery();

            //trae la consulta 
            if (rs.next()) {               
                return rs;
            }

        } catch (SQLException e) {
            System.err.println("ERROR CONSULTAS " + e);
        }

        return null;
    }

    /**
     *
     * @param query String consulta de tipos "INSERT INTO
     * aforotk(nivel,barriles,idTanque) VALUES(?,?,?)"; "UPDATE producto SET
     * codigo=?,nombre=?,precio=?,cantidad=? WHERE id=?" "DELETE FROM producto
     * WHERE id=?";
     * @param arrayVar arreglo donde se contiene las variable relacionadas al
     * caracter ? de la consulta, se debe relacionar a los metodos getter de la
     * tabla a consultar agregar en el mismo orden de la consulta
     * @return true si la consulta es exitosa
     * @throws SQLException
     */
    public boolean writeSQL(String query, ArrayList arrayVar) throws SQLException {

        PreparedStatement sentencia;
        int conteo = 0;

        try {

            sentencia = conectar().prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

            //ajusta parametros relacionados al simbolo "?" agregar los diferentes tipos que
            //se requieran (char, short....etc)
            //sentencia.setDouble(posicionArraylist,variable del arraylist);// es la variable de la consulta con valor ?
            for (Object obj : arrayVar) {
                
//                if (obj == null) {
//                    break;
//                }
                
                switch (obj.getClass().getSimpleName()) {
                    case TIPO_DOUBLE:
                        sentencia.setDouble(conteo + 1, (double) arrayVar.get(conteo));
                        break;
                    case TIPO_INT:
                        sentencia.setInt(conteo + 1, (int) arrayVar.get(conteo));
                        break;
                    case TIPO_STRING:
                        sentencia.setString(conteo + 1, (String) arrayVar.get(conteo));
                        break;
                    case TIPO_DATE:
                        sentencia.setDate(conteo + 1, (Date) arrayVar.get(conteo));
                        break;
                    case TIPO_TIME:
                        sentencia.setTime(conteo + 1, (Time) arrayVar.get(conteo));
                        break;
                    case TIPO_BOOLEAN:
                        boolean vIn = (boolean) arrayVar.get(conteo);
                        byte vOut = (byte) (vIn ? 1 : 0);
                        sentencia.setByte(conteo + 1, vOut);
                        break;
                    default:
                        throw new AssertionError();
                }
                conteo++;
            }

            //Si se ejecuta un registro devuelve true
            if (sentencia.executeUpdate() == 1) {     
                return true;
            }
        } catch (SQLException e) {
            System.err.println("ERROR " + e);
        } finally {
            this.cerrarConexion();
        }

        return false;
    }

    public void cerrarConexion() throws SQLException {

        try {
            //Cierra conexion
            if (getConexion() != null) {
                getConexion().close();
                if (!getConexion().isClosed()) {
                    System.out.println("Conexion no esta Cerrada");
                }
            }
        } catch (SQLException e) {
            System.err.println("ERROR " + e);
        }
    }

}
