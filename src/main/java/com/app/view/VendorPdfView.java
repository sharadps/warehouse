package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Vendor;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class VendorPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		response.addHeader("Content-Disposition", "attachment;filename:Vendors.pdf");

		Paragraph p = new Paragraph("Vendors Data In Pdf Format");
		document.add(p);

		@SuppressWarnings("unchecked")
		List<Vendor> list = (List<Vendor>) model.get("vendor");

		PdfPTable t = new PdfPTable(6);
		t.addCell("ID");
		t.addCell("NAME");
		t.addCell("CODE");
		t.addCell("DESIGNATION");
		t.addCell("PRESERVE");

		for (Vendor v : list) {
			t.addCell(v.getVenId().toString());
			t.addCell(v.getVenName());
			t.addCell(v.getVenCode());
			t.addCell(v.getVenDesg());
			t.addCell(v.getVenPreserve().toString());
		}

	}

}
