package org.example;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

public class Main {

        public static void main(String[] args) {
            WebDriverManager.chromedriver().setup(); // Set up ChromeDriver
            WebDriver driver = new ChromeDriver(); // Initialize driver
            driver.manage().window().maximize();

            // Cast WebDriver to JavascriptExecutor


                    driver.get("https://www.google.com/search?q=wuzzuf&oq=wuzzuf&gs_lcrp=EgZjaHJvbWUyBggAEEUYOdIBCDU5OTdqMGo0qAIAsAIB&sourceid=chrome&ie=UTF-8");
            Actions actions = new Actions(driver);
            actions.scrollByAmount(0, 1000).perform();
        }
    }

