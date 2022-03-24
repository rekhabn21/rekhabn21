package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.pages.AssignmentPageObjects;
import com.pages.AttendancePageObjects;
import com.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AttendancefunctionStepdefinition {
	
	public AttendancefunctionStepdefinition() throws IOException {
		super();
	ConfigReader confi = new ConfigReader();
	//driver =DriverFactory.Initialization();
	driver.get(confi.prop.getProperty("URL") + confi.prop.getProperty("Basepath_login"));

	}
	
	 WebDriver driver;
	
	AttendancePageObjects attend = new AttendancePageObjects(driver);

	@Given("Admin is on Manage Attendance\\(Admin and Class Staff) page")
	public void admin_is_on_manage_attendance_admin_and_class_staff_page() {
		attend.Link_click();
	}

	@When("Admin Selects Batch,Class and Class Date")
	public void admin_selects_batch_class_and_class_date() {
		attend.Attendance_Batch();
		attend.Attendance_Class();
		attend.Class_date();
	}

	@Then("Student attendance can be viewed succesfully based on the selected criteria")
	public void student_attendance_can_be_viewed_succesfully_based_on_the_selected_criteria() {
		 System.out.println("Landed in the page");
	}

	@When("Admin clicks on save button after selecting batch and class and marks the student as either {string}")
	public void admin_clicks_on_save_button_after_selecting_batch_and_class_and_marks_the_student_as_either() {
		attend.Attendance_Batch();
		attend.Attendance_Class();
		attend.Class_date();
		attend.RB_Present();
		attend.Save_btn();
	}

	@Then("Student attendance details will be saved  succeesfully")
	public void student_attendance_details_will_be_saved_succeesfully() {
		
		 System.out.println("Saved successfully");

	}

	@When("Admin clicks on reset button after selecting batch , class and class date")
	public void admin_clicks_on_reset_button_after_selecting_batch_class_and_class_date() {
		attend.Attendance_Batch();
		attend.Attendance_Class();
		attend.Class_date();
		attend.Reset_btn();
	}

	@Then("Default radio button will be selected for all the displayed students")
	public void default_radio_button_will_be_selected_for_all_the_displayed_students() {
		attend.RB_Unknown();
	}


}