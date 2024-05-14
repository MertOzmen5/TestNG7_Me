package Gun06;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class _04_MenuValidation_Elements {
    public _04_MenuValidation_Elements() {PageFactory.initElements(BaseDriver.driver,this);}

    @FindBy (css = "[class='nav navbar-nav']>li")
    public List<WebElement>header;

    @FindBy (css = "[class='collapse navbar-collapse navbar-ex1-collapse']")
    public WebElement topMenu;
}
