package com.zerobankbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;


public class BasePage {
	
	private WebDriver driver=null;              //driver instance is a private b'coz i don't want it should used by everyone   
	private Properties prop = null;
	
	
	/**
	 * This method is used to initialize the webDriver on the basis of browser
	 * @param return instance prop
	 * @return driver instance
	 */
	public WebDriver init_Driver(Properties prop) {
		
		String browser = prop.getProperty("browsername");		
		
		switch (browser) {
		case "chrome":
			openChrome();
			break;
		case "IE":
			openIe();
			break;
		case "firefox":
			openFireFox();
			break;
		case "safari":
			openFireFox();
			
		default:
			System.out.println("Please pass the correct Browsername");
			break;
		}
		
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get(prop.getProperty("url"));
	
	return driver;
		
	}
	
	/**
	 * @return properties available in config.properties file
	 */
	public Properties init_Prop() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(".\\src\\main\\resources\\com\\zerobankconfigs\\config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("config file is not found");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("config file is not loaded properly");
		}
		
		return prop;

	}

	public void openChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public void openIe() {
		WebDriverManager.iedriver().setup();
		driver = new ChromeDriver();
		
	}

	public void openFireFox() {
		WebDriverManager.firefoxdriver().setup();
		driver = new ChromeDriver();
	}
	

	public void openSafari() {
		WebDriverManager.getInstance(DriverManagerType.SAFARI).setup();
		driver = new SafariDriver();
	}
	
	/**
	 * @return driver instance as a null if driver is not initialized and driver is initialized under method
	 */
	@SuppressWarnings("unused")
	private WebDriver getDriver() {
		if (driver.equals(null)) {
			throw new NullPointerException("driver instance is not initialized");
		}
		return driver;
	}
	
	
}
