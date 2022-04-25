	package com.qa.pageobjectsMHproject;
	
	import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.opencsv.CSVWriter;
import com.qa.MHutils.Basepagedriverfactory;
	
	public class TNpage extends Basepagedriverfactory {
			
		
		public TNpage() throws IOException {
			super();
			try {
				PageFactory.initElements(driver, this);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	
		JavascriptExecutor js = (JavascriptExecutor)driver;

		
		
		// webelements from TNcovidhelpsearchpage
	
		@FindBy(css= "main[id='main'] h1")	@CacheLookup
		WebElement 	pageheading ;
			
		@FindBy(css= "select[aria-controls='dtBasicExample']")	@CacheLookup
		WebElement selectdrpdwn ;
		
		@FindBy(css="div[role='status']")@CacheLookup
		WebElement searchStatus;
		
		// table header elements//
		@FindBy(xpath="//tbody/tr[1]/th[1]")	WebElement	tablefirstRow;
		
		@FindBy(xpath= "//tr//th[contains(.,'S.NO')]")	@CacheLookup
		WebElement serialNo;
		
		@FindBy(xpath= " //tr//th[contains(.,'District')]")	@CacheLookup
		WebElement districtNamecol;
		
		@FindBy(xpath="//tr//th[contains(.,'Institution')] ")	@CacheLookup
		WebElement institutionNamecol;
		
		//covid beds info
		@FindBy(xpath="//tr//th[contains(.,'COVID BEDS')]")	@CacheLookup
		WebElement covidBedscol;
		
		@FindBy(xpath= "//thead//tr[2]//th[3]")@CacheLookup
		WebElement vacantbedscol;
		
		//oxygen info
		@FindBy(xpath= "//tr//th[contains(., 'OXYGEN SUPPORTED BEDS')]")	@CacheLookup
		WebElement o2beds;
			
		@FindBy(xpath= "//tr[2]//th[6]")@CacheLookup
		WebElement oxygenUnitscol;
		
		//icu beds info
		@FindBy(xpath= "//tr//th[contains(., 'ICU BEDS')]")	@CacheLookup
		WebElement icubedscol;
		
		@FindBy(xpath= "//tr[2]//th[12]")
		WebElement icuBedsVacantcol;
		
		//ventilators info
		@FindBy(xpath= "//tr//th[contains(., 'VENTILATOR')]")	@CacheLookup 
		WebElement ventilatorscol;
		
		@FindBy(xpath= "//tr[2]//th[15]")
		WebElement ventilatorsAvailable;
		
		//updated
		@FindBy(xpath= "//tr//th[contains(., 'Last updated')]")
		WebElement lastUpdated;
		
		
		@FindBy(xpath= "//tr//th[contains(.,'Contact Number')]")
		WebElement contactNum;
		@FindBy(xpath="//th[contains(.,'Remarks')]")
		WebElement remarks;
		
		
		
		@FindBy(xpath= "//div//a[text()='Previous']")@CacheLookup
		WebElement previousBtn;
		
		@FindBy(xpath= "//a[@id='dtBasicExample_next']")@CacheLookup
		WebElement nextBtn;
		
	/*
	@FindBy(xpath= "")@CacheLookup
	WebElement ;*/
	
	
	//Actions and Methods =======================
	
	public void pageheadingfunction() {
		 String heading =pageheading.getText();
			System.out.println("==========" +heading+"=============");
	}
	
	
	public String searchStatusfunction() {
		String s = searchStatus.getText();
		System.out.println("Search Status : "+  s);
		return  s;
	}	
	
	
	public void selectdropdownfunction() {
		selectdrpdwn.click();
		Select select= new Select(selectdrpdwn);
		select.selectByVisibleText("100");
		System.out.println(" Select rows by 100");
	}
	
	
	
	public void districtNamefunction() {
		districtNamecol.getText();
		}	
	
	public void institutionNamefunction() {
		institutionNamecol.getText();
	}	
		
	public void vacantbedsfunction() {
	vacantbedscol.getText();
	}

	public void oxygenunitsfunction() {
	oxygenUnitscol.getText();
	}
	
	public void icuBedsVacantfunction() {
	icuBedsVacantcol.getText();
	}
	
	public void ventilatorsfunction() {
		ventilatorsAvailable.getText();
	}
	
	
	public void updatedfunction() {
	lastUpdated.getText();
	}
	
	public void contactnumfunction() {
	contactNum.getText();
	}
	
	public void remarksfunction() {
	remarks.getText();
	}
	
	public void nextbuttonfunction() {
	try {
		while (nextBtn.isDisplayed()==true) {
			nextBtn.click();
	}
	}catch( Exception e) {
		System.out.println("End of Pages");
	}
	}
	
	public void safeJavaScriptscrollup(WebElement element) throws Exception {
		try {
			if (element.isDisplayed()) {
				System.out.println("Scroll up to the top of the table");

				js.executeScript("arguments[0].scrollIntoView();", element);
			}
			}catch (Exception n) {
			 System.out.println("End of Tablecontents");
			}
	}
	
		
	public void datacollectiontocsv(String SheetName, String keyword) throws Exception {
		System.out.println("=== Entering datacollectiontocsv() ===");
	
		FileWriter outputfile = new FileWriter(new File("Covidata" + keyword + ".csv"));
		CSVWriter writer = new CSVWriter(outputfile);
		String srchStatus = new String();
		String[] header = { "District", "Institution","Institution contact num", "Covidbeds Avaialable", "O2units Available", "ICU beds avaialable",
				"Ventilators Avaialble", "Last Updated", "Remarks" };
		
		writer.writeNext(header);
	
		//System.out.println("\n On TN state covid search page ");
		System.out.println(	driver.getTitle());
		
		try {
		
		pageheadingfunction();
		selectdropdownfunction();//select 100 rows
		srchStatus = searchStatusfunction();// shows 1 to 100 of 567 entries
		}catch(Exception e) {
	}
		int pageno =1;
		int  total_rows  = Integer.parseInt(srchStatus.substring(srchStatus.indexOf("of")+3, srchStatus.indexOf("entries")-1));
		System.out.println("Total Records : " + total_rows);
			
		WebElement nextpageBTn =driver.findElement(By.xpath("//a[@id='dtBasicExample_next']"));
	try {	
		for (int p=1;p<total_rows; p++) {
				
		int	rowsperpage=driver.findElements(By.xpath("//table[@id='dtBasicExample']/tbody/tr")).size();
		
		System.out.println("No.of Rows in this page:"+rowsperpage);
						
			for (int r=1;r<=rowsperpage;r++){
				
					 WebElement d = driver.findElement(By.xpath("//tbody/tr["+r+"]/td[1]"));
					 String District =d.getText();
					 
					 WebElement hospName  = driver.findElement(By.xpath("//tbody/tr["+r+"]//td[2]"));
					 String InstitutionName =hospName.getText();
					
					 WebElement vacantbeds= driver.findElement(By.xpath("//tbody/tr["+r+"]//td[5]"));
					 String Vacantbedsavaialble =vacantbeds.getText();
					
					 WebElement O2 = driver.findElement(By.xpath("//tbody/tr["+r+"]//td[8]"));
					 String OxygenUnits =O2.getText();
					 			 
					 WebElement icubeds=driver.findElement(By.xpath("//tbody/tr["+r+"]//td[14]"));
					 String IcuBedsavailable =icubeds.getText();
					
					 WebElement vbeds  =driver.findElement(By.xpath("//tbody/tr["+r+"]//td[17]"));
					 String Ventilatorunits =vbeds.getText();
					 
					 WebElement  update = driver.findElement(By.xpath("//tbody/tr["+r+"]//td[18]"));
					 String Lastupdated =update.getText();
					
					 WebElement contact =driver.findElement(By.xpath("//tbody/tr["+r+"]//td[19]"));
					 String HospContactNum =contact.getText();
					 
					 WebElement remarks  = driver.findElement(By.xpath("//tbody/tr["+r+"]//td[20]"));
					 String Remarks = remarks.getText();
					 
					 String[] dataRows = {District ,InstitutionName,HospContactNum ,Vacantbedsavaialble,OxygenUnits,IcuBedsavailable,Ventilatorunits,
							 Lastupdated,Remarks};
						writer.writeNext(dataRows);
				}
								
			/*if ( nextpageBTn.isEnabled()  == false) {
				System.out.println("End of table");
				break;
			}else {	driver.findElement(By.xpath("//a[@id='dtBasicExample_next']")).click();*/
//				
			try{
				if(rowsperpage<100) {
					System.out.println( " Next page Button is disabled---> end of rows");
					break;
				}
			else {
		
			nextpageBTn =driver.findElement(By.xpath("//a[@id='dtBasicExample_next']"));
			nextpageBTn.click(); 
			pageno++;
			System.out.println("go to next set of rows in the table");
			System.out.println( "\n next page :" +pageno); 
			searchStatusfunction();
			safeJavaScriptscrollup(pageheading);
			}
			}
			catch(Exception s) {
			}
			} 	
		}catch (StaleElementReferenceException s)	{
	}
			writer.close();
			System.out.println("\n==========Enter all data to excel from CSV=============");
			System.out.println("=== Leaving datacollectiontocsv() ===");
		}
	}
	
