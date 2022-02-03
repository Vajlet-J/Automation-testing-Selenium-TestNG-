import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class D_12_Violeta_Jokic_NS105QA4 {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver",
                PropReader.fetchProperty("WEBDRIVER.CHROME.PATH"));

        WebDriver wd = new ChromeDriver();

        wd.get("https://www.wikipedia.org/");

        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

      WebElement searchLanguage = wd.findElement(By.xpath("//select[@id='searchLanguage']"));
      searchLanguage.click();

      WebElement serbian = wd.findElement(By.xpath("//option[contains(text(),'Српски / Srpski')]"));
      serbian.click();

      WebElement searchInput = wd.findElement(By.xpath("//input[@id='searchInput']"));
      searchInput.sendKeys("Java");

      WebElement suggestion = wd.findElement(By.xpath("//body/div[3]/form[1]/fieldset[1]/div[1]/div[2]/div[1]/a[2]"));
      suggestion.click();

      WebElement title = wd.findElement(By.xpath("//h1[@id='firstHeading']"));

      if(title.getText().equals("Java (програмски језик)")){
          System.out.println("Title is correct.");
      }else {
          System.out.println("Ttile is not correct.");
      }

      wd.close();


    }

}
