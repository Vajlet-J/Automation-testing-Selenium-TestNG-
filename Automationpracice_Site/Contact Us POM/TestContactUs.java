import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ContactUs;
import utils.PropReader;
import utils.Random;

import java.io.IOException;
import java.time.Duration;

public class TestContactUs {

    private WebDriver wd;

    @BeforeClass
    public void init()throws IOException{
        System.setProperty("webdriver.chrome.driver",
                PropReader.fetchProperty("WEBDRIVER.CHROME.PATH"));
    wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public void zatvoriWebDriver(){
        wd.close();
    }

    /**
     * This test tests contact us happy path
     * Test steps:
     * 1. Go to http://automationpractice.com/index.php?controller=contact
     * 2. Select 2 from dropdown
     * 3. input email
     * 4. Input oder Ref
     * 5. Upload File
     * 6. Send a message
     * 7. Click send button
     * 8. Assert that message is sent
     * @throws IOException
     */

    @Test
    public void contactUsHappyPath() throws IOException {
        wd.manage().window().maximize();
        wd.get("http://automationpractice.com/index.php?controller=contact");
        wd.manage().window().maximize();
        Assert.assertEquals(wd.getCurrentUrl(),"http://automationpractice.com/index.php?controller=contact",
                "The current url should be equal to http://automationpractice.com/index.php?controller=contact");

        ContactUs contactUsPage = new ContactUs(wd);
        System.out.println("Select 2 from dropdown");
        contactUsPage.selectValueFromDropdown("2");
        System.out.println(" input email");
        contactUsPage.inputEmailAddress(Random.getRandomUserEmail());
        System.out.println(" input email");
        contactUsPage.inputOrderRef("loremipsum");
        System.out.println("Select 2 from dropdown");
        contactUsPage.uploadFile("C:\\Users\\Benutzer1\\Desktop\\PoMProjekat\\src\\main\\resources\\File.txt");
        System.out.println("Select 2 from dropdown");
        contactUsPage.sendAMessage("ovo je poruka");

        WebElement m = contactUsPage.getMessageField();
        System.out.println("Click send button");
        contactUsPage.clickSendButton();
        String confirmationMessage = contactUsPage.getConfirmationMsg();
        Assert.assertEquals(confirmationMessage,"Your message has been successfully sent to our team.",
                "The message should be equal to 'Your message has been successfully sent to our team.");
    }

    @Test
    public void contactUsUnHappyPath() throws IOException {
        wd.get("http://automationpractice.com/index.php?controller=contact");
        wd.manage().window().maximize();
        Assert.assertEquals(wd.getCurrentUrl(),"http://automationpractice.com/index.php?controller=contact",
                "The current url should be equal to http://automationpractice.com/index.php?controller=contact");

        ContactUs contactUsPage = new ContactUs(wd);
        System.out.println("Select 2 from dropdown");
        contactUsPage.selectValueFromDropdown("2");

        System.out.println("Click send button");
        contactUsPage.clickSendButton();

        String invalidMessage = contactUsPage.getInvalidMessage();
        Assert.assertTrue(invalidMessage.contains("Invalid email address."),"The message should be there is 1 error");
    }
}
