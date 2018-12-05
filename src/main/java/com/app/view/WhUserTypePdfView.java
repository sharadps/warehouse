package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.WhUserType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhUserTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.addHeader("Content-Disposition", "attachment;filename:WhUserTypePdfs.pdf");

		Paragraph p = new Paragraph("WhUserTypePdf Data In Pdf Format");
		document.add(p);

		@SuppressWarnings("unchecked")
		List<WhUserType> list = (List<WhUserType>) model.get("whty");

		PdfPTable t = new PdfPTable(6);
		t.addCell("ID");
		t.addCell("TYPE");
		t.addCell("CODE");
		t.addCell("FOR TYPE");
		t.addCell("EMAIL");
		t.addCell("CONTACT");
		t.addCell("ID TYPE");
		t.addCell("IF OTHER");
		t.addCell("ID NUMBER");

		for (WhUserType w : list) {
			t.addCell(w.getWhId().toString());
			t.addCell(w.getWhType());
			t.addCell(w.getWhCode());
			t.addCell(w.getWhForType());
			t.addCell(w.getWhEmail());
			t.addCell(w.getWhContact());
			t.addCell(w.getWhIdType());
			t.addCell(w.getWhIfOther());
			t.addCell(w.getWhIdNumber());
		}

	}

}
