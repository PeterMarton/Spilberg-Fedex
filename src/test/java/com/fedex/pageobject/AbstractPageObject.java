package com.fedex.pageobject;

import com.fedex.ChromeDriverManager;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPageObject implements PageObject {

    @Override
    public void init() {
        PageFactory.initElements(ChromeDriverManager.getDriver(), this);
    }

}
