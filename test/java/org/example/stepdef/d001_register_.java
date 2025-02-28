package org.example.stepdef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.p001_registerPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.example.stepdef.Hook.driver;

public class d001_register_ {
    p001_registerPage register=new p001_registerPage();
    SoftAssert soft =new SoftAssert();
    WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
    public static Faker fake=new Faker();
    public static String firstname=fake.name().firstName();
    public static String lastname=fake.name().lastName();
   public static String email =fake.internet().emailAddress();
   public static String password =fake.internet().password(8,10)+"A_Z@";
@Given("user navigate to ikea website click on create and log in button")
    public void Navigate_to_the_register_page(){
    //click on register/login button
    register.signUpPAge.click();

}

    @When("user click on create account")
    public void userClickOnCreateAccountButton() {
    //click on create account
        register.createAccountButto.click();


    }

    @And("fill register required filled and click on create account button")
    public void fillRegisterRequiredFilled() throws InterruptedException {
         WebElement createAccountButtonConfirmed  = driver.findElement(By.xpath("//button[@data-testid='sign-up-create-account']"));
    Actions action =new Actions(driver);
    //fill account info
    register.firstName.sendKeys(firstname);
    register.lastNAme.sendKeys(lastname);
    register.email.sendKeys(email);
    register.password.sendKeys(password);
        WebElement body = driver.findElement(By.tagName("body"));
// Scroll down using PAGE_DOWN
        body.sendKeys(Keys.PAGE_DOWN);
        WebElement Checkbox_termsAndCondition =driver.findElement(By.xpath("//input[@data-testid=\"privacy-policy-checkbox\"]"));
  Thread.sleep(3000);
  Checkbox_termsAndCondition.click();

createAccountButtonConfirmed.click();

}

    @Then("user is registered sucessfully")
    public void userIsRegisteredSucessfully() {
    // assert that a welcome message by th registered name is displayed after the user is successfully registered
    soft.assertEquals(register.heyUser.getText().toLowerCase(),firstname.toLowerCase()+lastname.toLowerCase());
    }
}
