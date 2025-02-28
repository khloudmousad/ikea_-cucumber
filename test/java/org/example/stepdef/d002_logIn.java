package org.example.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.p002_logIn;
import org.testng.asserts.SoftAssert;

public class d002_logIn {
    p002_logIn logIn =new p002_logIn();
   SoftAssert soft=new SoftAssert();

    @When("fill his mail and password")
    public void fillEmailAndPassword(){

     logIn.emailAddress.sendKeys(d001_register_.email);
     logIn.password.sendKeys(d001_register_.password);
    }

    @And("click on log in button")
    public void clickOnLogInButton() {
        logIn.logInButton.click();

    }

    @Then("user is logged in successfully")
    public void userIsLoggedInSuccessfully() {
        soft.assertEquals(logIn.heyUser.getText().toLowerCase(),d001_register_.firstname.toLowerCase()+d001_register_.lastname.toLowerCase());
    }
}
