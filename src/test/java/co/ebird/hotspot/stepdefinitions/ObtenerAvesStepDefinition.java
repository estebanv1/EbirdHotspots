package co.ebird.hotspot.stepdefinitions;

import co.ebird.hotspot.models.LoginData;
import co.ebird.hotspot.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.ebird.hotspot.utils.Constants.PASSWORD;
import static co.ebird.hotspot.utils.Constants.USERNAME;

public class ObtenerAvesStepDefinition {

    @Before
    public void setStage () {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que quiero obtener la abundancia de las aves")
    public void queQuieroObtenerLaAbundanciaDeLasAves() {
        OnStage.theActorCalled("ebird user").wasAbleTo(OpenUp.thePage());
    }

    @Cuando("^ingreso con usuario y contraseña al hotspot con url (.*)$")
    public void ingresoAlHotspot(String hotspotUrl) {
        LoginData loginData = new LoginData(USERNAME, PASSWORD);
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginToHotspot.byUrl(hotspotUrl, loginData)
        );
    }

    @Cuando("^ingreso al hotspot (.*) cercano a (.*)$")
    public void ingresoAlHotspotCercanoA(String hotspot, String place) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GoToHotspot.byName(place, hotspot)
        );
    }

    @Cuando("^ingreso con usuario y contraseña al hotspot (.*) cercano a (.*)$")
    public void ingresoAlHotspotConUsuarioYContrasena(String hotspot, String place) {
        LoginData loginData = new LoginData(USERNAME, PASSWORD);
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.onThePage(loginData, place, hotspot)
        );
    }

    @Entonces("extraigo la información de las aves")
    public void extraigoLaInformacionDeLasAves() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GetTheBirds.fromTheHotspot()
        );
    }

}
