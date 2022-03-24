package StepDefinitions;

import com.factory.DriverFactory;
import com.pages.LaunchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LaunchPageSteps {
private LaunchPage launchpage=new LaunchPage(DriverFactory.getDriver());

@Given("User is on LMS portal with Login button Link")
public void user_is_on_lms_portal_with_login_button_link() {
	launchpage.displayLoginBtnLink();
}

@When("User clicks on Login button link")
public void user_clicks_on_login_button_link() {
	launchpage.clickOnLoginBtn();
    
}

@Then("user navigates to Log-In Screen page")
public void user_navigates_to_log_in_screen_page() {
    launchpage.loginUrl.toString();
}

}
