package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AttendancePageObjects {
	
					WebDriver driver;
	
	public AttendancePageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Manage Attendance")
	WebElement ManageAttedance;
		
	@FindBy(id="selAttendanceBatch")
	WebElement selAttendanceBatch;
	
	@FindBy(id="selAttendanceClass")
	WebElement selAttendanceClass;
	
	@FindBy(id="txtCassDate")
	WebElement txtCassDate;
	
	@FindBy(id="radPresent")
	WebElement radPresent;
	
	@FindBy(id="radAbsent")
	WebElement radAbsent;
	
	@FindBy(id="radLate")
	WebElement radLate;
	
	@FindBy(id="radExcused")
	WebElement radExcused;
	
	@FindBy(id="radUnknown")
	WebElement radUnknown;
	
	@FindBy(id="btnSaveAttendance")
	WebElement btnSaveAttendance;
	
	@FindBy(id="btnReset")
	WebElement btnReset;
	
	public void Link_click() {
		ManageAttedance.click();
		
	}
	
	
	public void Attendance_Batch() {
			
		Select attn_dropdown = new Select(selAttendanceBatch);
		attn_dropdown.selectByVisibleText("SDET 02");
	}
	
	public void Attendance_Class() {
		
		Select attn_dropdown = new Select(selAttendanceClass);
		attn_dropdown.selectByVisibleText("Selenium");
	}
	
	public void Class_date() {
		txtCassDate.sendKeys("09/23/21");
		
	}
	
	public void RB_Present() {
		radPresent.click();
		
	}
	
	public void RB_Absent() {
		radAbsent.click();
		
	}
	
	public void RB_Late() {
		
		radLate.click();
	}

	public void RB_Excused() {
		radExcused.click();
	
}
	public void RB_Unknown() {
		radUnknown.click();
		
	}
	
	public void Save_btn() {
		btnSaveAttendance.click();
	}

	public void Reset_btn() {
		btnReset.click();

}
}
