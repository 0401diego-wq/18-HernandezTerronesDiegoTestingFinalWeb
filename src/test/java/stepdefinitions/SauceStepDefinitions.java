package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.annotations.Steps;
import steps.SauceSteps;

public class SauceStepDefinitions {

    @Steps
    SauceSteps sauceSteps;

    @Dado("que el usuario abre la página de SauceDemo")
    public void abrirSauceDemo() {
        sauceSteps.abrirSauceDemo();
    }

    @Cuando("escribo el usuario {string}")
    public void escriboElUsuario(String username) {
        sauceSteps.escriboElUsuario(username);
    }

    @Y("escribo la contraseña {string}")
    public void escriboLaContraseña(String passwordT) {
        sauceSteps.escriboLaContraseña(passwordT);
    }

    @Y("hago clic en el boton Login")
    public void hagoClicEnElBotonLogin() {
        sauceSteps.clickLogin();
    }

    @Entonces("el logeo fue exitoso en la pagina de SauceDemo con el titulo {string}")
    public void elLogeoFueExitosoEnLaPaginaDeSauceDemoConElTitulo(String tituloPagina) {
        sauceSteps.validarLogeoExitoso(tituloPagina);
    }
}
