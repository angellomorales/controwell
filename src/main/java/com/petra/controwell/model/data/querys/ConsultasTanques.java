package com.petra.controwell.model.data.querys;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import com.petra.controwell.model.data.Tanques;
import com.petra.controwell.model.data.bdstruct.Consultas;

/**
 *
 * @author Angello Morales
 */
public class ConsultasTanques {

    public boolean agregarTanque(Tanques tks) throws SQLException {

        //creacion de variables para la consulta
        Consultas consultas = new Consultas();
        ArrayList arrayVar = new ArrayList();
        boolean estado = false;

        //consulta a realizar
        String query = "INSERT INTO tanques(idTanque, capacidad,tipoFluido) VALUES(?,?,?)";

        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
        arrayVar.add(tks.getIdTanque());
        arrayVar.add(tks.getCapacidad());
        arrayVar.add(tks.getTipoFluido());

        //ejecutar consulta y almacenar resultados en rs si se requiere
        estado = consultas.writeSQL(query, arrayVar);
        return estado;
    }

    public boolean eliminarTanque(Tanques tks) throws SQLException {

        //creacion de variables para la consulta
        Consultas consultas = new Consultas();
        ArrayList arrayVar = new ArrayList();
        boolean estado = false;

        //consulta a realizar
        String query = "DELETE FROM tanques WHERE idTanque=?";

        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
        arrayVar.add(tks.getIdTanque());

        //ejecutar consulta y almacenar resultados en rs si se requiere
        estado = consultas.writeSQL(query, arrayVar);
        return estado;
    }
    public ArrayList listarTanques() throws SQLException {

        //creacion de variables para la consulta
        Consultas consultas = new Consultas();
        ArrayList arrayVar = new ArrayList();
        ResultSet rs;
        ArrayList listado = new ArrayList();

        //consulta a realizar
        String query = "SELECT idTanque FROM tanques";

        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
        //ejecutar consulta y almacenar resultados en rs si se requiere
        rs = consultas.readSQL(query, arrayVar);

        //asignar resultados a setter de objeto
        try {
            if (rs != null) {
                //consulta exitosa
                listado.add(rs.getString("idTanque"));
                while (rs.next()) {
                    listado.add(rs.getString("idTanque"));
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
    
    public boolean modificarTanques(Tanques tks) throws SQLException {

        //creacion de variables para la consulta
        Consultas consultas = new Consultas();
        ArrayList arrayVar = new ArrayList();
        boolean estado = false;

        //consulta a realizar
        String query = "UPDATE tanques SET capacidad =?, tipoFluido=? WHERE idTanque=?";

        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
        arrayVar.add(tks.getCapacidad());
        arrayVar.add(tks.getTipoFluido());
        arrayVar.add(tks.getIdTanque());

        //ejecutar consulta y almacenar resultados en rs si se requiere
        estado = consultas.writeSQL(query, arrayVar);
        return estado;
    }
    public boolean buscarTanques(Tanques tks) throws SQLException {

        //creacion de variables para la consulta
        Consultas consultas = new Consultas();
        ArrayList arrayVar = new ArrayList();
        ResultSet rs;
        boolean estado = false;

        //consulta a realizar
        String query = "SELECT * FROM tanques WHERE idtanque=?";

        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
        arrayVar.add(tks.getIdTanque());

        //ejecutar consulta y almacenar resultados en rs si se requiere
        rs = consultas.readSQL(query, arrayVar);

        //asignar resultados a setter de objeto
        try {
            if (rs != null) {
                tks.setCapacidad(rs.getInt("capacidad"));
                tks.setTipoFluido(rs.getString("tipoFluido"));

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
}
