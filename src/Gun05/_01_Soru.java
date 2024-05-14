package Gun05;
/*
  Senaryo;
  1- Brands menusune gidiniz.
  2- Burada her bir markanın üstünde yer alan harf ile başladığını doğrulayınız
*/

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _01_Soru extends BaseDriver {
    @Test
    public void brands1() {
        WebElement brands = driver.findElement(By.linkText("Brands"));
        brands.click();

        WebElement main = driver.findElement(By.cssSelector("[id='content']"));

        List<WebElement> markalar = main.findElements(By.cssSelector("[class='row']"));
        //elementin içinde element ararken XPATH kullanılamaz, çünkü o TÜM sayfada arar

        List<WebElement> harfler = driver.findElements(By.cssSelector("[id='content']>h2"));

        for (WebElement e : markalar) {
            System.out.println("e.getText() = " + e.getText());
        }

        for (WebElement d : harfler) {
            System.out.println("d.getText() = " + d.getText());
        }

        for (int i = 0; i < harfler.size(); i++) {

            Assert.assertEquals(harfler.get(i).getText().charAt(0), markalar.get(i).getText().charAt(0));
            System.out.println(harfler.get(i).getText().charAt(0) + " " + markalar.get(i).getText());
        }
    }
}
