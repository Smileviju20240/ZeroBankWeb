package com.zerobankpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

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
	By footertext = By.cssSelector("div.disclaimer.span12");

	// Always Create constructor of page class b'coz it will always be called in other class when you are creating object.

	public HomePage(WebDriver driver) {
		this.driver = driver;
		action = new RegularActions(this.driver);
	}

	public String getTitleOfHomePage() {
		return action.gettingTitle();
	}
	
	public String getfooterText() {
		return action.gettingText(footertext);
	}

	public LoginPage verifyAnddoclickSignintab() {
		if (action.isDisalbedOrNot(signup)) {
			action.doClick(signup);
		} else
			System.out.println("Signuplink is not working");
		
		return new LoginPage(driver);
	}

}
