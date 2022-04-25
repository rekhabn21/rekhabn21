package missionHumaneProject;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class MyHospitalAssignment {

	static WebDriver driver = null;
	@Test
	public void f() {
		System.out.println("Start Test");
		int noOfHosp = 0;

		// zones dropdown select
		WebElement Zone = driver.findElement(By.id("ddlZone"));// webelement zone created for the drop down
		Select ZoneName = new Select(Zone); // zone dropdown list selected
		List<WebElement> AllZones = ZoneName.getOptions();
		System.out.println("The number of zones are " + (AllZones.size()));
		for (int i = 1; i < AllZones.size(); i++) {
			System.out.println("Zone name => " + AllZones.get(i).getText());
			ZoneName.selectByIndex(i);
			noOfHosp = driver.findElements(By.xpath("//div[@id='accordionExample']/div")).size();
			System.out.println("Number of hospitals : " + noOfHosp);

			//if (ZoneName.equals("West Zone")) {//------>> if u want just one zone use this loop
			iteratingHospital(noOfHosp); // call iteration method for Hospitals in each zone

			//}

			// Refreshing values so that no to get org.openqa.selenium.StaleElementReferenceException
			Zone = driver.findElement(By.id("ddlZone"));
			ZoneName = new Select(Zone);
			AllZones = ZoneName.getOptions();
		}
	}
// end of for loop

	public static void iteratingHospital(int WestZone) {
		for (int i = 1; i <= WestZone; i++) {
			WebElement hospital = driver.findElement(By.xpath("//div[@id='headingOne-" + i + "']//div//a[@class=' hospital-info']"));
			hospital.click();
			driver.switchTo().activeElement();// Switching to modal pop-up
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblhosname")));
			String HospName = driver.findElement(By.id("lblhosname")).getText();// hospital Address
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lblhosCno")));
			String HospContact = driver.findElement(By.xpath("//span[@id='lblhosCno']")).getText();// hospital contact
			System.out.print("  iteration " + i + " |  Hospital Name  " + HospName + " |  Hospital Contact No. " + HospContact);
			driver.findElement(By.xpath("//button[@aria-label='Close']")).click(); // Close modal popup

			// no .of beds
			String VacantBed = driver.findElement(By.xpath("//div[@class='acc-btn']//div[contains(@class,'caption-text total-vacant-bed')]")).getText();
			System.out.print(" | Total no. Of VacantBeds " + VacantBed);
					
			// o2 bed availability
			String O2beds = driver.findElement(By.xpath("//div[@id='collapseOne-2']//li[2]//div[1]//div[2]")).getText();
			System.out.print(" | no.Of O2units " + O2beds);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='collapseOne-" + i + "']/div/ul/li[4]/div/div[2]")));
			
			// ventilator beds
			String ventilator = driver.findElement(By.xpath(" //div[@id='collapseOne-2']//li[4]//div[1]//div[1]")).getText();
			System.out.print(" | Ventilators" + ventilator);
			System.out.println(" ");

		}
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println(" Start Before Test");
		System.setProperty("webdriver.chrome.driver", "C:\\selenium drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://office.suratsmartcity.com/SuratCOVID19/Home/COVID19BedAvailabilitydetails");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("End Before Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println(" Star AfterTest");
		//driver.close();
		System.out.println("End After Test");
	}
}
