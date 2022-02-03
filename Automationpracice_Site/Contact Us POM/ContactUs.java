package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUs {

    private WebDriver driver;

    @FindBy(xpath = "//select[@id='id_contact']")
    WebElement dropdown;
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailAddress;
    @FindBy(xpath = "//input[@id='id_order']")
    WebElement orderRef;
    @FindBy(xpath = "//input[@id='fileUpload']")
    WebElement uploadFileField;
    @FindBy(xpath = "//textarea[@id='message']")
    WebElement messageField;
    @FindBy(xpath = "//button[@id='submitMessage']")
    WebElement sendMsg;
    @FindBy(className = "alert-success")
    WebElement confitmationBox;
    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]")
    WebElement invalidMail;

    public ContactUs(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void selectValueFromDropdown(String value){
        Select subject = new Select(dropdown);
        subject.selectByValue(value);
    }
    public void inputEmailAddress (String email){
       emailAddress.sendKeys(email);
   }
    public void inputOrderRef(String value){
    orderRef.sendKeys(value);
    }
    public void uploadFile(String pathToFile){
        uploadFileField.sendKeys(pathToFile);
    }
    public void sendAMessage(String message){
       messageField.sendKeys(message);
    }
    public WebElement getMessageField() {
        return new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='submitMessage']")));
    }
    public void clickSendButton(){
        sendMsg.click();
    }
    public String getConfirmationMsg(){
        return confitmationBox.getText();
   }
    public String getInvalidMessage(){
        return invalidMail.getText();
   }
}

