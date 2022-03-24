package com.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class ManageBatchespage  {
	private WebDriver driver;
	public ManageBatchespage() throws IOException {
		super();
		try {
			PageFactory.initElements(driver, this);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	} 
	
	AddorEditbatchespage addeditpg = new AddorEditbatchespage();
	
	
	@FindBy(id = "btnAddBatch")	@CacheLookup	WebElement btnAddBatch;
	@FindBy(id = "selbatchprogram")	@CacheLookup	WebElement selbatchprogram;
	@FindBy(id = "btneditbatch")	@CacheLookup	WebElement btneditbatch;
	@FindBy(id = "btndeletebatch")	@CacheLookup	WebElement btndeletebatch;
	@FindBy(id = "txtboxBatchId") 	@CacheLookup 	WebElement txtboxbatchId;// Batch Id
	@FindBy(id = "txtboxbatchName")	@CacheLookup	WebElement txtboxbatchName;// Batch Name,
	@FindBy(id = "txtboxBatchDesc")	@CacheLookup	WebElement txtboxBatchDesc;// Batch Description,
	@FindBy(id = "selBatchstatus")	@CacheLookup    WebElement selBatchstatus;// select Batch Status,
	@FindBy(id = "txtboxnoofclassses")	@CacheLookup	WebElement txtboxnoofclassses;// enters BatchNo.of classes
	@FindBy(id = "messagebox")	@CacheLookup	WebElement message;
	@FindBy(id = "headerBatchesList")@CacheLookup	WebElement header2;
	@FindBy(id = "batchid")@CacheLookup	List<WebElement> BatchId;
//******************************************************************************************************************

	// Actions and Methods
	
	public void batchprogramfunction(String batchname) {
		Select batch = (Select) new Select((WebElement) selbatchprogram).getOptions();
		batch.selectByValue(batchname);
	}
	
	public void btnAddBatchfunction() {
		btnAddBatch.click();
	}

	public void btneditfunction(){
		 btneditbatch.click();
	}
	
	public void deleteBatchfunction() {
		btndeletebatch.click();
	}
	
	
	public void batchIdfunction() {
		txtboxbatchId.sendKeys("");
	}

	public void batchNamefunction() {
		txtboxbatchName.sendKeys("");
	}

	public void batchDescriptionfunction() {
		txtboxBatchDesc.sendKeys("");
	}

	public void batchStatusfunction() {
		selBatchstatus.click();
	}

	public void noofclassesfunction() {
		txtboxnoofclassses.sendKeys("");
	}
	public void headerfunction() {
		header2.getAttribute("text");
	}
	
	public int batchidfunction() {
		return BatchId.size();
	}
	public void messagedispalyedfunction() {
		message.isDisplayed();
	}
	
//***************************************************************************************************************
//Methods 
	
	public void verifypagetitle() {
	System.out.println(driver.getTitle());
	}
		
	public void batcheslistdisplayed() {
	header2.isDisplayed();
	header2.getAttribute("text");
	
	if (header2.isDisplayed() == true  )
		 if (BatchId.size()>0)  {
		System.out.println( "Batches list not empty");
	}
		 else{
			 System.out.println("Batch list empty- no batches");
		 }
	}
			
	public  AddorEditbatchespage AddBatchfunction() throws IOException {
		btnAddBatch.click();
		driver.navigate();
		System.out.println(driver.getTitle());
		return new AddorEditbatchespage();
	}

	 	public void deletebatchlistfunction() {
 		btndeletebatch.click();
 		String msg = message.getAttribute("text");
 		System.out.println(msg);
 	}
 	
	 	public  AddorEditbatchespage EditBatchfunction() throws IOException {
			btneditbatch.click();
			driver.navigate();
			System.out.println(driver.getTitle());// edit page of corresponding to batchname selected for edit
			return new AddorEditbatchespage();
	}
	 	
	 	public void messagepresentfunction() {
	 		message.isDisplayed();
	 		String msg =message.getText();
	 		System.out.println(msg);
	 	
	 	}
	 	
	
	 	
	 	
}