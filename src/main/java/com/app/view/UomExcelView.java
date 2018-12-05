package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Uom;

public class UomExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// File Name change as well as Download Excel
		response.addHeader("Content-Disposition","attachment;filename=Uoms.xlsx");
		// Create Sheet With Name
		Sheet sheet = workbook.createSheet("uom");

		// Create Head
		setHead(sheet);

		// Read Data
		@SuppressWarnings("unchecked")
		List<Uom> uoms = (List<Uom>) model.get("uom");

		// set Body
		setBody(sheet, uoms);

	}

	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);

		row.createCell(0).setCellValue("Uom ID");
		row.createCell(1).setCellValue("Uom Type");
		row.createCell(2).setCellValue("Uom Model");
		row.createCell(3).setCellValue("Uom Description");
	}

	private void setBody(Sheet sheet, List<Uom> uoms) {
		int rowNum = 1;
		for (Uom u : uoms) {
			Row row = sheet.createRow(rowNum++);

			row.createCell(0).setCellValue(u.getUomId());
			row.createCell(1).setCellValue(u.getUomType());
			row.createCell(2).setCellValue(u.getUomModel());
			row.createCell(3).setCellValue(u.getUomDsc());
		}

	}
}
