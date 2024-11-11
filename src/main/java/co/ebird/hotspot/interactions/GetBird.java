package co.ebird.hotspot.interactions;

import co.ebird.hotspot.userinterfaces.BirdPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.actions.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;

import static co.ebird.hotspot.exceptions.HotspotException.ASSERT_REFRESH_BROWSER;
import static co.ebird.hotspot.userinterfaces.BirdPage.*;

public class GetBird implements Interaction {

    private static final Logger LOGGER = LogManager.getLogger(GetBird.class);
    public static GetBird fromTheHotspot() {
        return Tasks.instrumented(GetBird.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String observations = null;
        String photos = null;
        String audios = null;
        String name = null;
        int attempts = 0;
        while (observations == null || observations.trim().isEmpty())
        {
            if (attempts > 15) {
                actor.attemptsTo(Browser.refreshPage());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    LOGGER.info(ASSERT_REFRESH_BROWSER);
                    Thread.currentThread().interrupt();
                }
            }
            try {
                actor.attemptsTo(
                        Scroll.to(SCROLL1.waitingForNoMoreThan(Duration.ofSeconds(40))),
                        Scroll.to(SCROLL2.waitingForNoMoreThan(Duration.ofSeconds(40)))
                );
            } catch (TimeoutException e) {
                LOGGER.log(Level.INFO, "Error en scroll: {}", e.getMessage());
            }
            if (attempts > 15) {
                actor.attemptsTo(Browser.refreshPage());
                try {
                    Thread.sleep((int)((attempts - 10) * 1000));
                } catch (InterruptedException e) {
                    LOGGER.info(ASSERT_REFRESH_BROWSER);
                    Thread.currentThread().interrupt();
                }
            }
            if (name == null || name.trim().isEmpty()){
            name = actor.asksFor(
                    Text.of(NAME).asString()).trim();}
            if (observations == null || observations.trim().isEmpty()){
            observations = actor.asksFor(
                    Text.of(OBSERVATIONS).asString()).trim();}
            if (photos == null || photos.trim().isEmpty()){
            photos = actor.asksFor(
                    Text.of(BirdPage.PHOTOS.waitingForNoMoreThan(Duration.ofSeconds(15))).asString()).trim();}
            if (audios == null || audios.trim().isEmpty()){
            audios = actor.asksFor(
                    Text.of(BirdPage.SOUNDS).asString()).trim();}

            attempts = attempts + 1;
        }

        observations = observations.replace(".","");
        String birdInfo = name + "," + observations + "," + photos + "," + audios + ",";
        actor.remember("birdInfo", birdInfo);
    }
}
