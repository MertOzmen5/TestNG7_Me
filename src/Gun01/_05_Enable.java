package Gun01;

import Utility.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class _05_Enable {

    @Test
    public void test1() {
        System.out.println("Test 1");
        driver.get("https://techno.study/");
    }

    @Test
    public void test2() {
        System.out.println("Test 2");
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void test3() {
        System.out.println("Test 3");
        driver.get("https://www.google.com.tr/");
    }

    public static WebDriverWait wait;

    public static WebDriver driver;

    @BeforeClass
    public void BaslangicIslemleri() { //TearStart
        System.out.println("Başlangıç işlemleri yapılıyor."); // driver oluşturma,wait işlemleri

        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // Sayfa hata verirse 20 sn mühlet.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Elementi bulma mühleti 5 sn.
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    @AfterClass
    public void KapanisIslemleri() { // TearDown
        System.out.println("Kapanış işlemleri yapılıyor."); // BekleKapat

        Tools.Bekle(3);
        driver.quit();


    }
}
