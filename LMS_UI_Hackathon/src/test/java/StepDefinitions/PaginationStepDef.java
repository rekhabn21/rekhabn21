package StepDefinitions;

import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.pages.PaginationPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class PaginationStepDef {
	WebDriver driver;
	public PaginationPage pageObj ;


//	//*******BACKGROUND*****************
//	@Given("Admin is logged in & Programs, Batches and Users\\(Registered and Unregistered) are created already")
//	public void admin_is_logged_in_Programs_Batches_and_Users_Registered_and_Unregistered_are_created_already() {
//		DriverFactory.initialiseDriver();
//		driver = DriverFactory.driver;
//		pageObj = new PaginationPage(driver);
//	}

	/*   Manage Recording (Admin page)
	 *   Feature : Pagination
	 *   Scenario : Check functionality of Pagination at Manage user(Admin) page
	 * 
	 */
	
	@Given("Admin is on Manage users-admin page of User list\\(Unregistered)")
	public void admin_is_on_Manage_users_admin_page_of_User_list_Unregistered() throws InterruptedException {
		pageObj.clickUsersHomePage();
		pageObj.clickUnassignedUsers();


	}

	@When("result is containing many user records")
	public void result_is_containing_many_user_records() throws InterruptedException {

		try {
			pageObj.clickPagination();
		}
		catch(Exception e){
			System.out.println("Reached Last Page");
		}
	}

	@Then("Large number of user records will be divided into smaller discrete pages")
	public void large_number_of_user_records_will_be_divided_into_smaller_discrete_pages() {
		driver.close();
	}
	/*   Manage Recording (Admin page)
	 *   Feature : Pagination
	 *   Scenario : Check functionality of Pagination at Manage Attendance-Admin and Class Staff page
	 * 
	 */
	

	@Given("Admin is on  Manage Attendance\\(Admin and Class Staff) page ogf Manage Attendance\\(admin)") 
	public void admin_is_on_Manage_Attendance_Admin_and_Class_Staff_page_ogf_Manage_Attendance_admin() { 
		pageObj.clickManageAssignment();
	}

	@When("Result is containing many Student records") 
	public void result_is_containing_many_Student_records() { 
		try {
			pageObj.clickPagination();
		}
		catch(Exception e){
			System.out.println("Reached Last Page");
		}
	}

	@Then("Large number of Student records will be divided into smaller discrete pages") 
	public void large_number_of_Student_records_will_be_divided_into_smaller_discrete_pages()
	{ driver.close(); 
	}


}
