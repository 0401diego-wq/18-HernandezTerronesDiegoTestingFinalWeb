package page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

@DefaultUrl("https://www.saucedemo.com")
public class SauceFinalPage extends PageObject {

    @FindBy(id = "user-name")
    public WebElementFacade txtUsuario;

    @FindBy(id = "password")
    public WebElementFacade txtPassword;

    @FindBy(id = "login-button")
    public WebElementFacade btnLogin;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElementFacade lblError;

    @FindBy(className = "title")
    public WebElementFacade lblTitulo;
}