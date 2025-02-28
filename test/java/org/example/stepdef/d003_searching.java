package org.example.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.p003_searching;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class d003_searching {
    //searching keyword
    String keyword="sofa";

    p003_searching search =new p003_searching();

    @Given("user navigate to the website and click on search bar")
    public void clickOnSearchBar(){
        search.searchBar.click();
    }

    @When("user search on a product keyword")
    public void userSearchOnAProductKeyword() {
        search.searchBar.sendKeys(keyword);
    }

    @And("click on search icon")
    public void clickOnSearchIcon() {
        search.searchIcon.click();
    }

    @Then("the results should be related to the searched key")
    public void theResultsShouldBeRelatedToTheSearchedKey() throws InterruptedException {
    List<WebElement> getSearchResultItems=search.getSearchResultItems();
        int count =0;
        // get size od searched items
        int size=search.getSearchResultItems().size();
   // loop on the searched items to check if the keyword included or not
        for(WebElement item :search.getSearchResultItems()){
          if(  item.getText().toLowerCase().contains(keyword)){
             //increase the counter if the keyword included in the item
              count++;
          }
          else {
              System.out.println(item.getText());
          }

        }
        //if the count equal size so all the searched result include keyword
        if(count==size){
            System.out.println("all searching result are related to the key word ");
        }
        else
        {  //if not so ni=ot all the items include the keyword and print the related items
            System.out.println("there are items unrelated to the searching keyword");
            System.out.println("Number of related search items :"+count);
        }
        // check if the related content section include the searching keyword or not
        count =0;
        size=search.relatedContent().size();
 for(WebElement item :search.relatedContent()){
          if(  item.getText().toLowerCase().contains(keyword)){
              count++;


          }
          else {
              System.out.println(item.getText());
          }

        }
        if(count==size){
            System.out.println("all related content  in the related content section are related to the search  key word ");
        }
        else
        {
            System.out.println("there are items unrelated in the related content section to the searching keyword");
            System.out.println("Number of related search items in the related content section :"+count);
        }
        // check if the Go to category section include the searching keyword or not
        count =0;
        size=search.goToCategory().size();

 for(WebElement item :search.goToCategory()){
          if(  item.getText().toLowerCase().contains(keyword)){
              count++;


          }
          else {
              System.out.println(item.getText());
          }

        }
        if(count==size){
            System.out.println("all searching result in the go to category section are related to the key word ");
        }
        else
        {
            System.out.println("there are items unrelated to the searching keyword in the go to category section ");
            System.out.println("Number of related search items in the go to category section :"+count);
        }




    }
}
