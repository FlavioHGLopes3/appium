package com.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "html:target/cucumber-reports.html"},
        features = {"src/test/resources/features"},
        glue = {"com.test"}
//        tags = "@Emulator"
)


public class CucumberRunner {

}
