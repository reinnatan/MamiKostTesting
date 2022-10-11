package mamikost.config;

import io.appium.java_client.remote.IOSMobileCapabilityType;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public enum MobileDriverCapabilities {
    ANDROID {
        @Override
        public MutableCapabilities returnCapabilities(final DesiredCapabilities extraCapabilities) {
            final DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("project", "Kredivo Android App");

            desiredCapabilities.setCapability("browserstack.appium_version", "1.22.0");
            desiredCapabilities.setCapability("browserstack.appiumVersion", "1.22.0");

            desiredCapabilities.setCapability("unicodeKeyboard", true);
            desiredCapabilities.setCapability("resetKeyboard", true);
            desiredCapabilities.setCapability("browserstack.debug", true);
            desiredCapabilities.setCapability("browserstack.local", true);
            desiredCapabilities.setCapability("browserstack.deviceLogs", true);
            desiredCapabilities.setCapability("browserstack.appiumLogs", true);
            desiredCapabilities.setCapability("browserstack.networkLogs", true);
            desiredCapabilities.setCapability("browserstack.geoLocation", "ID");

            desiredCapabilities.setCapability("browserstack.video", true);
            desiredCapabilities.setCapability("autoGrantPermissions", true);
            desiredCapabilities.setCapability("--no-reset", true);
            desiredCapabilities.setCapability("clearDeviceLogsOnStart", true);
            desiredCapabilities.setCapability("newCommandTimeout", 30000);
            desiredCapabilities.setCapability("adbExecTimeout", 30000);
            desiredCapabilities.setCapability("browserstack.idleTimeout", 600);
            desiredCapabilities.setCapability("nativeWebTap", true);

            desiredCapabilities.setCapability("browserstack.resignApp", "false");

            desiredCapabilities.setCapability("automationName", "uiautomator2");

            desiredCapabilities.merge(extraCapabilities);

            return desiredCapabilities;
        }

    },

    ANDROID_APPIUM_8 {
        @Override
        public MutableCapabilities returnCapabilities(final DesiredCapabilities extraCapabilities) {
            final MutableCapabilities mutableCapabilities = new MutableCapabilities();
            final HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
            browserstackOptions.put("appiumVersion", "1.22.0");
            browserstackOptions.put("debug", true);
            browserstackOptions.put("local", true);
            browserstackOptions.put("deviceLogs", true);
            browserstackOptions.put("appiumLogs", true);
            browserstackOptions.put("networkLogs", true);
            browserstackOptions.put("geoLocation", "ID");
            browserstackOptions.put("video", true);
            browserstackOptions.put("idleTimeout", 600);
            browserstackOptions.put("resignApp", "false");

            mutableCapabilities.setCapability("bstack:options", browserstackOptions);
            mutableCapabilities.setCapability("appium:project", "Kredivo Android App");

            //desiredCapabilities.setCapability("browserstack.appiumVersion", "1.22.0");

            mutableCapabilities.setCapability("appium:unicodeKeyboard", true);
            mutableCapabilities.setCapability("appium:resetKeyboard", true);

            mutableCapabilities.setCapability("appium:autoGrantPermissions", true);
            mutableCapabilities.setCapability("-appium:-no-reset", true);
            mutableCapabilities.setCapability("appium:clearDeviceLogsOnStart", true);
            mutableCapabilities.setCapability("appium:newCommandTimeout", 30000);
            mutableCapabilities.setCapability("appium:adbExecTimeout", 30000);
            mutableCapabilities.setCapability("appium:nativeWebTap", true);

            mutableCapabilities.setCapability("appium:automationName", "uiautomator2");

            mutableCapabilities.merge(extraCapabilities);

            return mutableCapabilities;
        }

    },

    IOS_APPIUM_8{
        @Override
        public MutableCapabilities returnCapabilities(final DesiredCapabilities extraCapabilities) {
            final MutableCapabilities iosMutableCapabilities = new MutableCapabilities();
            final HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();

            browserstackOptions.put("appiumVersion", "1.22.0");
            browserstackOptions.put("debug", true);
            browserstackOptions.put("local", true);
            browserstackOptions.put("deviceLogs", true);
            browserstackOptions.put("appiumLogs", true);
            browserstackOptions.put("networkLogs", true);
            browserstackOptions.put("geoLocation", "ID");
            browserstackOptions.put("video", true);
            browserstackOptions.put("idleTimeout", 70);
            iosMutableCapabilities.setCapability("bstack:options", browserstackOptions);

            iosMutableCapabilities.setCapability("appium:device", "iPhone XS");
            iosMutableCapabilities.setCapability("appium:realMobile", "iPhone XS");
            iosMutableCapabilities.setCapability("appium:project", "Kredivo IOS App");

            iosMutableCapabilities.setCapability("appium:unicodeKeyboard", true);
            iosMutableCapabilities.setCapability("appium:autoGrantPermissions", true);
            iosMutableCapabilities.setCapability("-appium:--no-reset", false);
            iosMutableCapabilities.setCapability("appium:clearSystemFiles", true);
            iosMutableCapabilities.setCapability("appium:wdaStartupRetryInterval", "1000");
            iosMutableCapabilities.setCapability("appium:useNewWDA", true);
            iosMutableCapabilities.setCapability("appium:waitForQuiescence", false);
            iosMutableCapabilities.setCapability("appium:shouldUseSingletonTestManager", false);
            iosMutableCapabilities.setCapability("appium:connectHardwareKeyboard", false);
            iosMutableCapabilities.setCapability("appium:clearDeviceLogsOnStart", true);
            iosMutableCapabilities.setCapability("appium:"+ IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);
            iosMutableCapabilities.setCapability("appium:"+IOSMobileCapabilityType.SAFARI_ALLOW_POPUPS, true);
            iosMutableCapabilities.setCapability(IOSMobileCapabilityType.BROWSER_NAME, "Safari");
            iosMutableCapabilities.setCapability("appium:newCommandTimeout", 30000);
            iosMutableCapabilities.setCapability("appium:adbExecTimeout", 30000);
            iosMutableCapabilities.setCapability("appium:nativeWebTap", true);

            return iosMutableCapabilities;

        }
    };

    public abstract MutableCapabilities returnCapabilities(DesiredCapabilities extraCapabilities);
}
