package mamikost.page;

import io.appium.java_client.AppiumDriver;

public class PageCollection {
    protected ThreadLocal<AppiumDriver> androidDriver;
    private MainPage mainPage;

    public PageCollection(ThreadLocal<AppiumDriver> androidDriver) {
        this.androidDriver = androidDriver;
    }

    public MainPage getMainPage() {
        return (mainPage == null) ? mainPage = new MainPage(androidDriver) : mainPage;
    }
}
