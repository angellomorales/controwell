package com.petra.controwell.control.internal;

import com.petra.controwell.model.Graficas;
import com.petra.controwell.model.SeriesGrafica;
import com.petra.controwell.model.data.querys.ConsultasProcesoProduccionArray;
import com.petra.controwell.model.utilities.Utilities;
import com.petra.controwell.view.internal.FrmGraficas;
import com.petra.controwell.view.internal.FrmSeries;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Angello Morales
 */
public class CtrlGraficas implements ActionListener {

    //vista
    public FrmGraficas frmGraficas;

    //modelo BD
    public ConsultasProcesoProduccionArray graficaC;
    //modelo

    //controlador
    public CtrlSeries ctrlSeries;
    public Utilities utilities;

    //variables
    Graficas grafica = new Graficas();
    boolean isEjePrincipal = grafica.EJE_PRINCIPAL;

    public CtrlGraficas(FrmGraficas frmGraficas, FrmSeries frmSeries, ConsultasProcesoProduccionArray graficaC, Utilities utilities) {
        this.frmGraficas = frmGraficas;
        this.utilities = utilities;
        this.graficaC = graficaC;
        this.ctrlSeries = new CtrlSeries(frmSeries, utilities, this);

        //instanciar librerias
        this.frmGraficas.cmbxIdPozo.removeAllItems();
        grafica.setTipoGrafica(grafica.SERIETIEMPO);

        //agregar listener a los botones dentro del constructor
        this.frmGraficas.btnGraficar.addActionListener(this);
        this.frmGraficas.btnExportar.addActionListener(this);
        this.frmGraficas.btnSeriesPrincipal.addActionListener(this);
        this.frmGraficas.btnSeriesSecundario.addActionListener(this);
        this.frmGraficas.btnReset.addActionListener(this);
        this.frmGraficas.rdbtnDia.addActionListener(this);
        this.frmGraficas.rdbtnRangoFecha.addActionListener(this);

        //itemListener particular para combobox
        this.frmGraficas.cmbxIdPozo.addItemListener((ItemEvent itemEvent) -> {
            int state = itemEvent.getStateChange();
            String valcmbx;
            valcmbx = frmGraficas.cmbxIdPozo.getSelectedItem().toString();
            if (state == ItemEvent.SELECTED) {
                if (!valcmbx.isEmpty()) {
                    habilitarBtnGraficar();
                }

            }
        });

        //PopertychangeListener particular para spinner
        this.frmGraficas.dtchFechaInicial.addPropertyChangeListener((PropertyChangeEvent e) -> {
            if ("date".equals(e.getPropertyName())) {
                habilitarBtnGraficar();
            }
        });
        this.frmGraficas.dtchFechaFinal.addPropertyChangeListener((PropertyChangeEvent e) -> {
            if ("date".equals(e.getPropertyName())) {
                habilitarBtnGraficar();
            }
        });
    }

