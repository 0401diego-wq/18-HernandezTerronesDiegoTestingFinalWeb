package stepdefinitions;

import io.cucumber.java.es.*;
import net.serenitybdd.annotations.Steps;
import steps.SauceFinalSteps;

public class SauceFinalStepDefinitions {

    @Steps
    SauceFinalSteps diegoSteps;

    @Dado("que el usuario abre la página de SauceDemo")
    public void abrirPagina() {
        diegoSteps.cargarPagina();
    }

    @Cuando("ingresa las credenciales de un usuario {string}")
    public void ingresarCredenciales(String tipo) {
        diegoSteps.loginConUsuario(tipo);
    }

    @Y("selecciona el producto {string}")
    public void seleccionarProducto(String producto) {
        diegoSteps.agregarProductoAlCarrito(producto);
    }

    @Y("completa el proceso de checkout")
    @Y("finaliza el checkout con sus datos personales")
    public void completarCheckout() {
        diegoSteps.terminarCompraConDatos();
    }

    @Y("intenta finalizar el checkout sin ingresar el Zip Code")
    public void intentarCheckoutSinZip() {
        diegoSteps.checkoutIncompleto();
    }

    @Y("elimina el producto del carrito")
    public void eliminarProducto() {
        diegoSteps.eliminarProductoSeleccionado();
    }

    @Y("ordena los productos por {string}")
    public void ordenarPorPrecio(String criterio) {
        diegoSteps.ordenarProductosPor(criterio);
    }

    @Entonces("debería ver el mensaje de éxito {string}")
    public void validarExito(String msj) {
        diegoSteps.validarMensajeExito(msj);
    }

    @Entonces("debería ver el mensaje de error {string}")
    @Entonces("debería ver el mensaje de alerta {string}")
    public void validarMensajesError(String msj) {
        diegoSteps.validarMensajeError(msj);
    }

    @Entonces("el contador del carrito debería mostrar {string}")
    public void validarContadorCarrito(String cantidad) {
        diegoSteps.verificarCantidadCarrito(cantidad);
    }

    @Entonces("el primer producto debería ser {string}")
    public void validarPrimerProducto(String nombreProducto) {
        diegoSteps.validarNombrePrimerProducto(nombreProducto);
    }
}