package co.ebird.hotspot.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

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
    public static final Target INPUT_CITY = Target.the("Where we enter the city name")
            .locatedBy("#search-city");
    public static final Target ZOOM_BUTTON = Target.the("Button to reduce the zoom in the map")
            .locatedBy("/html/body/div[2]/div/div[2]/div[1]/div/div[1]/div/div[4]/div/div/div/button[2]");
    public static final Target HOTSPOT_MARK = Target.the("Where we select the hotspot")
            .locatedBy("*[title*=\"Bosques de Quebrada Sinifaná\"]");
    public static final Target HOTSPOT_BUTTON = Target.the("Button to open the hotspot")
            .locatedBy("//a[contains(text(),'Mostrar detalles')]");
}
