package com.company.util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	static String projectPath;
	static XSSFWorkbook workBook;
	static XSSFSheet sheet ;
	
	public ExcelUtilities(String ExcelPath, String sheetName) {
		try {		
		workBook = new XSSFWorkbook(ExcelPath);
		sheet = workBook.getSheet(sheetName);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//getRowCount();
//		getCellDataString(0,0);
		getCellDataNumber(1,1);
	}
	
	public static int getRowCount() {
		int rowCount = 0;
		try {			
			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No of Rows :" +rowCount);
			
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return rowCount;
	}
	
	public static int getColumnCount() {
		int colCount=0;
		try {			
			colCount =sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("No of Columns :" +colCount);
			
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return colCount; 
	}
	
	public static String getCellDataString(int rowNum, int colNum) {
		String cellData = null;
		try {
		cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		System.out.println(cellData);
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellData;
	}
		

	public static void getCellDataNumber(int rowNum, int colNum) {
		try {
		double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		System.out.println(cellData);
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
}
