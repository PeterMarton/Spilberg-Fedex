package com.fedex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class ChromeDriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            setupDriver();
        }
        return driver;
    }

    public static void setupDriver() {
        driver = new ChromeDriver(getChromeOptions());
    }

    public static void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();

        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
        chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        return chromeOptions;
    }

}
