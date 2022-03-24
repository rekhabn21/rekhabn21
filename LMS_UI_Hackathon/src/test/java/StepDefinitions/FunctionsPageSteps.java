package StepDefinitions;

import com.factory.DriverFactory;
import com.pages.FunctionsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FunctionsPageSteps {
private FunctionsPage functionsPage=new FunctionsPage(DriverFactory.getDriver());

@Given("Admin is on Manage Programs Page (admin) by clicking on Programs Tab")
public void admin_is_on_manage_programs_page_admin_by_clicking_on_programs_tab() {
    functionsPage.programsTab();
}

@When("Admin Add a program to Existing programs list")
public void admin_add_a_program_to_existing_programs_list() {
   functionsPage.programName();
   functionsPage.programDescription();
   functionsPage.active();
   functionsPage.submitBtn();
}

@Then("Newly Added program details will be displayed in Manage Programs Page(admin)")
public void newly_added_program_details_will_be_displayed_in_manage_programs_page_admin() {
    functionsPage.manageProDisplayList();
}

@When("Admin Edits an existing program")
public void admin_edits_an_existing_program() {
	functionsPage.editExistingProgram();
}

@Then("Updated program details will be displayed in Manage Programs Page(admin)")
public void updated_program_details_will_be_displayed_in_manage_programs_page_admin() {
	functionsPage.editProDisplayList();
}

@When("Admin Delete an existing program")
public void admin_delete_an_existing_program() {
    functionsPage.deleteProDisplayList();
}

@Then("Deleted program details will be removed from Manage Programs Page(admin)")
public void deleted_program_details_will_be_removed_from_manage_programs_page_admin() {
    functionsPage.manageProDisplayList();
}

@When("Admin tries to view exisiting program details")
public void admin_tries_to_view_exisiting_program_details(String progName) {
	functionsPage.viewExistingProg(progName);
}

@Then("All the existing program details will be displayed in Manage Programs Page(admin)")
public void all_the_existing_program_details_will_be_displayed_in_manage_programs_page_admin() {
	functionsPage.manageProDisplayList();
}

@Given("Admin is on Add tab in Add/Edit Programs page by clicking Add Program in Manage Programs Page(admin)")
public void admin_is_on_add_tab_in_add_edit_programs_page_by_clicking_add_program_in_manage_programs_page_admin() {
   functionsPage.addEditProgramPage();
}

@When("Admin clicks on submit button after entering the Program Name ,Program Description,Program Status")
public void admin_clicks_on_submit_button_after_entering_the_program_name_program_description_program_status() {
    functionsPage.submitBtn();
}

@Then("All the program details will be added to Programs List in Manage Programs Page(admin) with auto generated same ProgramCreationtime and ProgramModifiedtime in MM/DD/YY HH:MM format")
public void all_the_program_details_will_be_added_to_programs_list_in_manage_programs_page_admin_with_auto_generated_same_program_creationtime_and_program_modifiedtime_in_mm_dd_yy_hh_mm_format() {
	functionsPage.manageProDisplayList();
	functionsPage.ProgramCreationtime();
	functionsPage.ProgramModifiedtime();
}

@Given("Admin is on Edit tab in Add/Edit Programs page by clicking Edit icon in Manage Programs Page(admin)")
public void admin_is_on_edit_tab_in_add_edit_programs_page_by_clicking_edit_icon_in_manage_programs_page_admin() {
   functionsPage.addTabBtn();
}

@When("Admin clicks on submit button after updating the required fields like Program Name ,Program Description,Program Status")
public void admin_clicks_on_submit_button_after_updating_the_required_fields_like_program_name_program_description_program_status() {
    functionsPage.addEditProgramPage();
    functionsPage.submitBtn();
}

@Then("All the updated program details will be added to Programs List in Manage Programs Page(admin) with auto generated same ProgramCreationtime and modified Programtime MM/DD/YY HH:MM format")
public void all_the_updated_program_details_will_be_added_to_programs_list_in_manage_programs_page_admin_with_auto_generated_same_program_creationtime_and_modified_programtime_mm_dd_yy_hh_mm_format() {
	functionsPage.manageProDisplayList();
	functionsPage.ProgramCreationtime();
	functionsPage.ProgramModifiedtime();
}

@When("Admin clicks on Trash icon for any program in Programs List")
public void admin_clicks_on_trash_icon_for_any_program_in_programs_list() {
  functionsPage.trashBtn();
}

@Then("Program will be deleted from the Programs List in Manage Programs Page(admin)")
public void program_will_be_deleted_from_the_programs_list_in_manage_programs_page_admin(String ProgramName) {
	functionsPage.deleteExistingProg(ProgramName);
}

}