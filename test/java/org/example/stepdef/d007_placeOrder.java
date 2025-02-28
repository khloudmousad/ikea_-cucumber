package org.example.stepdef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.p007_placeOrder;
import org.testng.asserts.SoftAssert;

public class d007_placeOrder {
    p007_placeOrder order =new p007_placeOrder();
    Faker fake=new Faker();
    SoftAssert soft =new SoftAssert();
   @When("user add random product to the cart")
    public void addRandomProductToTheCart() throws InterruptedException {
       order.addRandomProductToThebag();

   }

    @And("go  to check out Afill billing address field")
    public void goToCheckOutAfillBillingAddressField() throws InterruptedException {
       order.checkOutbutton().click();
       order.fullNAme().sendKeys(fake.name().fullName());
       order.selectGovern();
       order.selectArea();
       order.email().sendKeys(fake.internet().safeEmailAddress());
       order.mobileNumber().sendKeys("01016611555");
       order.address().sendKeys(fake.address().streetAddress());
       order.buildnameApartnumFloorNum().sendKeys(fake.address().buildingNumber());
       order.continueButton().click();
       Thread.sleep(4000);


    }

    @And("choose delivery date and address")
    public void chooseDeliveryDateAndAddress() {
        order.clickContinueToPayment();

    }

    @And("choose payment method and place the order")
    public void choosePaymentMethodAndPlaceTheOrder() {
        order.chooseCODpaymentandPlaceOrder();


    }

    @Then("the OTP message should be displayed")
    public void theOTPMessageShouldBeDisplayed() {
       soft.assertEquals(order.OTPmessage().getText(),"Send One Time Password (OTP)","The  OTP message didnot displayed ");

    }
}
