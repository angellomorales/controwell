package com.petra.controwell.model.utilities.document;

import java.io.IOException;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import java.lang.System;

public class DocumentSignature implements IEventHandler {
	protected PdfFormXObject placeholder;
	protected float side = 20;
	protected float x = 150;
	protected float y = 15;
	protected float space = 10f;
	protected float descent = 3;

	public DocumentSignature(PdfDocument pdf) {
		placeholder = new PdfFormXObject(new Rectangle(0, 0, side, side));
	}

	@Override
	public void handleEvent(Event event) {

		PdfFont font = null;
			try {
				font = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
		PdfDocument pdf = docEvent.getDocument();
		PdfPage page = docEvent.getPage();
//		int pageNumber = pdf.getPageNumber(page);
		String myUnicodeSymbol = "\u00A9";
		Rectangle pageSize = page.getPageSize();
		PdfCanvas pdfCanvas = new PdfCanvas(page.getLastContentStream(), page.getResources(), pdf);
		try (Canvas canvas = new Canvas(pdfCanvas,pageSize)) {
//			Paragraph p = new Paragraph().add("Page ").add(String.valueOf(pageNumber)).add(" of");
			Paragraph p = new Paragraph().add("Desarrollado por PETRA SERVICES "+myUnicodeSymbol).setFont(font).setFontSize(8f);
			canvas.showTextAligned(p, x, y, TextAlignment.RIGHT);
		}
		pdfCanvas.addXObject(placeholder, x + space, y - descent);
		pdfCanvas.release();

	}

	public void writeTotal(PdfDocument pdf) {
		try (Canvas canvas = new Canvas(placeholder, pdf)) {
			canvas.showTextAligned(String.valueOf(pdf.getNumberOfPages()), 0, descent, TextAlignment.LEFT);
		}
	}

}
