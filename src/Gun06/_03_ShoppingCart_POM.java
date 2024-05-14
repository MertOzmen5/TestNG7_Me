package Gun06;

/*
   Senaryo :
   1- Siteyi açınız.
   2- Sitede "ipod" kelimesini aratınız
   3- Çıkan sonuçlardan random birini sepete atınız.
   4- Shopping Chart a tıklatınız.
   5- Seçilen ürünün sepette olduğunu doğrulayınız.
   6- POM ile çözünüz.
 */

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;



public class _03_ShoppingCart_POM extends BaseDriver {

    @Test
    public void SP() {

        _01_PlaceOrder_Elementleri poe = new _01_PlaceOrder_Elementleri();
        _03_ShoppingCart_Elements she=new _03_ShoppingCart_Elements();

        poe.searchBox.sendKeys("ipod"+ Keys.ENTER);

        int randomSecim= Tools.randomGenerator(she.addToChartButtons.size());
        String whichProduct=she.products.get(randomSecim).getText();

        she.addToChartButtons.get(randomSecim).click();

        she.shoppingCart.click();

        boolean finded=Tools.ListContainsString(she.ChartList,whichProduct);

        Assert.assertTrue(finded,"This product is not in the cart list.");



    }




}
