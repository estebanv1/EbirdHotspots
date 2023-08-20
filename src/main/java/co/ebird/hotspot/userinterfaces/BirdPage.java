package co.ebird.hotspot.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class BirdPage extends PageObject {

    public static final Target NAME = Target.the("Scientific name of the bird")
            .locatedBy("span[class*=\"Heading-sub--sci\"]");
    public static final Target OBSERVATIONS = Target.the("Number of observations at the hotspot")
            .locatedBy("section[class$=\"SpeciesData-cell--stats\"]  table > thead + tbody tr:nth-child(2) td:nth-child(2) span");
    public static final Target PHOTOS = Target.the("Number of photos at the hotspot")
            .locatedBy("section[class$=\"SpeciesData-cell--stats\"]  table > thead + tbody tr:nth-child(2) td:nth-child(3) span a");
    public static final Target SOUNDS = Target.the("Number of sounds at the hotspot")
            .locatedBy("section[class$=\"SpeciesData-cell--stats\"]  table > thead + tbody tr:nth-child(2) td:nth-child(4) span a");
}
