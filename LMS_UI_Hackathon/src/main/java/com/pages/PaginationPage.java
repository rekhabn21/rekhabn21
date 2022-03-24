package com.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class PaginationPage {
	WebDriver driver;


	public PaginationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/*
	 * Page Objects for Manage user(Admin) Page & Manage Attendance(Admin and Class Staff) page
	 */


	@FindBy(id="linkUsers")
	WebElement linkUsers;
	
	@FindBy(id="linkUnassignedUsers")
	WebElement unAssignedUsers;
	
	@FindBy(id="buttonPagination")
	WebElement pagination;
	
	@FindBy(id="linkManageAssignments")
	WebElement manageAssignment;
	


	public void  clickUsersHomePage() {
		linkUsers.click();
	}

	public void  clickUnassignedUsers() {
		unAssignedUsers.click();
	}
	public void clickPagination() {
		pagination.click();
	} 
	public void clickManageAssignment() {
		manageAssignment.click();
	}
	
}
