package Gun01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _03_Annotations {

    @Test
    public void Test1(){
        System.out.println("test1 çalıştı.");
    }

    @Test
    public void test2(){
        System.out.println("test2 çalıştı.");
    }

    @BeforeClass
    public void BeforeClassBolumu(){
        System.out.println("Before Class Bölümü çalıştı.");
    }

    @AfterClass
    public void AfterClassBolumu(){
        System.out.println("After Class Bölümü çalıştı.");
    }
}
