package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignmentPageObjects {
	WebDriver driver;
	
	public AssignmentPageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="txtAssignmentBatch")
	WebElement txtAssignmentBatch;
	
	@FindBy(id="btnManageGrades")
	WebElement btnManageGrades;                    
	
	@FindBy(id="btnEditAssignment")
	WebElement btnEditAssignment;
	
	@FindBy(id="btnDelAssignment")
	WebElement btnDelAssignment;

	@FindBy(id="btnGradesSubmit")
	WebElement btnGradesSubmit;
	
	@FindBy(linkText="Manage Assignments")
	WebElement ManageAssignments;
	
	@FindBy(id="selGradeBatch")   
	WebElement selGradeBatch;
	
	@FindBy(id="selAssignmentName")
	WebElement selAssignmentName;
	
	@FindBy(id="txtAssignmentDate")
	WebElement txtAssignmentDate;
	
	@FindBy(id="txtSubComments")
	WebElement txtSubComments;
	
	public void manage_link() {
		ManageAssignments.click();
	}
	
	public void txtAssignmentBatch() {
		txtAssignmentBatch.sendKeys("SDET 01");
	}
	
	public void btnManageGrades() {
		btnManageGrades.click();
	}
	
	public void selGradeBatch() {
		selGradeBatch.sendKeys("SDET 01");
	}
	
	public void selAssignmentName() {
		selAssignmentName.sendKeys("Selenium_1");
	}
	
	public void txtAssignmentDate() {
		txtAssignmentDate.sendKeys("09/23/21");
	}
	
	public void txtSubComments() {
		txtSubComments.sendKeys("Completed");
	}
	
	public void btnGradesSubmit() {
		btnGradesSubmit.click();
	}
	
	public void btnEditAssignment() {
		btnEditAssignment.click();
	}
	
	public void btnDelAssignment() {
		btnDelAssignment.click();
	}
	
	
}
