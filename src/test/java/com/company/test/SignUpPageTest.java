package com.company.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.company.base.TestBase;
import com.company.pages.LoginPage;
import com.company.pages.SignupPage;

public class SignUpPageTest extends TestBase{

	SignupPage signUpPage;
	LoginPage loginPage;
	

	public SignUpPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		signUpPage = new SignupPage();
	}

	@Test(priority = 1)
	public void signUpPageTitleTest() {
		String title = signUpPage.validateSignUpPageTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
	}

	@Test(priority = 2)
	public void SignUpTest() {
		loginPage = signUpPage.signUp();
	}

	@AfterMethod
	public void tearDown() {
	driver.quit();
	}
}
