package com.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FunctionsPage {
//private WebDriver driver;
	
	WebDriver driver1;	
	@FindBy (xpath="//input[@id='btnprogramstTab']")
	@CacheLookup
	WebElement programsTab;
	
	@FindBy (xpath="//input[@id='txtProgramName']")
	@CacheLookup
	WebElement programName;
	
	@FindBy (xpath="//input[@id='txtProgramDescription']")
	@CacheLookup
	WebElement programDescription;
	
	@FindBy (xpath="//input[@id='radPrgmActiveStatus']")
	@CacheLookup
	WebElement active;
	
	@FindBy (xpath="//input[@id='radPrgmInActiveStatus']")
	@CacheLookup
	WebElement inactive;
	
	@FindBy (xpath="//input[@id='btnProgramSubmit']")
	@CacheLookup
	WebElement submitBtn;
	
	@FindBy (xpath="//input[@id='btnEdit']")
	@CacheLookup
	WebElement editBtn;
	
	@FindBy (xpath="//input[@id='txtexistingProName']")
	@CacheLookup
	WebElement existingProName;
	
	@FindBy (xpath="//input[@id='btnDelete']")
	@CacheLookup
	WebElement deleteBtn;
	
	@FindBy (xpath="//input[@id='btnAddTab']")
	@CacheLookup
	WebElement addTabBtn;
	
	@FindBy (xpath="//input[@id='btnTrash']")
	@CacheLookup
	WebElement trashBtn;
	/*private By programsTab = By.id("btnprogramstTab");
	public By programName = By.id("txtProgramName");
	private By programDescription= By.id("txtProgramDescription");
	private By active = By.id("radPrgmActiveStatus");
	private By inactive = By.id("radPrgmInActiveStatus");
	private By submitBtn = By.id("btnProgramSubmit");
	private By editBtn = By.id("btnEdit");
	private By existingProName = By.id("txtexistingProName");
	private By deleteBtn = By.id ("btnDelete");
	private By addTabBtn = By.id("btnAddTab");
	private By trashBtn = By.id("btnTrash"); */
	 
     
	 //2.constructor of the page class
		public FunctionsPage (WebDriver driver) {
			this.driver1=driver;
			try {
				PageFactory.initElements(driver, this);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		//3. page actions
		public void programsTab() {
			programsTab.click();
		}
		public void programName() {
			programName.sendKeys("SDET");
		}
		public void programDescription() {
		programDescription.sendKeys("This is my first program");
		}
		public void active() {
			active.click();
		}
		public void existingProName() {
			existingProName.getText();
		}
		public void inactive() {
			inactive.click();
		}
		public void submitBtn() {
			submitBtn.click();
		}
		public void editBtn() {
			editBtn.click();
		}
		public void deleteBtn() {
			deleteBtn.click();
		}
		public void addTabBtn() {
			addTabBtn.click();
		}
		public void trashBtn() {
			trashBtn.click();
		}
 public void manageProDisplayList() {
		programName.getText();
		programDescription.getText();
	    active.getText();
	   
 }
 public void editProDisplayList() {
	 programName.getText();
	 programDescription.getText();
	 active.getText();
	 }
 public void addEditProgramPage() {
	    addTabBtn();
		programName.sendKeys("SDET");
		programDescription.sendKeys("this is program");
	    active.click();
	   
}
 
 public void editExistingProgram() {
	 if ((programName).getText()=="SDET")
	 {
	 programDescription.getText();
	 active.getText();
	 } 
 }
  
 public void deleteProDisplayList() {
	 if((programName).getText()=="SDET")
	 {
	deleteBtn.click();
     }
 }
 
 
 public void viewExistingProg(String Prog) {
	 if((programName).getText()=="SDET")
	 {
	 programName.getText();
	 programDescription.getText();
	 active.getText();
	 }
   }
 public String DateTimeFormat()
 {
	 LocalDate dateObj = LocalDate.now();
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/DD/YY hh:mm");
     String date = dateObj.format(formatter);
     System.out.println(date);
     return date;
 }
 
 public void trash() {
	 if((programName).getText()=="SDET")
	 {
	 trashBtn.click();
	 
     }
 }
 public void deleteExistingProg(String progName) {
	 if((programName).getText()==progName)
	 {
		 
     }
 }

public void ProgramCreationtime() {
	DateTimeFormat();	
}
public void ProgramModifiedtime() {
	DateTimeFormat();	
}
}

