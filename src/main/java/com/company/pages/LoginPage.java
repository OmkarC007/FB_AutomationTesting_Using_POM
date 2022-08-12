package com.company.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.company.base.TestBase;

public class LoginPage extends TestBase{

	//page factory - or:
	@FindBy(xpath = "//input[@id='email']")
	WebElement username;
	
	@FindBy(name = "pass")
	WebElement password;
	
	@FindBy(name = "login")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[text()='Create New Account']")
	WebElement CreateAccountbtn;
	
	//Initialize page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);	 	
	}
	//Actions
	public String validatLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage(); 
	}
}

