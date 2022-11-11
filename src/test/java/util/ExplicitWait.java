package util;

import org.openqa.selenium.WebDriver;
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

}
