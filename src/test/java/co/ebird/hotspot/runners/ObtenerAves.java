package co.ebird.hotspot.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import net.serenitybdd.screenplay.targets.Target;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/obtener_aves.feature",
        glue = "co.ebird.hotspot.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "")

public class ObtenerAves {

}