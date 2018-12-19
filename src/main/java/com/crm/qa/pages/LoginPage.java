package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
//Page Factory or Object Repository
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[@class='nav navbar-nav navbar-right']//*[text()='Sign Up']")
	WebElement signUpBtn;
	
	@FindBy(xpath="//*[@class='img-responsive' and @alt='free crm logo']")
	WebElement crmLogo;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	 }
	
	public boolean crmImageLogo(){
		return crmLogo.isDisplayed();
	 }
	
	public HomePage login(String un,String pw){
		username.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.click();
		
		return new HomePage();
	}
	
	

}
