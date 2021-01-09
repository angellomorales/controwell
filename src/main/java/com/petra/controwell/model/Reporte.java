package com.petra.controwell.model;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.PdfException;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfDocumentInfo;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfVersion;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.WriterProperties;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.ColumnDocumentRenderer;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.DottedBorder;
import com.itextpdf.layout.borders.RoundDotsBorder;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.VerticalAlignment;
import com.petra.controwell.control.internal.CtrlReporte;
import com.petra.controwell.model.utilities.Utilities;
import com.petra.controwell.model.utilities.document.DocumentHeader;
import com.petra.controwell.model.utilities.document.DocumentSignature;
import com.petra.controwell.model.utilities.document.RoundedCornersCell;
import com.petra.controwell.view.internal.FrmReporte;

import static com.itextpdf.layout.borders.Border.ROUND_DOTS;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.jfree.chart.JFreeChart;

/**
 *
 * @author Angello Morales
 */
//http://codigoxules.org/java-itext-pdf-creando-pdf-java-itext/
//https://itextpdf.com/en/resources/books/itext-7-jump-start-tutorial-java/intro
//http://codigoxules.org/java-jtable-importar-contenido-carpeta-exportar-pdf/
public class Reporte {

	// controlador
	public Utilities utilities;
	public CtrlReporte ctrlReporte;

	// definicion de stylos
//	private Style paragraphStyle = new Style();
//	private Style tableHeaderStyle = new Style();
//	private Style tableContentStyle = new Style();

	// path de imagenes
	private static final String imageLogo = "./src/main/resources/img/ico.png";
	// variables

	public Reporte(CtrlReporte ctrlReporte) throws IOException {
		// configuracion de estilos
//		this.editarStyle(paragraphStyle, StandardFonts.HELVETICA, 12);
//		this.editarStyle(tableHeaderStyle, StandardFonts.HELVETICA_BOLD, 14);
//		this.editarStyle(tableContentStyle, StandardFonts.HELVETICA, 10);
		utilities = new Utilities();
		this.ctrlReporte = ctrlReporte;

	}

	public void createPDF(File pdfNewFile, Date fecha) throws SQLException {
		try {
			// creacion de documento con metadata y fichero
			WriterProperties properties = new WriterProperties();
			properties.addXmpMetadata();
			properties.setPdfVersion(PdfVersion.PDF_1_6);
			PdfWriter writer = new PdfWriter(new FileOutputStream(pdfNewFile), properties);
			PdfDocument pdf = new PdfDocument(writer);
			pdf.addEventHandler(PdfDocumentEvent.START_PAGE, new DocumentHeader(this.documentHeader(fecha)));
			DocumentSignature event = new DocumentSignature(pdf);
			pdf.addEventHandler(PdfDocumentEvent.END_PAGE, event);
			PageSize ps = PageSize.LETTER.rotate();
			editarMetadata(pdf, utilities.getFechaActual());
			try (Document document = new Document(pdf, ps);) {

				documentLayout(document, pdf);
//
//				// agrega bloques de contenido
//				document.add(agregarTabladesdeModelo(this.ObjetoPruebaJtableModel()));
//				// basico para un parrafo
//				//document.add(new Paragraph("Hello World!").addStyle(paragraphStyle));
//				document.add(this.insertarGrafica(pdf, this.ObjetoJFreeChartPruebas()));
//				PARA NUMERO DE PAGINAS
//				document.add(new Div());
//				event.writeTotal(pdf);
				document.close();
			}
			JOptionPane.showMessageDialog(null, "se ha generado el reporte del dia " + fecha);
		} catch (FileNotFoundException | PdfException fileNotFoundException) {
			System.err.println(
					"The file not exists (Se ha producido un error al generar un documento): " + fileNotFoundException);
			JOptionPane.showMessageDialog(null, "Se ha producido un error al generar un documento");
		} catch (IOException iOException) {
			System.err.println("error en la grafica: " + iOException);
		}

	}

	public Style editarStyle(PdfFont font, float size) throws IOException {
		Style style = new Style();
		style.setFont(font).setFontSize(size);
		return style;
	}

	public void editarMetadata(PdfDocument pdf, Date fecha) {
		PdfDocumentInfo info = pdf.getDocumentInfo();
		info.setTitle("Reporte de Producción del dia " + fecha);
		info.setAuthor("ControWell");
		info.setSubject("Operadora xxx");
		info.setKeywords("Producción");
		info.setCreator("Petra");
	}

