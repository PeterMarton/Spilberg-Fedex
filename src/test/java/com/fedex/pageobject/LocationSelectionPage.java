package com.fedex.pageobject;

import com.fedex.ChromeDriverManager;
import org.openqa.selenium.By;

public class LocationSelectionPage extends AbstractPageObject {

    private static String storedLocationName;
    private static int storedLanguagePosition;

    public String languageLocation = "//*[contains(text(),'%s')]/a[%s]";

    public void selectLocation(final String locationName, final int languagePosition) {
        storedLocationName = locationName;
        storedLanguagePosition = languagePosition;

        ChromeDriverManager
                .getDriver()
                .findElement(By.xpath(String.format(languageLocation, locationName, languagePosition)))
                .click();
    }

    public static String getStoredLocationName() {
        return storedLocationName;
    }

    public static int getStoredLanguagePosition() {
        return storedLanguagePosition;
    }
}
