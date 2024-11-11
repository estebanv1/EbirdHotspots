package co.ebird.hotspot.tasks;

import co.ebird.hotspot.interactions.GetBird;
import co.ebird.hotspot.utils.*;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actions.Browser;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static co.ebird.hotspot.userinterfaces.HotspotPage.BIRDS_LIST_BUTTON;

public class GetTheBirds implements Task{

    private static final Logger LOGGER = LogManager.getLogger(GetTheBirds.class);

    public static GetTheBirds fromTheHotspot() {
        return Tasks.instrumented(GetTheBirds.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        CSVUtility.deleteCsvFile();

        LOGGER.info("Inicia la extracción de información");

        String listsNumber = actor.asksFor(
                Text.of(".PageHeading-content .PlaceStats-stats a:nth-child(2) span .StatsIcon-stat-count")
                        .asString()).trim();
        LOGGER.log(Level.INFO, "Número de listas: {}", listsNumber);

        actor.attemptsTo(Click.on(BIRDS_LIST_BUTTON));

        List<WebElementFacade> birdWebElements = Target.the("bird").located(
                By.cssSelector(".BirdList-list section[aria-labelledby='nativeNaturalized'] .BirdList-list-list li"))
                .resolveAllFor(actor);
        int speciesNumber1 = birdWebElements.size();
        String speciesNumber2 = null;
        try {
            List<WebElementFacade> numberWebElements = Target.the("bird").located(
                    By.cssSelector("li[class='BirdList-list-list-item countable']")).resolveAllFor(actor);
            speciesNumber2 = String.valueOf(numberWebElements.size());
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, "Error obteniendo el número de especies: {}", e.getMessage());
        }
        int speciesNumber;
        if (speciesNumber2 != null && !speciesNumber2.trim().isEmpty()) {
            speciesNumber = Math.min(Integer.parseInt(speciesNumber2.trim()), speciesNumber1);
        } else {
            speciesNumber = speciesNumber1;
        }
        LOGGER.log(Level.INFO, "Número de especies identificado: {}", speciesNumber);

        String[] birdDataHeaders = new String[]{"Especie", "Observaciones", "Fotos", "Audios",
                "Último registro"};
        CSVUtility.appendRowToCsv(birdDataHeaders);

        outerloop:
        for (int i = 0; i <= speciesNumber - 1; i = i + 1) {
            String date = null;

            while ((date == null || date.trim().isEmpty())) {
                try {
                    date = TransformDate.toFormat(actor.asksFor(
                            Text.of(".BirdList-list section[aria-labelledby='nativeNaturalized'] .BirdList-list-list li:nth-child(" + (i + 1) + ") .Obs div[class='Obs-date u-meta'] a time").asString()));
                } catch (Exception e) {
                    LOGGER.log(Level.ERROR, "No hay fecha para el número {}, {}", (i + 1), e);
                    break outerloop;
                }
            }

            actor.attemptsTo(
                    Click.on(".BirdList-list section[aria-labelledby='nativeNaturalized'] .BirdList-list-list li:nth-child(" + (i + 1) + ") .Obs .Obs-species a"),
                    GetBird.fromTheHotspot(),
                    Browser.navigateBack()
            );

            String birdData = actor.recall("birdInfo") + date;

            String[] birdDataList = birdData.split(",");
            CSVUtility.appendRowToCsv(birdDataList);

            LOGGER.log(Level.INFO, "Ave agregada: # {} - {}", i + 1, birdData);
        }

        CSVUtility.appendRowToCsv(new String[]{"Número de listas: ", listsNumber});

        LOGGER.log(Level.INFO, "Número de listas: {}", listsNumber);
    }
}