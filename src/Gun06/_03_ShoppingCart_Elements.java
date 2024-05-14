package Gun06;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class _03_ShoppingCart_Elements {

    public _03_ShoppingCart_Elements() {PageFactory.initElements(BaseDriver.driver,this);}


    @FindBy (css = "[class='caption']>h4")
    public List<WebElement> products;

    @FindBy (css = "[class='button-group'] [class='fa fa-shopping-cart']")
    public List<WebElement> addToChartButtons;

    @FindBy (linkText = "shopping cart")
    public WebElement shoppingCart;

    @FindBy (css = "[class='text-left']>a")
    public List<WebElement>ChartList;

}
