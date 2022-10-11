package mamikost.searchtest.commondef;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import mamikost.config.DriverBuilderFactory;
import mamikost.config.DriverType;
import mamikost.page.PageCollection;


public class CommonDefinition {
    private ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    public ThreadLocal<AppiumDriver> getDriver() {
        return driver;
    }
    private PageCollection pageCollection;

    public void createAndroidDriver(String scenario) {
        driver.set(DriverBuilderFactory.getDriver(DriverType.ANDROID).createDriver(scenario));
        initPageCollection();
    }

    public void tearDown(){
        if (getDriver().get().getSessionId() != null) {
            quitDriver();
        }
    }

    private void quitDriver() {
        try {
            driver.get().quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initPageCollection(){
        pageCollection = new PageCollection(getDriver());
    }

    public PageCollection getPageCollection() {
        return pageCollection;
    }
}