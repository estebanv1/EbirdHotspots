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

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class GetBird implements Interaction {

    public static GetBird fromTheHotspot() {
        return Tasks.instrumented(GetBird.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(By.cssSelector("div[data-activitybadge-ebirdapikey]")),
                Scroll.to(By.cssSelector("#stats-heading"))
        );
        while ((Constants.strName == null || Constants.strName.trim().isEmpty())
                || (Constants.strObservations == null || Constants.strObservations.trim().isEmpty())
                || (Constants.strPhotos == null || Constants.strPhotos.trim().isEmpty())
                || (Constants.strSounds == null) || Constants.strSounds.trim().isEmpty()) {
            if (Constants.strName == null || Constants.strName.trim().isEmpty()){
            Constants.strName = actor.asksFor(
                    Text.of(BirdPage.NAME).asString());}
            if (Constants.strObservations == null || Constants.strObservations.trim().isEmpty()){
            Constants.strObservations = actor.asksFor(
                    Text.of(BirdPage.OBSERVATIONS).asString());}
            if (Constants.strPhotos == null || Constants.strPhotos.trim().isEmpty()){
            Constants.strPhotos = actor.asksFor(
                    Text.of(BirdPage.PHOTOS).asString());}
            if (Constants.strSounds == null || Constants.strSounds.trim().isEmpty()){
            Constants.strSounds = actor.asksFor(
                    Text.of(BirdPage.SOUNDS).asString());}
        }
    }
}
