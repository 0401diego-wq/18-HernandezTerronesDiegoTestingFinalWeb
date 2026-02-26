package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/SauceDemoFinal.feature",
        glue = "stepdefinitions",
        tags = "@CasosFinales"
)
public class FinalTestSuite { // El nombre DEBE coincidir con el archivo .java
}