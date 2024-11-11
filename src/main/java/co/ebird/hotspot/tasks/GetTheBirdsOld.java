package co.ebird.hotspot.tasks;

import co.ebird.hotspot.interactions.GetBirdOld;
import co.ebird.hotspot.utils.BirdDataUtil;
import co.ebird.hotspot.utils.Constants;
import co.ebird.hotspot.utils.TransformDate;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Browser;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static co.ebird.hotspot.userinterfaces.HotspotPage.BIRDS_LIST_BUTTON;

public class GetTheBirdsOld implements Task{

    String strNumber;
    Integer maxNumber;
    private String strName;
    private String strObservations;
    private String strPhotos;
    private String strSounds;
    // String strDate;
    private List<List<String>> birdsData = new ArrayList<>(700);

    public static GetTheBirdsOld fromTheHotspot() {
        return Tasks.instrumented(GetTheBirdsOld.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("a");
        String listsNumber = actor.asksFor(
                Text.of(".PageHeading-content .PlaceStats-stats a:nth-child(2) span .StatsIcon-stat-count").asString()).trim();
        System.out.println("Número de listas: " + listsNumber);
        actor.attemptsTo(Click.on(BIRDS_LIST_BUTTON));
        List<WebElementFacade> birdWebElements = Target.the("bird").located(By.cssSelector(".BirdList-list section[aria-labelledby='nativeNaturalized'] .BirdList-list-list li")).resolveAllFor(actor);
        int numm = birdWebElements.size();
        System.out.println("Tamaño1: " + numm);
        String strNumber = null;
        try {
            List<WebElementFacade> numberWebElements = Target.the("bird").located(By.cssSelector("li[class='BirdList-list-list-item countable']")).resolveAllFor(actor);
            strNumber = String.valueOf(numberWebElements.size());
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        if (strNumber != null && !strNumber.trim().isEmpty()) {
            System.out.println("Tamaño2: " + strNumber);
            maxNumber = Math.min(Integer.parseInt(strNumber.trim()), numm);
        } else {
            maxNumber = numm;
        }
        System.out.println("Tamaño3: " + maxNumber);
        outerloop:
        for (int i = 0; i <= maxNumber - 1; i = i + 1) {
            Constants.strName = null;
            Constants.strObservations = null;
            Constants.strPhotos = null;
            Constants.strSounds = null;
            String strDate = null;

            while ((strDate == null || strDate.trim().isEmpty())) {
                try {
                    strDate = TransformDate.toFormat(actor.asksFor(
                            Text.of(".BirdList-list section[aria-labelledby='nativeNaturalized'] .BirdList-list-list li:nth-child(" + (i + 1) + ") .Obs div[class='Obs-date u-meta'] a time").asString()));
                } catch (Exception e) {
                    System.out.println("No hay fecha para el número " + (i + 1) + ", " + e);
                    break outerloop;
                }
                }
                actor.attemptsTo(
                    Click.on(".BirdList-list section[aria-labelledby='nativeNaturalized'] .BirdList-list-list li:nth-child(" + (i + 1) + ") .Obs .Obs-species a"),
                    GetBirdOld.fromTheHotspot(),
                    Browser.navigateBack()
            );
            List<String> birdData = new ArrayList<>(5);
            birdData.add(0, Constants.strName);
            //System.out.println(Constants.strName);
            birdData.add(1, Constants.strObservations);
            birdData.add(2, Constants.strPhotos);
            birdData.add(3, Constants.strSounds);
            birdData.add(4, strDate);
            /*birdData.addAll(Arrays.asList(Constants.weeksFrequency));*/
            birdsData.add(birdData);
        };

        System.out.print("Especie");
        System.out.print(",");

        System.out.print("Observaciones");
        System.out.print(",");

        /*System.out.print("Porcentaje de presencia");
        System.out.print(",");*/

        System.out.print("Fotos");
        System.out.print(",");

        /*System.out.print("Porcentaje de fotos");
        System.out.print(",");*/

        System.out.print("Audios");
        System.out.print(",");

        /*System.out.print("Porcentaje de audios");
        System.out.print(",");*/

        System.out.print("Último registro");
        //System.out.print(",");

        System.out.print("\n");

        //ExportUtil.printFrequencyHeaders();
        for (int i = 0; i < birdsData.size(); i = i + 1) {
            System.out.print(birdsData.get(i).get(0));
            System.out.print(",");

            System.out.print(birdsData.get(i).get(1));
            System.out.print(",");

            /*System.out.print(Math.round((Float.parseFloat(birdsData.get(i).get(1)) / Float.parseFloat(listsNumber)) * 1000.0) / 10.0);
            System.out.print(",");*/

            System.out.print(birdsData.get(i).get(2));
            System.out.print(",");

            /*System.out.print(Math.round((Float.parseFloat(birdsData.get(i).get(2)) / (float) photosNumber) * 1000.0) / 10.0);
            System.out.print(",");*/

            System.out.print(birdsData.get(i).get(3));
            System.out.print(",");

            /*System.out.print(Math.round((Float.parseFloat(birdsData.get(i).get(3)) / (float) audiosNumber) * 1000.0) / 10.0);
            System.out.print(",");*/

            System.out.print(birdsData.get(i).get(4));
            System.out.println();

            //System.out.print(",");
            //ExportUtil.printFrequencies(birdsData, i);

        }
        System.out.println("Número de listas: " + listsNumber);
        int photosNumber = BirdDataUtil.sumColumn(birdsData, 2);
        int audiosNumber = BirdDataUtil.sumColumn(birdsData, 3);
        System.out.println("Número de fotos: " + photosNumber);
        System.out.println("Número de audios: " + audiosNumber);
    }
}