    public void iniciar() throws PropertyVetoException {
        frmGraficas.setTitle("Gráficos");
        frmGraficas.setVisible(true);
        frmGraficas.toFront();
        frmGraficas.setSelected(true);
        this.habilitarBtnGraficar();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //acciones a ejecutar cuando se presiona un elemento en la pantalla 
        //if por cada elemento para detectar cual se presiono

        //-----Graficar-----
        if (e.getSource() == frmGraficas.btnGraficar) {

            ArrayList arrayDatosSeries = new ArrayList(this.cargarInformacionArraysGraficas());
            // valores eje principal
            int hayDataPrincipal = 0;
            int hayDataSecundario = 0;
            if (arrayDatosSeries != null) {
                for (int seri = 0; seri < arrayDatosSeries.size() - 1; seri++) {
                    int clavefecha = this.utilities.evaluarArrayIntOClaveo((ArrayList) arrayDatosSeries.get(arrayDatosSeries.size() - 1), seri);
                    if (clavefecha == 0) {
                        grafica.setArrayValoresX((ArrayList) arrayDatosSeries.get(seri));

                        for (int i = seri; i < arrayDatosSeries.size() - 1; i++) {
                            int clave = this.utilities.evaluarArrayIntOClaveo((ArrayList) arrayDatosSeries.get(arrayDatosSeries.size() - 1), i);
                            if (clave != 0) {
                                if (this.ctrlSeries.getArrayMapSeries().get(clave).isEjePrincipal()) {
                                    grafica.cargarArrayValoresY((ArrayList) arrayDatosSeries.get(i), this.ctrlSeries.getArrayMapSeries().get(clave).getNombreSerie());
                                    hayDataPrincipal = 1;
                                }
                            }
                        }
                        if (hayDataPrincipal == 1) {
                            grafica.actualizarDatosGrafica(grafica.EJE_PRINCIPAL);
                            grafica.limpiarArrayDatos();
                            hayDataPrincipal=0;
                        }
                        //arreglar este como el de arriba negando el if
                        for (int i = seri; i < arrayDatosSeries.size() - 1; i++) {
                            int clave = this.utilities.evaluarArrayIntOClaveo((ArrayList) arrayDatosSeries.get(arrayDatosSeries.size() - 1), i);
                            if (clave != 0) {
                                if (!this.ctrlSeries.getArrayMapSeries().get(clave).isEjePrincipal()) {
                                    grafica.cargarArrayValoresY((ArrayList) arrayDatosSeries.get(i), this.ctrlSeries.getArrayMapSeries().get(clave).getNombreSerie());
                                    hayDataSecundario = 1;
                                }
                            }
                        }
                        if (hayDataSecundario == 1) {
                            grafica.actualizarDatosGrafica(grafica.EJE_SECUNDARIO);
                            grafica.limpiarArrayDatos();
                            hayDataSecundario=0;
                        }

                    }
                }
            }

            //plotear la grafica
            grafica.construirGrafica(null, this.ctrlSeries.getTituloEjePrincipal(), this.ctrlSeries.getTituloEjeSecundario(), "tiempo", isEjePrincipal);
            frmGraficas.panelGraficas.removeAll();
            frmGraficas.panelGraficas.add(grafica.obtienepanel(), BorderLayout.CENTER);
            frmGraficas.panelGraficas.validate();
            this.frmGraficas.btnSeriesPrincipal.setEnabled(false);
            this.frmGraficas.btnSeriesSecundario.setEnabled(false);

        }

        //-----EjePrincipal-----
        if (e.getSource() == frmGraficas.btnSeriesPrincipal) {
            try {
                // cargar datos al modelo si es necesario(cajas de texto etc...)
                ctrlSeries.iniciar(SeriesGrafica.EJE_PRINCIPAL);
                this.verificarEje();
                this.habilitarBtnGraficar();
            } catch (PropertyVetoException ex) {
                Logger.getLogger(CtrlOperacionTk.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        //-----EjeSecundario-----
        if (e.getSource() == frmGraficas.btnSeriesSecundario) {
            try {
                // cargar datos al modelo si es necesario(cajas de texto etc...)
                ctrlSeries.iniciar(SeriesGrafica.EJE_SECUNDARIO);
                this.verificarEje();
                this.habilitarBtnGraficar();
            } catch (PropertyVetoException ex) {
                Logger.getLogger(CtrlOperacionTk.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //-----Reset-----
        if (e.getSource() == frmGraficas.btnReset) {
            this.ctrlSeries.reset();
            this.ctrlSeries.frmSeries.hide();
            this.frmGraficas.btnSeriesPrincipal.setEnabled(true);
            this.frmGraficas.btnSeriesSecundario.setEnabled(true);
            this.habilitarBtnGraficar();
        }

        //-----Exportar-----
        if (e.getSource() == frmGraficas.btnExportar) {
            final int USARKEYMAP = 1;
            final int USARTODO = 0;
            int seleccion = JOptionPane.showOptionDialog(null, "seleccione los datos", "Datos", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Todos los datos", "Datos seleccionados"}, "Datos seleccionados");
            ArrayList arrayDatosSeries = null;
            switch (seleccion) {
                case USARTODO:
                    int tipo = JOptionPane.showOptionDialog(null, "presentación los datos", "Datos", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"promedio X día", "Todos"}, "promedio X día");
                    arrayDatosSeries = new ArrayList(this.cargarInformacionArraysExportar(tipo));
                    break;
                case USARKEYMAP:
                    arrayDatosSeries = new ArrayList(this.cargarInformacionArraysGraficas());
                    break;
            }
            if (arrayDatosSeries != null) {
                try {
                    writeExcel(arrayDatosSeries, seleccion,"exportDataGraph");
                } catch (Exception ex) {
                    Logger.getLogger(CtrlGraficas.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Error al exportar");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay datos para exportar");
            }
        }

        //--------------rdbtn-------------------
        if (e.getSource() == frmGraficas.rdbtnRangoFecha) {
            if (frmGraficas.rdbtnRangoFecha.isSelected()) {
                frmGraficas.dtchFechaFinal.setVisible(true);
                frmGraficas.lblFechaFinal.setVisible(true);
                frmGraficas.lblFechaInicial.setText("Fecha Inicial:");
            }
        }
        if (e.getSource() == frmGraficas.rdbtnDia) {
            if (frmGraficas.rdbtnDia.isSelected()) {
                frmGraficas.dtchFechaFinal.setVisible(false);
                frmGraficas.lblFechaFinal.setVisible(false);
                frmGraficas.lblFechaInicial.setText("Fecha:");
            }
        }
    }

    

    public void habilitarBtnGraficar() {

        if (this.ctrlSeries.getArrayMapSeries().size() > 1) {
            if (frmGraficas.rdbtnRangoFecha.isSelected()) {
                if (frmGraficas.dtchFechaInicial.getDate() != null && frmGraficas.dtchFechaFinal.getDate() != null && frmGraficas.dtchFechaFinal.getDate().getTime()>frmGraficas.dtchFechaInicial.getDate().getTime()) {
                    frmGraficas.btnGraficar.setEnabled(true);
                    frmGraficas.btnExportar.setEnabled(true);
                } else {
                    frmGraficas.btnGraficar.setEnabled(false);
                    frmGraficas.btnExportar.setEnabled(false);
                }
            } else {
                if (frmGraficas.dtchFechaInicial.getDate() != null) {
                    frmGraficas.btnGraficar.setEnabled(true);
                    frmGraficas.btnExportar.setEnabled(true);
                } else {
                    frmGraficas.btnGraficar.setEnabled(false);
                    frmGraficas.btnExportar.setEnabled(false);
                }
            }
        } else {
            frmGraficas.btnGraficar.setEnabled(false);
            frmGraficas.btnExportar.setEnabled(false);
        }
    }

    public void verificarEje() {

        Iterator it = this.ctrlSeries.getArrayMapSeries().keySet().iterator();
        while (it.hasNext()) {
            Integer key = (Integer) it.next();
            if (this.ctrlSeries.getArrayMapSeries().get(key).isEjePrincipal()) {
                isEjePrincipal = grafica.EJE_PRINCIPAL;
            } else {
                isEjePrincipal = grafica.EJE_SECUNDARIO;
                break;
            }
        }
    }

    public ArrayList cargarInformacionArraysGraficas() {
        String valcmbx;
        valcmbx = frmGraficas.cmbxIdPozo.getSelectedItem().toString();
        Date fechaInicialcmbx;
        Date fechaFinalcmbx = null;
        fechaInicialcmbx = new Date(frmGraficas.dtchFechaInicial.getDate().getTime());
        ArrayList arrayDatosSeries = new ArrayList();
        try {
            if (frmGraficas.rdbtnRangoFecha.isSelected()) {
                fechaFinalcmbx = new Date(frmGraficas.dtchFechaFinal.getDate().getTime());
                this.ctrlSeries.getArrayMapSeries().put(0, new SeriesGrafica("fecha", "fecha", this.grafica.EJE_PRINCIPAL));
                arrayDatosSeries = graficaC.buscarArrayPromedioProcesoXRangoFechas(valcmbx, this.ctrlSeries.getArrayMapSeries(), fechaInicialcmbx, fechaFinalcmbx, 0);
            } else {
                this.ctrlSeries.getArrayMapSeries().put(0, new SeriesGrafica("hora", "hora", this.grafica.EJE_PRINCIPAL));
                arrayDatosSeries = graficaC.buscarArrayPromedioProcesoXRangoFechas(valcmbx, this.ctrlSeries.getArrayMapSeries(), fechaInicialcmbx, fechaFinalcmbx, 1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlBalance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayDatosSeries;
    }

    public void writeExcel(ArrayList arrayDatosExport, int usarMap,String defaultTitle) throws Exception {
        String ruta = this.utilities.seleccionarArchivoSalida("Archivos Excel (.xlsx)", "xlsx",defaultTitle);
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(0, "Hoja excel");

        ArrayList<String> headers = new ArrayList<>();
        if (usarMap == 1) {
            for (int i = 0; i < arrayDatosExport.size() - 1; i++) {
                int clave = this.utilities.evaluarArrayIntOClaveo((ArrayList) arrayDatosExport.get(arrayDatosExport.size() - 1), i);
                headers.add(this.ctrlSeries.getArrayMapSeries().get(clave).getNombreSerie());
            }
        } else {
            for (int i = 0; i < arrayDatosExport.size() - 1; i++) {
                String titulo = this.utilities.evaluarArrayString((ArrayList) arrayDatosExport.get(arrayDatosExport.size() - 1), i);
                headers.add(titulo);
            }
        }

        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        headerStyle.setFont(font);

        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.size(); ++i) {
            String header = headers.get(i);
            Cell cell = headerRow.createCell(i);
            cell.setCellStyle(headerStyle);
            cell.setCellValue(header);
        }

        //for para filas
        for (int j = 0; j < this.utilities.evaluarArrayInterno(arrayDatosExport, 0).size(); j++) {
            Row dataRow = sheet.createRow(j + 1);
            //for para columnas
            for (int i = 0; i < arrayDatosExport.size() - 1; ++i) {
                if (j <= this.utilities.evaluarArrayInterno(arrayDatosExport, i).size() - 1) {
                    if ("fecha".equals(headers.get(i)) || "hora".equals(headers.get(i)) || "idPozo".equals(headers.get(i))) {
                        Cell cell=dataRow.createCell(i);
                        cell.setCellValue((String) this.utilities.evaluarArrayInterno(arrayDatosExport, i).get(j).toString());
                        cell.setCellStyle(style);
                        
                    } else {
                        dataRow.createCell(i).setCellValue((double) this.utilities.evaluarArrayInterno(arrayDatosExport, i).get(j));
                    }
                }
            }

        }
        //        agregar formulas
//        HSSFRow dataRow = sheet.createRow(1 + arrayDatosSeries.size());
//        HSSFCell total = dataRow.createCell(1);
//        total.setCellType(CellType.FORMULA);
//        total.setCellStyle(style);
//        total.setCellFormula(String.format("SUM(B2:B%d)", 1 + arrayDatosSeries.size()));
        cambiarAutorMetadataPoi(workbook);
        try (FileOutputStream file = new FileOutputStream(ruta)) {
            workbook.write(file);
            file.close();
            JOptionPane.showMessageDialog(null, "Datos exportados");
        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, "error al exportar");
            System.out.println("error al exportar: "+ fileNotFoundException);
        }
    }

    

    public void cambiarAutorMetadataPoi(XSSFWorkbook workbook) throws IOException {
        XSSFExcelExtractor xmltext = new XSSFExcelExtractor(workbook);
        xmltext.getCoreProperties().setCreator("Controwell");

    }

    public ArrayList cargarInformacionArraysExportar(int tipo) {
        String valcmbx;
        valcmbx = frmGraficas.cmbxIdPozo.getSelectedItem().toString();
        Date fechaInicialcmbx;
        Date fechaFinalcmbx = null;
        fechaInicialcmbx = new Date(frmGraficas.dtchFechaInicial.getDate().getTime());
        ArrayList arrayDatosExportar = new ArrayList();
        try {
            if (frmGraficas.rdbtnRangoFecha.isSelected()) {
                fechaFinalcmbx = new Date(frmGraficas.dtchFechaFinal.getDate().getTime());
                arrayDatosExportar = graficaC.buscarTodosProcesoXFecha(valcmbx, fechaInicialcmbx, fechaFinalcmbx, tipo,true);
            } else {
                arrayDatosExportar = graficaC.buscarTodosProcesoXFecha(valcmbx, fechaInicialcmbx, fechaFinalcmbx, 2,true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlBalance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayDatosExportar;
    }
}
