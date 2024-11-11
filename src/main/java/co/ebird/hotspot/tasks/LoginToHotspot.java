package co.ebird.hotspot.tasks;

import co.ebird.hotspot.models.LoginData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static co.ebird.hotspot.userinterfaces.LoginPage.*;
import static co.ebird.hotspot.userinterfaces.LoginPage.LOGIN_BUTTON;

public class LoginToHotspot implements Task{

    private static final Logger LOGGER = LogManager.getLogger(LoginToHotspot.class);
    private final String hotspotUrl;
    private final LoginData loginData;

    public LoginToHotspot(String hotspotUrl, LoginData loginData) {
        this.loginData = loginData;
        this.hotspotUrl = hotspotUrl;
    }

    public static LoginToHotspot byUrl(String hotspotUrl, LoginData loginData) {
        return Tasks.instrumented(LoginToHotspot.class, hotspotUrl, loginData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LOG_IN_LINK),
                Enter.theValue(loginData.getStrUsername()).into(INPUT_USERNAME),
                Enter.theValue(loginData.getStrPassword()).into(INPUT_PASSWORD),
                Click.on(LOGIN_BUTTON));
        LOGGER.log(Level.INFO, "Abriendo Hotspot {}", hotspotUrl);
        BrowseTheWeb.as(actor).openUrl(hotspotUrl);
    }
}
