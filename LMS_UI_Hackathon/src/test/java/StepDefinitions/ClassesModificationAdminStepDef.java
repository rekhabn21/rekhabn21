package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.factory.DriverFactory;
import com.pages.ClassesModificationAdminPage;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ClassesModificationAdminStepDef {
	WebDriver driver;
	public ClassesModificationAdminPage pageObj ;
	int classSize;
	int newSize;
//	@Given("Admin is logged in,Batches and Classes were created already")
//	public void admin_is_logged_in_Batches_and_Classes_were_created_already() {
//		DriverFactory.initialiseDriver();
//		driver = DriverFactory.driver;
//		pageObj = new ClassesModificationAdminPage(driver);
//	}

	/*  Manage Assignments Page(admin)
	 *   Feature : Different Classes Modifications By Admin
	 *   Scenario : Check whether Edited assignments details are visible to Admin
	 *  Page : "Manage Classes Page-admin"
	 * 
	 */
	
	@Given("Admin is on Manage Classes Page-admin by clicking on Manage Classes tab")
	public void admin_is_on_Manage_Classes_Page_admin_by_clicking_on_Manage_Classes_tab() {
		pageObj.clickManageClassesonHomePage();
	}

	@When("Admin Add a Class to Existing Batch")
	public void admin_Add_a_Class_to_Existing_Batch() {
		classSize = pageObj.classSerialNo().size();
		pageObj.clickAddClass();
	}

	@Then("Newly Added Class details should display in Manage Classes Page -Admin")
	public void newly_Added_Class_details_should_display_in_Manage_Classes_Page_Admin() {
		newSize = pageObj.classSerialNo().size();
		if(newSize>classSize) {
			Assert.assertTrue(true);
		}
	}

	/* 
	 *   Scenario : Check whether Edited classes details are visible to Admin
	 *  Page : "Manage Classes Page-admin"
	 * 
	 */
		@Then("Updated class details should display in Manage Classes Page-Admin")
		public void updated_class_details_should_display_in_Manage_Classes_Page_Admin() {
			pageObj.clickManageClassesonHomePage();
		}



	@When("Admin Delete an existing Class")
	public void admin_Delete_an_existing_Class() {
		classSize = pageObj.classSerialNo().size();
		pageObj.clickDeleteClass();
	}

	@Then("Deleted Class details will be removed from Manage Classes Page -Admin")
	public void deleted_Class_details_will_be_removed_from_Manage_Classes_Page_Admin() {
		newSize = pageObj.classSerialNo().size();  //Size of the web elements in the page     
		if(newSize<classSize) {    //The number of elements after the delete will be less than before
			Assert.assertTrue(true);
		}
	}
	
	/* 
	 *   Scenario : Check whether Admin can able to see all existing classes details
	 *  Page : "Manage Classes Page-admin"
	 * 
	 */
	
	@When("Admin try to view exisiting Class details")
		public void admin_try_to_view_exisiting_Class_details() {
		pageObj.clickManageClassesonHomePage();
		}
	
		@Then("All the existing Classes details are displayed in Manage Classes Page-Admin")
		public void all_the_existing_Classes_details_are_displayed_in_Manage_Classes_Page_Admin() {
			if(pageObj.classSerialNo().size()>=1) //Size of the web elements in the page 
				Assert.assertTrue(true);  //The number of elements after the add will be more than before
			else
				Assert.assertFalse(false);
		}
		/* 
		 *   Scenario :  Check whether Admin can add New Class for particular Batch
		 *  Page : "Manage Classes Page-admin"
		 * 
		 */
		
	@Given("Admin is on Add tab of Add\\/Edit Classes Page-Admin by clicking on Add Class in Manage Classes page\\(admin)")
	public void admin_is_on_Add_tab_of_Add_Edit_Classes_Page_Admin_by_clicking_on_Add_Class_in_Manage_Classes_page_admin() {
		pageObj.clickAddInTab();

	}

	@When("Admin clicks on submit button after entering the details  like Class Topic, Class Date, Staff Name, Class Description, Comments for the selected batch")
	public void admin_clicks_on_submit_button_after_entering_the_details_like_Class_Topic_Class_Date_Staff_Name_Class_Description_Comments_for_the_selected_batch() {
		classSize = pageObj.classSerialNo().size();
		pageObj.enterClassComments("Good");
		pageObj.enterClassDescription("From Monday to Froday");
		pageObj.enterClassTopic("Seelnium");
		pageObj.enterStaffName("ABC");
		pageObj.clickSubmit();
	}

	@Then("Created Class will be displayed in Manage Classes Page-admin")
	public void created_Class_will_be_displayed_in_Manage_Classes_Page_admin() {
		newSize = pageObj.classSerialNo().size();//Size of the web elements in the page 
		if(newSize>classSize) {  //The number of elements after the delete will be less than before
			Assert.assertTrue(true);
		}
	}

	/* 
	 *   Scenario : Check whether Admin can Edit existing Class for particular Batch
	 *  Page : "Manage Classes Page-admin"
	 * 
	 */
	
	@Given("Admin is on Edit tab of Add\\/Edit Classes Page by cliking on Edit icon in Manage Classes page\\(admin)")
	public void admin_is_on_Edit_tab_of_Add_Edit_Classes_Page_by_cliking_on_Edit_icon_in_Manage_Classes_page_admin() {
		pageObj.clickEditInTab();
	}

	@When("Admin clicks on submit button after updating class details")
	public void admin_clicks_on_submit_button_after_updating_class_details() {
		pageObj.enterClassDescription("New Text");
		pageObj.enterClassComments("New Comments");

	}

	@Then("Updated Class details will be displayedin Manage Classes Page\\(admin)")
	public void updated_Class_details_will_be_displayedin_Manage_Classes_Page_admin() {
		pageObj.clickManageClassesonHomePage();
		Assert.assertEquals(pageObj.listOfComments().get(classSize), "New Comments");
	}

	/* 
	 *   Scenario : Scenario: Check whether Admin can delete existing Class for particular Batch
	 *  Page : "Manage Classes Page-admin"
	 * 
	 */
	
	@Given("Admin is on Manage Classes Page\\(admin)")
	public void admin_is_on_Manage_Classes_Page_admin() {
		pageObj.clickManageClassesonHomePage();
	}

	@When("Admin clicks on Trash icon of existing Class for particular Batch")
	public void admin_clicks_on_Trash_icon_of_existing_Class_for_particular_Batch() {
		classSize = pageObj.classSerialNo().size();
		pageObj.clickDeleteClass();
	}

	@Then("Deleted Class will be removed from Manage Classes Page\\(admin)")
	public void deleted_Class_will_be_removed_from_Manage_Classes_Page_admin() {
		newSize = pageObj.classSerialNo().size();
		if(newSize==classSize-1) {
			Assert.assertTrue(true);
		}
	}



}
