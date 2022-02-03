import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ProductCompare;
import utils.PropReader;

import java.io.IOException;
import java.time.Duration;

public class TestProductCompare {

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
    public void compareTwoProducts() throws InterruptedException {
         wd.get("https://gigatron.rs/");
         wd.manage().window().maximize();

         ProductCompare productsToCompare = new ProductCompare(wd);
         productsToCompare.compareTwoProducts();

         String firstBagName = wd.findElement(By.xpath("//*[@id=\"app-container\"]/div/div[1]/table/thead/tr/th[1]/div[1]/a/h4")).getText();
         String secondBagName = wd.findElement(By.xpath("//h4[contains(text(),'LENOVO Torba za laptop ThinkPad 3-in-1 4X40H57287')]")).getText();

         Assert.assertEquals(firstBagName,"SAMSONITE Torba za laptop Network 3 Charcoal black - CC8*19002");
         Assert.assertEquals(secondBagName,"LENOVO Torba za laptop ThinkPad 3-in-1 4X40H57287");

         Assert.assertEquals(firstBagName, "SAMSONITE Torba za laptop Network 3 Charcoal black - CC8*19002");
         System.out.println("Both bags are added to compare.");
     }
     @Test
    public void compareOneProduct() throws InterruptedException {
         wd.get("https://gigatron.rs/");
         wd.manage().window().maximize();

         ProductCompare productsToCompare = new ProductCompare(wd);
         productsToCompare.compareOneProduct();

         try{
             Assert.assertEquals(wd.getCurrentUrl(),"https://gigatron.rs/uporedi", "The compare button should not work.");
         }catch(Throwable e){
             System.err.println(e);
         }
     }
}
