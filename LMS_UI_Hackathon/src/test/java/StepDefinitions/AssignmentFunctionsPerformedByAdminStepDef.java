package StepDefinitions;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AssignmentFunctionsPerformedByAdminStepDef {
	//	ManageAssignmentsPageAdmin manageAsgmentPageAdmin = new ManageAssignmentsPageAdmin();

	ManageAssignmentsPageAdmin manageAsgmentPageAdmin=new ManageAssignmentsPageAdmin(DriverFactory.getDriver());

	//background code
	@Given("Admin is logged in with Batches and Classes were created already")
	public void admin_is_logged_in_with_batches_and_classes_were_created_already() {
	   
	        
	        String pgtitle = manageAsgmentPageAdmin.checkUrl();
	        Assert.assertTrue(pgtitle, true);
	}

	@Given("Admin is on Manage Assignments Page\\(admin) by clicking on Manage Assignments tab")
	public void admin_is_on_manage_assignments_page_admin_by_clicking_on_manage_assignments_tab() {
	   
	       manageAsgmentPageAdmin.clickOnManageAssignmentTab();    
	}

	@When("Admin Add an Assignment to Existing Batch {string},{string},{string},{string}")
	public void admin_add_an_assignment_to_existing_batch(String Name, String Description, String DueDate, String File) {
	   
	        manageAsgmentPageAdmin.clickOnAddExistingBatch();
	        manageAsgmentPageAdmin.editData(Name,Description, DueDate,File);
	        manageAsgmentPageAdmin.submit();
	}

	@Then("Newly Added assignment Details will be displayed in Manage Assignments Page\\(Admin){string}")
	public void newly_added_assignment_details_will_be_displayed_in_manage_assignments_page_admin(String Name) {
	   
	    Assert.assertTrue(manageAsgmentPageAdmin.compareAssignmentName(Name));
	}

	@When("Admin Edit an existing assignment {string},{string},{string},{string}")
	public void admin_edit_an_existing_assignment(String Name, String Description, String DueDate, String File) {
	   
	        manageAsgmentPageAdmin.clickOnAddExistingBatch();
	        manageAsgmentPageAdmin.editData(Name,Description, DueDate,File);
	        manageAsgmentPageAdmin.submit();
	}

	@Then("Updated assignment details will be displayed in Manage Assignments Page\\(Admin) {string},{string},{string},{string}")
	public void updated_assignment_details_will_be_displayed_in_manage_assignments_page_admin(String Name, String Description, String DueDate, String File) {
	   
	       Assert.assertTrue(manageAsgmentPageAdmin.compareAssignmentName(Name));
	}

	@When("Admin Delete an existing assignment {string}")
	public void admin_delete_an_existing_assignment(String Name) {
	   
	   manageAsgmentPageAdmin.clickOnDeleteExistingBatch(Name);
	    
	}

	@Then("Deleted assignment details will be removed from Manage Assignments Page\\(Admin) {string}")
	public void deleted_assignment_details_will_be_removed_from_manage_assignments_page_admin(String Name) {
	   
	    Assert.assertTrue(manageAsgmentPageAdmin.compareAssignmentName(Name));
	}

	@When("Admin tries to view exisiting assignment details")
	public void admin_tries_to_view_exisiting_assignment_details() {
	   
	    //no need to add any code here as given Statement will  land here.
	}

	@Then("All the existing assignment details will be displayed in Manage Assignments Page\\(Admin) {string},{string},{string},{string}")
	public void all_the_existing_assignment_details_will_be_displayed_in_manage_assignments_page_admin(String Name, String Description, String DueDate, String File) {
	   
	   Assert.assertTrue(manageAsgmentPageAdmin.getAllExistingRecords(Name,Description,DueDate,File ));
	    
	}

	@Given("Admin is on Add tab of manage Assignments page\\(admin view) by clicking on Add Assignment in Manage Assignments Page\\(admin)")
	public void admin_is_on_add_tab_of_manage_assignments_page_admin_view_by_clicking_on_add_assignment_in_manage_assignments_page_admin() {
	   
	   manageAsgmentPageAdmin.clickOnAddExistingBatch();
	    
	}

	@When("Admin clicks on submit button after selecting Batch and enters Assignment name  {string}, Assignment Description {string}, Assignment Due {string}, Upload assignments {string}")
	public void admin_clicks_on_submit_button_after_selecting_batch_and_enters_assignment_name_assignment_description_assignment_due_upload_assignments(String Name, String Description, String DueDate, String File) {

	        manageAsgmentPageAdmin.clickOnAddExistingBatch();
	        manageAsgmentPageAdmin.editData("Name","Description", "DueDate","File");
	        manageAsgmentPageAdmin.submit();
	   
	    
	}

	@Then("Created assignments will be displayed in Manage Assignments Page\\(admin) and Manage Assignment page\\(User View)")
	public void created_assignments_will_be_displayed_in_manage_assignments_page_admin_and_manage_assignment_page_user_view() {
	   
	    Assert.assertTrue(manageAsgmentPageAdmin.getAllExistingRecords("Name","Description","DueDate","File" ));
	}

	@Given("Admin is on Edit tab of manage Assignments page\\(admin view) by clicking on Add Assignment in Manage Assignments Page\\(admin)")
	public void admin_is_on_edit_tab_of_manage_assignments_page_admin_view_by_clicking_on_add_assignment_in_manage_assignments_page_admin() {
	   
	        manageAsgmentPageAdmin.clickOnAddExistingBatch();
	        manageAsgmentPageAdmin.clickOnAddExistingBatch();
	}

	@When("Admin clicks on submit button after updating one or more assignment details  {string},{string},{string},{string}")
	public void admin_clicks_on_submit_button_after_updating_one_or_more_assignment_details(String Name, String Description, String DueDate, String File) {
	   
	    manageAsgmentPageAdmin.editData("Name","Description", "DueDate","File");
	        manageAsgmentPageAdmin.submit();
	}

	@Then("Updated assignment details will be displayed in Manage Assignments Page\\(admin) and Manage Assignment page\\(User View) {string},{string},{string},{string}")
	public void updated_assignment_details_will_be_displayed_in_manage_assignments_page_admin_and_manage_assignment_page_user_view(String Name, String Description, String DueDate, String File) {
	   
	   Assert.assertTrue(manageAsgmentPageAdmin.compareAssignmentName(Name));
	    
	}

	@Given("Admin is on Manage Assignments Page\\(admin)")
	public void admin_is_on_manage_assignments_page_admin() {
	   
	    manageAsgmentPageAdmin.clickManageAssignments();
	}

	@When("Admin clicks on Trash icon after selecting existing assignments {string}")
	public void admin_clicks_on_trash_icon_after_selecting_existing_assignments(String string) {
	   
	    manageAsgmentPageAdmin.deleteAssignment();
	}

	@Then("Deleted assignment will be removed from Admin View in Manage Assignments Page\\(admin) and Manage Assignment page\\(User View) {string}")
	public void deleted_assignment_will_be_removed_from_admin_view_in_manage_assignments_page_admin_and_manage_assignment_page_user_view(String Name) {
	   
	   Assert.assertTrue(manageAsgmentPageAdmin.compareAssignmentName(Name));
	    
	}

	@Given("Admin is on Manage Submissions\\(Admin) page by clicking on Manage button in Manage assignments page\\(admin)")
	public void admin_is_on_manage_submissions_admin_page_by_clicking_on_manage_button_in_manage_assignments_page_admin() {
	   
	    manageAsgmentPageAdmin.clickOnManage();
	}

	@When("Admin clicks on submit button after selecting all th details like {string},{string},{string} ,{string},{string} ,{string} and {string}")
	public void admin_clicks_on_submit_button_after_selecting_all_th_details_like_and(String Batch, String GradeBy, String Grade, String MakeGradeVisible, String string5, String string6, String string7) {
	   
	    manageAsgmentPageAdmin.sendDataForSubmission(Batch,GradeBy,Grade, MakeGradeVisible);
	}

	@Then("Grade Details will be visible to both Admin and User View")
	public void grade_details_will_be_visible_to_both_admin_and_user_view() {
	   
	    Assert.assertTrue(manageAsgmentPageAdmin.gradeDetails());
	}

	@When("Admin clicks on Submit button after selecting all the details like {string},{string},{string} ,{string},{string} ,{string} and {string}")
	public void admin_clicks_on_submit_button_after_selecting_all_the_details_like_and(String Batch, String GradeBy, String Grade, String MakeGradeVisible, String string5, String string6, String string7) {
	   
	    manageAsgmentPageAdmin.sendDataForSubmission(Batch,GradeBy,Grade, MakeGradeVisible);
	}

	@Then("Grade Details will be visible only to Admin")
	public void grade_details_will_be_visible_only_to_admin() {
	   
	   Assert.assertTrue(manageAsgmentPageAdmin.gradeDetails());
	    
	}

}
