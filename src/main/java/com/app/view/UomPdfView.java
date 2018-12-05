package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Uom;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UomPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachment;filename:Uoms.pdf");

		Paragraph p = new Paragraph("UomPdf Data In Pdf Format");
		document.add(p);

		@SuppressWarnings("unchecked")
		List<Uom> list = (List<Uom>) model.get("uom");

		PdfPTable t = new PdfPTable(6);
		t.addCell("ID");
		t.addCell("TYPE");
		t.addCell("Model");
		t.addCell("DESCRIPTION");

		for (Uom uom : list) {
			t.addCell(uom.getUomId().toString());
			t.addCell(uom.getUomType());
			t.addCell(uom.getUomModel());
			t.addCell(uom.getUomDsc());

		}

	}

}
