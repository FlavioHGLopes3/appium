package com.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "progress", "html:target/cucumber-report.html" },
        features = {"src/test/resources/features"},
        glue = {"com.test"}
)


public class CucumberRunner {

}
