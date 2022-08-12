package com.company.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.company.base.TestBase;
import com.company.pages.HomePage;
import com.company.pages.LoginPage;
import com.company.pages.ProfilePage;
import com.company.util.TestUtil;

public class ProfilePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ProfilePage profilePage;

	public ProfilePageTest() {
		super();
	}

	// Avoid dependency between TC. Relaunch Browser after each TC.
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		profilePage = new ProfilePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void checkProfilePageTest() {
		profilePage.checkProfile();
	}

	

	@Test(priority = 2)
	public void checkBioDataEntryTest() {
		profilePage.checkBioDataEntry();
	}
	
	@Test(priority = 3)
	public void seeAllPhotosTest() {
		profilePage.seeAllPhotos();
	}
	
//	@Test(priority = 4)
//	public void editProfileTest() {
//		profilePage.editProfile();
//	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
