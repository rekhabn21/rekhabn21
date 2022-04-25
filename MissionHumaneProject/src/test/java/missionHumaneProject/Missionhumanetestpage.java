package missionHumaneProject;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.MHutils.Basepagedriverfactory;
import com.qa.MHutils.constants;
import com.qa.pageobjectsMHproject.Punepage;
import com.qa.pageobjectsMHproject.TNpage;
import com.qa.pageobjectsMHproject.WBpage;


public class Missionhumanetestpage extends  Basepagedriverfactory {

	public Missionhumanetestpage() throws IOException {
		super();
		}
	
	TNpage tnpage = new TNpage();
	WBpage wbpg=new WBpage();
	Punepage punepg =new Punepage();
	
	@Test (priority = 1)
	public void tndataSearch() throws Exception {
				
	driver.get(constants.Base_URL_TN);
	System.out.println("COVID DATA SEARCH ======>    " + driver.getTitle());
	System.out.println(" Covid data search for TamilNadu Begins");
	tnpage =new TNpage();
		
	try {
		tnpage.datacollectiontocsv(constants.sheetname2, constants.TNpg);
	
	} catch (IOException e) {
		e.printStackTrace();
		}
	
	System.out.println(" Covid data search for TN-COVIDSearch Ends");
	}
	
	@Test(priority = 2)
	public void wbdataSearch() throws Exception {
	
	 wbpg=new WBpage();
		
	driver.get(constants.Base_URL_WB);
	System.out.println("COVID DATA SEARCH     " + driver.getTitle());
	System.out.println(" Covid data search for WestBengal Begins");
	
	wbpg.popuphandling();
	
	wbpg.wbdatacollectiontocsv(constants.sheetname1, constants.WBpg);
	
	
	System.out.println(" Covid data search for WestBengal Ends");
	}
		
	@Test(priority = 3)
	public void  punecovidsearchdata() throws Exception {
	
		punepg =new Punepage();
		
	driver.get(constants.Base_URL_Pune);
	System.out.println("COVID DATA SEARCH     " + driver.getTitle());
	System.out.println(" Covid data search for PUNE Begins");
	
	punepg.popuphandling();
	
	punepg.punedatacollectiontocsv(constants.sheetname3, constants.punepg);
	
	
	System.out.println(" Covid data search for PUNE Ends");
	}
		
	
	
	
	
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test begins====>>> Open new chrome Browser");
		try {
			Basepagedriverfactory.Intialization();
			} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		}

	
	@AfterTest
	public void afterTest() throws IOException {
		System.out.println(" Teardown starts");
		driver.close();
		driver.quit();
		System.out.println("After Test ends====>>> Close chrome Browser");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
