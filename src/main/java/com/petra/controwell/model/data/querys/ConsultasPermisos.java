package com.petra.controwell.model.data.querys;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import com.petra.controwell.model.data.Permisos;
import com.petra.controwell.model.data.bdstruct.Consultas;

/**
 *
 * @author Angello Morales
 */
public class ConsultasPermisos {

    public boolean buscarPermisos(Permisos wperm) throws SQLException {

        //creacion de variables para la consulta
        Consultas consultas = new Consultas();
        ArrayList arrayVar = new ArrayList();
        ResultSet rs;
        boolean estado = false;

        //consulta a realizar
        String query = "SELECT * FROM permisos WHERE idBoard=?";

        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
        arrayVar.add(wperm.getIdBoard());

        //ejecutar consulta y almacenar resultados en rs si se requiere
        rs = consultas.readSQL(query, arrayVar);

        //asignar resultados a setter de objeto
        try {
            if (rs != null) {
            	wperm.setFilePassword(rs.getString("filePassword"));
            	wperm.setTipo(rs.getString("tipo"));
            	wperm.setFechaActivacion(rs.getDate("fechaActivacion"));
            	wperm.setVigenciaDias(rs.getInt("vigenciaDias"));

                //consulta exitosa
                estado = true;
            } 
//            else {
//                JOptionPane.showMessageDialog(null, "No existe licencia");
//            }
            //para consultas que tienen rs se debe cerrar la conexion en cada 
            //funcion
            consultas.cerrarConexion();
        } catch (SQLException e) {
            System.err.println("ERROR " + e);
        }

        return estado;
    }

}
