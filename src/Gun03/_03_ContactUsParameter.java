package Gun03;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _03_ContactUsParameter extends BaseDriver {

    @Test
    @Parameters("mesaj") // xml deki ile aynı name olmalı.
    public void test(String gelenMesaj){

        logger.info("contact us başladı");

        WebElement contactUs1= driver.findElement(By.linkText("Contact Us"));
        contactUs1.click();

        WebElement msg= driver.findElement(By.cssSelector("[id='input-enquiry']"));
        msg.sendKeys(gelenMesaj);

        WebElement submitButton= driver.findElement(By.cssSelector("[value='Submit']"));
        submitButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("success"));

        logger.info("contact us bitti");

    }
}
