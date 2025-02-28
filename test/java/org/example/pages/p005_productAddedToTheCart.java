package org.example.pages;

import com.github.javafaker.Faker;
import org.example.stepdef.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.stepdef.Hook.driver;

public class p005_productAddedToTheCart {
    Faker fake =new Faker();
    int random;
    Actions action=new Actions(Hook.driver);
    public p005_productAddedToTheCart(){
        PageFactory.initElements(Hook.driver,this);
    }
    @FindBy(xpath = "//div[@id=\"tab-products\"]//div[@class=\"hnf-carousel-slide\"][4]")
    public WebElement lightingCategory;
    @FindBy(xpath = "//a[@href=\"https://www.ikea.com/eg/en/cat/lamps-li002/\"]")
    public WebElement lambSubCategory;
    @FindBy(xpath = "//span[@class=\"hnf-header__cart-counter\"]")
    public WebElement quantityOfProduct;
    public void clikOnaddProductByAddProductButton() throws InterruptedException {
        //choose a random product number
        action.moveToElement(Hook.driver.findElement(By.xpath("//div[@class=\"rec-carousel-slide\"]"))).perform();
        Thread.sleep(4000);

        int  size =Hook.driver.findElements(By.xpath("//div[@class=\"plp-fragment-wrapper\"]//button[@class=\"plp-btn plp-btn--small plp-btn--icon-emphasised\"]")).size();
       random=fake.number().numberBetween(1,size);
        Hook.driver.findElement(By.xpath("//button[@id=\"onetrust-accept-btn-handler\"]")).click();
//click on the add to bag button of the product
      action.moveToElement(  Hook.driver.findElement(By.xpath("//div[@class=\"plp-fragment-wrapper\"]["+random+"]//button[@class=\"plp-btn plp-btn--small plp-btn--icon-emphasised\"]"))).perform();
        Hook.driver.findElement(By.xpath("//div[@class=\"plp-fragment-wrapper\"]["+random+"]//button[@class=\"plp-btn plp-btn--small plp-btn--icon-emphasised\"]")).click();
        Thread.sleep(5000);
    }
    public void clickOnProductAndAdditToTheCat() throws InterruptedException {
        //click on same random product
        Hook.driver.findElement(By.xpath("//div[@class=\"plp-fragment-wrapper\"]["+random+"]")).click();
        // add the product to the bag
         Hook.driver.findElement(By.xpath("//div[@class=\"pip-product__buy-module-container\"]//button[@aria-label=\"Add to bag\"]")).click();
         //click on continue shopping
        driver.findElement(By.xpath("//button[@aria-label=\"Continue shopping\"]")).click();
        Thread.sleep(2000);

    }

}
