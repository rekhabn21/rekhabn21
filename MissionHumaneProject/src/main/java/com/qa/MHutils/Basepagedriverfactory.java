package com.qa.MHutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basepagedriverfactory {

	public static WebDriver driver;
	public static Properties prop; 

	public Basepagedriverfactory() throws IOException {
		try {
			prop = new Properties();
			FileInputStream FIS = new FileInputStream("src/main/java/com.qa/config.properties");
			prop.load(FIS);
		} catch (IOException e) {
			e.getCause();
		}
	}

	public static WebDriver Intialization() {

		WebDriverManager.chromedriver().setup();
			//// headless mode
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("headless");
//			 driver=new ChromeDriver(options);
			 driver=new ChromeDriver();
			 driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(testutils.Page_Load_TIMEOUT, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(testutils.Implicity_wait, TimeUnit.SECONDS);
				System.out.println("opens new chrome Browser");
				return driver;
		/*
		String browserName = prop.getProperty("browser");
		System.out.println("Browser : " + browserName);

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", Testutils.chromepath);
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {

			System.setProperty("webdriver.chrome.driver", Testutils.firefoxpath);
			driver = new FirefoxDriver();
		}*/
		

		
	}

}
