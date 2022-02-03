package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MetHotels {
    WebDriver driver;

    public MetHotels(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='naziv']")
    WebElement naziv;
    @FindBy(xpath = "//input[@id='adresa']")
    WebElement adresa;
    @FindBy(xpath = "//input[@id='cena']")
    WebElement cena;
    @FindBy(xpath = "//input[@id='slika']")
    WebElement slika;
    @FindBy(xpath = "//body/app-root[1]/div[1]/div[1]/div[1]/form-dodaj-smestaj[1]/form[1]/div[5]/button[1]")
    WebElement button;
    @FindBy(xpath = "//body/app-root[1]/div[1]/div[1]/div[2]/lista-smestaja-component[1]/div[1]/smestaj-component[1]/div[1]/div[1]/div[1]/a[2]")
    WebElement deleteFirst;

    public void addNewAccommodation() throws InterruptedException {
        naziv.click();
        naziv.sendKeys("Garsonjera");
        Thread.sleep(1000);
        adresa.click();
        adresa.sendKeys("Bulevar Oslobodjenja 110, Novi Sad");
        Thread.sleep(1000);
        cena.click();
        cena.sendKeys("5000");
        Thread.sleep(1000);
        slika.click();
        slika.sendKeys("https://reaanew.berza-nekretnine.com/uploads/images/stanovi/1004816/Garsonjera-podbara-1004816-7907.jpg");
        Thread.sleep(1000);
        button.click();
        Thread.sleep(1000);
    }
    public void deleteFirstAppartment() throws InterruptedException {
        deleteFirst.click();
        Thread.sleep(2000);
    }
}
