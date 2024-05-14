package Gun04;
/*
   bu örneği istediğin aşamada sorabilirsin, ister burda ister paralel testten sonra
   Senaryo
   1- Siteye gidiniz
   2- Specials tiklayiniz
   3- Cikan urun lerde (bütün ürünlerde indirim var mı, eski fiyat yeni fiyat var mı)
   4- Yukarıdaki işlemden sonra her ürünün önceki fiyatının şu andaki fiyattan
      yüksek olduğunu doğrulayınız.
   5- Yukarıdaki işlemi 2 farklı browserda ve paralel şekilde test ediniz.
*/

import Utility.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _01_Soru extends BaseDriverParameter {

    @Test
    public void test(){

        WebElement specials= driver.findElement(By.linkText("Specials"));
        specials.click();

        List<WebElement> urunler=driver.findElements(By.cssSelector("[class='price-old']"));
        List<WebElement> yUrunler=driver.findElements(By.cssSelector("[class='price-new']"));

        Assert.assertTrue(urunler.size()==yUrunler.size(),"Bütün ürünlerde indirim bulunmamaktadır.");

        for (int i = 0; i <yUrunler.size() ; i++) {
            double yeniFiyat=Double.parseDouble(yUrunler.get(i).getText().replaceAll("[^0-9,.]",""));
            double eskiFiyat=Double.parseDouble(urunler.get(i).getText().replaceAll("[^0-9,.]",""));

            Assert.assertTrue(yeniFiyat<eskiFiyat,"Yeni fiyat eski fiyattan küçük değil.");

        }
    }
}
