package mamikost.android.requiretest.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/mamikost/android/requiretest/features"},
        plugin = {
                    "pretty",
                    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                    "json:result/api.json",
                    "html:result/api.html"
                },
        glue = {"mamikost.android"}
)

//@RunWith(Cucumber.class)
public class RequireRunner extends AbstractTestNGCucumberTests {
}
