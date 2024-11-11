package co.ebird.hotspot.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class BirdPage extends PageObject {

    public static final Target NAME = Target.the("Scientific name of the bird")
            .locatedBy("span[class*=\"Heading-sub--sci\"]");
    public static final Target OBSERVATIONS = Target.the("Number of observations at the hotspot")
            .locatedBy(".Species-regionalData-stats div table tbody tr:nth-child(2) td:nth-child(2) span");
    public static final Target PHOTOS = Target.the("Number of photos at the hotspot")
            .locatedBy(".Species-regionalData-stats div table tbody tr:nth-child(2) td:nth-child(3) a");
    public static final Target SOUNDS = Target.the("Number of sounds at the hotspot")
            .locatedBy(".Species-regionalData-stats div table tbody tr:nth-child(2) td:nth-child(4) a");
    public static final Target SCROLL1 = Target.the("scroll 1")
            .located(By.cssSelector(".Species-identification"));
    public static final Target SCROLL2 = Target.the("Scroll 2")
            .located(By.cssSelector(".Species-regionalData"));
    public static final Target WEEKFREQUENCY = Target.the("Week frequency")
            .located(By.cssSelector("section[class=\"SpeciesData-cell SpeciesData-cell-freq\"] > div > div[class=\"Panel Panel--white u-inset-md\"] > div > table > tbody > tr >td:nth-child(n) > span span"));


}
