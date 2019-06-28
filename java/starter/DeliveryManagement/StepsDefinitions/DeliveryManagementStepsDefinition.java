package starter.DeliveryManagement.StepsDefinitions;

import cucumber.api.java.en.*;
import net.thucydides.core.annotations.Steps;
import starter.DeliveryManagement.Steps.DeliverySteps;

public class DeliveryManagementStepsDefinition {

    @Steps
    DeliverySteps deliverySteps;

    @Given("^The Dispatcher is in the \"([^\"]*)\" menu option$")
    public void the_Dispatcher_is_in_the_menu_option(String arg1) {
        deliverySteps.the_Dispatcher_is_in_the_menu_option(arg1);
    }

    @Given("^selects the \"([^\"]*)\" tab$")
    public void selects_the_tab(String arg1) {
        deliverySteps.selects_the_tab(arg1);

    }


    @When("^selects \"([^\"]*)\" subtab$")
    public void clicks_on_the_tab_subtab(String arg1) {
        deliverySteps.clicks_on_the_tab_subtab(arg1);
    }

    @Then("^Display list of Truck and Drivers relationship information$")
    public void display_list_of_Truck_and_Drivers_relationship_information() {
        deliverySteps.display_list_of_Truck_and_Drivers_relationship_information();
    }

    @When("^Introduce value to Search \"([^\"]*)\" to field \"([^\"]*)\"$")
    public void introduce_value_to_search(String arg1, String field) {
        deliverySteps.introduce_value_to_search(arg1,field);
    }


    @Then("^Displays the matching Deliveries$")
    public void display_the_matching_deliveries() {
        deliverySteps.display_the_matching_deliveries();
    }
    @When("^clicks on the arrow right to the header of Status column$")
    public void clicks_on_arrow() {
        deliverySteps.clicks_on_arrow();
    }
    @When("^select Sort Rank \"([^\"]*)\" options$")
    public void select_sort_rank_option(String arg1) {
        deliverySteps.select_sort_rank_option(arg1);
    }
    @Then("^the system will sort by the selected column depending of the selection made$")
    public void display_sort_filter() {
        deliverySteps.display_sort_filter();
    }

    @When("^Double clicks on a selected shift$")
    public void dbclicks_on_selected_shift() {
        deliverySteps.dbclicks_on_selected_shift();
    }
    @Then("^Displays the Shift Details pop up$")
    public void displays_shift_details_popup() {
        deliverySteps.displays_shift_details_popup();
    }

}
