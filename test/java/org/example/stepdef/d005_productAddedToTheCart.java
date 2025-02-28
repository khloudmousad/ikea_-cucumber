package org.example.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.p005_productAddedToTheCart;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class d005_productAddedToTheCart {
    p005_productAddedToTheCart cart =new p005_productAddedToTheCart();
SoftAssert soft =new SoftAssert();
@When("user click on lighting category and choose lamb subcategory")
    public void clickOnLightingCategoryAndLambSubCategory()  {
    cart.lightingCategory.click();
    cart.lambSubCategory.click();

}

    @And("click on  “Add to Bag” button on a random product")
    public void clickOnAddToBagButtonOnARandomProduct() throws InterruptedException {
        cart.clikOnaddProductByAddProductButton();

    }

    @When("Click on the same product and add it to the bag")
    public void clickOnTheSameProductAndAddItToTheBag() throws InterruptedException {
    cart.clickOnProductAndAdditToTheCat();
        
    }

    @Then("the quantity displayed in the bag should be {int}")
    public void theQuantityDisplayedInTheBagShouldBe(int arg0) {
    soft.assertEquals(cart.quantityOfProduct.getText(),"2");
    soft.assertAll();
    }


}
