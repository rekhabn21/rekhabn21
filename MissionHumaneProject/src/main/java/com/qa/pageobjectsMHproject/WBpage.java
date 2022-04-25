package com.qa.pageobjectsMHproject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencsv.CSVWriter;
import com.qa.MHutils.Basepagedriverfactory;

public class WBpage extends Basepagedriverfactory {

	public WBpage() throws IOException {
		super();
		try {
			PageFactory.initElements(driver, this);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;

	/*
	 * @FindBy(xpath= "")@CacheLookup WebElement ;
	 */

	@FindBy(xpath = "//div[@class='mx-1 px-1 text-primary text-uppercase title-text col']") 	@CacheLookup	WebElement pageheading;
	@FindBy(css = "button[class='btn btn-primary']")	@CacheLookup	WebElement loadmoreBtn;

	@FindBy(xpath = "//tbody/tr")	List<WebElement> totalRows;
	
	@FindBy(xpath  ="//div[@class='modal-content']")WebElement popupbox ;
	@FindBy(xpath  ="//div[@class='modal-content']//button[@aria-label='Close']") WebElement popupcancel;
	
	
	// Actions and Methods =======================

	public void pageheadingfunction() {
		String heading = pageheading.getText();
		System.out.println("==========" + heading + "=============");
	}

	public int pagination() {
		int pageno = 1;

		try {
			while (loadmoreBtn.isDisplayed()) {
				js.executeScript("arguments[0]. click();", loadmoreBtn);
				pageno++;
			}
		} catch (Exception e) {

			System.out.println("  End of LOADING PAGES  ");
		}
		System.out.println("Total pages   " + pageno);
		return pageno;
	}

	public void safeJavaScriptscrollup(WebElement element) throws Exception {
		try {
			if (element.isDisplayed()) {
				System.out.println("Scroll up to the top of the table");

				js.executeScript("arguments[0].scrollIntoView();", element);
			}
		} catch (Exception n) {
			System.out.println("End of Tablecontents");
		}
	}
	public void popuphandling() {
		try {
			if( popupbox.isDisplayed()) {
				popupcancel.click();
			}
			else {
				System.out.println("No Pop-Ups");
			}
		}catch(Exception ne) {
			System.out.println(ne);
			}
		}
	
	
	public void wbdatacollectiontocsv(String SheetName, String keyword) throws Exception {
		System.out.println("=== Entering datacollectiontocsv() ===");
		FileWriter outputfile = new FileWriter(new File("Covidata" + keyword + ".csv"));
		CSVWriter writer = new CSVWriter(outputfile);
		String srchStatus = new String();
		String[] header = { "Hospital Name", "Hospital Number", "Hospital address", "O2units Available",
				"ICU with ventilators", "Last Updated" };
		writer.writeNext(header);
		pageheadingfunction();

		int totalpages = pagination();
		System.out.println("Total number of pages to search " + totalpages);

		int rownum = totalRows.size();
		System.out.println("\nTotal number of rows " + rownum);

		safeJavaScriptscrollup(pageheading);
		popuphandling();
		
		//int pageno = 1;
		
			for (int r = 1; r <= rownum; r++) {

				WebElement hospbtn = driver.findElement(By.xpath("//tbody/tr[" + r + "]/td[1]/div[1]/button[1]//*[name()='svg']"));
				hospbtn.click();

				WebElement hosp = driver.findElement(By.xpath("//tbody/tr[" + r + "]/td[1]/div[1]/button[1]"));
				String hospnamelink = hosp.getText();
				System.out.println(hospnamelink);

				WebElement update = driver.findElement(By.cssSelector("span[class='text-muted font-weight-bold']"));
				String updateStatus = update.getText();

				WebElement phno = driver.findElement(By.xpath("//td/p/span[contains(text(),'Phone')]"));
				String hospphone = phno.getText();

				WebElement addr = driver.findElement(By.xpath("//td/p/span[contains(text(),'Address')]"));
				String hospAddress = addr.getText();

				WebElement witho2 = driver.findElement(By.xpath("//tbody/tr[" + r + "]/td[3]/span[1]/span[1]"));
				String bedswithoxygen = witho2.getText();

				WebElement vent = driver.findElement(By.xpath("//tbody/tr[" + r + "]/td[5]/span[1]/span[1]"));
				String icuwithVentilator = vent.getText();
				driver.findElement(By.xpath("//tbody/tr[" + r + "]/td[1]/div[1]/button[1]//*[name()='svg']")).click();
				String[] data = { hospnamelink, hospphone, hospAddress, bedswithoxygen, icuwithVentilator,
						updateStatus };
				writer.writeNext(data);

			}
			try {
			if (loadmoreBtn.isDisplayed() == true) {
				loadmoreBtn.click();
				//pageno++;
				//System.out.println(" Nextpage " + pageno);
			} else {
				System.out.println("End of page");
			}
			}catch (Exception se) {
			
			}			
		
		writer.close();
		System.out.println("\n==========Enter all data to excel from CSV=============");
		System.out.println("Webscrapping  completed");
	}
}
