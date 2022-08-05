package com.company.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.company.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath = "//span[normalize-space()='Omkar Chikane']")
	WebElement usernamelabel;

	@FindBy(xpath = "//span[contains(text(),'Friends')]")
	WebElement FriendsLink;

	@FindBy(xpath = "//a[contains(@href,'/notifications/')]")
	WebElement NotificationsLink;

	@FindBy(xpath = "//a[contains(@href,'/groups/')]")
	WebElement groupsLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyUsernameLabel() {
		return usernamelabel.isDisplayed();
	}

	public HomePage clickOnFriendsLink(){
		FriendsLink.click();
		return new HomePage();
	}

	public GroupsPage ClickOnGroupsLink() {
		groupsLink.click();
		return new GroupsPage();
	}

	public HomePage clickOnNotificationsLink() {
		NotificationsLink.click();
		return new HomePage();
	}
}
