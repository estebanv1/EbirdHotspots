package co.ebird.hotspot.exceptions;

public class HotspotException extends Exception {

    public static final String ASSERT_GO_TO_HOTSPOT = "Error ingresando al hotspot";
    public static final String ASSERT_REFRESH_BROWSER = "Error actualizando la página";


    public HotspotException(String message) {
        super(message);
    }

    public HotspotException(String message, Throwable cause) {
        super(message, cause);
    }
}
