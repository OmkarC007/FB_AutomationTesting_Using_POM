package com.company.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.company.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop; 
	
	public static Logger log = Logger.getLogger(TestBase.class);
	
	public TestBase() { 
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\omkar\\eclipse-workspace"
					+ "\\SeleniumJavaFramework"
					+ "\\src\\main\\java\\com\\company\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-64bit\\geckodriver.exe");
		    driver = new FirefoxDriver();	
		}else if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver-32bit\\chromedriver.exe");
		    driver = new ChromeDriver();	
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	public void takeScreenshotAtEndOfTest(String testMethodName) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {			
			FileUtils.copyFile(scrFile, new File("C:\\Users\\omkar\\eclipse-workspace\\FbAutomationTesting_Using_POM\\screenshots\\"
			+testMethodName+"_"+".png"));
		}catch(IOException exp) {
			exp.printStackTrace();
		}
	}
}
