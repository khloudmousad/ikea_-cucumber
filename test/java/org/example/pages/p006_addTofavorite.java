package org.example.pages;

import org.example.stepdef.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

import static org.example.stepdef.Hook.driver;
import static org.example.stepdef.d001_register_.fake;

public class p006_addTofavorite {
    public p006_addTofavorite() throws InterruptedException {
        PageFactory.initElements(Hook.driver,this);
    }
   public String  selectedProductNameInHomePage;

    Actions action =new Actions(Hook.driver);
    public ArrayList<WebElement> products() throws InterruptedException {
        action.moveToElement(Hook.driver.findElement(By.xpath("//div[@class=\"rec-carousel-slide\"]"))).perform();

        Thread.sleep(4000);
        return new ArrayList<WebElement>(Hook.driver.findElements(By.xpath("//div[@class=\"rec-carousel-slide\"]")));
    }
    int random;

    public void addRandomProductToFavorite() throws InterruptedException {
        Hook.driver.findElement(By.xpath("//button[@id=\"onetrust-accept-btn-handler\"]")).click();

        int size =products().size();

        random = fake.number().numberBetween(1, size);
        action.moveToElement( driver.findElement(By.xpath("//div[@class=\"rec-carousel-slide\"]["+random+"]"))).perform();

        selectedProductNameInHomePage= driver.findElement(By.xpath("//div[@class=\"rec-carousel-slide\"][" + random + "]//h3")).getText();
        driver.findElement(By.xpath("//div[@class=\"rec-carousel-slide\"]["+random+"]//button[@class=\"pip-btn pip-btn--small pip-btn--icon-tertiary pip-product-compact__add-to-list-button\"]")).click();

    }

    @FindBy(xpath = "//button[@class=\"skapa-mvagent-wrapper-prefix-btn skapa-mvagent-wrapper-prefix-btn--small skapa-mvagent-wrapper-prefix-btn--plain skapa-mvagent-wrapper-prefix-toast__action-message\"]")
    public WebElement favoritePage;

public String selectedProductNameInFavorite() {
    return driver.findElement(By.xpath(" //span[@class=\"fav-price-module__description\"]/p")).getText();
}
public WebElement removeFromFavorite() {
    return driver.findElement(By.xpath("//button[@class=\"fav-btn fav-btn--xsmall fav-btn--icon-tertiary fav-quantity-stepper__decrease\"]"));
}


}
