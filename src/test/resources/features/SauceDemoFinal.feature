# language: es
@CasosFinales
Característica: Automatización de la tarea final SauceDemo

  Antecedentes:
    Dado que el usuario abre la página de SauceDemo

  @CasoTarea-1 @HappyPath
  Escenario: Realizar compra completa de forma exitosa
    Cuando ingresa las credenciales de un usuario "standard"
    Y selecciona el producto "Sauce Labs Backpack"
    Y completa el proceso de checkout
    Entonces debería ver el mensaje de éxito "Thank you for your order!"

  @CasoTarea-2 @UnhappyPath
  Escenario: Validar error con usuario bloqueado
    Cuando ingresa las credenciales de un usuario "locked"
    Entonces debería ver el mensaje de error "Epic sadface: Sorry, this user has been locked out."

  @CasoTarea-3 @UnhappyPath
  Escenario: Validar error al omitir el código postal en checkout
    Cuando ingresa las credenciales de un usuario "standard"
    Y intenta finalizar el checkout sin ingresar el Zip Code
    Entonces debería ver el mensaje de alerta "Error: Postal Code is required"

  @CasoTarea-4 @UnhappyPath
  Escenario: Validar error con credenciales incorrectas
    Cuando ingresa las credenciales de un usuario "invalid"
    Entonces debería ver el mensaje de error "Epic sadface: Username and password do not match any user in this service"

  @CasoTarea-5 @HappyPath
  Escenario: Eliminar un producto del carrito antes de la compra
    Cuando ingresa las credenciales de un usuario "standard"
    Y selecciona el producto "Sauce Labs Backpack"
    Y elimina el producto del carrito
    Entonces el contador del carrito debería mostrar "0"

  @CasoTarea-6 @HappyPath
  Escenario: Verificar que el orden de los productos sea por precio de menor a mayor
    Cuando ingresa las credenciales de un usuario "standard"
    Y ordena los productos por "Price (low to high)"
    Entonces el primer producto debería ser "Sauce Labs Onesie"
