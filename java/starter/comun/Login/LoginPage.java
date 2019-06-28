package starter.comun.Login;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import org.assertj.core.api.Assert;
import org.openqa.selenium.By;
import starter.comun.ErrorFailure;


public class LoginPage extends PageObject {



    @FindBy(className="sc-jAaTju")
    WebElementFacade loginView;


    public void display_logging_view(){
        assertThat(loginView.isDisplayed()).isTrue();
    }
    public void introduces_credentials(String username, String password) {
        evaluateJavascript(" window.triggerChange = function(nextValue,element){" +
                            "  var eventinput = new Event('input', { bubbles: true }), " +
                            "   eventchange = new Event('change', { bubbles: true });" +
                            "  var previousValue = element.value;" +
                            "  element.value = nextValue;" +
                            "  element._valueTracker.setValue(previousValue);" +
                            "  element.dispatchEvent(eventinput);" +
                            "  element.dispatchEvent(eventchange);};" +
                "window.triggerChange(arguments[0],document.querySelector(\"input[type='username']\"));" +
                "window.triggerChange(arguments[1],document.querySelector(\"input[type='password']\"));" +
                "$(\"button[type='button']\").focus();$(\"button[type='button']\").click();",username,password);


    }

    public void display_error_logging_Message(String errorMessages,String classElement) throws ErrorFailure {
        if(!classElement.equals("")){
            try {
                waitForRenderedElements(By.className(classElement));
            }catch (Throwable e) {
                fail("Can not find element with classname gsi-error-span and error message:'"+errorMessages+"'");
            }

        }
        try {
            waitForTextToAppear(errorMessages);
        }catch (Throwable e) {
            fail("The error message:'"+errorMessages+"' is not display");
        }


    }


}
