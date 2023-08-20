package co.ebird.hotspot.stepdefinitions;

import co.ebird.hotspot.models.LoginData;
import co.ebird.hotspot.tasks.GetTheBirds;
import co.ebird.hotspot.tasks.Login;
import co.ebird.hotspot.tasks.OpenUp;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;

public class ObtenerAvesStepDefinition {

    @DataTableType
    public LoginData loginDataEntry(Map<String, String> entry) {
        return new LoginData(
                entry.get("strUsername"),
                entry.get("strPassword")
        );
    }

    @Before
    public void setStage () {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que quiero obtener la abundancia de las aves")
    public void queQuieroObtenerLaAbundanciaDeLasAves() {
        OnStage.theActorCalled("Esteban").wasAbleTo(OpenUp.thePage());
    }
    @Cuando("ingreso al hotspot")
    public void ingresoAlHotspot(List<LoginData> loginData) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.onThePage(loginData.get(0))
        );
    }
    @Entonces("extraigo la información de las aves")
    public void extraigoLaInformaciónDeLasAves() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GetTheBirds.fromTheHotspot()
        );
    }

}
