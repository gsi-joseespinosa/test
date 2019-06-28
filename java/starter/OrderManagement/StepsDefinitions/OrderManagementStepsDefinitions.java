package starter.OrderManagement.StepsDefinitions;

import cucumber.api.java.en.*;
import net.thucydides.core.annotations.Steps;
import starter.OrderManagement.Steps.OrderManagementSteps;

public class OrderManagementStepsDefinitions {

    @Steps
    OrderManagementSteps orderManagementSteps;

    @Given("^clicks on \"([^\"]*)\" button$")
    public void clicks_on_button(String button){
        orderManagementSteps.clicks_on_button(button);

    }
    @Given("^select an accounts$")
    public void select_an_accounts(){
        orderManagementSteps.select_an_accounts();
    }
    @When("inserting OR modifing a value in the form")
    public void inserting_or_modifing_form_values(){
        orderManagementSteps.inserting_or_modifing_form_values();

    }
    @Then("Successful message is displayed \"([^\"]*)\"")
    public void display_message(String message){

        orderManagementSteps.display_message(message);
    }
    @Then("redirects the user to \"Search Criteria\" popup")
    public void redirect_to(){

    }

}
