package com.company.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.company.base.TestBase;

public class ProfilePage extends TestBase{

	@FindBy(xpath = "//span[normalize-space()='Omkar Chikane']")
	WebElement profileLink;

	@FindBy(xpath = "//span[contains(text(), 'Edit profile')]")
	WebElement editProfileLink;

	@FindBy(xpath = "//span[normalize-space()='\"Believes in Karma :)\"']")
	WebElement checkDescriptionLink;
	
	@FindBy(xpath = "//span[contains(text(),'See All Photos')]")
	WebElement seeAllPhotosLink;

	// Initializing the page objects - constructor of HomePage
	public ProfilePage() {
		PageFactory.initElements(driver, this);
	} 

	public void addProfile() {
		profileLink.click();
		editProfileLink.click();
		checkDescriptionLink.click();
		seeAllPhotosLink.click();
	}

	public boolean checkProfile() {
		profileLink.click();
		return profileLink.isDisplayed();
	}

	public boolean checkBioDataEntry() {
		profileLink.click();
		return checkDescriptionLink.isDisplayed();
	}
	
	public ProfilePage seeAllPhotos() {
		profileLink.click();
	 seeAllPhotosLink.click();
	 return new ProfilePage();
	}
	public Boolean editProfile() {
		profileLink.click();
	return	editProfileLink.isDisplayed();
		
	}
}
