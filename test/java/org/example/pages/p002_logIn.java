package org.example.pages;

import org.example.stepdef.Hook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class p002_logIn {
    public p002_logIn(){
        PageFactory.initElements(Hook.driver,this);
    }
    @FindBy(xpath = "//input[@id=\"login-email\"]")
    public WebElement emailAddress;
     @FindBy(xpath = "//input[@type=\"password\"]")
    public WebElement password;
  @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement logInButton;
  //  user name on the home page after logging in
 @FindBy(xpath = "//a[@href=\"https://www.ikea.com/eg/en/profile/login/\"][3]//span[@class=\"hnf-btn__label\"]")
    public WebElement heyUser;

}
