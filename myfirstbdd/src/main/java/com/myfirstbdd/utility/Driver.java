package com.myfirstbdd.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		if(driver==null) {
			String browser=MyConfiguration.get("browser");
			switch(browser) {
			case "chrome-headless" :
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;
			case "firefox-headless" :
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				break;
			}
		}
		return driver;
	}
	
	public static void closeDriver() {
		if(driver!=null) {
			driver.quit();
			driver=null;
		}
	}

}
