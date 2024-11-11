package co.ebird.hotspot.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;

import static co.ebird.hotspot.exceptions.HotspotException.ASSERT_GO_TO_HOTSPOT;
import static co.ebird.hotspot.userinterfaces.LoginPage.*;

public class GoToHotspot implements Task{

    private static final Logger LOGGER = LogManager.getLogger(GoToHotspot.class);
    private final String place;
    private final String hotspot;

    public GoToHotspot(String place, String hotspot) {
        this.place = place;
        this.hotspot = hotspot;
    }

    public static GoToHotspot byName(String city, String hotspot) {
        return Tasks.instrumented(GoToHotspot.class, city, hotspot);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
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
            Click.on(String.format(HOTSPOT_MARK.getCssOrXPathSelector(), hotspot)),
            Click.on(HOTSPOT_BUTTON)
        );
    }
}
