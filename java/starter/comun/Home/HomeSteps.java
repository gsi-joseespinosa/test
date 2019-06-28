package starter.comun.Home;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;

public class HomeSteps extends ScenarioSteps {

    HomePage page;

    @Step
    public Boolean checkCurrentPage(){
        return getPages().isCurrentPageAt(HomePage.class);
    }


    @Step
    public void clicks_on_button(String button){
       page.clicks_on_button(button);
    }
    @Step
    public void validate_display_Status_pop_up(String arg1) {
        page.validate_display_Status_pop_up(arg1);
    }
    @Step
    public void display_progress_pop_up() {
        page.display_progress_pop_up();
    }
    @Step
    public void display_graphic(String type) {
        page.is_iframe_ready();
        page.display_graphic_description(type);
    }

}
