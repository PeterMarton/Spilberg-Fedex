package util;

public enum Location {

    GREENLAND("en-gl", ""),
    ITALY("en-gl", "it-it"),
    HUNGARY("en-hu", "hu-hu");

    private final String defaultLanguage;
    private final String extraLanguage;

    Location(String language, String extraLanguage) {
        this.defaultLanguage = language;
        this.extraLanguage = extraLanguage;
    }
    public String getLanguage(String location, int position) {
        return switch (position) {
            case 1 -> defaultLanguage;
            case 2 -> extraLanguage;
            default -> null;
        };
    }

}
