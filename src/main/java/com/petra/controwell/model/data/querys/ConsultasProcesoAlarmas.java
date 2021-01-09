package com.petra.controwell.model.data.querys;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.petra.controwell.model.data.ProcesoAlarmas;
import com.petra.controwell.model.data.bdstruct.Consultas;

/**
 *
 * @author Angello Morales
 */
public class ConsultasProcesoAlarmas {

    public boolean buscarAlarmas(ProcesoAlarmas procA) throws SQLException {

        //creacion de variables para la consulta
        Consultas consultas = new Consultas();
        ArrayList arrayVar = new ArrayList();
        ResultSet rs;
        boolean estado = false;

        //consulta a realizar
        String query = "SELECT * FROM procesoalarmas WHERE idPozo=? ORDER BY consecutivo DESC LIMIT 1";

        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
        arrayVar.add(procA.getIdPozo());

        //ejecutar consulta y almacenar resultados en rs si se requiere
        rs = consultas.readSQL(query, arrayVar);

        //asignar resultados a setter de objeto
        try {
            if (rs != null) {
                procA.setPresionCabezaMin(rs.getDouble("presionCabezaMin"));
                procA.setPresionCabezaMax(rs.getDouble("presionCabezaMax"));
                procA.setPresionCabezaEnable(rs.getBoolean("presionCabezaEnable"));
                procA.setTemperaturaCabezaMin(rs.getDouble("temperaturaCabezaMin"));
                procA.setTemperaturaCabezaMax(rs.getDouble("temperaturaCabezaMax"));
                procA.setTemperaturaCabezaEnable(rs.getBoolean("temperaturaCabezaEnable"));
                procA.setPresionCasingMin(rs.getDouble("presionCasingMin"));
                procA.setPresionCasingMax(rs.getDouble("presionCasingMax"));
                procA.setPresionCasingEnable(rs.getBoolean("presionCasingEnable"));
                procA.setPresionChokeMin(rs.getDouble("presionChokeMin"));
                procA.setPresionChokeMax(rs.getDouble("presionChokeMax"));
                procA.setPresionChokeEnable(rs.getBoolean("presionChokeEnable"));
                procA.setFlujoDiluyenteMin(rs.getDouble("flujoDiluyenteMin"));
                procA.setFlujoDiluyenteMax(rs.getDouble("flujoDiluyenteMax"));
                procA.setFlujoDiluyenteEnable(rs.getBoolean("flujoDiluyenteEnable"));
                procA.setPresionMezcladorMin(rs.getDouble("presionMezcladorMin"));
                procA.setPresionMezcladorMax(rs.getDouble("presionMezcladorMax"));
                procA.setPresionMezcladorEnable(rs.getBoolean("presionMezcladorEnable"));
                procA.setFlujoAceiteSepMin(rs.getDouble("flujoAceiteSepMin"));
                procA.setFlujoAceiteSepMax(rs.getDouble("flujoAceiteSepMax"));
                procA.setFlujoAceiteSepEnable(rs.getBoolean("flujoAceiteSepEnable"));
                procA.setFlujoAguaSepMin(rs.getDouble("flujoAguaSepMin"));
                procA.setFlujoAguaSepMax(rs.getDouble("flujoAguaSepMax"));
                procA.setFlujoAguaSepEnable(rs.getBoolean("flujoAguaSepEnable"));
                procA.setPresionSepMin(rs.getDouble("presionSepMin"));
                procA.setPresionSepMax(rs.getDouble("presionSepMax"));
                procA.setPresionSepEnable(rs.getBoolean("presionSepEnable"));
                procA.setTemperaturaSepMin(rs.getDouble("temperaturaSepMin"));
                procA.setTemperaturaSepMax(rs.getDouble("temperaturaSepMax"));
                procA.setTemperaturaSepEnable(rs.getBoolean("temperaturaSepEnable"));
                procA.setPresionGasSepMin(rs.getDouble("presionGasSepMin"));
                procA.setPresionGasSepMax(rs.getDouble("presionGasSepMax"));
                procA.setPresionGasSepEnable(rs.getBoolean("presionGasSepEnable"));
                procA.setTemperaturaGasSepMin(rs.getDouble("temperaturaGasSepMin"));
                procA.setTemperaturaGasSepMax(rs.getDouble("temperaturaGasSepMax"));
                procA.setTemperaturaGasSepEnable(rs.getBoolean("temperaturaGasSepEnable"));
                procA.setFlujoGasMin(rs.getDouble("flujoGasMin"));
                procA.setFlujoGasMax(rs.getDouble("flujoGasMax"));
                procA.setFlujoGasEnable(rs.getBoolean("flujoGasEnable"));
                procA.setPresionLineaMin(rs.getDouble("presionLineaMin"));
                procA.setPresionLineaMax(rs.getDouble("presionLineaMax"));
                procA.setPresionLineaEnable(rs.getBoolean("presionLineaEnable"));
                procA.setFecha(rs.getDate("fecha"));
                procA.setHora(rs.getTime("hora"));
                procA.setPresionCabezaActive(rs.getBoolean("presionCabezaActive"));
                procA.setTemperaturaCabezaActive(rs.getBoolean("temperaturaCabezaActive"));
                procA.setPresionCasingActive(rs.getBoolean("presionCasingActive"));
                procA.setPresionChokeActive(rs.getBoolean("presionChokeActive"));
                procA.setFlujoDiluyenteActive(rs.getBoolean("flujoDiluyenteActive"));
                procA.setPresionMezcladorActive(rs.getBoolean("presionMezcladorActive"));
                procA.setFlujoAceiteSepActive(rs.getBoolean("flujoAceiteSepActive"));
                procA.setFlujoAguaSepActive(rs.getBoolean("flujoAguaSepActive"));
                procA.setPresionSepActive(rs.getBoolean("presionSepActive"));
                procA.setTemperaturaSepActive(rs.getBoolean("temperaturaSepActive"));
                procA.setPresionGasSepActive(rs.getBoolean("presionGasSepActive"));
                procA.setTemperaturaGasSepActive(rs.getBoolean("temperaturaGasSepActive"));
                procA.setFlujoGasActive(rs.getBoolean("flujoGasActive"));
                procA.setPresionLineaActive(rs.getBoolean("presionLineaActive"));

                //consulta exitosa
                estado = true;
            } else {
                System.err.println("No hay datos relacionados");
            }
            //para consultas que tienen rs se debe cerrar la conexion en cada 
            //funcion
            consultas.cerrarConexion();
        } catch (SQLException e) {
            System.err.println("ERROR " + e);
        }

        return estado;
    }

