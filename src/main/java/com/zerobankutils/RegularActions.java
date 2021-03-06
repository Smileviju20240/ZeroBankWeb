
package com.zerobankutils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zerobankbase.BasePage;

public class RegularActions extends BasePage{
	
	WebDriver driver;
	
	public RegularActions(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement doFind(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("Exception at finding element : " + locator);
		}

		return element;
	}
	
	public void doClick(By locator) {
		doFind(locator).click();
	}
	
	public void doSendKeys(By locator, String text) {
		doFind(locator).sendKeys(text);
	}
	
	public String gettingTitle() {
		return driver.getTitle();
	}
	
	public boolean isDisalbedOrNot(By locator) {
		return doFind(locator).isDisplayed();
	}
	
	public String doText(By locator) {
		return doFind(locator).getText();
	}
}
