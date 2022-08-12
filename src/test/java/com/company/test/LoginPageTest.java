package com.company.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.company.base.TestBase;
import com.company.pages.HomePage;
import com.company.pages.LoginPage;
import com.company.util.CustomListner;
import com.company.util.TestUtil;

@Listeners(CustomListner.class)
public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	public static Logger log = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();		
	}
	
	@Test (priority=1)
	public void LoginPageTitle() {
		String title = loginPage.validatLoginPageTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
		log.info("login " + homePage);
	}
	
	
	@Test(priority=2)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("login " + homePage);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}	
}
