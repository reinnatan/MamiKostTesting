package mamikost.page;

import io.appium.java_client.AppiumDriver;

public class MainPage {
    private LoginPage loginPage;
    private OnBoardingPage onBoardingPage;

    protected ThreadLocal<AppiumDriver> androidDriver;

    public MainPage(ThreadLocal<AppiumDriver> androidDriver2) {
        this.androidDriver = androidDriver2;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(androidDriver) : loginPage;
    }
    public OnBoardingPage getOnBoardingPage() {
        return (onBoardingPage == null) ? onBoardingPage = new OnBoardingPage(androidDriver) : onBoardingPage;
    }

    public void userLogin() {
        getOnBoardingPage().clickSkip();
        getLoginPage().clickLogin();
        getLoginPage().clickAgreeButton();
        getLoginPage().inputAndSubmitLoginCredentials();
        getLoginPage().selectAndInputOtp();
    }
}
