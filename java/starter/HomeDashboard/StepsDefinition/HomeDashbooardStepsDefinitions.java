package starter.HomeDashboard.StepsDefinition;

import cucumber.api.java.en.*;
import net.thucydides.core.annotations.Steps;
import starter.comun.Home.HomeSteps;
import starter.comun.Login.LoginSteps;

public class HomeDashbooardStepsDefinitions {

    @Steps
    HomeSteps homeSteps;

    @When("^Clicks on \"([^\"]*)\" button$")
    public void clicks_on_button(String button) {
        homeSteps.clicks_on_button(button);
    }

    @Then("^System display a progress pop up to Import the Account$")
    public void system_display_a_progress_pop_up_to_Import_the_Account() {
        homeSteps.display_progress_pop_up();
    }

    @Then("^displays and \"([^\"]*)\" Status pop up$")
    public void displays_and_Status_pop_up(String arg1) {
        homeSteps.validate_display_Status_pop_up(arg1);
    }
    @Then("The system displays the \"([^\"]*)\"")
    public void display_graphic_description(String type){
        homeSteps.display_graphic(type);
    }

}
