package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class ProductCompare {
    WebDriver driver;

    public ProductCompare(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//body/div[@id='root']/div[@id='app']/div[@id='content']/div[1]/div[2]/div[1]/div[1]/nav[1]/div[1]/div[1]/div[1]/button[1]")
    WebElement menuButton;
    @FindBy(id = "main-nav-1")
    WebElement prenosniRacunar;
    @FindBy(xpath = "//body/div[@id='root']/div[@id='app']/div[@id='content']/div[@id='app-container']/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[2]/h3[1]/a[1]")
    WebElement torbeZaPrenosniRacunar;
    @FindBy(id = "compare-193071")
    WebElement samsoniteCompare;
    @FindBy(id = "compare-406681")
    WebElement lenovoCompare;
    @FindBy(className = "compare-widget" )
    WebElement compareBox;
    @FindBy(xpath = "//body/div[@id='root']/div[@id='app']/div[@id='content']/div[@id='app-container']/div[1]/div[1]/div[2]/a[1]")
    WebElement compareButton;

    public void compareTwoProducts() throws InterruptedException {
        menuButton.click();
        Thread.sleep(5000);
        prenosniRacunar.click();
        torbeZaPrenosniRacunar.click();
        samsoniteCompare.click();
        lenovoCompare.click();
        compareBox.click();
        compareButton.click();
    }
    public void compareOneProduct() throws InterruptedException {
        menuButton.click();
        Thread.sleep(5000);
        prenosniRacunar.click();
        torbeZaPrenosniRacunar.click();
        samsoniteCompare.click();
        compareBox.click();
        compareButton.click();
    }
}
