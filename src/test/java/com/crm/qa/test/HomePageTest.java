package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		initialization();
		loginPage=new LoginPage();
		contactsPage=new ContactsPage();
		testUtil=new TestUtil();
		Thread.sleep(5000);
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle=homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle,"CRMPRO","Home Page title not matched");
		}
	
	@Test(priority=2)
	public void verifyUsernamelabel(){
		testUtil.switchToFrame();
		boolean flag=homePage.verifyuserNamelabel();
		Assert.assertTrue(flag);
		}
	
	
	@Test(priority=3)
	public void verifyContactslink(){
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
		}
	
		
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}

}
