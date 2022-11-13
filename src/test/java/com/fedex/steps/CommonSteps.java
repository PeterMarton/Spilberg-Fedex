package com.fedex.steps;

import com.fedex.ChromeDriverManager;
import com.fedex.pageobject.HomePage;
import com.fedex.pageobject.LocationSelectionPage;
import com.fedex.pageobject.TrackPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import util.ExplicitWait;
import util.Location;
import util.Page;
import util.WebConfig;

public class CommonSteps {

    private WebDriver getDriver() {
        return ChromeDriverManager.getDriver();
    }

    @When("I go to the main page")
    public void goToLandingPage() {
        getDriver().get(Page.DOMAIN.getUrl());
    }

    @When("I select {} with {position} option as location")
    public void selectLocationWithLanguage(String locationName, int languagePosition) {
        new LocationSelectionPage().selectLocation(locationName, languagePosition);
    }

    @Then("I was redirected to the expected page")
    public void indexPage() {
        Location country = Location.valueOf(LocationSelectionPage
                .getStoredLocationName()
                .toUpperCase());
        String language = country.getLanguage(LocationSelectionPage.getStoredLanguagePosition());
        ExplicitWait.waitUntilUrlLoaded(getDriver(), String.format(Page.HOME.getUrl(), language));
    }

    @When("I go to the main page of {} in {position} language")
    public void iGoToTheMainPageOfChinaWithInEnglish(String country, int position) {
        String locale = Location
                .valueOf(country.toUpperCase())
                .getLanguage(position);
        String url = String.format(Page.HOME.getUrl(), locale);
        getDriver().get(url);
        ExplicitWait.waitUntilUrlLoaded(getDriver(), url);

    }

    @Given("My location is different {}")
    public void myLocationIsDifferent(String locale) {
        String url = getDriver().getCurrentUrl();
        ExplicitWait.waitUntilUrlLoaded(getDriver(), url);
        new WebConfig().setLocationCookie(getDriver(), locale);

    }
    @Then("I see location selection option")
    public void iSeeLocationSelectionOption() {
        Assertions
                .assertThat(new HomePage().isGeoLocatorDisplayed())
                .as("Geo selection is not displayed! ")
                .isTrue();
    }
    @When("I select language {}")
    public void iSelectCountryCodeHU(String locale) {
        new HomePage().selectCountryCode(locale.toUpperCase());
    }
    @Then("I am on the {} page with language {}")
    public void iAmOnTheExpectedPage(String page, String locale) {
        Assertions
                .assertThat(getDriver().getCurrentUrl())
                .isEqualTo(String.format(Page
                        .valueOf(page)
                        .getUrl(), locale.toLowerCase()));
    }

    @When("I go to {} page with direct link with {} language settings")
    public void iGoToPageWithDirectLinkLanguageSettings(String page, String locale) {

        locale = "no".equals(locale) ? "" : locale;
        String url = String.format(Page
                .valueOf(page)
                .getUrl(), locale.toLowerCase());
        getDriver().get(url);
        new WebConfig().setLocationCookie(getDriver(), locale.substring(3, 5));
        ExplicitWait.waitUntilUrlLoaded(getDriver(), url);
    }

    @Then("I see message {}")
    public void iSeeMessage(String message) {
        Assertions
                .assertThat(message)
                .isEqualTo(new TrackPage().getErrorMessage());

    }
    @When("I search for parcel number {}")
    public void iSearchParcelWithNumber(String parcelNumber) {
        new HomePage().searchForParcelHeader(parcelNumber);
    }

    @When("I use home page search bar to find parcel number {}")
    public void iSearchParcelWithHomeSearchString(String parcelNumber) {
        new HomePage().searchForParcelSearchBar(parcelNumber);
    }

    @When("I open search field")
    public void openSearchField() {
        new HomePage().openSearchField();
    }

    @Then("I am on the {} page")
    public void iAmOnThePage(String page) {
        ExplicitWait.waitUntilUrlContains(getDriver(), Page
                .valueOf(page)
                .getUrl());
    }
    @Then("I am on the {} page with {} language")
    public void iAmOnThePageWithLanguage(String page, String locale) {
        ExplicitWait.waitUntilUrlLoaded(getDriver(), String.format(Page
                .valueOf(page)
                .getUrl(), locale));
    }

    @When("I select shipping")
    public void selectShipping() {
        new HomePage().clickShipping();
    }

    @When("I select locations")
    public void selectLocation() {
        new HomePage().selectLocations();
    }

    @When("Cookie option popped up")
    public void cookiesPopUp() {
        ExplicitWait.waitUntilClickable(getDriver(), new HomePage().cookieOption());
    }

    @When("I select login")
    public void clickLogin() {
        new HomePage()
                .clickSingUpLogin()
                .clickLogin();
    }

    @Then("I see {int} submenus in the list")
    public void iSeeSubmenuInTheList(int listSize) {
        Assertions
                .assertThat(new HomePage().getSubmenuSize())
                .isEqualTo(listSize);
    }
    @When("I click on Ask FedEx chat icon")

    public void clickOnChatIcon() {

        new HomePage().openChat();
    }

    @Then("Chat has been opened")
    public void chatIsOpen() {
        ExplicitWait.waitUntilVisible(getDriver(), new HomePage().getChatWindowElement());
    }
}
