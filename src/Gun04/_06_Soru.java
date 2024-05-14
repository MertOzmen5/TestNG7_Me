package Gun04;
/*

 Bir önceki taskı PARAMETERDRIVER ile yapınız
 sonrasında farklı tarayıcılar ile çalıştırınız. (crossbrowser)
 sonrasında paralel çalıştırınız.(parallel)
 */

import Utility.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _06_Soru extends BaseDriverParameter {
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
    Object[] datalarim() { // DataProvider kullandığımız zaman XML'den yazılacak kelimeleri göndermemize gerek yok.

        Object[] aranacaklar = {"mac", "ipod", "samsung"};
        return aranacaklar;
    }


}
