/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petra.controwell.model;

import java.awt.Color;
import java.awt.Font;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.petra.controwell.model.utilities.Utilities;

/**
 *
 * @author AngelloM
 */
public class Graficas {

    private JFreeChart grafica;
    private XYDataset datosPrincipal;
    private XYDataset datosSecundario;

    public final boolean EJE_SECUNDARIO = false;
    public final boolean EJE_PRINCIPAL = true;
    public final int LINEAL = 1;
//    public final int POLAR = 2;
//    public final int DISPERSION = 3;
//    public final int AREA = 4;
//    public final int LOGARITMICA = 5;
    public final int SERIETIEMPO = 6;
    private int tipoGrafica;

    //controlador
    public Utilities ctrlUtilities = new Utilities();

    //variables para almacenar los datos de las series
    private final ArrayList<String> arrayTituloSerie = new ArrayList<>();
    private ArrayList arrayValoresX = new ArrayList();
    private final ArrayList<ArrayList> arraySeries = new ArrayList<>();

    public XYSeries agregarSerieTipoXY(String id, ArrayList<Double> x, ArrayList<Double> y) {
        XYSeries serie = new XYSeries(id);

        //llena la serie con los datos del Arraylist
        x.forEach((n) -> serie.add(n, y.get(x.indexOf(n))));
        return serie;

    }

    public TimeSeries agregarSerieTipoTime(String id, ArrayList<Date> timeX, ArrayList<Double> y) {
        TimeSeries serie = new TimeSeries(id);

        //llena la serie con los datos del Arraylist
        for (int i = 0; i < timeX.size(); i++) {

            //array tipo Calendar
//            serie.add(new Second(timeX.get(i).getTime()), y.get(i));
            //array tipo Date
            serie.add(new Second(ctrlUtilities.asignacionFechas(timeX.get(i), timeX.get(i)).getTime()), y.get(i));
        }
        //timeX.forEach((n) -> serie.add(new Hour(n.getTime()), y.get(timeX.indexOf(n))));

        return serie;
    }

    public void actualizarDatosGrafica(boolean ejeDatos) {
        XYSeriesCollection datasetXY = new XYSeriesCollection();
        TimeSeriesCollection datasetTime = new TimeSeriesCollection();
        int conteo = 0;
        for (ArrayList arraySery : arraySeries) {
            if (getTipoGrafica() == SERIETIEMPO) {
                datasetTime.addSeries(this.agregarSerieTipoTime(arrayTituloSerie.get(conteo), getArrayValoresX(), arraySery));
            }
            if (getTipoGrafica() == LINEAL) {
                datasetXY.addSeries(this.agregarSerieTipoXY(arrayTituloSerie.get(conteo), getArrayValoresX(), arraySery));
            }
            conteo++;
        }
        if (ejeDatos) {
            if (getTipoGrafica() == SERIETIEMPO) {
                this.setDatosPrincipal(datasetTime);
            }
            if (getTipoGrafica() == LINEAL) {
                this.setDatosPrincipal(datasetXY);
            }
        } else {
            if (getTipoGrafica() == SERIETIEMPO) {
                this.setDatosSecundario(datasetTime);
            }
            if (getTipoGrafica() == LINEAL) {
                this.setDatosSecundario(datasetXY);
            }
        }

    }

    public void construirGrafica(String tituloGrafica, String tituloEjeYPrincipal, String tituloEjeYSecundario, String tituloEjeX, boolean soloEjePrincipal) {

        //construct the plot
        XYPlot plot = new XYPlot();
        plot.setDataset(0, getDatosPrincipal());

        //customize the plot with renderers and axis
        plot.setRenderer(0, new XYSplineRenderer());//use default fill paint for first series
//        plot.setRenderer(0, new XYBarRenderer());//use default fill paint for first series
        plot.setRangeAxis(0, new NumberAxis(tituloEjeYPrincipal));

        //Map the data to the appropriate axis
        plot.mapDatasetToRangeAxis(0, 0);

        if (getTipoGrafica() == SERIETIEMPO) {
            plot.setDomainAxis(new DateAxis(tituloEjeX));
        }
        if (getTipoGrafica() == LINEAL) {
            plot.setDomainAxis(new NumberAxis(tituloEjeX));

        }
        //eje secundario
        if (!soloEjePrincipal) {
            //construct the plot
            plot.setDataset(1, getDatosSecundario());
            //customize the plot with renderers and axis
            plot.setRenderer(1, new XYSplineRenderer());
            plot.setRangeAxis(1, new NumberAxis(tituloEjeYSecundario));
            //Map the data to the appropriate axis
            plot.mapDatasetToRangeAxis(1, 1);
        }

        //generate the chart
        JFreeChart chart = new JFreeChart(tituloGrafica, new Font("Tahoma", Font.BOLD, 16), plot, true);
        chart.setBackgroundPaint(Color.WHITE);
        this.setGrafica(chart);
    }

    public void cargarArrayValoresY(ArrayList serie, String titulo) {
        arraySeries.add(serie);
        arrayTituloSerie.add(titulo);

    }

    public void limpiarArrayDatos() {
        this.arrayTituloSerie.removeAll(arrayTituloSerie);
        this.arraySeries.removeAll(arraySeries);
//        this.arrayValoresX.removeAll(arrayValoresX);
    }

    public JPanel obtienepanel() {
        return new ChartPanel(getGrafica());

    }

    public JFreeChart getGrafica() {
        return grafica;
    }

    public void setGrafica(JFreeChart grafica) {
        this.grafica = grafica;
    }

    public XYDataset getDatosPrincipal() {
        return datosPrincipal;
    }

    public void setDatosPrincipal(XYDataset datosPrincipal) {
        this.datosPrincipal = datosPrincipal;
    }

    public XYDataset getDatosSecundario() {
        return datosSecundario;
    }

    public void setDatosSecundario(XYDataset datosSecundario) {
        this.datosSecundario = datosSecundario;
    }

    public ArrayList getArrayValoresX() {
        return arrayValoresX;
    }

    public void setArrayValoresX(ArrayList arrayValoresX) {
        this.arrayValoresX = arrayValoresX;
    }

    public int getTipoGrafica() {
        return tipoGrafica;
    }

    public void setTipoGrafica(int tipoGrafica) {
        this.tipoGrafica = tipoGrafica;
    }

}
