package com.zerobankTests;

import org.testng.annotations.Test;

import com.zerobankbase.BasePage;
import com.zerobankpages.HomePage;
import com.zerobankutils.AppConstants;

import org.testng.annotations.BeforeTest;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class HomePageTest extends BasePage{
	
	WebDriver driver;
	Properties prop;
	BasePage bp;
	HomePage hp;
	
	@BeforeTest
	  public void setUp() {
		
		bp = new BasePage();
		prop = bp.init_Prop();
		driver = bp.init_Driver(prop);
		hp = new HomePage(driver);
		
	  }
	
	
	@Test(priority = 1)
  public void verifyHomePage() {
		Assert.assertEquals(AppConstants.HOME_PAGE_TITLE, hp.getTitleOfHomePage());
  }
	@Test(priority=2)
	public void verifyfooterText() {
		Assert.assertEquals(AppConstants.Footer_Text, hp.getfooterText());
	}
	
	@Test(priority = 3)
  public void doClickOnSignIn() {
		hp.verifyAnddoclickSignintab();
	}
  

  @AfterTest
  public void tearDownTheBrowser() {
	  driver.quit();
  }

}
