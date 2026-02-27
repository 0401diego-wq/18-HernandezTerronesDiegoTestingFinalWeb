package steps;

import page.SauceFinalPage;
import net.serenitybdd.annotations.Step;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class SauceFinalSteps {

    SauceFinalPage saucePage;
    EnvironmentVariables environmentVariables;

    @Step("Cargar la página de SauceDemo")
    public void cargarPagina() {
        saucePage.open();
    }

    @Step("Login con usuario de tipo {0}")
    public void loginConUsuario(String tipo) {
        String user = environmentVariables.getProperty("credentials." + tipo + ".user");
        String pass = environmentVariables.getProperty("credentials." + tipo + ".pass");
        saucePage.txtUsuario.type(user);
        saucePage.txtPassword.type(pass);
        saucePage.btnLogin.click();
    }

    @Step("Seleccionar producto {0}")
    public void agregarProductoAlCarrito(String nombreProducto) {
        saucePage.find(By.xpath("//div[text()='" + nombreProducto + "']/ancestor::div[@class='inventory_item']//button")).click();
    }

    @Step("Completar el proceso de checkout")
    public void terminarCompraConDatos() {
        saucePage.find(By.id("shopping_cart_container")).click();
        saucePage.find(By.id("checkout")).click();
        saucePage.find(By.id("first-name")).type("Diego");
        saucePage.find(By.id("last-name")).type("Hernandez");
        saucePage.find(By.id("postal-code")).type("12345");
        saucePage.find(By.id("continue")).click();
        saucePage.find(By.id("finish")).click();
    }

    @Step("Intentar checkout sin Zip Code")
    public void checkoutIncompleto() {
        saucePage.find(By.id("shopping_cart_container")).click();
        saucePage.find(By.id("checkout")).click();
        saucePage.find(By.id("first-name")).type("Diego");
        saucePage.find(By.id("last-name")).type("Hernandez");
        saucePage.find(By.id("continue")).click();
    }

    @Step("Eliminar producto del carrito")
    public void eliminarProductoSeleccionado() {
        saucePage.find(By.id("remove-sauce-labs-backpack")).click();
    }

    @Step("Ordenar productos por: {0}")
    public void ordenarProductosPor(String criterio) {
        new Select(saucePage.find(By.className("product_sort_container"))).selectByVisibleText(criterio);
    }

    @Step("Validar mensaje de error o alerta")
    public void validarMensajeError(String mensajeEsperado) {
        assertThat(saucePage.lblError.getText(), containsString(mensajeEsperado));
    }

    @Step("Validar mensaje de éxito")
    public void validarMensajeExito(String mensajeEsperado) {
        assertThat(saucePage.find(By.className("complete-header")).getText(), containsString(mensajeEsperado));
    }

    @Step("Verificar cantidad carrito")
    public void verificarCantidadCarrito(String cantidad) {
        String actual = "0";
        if (!saucePage.findAll(By.className("shopping_cart_badge")).isEmpty()) {
            actual = saucePage.find(By.className("shopping_cart_badge")).getText();
        }
        assertThat(actual, is(cantidad));
    }

    @Step("Validar nombre primer producto")
    public void validarNombrePrimerProducto(String nombre) {
        assertThat(saucePage.find(By.className("inventory_item_name")).getText(), is(nombre));
    }

    // --- MÉTODOS ADICIONALES PARA LLEGAR A LOS 10 ---

    @Step("Hacer scroll hasta el final")
    public void hacerScrollAlFooter() {
        saucePage.evaluateJavascript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Step("Verificar iconos sociales")
    public void verificarIconosSociales() {
        assertThat(saucePage.find(By.className("social_twitter")).isDisplayed(), is(true));
    }

    @Step("Abrir menú lateral")
    public void abrirMenu() {
        saucePage.find(By.id("react-burger-menu-btn")).waitUntilClickable().click();
    }

    @Step("Clic en opción del menú: {0}")
    public void clickOpcionMenu(String opcion) {
        if(opcion.equalsIgnoreCase("Logout")) {
            saucePage.find(By.id("logout_sidebar_link")).waitUntilClickable().click();
        }
    }

    @Step("Verificar redirección al login")
    public void verificarPaginaLogin() {
        assertThat(saucePage.btnLogin.isDisplayed(), is(true));
    }

    @Step("Clic en nombre del producto")
    public void clicNombreProducto(String nombre) {
        saucePage.find(By.xpath("//div[text()='" + nombre + "']")).click();
    }

    @Step("Verificar descripción del producto")
    public void verificarDescripcionProducto() {
        assertThat(saucePage.find(By.className("inventory_details_desc")).isDisplayed(), is(true));
    }

    @Step("Verificar texto del footer")
    public void verificarTextoFooter(String texto) {
        assertThat(saucePage.find(By.className("footer_copy")).getText(), containsString(texto));
    }
}