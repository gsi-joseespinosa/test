package starter.OrderManagement.Steps;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import starter.comun.SystemPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrderManagementPage extends PageObject {

    SystemPage systemPage;

    public void select_an_accounts() {
        Actions actions = new Actions(getDriver());
        WebElement row = find(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[1]/div[1]/div[1]/div/div[2]/div/div/div/div/div[2]/div/div"));
        actions.click(row).perform();
    }

    public void inserting_or_modifing_form_values() {
        //Selected the main form fields

        //Clicks on combox "Order Type"
        SelectFromPopoverElement("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/div/span/span/div/button");

        //Current tank Input
        systemPage.EvaluateTriggerChangeInputByPropertyName(new Random().nextInt(100), "name", "idcurrenttank");

        //Clicks on combox "Fill Type"
        SelectFromPopoverElement("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[6]/div/div/div/div/span[1]/span/div/button");

        //Select Order Qty
        WebElement orderQty=find(By.name("orderQty"));
        if(orderQty.isEnabled()){
            systemPage.EvaluateTriggerChangeInputByPropertyName(new Random().nextInt(400), "name", "orderQty");
        }
        //Product
        SelectFromPopoverElement("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div[7]/div/div/div/div/span/span/div/button");

        //Requested Date
        Actions actions= new Actions(getDriver());
        WebElement date=find(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[9]/div/div/div/span/span/div/input"));

        actions.moveToElement(date).click().perform();
        List<WebElementFacade> list=findAll(By.className("DayPicker-Day"));

        actions.moveToElement(list.get(new Random().nextInt(list.size()))).click().perform();




    }
    private void SelectFromPopoverElement(String xpath){
        System.out.println(xpath);
        find(By.xpath(xpath)).click();
        WebElement Selectpopover = find(By.cssSelector("div[class*='bp3-select-popover']"));
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOf(Selectpopover));
        List<WebElementFacade> menu = findAll("ul[class*='bp3-menu'] li a[class*='bp3-menu-item']");
        Random random = new Random();
        menu.get(random.nextInt(menu.size())).click();
    }
    //html/body/div[3]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/div/span/span/div/button
}
