package starter.DeliveryManagement.Steps;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import starter.comun.Home.HomePage;
import starter.comun.SystemPage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class DeliverySteps extends ScenarioSteps {
    DeliveryPage deliveryPage;
    HomePage homePage;
    SystemPage systemPage;

    @Step
    public void the_Dispatcher_is_in_the_menu_option(String arg1) {
        homePage.the_Dispatcher_is_in_the_menu_option(arg1);

    }

    @Step
    public void selects_the_tab(String arg1) {
        deliveryPage.selects_the_tab(arg1);
        Serenity.setSessionVariable("SubTabOption").to(arg1);
    }

    @Step
    public void clicks_on_the_tab_subtab(String arg2) {
        deliveryPage.clicks_on_the_tab_subtab_option(arg2);

    }

    @Step
    public void display_list_of_Truck_and_Drivers_relationship_information() {
        deliveryPage.display_list_of_Truck_and_Drivers_relationship_information();
    }

    @Step
    public void introduce_value_to_search(String match, String field) {
        Serenity.setSessionVariable("SearchStatus").to(match);
        Serenity.setSessionVariable("SearchStatusField").to(field);
        if (match.equals("incorrect")) {
            systemPage.EvaluateTriggerChangeInputByPropertyName("incorrectValue", "type", "search");
            systemPage.waitForElementByClassname("bp3-spinner-animation", deliveryPage);

        } else {
            WebElement e = null;
            String text = "";
            int i = 0;
            boolean begin = true;
            while (text.equals("") && i < 81) {

                try {
                    ArrayList d = SearchIterator(i, begin, field);
                    i = (Integer) d.get(1) + 9;
                    e = (WebElement) d.get(0);
                } catch (Throwable exeption) {
                    fail("Can't find a possible candidate to run the test in column \"" + field + "\"\n " +
                            "This error happened because all string text candidate are empty");
                }
                if (begin) begin = false;
                text = e.getText();
            }

            Serenity.setSessionVariable("SearchValue").to(e.getText());
            systemPage.EvaluateTriggerChangeInputByPropertyName(e.getText(), "type", "search");
            systemPage.waitForElementByClassname("bp3-spinner-animation", deliveryPage);


        }
    }


    @Step
    public void display_the_matching_deliveries() {
        String variable = Serenity.sessionVariableCalled("SearchStatus");
        if (variable.equals("incorrect")) {
            assertThat((getDriver().findElements(By.xpath(".//p[contains(text(), 'No data')]")).size() > 0)).isTrue();
        } else {
            boolean spected = true;
            String serachValue = Serenity.sessionVariableCalled("SearchValue");
            WebElement e = null;
            try {
                String field = Serenity.sessionVariableCalled("SearchStatusField");
                int i = 0;
                boolean begin = true;
                while (i < 81) {
                    ArrayList d = SearchIterator(i, begin, field);
                    i = (Integer) d.get(1) + 9;
                    e = (WebElement) d.get(0);
                    if (begin) begin = false;
                    spected = (spected && e.getText().toLowerCase().contains(serachValue.toLowerCase()));
                }
            } catch (Throwable exception) {

            }
            assertThat(spected).isTrue();


        }
    }

    private ArrayList SearchIterator(int i, boolean begin, String field) {
        WebElement e = null;
        switch (field) {
            case "ticket":
                if (begin) i = 4;
                e = deliveryPage.find(By.xpath("//*[@id=\"App\"]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div/div/div/div[1]/div[1]/div/div[2]/div/div/div[1]/div/div[" + i + "]/div/div/p"));
                break;
            case "account":
                if (begin) i = 5;
                e = deliveryPage.find(By.xpath("//*[@id=\"App\"]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div/div/div/div[1]/div[1]/div/div[2]/div/div/div[1]/div/div[" + i + "]/div/div/p"));
                break;
            case "name":
                if (begin) i = 6;
                e = deliveryPage.find(By.xpath("//*[@id=\"App\"]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div/div/div/div[1]/div[1]/div/div[2]/div/div/div[1]/div/div[" + i + "]/div/div/p"));
                break;
            case "driver":
                if (begin) i = 3;
                e = deliveryPage.find(By.xpath("//*[@id=\"App\"]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div/div[1]/div/div[" + i + "]/div/div/p"));
                System.out.println(e.getText());
                break;
        }
        ArrayList s = new ArrayList();
        s.add(e);
        s.add(i);
        return s;
    }

    @Step
    public void clicks_on_arrow() {
        //Get the Driver sort button
        deliveryPage.clicks_on_arrow();

    }

    @Step
    public void select_sort_rank_option(String sortType) {
        Serenity.setSessionVariable("SortType").to(sortType);
        deliveryPage.select_sort_rank_option(sortType);
    }

    @Step
    public void display_sort_filter() {
        String sorType = Serenity.sessionVariableCalled("SortType");
        int i = 0;
        boolean firts = true;
        ArrayList<String> arraylist = new ArrayList<>();
        String messages = "";


        WebElement current = null;
        messages = "No element found to sort";
        try {
            while (i < 170) {
                ArrayList list = SearchIterator(i, firts, "driver");
                current = (WebElement) list.get(0);
                i = ((Integer) list.get(1)) + 12;
                arraylist.add(current.getText());
                if (firts) firts = false;
            }
        } catch (Throwable exp) {
            if (i==0) fail(messages);
        }
        try {
            ArrayList<String> arraylistCopy = (ArrayList<String>) arraylist.clone();
            Collections.sort(arraylistCopy);
            messages = "The list is not ordering by " + sorType + " action";
            if (sorType.toLowerCase().equals("desc")) {
                Collections.reverse(arraylistCopy);
                Assert.assertTrue(arraylistCopy.equals(arraylist));
            } else {
                //Assert for asc and not sort options
                Assert.assertTrue(arraylistCopy.equals(arraylist));
            }
        } catch (Throwable exp) {
            fail(messages);
        }


    }
    @Step
    public void dbclicks_on_selected_shift() {
        deliveryPage.dbclicks_on_selected_shift();
    }
    @Step
    public void displays_shift_details_popup() {
        deliveryPage.displays_shift_details_popup();
    }
}
