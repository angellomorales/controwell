package com.petra.controwell.model.data.querys;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import com.petra.controwell.model.data.AforoTk;
import com.petra.controwell.model.data.bdstruct.Consultas;

/**
 *
 * @author Angello Morales
 */
public class ConsultasAforoTk {

    public double buscarVolumenAforo(AforoTk aftk) throws SQLException {

        //creacion de variables para la consulta
        Consultas consultas = new Consultas();
        ArrayList arrayVar = new ArrayList();
        ResultSet rs;
        double valor = 0;

        //consulta a realizar
        String query = "SELECT volumen FROM aforotk WHERE nivel=? AND idTanque=?";

        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
        arrayVar.add(aftk.getNivel());
        arrayVar.add(aftk.getIdTanque());

        //ejecutar consulta y almacenar resultados en rs si se requiere
        rs = consultas.readSQL(query, arrayVar);

        //asignar resultados a setter de objeto
        try {
            if (rs != null) {

                //consulta exitosa
                valor = rs.getDouble("volumen");
            }
            //para consultas que tienen rs se debe cerrar la conexion en cada 
            //funcion
            consultas.cerrarConexion();
        } catch (SQLException e) {
            System.err.println("ERROR " + e);
        }
        return valor;
    }

    public double buscarIncrementoAforo(AforoTk aftk) throws SQLException {

        //creacion de variables para la consulta
        Consultas consultas = new Consultas();
        ArrayList arrayVar = new ArrayList();
        ResultSet rs;
        double valor = 0;

        //consulta a realizar
        String query = "SELECT incremento FROM aforotk WHERE nivel=? AND idTanque=?";

        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
        arrayVar.add(aftk.getNivel() + 1);
        arrayVar.add(aftk.getIdTanque());

        //ejecutar consulta y almacenar resultados en rs si se requiere
        rs = consultas.readSQL(query, arrayVar);

        //asignar resultados a setter de objeto
        try {
            if (rs != null) {

                //consulta exitosa
                valor = rs.getDouble("incremento");
            }
            //para consultas que tienen rs se debe cerrar la conexion en cada 
            //funcion
            consultas.cerrarConexion();
        } catch (SQLException e) {
            System.err.println("ERROR " + e);
        }

        return valor;
    }

    public boolean almacenarAforoTanque(AforoTk aftk) throws SQLException {

        //creacion de variables para la consulta
        Consultas consultas = new Consultas();
        ArrayList arrayVar = new ArrayList();
        boolean estado = false;

        //consulta a realizar
        String query = "INSERT INTO aforotk(nivel,volumen,incremento,idTanque,temperaturaBase,material) VALUES(?,?,?,?,?,?)";

        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
        arrayVar.add(aftk.getNivel());
        arrayVar.add(aftk.getVolumen());
        arrayVar.add(aftk.getIncremento());
        arrayVar.add(aftk.getIdTanque());
        arrayVar.add(aftk.getTemperaturaBase());
        arrayVar.add(aftk.getMaterial());

        //ejecutar consulta y almacenar resultados en rs si se requiere
        estado = consultas.writeSQL(query, arrayVar);
        return estado;
    }

    public boolean eliminarAforoTanque(AforoTk aftk) throws SQLException {

        //creacion de variables para la consulta
        Consultas consultas = new Consultas();
        ArrayList arrayVar = new ArrayList();
        boolean estado = false;

        //consulta a realizar
        String query = "DELETE FROM aforotk WHERE idTanque=?";

        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
        arrayVar.add(aftk.getIdTanque());

        //ejecutar consulta y almacenar resultados en rs si se requiere
        estado = consultas.writeSQL(query, arrayVar);
        return estado;
    }

