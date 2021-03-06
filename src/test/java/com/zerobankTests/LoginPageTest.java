
package com.zerobankTests;

import org.testng.annotations.Test;
import com.zerobankbase.BasePage;
import com.zerobankpages.HomePage;
import com.zerobankpages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTest extends BasePage {

    WebDriver driver;
	Properties prop;
	BasePage bp;
	HomePage hp;
	LoginPage lp;

	@BeforeMethod
	public void setUp() {

		bp = new BasePage();
		prop = bp.init_Prop();
		driver = bp.init_Driver(prop);
		hp = new HomePage(driver);
		lp = hp.verifyAnddoclickSignintab();
	}

	@Test(priority = 1)
	public void TestverifyLogin() {
		lp.doGetInAccountSummary();
	}
	
	@DataProvider
	public Object[][] getInvalidLoginData() {
		Object dataarray[][] = {
				{"test@gmail.com","test"},
				{"test@gmail.com", " "},
				{"  ", "test"},
				{"test","test"},
				{" "," "}
		};
		return dataarray;
	}
	
	@Test(priority = 2, dataProvider = "getInvalidLoginData")
	public void login_invalidData(String login, String pass) {
		lp.doNotLogIn(login, pass);
		Assert.assertTrue(lp.docheck_loginerrormessage());
	}

	@AfterMethod
	public void tearDownTheBrowser() {
		driver.quit();
	}

}
