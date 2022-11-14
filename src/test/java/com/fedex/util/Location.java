package com.fedex.util;

public enum Location {

    GREENLAND("en-gl", ""),
    ITALY("en-it", "it-it"),
    CHINA("en-cn", "zh-cn"),
    HUNGARY("en-hu", "hu-hu");

    private final String defaultLanguage;
    private final String extraLanguage;

    Location(String language, String extraLanguage) {
        this.defaultLanguage = language;
        this.extraLanguage = extraLanguage;
    }
    public String getLanguage(int position) {
        return switch (position) {
            case 1 -> defaultLanguage;
            case 2 -> extraLanguage;
            default -> null;
        };
    }

}
