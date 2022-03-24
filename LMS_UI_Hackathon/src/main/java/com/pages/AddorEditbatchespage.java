package com.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.Testutils;


public class AddorEditbatchespage {
	private WebDriver driver;
	

	public AddorEditbatchespage() throws IOException {
		super();
		try {
			PageFactory.initElements(driver, this);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	AddorEditbatchespage addeditpg ;
	ManageBatchespage mbpg = new ManageBatchespage();

	@FindBy(id = "txtBatchName")	@CacheLookup 	WebElement batchName;
	@FindBy(id = "txtBatchDescription")	@CacheLookup 	WebElement batchDesc;
	@FindBy(id = "radBatchInActiveStatus") 	@CacheLookup 	WebElement inactiveradiobtn;
	@FindBy(id = "radBatchActiveStatus") 	@CacheLookup 	WebElement activeradiobtn;
	@FindBy(id = "txtBatchNoClasses")	@CacheLookup 	WebElement batchnum;
	@FindBy(id = "btnSubmit")	@CacheLookup	WebElement submit;
	@FindBy(id = "addBtn")	@CacheLookup 	WebElement addBtn;
	@FindBy(id = "editBtn")	@CacheLookup 	WebElement editBtn;
	

	public void addbuttonfunction() {
		addBtn.click();
	}

	public void editbuttonfunction() {
		editBtn.click();
	}

	public void batchnamefunction() {
		batchName.sendKeys("");
	}

	public void BatchDescriptionfunction() {
		batchDesc.sendKeys("");
	}

	public void activeselectfunction() {
		activeradiobtn.click();
	}

	public void inactiveselectfunction() {
		inactiveradiobtn.click();
	}

	public void BatchNofunction() {
		batchnum.sendKeys("");
	}

	public void submitfunction() {
		submit.click();
	}

	public void verifypagetitle() {
		System.out.println(driver.getTitle());
	}

	public AddorEditbatchespage addbatchfunction() throws IOException {
		try {
			ManageBatchespage mbpg = new ManageBatchespage();
			mbpg.AddBatchfunction();
			driver.navigate();
			driver.getTitle();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return new AddorEditbatchespage();
	}
		
	public  void  verifyeditfunction() {
		try {
			mbpg = new ManageBatchespage();
			mbpg.btneditfunction();
			addeditpg.batchName.getText();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void newbatchfunction() {
		System.out.println(driver.getTitle());
		batchName.sendKeys(Testutils.batchName);
		batchnum.sendKeys(Testutils.batchnum);
		batchDesc.sendKeys(Testutils.batchDesc);
		activeradiobtn.click();
		submit.click();
		driver.navigate().back();
		driver.getTitle();
		try {
			mbpg = new ManageBatchespage();
			//assertTrue
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void editexistingbatchfunction() {
		System.out.println(driver.getTitle());
		System.out.println(batchName.getText());// edit page of corresponding to batchname selected for edit
		batchDesc.sendKeys(Testutils.batchDescnew);
		batchnum.sendKeys(Testutils.batchnum1);
		activeradiobtn.click();
		submit.click();
		driver.navigate().back();
		driver.getTitle();
		try {
			mbpg = new ManageBatchespage();
			//assertTrue
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	
	
	/*
	 * Given Admin is on Add tab of ADD/Edit batches page (admin) by clicking on Add Batch in Manage Batches Page(admin) 
	 * When Admin clicks on submit button after entering BatchId,Batch Name,Batch Description,select Batch Status, enters BatchNo.of classes
	 *  Then Created Batch details will be displayed in Manage Batches Page(Admin) with
	 * auto generated Created Date and Modified date in MM/DD/YY format
	 */

}
