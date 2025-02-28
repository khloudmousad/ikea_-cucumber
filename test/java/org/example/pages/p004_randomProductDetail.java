package org.example.pages;

import com.github.javafaker.Faker;
import org.example.stepdef.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

import static org.example.stepdef.Hook.driver;
import static org.example.stepdef.d001_register_.fake;

public class p004_randomProductDetail {
    public p004_randomProductDetail() throws InterruptedException {
        PageFactory.initElements(Hook.driver,this);

    }
    Actions action =new Actions(driver);
    Faker fake =new Faker();
    // array list of the products list
    public ArrayList<WebElement> products() throws InterruptedException {
        action.moveToElement(Hook.driver.findElement(By.xpath("//div[@class=\"rec-carousel-slide\"]"))).perform();

        Thread.sleep(4000);
        return new ArrayList<WebElement>(Hook.driver.findElements(By.xpath("//div[@class=\"rec-carousel-slide\"]")));
    }
    int size =products().size();


    final int  random =fake.number().numberBetween(1,size);

    public WebElement selectedProduct() {   return driver.findElement(By.xpath("//div[@class=\"rec-carousel-slide\"]["+random+"]"));}
    public String selectedProductNameInHomePage () { return   driver.findElement(By.xpath("//div[@class=\"rec-carousel-slide\"]["+random+"]//h3")).getText();}
    public String selectedProductpriceInHomePage()  { return   driver.findElement(By.xpath("//div[@class=\"rec-carousel-slide\"]["+random+"]//span[@class=\"pip-price pip-price--leading pip-price--leading pip-price--medium pip-price--currency-super-aligned pip-price--decimal-super-aligned pip-price-module__current-price\"]//span[@class=\"pip-price__nowrap\"]//span[2]")).getText();}


// product name in the home page
   public WebElement selectedProductNameInProductPage(){
      return driver.findElement(By.xpath("//h1[@class=\"pip-header-section\"]//div[@class=\"pip-header-section__container-text\"]"));
  }
  //product price on the homepage
public WebElement selectedProductPriceInProductPage(){
      return driver.findElement(By.xpath("//div[@class=\"js-price-package pip-price-package\"]//span[@class=\"pip-price pip-price--leading pip-price--leading pip-price--medium pip-price--currency-super-aligned pip-price--decimal-super-aligned pip-price-module__current-price\"]//span[@class=\"pip-price__nowrap\"]//span[2]"));

}

}
