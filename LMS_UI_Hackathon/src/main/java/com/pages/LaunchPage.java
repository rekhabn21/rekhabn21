package com.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.factory.DriverFactory;

public class LaunchPage {
private WebDriver driver;
//1. by locators 
@FindBy (xpath="//input[@id='btnLogin']")
@CacheLookup
WebElement loginBtn;

//private By loginBtn = By.id("btnLogin");
public String loginUrl = "https://LMS-UI.com";

   //2.constructor of the page class
public LaunchPage (WebDriver driver) {
		this.driver=driver;
		try {
			PageFactory.initElements(driver, this);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
}
	//3. page actions
	public void displayLoginBtnLink() {
		loginBtn.getText();
	}
	public void clickOnLoginBtn() {
		loginBtn.click();
	}
	 public LoginPage launchtologinpage()  {
		 loginBtn.click();
		 driver.navigate();
		 String pgtitle = driver.getTitle();
		 System.out.println(pgtitle);
		 return new LoginPage(driver);
		 	 
	 }
}



