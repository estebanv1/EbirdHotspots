package co.ebird.hotspot.tasks;

import co.ebird.hotspot.models.LoginData;

import static co.ebird.hotspot.exceptions.HotspotException.ASSERT_GO_TO_HOTSPOT;
import static co.ebird.hotspot.userinterfaces.LoginPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;

import java.time.Duration;

public class Login implements Task{

    private static final Logger LOGGER = LogManager.getLogger(Login.class);
    private final LoginData loginData;
    private final String place;
    private final String hotspot;

    public Login(LoginData loginData, String place, String hotspot) {
        this.loginData = loginData;
        this.place = place;
        this.hotspot = hotspot;
    }

    public static Login onThePage(LoginData loginData, String city, String hotspot) {
        return Tasks.instrumented(Login.class, loginData, city, hotspot);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(LOG_IN_LINK),
            Enter.theValue(loginData.getStrUsername()).into(INPUT_USERNAME),
            Enter.theValue(loginData.getStrPassword()).into(INPUT_PASSWORD),
            Click.on(LOGIN_BUTTON),
            Click.on(EXPLORE_BUTTON),
            Click.on(HOTSPOTS_BUTTON),
            Enter.theValue(place.substring(0, place.length() - 1)).into(INPUT_PLACE)
            );
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            LOGGER.info(ASSERT_GO_TO_HOTSPOT);
            Thread.currentThread().interrupt();
        }
        actor.attemptsTo(
                Enter.theValue(place.substring(place.length() - 1)).into(INPUT_PLACE)
        );
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            LOGGER.info(ASSERT_GO_TO_HOTSPOT);
            Thread.currentThread().interrupt();
        }
        actor.attemptsTo(
                Hit.the(Keys.ENTER).into((INPUT_PLACE)),
                Click.on(ZOOM_BUTTON),
                Click.on(ZOOM_BUTTON),
                Click.on(ZOOM_BUTTON),
                Click.on(ZOOM_BUTTON),
                WaitUntil.the(String.format(HOTSPOT_MARK.getCssOrXPathSelector(), hotspot), isPresent())
                        .forNoMoreThan(Duration.ofSeconds(15)).then(
                                Click.on(String.format(HOTSPOT_MARK.getCssOrXPathSelector(), hotspot))),
                Click.on(HOTSPOT_BUTTON)
        );
    }
}
