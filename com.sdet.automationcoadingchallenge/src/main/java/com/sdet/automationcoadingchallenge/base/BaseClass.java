package com.sdet.automationcoadingchallenge.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.DOMConfiguration;

import com.sdet.automationcoadingchallenge.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeSuite
	public static void beforeSuite() {
		String log4jConfPath = System.getProperty("user.dir")+ "/log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}
	@BeforeTest
	public void loadConfig() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/configuration/Config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void launchApp() {
		
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		Action.maximiseWindow(driver);
		Action.implicitWait(driver, 12);
		Action.PageLoadTimeOut(driver, 30);
		driver.get(prop.getProperty("url"));
		
	}

}