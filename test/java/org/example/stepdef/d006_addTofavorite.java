package org.example.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.p006_addTofavorite;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class d006_addTofavorite {
Actions action=new Actions(Hook.driver);
p006_addTofavorite favor =new p006_addTofavorite();

SoftAssert soft =new SoftAssert();
    public d006_addTofavorite() throws InterruptedException {
    }

    @When("user add random product on favorite list")
    public void addRandomProductToFavorite () throws InterruptedException {

        favor.addRandomProductToFavorite();
    }

    @And("click on view button to show favorite page")
    public void clickOnViewButtonToShowFavoritePage() throws InterruptedException {
        favor.favoritePage.click();
        Thread.sleep(4000);

    }

    @Then("the added to favorite product should be viewed on the favorite page")
    public void theAddedToFavoriteProductShouldBeViewedOnTheFavoritePage() {
        soft.assertEquals(favor.selectedProductNameInHomePage.replaceAll("[\\s \\n ,.\\d]+",""), favor.selectedProductNameInFavorite().replaceAll("[\\s \\n ,.\\d]+",""));
    }
    @Then("remove the product from favorite page")
    public void removeTheProductFromFavoritePage() {
        favor.removeFromFavorite().click();
    }
}
