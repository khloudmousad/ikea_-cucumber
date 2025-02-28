package org.example.stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Hook {
    public static WebDriver driver;

    @Before
    public void beforemethod()
    {
        WebDriverManager.chromedriver().setup();


        //option.addExtensions(new File("C:\\Users\\khloo\\IdeaProjects\\cucumber\\src\\main\\resources\\AdBlock — block ads across the web - Chrome Web Store 6.14.1.0.crx"));
        driver =new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100000, TimeUnit.MILLISECONDS);
        driver.get("https://www.ikea.com/eg/en/");



    }




    @After
    public  void aftermethod()
    {

        driver.quit();
    }
}
