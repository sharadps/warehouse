package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Vendor;

public class VendorExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// file name change
		response.addHeader("Content-Disposition", "attachment;filename:Vendor.xlsx");

		// create sheet with name
		Sheet sheet = workbook.createSheet("vendor");

		// set Head
		setHead(sheet);

		// read data form database
		@SuppressWarnings("unchecked")
		List<Vendor> list = (List<Vendor>) model.get("vendor");

		// set body
		setBody(sheet, list);

	}

	private void setHead(Sheet sheet) {

		Row row = sheet.createRow(0);

		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Vendor Name");
		row.createCell(2).setCellValue("Vendor Code");
		row.createCell(3).setCellValue("Vendor Designation");
		row.createCell(4).setCellValue("Preserve");

	}

	private void setBody(Sheet sheet, List<Vendor> list) {

		int rowNum = 1;
		for (Vendor vendor : list) {
			Row row = sheet.createRow(rowNum++);

			row.createCell(0).setCellValue(vendor.getVenId());
			row.createCell(1).setCellValue(vendor.getVenName());
			row.createCell(2).setCellValue(vendor.getVenCode());
			row.createCell(3).setCellValue(vendor.getVenDesg());
			row.createCell(4).setCellValue(vendor.getVenPreserve().toString());

		}
	}

}
