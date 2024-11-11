package co.ebird.hotspot.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class LoginPage extends PageObject{

    public static final Target LOG_IN_LINK = Target.the("Button link to go to the login page")
            .locatedBy("//a[contains(text(),'Iniciar sesión')]");
    public static final Target INPUT_USERNAME = Target.the("Where we enter the username")
            .locatedBy("#input-user-name");
    public static final Target INPUT_PASSWORD = Target.the("Where we enter the password")
            .locatedBy("#input-password");
    public static final Target LOGIN_BUTTON = Target.the("Button to login")
            .locatedBy("#form-submit");
    public static final Target EXPLORE_BUTTON = Target.the("Button to go to the explore page")
            .locatedBy("//strong[contains(text(),'Explorar')]");
    public static final Target HOTSPOTS_BUTTON = Target.the("Button to go to the hotspots page")
            .locatedBy("//a[contains(text(),'Explorador de sitios de interés')]");
    public static final Target INPUT_PLACE = Target.the("Where we enter the place name")
            .locatedBy("#search-city");
    public static final Target ZOOM_BUTTON = Target.the("Button to reduce the zoom in the map")
            .locatedBy("#map > div:nth-child(1) > div > div:nth-child(4) > div > div > div > button:nth-child(3)");
    public static final Target HOTSPOT_MARK = Target.the("Where we select the hotspot")
            .locatedBy("*[title*=\"%s\"]");
    public static final Target HOTSPOT_BUTTON = Target.the("Button to open the hotspot")
            .locatedBy("//a[contains(text(),'Mostrar detalles')]");
}
