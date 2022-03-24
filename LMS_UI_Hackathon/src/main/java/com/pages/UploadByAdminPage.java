package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UploadByAdminPage {
	WebDriver driver;
	public UploadByAdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/*
	 * Page Objects for Manage Recordings page
	 */
	@FindBy(id="linkManageRecordings")
	WebElement manageRecordings;
	
	
	@FindBy(id="selBatchRecording")
	WebElement batchdropdown;
	
	@FindBy(id="selRecordingTopic")
	WebElement topicDropdown;
	
	@FindBy(id="btnUploadRecording")
	WebElement uploadRecording;
	
	@FindBy(id="btnUploadRecResource")
	WebElement uploadResource;
	
	

	/*
	 * Page Objects for Manage Recordings page
	 */
	
	public  void clickManageRecordings() {
		manageRecordings.click();
	}
	
	public void selectBatchFromDropDown(String text) {
		Select s = new Select(batchdropdown);
		s.selectByVisibleText(text);
		
	}
	public void selectTopicFromDropDown(String text) {
		Select s = new Select(topicDropdown);
		s.selectByVisibleText(text);
		
	}
	
	public  void clickUploadRecording() {
		uploadRecording.click();
	}
	public  void clickUploadResources() {
		uploadResource.click();
	}
	
	
	
}
