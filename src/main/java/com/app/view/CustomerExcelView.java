package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Customer;

public class CustomerExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// Change File Name and download excel file
		response.addHeader("Content-Disposition", "attachment;filename:Cusomers.xlsx");

		// Create Sheet with name
		Sheet sheet = workbook.createSheet("cust");
		// set Head
		setHead(sheet);

		// Read the data
		@SuppressWarnings("unchecked")
		List<Customer> list = (List<Customer>) model.get("cust");

		// setBody
		setBody(sheet, list);
	}

	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Customer Code");
		row.createCell(2).setCellValue("Address");
		row.createCell(3).setCellValue("Location");
		row.createCell(4).setCellValue("Enabled");
		row.createCell(5).setCellValue("Email");
		row.createCell(6).setCellValue("Contact");
	}

	private void setBody(Sheet sheet, List<Customer> list) {
		int rowNum = 1;
		for (Customer c : list) {
			Row row = sheet.createRow(rowNum++);

			row.createCell(0).setCellValue(c.getCustId());
			row.createCell(1).setCellValue(c.getCustCode());
			row.createCell(2).setCellValue(c.getCustAddress());
			row.createCell(3).setCellValue(c.getCustLocs());
			row.createCell(4).setCellValue(c.getCustEnabled());
			row.createCell(5).setCellValue(c.getCustEmail());
			row.createCell(6).setCellValue(c.getCustContact());
		}
	}
}
