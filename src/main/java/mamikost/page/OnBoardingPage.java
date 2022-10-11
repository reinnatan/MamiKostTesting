package mamikost.page;


import io.appium.java_client.AppiumDriver;


public class OnBoardingPage extends BasePageAndroid {
    public OnBoardingPage(ThreadLocal<AppiumDriver> androidDriver) {
        super(androidDriver);
    }

    private static String PERMISSION_ALLOW_BUTTON = "com.android.packageinstaller:id/permission_allow_button";
    private static String LANGUANGES_BUTTON = "com.finaccel.android.staging:id/linear_lang";
    private static String LANGUAES_EN_BUTTON = "com.finaccel.android.staging:id/linear_us";

    public void clickSkip(){
        clickAndWaitOnElement("com.finaccel.android.staging:id/btn_skip", longWait);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickAllowPermissionBtn() {
        clickAndWaitOnElement(PERMISSION_ALLOW_BUTTON);
    }

    public void clickPermissionAllowBtnIfAppear() {
        if (isElementIfVisibleUsingXpath(PERMISSION_ALLOW_BUTTON)) {
            clickAllowPermissionBtn();
        }
    }
}
