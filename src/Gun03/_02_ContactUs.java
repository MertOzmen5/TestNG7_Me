package Gun03;
/*
  1- ContactUs a tıklayınız
  2- Mesaj kutusuna en az 10 karakterlik bir mesaj yazınız.
  3- Submit ettikten sonra url deki success yazısını doğrulayınız.
 */

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_ContactUs extends BaseDriver {

    @Test
    public void Test1(){
        WebElement contactUs1= driver.findElement(By.linkText("Contact Us"));
        contactUs1.click();

        WebElement msg= driver.findElement(By.cssSelector("[id='input-enquiry']"));
        msg.sendKeys("Merhaba ben Mert.");

        WebElement submitButton= driver.findElement(By.cssSelector("[value='Submit']"));
        submitButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("success"));


    }





}