    public boolean agregarAlarmas(ProcesoAlarmas procA) throws SQLException {

        //creacion de variables para la consulta
        Consultas consultas = new Consultas();
        ArrayList arrayVar = new ArrayList();
        boolean estado = false;

        //consulta a realizar
        String query = "INSERT INTO procesoalarmas(idPozo, presionCabezaMin, presionCabezaMax, presionCabezaEnable, temperaturaCabezaMin, temperaturaCabezaMax, temperaturaCabezaEnable, presionCasingMin, presionCasingMax, presionCasingEnable, presionChokeMin, presionChokeMax, presionChokeEnable, flujoDiluyenteMin, flujoDiluyenteMax, flujoDiluyenteEnable, presionMezcladorMin, presionMezcladorMax, presionMezcladorEnable, flujoAceiteSepMin, flujoAceiteSepMax, flujoAceiteSepEnable, flujoAguaSepMin, flujoAguaSepMax, flujoAguaSepEnable, presionSepMin, presionSepMax, presionSepEnable, temperaturaSepMin, temperaturaSepMax, temperaturaSepEnable, presionGasSepMin, presionGasSepMax, presionGasSepEnable, temperaturaGasSepMin, temperaturaGasSepMax, temperaturaGasSepEnable, flujoGasMin, flujoGasMax, flujoGasEnable, presionLineaMin, presionLineaMax, presionLineaEnable, fecha, hora, presionCabezaActive, temperaturaCabezaActive, presionCasingActive, presionChokeActive, flujoDiluyenteActive, presionMezcladorActive, flujoAceiteSepActive, flujoAguaSepActive, presionSepActive, temperaturaSepActive, presionGasSepActive, temperaturaGasSepActive, flujoGasActive, presionLineaActive) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
        arrayVar.add(procA.getIdPozo());
        arrayVar.add(procA.getPresionCabezaMin());
        arrayVar.add(procA.getPresionCabezaMax());
        arrayVar.add(procA.isPresionCabezaEnable());
        arrayVar.add(procA.getTemperaturaCabezaMin());
        arrayVar.add(procA.getTemperaturaCabezaMax());
        arrayVar.add(procA.isTemperaturaCabezaEnable());
        arrayVar.add(procA.getPresionCasingMin());
        arrayVar.add(procA.getPresionCasingMax());
        arrayVar.add(procA.isPresionCasingEnable());
        arrayVar.add(procA.getPresionChokeMin());
        arrayVar.add(procA.getPresionChokeMax());
        arrayVar.add(procA.isPresionChokeEnable());
        arrayVar.add(procA.getFlujoDiluyenteMin());
        arrayVar.add(procA.getFlujoDiluyenteMax());
        arrayVar.add(procA.isFlujoDiluyenteEnable());
        arrayVar.add(procA.getPresionMezcladorMin());
        arrayVar.add(procA.getPresionMezcladorMax());
        arrayVar.add(procA.isPresionMezcladorEnable());
        arrayVar.add(procA.getFlujoAceiteSepMin());
        arrayVar.add(procA.getFlujoAceiteSepMax());
        arrayVar.add(procA.isFlujoAceiteSepEnable());
        arrayVar.add(procA.getFlujoAguaSepMin());
        arrayVar.add(procA.getFlujoAguaSepMax());
        arrayVar.add(procA.isFlujoAguaSepEnable());
        arrayVar.add(procA.getPresionSepMin());
        arrayVar.add(procA.getPresionSepMax());
        arrayVar.add(procA.isPresionSepEnable());
        arrayVar.add(procA.getTemperaturaSepMin());
        arrayVar.add(procA.getTemperaturaSepMax());
        arrayVar.add(procA.isTemperaturaSepEnable());
        arrayVar.add(procA.getPresionGasSepMin());
        arrayVar.add(procA.getPresionGasSepMax());
        arrayVar.add(procA.isPresionGasSepEnable());
        arrayVar.add(procA.getTemperaturaGasSepMin());
        arrayVar.add(procA.getTemperaturaGasSepMax());
        arrayVar.add(procA.isTemperaturaGasSepEnable());
        arrayVar.add(procA.getFlujoGasMin());
        arrayVar.add(procA.getFlujoGasMax());
        arrayVar.add(procA.isFlujoGasEnable());
        arrayVar.add(procA.getPresionLineaMin());
        arrayVar.add(procA.getPresionLineaMax());
        arrayVar.add(procA.isPresionLineaEnable());
        arrayVar.add(procA.getFecha());
        arrayVar.add(procA.getHora());
        arrayVar.add(procA.isPresionCabezaActive());
        arrayVar.add(procA.isTemperaturaCabezaActive());
        arrayVar.add(procA.isPresionCasingActive());
        arrayVar.add(procA.isPresionChokeActive());
        arrayVar.add(procA.isFlujoDiluyenteActive());
        arrayVar.add(procA.isPresionMezcladorActive());
        arrayVar.add(procA.isFlujoAceiteSepActive());
        arrayVar.add(procA.isFlujoAguaSepActive());
        arrayVar.add(procA.isPresionSepActive());
        arrayVar.add(procA.isTemperaturaSepActive());
        arrayVar.add(procA.isPresionGasSepActive());
        arrayVar.add(procA.isTemperaturaGasSepActive());
        arrayVar.add(procA.isFlujoGasActive());
        arrayVar.add(procA.isPresionLineaActive());

        //ejecutar consulta y almacenar resultados en rs si se requiere
        estado = consultas.writeSQL(query, arrayVar);
        return estado;
    }

