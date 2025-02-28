package org.example.pages;

import org.example.stepdef.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.systeminfo.model.Size;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.example.stepdef.Hook.driver;
import static org.example.stepdef.d001_register_.fake;

public class p007_placeOrder {
    public p007_placeOrder(){
        PageFactory.initElements(Hook.driver,this);
    }
    Actions action =new Actions(driver);
    int random;
    public void addRandomProductToThebag() throws InterruptedException {
        Hook.driver.findElement(By.xpath("//button[@id=\"onetrust-accept-btn-handler\"]")).click();
        action.moveToElement(Hook.driver.findElement(By.xpath("//div[@class=\"rec-carousel-slide\"]"))).perform();

        Thread.sleep(5000);
        int  size =Hook.driver.findElements(By.xpath("//div[@class=\"rec-carousel-slide\"]")).size();
        System.out.println(size);
        random=fake.number().numberBetween(1,size);
        action.moveToElement(Hook.driver.findElement(By.xpath("//div[@class=\"rec-carousel-slide\"]["+random+"]"))).perform();
        Thread.sleep(2000);

        Hook.driver.findElement(By.xpath("//div[@class=\"rec-carousel-slide\"]["+random+"]")).click();
        // add the product to the bag
        action.moveToElement(Hook.driver.findElement(By.xpath("//div[@class=\"pip-buy-module__buy-button-container \"]//button[@aria-label=\"Add to bag\"]"))).click().perform();
        //click on continue to shopping bag
        driver.findElement(By.xpath("//a[@aria-label=\"Go to shopping bag\"]")).click();
        Thread.sleep(2000);

    }
    public WebElement checkOutbutton(){
        return driver.findElement(By.xpath("//button[@data-testid=\"summary-checkout-button\"]"));
    }
    public WebElement fullNAme(){
      return  driver.findElement(By.xpath("//input[@placeholder=\"Full Name\"]"));
    }

     public void selectGovern(){

         action.moveToElement(driver.findElement(By.xpath("//select[@class=\"form-control input-lg-4\"][@name=\"NewAddress.AreaId\"]"))).click().perform();
         int size= driver.findElements(By.xpath("//select[@class=\"form-control input-lg-4\"][@name=\"NewAddress.AreaId\"]/option")).size();

         driver.findElement(By.xpath("//select[@class=\"form-control input-lg-4\"][@name=\"NewAddress.AreaId\"]/option["+fake.number().numberBetween(2,size)+"]")).click();

    }
     public void selectArea(){

         driver.findElement(By.xpath("//select[@class=\"form-control input-lg-4\"][@name=\"NewAddress.CityAreaId\"]")).click();
        int size= driver.findElements(By.xpath("//select[@class=\"form-control input-lg-4\"][@name=\"NewAddress.CityAreaId\"]/option")).size();

         driver.findElement(By.xpath("//select[@class=\"form-control input-lg-4\"][@name=\"NewAddress.CityAreaId\"]/option["+fake.number().numberBetween(2,size)+"]")).click();
    }

     public WebElement email(){
       return driver.findElement(By.xpath("//input[@placeholder=\"sample1@sample.com\"]"));
    }
     public WebElement mobileNumber(){
        return driver.findElement(By.xpath("//input[@placeholder=\"XXXXXXXXXXX\"]"));
    }
     public WebElement address(){
       return driver.findElement(By.xpath("//input[@placeholder=\"Address\"]"));
    }
     public WebElement buildnameApartnumFloorNum(){
       return driver.findElement(By.xpath("//input[@placeholder=\"Building Name/Apartment No./Floors No.\"]"));
    }
     public WebElement continueButton() throws InterruptedException {
        return driver.findElement(By.xpath("//button[@id=\"billingSubmitButton\"]"));
    }
    public void clickContinueToPayment(){
        //click on continue to payment
       action.moveToElement( driver.findElement(By.xpath("//button[@id=\"deliveryAndAssemblyContinue\"]"))).perform();
        driver.findElement(By.xpath("//button[@id=\"deliveryAndAssemblyContinue\"]")).click();
    }
    public void chooseCODpaymentandPlaceOrder(){

        //choose cash on delivery payment
        action.moveToElement(driver.findElement(By.xpath("//div[@class=\"row\"][8]//span[@class=\"checkmark\"]"))).click().perform();
        //click on place order button
       action.moveToElement(driver.findElement(By.xpath("//button[@onclick=\"onCashOnDeliveryPay()\"]"))).perform();
        driver.findElement(By.xpath("//button[@onclick=\"onCashOnDeliveryPay()\"]")).click();
    }
    public WebElement OTPmessage(){
      return  driver.findElement(By.xpath("//button[@class=\"btn btn-primary opcbuttons longText\"]"));
    }

}
