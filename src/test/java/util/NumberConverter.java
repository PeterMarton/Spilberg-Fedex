package util;

public class NumberConverter {

    private NumberConverter() {
    }

    public static Integer getMatchingIndex(String option) {
        return switch (option.toLowerCase()) {
            case "first", "default" -> 1;
            case "second" -> 2;
            case "third" -> 3;
            case "fourth" -> 4;
            default -> null;
        };
    }
}
