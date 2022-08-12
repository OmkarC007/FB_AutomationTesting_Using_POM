package com.company.excel;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.company.util.ExcelUtilities;

public class ExcelDataProviderTest {
	
	static WebDriver driver ;
	static Properties prop;
	
	@BeforeTest
	public void setUpTest() {
		//String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-64bit\\geckodriver.exe");
		driver = new FirefoxDriver();	
	}
	
	@Test(dataProvider = "testData")
	public void test1(String username, String password) throws Exception {
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath( "//input[@id='email']")).sendKeys(username);
		driver.findElement(By.name("pass")).sendKeys(password);
		Thread.sleep(2000); 
		driver.findElement(By.name("login")).click();
		
	}
	
	@DataProvider(name = "testData")
	public  Object[][] getData() {
		String excelPath = "C:\\Users\\omkar\\eclipse-workspace\\FbAutomationTesting_Using_POM\\excel\\data.xlsx";		
		Object data[][] = testData(excelPath, "Sheet1");
		return data;
	}
	
	public Object[][] testData(String excelPath, String sheetName) {
		ExcelUtilities excel = new ExcelUtilities(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColumnCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for(int i=1; i< rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				
				String cellData = excel.getCellDataString(i, j);
				//System.out.println(cellData + " " );
				data[i-1][j] = cellData;
			}
			//System.out.println();
		}
		return data;
	}
		
	
}
