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
import org.openqa.selenium.TimeoutException;

import java.time.Duration;
import java.util.Arrays;

import static co.ebird.hotspot.userinterfaces.BirdPage.SCROLL1;
import static co.ebird.hotspot.userinterfaces.BirdPage.SCROLL2;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class GetBird implements Interaction {

    public static GetBird fromTheHotspot() {
        return Tasks.instrumented(GetBird.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int attemps = 0;
        Arrays.fill(Constants.weeksFrequency, null);
        /*for (String s : weeksFrequency) {
            System.out.print(s);
            System.out.print(" | ");
        }
        System.out.println(" ");
        System.out.println(weeksFrequency.length);*/
        while ((Constants.strName == null || Constants.strName.trim().isEmpty())
                || (Constants.strObservations == null || Constants.strObservations.trim().isEmpty())
                || (Constants.strPhotos == null || Constants.strPhotos.trim().isEmpty())
                || (Constants.strSounds == null) || Constants.strSounds.trim().isEmpty()
        || Arrays.asList(Constants.weeksFrequency).contains(null) || Arrays.asList(Constants.weeksFrequency).contains("")) {
            if (attemps > 15) {
                actor.attemptsTo(Browser.refreshPage());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                actor.attemptsTo(
                        Scroll.to(SCROLL1.waitingForNoMoreThan(Duration.ofSeconds(40))),
                        Scroll.to(SCROLL2.waitingForNoMoreThan(Duration.ofSeconds(40)))
                );
            } catch (TimeoutException e) {
                System.out.println("Error en scroll: " + e);
            }
            if (Constants.strName == null || Constants.strName.trim().isEmpty()){
            Constants.strName = actor.asksFor(
                    Text.of(BirdPage.NAME).asString());}
            if (Constants.strObservations == null || Constants.strObservations.trim().isEmpty()){
            Constants.strObservations = actor.asksFor(
                    Text.of(BirdPage.OBSERVATIONS).asString());}
            if (Constants.strPhotos == null || Constants.strPhotos.trim().isEmpty()){
            Constants.strPhotos = actor.asksFor(
                    Text.of(BirdPage.PHOTOS.waitingForNoMoreThan(Duration.ofSeconds(15))).asString());}
            if (Constants.strSounds == null || Constants.strSounds.trim().isEmpty()){
            Constants.strSounds = actor.asksFor(
                    Text.of(BirdPage.SOUNDS).asString());}
            if (Arrays.asList(Constants.weeksFrequency).contains(null) || Arrays.asList(Constants.weeksFrequency).contains("")) {
                for (int i = 0; i < 48; i = i + 1) {
                    //System.out.println(i);
                    String weekFrequency = Constants.weeksFrequency[i];
                    if (weekFrequency == null || weekFrequency.trim().isEmpty()) {
                        weekFrequency = actor.asksFor(
                                Text.of("section[class=\"SpeciesData-cell SpeciesData-cell-freq\"] > div > div[class=\"Panel Panel--white u-inset-md\"] > div > table > tbody > tr >td:nth-child(" + (i + 1) + ") > span span").asString());
                        //System.out.println("section[class=\"SpeciesData-cell SpeciesData-cell-freq\"] > div > div[class=\"Panel Panel--white u-inset-md\"] > div > table > tbody > tr >td:nth-child(" + (i + 1) + ") > span span");
                        //System.out.println(weekFrequency);
                        //System.out.println("p");
                        if (weekFrequency.startsWith("Frecuencia")) {
                            //System.out.println(weekFrequency.split(": ")[1].replace("%", ""));
                            Constants.weeksFrequency[i] = weekFrequency.split(": ")[1].replace("%", "");
                        } else if (weekFrequency.equals("Datos insuficientes")) {
                            Constants.weeksFrequency[i] = "N/A";
                        } else {
                            System.out.println("Valor de frecuencia no identificado: " + weekFrequency);
                            Constants.weeksFrequency[i] = weekFrequency;
                        }
                    }
                    /*for (int j = 0; j < 48; j = j + 1) {
                        System.out.print(weeksFrequency[j]);
                        System.out.print(" | ");
                    }
                    System.out.println(" ");*/
                }
            }
            attemps = attemps + 1;
        }
        Constants.strObservations = Constants.strObservations.replace(".","");
        /*System.out.print((Constants.strName + "                                          ").substring(0,35));
        System.out.print(" | ");
        System.out.print((Constants.strObservations + "        ").substring(0,5));
        System.out.print(" | ");
        System.out.println((Constants.strPhotos + "        ").substring(0,4));*/
    }
}
