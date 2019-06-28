package starter.comun;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;


public class SystemPage extends PageObject {

    private  void setTriggerChangeInput(){
        Boolean r=(Boolean)   evaluateJavascript("return (typeof window.triggerChangeInput !== \"undefined\")");
        if(!r) {
            evaluateJavascript(" window.triggerChangeInput = function(nextValue,element){" +
                    "   var eventinput = new Event('input', { bubbles: true }), " +
                    "   eventchange = new Event('change', { bubbles: true });" +
                    "  var previousValue = element.value;" +
                    "  element.value = nextValue;" +
                    "  element._valueTracker.setValue(previousValue);" +
                    "  element.dispatchEvent(eventinput);" +
                    "  element.dispatchEvent(eventchange);};");
        }
    }

    public WebElement EvaluateTriggerChangeInputByXpath(Object arg, String xpath){
         setTriggerChangeInput();
        evaluateJavascript("var elemnt=document.evaluate(arguments[1], document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                "window.triggerChangeInput(arguments[0],elemnt)",arg,xpath);
     return (WebElement) evaluateJavascript("return document.evaluate(arguments[1], document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;",xpath);
    }

    public WebElement EvaluateTriggerChangeInputByPropertyName(Object arg, String property,String propertyValue){
         setTriggerChangeInput();
       return  (WebElement) evaluateJavascript("var elemnt=document.querySelector(arguments[1]);" +
                "window.triggerChangeInput(arguments[0],elemnt); return elemnt",arg,"input["+property+"*='"+propertyValue+"']");
        }

    public WebElement waitForElementByClassname(String classname,PageObject page){
        try {
            page.waitForAnyRenderedElementOf(By.className(classname));
            return $("div[class*='"+classname+"']");
        }catch (Throwable e){
            fail("Can't find element with classname: '"+classname+"'");
        }
        return null;
    }

    public void displays_popup() {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='bp3-dialog']")));
        new WebDriverWait(getDriver(), 5);
        WebElement el=getDriver().findElement(By.cssSelector("div[class='bp3-dialog']"));
        assertThat(el.isDisplayed()).isTrue();
    }

}
