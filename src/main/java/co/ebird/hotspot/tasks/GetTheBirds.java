package co.ebird.hotspot.tasks;

import co.ebird.hotspot.interactions.GetBird;
import co.ebird.hotspot.models.BirdData;
import co.ebird.hotspot.models.LoginData;
import co.ebird.hotspot.userinterfaces.BirdPage;
import co.ebird.hotspot.userinterfaces.HotspotPage;
import co.ebird.hotspot.userinterfaces.LoginPage;
import co.ebird.hotspot.utils.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actions.Browser;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class GetTheBirds implements Task{

    String strNumber;
    Integer maxNumber;
    private String strName;
    private String strObservations;
    private String strPhotos;
    private String strSounds;
    private String strDate;
    private List<List<String>> birdsData = new ArrayList<>(500);

    public static GetTheBirds fromTheHotspot() {
        return Tasks.instrumented(GetTheBirds.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        strNumber = actor.asksFor(
                Text.of(HotspotPage.MAX_NUMBER).asString());
        strDate = actor.asksFor(
                Text.of(HotspotPage.DATE).asString());
        strNumber = strNumber.replace(".","");
        maxNumber = Integer.parseInt(strNumber);
        for (int i = 0; i <= 4 + 1; i = i + 1) {
            actor.attemptsTo(
                    Click.on("#place-species-observed-results section:nth-child(" + (i + 1) + ") a[data-species-code]"),
                    GetBird.fromTheHotspot(),
                    Browser.navigateBack()
            );
            List<String> birdData = new ArrayList<>(5);
            birdData.add(0,Constants.strName);
            birdData.add(1,Constants.strObservations);
            birdData.add(2,Constants.strPhotos);
            birdData.add(3,Constants.strSounds);
            birdsData.add(i,birdData);
        };
        System.out.println("Acá");
        for (int i = 0; i <= 4; i = i + 1) {
            System.out.print(birdsData.get(i).get(0));
            System.out.print(",");
            System.out.print(birdsData.get(i).get(1));
            System.out.print(",");
            System.out.print(birdsData.get(i).get(2));
            System.out.print(",");
            System.out.println(birdsData.get(i).get(3));
        }
    }
}
