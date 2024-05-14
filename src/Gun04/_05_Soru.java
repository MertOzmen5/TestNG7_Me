package Gun04;
/*

 Daha önceki derslerde yaptğımız Search fonksiyonunu
 mac,ipod ve samsung için Dataprovider ile yapınız.
 */

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class _05_Soru extends BaseDriver {

    @Test(dataProvider = "datalarim")

    public void searchFunction(String gelenKelime) {

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.clear();
        searchInput.sendKeys(gelenKelime + Keys.ENTER);



        List<WebElement> captions = driver.findElements(By.cssSelector("[class='caption']> h4"));

        for (WebElement e : captions) {
            System.out.println("e.getText() = " + e.getText());
            Assert.assertTrue(e.getText().toLowerCase().contains(gelenKelime.toLowerCase()), "Aranan kelime bulunmadı");
        }


    }

    @DataProvider
    Object[] datalarim() {

        Object[] aranacaklar = {"mac", "ipod", "samsung"};
        return aranacaklar;
    }
}
