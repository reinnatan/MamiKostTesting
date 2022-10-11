package mamikost.config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

@Component
public class AndroidDriverBuilder implements DriverBuilder{


    @Autowired
    BrowserstackProperties browserstackProperties;
    //public AndroidDriverBuilder(){
    //    System.out.println("Constructor Dipanggil");
    //}

    @Override
    public DriverType getType() {
        return DriverType.ANDROID;
    }

    @Override
    public AppiumDriver createDriver(String scenario) {
        DesiredCapabilities extraCapabilities = new DesiredCapabilities();
        UiAutomator2Options options = new UiAutomator2Options();
        options = options.merge(MobileDriverCapabilities.valueOf("ANDROID_APPIUM_8").returnCapabilities(extraCapabilities));
        options.setCapability("build", scenario);
        options.setCapability("device", "Samsung Galaxy S21 Ultra");
        options.setCapability("realMobile", "Samsung Galaxy S21 Ultra");
        options.setCapability("deviceName", "Samsung Galaxy S21 Ultra");
        options.setCapability("os_version", "11.0");
        options.setCapability("name", "testing-1");
        options.setCapability("app", "android");

        try {
            System.out.println("bs : "+browserstackProperties.getUserName()+browserstackProperties.getAppiumHub());
            return
                    new AndroidDriver(
                            new URL("https://"+browserstackProperties.getUserName()+":"+
                                    browserstackProperties.getApiKey()+browserstackProperties.getAppiumHub()),
                            options);
        } catch (MalformedURLException e) {
            System.out.println("GAGAL");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void quitDriver() {

    }
}
