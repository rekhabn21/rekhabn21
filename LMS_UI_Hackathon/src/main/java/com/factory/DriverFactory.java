package com.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	public static Properties prop;

	public DriverFactory() throws IOException {
		try {
			prop = new Properties();
			FileInputStream FIS = new FileInputStream("./src/test/resources/config/Config.properties");
			prop.load(FIS);
		} catch (IOException e) {
			e.getCause();
		}
	}
	public static ThreadLocal<WebDriver> tlDriver= new ThreadLocal<>();
	//This method is used to initialize the tlocal driver on the basis of given browser 
	public WebDriver init_driver(String browser) {
		System.out.println("browser value is:"  +browser);
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());		
		}
		
		else if (browser.equals("firefox")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new FirefoxDriver());
	}
		else {
			System.out.println("Please pass the correct browservalue: "   + browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
		
	
		public static synchronized WebDriver getDriver() {
			return tlDriver.get();
			
			
		}
	}


