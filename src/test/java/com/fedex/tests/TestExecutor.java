package com.fedex.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(features = "src/test/resources/features/",
        glue = "com.fedex.steps",
        plugin = {
                "pretty",
                "json:target/cucumber/json/full.json",
                "html:target/cucumber/json/report.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "rerun:target/failedrerun.txt",
        },
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class TestExecutor extends AbstractTestNGCucumberTests {
    @BeforeSuite
    public void setupDocker() {
        System.setProperty("cucumber.filter.tags", "@" + System.getProperty("cucumberTag", "regression"));
    }
}
