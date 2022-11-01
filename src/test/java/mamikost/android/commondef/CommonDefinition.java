package mamikost.android.commondef;

import io.appium.java_client.AppiumDriver;
import mamikost.config.DriverBuilderFactory;
import mamikost.config.DriverType;
import mamikost.page.PageCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


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

    //@AfterClass(alwaysRun = true)
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
