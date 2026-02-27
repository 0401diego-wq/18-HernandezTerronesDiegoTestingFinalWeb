# 18-HernándezTerronesDiegoTestingFinalWeb

## Descripción del Proyecto
Este proyecto es la entrega final de automatización Web para **SauceDemo**. Se utiliza un framework basado en **Serenity BDD**, **Cucumber** y **Selenium WebDriver** siguiendo el patrón de diseño **Page Object Model (POM)**.

## Resumen de Pruebas
Se han automatizado **10 escenarios de prueba** que cubren flujos críticos:
1. **Compra Exitosa**: Flujo completo desde el login hasta el agradecimiento de orden.
2. **Usuario Bloqueado**: Validación de mensaje de error para `locked_out_user`.
3. **Checkout Incompleto**: Validación de error cuando falta el Código Postal.
4. **Credenciales Inválidas**: Validación de error al ingresar datos incorrectos.
5. **Remover Producto**: Validación del contador del carrito al eliminar items.
6. **Ordenamiento**: Verificación de filtro por precio (Menor a Mayor).
7. **Redes Sociales**: Presencia de iconos en el footer.
8. **Logout**: Cierre de sesión exitoso desde el menú lateral.
9. **Detalle de Producto**: Acceso a la descripción individual de items.
10. **Copyright**: Verificación del texto legal en el footer.

## Requisitos
* **Java**: Versión 17.
* **Maven**: Gestor de dependencias.
* **Navegador**: Google Chrome.

## Ejecución
Para correr las pruebas y generar el reporte visual, usa el siguiente comando en la terminal:
```bash
mvn clean verify -Dheadless.mode=false
