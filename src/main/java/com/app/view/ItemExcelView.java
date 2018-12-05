package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Item;

public class ItemExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// change file Name and Download file
		response.addHeader("Content-Disposition", "attachment;filename:Item.xlsx");

		// create sheet with with name
		Sheet sheet = workbook.createSheet("item");

		// setHead
		setHead(sheet);

		// read the file data form database
		@SuppressWarnings("unchecked")
		List<Item> list = (List<Item>) model.get("item");

		// set Body
		setBody(sheet, list);

	}

	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);

		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("CODE");
		row.createCell(2).setCellValue("WIDTH");
		row.createCell(3).setCellValue("LENGTH");
		row.createCell(4).setCellValue("HEIGHT");
		row.createCell(5).setCellValue("BASE COST");
		row.createCell(6).setCellValue("CURRENCY");

	}

	private void setBody(Sheet sheet, List<Item> list) {
		int rowNum = 1; 

		for (Item item : list) {
			Row row = sheet.createRow(rowNum++);

			row.createCell(0).setCellValue(item.getiId());
			row.createCell(1).setCellValue(item.getItemCode());
			row.createCell(2).setCellValue(item.getiWidth());
			row.createCell(3).setCellValue(item.getiLength());
			row.createCell(4).setCellValue(item.getiHeight());
			row.createCell(5).setCellValue(item.getiBaseCost());
			row.createCell(6).setCellValue(item.getiCurrency());

		}
	}
}
