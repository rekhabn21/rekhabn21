package StepDefinitions;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import com.factory.DriverFactory;
import com.pages.AssignmentPageObjects;
import com.pages.AttendancePageObjects;
import com.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AssignmentfunctionStepdefinition extends DriverFactory {
	
	public AssignmentfunctionStepdefinition() throws IOException {
		super();
		ConfigReader confi = new ConfigReader();
	//driver =DriverFactory.Initialization();
	driver.get(confi.prop.getProperty("URL") + confi.prop.getProperty("Basepath_login"));
	

	}
	
	 WebDriver driver;
	
	AssignmentPageObjects assign = new AssignmentPageObjects(driver);
	
	
	@Given("User is on Manage Submissions\\(user) page")
	public void user_is_on_manage_submissions_user_page() {
	    assign.manage_link();
	}

	@When("User clicks on submit button after selecting Batch,Assignment Name,Assignment Date ,add comments")
	public void user_clicks_on_submit_button_after_selecting_batch_assignment_name_assignment_date_add_comments() {
	    assign.btnManageGrades();
		 assign.selGradeBatch();
	     assign.selAssignmentName();
	     assign.txtAssignmentDate();
	     assign.txtSubComments();
	     assign.btnGradesSubmit();
		
	}

	@Then("Assignment will be submitted succesfully")
	public void assignment_will_be_submitted_succesfully() {
	    
		System.out.println("Assignment submitted successfully");
		
	}

	@When("User clicks on submit button after clicking on Edit icon to edit the required details")
	public void user_clicks_on_submit_button_after_clicking_on_edit_icon_to_edit_the_required_details() {
	    
		assign.btnEditAssignment();
		
	}

	@Then("Updated Assignment will be submitted successfully")
	public void updated_assignment_will_be_submitted_successfully() {
		
		System.out.println("Assignment edited successfully");

	}

	@When("User clicks on Trash icon after the assignment")
	public void user_clicks_on_trash_icon_after_the_assignment() {
	    assign.btnDelAssignment();
	}

	@Then("Assignment will be deleted successfully")
	public void assignment_will_be_deleted_successfully() {
		
		System.out.println("Assignment deleted successfully");

	}
	
}
