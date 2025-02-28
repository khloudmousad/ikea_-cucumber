package org.example.stepdef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.p004_randomProductDetail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

import static org.bouncycastle.oer.its.ieee1609dot2.CertificateId.name;
import static org.example.stepdef.Hook.driver;
import static org.example.stepdef.d001_register_.fake;

public class d004_randomProductDetail {

    p004_randomProductDetail product=new p004_randomProductDetail();
  SoftAssert soft =new SoftAssert();
Actions action =new Actions(driver);

    public d004_randomProductDetail() throws InterruptedException {
    }
  String  selectedProductNameInHomePage;
    String selectedProductpriceInHomePage;
    @When("user click on random product on the home page")
    public void clickOnRandomProduct(){

action.moveToElement(product.selectedProduct()).perform();
        selectedProductNameInHomePage=product.selectedProductNameInHomePage();
        selectedProductpriceInHomePage=product.selectedProductpriceInHomePage();
        product.selectedProduct().click();


    }

    @Then("the product details pge open")
    public void theProductDetailsPgeOpen() {
// assert that the product name and price is displayed on the product page
        soft.assertTrue(product.selectedProductNameInProductPage().isDisplayed());
        soft.assertTrue(product.selectedProductPriceInProductPage().isDisplayed());

        soft.assertAll();


    }

    @And("the product details in the home page same as in the product page")
    public void theProductDetailsInTheHomePageSameAsInTheProductPage() {

        soft.assertTrue(product.selectedProductNameInProductPage().getText().replaceAll("[\\s,\\n\\dx cm]+","").toLowerCase().trim().contains(selectedProductNameInHomePage.replaceAll("[\\s,\\n\\dx cm]+","").toLowerCase().trim()),"the product name in the home page not same as in the product page");
        soft.assertEquals(selectedProductpriceInHomePage,product.selectedProductPriceInProductPage().getText());
        soft.assertAll();
    }

}
