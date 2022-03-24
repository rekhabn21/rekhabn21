package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageAssignmentsPageAdmin {

	WebDriver driver=null;
	
	//Page Objects
	@FindBy(id = "txtBoxBatch")
	WebElement txtBoxBatch;
	
	@FindBy(id = "btnAddProgram")
	WebElement  btnAddPgm ;
	
	@FindBy(id = "linkManage")
	WebElement  linkManage ;
	
	@FindBy(id = "btnEdit")
	WebElement  btnEdit ;
	
	@FindBy(id = "btnDelete")
	WebElement  btnDelete ;
	
	@FindBy(id = "leftPanelLinkManageAssignments")
	WebElement  leftPanelLinkManageAssignments ;
	
	@FindBy(id = "btnAssignmentsAdd")
	WebElement   btnAssignmentsAdd;
	
	@FindBy(id = "btnAssignmentsEdit")
	WebElement  btnAssignmentsEdit ;
	
	@FindBy(id = "drpdwnBatch")
	WebElement  drpdwnBatch ;
	
	@FindBy(id = "txtBxAsgnmentName")
	WebElement  txtBxAsgnmentName ;
	
	@FindBy(id = "txtBxAsgnmentDescription")
	WebElement  txtBxAsgnmentDescription ;
	
	@FindBy(id = "calenderAsgnmentDue")
	WebElement  calenderAsgnmentDue ;
	
	@FindBy(id = "asignmentUploadLnk")
	WebElement asignmentUploadLnk  ;
	
	@FindBy(id = "btnAddAssignSubmit")
	WebElement  btnAddAssignSubmit ;
	
	@FindBy(id = "drpdwngradedBy")
	WebElement  drpdwngradedBy ;
	
	@FindBy(id = "drpdwnGrade")
	WebElement  drpdwnGrade ;
	
	@FindBy(id = "chkbxMakeGradesVisible")
	WebElement  chkbxMakeGradesVisible ;
	
	@FindBy(id = "btnGradeSubmit")
	WebElement  btnGradeSubmit ;
	
	@FindBy(id = "txtbxAddComments")
	WebElement  txtbxAddComments ;
	
	@FindBy(id = "labelAssignmentName")
	WebElement labelAssignmentName;
	
	@FindBy(id = "labelAssignmentdescription")
	WebElement labelAssignmentdescription;
	
	@FindBy(id = "labelAssignmentdueDate")
	WebElement labelAssignmentdueDate;
	
	@FindBy(id = "labelAssignmentfile")
	WebElement labelAssignmentfile;
	
	/*
	 * //Initialisze Page Objects public ManageAssignmentsPageAdmin() { WebDriver
	 * driver = null; PageFactory.initElements(driver, this); }
	 */
	
	//2.constructor of the page class
			public ManageAssignmentsPageAdmin (WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
	
	//Actions
	public void clickOnManageAssignmentTab() {
		
		leftPanelLinkManageAssignments.click();
		
	}
	
	public void clickOnAddExistingBatch() {
		
		btnAddPgm.click();
	}
	
    public void clickOnDeleteExistingBatch(String name) {
		
    	labelAssignmentName.isDisplayed();
		btnDelete.click();
	}
	
    public void clickOnEditExistingBatch() {
		
  		btnEdit.click();
    }
	public void editData(String Name, String Description, String DueDate, String File) {
		
		txtBxAsgnmentName.sendKeys(Name);
		txtBxAsgnmentDescription.sendKeys(Description);
		calenderAsgnmentDue.sendKeys(DueDate);
		asignmentUploadLnk.sendKeys(File);
		
	}
	
	public void submit() {
		
		btnAddAssignSubmit.click();
	}
	
	public void clickManageAssignments() {
		
		leftPanelLinkManageAssignments.click();
	}
	
	public void deleteAssignment() {
		
		btnDelete.click();
		
	}
	
    public void clickOnManage() {
		
	linkManage.click();
		
	}

	public void sendDataForSubmission(String batch, String gradeBy, String grade, String makeGradeVisible) {
		
		txtBoxBatch.sendKeys(batch);
		drpdwnGrade.click();
		chkbxMakeGradesVisible.click();
		btnGradeSubmit.click();
		
	}

	public boolean compareAssignmentName(String name) {
		
		if(( labelAssignmentName.getText() ).equals(name) ) {
			return true;
		}
	
	 return false;
	}

	public boolean getAllExistingRecords(String name, String description, String dueDate, String file) {
		
		if( (( labelAssignmentName.getText() ).equals(name)) &&  (( labelAssignmentdescription.getText() ).equals(description)) 
				&& (( labelAssignmentdueDate.getText() ).equals(dueDate)) && (( labelAssignmentfile.getText() ).equals(file)))
{
			return true;
		}
		
		return false;
		
	}

	//background check
	public String checkUrl() {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	}

	public boolean gradeDetails() {
		
		return drpdwnBatch.isDisplayed();
			
	}
    
    
}
