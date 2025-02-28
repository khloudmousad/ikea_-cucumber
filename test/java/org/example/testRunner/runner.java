package org.example.testRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import java.awt.*;


@CucumberOptions
        (
                features = "src/main/resources/features",
                glue="org/example/stepdef",
                tags="",
                plugin = {"pretty" ,
                        "html:reports/report.html"}
        )
public class runner extends AbstractTestNGCucumberTests{
}
