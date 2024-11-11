package co.ebird.hotspot.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class HotspotPage extends PageObject {

    public static final Target BIRDS_LIST_BUTTON = Target.the("button to go to the birds list")
            .locatedBy("//a[contains(text(),'Lista de aves')]");
    public static final Target MAX_NUMBER = Target.the("The number of species")
            .locatedBy(".BirdList-controls .BirdList-controls-stats a:nth-child(1)  .StatsIcon-stat-count");
    public static final Target DATE = Target.the("The number of species")
            .locatedBy("#place-species-observed-results section:nth-child(1) div[class^=\"Observation-meta\"] svg + a span");
}