    public boolean eliminarAlarmas(ProcesoAlarmas procA) throws SQLException {

        //creacion de variables para la consulta
        Consultas consultas = new Consultas();
        ArrayList arrayVar = new ArrayList();
        boolean estado = false;

        //consulta a realizar
        String query = "DELETE FROM procesoalarmas WHERE idPozo=?";

        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
        arrayVar.add(procA.getIdPozo());

        //ejecutar consulta y almacenar resultados en rs si se requiere
        estado = consultas.writeSQL(query, arrayVar);
        return estado;
    }

    public boolean editarAlarmas(ProcesoAlarmas procA) throws SQLException {

        //creacion de variables para la consulta
        Consultas consultas = new Consultas();
        ArrayList arrayVar = new ArrayList();
        boolean estado = false;

        //consulta a realizar
        String query = "UPDATE procesoalarmas SET presionCabezaMin=?, presionCabezaMax=?, presionCabezaEnable=?, temperaturaCabezaMin=?, temperaturaCabezaMax=?, temperaturaCabezaEnable=?, presionCasingMin=?, presionCasingMax=?, presionCasingEnable=?, presionChokeMin=?, presionChokeMax=?, presionChokeEnable=?, flujoDiluyenteMin=?, flujoDiluyenteMax=?, flujoDiluyenteEnable=?, presionMezcladorMin=?, presionMezcladorMax=?, presionMezcladorEnable=?, flujoAceiteSepMin=?, flujoAceiteSepMax=?, flujoAceiteSepEnable=?, flujoAguaSepMin=?, flujoAguaSepMax=?, flujoAguaSepEnable=?, presionSepMin=?, presionSepMax=?, presionSepEnable=?, temperaturaSepMin=?, temperaturaSepMax=?, temperaturaSepEnable=?, presionGasSepMin=?, presionGasSepMax=?, presionGasSepEnable=?, temperaturaGasSepMin=?, temperaturaGasSepMax=?, temperaturaGasSepEnable=?, flujoGasMin=?, flujoGasMax=?, flujoGasEnable=?, presionLineaMin=?, presionLineaMax=?, presionLineaEnable=?, fecha=?, hora=?, presionCabezaActive=?, temperaturaCabezaActive=?, presionCasingActive=?, presionChokeActive=?, flujoDiluyenteActive=?, presionMezcladorActive=?, flujoAceiteSepActive=?, flujoAguaSepActive=?, presionSepActive=?, temperaturaSepActive=?, presionGasSepActive=?, temperaturaGasSepActive=?, flujoGasActive=?, presionLineaActive=? WHERE idPozo=?";

        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
        arrayVar.add(procA.getPresionCabezaMin());
        arrayVar.add(procA.getPresionCabezaMax());
        arrayVar.add(procA.isPresionCabezaEnable());
        arrayVar.add(procA.getTemperaturaCabezaMin());
        arrayVar.add(procA.getTemperaturaCabezaMax());
        arrayVar.add(procA.isTemperaturaCabezaEnable());
        arrayVar.add(procA.getPresionCasingMin());
        arrayVar.add(procA.getPresionCasingMax());
        arrayVar.add(procA.isPresionCasingEnable());
        arrayVar.add(procA.getPresionChokeMin());
        arrayVar.add(procA.getPresionChokeMax());
        arrayVar.add(procA.isPresionChokeEnable());
        arrayVar.add(procA.getFlujoDiluyenteMin());
        arrayVar.add(procA.getFlujoDiluyenteMax());
        arrayVar.add(procA.isFlujoDiluyenteEnable());
        arrayVar.add(procA.getPresionMezcladorMin());
        arrayVar.add(procA.getPresionMezcladorMax());
        arrayVar.add(procA.isPresionMezcladorEnable());
        arrayVar.add(procA.getFlujoAceiteSepMin());
        arrayVar.add(procA.getFlujoAceiteSepMax());
        arrayVar.add(procA.isFlujoAceiteSepEnable());
        arrayVar.add(procA.getFlujoAguaSepMin());
        arrayVar.add(procA.getFlujoAguaSepMax());
        arrayVar.add(procA.isFlujoAguaSepEnable());
        arrayVar.add(procA.getPresionSepMin());
        arrayVar.add(procA.getPresionSepMax());
        arrayVar.add(procA.isPresionSepEnable());
        arrayVar.add(procA.getTemperaturaSepMin());
        arrayVar.add(procA.getTemperaturaSepMax());
        arrayVar.add(procA.isTemperaturaSepEnable());
        arrayVar.add(procA.getPresionGasSepMin());
        arrayVar.add(procA.getPresionGasSepMax());
        arrayVar.add(procA.isPresionGasSepEnable());
        arrayVar.add(procA.getTemperaturaGasSepMin());
        arrayVar.add(procA.getTemperaturaGasSepMax());
        arrayVar.add(procA.isTemperaturaGasSepEnable());
        arrayVar.add(procA.getFlujoGasMin());
        arrayVar.add(procA.getFlujoGasMax());
        arrayVar.add(procA.isFlujoGasEnable());
        arrayVar.add(procA.getPresionLineaMin());
        arrayVar.add(procA.getPresionLineaMax());
        arrayVar.add(procA.isPresionLineaEnable());
        arrayVar.add(procA.getFecha());
        arrayVar.add(procA.getHora());
        arrayVar.add(procA.isPresionCabezaActive());
        arrayVar.add(procA.isTemperaturaCabezaActive());
        arrayVar.add(procA.isPresionCasingActive());
        arrayVar.add(procA.isPresionChokeActive());
        arrayVar.add(procA.isFlujoDiluyenteActive());
        arrayVar.add(procA.isPresionMezcladorActive());
        arrayVar.add(procA.isFlujoAceiteSepActive());
        arrayVar.add(procA.isFlujoAguaSepActive());
        arrayVar.add(procA.isPresionSepActive());
        arrayVar.add(procA.isTemperaturaSepActive());
        arrayVar.add(procA.isPresionGasSepActive());
        arrayVar.add(procA.isTemperaturaGasSepActive());
        arrayVar.add(procA.isFlujoGasActive());
        arrayVar.add(procA.isPresionLineaActive());
        arrayVar.add(procA.getIdPozo());

        //ejecutar consulta y almacenar resultados en rs si se requiere
        estado = consultas.writeSQL(query, arrayVar);
        return estado;
    }

