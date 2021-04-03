package com.zerobankpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zerobankpages.AccountActivityPage;

public class AccountSummaryPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'Savings')]")
	WebElement savingLink;
	
	@FindBy(xpath="//a[contains(text(),'Brokerage')]")
	WebElement brokerageLink;
	
	@FindBy(xpath="//a[contains(text(),'Checking')]")
	WebElement checkingLink;
	
	@FindBy(xpath="//a[contains(text(),'Credit Card')]")
	WebElement creditCardLink;
	
	@FindBy(xpath="//a[contains(text(),'Loan')]")
	WebElement loanLink;
	
	// Initializing the page objects:
		public AccountSummaryPage() { // Constructor

			PageFactory.initElements(driver, this);
		}
		
		//Actions
		public AccountActivityPage clickOnSavings() throws InterruptedException {
			savingLink.click();
			Thread.sleep(3000);
			return new AccountActivityPage();
			
		}
		
		public AccountActivityPage clickOnBrokerage() throws InterruptedException {
			brokerageLink.click();
			Thread.sleep(3000);
			return new AccountActivityPage();
		}
		
		public AccountActivityPage clickOnChecking() throws InterruptedException {
			checkingLink.click();
			Thread.sleep(3000);
			return new AccountActivityPage();
		}
		
		public AccountActivityPage clickOnCreditCard() throws InterruptedException {
			creditCardLink.click();
			checkingLink.click();
			Thread.sleep(3000);
			return new AccountActivityPage();
		}
		
		public void clickOnLoan() throws InterruptedException {
			loanLink.click();
			checkingLink.click();
			Thread.sleep(3000);
		}
		

}
