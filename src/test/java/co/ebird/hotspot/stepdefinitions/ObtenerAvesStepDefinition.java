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



    @Before
    public void setStage () {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que quiero obtener la abundancia de las aves")
    public void queQuieroObtenerLaAbundanciaDeLasAves() {
        System.out.println("ACÁ1");
        OnStage.theActorCalled("Esteban").wasAbleTo(OpenUp.thePage());
        System.out.println("ACÁ");
    }
    @Cuando("^ingreso con el usuario (.*) y la contrasena (.*) al hotspot (.*) de la ciudad (.*)$")
    public void ingresoAlHotspot(String strUsername, String strPassword, String hotspot, String city) {
        LoginData loginData= new LoginData(strUsername, strPassword);
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.onThePage(loginData, city, hotspot)
        );
    }
    @Entonces("extraigo la informacion de las aves")
    public void extraigoLaInformacionDeLasAves() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GetTheBirds.fromTheHotspot()
        );
    }

}
