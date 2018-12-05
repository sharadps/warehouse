package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.OrderModel;

public class OrderModelExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// file name change
		response.addHeader("Content-Disposition", "attachment;filename:OrderModels.xlsx");

		// create sheet with name
		Sheet sheet = workbook.createSheet("om");

		// set Head
		setHead(sheet);

		// read data form database
		@SuppressWarnings("unchecked")
		List<OrderModel> list = (List<OrderModel>) model.get("om");

		// set body
		setBody(sheet, list);

	}

	private void setHead(Sheet sheet) {

		Row row = sheet.createRow(0);

		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("OrderModel Model");
		row.createCell(2).setCellValue("OredreModel Code");
		row.createCell(3).setCellValue("OrderModel Method");
		row.createCell(4).setCellValue("Accept");
		row.createCell(5).setCellValue("Description");
	}

	private void setBody(Sheet sheet, List<OrderModel> list) {
		
		int rowNum=1;
		for (OrderModel om : list) {
			Row row = sheet.createRow(rowNum++);
			
			row.createCell(0).setCellValue(om.getOmId());
			row.createCell(1).setCellValue(om.getOmModel());
			row.createCell(2).setCellValue(om.getOmCode());
			row.createCell(3).setCellValue(om.getOmMethod());
			row.createCell(4).setCellValue(om.getOmAcceptt().toString());
			row.createCell(5).setCellValue(om.getOmDsc());
		}
	}

}
