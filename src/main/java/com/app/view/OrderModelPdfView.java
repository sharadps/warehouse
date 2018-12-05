package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.OrderModel;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrderModelPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// filename change
		response.addHeader("Content-Disposition", "attachment;filename:OrderModel.pdf");
		Paragraph p = new Paragraph("OrderModelPdf Data In Pdf Format");
		document.add(p);

		@SuppressWarnings("unchecked")
		List<OrderModel> list = (List<OrderModel>) model.get("om");

		PdfPTable t = new PdfPTable(6);
		t.addCell("ID");
		t.addCell("Model");
		t.addCell("CODE");
		t.addCell("METHOD");
		t.addCell("ACCEPT");
		t.addCell("DESCRIPTION");

		for (OrderModel om : list) {
			t.addCell(om.getOmId().toString());
			t.addCell(om.getOmModel());
			t.addCell(om.getOmCode());
			t.addCell(om.getOmMethod());
			t.addCell(om.getOmAcceptt().toString());
			t.addCell(om.getOmDsc());

		}

	}

}
