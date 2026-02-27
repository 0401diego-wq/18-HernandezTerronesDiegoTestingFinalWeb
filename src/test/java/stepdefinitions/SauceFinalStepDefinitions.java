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

    @Cuando("el usuario hace scroll hasta el final de la página")
    public void hacerScroll() {
        diegoSteps.hacerScrollAlFooter();
    }

    @Cuando("el usuario abre el menú lateral")
    public void abrirMenu() {
        diegoSteps.abrirMenu();
    }

    @Y("hace clic en la opción {string}")
    public void clicarOpcion(String opcion) {
        diegoSteps.clickOpcionMenu(opcion);
    }

    @Y("hace clic en el nombre del producto {string}")
    public void clicProducto(String nombre) {
        diegoSteps.clicNombreProducto(nombre);
    }

    // --- VALIDACIONES ---

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

    @Entonces("debería ver los iconos de redes sociales")
    public void validarIconos() {
        diegoSteps.verificarIconosSociales();
    }

    @Entonces("debería ser redirigido a la página de login")
    public void validarPaginaLogin() {
        diegoSteps.verificarPaginaLogin();
    }

    @Entonces("debería ver la descripción del producto")
    public void validarDescripcion() {
        diegoSteps.verificarDescripcionProducto();
    }

    @Entonces("el footer debería decir {string}")
    public void validarFooter(String texto) {
        diegoSteps.verificarTextoFooter(texto);
    }
}