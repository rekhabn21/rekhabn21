package com.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LmsAdminUserPage  {
	private WebDriver driver;

	public LmsAdminUserPage() throws IOException {
		super();
		try {
			PageFactory.initElements(driver, this);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	LmsAdminUserPage Lmsadminpg;
	Registereduserspage registereduserpg = new Registereduserspage();

	// Admin is on LMS Admin User Page Admin clicks on search button after entering
	// Email or Batch or Skill or program

	@FindBy(id = "txtUserEmail")
	@CacheLookup
	WebElement txtUserEmail;//
	@FindBy(id = "selUserBatch")
	@CacheLookup
	WebElement selUserBatch;//
	@FindBy(id = "selUserSkill")
	@CacheLookup
	WebElement selUserSkill;//
	@FindBy(id = "selUserProgram")
	@CacheLookup
	WebElement selUserProgram;//
	@FindBy(id = "search")
	@CacheLookup
	WebElement btnSearch;//
	@FindBy(id = "linkUnassignedUsers")
	@CacheLookup
	WebElement linkUnassignedUsers;

	public void emailtextbox() {
		txtUserEmail.sendKeys("");
	}

	public void Userbatchdropdownselection() {
		((WebElement) selUserBatch).isSelected();
	}

	public void UserSkillselection() {
		((WebElement) selUserSkill).isSelected();
	}

	public void userprogramselection() {
		((WebElement) selUserProgram).isSelected();
	}

	public void searchbtn() {
		btnSearch.click();
	}

	public void newassigneduserssearch() {
		linkUnassignedUsers.click();
	}

//*************************************************************************************************************************
//Scenario: Check whether Admin can search users by giving Email or Batch or Skill or program
//User is in Lms admin page	
	
	public String verifypagetitle() {
		System.out.println("The page title is    :" + driver.getTitle());
		return driver.getTitle();// LMS Admin page /users
	}

// user clicks on email or batch or skill or program 

	public void searchUserBy() throws IOException {
		if (txtUserEmail.getText() != null) {
			this.searchUserByOption("EMAIL");
		} else if (selUserBatch.getText() != null) {
			this.searchUserByOption("BATCH");
		} else if (selUserSkill.getText() != null) {
			this.searchUserByOption("SKILL");
		} else if (selUserProgram.getText() != null) {
			this.searchUserByOption("PROGRAM");
		}
	}

	public void searchUserByOption(String argSearchType) throws IOException {
		switch (argSearchType) {
		case "EMAIL":
			searchforuserbyemailfunction();
			break;
		case "BATCH":
			searchforuserbybatchfunction(argSearchType);
			break;
		case "SKILL":
			searchforuserbyskillfunction1(argSearchType);
			break;
		case "PROGRAM":
			searchforuserbyprogramfunction(argSearchType);
			break;
		}
	}

	public String searchforuserbyemailfunction() {
		txtUserEmail.sendKeys("emaid id");
		searchbtn();
		driver.navigate();
		return driver.getTitle();// Manage users (admin) RegisteredUsersList
	}

	public Registereduserspage searchforuserbybatchfunction(String options) throws IOException {
		Select batches = (Select) new Select(selUserBatch).getOptions();
		batches.selectByValue(options);
		searchbtn();
		driver.navigate();
		return new Registereduserspage();// Manage users (admin) RegisteredUsersList
	}

	public Registereduserspage searchforuserbyskillfunction1(String skill) throws IOException {
		Select skills = (Select) new Select(selUserSkill).getOptions();
		skills.selectByValue(skill);
		searchbtn();
		driver.navigate();
		return new Registereduserspage();//// Manage users (admin) RegisteredUsersList
	}

	public Registereduserspage searchforuserbyprogramfunction(String program) throws IOException {
		Select programs = (Select) new Select(selUserProgram).getOptions();
		programs.selectByValue(program);
		searchbtn();
		driver.navigate();
		return new Registereduserspage();// Manage users (admin) RegisteredUsersList
	}

}
