package org.example.pages;

import org.example.stepdef.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.example.stepdef.Hook.driver;

public class p003_searching {
    public p003_searching() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id=\"ikea-search-input\"]")
    public WebElement searchBar;
    @FindBy(xpath = "//button[@id=\"search-box__searchbutton\"]")
    public WebElement searchIcon;
// search result items
    public ArrayList<WebElement> getSearchResultItems() {
        return new ArrayList<WebElement>(Hook.driver.findElements(By.xpath("//div[@class='plp-fragment-wrapper']//h3//span[2]")));

    }
    // related content section items

    public ArrayList<WebElement> relatedContent() {
        return new ArrayList<WebElement>(Hook.driver.findElements(By.xpath("//div[@class=\"plp-carousel-slide plp-content-item\"]//p[2]")));
    }
//Go to category section items
    public ArrayList<WebElement> goToCategory() {
        return new ArrayList<WebElement>(Hook.driver.findElements(By.xpath("//div[@class=\"plp-carousel-slide shelf-item\"]//p[2]")));
    }
}


