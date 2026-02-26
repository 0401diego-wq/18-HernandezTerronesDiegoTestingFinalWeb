package page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;

@DefaultUrl("https://duckduckgo.com")
public class GooglePage extends PageObject {

    @FindBy(id = "searchbox_input")
    WebElementFacade searchBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElementFacade searchButton;

    public void enterSearchTerm(String term) {
        searchBox.type(term);
        searchButton.click();
    }
}
