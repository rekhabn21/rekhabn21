package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;


import com.factory.DriverFactory;
import com.pages.SubmitPageObjects;

import com.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SubmitStepdefinition {
	
	public SubmitStepdefinition() throws IOException {
		super();
	ConfigReader confi = new ConfigReader();
	//driver =DriverFactory.Initialization();
	driver.get(confi.prop.getProperty("URL") + confi.prop.getProperty("Basepath_login"));

	}
	
   WebDriver driver;
	
	SubmitPageObjects sub = new SubmitPageObjects(driver);
	
	@Given("Admin is on Notification page")
	public void admin_is_on_notification_page() {
	    sub.Link_click();
	}

	@When("Admin clicks on submit button")
	public void admin_clicks_on_submit_button() {
		sub.Sel_ProName();
		sub.Hackathon_Name();
		sub.Hackathon_Desc();
		sub.Hackathon_Date();
		sub.Hackathon_Comments();
	    
	}

	@Then("Notifications will be submitted successfully")
	public void notifications_will_be_submitted_successfully() {
	   
		sub.Save_btn();
		System.out.println("Saved Successfully");
	}
	
	
}
