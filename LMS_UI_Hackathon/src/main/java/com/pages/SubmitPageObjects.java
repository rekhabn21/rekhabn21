package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SubmitPageObjects {
	
				WebDriver driver;
	
	public SubmitPageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Notifications")
	WebElement Notifications;
	
	@FindBy(id="selNotificationPgmName")
	WebElement selNotificationPgmName;
	
	@FindBy(id="txtHackathonName")
	WebElement txtHackathonName;
	
	@FindBy(id="txtHackathonDesc")
	WebElement txtHackathonDesc;
	
	@FindBy(id="txtHackathonDate")
	WebElement txtHackathonDate;
	
	@FindBy(id="txtHackathonComments")
	WebElement txtHackathonComments;
	
	@FindBy(id="btnSaveNotification")
	WebElement btnSaveNotification;
	
	public void Link_click() {
		Notifications.click();
		
	}
	public void Sel_ProName() {
		
		Select dropdown= new Select(selNotificationPgmName);
		dropdown.selectByVisibleText("SDET");
	//	((Select) selNotificationPgmName).selectByVisibleText("SDET");
				
	}
	
	public void Hackathon_Name() {
	 			
		txtHackathonName.sendKeys("API HACKATHON");
			
	}
	
	public void Hackathon_Desc() {
			
		txtHackathonDesc.sendKeys("API");
			
	}
	
	public void Hackathon_Date() {
		
		txtHackathonDate.sendKeys("09/23/21");
			
	}
	
    public void Hackathon_Comments() {
		
    	txtHackathonComments.sendKeys("API");
			
	}
	
 public void Save_btn() {
		
	 btnSaveNotification.click();
			
	}
	
}
