package Gun02;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class _02_EditAccount extends BaseDriver {
    /*
  Senaryo
  1- Siteyi açınız.
  2- Edit Account sayfasına ulaşınız.
  3- Ad ve soyadı değiştirip tekrar kaydedidiniz.
 */

    @Test
    public void EditAccount(){
        WebElement edit= driver.findElement(By.linkText("Edit Account"));
        edit.click();

        WebElement name= driver.findElement(By.id("input-firstname"));
        name.clear();
        name.sendKeys("Yeni isim");

        WebElement surName= driver.findElement(By.id("input-lastname"));
        surName.clear();
        surName.sendKeys("Yeni Soyisim");

        WebElement btn= driver.findElement(By.cssSelector("[value='Continue']"));
        btn.click();

        Tools.SuccessMessageValidation();
    }
}
