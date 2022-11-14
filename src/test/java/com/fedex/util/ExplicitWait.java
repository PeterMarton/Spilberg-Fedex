package com.fedex.util;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class ExplicitWait {

    private ExplicitWait() {
    }

    private static FluentWait<WebDriver> getFluentWait(WebDriver driver) {
        return new FluentWait<>(driver).withTimeout(Duration.ofMillis(5000));
    }

    public static boolean waitUntilUrlContains(WebDriver driver, String url) {
        return getFluentWait(driver).until(ExpectedConditions.urlContains(url));
    }

    public static boolean waitUntilUrlLoaded(WebDriver driver, String url) {
        return getFluentWait(driver).until(ExpectedConditions.urlToBe(url));
    }

    public static WebElement waitUntilVisible(WebDriver driver, WebElement element) {
        return getFluentWait(driver)
                .ignoring(NoSuchElementException.class, ElementClickInterceptedException.class)
                .until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitUntilClickable(WebDriver driver, WebElement element) {
        return getFluentWait(driver)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
