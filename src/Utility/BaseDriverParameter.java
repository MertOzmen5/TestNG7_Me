package Utility;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseDriverParameter {


    public WebDriverWait wait;

    public WebDriver driver;

    @BeforeClass
    @Parameters("browserTipi")
    public void BaslangicIslemleri(String browserTipi) { //TearStart
        // System.out.println("Başlangıç işlemleri yapılıyor."); // driver oluşturma,wait işlemleri

        switch (browserTipi.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:driver=new ChromeDriver();break;
        }

        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // Sayfa hata verirse 20 sn mühlet.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Elementi bulma mühleti 5 sn.
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        LoginTest();

    }

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

    @AfterClass
    public void KapanisIslemleri() { // TearDown
        // System.out.println("Kapanış işlemleri yapılıyor."); // BekleKapat

        Tools.Bekle(3);
        driver.quit();


    }
}
