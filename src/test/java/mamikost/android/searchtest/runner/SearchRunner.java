package mamikost.android.searchtest.runner;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/mamikost/android/searchtest/features"},
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        glue = {"mamikost.android.searchtest"}
)

//@RunWith(Cucumber.class)
public class SearchRunner extends AbstractTestNGCucumberTests {
}
