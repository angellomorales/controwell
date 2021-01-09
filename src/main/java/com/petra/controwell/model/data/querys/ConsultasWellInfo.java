package com.petra.controwell.model.data.querys;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import com.petra.controwell.model.data.WellInfo;
import com.petra.controwell.model.data.bdstruct.Consultas;

/**
 *
 * @author Angello Morales
 */
public class ConsultasWellInfo {

    public boolean buscarPozos(WellInfo winf) throws SQLException {

        //creacion de variables para la consulta
        Consultas consultas = new Consultas();
        ArrayList arrayVar = new ArrayList();
        ResultSet rs;
        boolean estado = false;

        //consulta a realizar
        String query = "SELECT * FROM wellinfo WHERE idPozo=?";

        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
        arrayVar.add(winf.getIdPozo());

        //ejecutar consulta y almacenar resultados en rs si se requiere
        rs = consultas.readSQL(query, arrayVar);

        //asignar resultados a setter de objeto
        try {
            if (rs != null) {
                winf.setOperadora(rs.getString("operadora"));
                winf.setUbicacion(rs.getString("ubicacion"));
                winf.setComentarios(rs.getString("comentarios"));

                //consulta exitosa
                estado = true;
            } else {
                JOptionPane.showMessageDialog(null, "No hay datos relacionados");
            }
            //para consultas que tienen rs se debe cerrar la conexion en cada 
            //funcion
            consultas.cerrarConexion();
        } catch (SQLException e) {
            System.err.println("ERROR " + e);
        }

        return estado;
    }

    public boolean agregarPozo(WellInfo winf) throws SQLException {

        //creacion de variables para la consulta
        Consultas consultas = new Consultas();
        ArrayList arrayVar = new ArrayList();
        boolean estado = false;

        //consulta a realizar
        String query = "INSERT INTO wellinfo(idPozo, ubicacion, operadora, comentarios) VALUES(?,?,?,?)";

        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
        arrayVar.add(winf.getIdPozo());
        arrayVar.add(winf.getUbicacion());
        arrayVar.add(winf.getOperadora());
        arrayVar.add(winf.getComentarios());

        //ejecutar consulta y almacenar resultados en rs si se requiere
        estado = consultas.writeSQL(query, arrayVar);
        return estado;
    }

    public boolean modificarPozo(WellInfo winf) throws SQLException {

        //creacion de variables para la consulta
        Consultas consultas = new Consultas();
        ArrayList arrayVar = new ArrayList();
        boolean estado = false;

        //consulta a realizar
        String query = "UPDATE wellinfo SET ubicacion=?,operadora =?,comentarios =? WHERE idPozo=?";

        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
        arrayVar.add(winf.getUbicacion());
        arrayVar.add(winf.getOperadora());
        arrayVar.add(winf.getComentarios());
        arrayVar.add(winf.getIdPozo());

        //ejecutar consulta y almacenar resultados en rs si se requiere
        estado = consultas.writeSQL(query, arrayVar);
        return estado;
    }

    public boolean eliminarPozo(WellInfo winf) throws SQLException {

        //creacion de variables para la consulta
        Consultas consultas = new Consultas();
        ArrayList arrayVar = new ArrayList();
        boolean estado = false;

        //consulta a realizar
        String query = "DELETE FROM wellinfo WHERE idPozo=?";

        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
        arrayVar.add(winf.getIdPozo());

        //ejecutar consulta y almacenar resultados en rs si se requiere
        estado = consultas.writeSQL(query, arrayVar);
        return estado;
    }

    public ArrayList listarPozos() throws SQLException {

        //creacion de variables para la consulta
        Consultas consultas = new Consultas();
        ArrayList arrayVar = new ArrayList();
        ResultSet rs;
        ArrayList listado = new ArrayList();

        //consulta a realizar
        String query = "SELECT idPozo FROM wellinfo";

        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
        //ejecutar consulta y almacenar resultados en rs si se requiere
        rs = consultas.readSQL(query, arrayVar);

        //asignar resultados a setter de objeto
        try {
            if (rs != null) {
                //consulta exitosa
                listado.add(rs.getString("idPozo"));
                while (rs.next()) {
                    listado.add(rs.getString("idPozo"));
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay datos relacionados");
            }
            //para consultas que tienen rs se debe cerrar la conexion en cada 
            //funcion
            consultas.cerrarConexion();
        } catch (SQLException e) {
            System.err.println("ERROR " + e);
        }

        return listado;
    }

}
