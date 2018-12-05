package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// file name change
		response.addHeader("Content-Disposition", "attachment;filename:WhUserTypes.xlsx");

		// create sheet with name
		Sheet sheet = workbook.createSheet("whty");

		// set Head
		setHead(sheet);

		// read data form database
		@SuppressWarnings("unchecked")
		List<WhUserType> list = (List<WhUserType>) model.get("whty");

		// set body
		setBody(sheet, list);

	}

	private void setHead(Sheet sheet) {

		Row row = sheet.createRow(0);

		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("User Type");
		row.createCell(2).setCellValue("User Code");
		row.createCell(3).setCellValue("Users For");
		row.createCell(4).setCellValue("User Email");
		row.createCell(5).setCellValue("User Contact");
		row.createCell(6).setCellValue("User Id Type");
		row.createCell(7).setCellValue("*If Other");
		row.createCell(8).setCellValue("Id Number");
	}

	private void setBody(Sheet sheet, List<WhUserType> list) {

		int rowNum = 1;
		for (WhUserType whty : list) {
			Row row = sheet.createRow(rowNum++);

			row.createCell(0).setCellValue(whty.getWhId());
			row.createCell(1).setCellValue(whty.getWhType());
			row.createCell(2).setCellValue(whty.getWhCode());
			row.createCell(3).setCellValue(whty.getWhForType());
			row.createCell(4).setCellValue(whty.getWhEmail());
			row.createCell(5).setCellValue(whty.getWhContact());
			row.createCell(6).setCellValue(whty.getWhIdType());
			row.createCell(7).setCellValue(whty.getWhIfOther());
			row.createCell(8).setCellValue(whty.getWhIdNumber());
		}
	}

}
