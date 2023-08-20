package co.ebird.hotspot.interactions;

import co.ebird.hotspot.models.BirdData;
import co.ebird.hotspot.userinterfaces.BirdPage;
import co.ebird.hotspot.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import co.ebird.hotspot.utils.Constants;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class GetBird implements Interaction {

    public static GetBird fromTheHotspot() {
        return Tasks.instrumented(GetBird.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String path = "//span[contains(text(), 'Bosques de Quebrada Sinifaná')]";
        actor.attemptsTo(
                Scroll.to(By.cssSelector("div[data-activitybadge-ebirdapikey]")),
                Scroll.to(By.cssSelector("#stats-heading"))
        );
        Constants.strName = actor.asksFor(
                Text.of(BirdPage.NAME).asString());
        actor.attemptsTo(
                Click.on(BirdPage.OBSERVATIONS).afterWaitingUntilPresent()
        );
        WaitUntil.the(BirdPage.OBSERVATIONS, isPresent());
        Constants.strObservations = actor.asksFor(
                Text.of(BirdPage.OBSERVATIONS).asString());
        WaitUntil.the(BirdPage.PHOTOS, isPresent());
        Constants.strPhotos = actor.asksFor(
                Text.of(BirdPage.PHOTOS).asString());
        WaitUntil.the(BirdPage.SOUNDS, isPresent());
        Constants.strSounds = actor.asksFor(
                Text.of(BirdPage.SOUNDS).asString());
    }
}
