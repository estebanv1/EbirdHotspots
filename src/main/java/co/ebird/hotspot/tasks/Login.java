package co.ebird.hotspot.tasks;

import co.ebird.hotspot.models.LoginData;
import static co.ebird.hotspot.userinterfaces.LoginPage.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class Login implements Task{

    private final LoginData loginData;
    private final String city;
    private final String hotspot;

    public Login(LoginData loginData, String city, String hotspot) {
        this.loginData = loginData;
        this.city = city;
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
            Enter.theValue(city.substring(0,city.length() - 1)).into(INPUT_CITY)
            );
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        actor.attemptsTo(
                Enter.theValue(city.substring(city.length() - 1)).into(INPUT_CITY)
        );
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        actor.attemptsTo(
            Hit.the(Keys.ENTER).into((INPUT_CITY)),
            Click.on(ZOOM_BUTTON),
            Click.on(ZOOM_BUTTON),
            Click.on(ZOOM_BUTTON),
                Click.on(ZOOM_BUTTON),
            Click.on(String.format(HOTSPOT_MARK.getCssOrXPathSelector(), hotspot)),
            Click.on(HOTSPOT_BUTTON)
        );
    }
}
