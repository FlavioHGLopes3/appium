package com.alura.appium;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty" },
        features = {"src/main/resources/Features"},
        glue = {"Steps"}
)

public class CucumberTest {

}
