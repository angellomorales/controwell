package com.petra.controwell.model;

import java.awt.Paint;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.petra.controwell.model.utilities.Utilities;

/**
 * Clase para manejar las GraficasOldNoUsar
 *
 * @author Angello Morales
 */
public final class GraficasOldNoUsar {

    // objeto que maneja la grafica
    private JFreeChart grafica;
    private XYDataset datos;
    private String titulo;
    private String nombreEjeX;
    private String nombreEjeY;
    private double rangoEjeY;
    private int tipo;

    //Variables tipos de graficas
    public final static int LINEAL = 1;
    public final static int POLAR = 2;
    public final static int DISPERSION = 3;
    public final static int AREA = 4;
    public final static int LOGARITMICA = 5;
    public final static int SERIETIEMPO = 6;
    public final static int PASO = 7;
    public final static int PASOAREA = 8;
    public final static int MAXVALUE = 1;
    public final static int MINVALUE = 2;
    public final static String EJEX = "X";
    public final static String EJEY = "Y";

    //variables para almacenar los datos de las series
    private final ArrayList<Paint> arrayColorSerie = new ArrayList<>();
    private final ArrayList<String> arrayTituloSerie = new ArrayList<>();
    private ArrayList arrayValoresX = new ArrayList();
    private final ArrayList<ArrayList> arraySeries = new ArrayList<>();
    
    //controlador
    public Utilities ctrlUtilities=new Utilities();

    /**
     * Constructor de Grafica
     *
     * @param tipo
     * LINEAL,POLAR,DISPERSION,AREA,LOGARITMICA,SERIETIEMPO,PASO,PASOAREA
     * @param titulo Titulo de la grafica
     * @param nombreEjeX Titulo eje X
     * @param nombreEjeY Titulo eje Y
     * @param rangoEjeY Rango eje Y
     */
    public GraficasOldNoUsar(int tipo, String titulo, String nombreEjeX, String nombreEjeY, int rangoEjeY) {
        this.setTitulo(titulo);
        this.setNombreEjeX(nombreEjeX);
        this.setNombreEjeY(nombreEjeY);
        this.rangoEjeY = rangoEjeY;
        this.setTipo(tipo);
        this.seleccionGrafica(tipo);
    }

    /**
     * Selecciona el tipo de grafica
     * LINEAL,POLAR,DISPERSION,AREA,LOGARITMICA,SERIETIEMPO,PASO,PASOAREA
     *
     * @param tipo
     */
    public void seleccionGrafica(int tipo) {
        switch (tipo) {
            case LINEAL:
                this.setGrafica(ChartFactory.createXYLineChart(getTitulo(), getNombreEjeX(), getNombreEjeY(), getDatos(), PlotOrientation.VERTICAL, true, true, true));

                //Cambiar rango del eje Y
                setRangoEjes(getNombreEjeY(), EJEY, 0, getRangoEjeY());

                break;
            case POLAR:
                this.setGrafica(ChartFactory.createPolarChart(getTitulo(), getDatos(), true, true, true));
                break;
            case DISPERSION:
                this.setGrafica(ChartFactory.createScatterPlot(getTitulo(), getNombreEjeX(), getNombreEjeY(), getDatos(), PlotOrientation.VERTICAL, true, true, true));
                break;
            case AREA:
                this.setGrafica(ChartFactory.createXYAreaChart(getTitulo(), getNombreEjeX(), getNombreEjeY(), getDatos(), PlotOrientation.VERTICAL, true, true, true));
                break;
            case LOGARITMICA:
                this.setGrafica(ChartFactory.createXYLineChart(getTitulo(), getNombreEjeX(), getNombreEjeY(), getDatos(), PlotOrientation.VERTICAL, true, true, true));

                //Cambiar rango del eje Y a logaritmico
                XYPlot ejes = this.getGrafica().getXYPlot();
                NumberAxis rango = new LogarithmicAxis(getNombreEjeY());
                ejes.setRangeAxis(rango);

                break;
            case SERIETIEMPO:
                this.setGrafica(ChartFactory.createTimeSeriesChart(getTitulo(), getNombreEjeX(), getNombreEjeY(), getDatos(), true, true, true));
                break;
            case PASO:
                this.setGrafica(ChartFactory.createXYStepChart(getTitulo(), getNombreEjeX(), getNombreEjeY(), getDatos(), PlotOrientation.VERTICAL, true, true, true));
                break;
            case PASOAREA:
                this.setGrafica(ChartFactory.createXYStepAreaChart(getTitulo(), getNombreEjeX(), getNombreEjeY(), getDatos(), PlotOrientation.VERTICAL, true, true, true));
                break;
            default:
                throw new AssertionError();
        }
    }

    /**
     * Agrega una serie a la grafica
     *
     * @param id Nombre de la serie
     * @param x Arraylist con los datos del eje X
     * @param y Arraylist con los datos del eje Y
     * @param paint Asigna el color de la serie con el metodo Color
     * @return
     */
    public XYSeries agregarSerieTipoXY(String id, ArrayList<Double> x, ArrayList<Double> y, Paint paint) {
        XYSeries serie = new XYSeries(id);

        // Agregar Color
        XYPlot plott = getGrafica().getXYPlot();
        plott.getRenderer().setSeriesPaint(0, paint);

        //llena la serie con los datos del Arraylist
        x.forEach((n) -> serie.add(n, y.get(x.indexOf(n))));
        return serie;

    }

