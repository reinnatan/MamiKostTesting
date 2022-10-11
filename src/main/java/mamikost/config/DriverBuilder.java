package mamikost.config;

import io.appium.java_client.AppiumDriver;

public interface DriverBuilder {
    public DriverType getType();
    public AppiumDriver createDriver(String scenario);
    public void quitDriver();
}
