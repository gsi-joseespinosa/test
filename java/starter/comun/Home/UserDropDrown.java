package starter.comun.Home;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class UserDropDrown extends PageObject {
    @FindBy(id="logaoutDrown")
    WebElementFacade dropdrown;

    public void  SelectIdemFromDropDrown(String name){
        dropdrown.selectByVisibleText(name);
    }
}
