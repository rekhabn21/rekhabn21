package com.qa.MHutils;

import org.openqa.selenium.support.ui.WebDriverWait;

public class constants {
	
	public static  final String chromepath= "src/test/resources/drivers/chromedriver.exe";
	public static final String firefoxpath= "src/test/resources/drivers/geckodriver.exe";
	
	public static final String Base_URL_WB = "https://westbengal.covidsafe.in/";
	public static final String Base_URL_TN = "https://stopcorona.tn.gov.in/beds.php";
	public static final String Base_URL_Pune = "https://pune.covidsafe.in/";
	

	//excel file location and sheetname
	public static String excelFilepath=	"src/test-output/testdatacollected/coviddata.xlsx";
	public static final String sheetname1= "WBdata";	
	public static final String sheetname2 ="TNdata";
	public static final String sheetname3 ="Pune covid data";
	
	public static final String TNpg ="TN page";
	public static final String WBpg ="WBpage";
	public static final String punepg ="Punepage";
	
	
	
}




