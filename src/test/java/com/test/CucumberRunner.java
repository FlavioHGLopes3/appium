package com.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "progress", "html:target/cucumber-report.html" },
        features = {"src/test/resources/features"},
        glue = {"Steps"}
)

public class CucumberRunner {

}
