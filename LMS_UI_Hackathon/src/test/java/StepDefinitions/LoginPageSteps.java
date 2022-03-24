package StepDefinitions;
//import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import com.factory.DriverFactory;
import com.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import junit.framework.Assert;

public class LoginPageSteps {
private LoginPage loginpage=new LoginPage(DriverFactory.getDriver());
	
@Given("User is on LMS Log-In Screen")
public void user_is_on_lms_log_in_screen() {
	DriverFactory.getDriver().get("https://LMSPortal.com/login");   
}

@When("User enters Login Name and Password")
public void user_enters_login_name_and_password() {
   loginpage.loginName("admin");
   loginpage.password("password");
   }

@Then("user navigates to LMS Home Page")
public void user_navigates_to_lms_home_page() {
	DriverFactory.getDriver().get("LMSHomePageUrl");
	}

@When("User enters Invalid Login Name and Password")
public void user_enters_invalid_login_name_and_password() {
	loginpage.loginName("wrongLogin");
	loginpage.password("wrongPwd");
	
}

@Then("user will not login successfully with invalid credentials error message")
public void user_will_not_login_successfully_with_invalid_credentials_error_message() {
	String returnmsg =loginpage.alertmessageVerification();
	Assert.assertEquals("Invalid UserName and Password", returnmsg, returnmsg);
}

@Given("User is on Answer Security Question page by clicking on Forgot password link")
public void admin_user_is_on_answer_security_question_page_by_clikcing_on_forgot_password_link() {
   loginpage.forgotPwdLinkBtn();
  }

@When("User enters Email Address and clicks on Next button.User enters the Answer for security Question")
public void admin_user_enters_email_address_and_clicks_on_next_button_admin_user_enters_the_answer_for_security_question() {
   loginpage.emailAddress();
   loginpage.nextBtn();
   loginpage.securityQuestion();
   loginpage.securityAnswer();
}

@Then("Message like {string} will be displayed")
public void message_like_will_be_displayed(String string) {
	loginpage.resetDisplayedMsg(string);
	
}

@Then("Message like {string} will be displayed.")
public void messages_like_will_be_displayed(String string) {
    loginpage.resetLinkNotSend(string);
}
}
