package Gun01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _07_Assertions {

    @Test
    public void equalsOrnek() {
        String s1 = "Merhaba";
        String s2 = "Merhaba";

        // Actual (oluşan),Expected (Beklenen) ,HataMesajı (opsiyonel)

        Assert.assertEquals(s1, s2, "oluşanla beklenen aynı değil ");
    }

    @Test
    public void NotequalsOrnek() {
        String s1 = "Merhaba";
        String s2 = "Merhaba";

        // Actual (oluşan),Expected (Beklenen) ,HataMesajı (opsiyonel)

        Assert.assertNotEquals(s1, s2, "oluşanla beklenen farklı değil ");
    }

    @Test
    public void TrueOrnek() {
        String s1 = "Merhaba";
        String s2 = "Merhaba";

        // Actual (oluşan),Expected (Beklenen) ,HataMesajı (opsiyonel)

        Assert.assertTrue(s1.equals(s2), "oluşanla beklenen aynı değil");
    }

    @Test
    public void True2Ornek() {
        int s1 = 5;
        int s2 = 5;

        // Actual (oluşan),Expected (Beklenen) ,HataMesajı (opsiyonel)

        Assert.assertTrue(s1 == s2, "oluşanla beklenen aynı değil");
    }

    @Test
    public void NullOrnek() {
        String s = null;

        Assert.assertNull(s, "Değer null değil");
    }

    @Test
    public void direktFail() {
        int a = 56;

        if (a != 55)
            Assert.fail();
    }

    @Test
    public void FalseOrnek() {
        int s1=5;
        int s2=7;
        // Actual (oluşan),Expected (Beklenen) ,HataMesajı (opsiyonel)

        Assert.assertFalse(s1==s2, "oluşanla beklenen aynı değil");
    }
}
