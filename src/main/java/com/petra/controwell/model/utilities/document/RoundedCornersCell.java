package com.petra.controwell.model.utilities.document;

import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.renderer.CellRenderer;
import com.itextpdf.layout.renderer.DrawContext;
import com.itextpdf.layout.renderer.IRenderer;

public class RoundedCornersCell extends Cell {
	public RoundedCornersCell() {
		super();
	}

	public RoundedCornersCell(int rowspan, int colspan) {
		super(rowspan, colspan);
	}

	@Override
	protected IRenderer makeNewRenderer() {
		return new RoundedCornersCellRenderer(this);
	}
 }

class RoundedCornersCellRenderer extends CellRenderer {

	public RoundedCornersCellRenderer(Cell modelElement) {
		super(modelElement);
	}

	@Override
	public void drawBorder(DrawContext drawContext) {
		Rectangle occupiedAreaBBox = getOccupiedAreaBBox();
		UnitValue[] margins = getMargins();
		Rectangle rectangle = applyMargins(occupiedAreaBBox, margins, false);
		PdfCanvas canvas = drawContext.getCanvas();
		canvas.roundRectangle(rectangle.getX() + 1, rectangle.getY() + 1, rectangle.getWidth() - 2,
				rectangle.getHeight() - 2, 5).stroke();
		super.drawBorder(drawContext);
	}

}