package StepDefinitions;

import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.pages.ClassesModificationAdminPage;
import com.pages.UploadByAdminPage;
import com.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UploadByAdminStepDef {
	WebDriver driver;
	int classSize;
	int newSize;
	public UploadByAdminPage pageObj;
	
	
	/*
	 * Background  : Admin is logged in,Batches and Classes were created already
	 */
	
	@Given("Admin is logged in,Batches and Classes were created already")
	public void admin_is_logged_in_Batches_and_Classes_were_created_already() {
		ConfigReader confi = new ConfigReader();
		driver.get(confi.prop.getProperty("URL") + confi.prop.getProperty("Basepath_login"));

		//DriverFactory.initialiseDriver();
		//driver = DriverFactory.driver;
    pageObj = new UploadByAdminPage(driver);
	pageObj = new UploadByAdminPage(driver);
	}
	/*   Manage Recording (Admin page)
	 *   Feature : Different Upload features by Admin
	 *   Scenario : Check whether Admin can upload Recording
	 *  Link name on the Home page : "Manage Recordings"
	 * 
	 */

	@Given("Admin is on Manage Recording -Admin page by clicking Manage Recordings tab")
	public void admin_is_on_Manage_Recording_Admin_page_by_clicking_Manage_Recordings_tab() {
		pageObj.clickManageRecordings();
	}

	@When("Admin upload recording after selecting Batch and topic")
	public void admin_upload_recording_after_selecting_Batch_and_topic() {
		pageObj.selectBatchFromDropDown("SDET");
		pageObj.selectTopicFromDropDown("Selenium");
		pageObj.clickUploadRecording();
	}

	@Then("Uploaded recording will be displayed in Manage Classes page -Admin View for selected topic")
	public void uploaded_recording_will_be_displayed_in_Manage_Classes_page_Admin_View_for_selected_topic() {
		System.out.println("Uploaded");
	}

	/*   Manage Recording (Admin page)
	 *   Feature : Different Upload features by Admin
	 *   Scenario : Check whether Admin can Upload  Resources
	 *  Link name on the Home page : "Manage Recordings"
	 * 
	 */

	@When("Admin upload resources after selecting Batch and topic")
	public void admin_upload_resources_after_selecting_Batch_and_topic() {
		pageObj.selectBatchFromDropDown("SDET");
		pageObj.selectTopicFromDropDown("Selenium");
		pageObj.clickUploadResources();
	}

	@Then("Upload resources will be displayed in Manage Classes page\\(Admin View) for selected topic")
	public void upload_resources_will_be_displayed_in_Manage_Classes_page_Admin_View_for_selected_topic() {
		System.out.println("Uploaded");
	}
}
