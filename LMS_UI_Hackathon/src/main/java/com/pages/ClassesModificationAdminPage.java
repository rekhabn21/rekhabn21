package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ClassesModificationAdminPage {
	WebDriver driver;


	public ClassesModificationAdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
/*
 * Page Objects for Manage Classes(Admin) Page
 */
	@FindBy(id="linkManageClasses")
	WebElement linkManageClasses;
	
	@FindBy(id="btnAddClass")
	WebElement addClass;
	
	@FindBy(id="txtClassno")
	List<WebElement> classNo; 
	
	@FindBy(id="btnDelClass")
	WebElement deleteClass;
	
	@FindBy(id="btnEditlass")
	WebElement editClass;
	
	@FindBy(id="btnEdit")
	WebElement editInTab;
	
	@FindBy(id="btnAdd")
	WebElement addInTab;
	
	@FindBy(id="txtClassTopic")
	WebElement classTopic;
	
	@FindBy(id="dateClassDate")
	WebElement classDate;
	
	@FindBy(id="selClassStaffName")
	WebElement classStaffName;
	
	@FindBy(id="txtClassDescription")
	WebElement classDescription;
	
	@FindBy(id="txtClassComments")
	WebElement classComments;
	
	@FindBy(id="txtClassComments")
	List<WebElement> listComments;
	
	@FindBy(id="btnEditclassSubmit")
	WebElement submit;
	
	/*
	 * Action methods for the page Objects
	 */
	public void clickManageClassesonHomePage() {
		linkManageClasses.click();
	}
	public void clickAddClass() {
		addClass.click();
	}
	public List<WebElement> classSerialNo() {
		return classNo;
	}
	
	public void clickEditInTab() {
		editInTab.click();
	}
	public void clickDeleteClass() {
		deleteClass.click();
	}
	
	public void clickEditClass() {
		editClass.click();
	}
	public void enterClassTopic(String text) {
		classTopic.sendKeys(text);
	}
	public void clickDate() {
		classDate.click();
	}
	
	public void enterStaffName(String text) {
		Select s = new Select(classStaffName);
		s.selectByVisibleText(text);
		
	}
	public void enterClassDescription(String text) {
		classDescription.sendKeys(text);
	}
	public void enterClassComments(String text) {
		classComments.sendKeys(text);
	}
	public void clickSubmit() {
		submit.click();
	}
	public void clickAddInTab() {
		addInTab.click();
	}
    public List<WebElement> listOfComments(){
		return listComments;
    	
    }
}