	public Table agregarTabladesdeModelo(TableModel modelo) throws IOException {
		PdfFont headerFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
		float headerSize = 10;
		Style tableHeaderStyle = editarStyle(headerFont, headerSize);
		PdfFont contentFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);
		float contentSize = 9;
		Style tableContentStyle = editarStyle(contentFont, contentSize);
		Table table = new Table(modelo.getColumnCount());
		Border border = new SolidBorder(1.2f);
		table.setWidth(UnitValue.createPercentValue(80));
		table.setHorizontalAlignment(HorizontalAlignment.CENTER);
		for (int row = 0; row < modelo.getRowCount(); row++) {
			for (int column = 0; column < modelo.getColumnCount(); column++) {
				if (row == 0) {
					table.addHeaderCell(getTextCell(1, 1, modelo.getColumnName(column), TextAlignment.CENTER,
							tableHeaderStyle, border));
					table.addCell(getTextCell(1, 1, modelo.getValueAt(row, column).toString(), TextAlignment.CENTER,
							tableContentStyle, border));
				} else {
					table.addCell(getTextCell(1, 1, modelo.getValueAt(row, column).toString(), TextAlignment.CENTER,
							tableContentStyle, border));
				}
			}
		}
		return table;
	}

	public Image insertarGrafica(PdfDocument PDFdondeAlmacena, JFreeChart chart) throws IOException {
		PdfReader reader = new PdfReader(new ByteArrayInputStream(generateORSONChartPDF(chart)));
		PdfDocument chartDoc = new PdfDocument(reader);
		PdfFormXObject chartPDF = chartDoc.getFirstPage().copyAsFormXObject(PDFdondeAlmacena);
		Image chartImage = new Image(chartPDF);
		chartImage.setAutoScale(true);
		return chartImage;
	}

	private byte[] generateORSONChartPDF(JFreeChart chart) {
		// here we use OrsonPDF to generate PDF in a byte array
		com.orsonpdf.PDFDocument doc = new com.orsonpdf.PDFDocument();
		java.awt.Rectangle bounds = new java.awt.Rectangle(500, 335);
		com.orsonpdf.Page page = doc.createPage(bounds);
		com.orsonpdf.PDFGraphics2D g2 = page.getGraphics2D();
		chart.draw(g2, bounds);
		return doc.getPDFBytes();
	}

	public void documentLayout(Document document, PdfDocument pdf) throws IOException, SQLException {
		document.setMargins(70, 30, 60, 30);
		// content
		document.add(documentContent(pdf));
		// footer

	}

	public Table documentHeader(Date fecha) throws IOException {
		Style textStyle;
		PdfFont contentFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
		float contentSize = 20;
		textStyle = editarStyle(contentFont, contentSize);
		Table tableHeaderLayout = new Table(2);
		String texto = "REPORTE DE PRODUCCION DEL DIA " + fecha.toString();
		Image logo = new Image(ImageDataFactory.create(Reporte.imageLogo));
		logo.setHorizontalAlignment(HorizontalAlignment.CENTER);
		logo.setHeight(20);
		logo.setAutoScaleWidth(true);
		
		tableHeaderLayout.setWidth(UnitValue.createPercentValue(100));
		tableHeaderLayout.setHorizontalAlignment(HorizontalAlignment.CENTER);
		tableHeaderLayout.addCell(getTextCell(1, 1, texto, TextAlignment.CENTER, textStyle, Border.NO_BORDER));
		tableHeaderLayout.addCell(getGroupImageCell(1, 1, "", logo));
		// agregar fecha encabezado e imagen
		return tableHeaderLayout;
	}

	public Table documentContent(PdfDocument pdf) throws IOException, SQLException {

		Table tableContentLayout = new Table(2);
//		tableLayout.setBorder(new SolidBorder(1));
		tableContentLayout.setWidth(UnitValue.createPercentValue(100));
		tableContentLayout.setHorizontalAlignment(HorizontalAlignment.CENTER);
		
		tableContentLayout.addCell(
				getGroupTableCell(1, 1, "Inventario Inicial", ctrlReporte.frmReporte.tbInventarioInicial.getModel()));
		tableContentLayout.addCell(
				getGroupTableCell(1, 1, "Inventario Final", ctrlReporte.frmReporte.tbInventarioFinal.getModel()));
		tableContentLayout
				.addCell(getGroupTableCell(1, 1, "Producción", ctrlReporte.frmReporte.tbProduccion.getModel()));
		tableContentLayout.addCell(getGroupTableCell(1, 1, "Despachos", ctrlReporte.frmReporte.tbDespachos.getModel()));
		tableContentLayout
				.addCell(getGroupTableCell(1, 2, "Laboratorio", ctrlReporte.frmReporte.tbLaboratorio.getModel()));
		tableContentLayout
				.addCell(getGroupTableCell(1, 1, "Proceso", ctrlReporte.frmReporte.tbVariablesProceso.getModel()));
		tableContentLayout.addCell(getGroupTableCell(1, 1, "Variador", ctrlReporte.frmReporte.tbVariador.getModel()));
		tableContentLayout.addCell(getGroupImageCell(2, 1, "",
				insertarGrafica(pdf, ctrlReporte.graficarAcumulados(ctrlReporte.frmReporte.dtchFecha.getCalendar()))));
		tableContentLayout.addCell(getGroupTableCell(1, 1, "Capacidad", ctrlReporte.frmReporte.tbCapacidad.getModel()));
		tableContentLayout.addCell(getTextCell(1, 1,
				" COMENTARIOS:\n" + ctrlReporte.frmReporte.txtComentarios.getText(), TextAlignment.LEFT, null, null));
		return tableContentLayout;
	}

	public Cell getTextCell(int filasCombinar, int columnasCombinar, String texto, TextAlignment textAlignment,
			Style textStyle, Border border) throws IOException {
		Style paragraphStyle;
		Cell cell;
		if (border == null) {
			cell = new RoundedCornersCell(filasCombinar, columnasCombinar);
			cell.setBorder(Border.NO_BORDER);
		} else {
			cell = new Cell(filasCombinar, columnasCombinar);
			cell.setBorder(border);
		}
		if (textStyle == null) {
			PdfFont contentFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);
			float contentSize = 10;
			paragraphStyle = editarStyle(contentFont, contentSize);
		} else {
			paragraphStyle = textStyle;
		}
		cell.add(new Paragraph(texto).addStyle(paragraphStyle));
		cell.setPadding(2);
		cell.setTextAlignment(textAlignment);
		cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		return cell;
	}

	public Cell getGroupTableCell(int filasCombinar, int columnasCombinar, String titulo, TableModel tabla)
			throws IOException {
		PdfFont contentFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
		float contentSize = 10;
		Style paragraphStyle = editarStyle(contentFont, contentSize);
		Cell cell = new RoundedCornersCell(filasCombinar, columnasCombinar);

		if (tabla.getRowCount() > 0) {
			cell.add(new Paragraph(titulo).addStyle(paragraphStyle));
			cell.add(agregarTabladesdeModelo(tabla));
		}
		cell.setPadding(5);
		cell.setTextAlignment(TextAlignment.CENTER);
		cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		cell.setBorder(Border.NO_BORDER);
		return cell;
	}

	public Cell getGroupImageCell(int filasCombinar, int columnasCombinar, String titulo, Image imagen)
			throws IOException {
		PdfFont contentFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
		float contentSize = 10;
		Style paragraphStyle = editarStyle(contentFont, contentSize);
		Cell cell = new RoundedCornersCell(filasCombinar, columnasCombinar);
		cell.add(new Paragraph(titulo).addStyle(paragraphStyle));
		cell.add(imagen);
		cell.setPadding(5);
		cell.setTextAlignment(TextAlignment.CENTER);
		cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
//		cell.setBorder(new SolidBorder(1.5f));
		cell.setBorder(Border.NO_BORDER);
		return cell;
	}

