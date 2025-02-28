package org.example.pages;

import org.example.stepdef.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

import static org.example.stepdef.Hook.driver;

public class p001_registerPage {
    public p001_registerPage(){
        PageFactory.initElements(Hook.driver,this);
    }
    @FindBy(xpath ="//li[@class=\"hnf-header__profile-link\"]")
    public WebElement  signUpPAge;
    @FindBy(xpath ="//button[@class=\"skapa-mvagent-wrapper-prefix-btn skapa-mvagent-wrapper-prefix-btn--secondary skapa-mvagent-wrapper-prefix-btn--fluid\"]")
    public WebElement  createAccountButto;
    @FindBy(xpath ="//input[@id=\"first-name\"]")
    public WebElement firstName ;
    @FindBy(xpath ="//input[@id=\"last-name\"]")
    public WebElement lastNAme ;
    @FindBy(xpath ="//input[@id=\"email\"]")
    public WebElement email ;
    @FindBy(xpath ="//input[@id=\"password\"]")
    public WebElement password ;
   // Welcome message name
    @FindBy(xpath ="//h1[@class=\"main-page_header__ks6+-\"]")
    public WebElement heyUser ;

}
