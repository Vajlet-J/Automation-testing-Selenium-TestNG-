import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class TestSignIn {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                PropReader.fetchProperty("WEBDRIVER.CHROME.PATH"));

        WebDriver wd = new ChromeDriver();

        wd.get("http://automationpractice.com/index.php");

        wd.manage().window().maximize();

        if(wd.getCurrentUrl().equals("http://automationpractice.com/index.php")){
            System.out.println("Gettting homepage successful");
        }else{
            System.out.println("The actual url should be equal http://automationpractice.com/index.php");
        }

        WebElement signInButton = wd.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
        signInButton.click();
        Thread.sleep(1000);

        WebElement emailAddress = wd.findElement(By.xpath("//input[@id='email']"));
        WebElement password = wd.findElement(By.xpath("//input[@id='passwd']"));

        emailAddress.sendKeys("test@test.com");
        Thread.sleep(1000);
        password.sendKeys("1234");
        Thread.sleep(1000);

        WebElement buttonSignIn = wd.findElement(By.id("SubmitLogin"));
        buttonSignIn.click();
        Thread.sleep(1000);

        WebElement authErrorMessage = wd.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]"));
        if(!authErrorMessage.getText().equals("There is 1 error")){
            System.out.println("The error message should be present");
        }
        WebElement errorPopup = wd.findElement(By.className("alret-danger"));
        String colorOfErrorMsg = authErrorMessage.getCssValue("background-color");
        if(colorOfErrorMsg.equals("rgba( 243, 81, 92, 1)")){
            System.out.println("to je crvena boja.");
        }else{
            System.out.println("Nije crvena boja.");
        }
        wd.close();
    }
}
