package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachment;filename:ShipmentType.pdf");
		Paragraph p = new Paragraph("ShipmentTypePdf Data In Pdf Format");
		document.add(p);

		@SuppressWarnings("unchecked")
		List<ShipmentType> list = (List<ShipmentType>) model.get("stype");

		PdfPTable t = new PdfPTable(6);
		t.addCell("ID");
		t.addCell("Mode");
		t.addCell("CODE");
		t.addCell("ENABLED");
		t.addCell("GRADE");
		t.addCell("DESCRIPTION");

		for (ShipmentType stype : list) {
			t.addCell(stype.getShipId().toString());
			t.addCell(stype.getShipMode());
			t.addCell(stype.getShipCode());
			t.addCell(stype.getShipEnabled());
			t.addCell(stype.getShipGrade());
			t.addCell(stype.getShipDsc());

		}

	}
}
