package util;

public enum Page {
    INDEX("https://www.fedex.com"),
    HOME("https://www.fedex.com/%s/home.html"),
    CHOOSE_LOCATION(INDEX.getUrl() + "/global/choose-location.html");

    private final String url;

    Page(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