    public ArrayList listarMedidas(String tanque) throws SQLException {

        //creacion de variables para la consulta
        Consultas consultas = new Consultas();
        ArrayList arrayVar = new ArrayList();
        ResultSet rs;
        ArrayList<AforoTk> listado = new ArrayList();

        //consulta a realizar
        String query = "SELECT * FROM aforotk  WHERE idTanque=?";

        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
        arrayVar.add(tanque);
        //ejecutar consulta y almacenar resultados en rs si se requiere
        rs = consultas.readSQL(query, arrayVar);

        //asignar resultados a setter de objeto
        try {
            if (rs != null) {
                //consulta exitosa
                listado.add(new AforoTk(rs.getString("idTanque"), rs.getInt("nivel"), rs.getDouble("volumen"), rs.getDouble("incremento"), rs.getDouble("temperaturaBase"), rs.getString("material")));
                while (rs.next()) {
                    listado.add(new AforoTk(rs.getString("idTanque"), rs.getInt("nivel"), rs.getDouble("volumen"), rs.getDouble("incremento"), rs.getDouble("temperaturaBase"), rs.getString("material")));

                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay aforos cargados");
            }
            //para consultas que tienen rs se debe cerrar la conexion en cada 
            //funcion
            consultas.cerrarConexion();
        } catch (SQLException e) {
            System.err.println("ERROR " + e);
        }

        return listado;
    }

    public boolean buscarAforoXnivel(AforoTk aftk) throws SQLException {

        //creacion de variables para la consulta
        Consultas consultas = new Consultas();
        ArrayList arrayVar = new ArrayList();
        ResultSet rs;
        boolean estado = false;

        //consulta a realizar
        String query = "SELECT * FROM aforotk WHERE nivel=? AND idTanque=?";

        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
        arrayVar.add(aftk.getNivel());
        arrayVar.add(aftk.getIdTanque());

        //ejecutar consulta y almacenar resultados en rs si se requiere
        rs = consultas.readSQL(query, arrayVar);

        //asignar resultados a setter de objeto
        try {
            if (rs != null) {

                aftk.setVolumen(rs.getDouble("volumen"));
                aftk.setIncremento(rs.getDouble("incremento"));
                aftk.setTemperaturaBase(rs.getDouble("temperaturaBase"));
                aftk.setMaterial(rs.getString("material"));
                //consulta exitosa
                estado = true;
            }
            //para consultas que tienen rs se debe cerrar la conexion en cada 
            //funcion
            consultas.cerrarConexion();
        } catch (SQLException e) {
            System.err.println("ERROR " + e);
        }

        return estado;
    }

    public boolean almacenarAforoTanqueXArray(ArrayList<AforoTk> aftk) throws SQLException {

        //creacion de variables para la consulta
        Consultas consultas = new Consultas();
        ArrayList arrayVar = new ArrayList();
        boolean estado = false;
        //consulta a realizar

        StringBuilder query = new StringBuilder("INSERT INTO aforotk(nivel,volumen,incremento,idTanque,temperaturaBase,material) VALUES(?,?,?,?,?,?)");

        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
        arrayVar.add(aftk.get(0).getNivel());
        arrayVar.add(aftk.get(0).getVolumen());
        arrayVar.add(aftk.get(0).getIncremento());
        arrayVar.add(aftk.get(0).getIdTanque());
        arrayVar.add(aftk.get(0).getTemperaturaBase());
        arrayVar.add(aftk.get(0).getMaterial());

        for (int i = 1; i < aftk.size(); i++) {
            query.append(",(?,?,?,?,?,?)");

            //crear arraylist con objeto a consultar, agregar en el orden de la consulta
            arrayVar.add(aftk.get(i).getNivel());
            arrayVar.add(aftk.get(i).getVolumen());
            arrayVar.add(aftk.get(i).getIncremento());
            arrayVar.add(aftk.get(i).getIdTanque());
            arrayVar.add(aftk.get(i).getTemperaturaBase());
            arrayVar.add(aftk.get(i).getMaterial());
        }

        //ejecutar consulta y almacenar resultados en rs si se requiere
        estado = consultas.writeSQL(query.toString(), arrayVar);
        arrayVar.clear();

        return estado;
    }
    public boolean buscarUltimoXTanque(AforoTk aftk) throws SQLException {

        //creacion de variables para la consulta
        Consultas consultas = new Consultas();
        ArrayList arrayVar = new ArrayList();
        ResultSet rs;
        boolean estado = false;

        //consulta a realizar
        String query = "SELECT * FROM aforotk  WHERE idTanque=? ORDER BY consecutivo DESC LIMIT 1";

        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
        arrayVar.add(aftk.getIdTanque());

        //ejecutar consulta y almacenar resultados en rs si se requiere
        rs = consultas.readSQL(query, arrayVar);

        //asignar resultados a setter de objeto
        try {
            if (rs != null) {

                aftk.setVolumen(rs.getDouble("volumen"));
                aftk.setIncremento(rs.getDouble("incremento"));
                aftk.setTemperaturaBase(rs.getDouble("temperaturaBase"));
                aftk.setMaterial(rs.getString("material"));
                //consulta exitosa
                estado = true;
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
