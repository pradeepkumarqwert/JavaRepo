package com.scripts.resource;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelScript2 {
	static String filePath = System.getProperty("user.dir" + "\\TestData2.xlsx");

	public static void main(String[] args) throws IOException {
		try {
			writeExcel();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		readExcel();

		System.out.println("Excel script execution completed");
	}

	public static void writeExcel() throws IOException {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("CreatedSheet");
		String[] searchValues = { "jiomart", "amazon", "flipkart" };

		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("WebsiteName");
		header.createCell(1).setCellValue("WebsiteTitle");

		for (int i = 0; i < searchValues.length; i++) {
			Row row = sheet.createRow(i + 1);
			row.createCell(0).setCellValue(searchValues[i]);

		}

		FileOutputStream fos = new FileOutputStream(filePath);
		workbook.write(fos);
		fos.close();
		workbook.close();

		System.out.println("Write on the execl is done");

	}

	public static void readExcel() {

	}

}
