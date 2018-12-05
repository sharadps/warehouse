package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Item;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ItemPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", "attachment;filename:Item.pdf");

		Paragraph p = new Paragraph("Item Data Pdf View");

		// Paragraph add to document
		document.add(p);

		// read the data
		@SuppressWarnings("unchecked")
		List<Item> list = (List<Item>) model.get("item");

		// add the data in table format

		PdfPTable t = new PdfPTable(5);
		t.addCell("ID");
		t.addCell("CODE");
		t.addCell("WIDTH");
		t.addCell("LENGTH");
		t.addCell("HEIGHT");
		t.addCell("BASE COST");
		t.addCell("CURRENCY");

		for (Item item : list) {

			t.addCell(item.getiId().toString());
			t.addCell(item.getItemCode());
			t.addCell(item.getiWidth());
			t.addCell(item.getiLength());
			t.addCell(item.getiHeight());
			t.addCell(item.getiBaseCost());
			t.addCell(item.getiCurrency());
		}

	}

}
