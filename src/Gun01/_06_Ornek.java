package Gun01;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _06_Ornek extends BaseDriver {

    @Test

    public void LoginTest() {
        System.out.println("Login Test başladı.");

        driver.get("https://opencart.abstracta.us/index.php?route=account/register");

        WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
        myAccount.click();

        WebElement login = driver.findElement(By.linkText("Login"));
        login.click();

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("avmertozmen95@gmail.com");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("Merhaba11");

        WebElement login1 = driver.findElement(By.cssSelector("[value='Login']"));
        login1.click();

        WebElement confirm = driver.findElement(By.xpath("//h2[text()='My Account']"));

        wait.until(ExpectedConditions.titleIs("My Account"));
        Assert.assertEquals("My Account", confirm.getText());
        System.out.println("Login Test bitti.");


    }
}
