package util;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class WebConfig {

    public void setLocationCookie(WebDriver driver, String locale) {
        Cookie cook = driver
                .manage()
                .getCookieNamed("xacc");
        driver
                .manage()
                .deleteCookie(cook);
        Cookie cookie1 = new Cookie("xacc", locale);
        driver
                .manage()
                .addCookie(cookie1);
        driver
                .navigate()
                .refresh();
    }
}
