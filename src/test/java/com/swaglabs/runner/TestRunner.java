package com.swaglabs.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // plugin is used for reports
        plugin = {"pretty", "html:target/site/cucumber-pretty.html"},

        snippets = CucumberOptions.SnippetType.CAMELCASE,

        // glue connects the feature file with the step definitions
        glue = {"com/swaglabs/stepdefinitions"},

        features = {"src/test/resources/features"},

        tags = "@Login",

        // Checks if the steps are defined or not; similar to headless
        dryRun = false

)

public class TestRunner {
}
