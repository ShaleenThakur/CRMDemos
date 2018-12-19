package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'User: Shaleen ')]")
	WebElement usernamelabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contacts;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement deals;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle(){
		return driver.getTitle();
	 }
	
	public boolean verifyuserNamelabel(){
		return usernamelabel.isDisplayed();
	 }
	
	public ContactsPage clickOnContactsLink(){
		contacts.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		deals.click();
		return new DealsPage();
	}
	
	
}