    public boolean noHayAlarma(String pozo, String variable) throws SQLException {

        //creacion de variables para la consulta
        Consultas consultas = new Consultas();
        ArrayList arrayVar = new ArrayList();
        ResultSet rs;
        boolean estado = false;

        //consulta a realizar
        String query = "SELECT proceso.consecutivo, procesoalarmas." + variable + "Enable FROM proceso LEFT JOIN procesoalarmas ON proceso.idPozo=procesoalarmas.idPozo AND (procesoalarmas." + variable + "Enable>0 AND (procesoalarmas." + variable + "Min>proceso." + variable + " OR procesoalarmas." + variable + "Max<proceso." + variable + ")) WHERE proceso.idPozo=? ORDER BY proceso.consecutivo DESC LIMIT 1";
        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
        arrayVar.add(pozo);

        //ejecutar consulta y almacenar resultados en rs si se requiere
        rs = consultas.readSQL(query, arrayVar);

        //asignar resultados a setter de objeto
        try {
            if (rs != null) {
                //consulta exitosa
                if (rs.getString(variable + "Enable") == null) {
                    estado = true;
                }
            }
            //para consultas que tienen rs se debe cerrar la conexion en cada 
            //funcion
            consultas.cerrarConexion();
        } catch (SQLException e) {
            System.err.println("ERROR " + e);
        }

        return estado;
    }

//    public boolean agregarVariables(ProcesoAlarmas procA) throws SQLException {
//
//        //creacion de variables para la consulta
//        Consultas consultas = new Consultas();
//        ArrayList arrayVar = new ArrayList();
//        boolean estado = false;
//
//        //consulta a realizar
//        String query = "INSERT INTO procesoalarmas(idPozo, presionCabezaActive, temperaturaCabezaActive, presionCasingActive, presionChokeActive, flujoDiluyenteActive, presionMezcladorActive, flujoAceiteSepActive, flujoAguaSepActive, presionSepActive, temperaturaSepActive, presionGasSepActive, temperaturaGasSepActive, flujoGasActive, presionLineaActive) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//
//        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
//        arrayVar.add(procA.getIdPozo());
//        arrayVar.add(procA.isPresionCabezaActive());
//        arrayVar.add(procA.isTemperaturaCabezaActive());
//        arrayVar.add(procA.isPresionCasingActive());
//        arrayVar.add(procA.isPresionChokeActive());
//        arrayVar.add(procA.isFlujoDiluyenteActive());
//        arrayVar.add(procA.isPresionMezcladorActive());
//        arrayVar.add(procA.isFlujoAceiteSepActive());
//        arrayVar.add(procA.isFlujoAguaSepActive());
//        arrayVar.add(procA.isPresionSepActive());
//        arrayVar.add(procA.isTemperaturaSepActive());
//        arrayVar.add(procA.isPresionGasSepActive());
//        arrayVar.add(procA.isTemperaturaGasSepActive());
//        arrayVar.add(procA.isFlujoGasActive());
//        arrayVar.add(procA.isPresionLineaActive());
//
//        //ejecutar consulta y almacenar resultados en rs si se requiere
//        estado = consultas.writeSQL(query, arrayVar);
//        return estado;
//    }
//
//    public boolean editarVariables(ProcesoAlarmas procA) throws SQLException {
//
//        //creacion de variables para la consulta
//        Consultas consultas = new Consultas();
//        ArrayList arrayVar = new ArrayList();
//        boolean estado = false;
//
//        //consulta a realizar
//        String query = "UPDATE procesoalarmas SET presionCabezaActive=?, temperaturaCabezaActive=?, presionCasingActive=?, presionChokeActive=?, flujoDiluyenteActive=?, presionMezcladorActive=?, flujoAceiteSepActive=?, flujoAguaSepActive=?, presionSepActive=?, temperaturaSepActive=?, presionGasSepActive=?, temperaturaGasSepActive=?, flujoGasActive=?, presionLineaActive=? WHERE idPozo=?";
//
//        //crear arraylist con objeto a consultar, agregar en el orden de la consulta
//        arrayVar.add(procA.isPresionCabezaActive());
//        arrayVar.add(procA.isTemperaturaCabezaActive());
//        arrayVar.add(procA.isPresionCasingActive());
//        arrayVar.add(procA.isPresionChokeActive());
//        arrayVar.add(procA.isFlujoDiluyenteActive());
//        arrayVar.add(procA.isPresionMezcladorActive());
//        arrayVar.add(procA.isFlujoAceiteSepActive());
//        arrayVar.add(procA.isFlujoAguaSepActive());
//        arrayVar.add(procA.isPresionSepActive());
//        arrayVar.add(procA.isTemperaturaSepActive());
//        arrayVar.add(procA.isPresionGasSepActive());
//        arrayVar.add(procA.isTemperaturaGasSepActive());
//        arrayVar.add(procA.isFlujoGasActive());
//        arrayVar.add(procA.isPresionLineaActive());
//        arrayVar.add(procA.getIdPozo());
//
//        //ejecutar consulta y almacenar resultados en rs si se requiere
//        estado = consultas.writeSQL(query, arrayVar);
//        return estado;
//    }

}
