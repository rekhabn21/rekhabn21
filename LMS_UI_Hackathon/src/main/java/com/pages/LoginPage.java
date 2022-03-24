package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.factory.DriverFactory;

public class LoginPage  {
	
	private WebDriver driver;
	//1. by locators 
	public String loginScreenUrl = "https://LMS-UI.com/login";
	public String LMSHomePage="https://LMS-UI.com/home";
	//Login Name and Password
	
	@FindBy (xpath="//input[@id='txtUserLoginName']")
	@CacheLookup
	WebElement loginName;
	
	@FindBy (xpath="//input[@id='txtUserPassword']")
	@CacheLookup
	WebElement password;
	
	@FindBy (xpath="//input[@id='btnLoginSubmit']")
	@CacheLookup
	WebElement SubmitBtn;
	
	@FindBy (xpath="//input[@id='btnForgotPassword']")
	@CacheLookup
	WebElement forgotPwd;
	
	@FindBy (xpath="//input[@id='invalidUserNameOrPwd']")
	@CacheLookup
	WebElement alertMsg;
	
	@FindBy (xpath="//input[@id='txtUserEmailAddress']")
	@CacheLookup
	WebElement emailAddress;
	
	@FindBy (xpath="//input[@id='btnNext']")
	@CacheLookup
	WebElement nextBtn;
	
	@FindBy (xpath="//input[@id='txtSecurityAns']")
	@CacheLookup
	WebElement securityAnswer;
	
	@FindBy (xpath="//input[@id='txtPlaceOfBirth']")
	@CacheLookup
	WebElement securityQuestion;
	
	@FindBy (xpath="//input[@id='resetMsg']")
	@CacheLookup
	WebElement resetDisplayedMsg;
	
	@FindBy (xpath="//input[@id='resetNotSendMsg']")
	@CacheLookup
	WebElement resetLinkNotSend;
	/*private By loginName = By.id("txtUserLoginName");
	private By password = By.id("txtUserPassword");
	private By SubmitBtn = By.id("btnLoginSubmit");
	private By forgotPwd = By.id("btnForgotPassword");
	//user navigates to LMS Home Page
	public String LMSHomePage="https://LMS-UI.com/home";
	private By alertMsg = By.id("invalidUserNameOrPwd");
	private By emailAddress =By.id("txtUserEmailAddress");
	private By nextBtn =By.id("btnNext");
	private By securityAnswer =By.id("txtSecurityAns");
	private By securityQuestion =By.id("txtPlaceOfBirth");
	private By resetDisplayedMsg =By.id("resetMsg");
	private By resetLinkNotSend = By.id("resetNotSendMsg");*/
	
	//2.constructor of the page class
	public LoginPage (WebDriver driver) {
			this.driver=driver;
			try {
				
				PageFactory.initElements(driver, this);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			}
			
	//3. page actions
	//User enters Login Name and Password   
	public void loginName(String UsrName) {
	loginName.sendKeys(UsrName);
	}
	public void password(String pwd) {
	password.sendKeys(pwd);
		}
	public void forgotPwdLinkBtn() {
    forgotPwd.click();
			}
	public void submitBtn() {
	SubmitBtn.click();
			}
	public void emailAddress() {
	emailAddress.sendKeys("admin@gmail.com");
			}
	public void nextBtn() {
	nextBtn.click();
			}
	public void securityQuestion() {
	securityQuestion.sendKeys("placeOfBirth");
			}
	
	public void securityAnswer() {
    securityAnswer.sendKeys("newJersey");
			}
	public void resetDisplayedMsg(String expectedMsg) {
	resetDisplayedMsg.isDisplayed();
			}
	public void resetLinkNotSend(String expectedMsg) {
	resetLinkNotSend.isDisplayed();
			}
	
	public String alertmessageVerification() {
		String mesg = null;
	    try {
	        mesg = (alertMsg).getAttribute("innerText");
	        (alertMsg).isDisplayed();
	    } catch (Exception e) {
	        System.out.println(String.format(
	                "Following Message is not prompted "));
	    }
	    return mesg;
	}
	public void loginfunction() {
		loginName.sendKeys("admin");
		password.sendKeys("password");
		SubmitBtn.click();
		alertmessageVerification();
		driver.navigate();
		System.out.println(driver.getTitle());
		
	}
	}




