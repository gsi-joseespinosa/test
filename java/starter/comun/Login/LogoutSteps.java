package starter.comun.Login;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import starter.comun.Home.HomePage;

public class LogoutSteps extends ScenarioSteps {

    HomePage homePage;

    @Step
    public void set_Url(String url){
        if(!url.isEmpty())
            homePage.setDefaultBaseUrl(url);
    }

    @Step
    public void selectLogoutButton(){
        homePage.ClickOnMenuOptionsLogout();
    }


}
