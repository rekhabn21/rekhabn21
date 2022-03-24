package com.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class userdetailspage {
	private WebDriver driver;
	public userdetailspage() throws IOException {
		super();
		try {
			PageFactory.initElements(driver, this);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
		
	@FindBy(id = "selUserTimeZone") 	@CacheLookup	WebElement timeZonelist;//
	
	@FindBy(id = "selUserRoleName") 	@CacheLookup	WebElement userRolelist;
	
	@FindBy(id = "selBatchName") 	@CacheLookup	WebElement batchNamelist;
	
	@FindBy(id = "selProgramName")	@CacheLookup	WebElement programNameList;
	
	@FindBy(id = "btnSave")	@CacheLookup	WebElement saveBtn;
	
	@FindBy(id = "Alertmsg")	@CacheLookup	WebElement message;
	
	//*************************************************************************************************
	//actions on the webelements
	
	
	public String verifypagetitlefunction() {
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}
	
	public void  savebtnfunction() {
		saveBtn.click();
	}
		
	public void  messagefunction() {
		System.out.println(message.getText());
	}
	
//*******************************************************************************************************
	// methods
	
	public void  timezonelistfunction( String zone) {
		Select timezones = (Select) new Select(timeZonelist).getOptions();
		timezones.selectByValue(zone);
		saveBtn.click();
		message.getText();
		}
	
	public void  userrolelistfunction(String Role) {
		Select userroles = (Select) new Select(userRolelist).getOptions();
		userroles.selectByValue(Role);
		saveBtn.click();
		message.getText();
	}
	
	public void  batchnamelistfunction( String batch) {
		Select batchnames = (Select) new Select(batchNamelist).getOptions();
		 batchnames.selectByValue(batch);
		 saveBtn.click();
	}
	
	public void  programnamelistfunction( String program) {
		Select programs = (Select) new Select (programNameList).getOptions()	;
		programs.selectByValue(program);
		saveBtn.click();
		message.getText();
	}
	

}
