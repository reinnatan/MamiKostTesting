package mamikost.page;

import io.appium.java_client.AppiumDriver;
import mamikost.Utils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BasePage{
    protected ThreadLocal<AppiumDriver> driver;

    protected Wait<WebDriver> defaultWait;
    protected Wait<WebDriver> minimalWait;
    protected Wait<WebDriver> shortWait;
    protected Wait<WebDriver> longWait;

    public BasePage(ThreadLocal<AppiumDriver> driver) {
        this.driver = driver;
        PageFactory.initElements(driver.get(), this);
        defaultWait = new WebDriverWait(driver.get(), Duration.ofSeconds(5));
        minimalWait = new WebDriverWait(driver.get(), Duration.ofSeconds(1));
        shortWait = new WebDriverWait(driver.get(), Duration.ofSeconds(3));
        longWait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
    }

    protected abstract void clickAndWaitOnElement(String locator, Wait<WebDriver>... waitSupplied);
    protected abstract String getTextOrValueElement(WebElement element);
    protected abstract void setTextToElementByXpath(String locator, String text, Wait<WebDriver>... waitSupplied);
    protected abstract void swipeScreenBottomToTop();

    protected final boolean isElementIfVisibleUsingXpath(String locator, Wait<WebDriver>... waitSupplied) {
        try {
            Wait<WebDriver> tempWait = TestUtils.getFirstValueOr(waitSupplied, defaultWait);
            WebElement el = tempWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            return el.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected final void clickWithoutWait(String locator) {
        driver.get().findElement(By.xpath(locator)).click();
    }

    protected abstract void keepAppiumAlive();

}
