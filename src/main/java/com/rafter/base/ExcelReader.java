package com.rafter.base;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	/*
	 * Apache POI
	 * Add below dependencies
	 * poi
	 * poi-ooxml
	 * 
	 * Steps:
	 * 1. Identify the path of the file
	 * 2. Identify the sheet
	 * 3. Identify the no of rows
	 * 4. Identify the no of columns
	 * 5. Get the data using for loop
	 */
	
	String filePath;
	String sheetName;
	
	public ExcelReader(String filePath, String sheetName) {
		this.filePath = filePath;
		this.sheetName = sheetName;
	}
	
	public Object[][] getData() {
		
		//XSSFWorkbook: create obj and inform where your file is
		//XSSFSheet: get the sheet from workbook using getsheet method and save it in a XSSFSheet object
		
		XSSFWorkbook wb = null;

		try {
			wb = new XSSFWorkbook(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found");
		}

		XSSFSheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowCount-1][colCount];
		for (int row = 1; row < rowCount; row++) {
			for (int col = 0; col < colCount; col++) {
				data[row-1][col] = sheet.getRow(row).getCell(col).getStringCellValue();
				//System.out.println(sheet.getRow(row).getCell(col).getStringCellValue());
			}
		}
		
		return data;
		
		//read the data and store it in a data variable
		//of type Object[][] and return it
	}
}
