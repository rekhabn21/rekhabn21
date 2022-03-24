package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Registereduserspage  {
	private WebDriver driver;
	public Registereduserspage() throws IOException {
		super();
		try {
			PageFactory.initElements(driver, this);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	LmsAdminUserPage lmsuserpg = new LmsAdminUserPage();
	Registereduserspage registereduserpg;
	userdetailspage userdetailspg;

	// driver navigated from lms user admin page to this page during search for
	// registered users

	@FindBy(id = "btnViewRegUsers") 	@CacheLookup	WebElement btnViewRegUsers;// eyeicon

	@FindBy(id = "btnEditRegUsers")	@CacheLookup	WebElement btnEditRegUsers;// edit

	@FindBy(id = "btnViewRegUsers")	@CacheLookup	WebElement btnDelRegUsers; // delete

	@FindBy(id = "alertmsg")	@CacheLookup	WebElement alertmsg; //
	
//**************************************************************************************
// Actions	
	
	public void registedusersicon() {
		btnViewRegUsers.click();
	}

	public void editusersicon() {
		btnEditRegUsers.click();
	}

	public void deleteusericon() {
		btnDelRegUsers.click();
	}

	public void alertmsgfunction() {
		alertmsg.getText();
	}

//**************************************************************************************************************************
	// Scenario2: Check whether Admin can edit registered user in Manage
	// users(admin) page

	public String verifycurrenrtpagetitle() { // driver is in RegisteredUsers list
		return driver.getTitle();
	}

	public userdetailspage editusersfunction() throws IOException {
		registedusersicon();
		driver.navigate();
		driver.getTitle();
		return  new userdetailspage();// driver navigated to user details page
	}
	
	public void editTimezonefunction(String zone) {
		driver.getTitle();
		try {
			userdetailspg = new userdetailspage();
			userdetailspg.timezonelistfunction(zone);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	public void Userrolebatchfunction(String role) {
		driver.getTitle();
		try {
			userdetailspg = new userdetailspage();
		} catch (IOException e) {
			userdetailspg.userrolelistfunction(role);
			e.printStackTrace();
		}
	}

	public void editprogramfunction(String program) {
		driver.getTitle();
		try {
			userdetailspg = new userdetailspage();
			userdetailspg.programnamelistfunction(program);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// driver is in admin userdetails page

// *************************************************************************************************************

	public void deletefunction() throws IOException {
		// driver is in admin userdetails page
		driver.navigate().back();
		registereduserpg =  new Registereduserspage();
		driver.getTitle();// driver is in RegisteredUsers list
		deleteusericon();
	}

	public void userdeletedfunction() {
		alertmsgfunction();
		driver.getTitle();
	}

//***************************************************************************************************************************
// Scenario4: Check whether Admin will be navigated to manage users(admin) page when clicked on eye icon

	public userdetailspage verifyeyeiconfunction() throws IOException {
		driver.getTitle();
		registedusersicon();
		driver.navigate();
		return new userdetailspage();
	}

	public void userdetailsfunction() {
		driver.getTitle();// read-only format of manage users adminpage

	}

}
