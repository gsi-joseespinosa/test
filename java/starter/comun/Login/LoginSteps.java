package starter.comun.Login;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import starter.comun.Home.HomePage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class LoginSteps extends ScenarioSteps {

    LoginPage page;
    Actor actor;
    @Step
    public void set_Url(String url){
        page.setDefaultBaseUrl(url);
    }

    @Step
    public void openLoginView(){
        page.open();
        page.display_logging_view();
    }

    @Step
    public void introduces_credentials(String username, String password) {
            page.introduces_credentials(username,password);
    }

    @Step
    public void chekHomeScreen(){
        String classname="bp3-spinner-animation";
        try {
            page.waitForAnyRenderedElementOf(By.className("bp3-spinner-animation"));
        }catch (Throwable e){
            fail("Can't find element with classname: '"+classname+"'");
        }

        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.urlContains("home"));
        assertThat(getPages().isCurrentPageAt(HomePage.class)).isTrue();
    }

    public void SefeCrendtials(String username, String password){
        //This method will invoque when the credentials loggin was correct used for others Scenarios
        Serenity.setSessionVariable("username").to(username);
        Serenity.setSessionVariable("password").to(password);
    }

    @Step
    public void display_error_logging_Message(String errorMessages,String classElement) {
        page.display_error_logging_Message(errorMessages,classElement);
    }
    @Step
    public void default_login(){
        set_Url("http://192.168.10.120:3000/login");
        openLoginView();
        introduces_credentials("hopkinsBC","hopkinsBC");
        chekHomeScreen();
    }
    @Step
    public void ckeck_currentPage(){
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.urlContains("login"));
        assertThat(getPages().isCurrentPageAt(page.getClass())).isTrue();
    }
}
