package co.ebird.hotspot.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class HotspotPage extends PageObject {

    public static final Target MAX_NUMBER = Target.the("The number of species")
            .locatedBy("#place-species-observed-results section:nth-last-child(1) div[class^=\"Observation-numberObserved\"] span:nth-child(2)");
    public static final Target DATE = Target.the("The number of species")
            .locatedBy("#place-species-observed-results section:nth-child(1) div[class^=\"Observation-meta\"] svg + a span");
}
