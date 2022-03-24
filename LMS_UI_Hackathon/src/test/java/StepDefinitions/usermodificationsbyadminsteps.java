package StepDefinitions;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.util.ConfigReader;
import com.util.Testutils;
import com.pages.LaunchPage;
import com.pages.LmsAdminUserPage;
import com.pages.Registereduserspage;
import com.pages.LoginPage;
import com.pages.userdetailspage;

import io.cucumber.java.en.*;

public class usermodificationsbyadminsteps  {
		
	LaunchPage launchpg;
	LoginPage lpg;
	WebDriver driver;
	LmsAdminUserPage lmsuserpg ;
	Registereduserspage registereduserpg;
	userdetailspage userdetailspg;
 
public usermodificationsbyadminsteps() throws IOException {
		super();
		ConfigReader confi = new ConfigReader();
		//driver =DriverFactory.Initialization();
		
		//System.out.println(prop.getProperty("URL"));
		
		
	 driver.get(confi.prop.getProperty("URL") + confi.prop.getProperty("Basepath_login"));
		
		launchpg = new LaunchPage(driver);
		launchpg.launchtologinpage();
		lpg =new LoginPage(driver);
		Assert.assertTrue("Login", true);
		lpg.loginfunction();
		driver.getTitle();
	}
	
 // Background step
@Given("Admin is logged in, Programs and Batches were created already")
public void admin_is_logged_in_programs_and_batches_were_created_already() {
 
	 String pgtitle = driver.getTitle();
	Assert.assertTrue(pgtitle, true);
	}
//=================================================================================================================================	
//#1 Scenario: Check whether Admin can search users by giving Email or Batch or Skill or program
	
	@Given("Admin is on LMS Admin User Page")
	public  void admin_is_on_lms_admin_user_page() {
		try {
			lmsuserpg= new LmsAdminUserPage();
			lmsuserpg.verifypagetitle();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	@When("Admin clicks on search button after entering  Email or Batch or Skill or program")
	public void admin_clicks_on_search_button_after_entering_email_or_batch_or_skill_or_program(String aoption) {
	    try {
			lmsuserpg.searchUserByOption(aoption);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	@Then("Admin will be navigated to Manage users\\(admin) page where Registered User list will be displayed")
	public void admin_will_be_navigated_to_manage_users_admin_page_where_registered_user_list_will_be_displayed() {
	    try {
			registereduserpg =new Registereduserspage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	}

//*********************************************************************************************************************************
//#2 Scenario: Check whether Admin can edit registered user in Manage users(admin) page
@Given("Admin is on Manage users(admin) page, Registered User list,and clicks on edit icon")
public void admin_is_on_manage_users_admin_page_registered_user_list_and_clicks_on_edit_icon() {
    try {
		registereduserpg =new Registereduserspage();
		registereduserpg.verifycurrenrtpagetitle();
		registereduserpg.editusersicon();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

@When("Admin will be navigated to Manage users\\(admin) page where User details will be displayed")
public void admin_will_be_navigated_to_manage_users_admin_page_where_user_details_will_be_displayed() {
	try {
		userdetailspg= new userdetailspage();
		userdetailspg.verifypagetitlefunction();
		
	} catch (IOException e) {
		e.printStackTrace();
	}
   }

@Then("Admin will be able to edit User details like Time zone, User role batch, Program and click on save")
public void admin_will_be_able_to_edit_user_details_like_time_zone_user_role_batch_program_and_click_on_save( String option) {
	//timezone update
	userdetailspg.timezonelistfunction(option);
	userdetailspg.messagefunction();
	
	//userrole update
	userdetailspg.userrolelistfunction(option);
	userdetailspg.messagefunction();
	
	//batch name update
	userdetailspg.batchnamelistfunction(option);
	userdetailspg.messagefunction();
	
	//program update
	userdetailspg.programnamelistfunction(option);
	userdetailspg.messagefunction();
	
	// driver is on userdetails page...navigate back to registered users list page
	driver.navigate().back();
	}

//=================================================================================================================================	

//#3 Scenario: Check whether Admin can delete particular registered user in Manage users(admin) 

@Given("Admin is on Manage users\\(admin) page, Registered Users list")
public void admin_is_on_manage_users_admin_page_registered_users_list() {
	try {
		registereduserpg =new Registereduserspage();
		registereduserpg.verifycurrenrtpagetitle();
		
	} catch (IOException e) {
		e.printStackTrace();
	}
}

@When("Admin clicks on trash icon of particular registered user")
public void admin_clicks_on_trash_icon_of_particular_registered_user() {
	try {
		registereduserpg.deletefunction() ;
	} catch (IOException e) {
	e.printStackTrace();
	}
}

@Then("Deleted registered user will be removed from Registered users list")
public void deleted_registered_user_will_be_removed_from_registered_users_list() {
	registereduserpg.alertmsgfunction();
   
}
//=================================================================================================================================	

//#4 Scenario: Check whether Admin will be navigated to manage users(admin) page when clicked on eye icon

@When("Admin clicks on eye icon for particular user")
public void admin_clicks_on_eye_icon_for_particular_user() {
	try {
		registereduserpg.verifyeyeiconfunction();
	} catch (IOException e) {
				e.printStackTrace();
	}
}

@Then("Admin will be navigated to Manage users(admin) page and view the User details only in read only format")
public void admin_will_be_navigated_to_manage_users_admin_page_and_view_the_user_details_only_in_read_only_format() {
   userdetailspg.verifypagetitlefunction();
   assertTrue(driver.getTitle(),true);
   
}

//=================================================================================================================================	

}
