package StepDefinitions;

import static org.junit.Assert.assertArrayEquals;

import java.io.IOException;
import com.factory.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.util.*;
import com.util.Testutils;
import com.util.ConfigReader;
import com.pages.AddorEditbatchespage;
import com.pages.LaunchPage;
import com.pages.ManageBatchespage;
import com.factory.*;
import com.pages.LoginPage;
import io.cucumber.core.options.Constants;
import io.cucumber.java.en.*;

public class batchesfunctionbyadminsteps {
	
	LaunchPage launchpg;
	LoginPage lpg;
	WebDriver driver;
	ManageBatchespage mbpg;
	AddorEditbatchespage addeditpg;
	int oldbatchsize;
	int newbatchsize;
	
	public batchesfunctionbyadminsteps() throws IOException {
		super();
		ConfigReader cfg = new ConfigReader();
		//driver =DriverFactory.Initialization();
		driver.get(cfg.prop.getProperty("URL") + cfg.prop.getProperty("Basepath_login"));
		launchpg = new LaunchPage(driver);
		launchpg.launchtologinpage();
		lpg =new LoginPage(driver );
		Assert.assertTrue("Login", true);
		lpg.loginfunction();
		driver.getTitle();
	}
	//background
	@Given("Admin is logged in and Programs were created")
	public void admin_is_logged_in_and_programs_were_created() {
		 String pgtitle = driver.getTitle();
			Assert.assertTrue(pgtitle, true);
			
	}
		
// #1 Scenario: Check whether Newly Added batches details are visible to Admin
	@Given("Admin is on Manage Batches Page(admin) screen, by clicking on batches tab")
	public void admin_is_on_manage_batches_page_admin_screen_by_clicking_on_batches_tab() {

		try {
			mbpg = new ManageBatchespage();
			System.out.println(driver.getTitle());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@When("Admin Adds Batch to Existing Batch")
	public void admin_adds_batch_to_existing_batch() {
		try {

			mbpg = new ManageBatchespage();
			mbpg.batcheslistdisplayed();
			oldbatchsize = mbpg.batchidfunction();
			mbpg.AddBatchfunction();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Then("Newly Added Batch Details will be displayed in Manage Batches Page(Admin)")
	public void newly_added_batch_details_will_be_displayed_in_manage_batches_page_admin() {
		try {
			mbpg = new ManageBatchespage();
			mbpg.batcheslistdisplayed();
			newbatchsize = mbpg.batchidfunction();

			if (newbatchsize > oldbatchsize)
				Assert.assertTrue(true);
			System.out.println(" New batch added to batches list");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//==================================================================================================================================================================

//#2 Scenario: Check whether Edited batches details are visible to Admin
	@When("Admin Edits an existing Batch")
	public void admin_edits_an_existing_batch() {
		try {
			addeditpg = new AddorEditbatchespage();
			addeditpg.newbatchfunction();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Then("Updated Batch details will be displayed in Manage Batches Page(Admin)")
	public void updated_batch_details_will_be_displayed_in_manage_batches_page_admin() {
		mbpg.messagepresentfunction();
		mbpg.batcheslistdisplayed();
	}

//======================================================================================================================================================

//#3 Scenario: Check whether Deleted batches details are removed from Admin view

	@When("Admin Delete an existing Batch")
	public void admin_delete_an_existing_batch() {
		try {
			mbpg = new ManageBatchespage();
			mbpg.batcheslistdisplayed();
			oldbatchsize = mbpg.batchidfunction();
			mbpg.deleteBatchfunction();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Then("Deleted Batch details will be removed from Manage Batches Page\\(Admin)")
	public void deleted_batch_details_will_be_removed_from_manage_batches_page_admin() {
		mbpg.deleteBatchfunction();
		mbpg.batcheslistdisplayed();
		newbatchsize = mbpg.batchidfunction();
		if (newbatchsize < oldbatchsize)
			Assert.assertTrue(true);
		System.out.println(" batch delted from batches list");
	}

//==================================================================================================================================================

//#4 Scenario: Check whether Admin can able to see all existing batches details

	@When("Admin tries to view exisiting Batch details")
	public void admin_tries_to_view_exisiting_batch_details() {
		try {
			mbpg = new ManageBatchespage();
			driver.getTitle();
			mbpg.batcheslistdisplayed();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Then("All the existing Batch details details will be displayed in Manage Batches Page(Admin)")
	public void all_the_existing_batch_details_details_will_be_displayed_in_manage_batches_page_admin() {
		mbpg.batcheslistdisplayed();
	}

//==========================================================================================================================================================

//#5 Scenario: Check whether Admin can add batch to batches list

	@Given("Admin is on Add tab of ADD/Edit batches page(admin) by clicking on Add Batch in Manage Batches Page(admin)")
	public void admin_is_on_add_tab_of_add_edit_batches_page_admin_by_clicking_on_add_batch_in_manage_batches_page_admin() {
		try {
			mbpg = new ManageBatchespage();
			mbpg.batcheslistdisplayed();
			oldbatchsize = mbpg.batchidfunction();
			mbpg.AddBatchfunction();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@When("Admin clicks on submit button after entering  BatchId,Batch Name,Batch Description,select Batch Status, enters BatchNo.of classes")
	public void admin_clicks_on_submit_button_after_entering_batch_id_batch_name_batch_description_select_batch_status_enters_batch_no_of_classes() {

		try {
			addeditpg = new AddorEditbatchespage();
			addeditpg.newbatchfunction();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Then("Created Batch details will be displayed in Manage Batches Page(Admin) with auto generated Created Date and Modified date in MM\\/DD\\/YY format")
	public void created_batch_details_will_be_displayed_in_manage_batches_page_admin_with_auto_generated_created_date_and_modified_date_in_mm_dd_yy_format()
			throws Throwable {
		mbpg = new ManageBatchespage();
		driver.getTitle();
		newbatchsize = mbpg.batchidfunction();

		if (newbatchsize > oldbatchsize)
			Assert.assertTrue(true);
		System.out.println(" New batch added to batches list");
	}

//=============================================================================================================================================================

//#6 Scenario: Check whether Admin can edit particular batch in batches list

	@Given("Admin is on Edit tab of ADD/Edit batches page(admin) by clicking on edit icon")
	public void admin_is_on_edit_tab_of_add_edit_batches_page_admin_by_clicking_on_edit_icon() {
		try {
			mbpg = new ManageBatchespage();
			mbpg.EditBatchfunction();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@When("Admin clicks on submit button after updating Batch Name, Batch Description,select Batch Status, Batch No.of classes")
	public void admin_clicks_on_submit_button_after_updating_batch_name_batch_description_select_batch_status_batch_no_of_classes() {
		try {
			addeditpg = new AddorEditbatchespage();
			addeditpg.editexistingbatchfunction();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Then("Updated Batch details will be displayed in Manage Batches Page(Admin) screen with same autogenerated creation date and different Modified date in MM\\/DD\\/YY format")
	public void updated_batch_details_will_be_displayed_in_manage_batches_page_admin_screen_with_same_autogenerated_creation_date_and_different_modified_date_in_mm_dd_yy_format() {
		mbpg.messagedispalyedfunction();
		mbpg.messagepresentfunction();
		mbpg.batcheslistdisplayed();
	}
//==================================================================================================================================================================================

//#7 Scenario: Check whether Admin can delete particular batch in batches list

	@Given("Admin is on Manage Batches Page(admin) screen")
	public void admin_is_on_manage_batches_page_admin_screen() throws Throwable {
		mbpg = new ManageBatchespage();
		driver.getTitle();
		Assert.assertTrue(driver.getTitle(), true);
	}

	@When("Admin clicks on particular batch trash icon")
	public void admin_clicks_on_particular_batch_trash_icon() {
		try {
			mbpg = new ManageBatchespage();
			mbpg.batcheslistdisplayed();
			oldbatchsize = mbpg.batchidfunction();
			mbpg.deleteBatchfunction();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Then("Batch will be deleted from the Batches List in Manage Batches Page(admin)")
	public void batch_will_be_deleted_from_the_batches_list_in_manage_batches_page_admin() throws Throwable {

		mbpg = new ManageBatchespage();
		mbpg.batcheslistdisplayed();
		newbatchsize = mbpg.batchidfunction();

		if (newbatchsize > oldbatchsize) {
			Assert.assertTrue(true);
			System.out.println(" New batch added to batches list");
		}
	}
}