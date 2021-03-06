package com.zerobankpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zerobankbase.BasePage;
import com.zerobankutils.RegularActions;

public class HomePage extends BasePage {

	WebDriver driver;
	RegularActions action;

	By title = By.xpath("//a[normalize-space()='Zero Bank']");
	By signup = By.id("signin_button");
	By links = By.xpath("//a");
	By search = By.id("searchTerm");
	By Hometab = By.id("homeMenu");
	By onlinebanking = By.id("onlineBankingMenu");
	By feedback = By.id("feedback");

	// Always Create constructor of page class b'coz it will always be called in other class while object creation.

	public HomePage(WebDriver driver) {
		this.driver = driver;
		action = new RegularActions(this.driver);
	}

	public String getTitleOfHomePage() {
		return action.gettingTitle();
	}

	public LoginPage verifyAnddoclickSignintab() {
		if (action.isDisalbedOrNot(signup)) {
			action.doClick(signup);
		} else
			System.out.println("Signuplink is not working");
		
		return new LoginPage(driver);
	}

}
