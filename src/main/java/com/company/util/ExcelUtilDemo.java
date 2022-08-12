package com.company.util;

public class ExcelUtilDemo {

	public static void main(String[] args) {
				
		String projectPath = System.getProperty("user.dir");
		ExcelUtilities excel = new ExcelUtilities(projectPath+"/excel/data.xlsx", "Sheet1");
		
		excel.getRowCount();
		excel.getCellDataString(0, 0);
		excel.getCellDataNumber(1, 1); 
	}
} 
