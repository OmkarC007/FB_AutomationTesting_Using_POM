package com.company.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.company.base.TestBase;
import com.company.pages.HomePage;
import com.company.pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		
	}
	
	@Test 
	public void LoginPageTitle() {
		String title = loginPage.validatLoginPageTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
	}
	@Test(priority=1)
	public void loginTest() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
}
