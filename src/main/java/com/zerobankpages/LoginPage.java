package com.zerobankpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zerobankbase.BasePage;
import com.zerobankutils.RegularActions;

public class LoginPage extends BasePage {

	WebDriver driver;
	RegularActions action;

	By Login = By.id("user_login");
	By password = By.id("user_password");
	By signin = By.xpath("//input[@name='submit']");
	By Advanced = By.xpath("//button[@id='details-button']");
	By proceedlink = By.xpath("//a[@href='#' and @id='proceed-link']");
	By errormessage = By.xpath("//div[@class='alert alert-error']");
	

// Always Create constructor of page class b'coz it will always be called in other class while object creation.

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		action = new RegularActions(this.driver);
	}

	public WebDriver doGetInAccountSummary() {

		if (action.isDisalbedOrNot(signin)) {
			doLogin();
		}
		return driver;
	}
	
	public void doNotLogIn(String login, String pwd) {
		
		action.doSendKeys(Login, login);
		action.doSendKeys(password, pwd);
		action.doClick(signin);
	}

	public void doLogin() {

		action.doSendKeys(Login, "username");
		action.doSendKeys(password, "password");
		action.doClick(signin);
		action.doClick(Advanced);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		action.doClick(proceedlink);
		
	}
	
	public boolean docheck_loginerrormessage() {
		return action.isDisalbedOrNot(errormessage);
	}

}
