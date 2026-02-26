package steps;

import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import page.SaucePage;

public class SauceSteps {

    SaucePage saucePage;

    @Step("Abrir la página de SauceDemo")
    public void abrirSauceDemo() {
        saucePage.open();
    }

    public void escriboElUsuario(String username) {
        saucePage.enterUsername(username);
    }

    public void escriboLaContraseña(String passwordT) {
        saucePage.enterPassword(passwordT);
    }

    public void clickLogin() {
        saucePage.clickLogin();
    }

    public void validarLogeoExitoso(String tituloPagina) {
        saucePage.validarLogoPresente(tituloPagina);
    }
}
