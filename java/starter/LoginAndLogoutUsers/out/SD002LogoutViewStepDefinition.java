package starter.LoginAndLogoutUsers.out;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import starter.comun.Login.LoginSteps;
import starter.comun.Login.LogoutSteps;

public class SD002LogoutViewStepDefinition {

    @Managed
    WebDriver browser;
    @Steps
    LoginSteps login;

    @Steps
    LogoutSteps logoutSteps;


    @Before
      public void LogingBefore(){
     
      }

    @Given("^the user is in any view of the system \"([^\"]*)\"$")
    public void the_user_is_in_any_view_of_the_system(String viewUrl) {
       // login.getPages().get(null);

       // if(!viewUrl.isEmpty())
          // login.set_Switch_URL(viewUrl);
    }

    @When("^clicks on the User Profile and select Logout$")
    public void clicks_on_the_User_Profile_and_select_Logout() {
        logoutSteps.selectLogoutButton();
    }

    @Then("^logout from the system$")
    public void logout_from_the_system() {
    login.ckeck_currentPage();
    }

}
