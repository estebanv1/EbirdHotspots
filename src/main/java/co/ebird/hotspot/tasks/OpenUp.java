package co.ebird.hotspot.tasks;

import co.ebird.hotspot.userinterfaces.EbirdPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Browser;
import net.serenitybdd.screenplay.actions.Open;

public class OpenUp implements Task {

    private EbirdPage ebirdPage;

    public static OpenUp thePage() {
        return Tasks.instrumented(OpenUp.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        ebirdPage.setDefaultBaseUrl("https://www.ebird.org");
        actor.attemptsTo(
                Open.browserOn(ebirdPage),
                Browser.maximize()
        );
    }
}
