package com.petra.controwell.model.utilities.document;

import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.element.Table;

public class DocumentHeader implements IEventHandler {
	Table header;
	private float marginLeftRigth = 20f;
	private float marginTop = 20f;

	public DocumentHeader(Table header) {
		this.header = header;
	}

	@Override
	public void handleEvent(Event event) {
		PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
		PdfDocument pdf = docEvent.getDocument();
		PdfPage page = docEvent.getPage();
		Rectangle pageSize = page.getPageSize();
		Rectangle area = new Rectangle(marginLeftRigth, marginTop * (-1), pageSize.getWidth() - 2 * marginLeftRigth,
				pageSize.getHeight());
		PdfCanvas pdfCanvas = new PdfCanvas(page.getLastContentStream(), page.getResources(), pdf);
		try (Canvas canvas = new Canvas(pdfCanvas, area)) {
			canvas.add(header);
		}
	}

}
