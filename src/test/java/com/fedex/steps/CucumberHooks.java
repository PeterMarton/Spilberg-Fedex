package com.fedex.steps;

import com.fedex.ChromeDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CucumberHooks {
    private static final Logger LOGGER = LoggerFactory.getLogger(CucumberHooks.class);

    @Before
    public void beforeScenario(Scenario scenario) {

        ChromeDriverManager.setupDriver();
        scenario.log("### Testcase \"" + scenario
                .getName()
                .toUpperCase() + "\" has been started");

    }

    @After
    public void afterScenario(Scenario scenario) {
        scenario.log("### Testcase \"" + scenario
                .getName()
                .toUpperCase() + "\" has " + scenario.getStatus());

        ChromeDriverManager.tearDownDriver();
    }
}

