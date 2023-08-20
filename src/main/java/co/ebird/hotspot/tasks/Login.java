package co.ebird.hotspot.tasks;

import co.ebird.hotspot.models.LoginData;
import co.ebird.hotspot.userinterfaces.LoginPage;
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

    public Login(LoginData loginData) {
        this.loginData = loginData;
    }

    public static Login onThePage(LoginData loginData) {
        return Tasks.instrumented(Login.class, loginData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(LoginPage.LOG_IN_LINK),
            Enter.theValue(loginData.getStrUsername()).into(LoginPage.INPUT_USERNAME),
            Enter.theValue(loginData.getStrPassword()).into(LoginPage.INPUT_PASSWORD),
            Click.on(LoginPage.LOGIN_BUTTON),
            Click.on(LoginPage.EXPLORE_BUTTON),
            Click.on(LoginPage.HOTSPOTS_BUTTON),
            Enter.theValue("Bolombol").into(LoginPage.INPUT_CITY)
            );
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        actor.attemptsTo(
                Enter.theValue("o").into(LoginPage.INPUT_CITY)
        );
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        actor.attemptsTo(
            Hit.the(Keys.ENTER).into((LoginPage.INPUT_CITY)),
            Click.on(LoginPage.ZOOM_BUTTON),
            Click.on(LoginPage.ZOOM_BUTTON),
            Click.on(LoginPage.ZOOM_BUTTON),
            Click.on(LoginPage.HOTSPOT_MARK),
            Click.on(LoginPage.HOTSPOT_BUTTON)
        );
    }
}
