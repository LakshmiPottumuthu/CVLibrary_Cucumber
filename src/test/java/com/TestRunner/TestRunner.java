package com.TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",               
        },
        dryRun = false,
        monochrome  = true,
        features = {"src/test/resources/Features"},
        glue = {"com/StepDefinitions"}
)
public class TestRunner {

}
