package mamikost.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import lombok.extern.slf4j.Slf4j;
import mamikost.Utils.TestUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import java.util.Arrays;


@Slf4j
public class BasePageAndroid extends BasePage {

    public BasePageAndroid(ThreadLocal<AppiumDriver> androidDriver) {
        super(androidDriver);
    }

    @Override
    protected void clickAndWaitOnElement(String locator, Wait<WebDriver>... waitSupplied) {
//        Wait<WebDriver> tempWait = new WebDriverWait(androidDriver.get(), 10);
//        MobileElement mobileElement = (MobileElement) tempWait
//                .until(ExpectedConditions.elementToBeClickable(By.id(locator)));
//        mobileElement.click();
        Wait<WebDriver> tempWait = TestUtils.getFirstValueOr(waitSupplied, defaultWait);
        WebElement element;
        if(locator.startsWith("//") || locator.startsWith("(//")){
            element = (WebElement) tempWait
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        }else{
            element = (WebElement) tempWait
                    .until(ExpectedConditions.elementToBeClickable(By.id(locator)));
        }
        element.click();
    }

    /**
     * Gets the text or value element.
     *
     * @param element the mobile element
     * @return the text or value element
     */
    public String getTextOrValueElement(WebElement element) {
        return element.getText();
    }

    protected void setTextToElementByXpath(String locator, String text, Wait<WebDriver>... waitSupplied) {
        log.info("Typing text " + text + " on element " + locator);
        Wait<WebDriver> tempWait = TestUtils.getFirstValueOr(waitSupplied, defaultWait);
        WebElement element = tempWait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        clickAndWaitOnElement(locator, tempWait);
        element.clear();
        element.sendKeys(text);
        log.info("typing text " + text + " on element " + locator + " with value=" + text + " is successful");
    }

    /**
     * Swipe screen bottom to top.
     */
    protected void swipeScreenBottomToTop() {
        Dimension deviceDimension = driver.get().manage().window().getSize();
        Point start = new Point((int)(deviceDimension.getWidth()*0.5), (int)(deviceDimension.getHeight()*0.6));
        Point end = new Point((int)(deviceDimension.getWidth()*0.5), (int)(deviceDimension.getHeight()*0.1));

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), start.getX(), start.getY()))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), end.getX(), end.getY()))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.get().perform(Arrays.asList(swipe));
    }

    /**
     * Keep the appium alive to avoid
     * time out while waiting for
     * backend process
     * such as, waiting for db data created
     */
    @Override
    protected void keepAppiumAlive() {
        ((AndroidDriver) driver.get()).getDeviceTime();
        ((AndroidDriver) driver.get()).getOrientation();
    }

    /**
     * Press key code android.
     * @param androidKey the android key
     */
    protected void pressKeyCodeAndroid(AndroidKey androidKey) {
        // fixing the race condition
        ((AndroidDriver) driver.get()).pressKey(new KeyEvent(androidKey));
    }

    public void pressAndroidNumericKey(String number) {
        switch (number) {
            case "1":
                pressKeyCodeAndroid(AndroidKey.DIGIT_1);
                break;
            case "2":
                pressKeyCodeAndroid(AndroidKey.DIGIT_2);
                break;
            case "3":
                pressKeyCodeAndroid(AndroidKey.DIGIT_3);
                break;
            case "4":
                pressKeyCodeAndroid(AndroidKey.DIGIT_4);
                break;
            case "5":
                pressKeyCodeAndroid(AndroidKey.DIGIT_5);
                break;
            case "6":
                pressKeyCodeAndroid(AndroidKey.DIGIT_6);
                break;
            case "7":
                pressKeyCodeAndroid(AndroidKey.DIGIT_7);
                break;
            case "8":
                pressKeyCodeAndroid(AndroidKey.DIGIT_8);
                break;
            case "9":
                pressKeyCodeAndroid(AndroidKey.DIGIT_9);
                break;
            case "0":
                pressKeyCodeAndroid(AndroidKey.DIGIT_0);
                break;
        }
    }
}
