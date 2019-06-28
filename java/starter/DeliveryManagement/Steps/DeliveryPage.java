package starter.DeliveryManagement.Steps;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import starter.comun.SystemPage;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class DeliveryPage extends PageObject {

    SystemPage systemPage;

    public void selects_the_tab(String arg) {
        WebElement e = null;
        switch (arg) {
            case "Delivery Summary":
                e = find(By.xpath("//*[@id=\"App\"]/div/div[2]/div[2]/div/div[1]/div[1]/span[2]"));
                e.click();
                break;
            case "Order Management":
                e = find(By.xpath("//*[@id=\"App\"]/div/div[2]/div[2]/div/div[1]/div[2]/span[2]"));
                e.click();
                break;

        }
    }

    public void clicks_on_the_tab_subtab_option(String subtab) {
        switch ((String) Serenity.sessionVariableCalled("SubTabOption")) {
            case "Delivery Summary":
                TagDeliverySummary(subtab);
                break;
            case "Order Management":
                TagOpenOrder(subtab);
                break;

        }

    }
    private void TagOpenOrder(String arg) {
        String exceptionFail = "Can't find element";
        try {
            exceptionFail = "'Tags " + arg + "'";
            WebElement eTag = null;
            WebElement e = null;

            switch (arg) {
                case "Open Orders":
                    e = find(By.xpath("//*[@id=\"App\"]/div/div[2]/div[2]/div/div[2]/div/div/div[1]/div[1]/span[2]"));
                    assertThat(e.getText().toLowerCase().contains(arg.toLowerCase())).isTrue();
                    e.click();
                    break;
                case "Delivery Exceptions":

                    break;
                case "Export":

                    break;

            }
        } catch (Throwable exc) {
            fail(exceptionFail);
        }

    }
    private void TagDeliverySummary(String arg) {
        String exceptionFail = "Can't find element";
        try {
            exceptionFail = "'Tags " + arg + "'";
            WebElement eTag = null;
            WebElement e = null;

            switch (arg) {
                case "Summary":
                    e = find(By.xpath("//*[@id=\"App\"]/div/div[2]/div[2]/div/div[1]/div[1]/span[2]"));
                    assertThat(e.getText().equalsIgnoreCase(arg));
                    e.click();
                    //Select Delivery Summary tag
                    exceptionFail = "'Tags " + arg + "'";
                    eTag = find(By.xpath("//*[@id=\"App\"]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[1]/div[1]/span"));
                    assertThat(eTag.getText().equalsIgnoreCase(arg)).isTrue();
                    eTag.click();
                    //Get Date input
                    exceptionFail = "'Date input'";
                    String xpath = "//*[@id=\"App\"]/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/div/div/div/div/span/span/div/input";
                    String value = "2019-04-30";
                    WebElement dateInput = systemPage.EvaluateTriggerChangeInputByXpath(value, xpath);

                    $("div[class*='bp3-table-container']");
                    WebElement divElm = systemPage.waitForElementByClassname("bp3-spinner-animation", this);
                    exceptionFail = "The request for table is not finished or the response time is not enough, which is 50 seconds by default.";
                    new WebDriverWait(getDriver(), 50).until(ExpectedConditions.invisibilityOf(divElm));

                    break;
                case "Shift Details":

                    break;
                case "Export":

                    break;

            }
        } catch (Throwable exc) {
            fail(exceptionFail);
        }

    }

    public void display_list_of_Truck_and_Drivers_relationship_information() {

        assertThat((getDriver().findElements(By.cssSelector("div[title='Truck']")).size() > 0 ||
                getDriver().findElements(By.cssSelector("div[title='Driver']")).size() > 0 ||
                getDriver().findElements(By.xpath(".//p[contains(text(), 'No data')])")).size() > 0)
        ).isTrue();

    }


    public void clicks_on_arrow() {
        WebElement eBut = find(By.xpath("//*[@id=\"App\"]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/div[1]/div/div[3]/div[1]/div[2]/span/span/span"));
        eBut.click();

    }

    public void select_sort_rank_option(String sortType) {
        List<WebElementFacade> tagUl = findAll(By.cssSelector("a[class*='bp3-menu-item']"));

        int g = 0;
        for (WebElement el : tagUl) {
            if (g == 0 && sortType.toLowerCase().contains("asc")) {
                el.click();
                WebElement divElm = systemPage.waitForElementByClassname("bp3-spinner-animation", this);
                new WebDriverWait(getDriver(), 50).until(ExpectedConditions.invisibilityOf(divElm));
                break;
            } else if (g == 1 && sortType.toLowerCase().contains("desc")) {
                el.click();
                WebElement divElm = systemPage.waitForElementByClassname("bp3-spinner-animation", this);
                new WebDriverWait(getDriver(), 50).until(ExpectedConditions.invisibilityOf(divElm));
                break;
            } else if (g == 2) {
                el.click();
                WebElement divElm = systemPage.waitForElementByClassname("bp3-spinner-animation", this);
                new WebDriverWait(getDriver(), 50).until(ExpectedConditions.invisibilityOf(divElm));
                break;
            }
            g++;
        }
    }

    public void dbclicks_on_selected_shift() {
        Actions actions = new Actions(getDriver());
        WebElement cell = find(By.xpath("//*[@id=\"App\"]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div/div[1]/div/div[2]/div/div"));
        actions.doubleClick(cell).perform();
    }

    public void displays_shift_details_popup() {
        systemPage.displays_popup();
    }
}