    public TimeSeries agregarSerieTipoTime(String id, ArrayList<Calendar> timeX, ArrayList<Double> y, Paint paint) {
        TimeSeries serie = new TimeSeries(id);
        // Agregar Color
        XYPlot plott = getGrafica().getXYPlot();
        plott.getRenderer().setSeriesPaint(0, paint);

        //llena la serie con los datos del Arraylist
        for (int i = 0; i < timeX.size(); i++) {
            
            serie.add(new Second(timeX.get(i).getTime()),y.get(i));
        }
        //timeX.forEach((n) -> serie.add(new Hour(n.getTime()), y.get(timeX.indexOf(n))));

        return serie;
    }

    public void actualizarGrafica() {
        XYSeriesCollection coleccionXY = new XYSeriesCollection();
        TimeSeriesCollection coleccionTime = new TimeSeriesCollection();
        int conteo = 0;

        for (ArrayList arraySery : arraySeries) {
            if (this.getTipo() != SERIETIEMPO) {
                coleccionXY.addSeries(this.agregarSerieTipoXY(arrayTituloSerie.get(conteo), getArrayValoresX(), arraySery, arrayColorSerie.get(conteo)));
                setDatos(coleccionXY);
            } else {
                coleccionTime.addSeries(this.agregarSerieTipoTime(arrayTituloSerie.get(conteo), getArrayValoresX(), arraySery, arrayColorSerie.get(conteo)));
                setDatos(coleccionTime);
            }
            conteo++;
        }
        this.seleccionGrafica(this.getTipo());

    }

    public void cargarDatosY(ArrayList serie, String titulo, Paint color) {
        arraySeries.add(serie);
        arrayTituloSerie.add(titulo);
        arrayColorSerie.add(color);

    }

    /**
     * Limpia los valores de los arraylist donde se almacena las series
     *
     */
    public void limpiarDatos() {
        this.arrayColorSerie.removeAll(arrayColorSerie);
        this.arrayTituloSerie.removeAll(arrayTituloSerie);
        this.arraySeries.removeAll(arraySeries);
        this.arrayValoresX.removeAll(arrayValoresX);
    }

    /**
     * Obtiene el panel donde se encuentra la grafica
     *
     * @return panel
     */
    public JPanel obtienepanel() {
        return new ChartPanel(getGrafica());

    }

    /**
     * Metodo para modificar el rango de la grafica
     *
     * @param titulo titulo del eje a modificar
     * @param eje nombre del eje a modificar
     * @param min int valor minimo
     * @param max int valor maximo
     */
    public void setRangoEjes(String titulo, String eje, double min, double max) {
        XYPlot ejes = getGrafica().getXYPlot();
        NumberAxis rango = new NumberAxis(titulo);
        rango.setRange(min, max);
        if (eje.equals(EJEY)) {
            ejes.setRangeAxis(rango);
        }
        if (eje.equals(EJEX)) {
            ejes.setDomainAxis(rango);
        }
    }

    public double getRangoEjes(String eje, int maxMin) {
        double ejeValue = 0;
        XYPlot rango = getGrafica().getXYPlot();
        if (eje.equals(EJEY)) {
            if (maxMin == MINVALUE) {
                ejeValue = (double) rango.getRangeAxis().getLowerBound();
            }
            if (maxMin == MAXVALUE) {
                ejeValue = (double) rango.getRangeAxis().getUpperBound();
            }
        }
        if (eje.equals(EJEX)) {
            if (maxMin == MINVALUE) {
                ejeValue = (double) rango.getDomainAxis().getLowerBound();
            }
            if (maxMin == MAXVALUE) {
                ejeValue = (double) rango.getDomainAxis().getUpperBound();
            }
        }
        return ejeValue;
    }

    //<editor-fold defaultstate="collapsed" desc="getters y setters arraylist series">
    public JFreeChart getGrafica() {
        return grafica;
    }

    public void setGrafica(JFreeChart grafica) {
        this.grafica = grafica;
    }

    public XYDataset getDatos() {
        return datos;
    }

    public void setDatos(XYDataset datos) {
        this.datos = datos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombreEjeX() {
        return nombreEjeX;
    }

    public void setNombreEjeX(String nombreEjeX) {
        this.nombreEjeX = nombreEjeX;
    }

    public String getNombreEjeY() {
        return nombreEjeY;
    }

    public void setNombreEjeY(String nombreEjeY) {
        this.nombreEjeY = nombreEjeY;
    }

    public double getRangoEjeY() {
        return rangoEjeY;
    }

    public void setRangoEjeY(double rangoEjeY) {
        this.rangoEjeY = rangoEjeY;
    }

    public ArrayList getArrayValoresX() {
        return arrayValoresX;
    }

    public void setArrayValoresX(ArrayList arrayValoresX) {
        this.arrayValoresX = arrayValoresX;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    //</editor-fold>
}
