package Gun02;


import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Dependency {
    // Arabanın hareket sırası: start, drive, park, stop
    @Test
    public void StartCar() {
        System.out.println("StartCar");
        Assert.fail();
    }

    @Test(dependsOnMethods = {"StartCar"}) // Bu testin çalışmaya başlaması StartCar'ın başarılı bitmesine bağlı.
    public void DriverCar() {
        System.out.println("DriverCar");
    }

    @Test(dependsOnMethods = {"StartCar", "DriverCar"})
    public void ParkCar() {
        System.out.println("ParkCar");
    }

    @Test(dependsOnMethods = {"ParkCar"},alwaysRun = true) // hatalı olsa da sen başla
    public void StopCar() {
        System.out.println("StopCar");
    }
}
// bağımlı testler, direk metodundan çalıştırdığınızda bağımlı olduğu metod zincirinde
// 1 üste kadar otomatik çağırıp çalışabilir.

//Dependency (bağımlılık):Bir testin diğer bir testin sonucuna veya
//belirli bir duruma bağlı olduğu durumları ifade eder.
//Örneğin, bir testin çalışabilmesi için önce başka bir testin başarılı
//bir şekilde tamamlanması gerekebilir. Bu tür senaryolarda TestNG'nin Dependency özelliği devreye girer.
