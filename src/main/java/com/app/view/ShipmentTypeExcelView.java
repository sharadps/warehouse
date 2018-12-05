package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.ShipmentType;

public class ShipmentTypeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// file name change
		response.addHeader("Content-Disposition", "attachment;filename:ShipmentTypes.xlsx");

		// create sheet with name
		Sheet sheet = workbook.createSheet("stype");

		// set Head
		setHead(sheet);

		// read data form database
		@SuppressWarnings("unchecked")
		List<ShipmentType> list = (List<ShipmentType>) model.get("stype");

		// set body
		setBody(sheet, list);

	}

	private void setHead(Sheet sheet) {

		Row row = sheet.createRow(0);

		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Shipment Type");
		row.createCell(2).setCellValue("Shipment Code");
		row.createCell(3).setCellValue("Enable Shipment");
		row.createCell(4).setCellValue("Shipment Grade");
		row.createCell(5).setCellValue("Description");
	}

	private void setBody(Sheet sheet, List<ShipmentType> list) {

		int rowNum = 1;
		for (ShipmentType stype : list) {
			Row row = sheet.createRow(rowNum++);

			row.createCell(0).setCellValue(stype.getShipId());
			row.createCell(1).setCellValue(stype.getShipMode());
			row.createCell(2).setCellValue(stype.getShipCode());
			row.createCell(3).setCellValue(stype.getShipEnabled());
			row.createCell(4).setCellValue(stype.getShipGrade());
			row.createCell(5).setCellValue(stype.getShipDsc());
		}
	}
}
