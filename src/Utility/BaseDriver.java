package Utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseDriver {

    public static Logger logger= LogManager.getLogger(); // Logları ekleyeceğim nesneyi başlattım.

    public static WebDriverWait wait;

    public static WebDriver driver;

    @BeforeClass
    public void BaslangicIslemleri() { //TearStart
       // System.out.println("Başlangıç işlemleri yapılıyor."); // driver oluşturma,wait işlemleri

        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // Sayfa hata verirse 20 sn mühlet.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Elementi bulma mühleti 5 sn.
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        LoginTest();

    }
    public void LoginTest() {
        System.out.println("Login Test başladı.");
        logger.info("Log işlemi başladı..");

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

        logger.info("Log işlemi tamamlandı.");

        //legonun kapanması için- butonlar altına kalınca tıklatma yapılamıyor
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.className("bitnami-corner-image"))).perform();
        driver.findElement(By.id("bitnami-close-banner-button")).click();


    }

    @AfterClass
    public void KapanisIslemleri() { // TearDown
       // System.out.println("Kapanış işlemleri yapılıyor."); // BekleKapat

        Tools.Bekle(3);
        driver.quit();

        logger.info("Driver kapatıldı.");

    }
    @BeforeMethod
    public void beforeMethod(){
        logger.info("Metod başladı.");

        logger.warn("WARN : Metod başladı,hata oluşmuş olsa idi");

    }

    @AfterMethod
    public void AfterMethod(ITestResult sonuc){
        logger.info(sonuc.getName()+ " Metod bitti." +(sonuc.getStatus()==1 ? "Passed" : "Failed"));

        logger.warn("WARN : Metod bitti,hata oluşmuş olsa idi");


    }
}
