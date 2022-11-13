package com.fedex.pageobject;

import com.fedex.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPageObject implements PageObject {

    protected WebDriver driver;

    public AbstractPageObject() {
        init();
    }

    @Override
    public void init() {
        this.driver = ChromeDriverManager.getDriver();
        PageFactory.initElements(ChromeDriverManager.getDriver(), this);
    }

}
