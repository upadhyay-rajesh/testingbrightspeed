package com.myfirstbdd.utility;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyConfiguration {
	private static Properties pp;
	
	static {
		try {
			String path="myconfiguration.properties";
			FileInputStream rr=new FileInputStream(path);
			pp=new Properties();
			pp.load(rr);
			rr.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String get(String key) {
		return pp.getProperty(key);
	}
	
	public static class Driver{
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
}


















