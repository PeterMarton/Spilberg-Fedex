package com.fedex.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrackPage extends AbstractPageObject {

    @FindBy(css="[class*='text-left']")
    private WebElement errorMessage;

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
