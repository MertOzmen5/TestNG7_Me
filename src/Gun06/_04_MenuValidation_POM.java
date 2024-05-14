package Gun06;

/*
  Senaryo
  1- Siteyi açınız.
  2- Top Menudeki menu elemanlarının olduğunu doğrulayınız.(menuValidation)
  3- Desktops, Laptops & Notebooks, Components, Tablets, Software, Phones & PDAs, Cameras, MP3 Players
  4- POM ile çözünüz.
 */


import Utility.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_MenuValidation_POM extends BaseDriver {

    @Test
    public void MenuVal() {

        _04_MenuValidation_Elements mve = new _04_MenuValidation_Elements();


        for (int i = 0; i < mve.header.size(); i++) {

            System.out.println(mve.header.get(i).getText());

            Assert.assertTrue(mve.topMenu.getText().contains(mve.header.get(i).getText()),"Product is not available in Top Menu.");
        }

    }
}
