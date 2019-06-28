package starter.OrderManagement.Steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import starter.comun.SystemPage;

import static org.assertj.core.api.Assertions.fail;

public class OrderManagementSteps extends ScenarioSteps {

    OrderManagementPage orderManagementPage;
    SystemPage systemPage;
    @Step
    public void clicks_on_button(String button) {
        WebElement btn=null;
        switch (button){
            case "Create New Order":
                orderManagementPage.find(By.xpath("//*[@id=\"App\"]/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/div[2]/button[2]/span[2]")).click();
                systemPage.displays_popup();
                break;
            case "Create Order":
               // WebElement el=orderManagementPage.find(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/div/div/button"));
                new WebDriverWait(orderManagementPage.getDriver(), 10).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/div/div/button")));

                orderManagementPage.find(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/div/div/button")).click();
                break;
            case "Save Order":

                new Actions(getDriver()).moveToElement(orderManagementPage.find(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[3]/div/button[1]")))
                        .click().perform();
                break;
        }

    }
    @Step
    public void select_an_accounts() {
        orderManagementPage.select_an_accounts();
    }

    public void inserting_or_modifing_form_values() {
        orderManagementPage.inserting_or_modifing_form_values();
    }

    public void display_message(String message) {
        try {
            orderManagementPage.waitForTextToAppear(message);
        }catch (Throwable e) {
            fail("The error message:'"+message+"' is not display");
        }
    }
}
