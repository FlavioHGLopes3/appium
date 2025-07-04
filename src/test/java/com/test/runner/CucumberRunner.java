package com.test.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "progress", "html:target/cucumber-reports.html"},
        features = {"src/test/resources/features/Login",
                "src/test/resources/features/produtos"},
        glue = {"com.test"},
        tags = "@Login,@Rateio"
)


public class CucumberRunner {

}