//-----------------borrar cuando finalice los objetos de prueba-----------------------------------
	public DefaultTableModel ObjetoPruebaJtableModel() {

		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new Object[] { "Tanque", "Recibo", "Entrega", "ado2" });
		modelo.addRow(new Object[] { 1, 2, 3, 11 });
		modelo.addRow(new Object[] { 4, 5, 6, 13 });
		modelo.addRow(new Object[] { 7, 8, 9, 14 });
		return modelo;
	}

	public JFreeChart ObjetoJFreeChartPruebas() {
		Graficas grafica = new Graficas();
		Double valoresX[] = { 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0 };
		ArrayList<Double> arrayValoresX = new ArrayList<Double>();
		ArrayList<Double> series1 = new ArrayList<Double>();
		ArrayList<Double> series2 = new ArrayList<Double>();
		for (Double i : valoresX) {
			arrayValoresX.add(i);
			series1.add(Math.pow(i, 2));
			series2.add(Math.exp(i));
		}

		grafica.setTipoGrafica(grafica.LINEAL);
		grafica.setArrayValoresX((ArrayList) arrayValoresX);
		grafica.cargarArrayValoresY(series1, "x^2");
		grafica.cargarArrayValoresY(series2, "e^x");
		grafica.actualizarDatosGrafica(grafica.EJE_PRINCIPAL);
		grafica.construirGrafica("grafica Prueba", "valores Y", "Valores Y2", "valores x", grafica.EJE_PRINCIPAL);

		return grafica.getGrafica();

	}

}
