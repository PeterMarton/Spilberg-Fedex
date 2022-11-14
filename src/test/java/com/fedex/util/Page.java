package com.fedex.util;

public enum Page {
    DOMAIN("https://www.fedex.com/"),
    HOME(DOMAIN.getUrl() + "%s/home.html"),
    FEDEX_TRACK(DOMAIN.getUrl() + "fedextrack/"),
    FEDEX_TRACK_ERROR(DOMAIN.getUrl() + "fedextrack/system-error"),
    LOGIN(DOMAIN.getUrl() + "secure-login/%s/#/login-credentials"),
    LOCATION("https://local.fedex.com/%s"),
    CHOOSE_LOCATION(DOMAIN.getUrl() + "global/choose-location.html");

    private final String url;

    Page(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
