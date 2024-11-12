package co.ebird.hotspot.utils;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String INITIAL_PAGE = "https://www.ebird.org/";
    public static final String USERNAME = System.getProperty("USERNAME", "user");
    public static final String PASSWORD = System.getProperty("PASSWORD", "pass");
}
