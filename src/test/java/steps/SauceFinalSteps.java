package steps;

import page.SauceFinalPage;
import net.serenitybdd.annotations.Step;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select; // Importación necesaria para el menú de ordenamiento
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

    @Step("Eliminar el producto del carrito")
    public void eliminarProductoSeleccionado() {
        // Localiza el botón de Remove para el producto agregado (ej. backpack)
        saucePage.find(By.id("remove-sauce-labs-backpack")).click();
    }

    @Step("Ordenar productos por: {0}")
    public void ordenarProductosPor(String criterio) {
        // Usa la clase Select para interactuar con el combo box de la página
        new Select(saucePage.find(By.className("product_sort_container"))).selectByVisibleText(criterio);
    }

    @Step("Validar mensaje de error o alerta")
    public void validarMensajeError(String mensajeEsperado) {
        String mensajeActual = saucePage.lblError.getText();
        assertThat(mensajeActual, containsString(mensajeEsperado));
    }

    @Step("Validar mensaje de éxito")
    public void validarMensajeExito(String mensajeEsperado) {
        String mensajeActual = saucePage.find(By.className("complete-header")).getText();
        assertThat(mensajeActual, containsString(mensajeEsperado));
    }

    @Step("Verificar que el contador del carrito sea {0}")
    public void verificarCantidadCarrito(String cantidadEsperada) {
        String cantidadActual = "0";
        // Si el carrito está vacío, el badge desaparece. Si no, tomamos el número.
        if (!saucePage.findAll(By.className("shopping_cart_badge")).isEmpty()) {
            cantidadActual = saucePage.find(By.className("shopping_cart_badge")).getText();
        }
        assertThat(cantidadActual, is(cantidadEsperada));
    }

    @Step("Validar que el primer producto de la lista sea {0}")
    public void validarNombrePrimerProducto(String nombreEsperado) {
        String nombreActual = saucePage.find(By.className("inventory_item_name")).getText();
        assertThat(nombreActual, is(nombreEsperado));
    }
}