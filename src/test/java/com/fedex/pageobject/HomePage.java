package com.fedex.pageobject;

import com.fedex.ChromeDriverManager;
import net.jodah.failsafe.Failsafe;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.ExplicitWait;
import util.Page;
import util.RetryPolicyConfig;

import java.util.List;

public class HomePage extends AbstractPageObject {

    @FindBy(className = "fxg-geo-locator__body")
    private WebElement geoLocator;

    @FindBy(css = "[data-analytics='hdr|tab|1||Shipping']")
    private WebElement shippingDropdown;

    @FindBy(css = "[class*='options__search-btn']")
    private WebElement searchIcon;

    @FindBy(id = "fxg-search-text")
    private WebElement searchTextField;

    @FindBy(id = "trackingnumber")
    private WebElement searchBarTextField;

    @FindBy(id = "btnSingleTrack")
    private WebElement trackButton;

    @FindBy(css = "div.fxg-dropdown.fxg-global-nav > div > div:nth-child(1) .link")
    private List<WebElement> submenuElements;

    @FindBy(className = "fxg-user-options__sign-in-text")
    private WebElement loginMenu;

    @FindBy(css = "[title*='LOG IN']")
    private WebElement loginSubMenu;

    @FindBy(xpath = "//*[text()='LOCATIONS ']")
    private WebElement location;

    @FindBy(className = "va_icon")
    private WebElement chatIcon;
    @FindBy(css = "[class='nw_Popin shadow']")
    private WebElement chatWindow;

    private final String dataCountryCode = "[data-analytics*='%s']";

    @FindBy(className = "fxg-cookie-consent__actions")
    private WebElement cookieOption;

    public boolean isGeoLocatorDisplayed() {
        try {
            ExplicitWait.waitUntilVisible(driver, geoLocator);
            return geoLocator.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void selectCountryCode(String locale) {
        String element = String.format(dataCountryCode, locale);
        ExplicitWait.waitUntilVisible(driver, geoLocator);
        WebElement webElement = driver.findElement(By.cssSelector(element));
        ExplicitWait
                .waitUntilClickable(driver, webElement)
                .click();
        ExplicitWait.waitUntilUrlContains(driver, Page.DOMAIN.getUrl());
    }

    public HomePage openSearchField() {
        searchIcon.click();
        return this;
    }
    public void searchForParcelHeader(String trackingNumber) {
        searchTextField.sendKeys(trackingNumber);
        searchTextField.submit();
    }

    public void searchForParcelSearchBar(String trackingNumber) {
        searchBarTextField.sendKeys(trackingNumber);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        trackButton.click();
    }

    public void clickShipping() {
        shippingDropdown.click();
    }
    public int getSubmenuSize() {
        return submenuElements.size();
    }
    public void selectLocations() {
        location.click();
    }
    public HomePage clickSingUpLogin() {
        loginMenu.click();
        return this;
    }

    public void clickLogin() {
        loginSubMenu.click();
    }
    public WebElement cookieOption() {
        return cookieOption;
    }

    public void openChat() {

        Failsafe
                .with(RetryPolicyConfig.retryPolicy)
                .run(() -> {
                    ExplicitWait.waitUntilVisible(driver, chatIcon);
                    chatIcon.click();
                });
    }

    public WebElement getChatWindowElement() {
        return chatWindow;
    }
}
