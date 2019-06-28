package starter.LoginAndLogoutUsers.in;

import cucumber.api.java.en.*;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import starter.comun.Login.LoginPage;
import starter.comun.Login.LoginSteps;

public class SD001LogingViewStepDefinition {

    @Managed
    WebDriver browser;
    WebDriver driver;

    @Steps
    LoginSteps homeLoginPage;

    @Given("^Access to the system and opens the (.*)$")
    public void access_to_the_system_and_opens_the_URL(String url) {
        homeLoginPage.set_Url(url);
    }

    @When("^The system will displays the \"([^\"]*)\" view$")
    public void the_system_will_displays_the_view(String viewName) {
        homeLoginPage.openLoginView();
    }

    @Then("^Home Screen is displayed$")
    public void home_Screen_is_displayed() {
        homeLoginPage.chekHomeScreen();
    }

    @Then("^displays the Home Screen view$")
    public void displays_the_Home_Screen_view() {
        homeLoginPage.chekHomeScreen();
    }

    @When("^Introduces the username \"([^\"]*)\" and password \"([^\"]*)\" and Click Login Buttom$")
    public void introduces_credentials(String username, String password) {
        homeLoginPage.introduces_credentials(username,password);
    }


    @Then("^Display error logging Message \"([^\"]*)\" in classElement \"([^\"]*)\"$")
    public void display_error_logging_Message(String errormessage,String classElement) {

        homeLoginPage.display_error_logging_Message(errormessage,classElement);
    }

    @Given("^Loging to system$")
    public void login_default(){
        homeLoginPage.default_login();
    }
    @Given("^The Dispatcher is in Home Screen$")
    public void the_Dispatcher_is_in_Home_Screen() {
        home_Screen_is_displayed();
    }

}
