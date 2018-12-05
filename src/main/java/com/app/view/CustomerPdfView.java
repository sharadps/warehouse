package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Customer;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class CustomerPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		// filename change
		response.addHeader("Content-Disposition", "attachment;filename:Customers.pdf");

		// create one Paragraph
		Paragraph p = new Paragraph("Customer Data In Pdf Format");
		// add Paragraph in document file
		document.add(p);

		// reads the data form database table
		@SuppressWarnings("unchecked")
		List<Customer> list = (List<Customer>) model.get("cust");

		PdfPTable t = new PdfPTable(6);

		t.addCell("ID");
		t.addCell("CODE");
		t.addCell("ADDRESS");
		t.addCell("LOCATION");
		t.addCell("ENABLED");
		t.addCell("EMAIL");
		t.addCell("CONTACT");
		
		for (Customer c : list) {
			t.addCell(c.getCustId().toString());
			t.addCell(c.getCustCode());
			t.addCell(c.getCustAddress());
			t.addCell(c.getCustLocs());
			t.addCell(c.getCustEnabled());
			t.addCell(c.getCustEmail());
			t.addCell(c.getCustContact());
		}
	}

}
