import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MetHotels;
import utils.PropReader;

import java.io.IOException;
import java.time.Duration;

public class TestMetHotels {

    private WebDriver wd;

    @BeforeClass
    public void init()throws IOException {
        System.setProperty("webdriver.chrome.driver",
                PropReader.fetchProperty("WEBDRIVER.CHROME.PATH"));
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterTest
    public void closeBW() throws IOException {
        wd.close();
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
    }
    @Test
    public void addNewSeating() throws InterruptedException {
        wd.get("https://it-255-dz-06-andjela-bojic3972.vercel.app/");
        wd.manage().window().maximize();
        MetHotels metHotels = new MetHotels(wd);
        metHotels.addNewAccommodation();
        metHotels.deleteFirstAppartment();

        String listaSmestaja = wd.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[2]/lista-smestaja-component[1]/div[1]")).getText();
        Assert.assertTrue(listaSmestaja.contains("Garsonjera"));

        Assert.assertFalse(wd.getPageSource().contains("Apartman 1"));
    }
}
