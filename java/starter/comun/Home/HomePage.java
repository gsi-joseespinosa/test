package starter.comun.Home;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.*;
import net.thucydides.core.annotations.DefaultUrl;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@DefaultUrl("http://192.168.10.120:3000/home")
@At(urls = {"http://192.168.10.120:3000/home"})
public class HomePage extends PageObject {


    public void ClickOnMenuOptionsLogout() {
        List<WebElementFacade> menu2 = getUserOptions();
        for (WebElement el : menu2) {
            String icon = el.getAttribute("icon");

            if (icon != null && icon.equalsIgnoreCase("log-out")) {
                el.findElement(By.xpath("./..")).click();
                break;
            }
        }
    }

    public List<WebElementFacade> getUserOptions() {
            waitForAnyRenderedElementOf(By.cssSelector("span[class*='bp3-popover-wrapper'] button[type='button'] span[icon*='user']"));
           WebElement button = (WebElement) evaluateJavascript("return $(\"span[class='bp3-popover-wrapper'] button[type='button'] span[icon='user']\").parent()[0];");
           button.click();
           List<WebElementFacade> menu = findAll("//ul[@class='bp3-menu']");
           return menu.get(0).thenFindAll(By.tagName("span"));

    }

    public void clicks_on_button(String button) {
        try{
        List<WebElementFacade> importList = findAll("//span[@icon='refresh']");

            switch (button) {
                case "Import Account":
                    importList.get(0).click();
                    break;
                case "Import Order":
                    importList.get(1).click();
                    break;
                default:
                    importList.get(2).click();
                    break;
            }
        }catch (Throwable e){
            fail("Can't find the elements of the import group.");
        }

    }
    public void validate_display_Status_pop_up(String button) {
        //Looking for the visual result on screen and validate it
     //   try {
            switch (button) {
                case "Import Account":
                    WebElement e = find(By.xpath(".//*[contains(text(), 'Accounts Passed')]"));
                    WebElement e2 = find(By.xpath(".//*[contains(text(), 'Accounts Failed')]"));
                    WebElement e3 = find(By.xpath(".//*[contains(text(), 'Accounts Ungeocoded')]"));
                    assertThat((e.isDisplayed() && e2.isDisplayed() && e3.isDisplayed())).isTrue();
                    break;
                case "Import Order":
                    WebElement e4 = find(By.xpath(".//*[contains(text(), 'Orders Conflicted')]"));
                    WebElement e5 = find(By.xpath(".//*[contains(text(), 'Orders Passed')]"));
                    assertThat((e4.isDisplayed() && e5.isDisplayed())).isTrue();
                    break;
                default:

                    break;
            }
       /* }catch (Throwable e){
            fail("The request result couldn't show ");
        }*/

    }

    public void display_progress_pop_up() {
        String Errormessage = "";
        try {
                    //Looking for the progress element
              Errormessage = "Can't find element with class: 'bp3-progress-bar'";
              waitForAnyRenderedElementOf(By.cssSelector("div[class*='bp3-progress-bar']"));

              //Waiting for ajax request is completed if element is displayed yet
                 WebElement divElm=$("div[class*='bp3-progress-bar']");
                    Errormessage = "The ajax request is not finished or the response time is not enough, which is 50 seconds by default.";
                    new WebDriverWait(getDriver(), 50).until(ExpectedConditions.invisibilityOf(divElm));

        } catch (Throwable e) {
            fail(Errormessage);
        }
    }

    public void display_graphic_description(String type) {
        WebElement ele=null;
        try {
            ele = $("div[tip*='" + type + "']");
            new WebDriverWait(getDriver(), 180).until(ExpectedConditions.visibilityOf(ele));
        }catch (Throwable e){
            fail("Can't find the element which tip contains '"+type+"'");
        }
        assertThat(ele.isDisplayed()).isTrue();

    }

    public void is_iframe_ready() {
        String ErrorMessage="";
        try {
            ErrorMessage="The wait time for frame to be available return a failure status.";
            new WebDriverWait(getDriver(), 180).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe")));
            ErrorMessage="The wait time for the response in a frame has over, can't access to elements inside it.";
            //ZDBPoweredByEl dashRowDivEdit
            new WebDriverWait(getDriver(), 180).until(ExpectedConditions.visibilityOf($(".dashRowDivEdit")));
        }catch (Throwable e){
            fail(ErrorMessage);
        }
    }

    public void the_Dispatcher_is_in_the_menu_option(String arg1) {
        WebElement e=null;
        switch (arg1){
            case "Delivery Management":
               e=  find(By.xpath("//*[@id='App']/div/div[1]/div[2]/div/span"));
               e.click();
               //Wait for div container of Delivery Sumary Tags
               waitForRenderedElements(By.xpath("//*[@id=\"App\"]/div/div[2]/div[2]"));
                break;
            case "SETUP":
                 e=  find(By.xpath("//*[@id='App']/div/div[1]/div[3]/div/span"));
                 e.click();
                break;

        }

    }
}
