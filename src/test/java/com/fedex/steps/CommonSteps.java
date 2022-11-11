package com.fedex.steps;

import com.fedex.ChromeDriverManager;
import com.fedex.pageobject.LocationSelectionPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import util.ExplicitWait;
import util.Location;
import util.Page;

public class CommonSteps {

    private WebDriver getDriver() {
        return ChromeDriverManager.getDriver();
    }

    @When("I go to the main page")
    public void goToLandingPage() {
        getDriver().get(Page.INDEX.getUrl());
    }

    @Then("The {} page is loaded successfully")
    public void validatePageLoaded(String page) {
        Assertions
                .assertThat(getDriver().getCurrentUrl())
                .as("Expected page is not loaded")
                .contains(Page
                        .valueOf(page)
                        .getUrl());
    }

    @When("I select {} with {position} option as location")
    public void selectLocationWithLanguage(String locationName, int languagePosition) {
        new LocationSelectionPage().selectLocation(locationName, languagePosition);
    }

    @Then("I redirected to the expected page")
    public void indexPage() {
        Location country = Location.valueOf(LocationSelectionPage
                .getStoredLocationName()
                .toUpperCase());
        String location = country.name();
        String language = country.getLanguage(location, LocationSelectionPage.getStoredLanguagePosition());
        ExplicitWait.waitUntilUrlLoaded(getDriver(), String.format(Page.HOME.getUrl(), language));
    }

}
