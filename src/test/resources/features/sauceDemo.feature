# language: es
Característica: Como QE quiero automatizar la página
  SauceDemo para poder entender y hacer
  una automatizacion web

  @SAUCE-1 @happypath
  Escenario: Verificar el logeo correcto en la pagina SauceDemo - OK
    Dado que el usuario abre la página de SauceDemo
    Cuando escribo el usuario "standard_user"
    Y escribo la contraseña "secret_sauce"
    Y hago clic en el boton Login
    Entonces el logeo fue exitoso en la pagina de SauceDemo con el titulo "Swag Labs"