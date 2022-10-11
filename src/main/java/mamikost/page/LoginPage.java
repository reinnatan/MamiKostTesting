package mamikost.page;


import io.appium.java_client.AppiumDriver;


public class LoginPage extends BasePageAndroid {
    public LoginPage(ThreadLocal<AppiumDriver> androidDriver) {
        super(androidDriver);
    }

    private static String AGREE_OK_BUTTON = "com.finaccel.android.staging:id/btn_ok";
    private static String LOGIN_BUTTON = "com.finaccel.android.staging:id/btn_login";
    private static String PHONE_NUMBER_EDIT_BOX = "//android.widget.TextView[@text='+62']/following-sibling::android.widget.EditText";
    private static String PIN_EDIT_BOX = "//android.widget.EditText[@text='PIN']";
    private static String SELECT_VERIFICATION_METHOD = "//android.widget.TextView[@text='Pilih metode verifikasimu']";
    private static String SMS_OTP_OPTION = "//android.widget.TextView[contains(@text, 'Via SMS')]";
    //private static String SMS_OTP_OPTION = "//android.widget.TextView[@text='Via SMS ke']/parent::android.widget.LinearLayout/parent::android.view.ViewGroup";
    private static String OTP_FIRST_IMG = "(//android.widget.FrameLayout/android.widget.ImageView)[1]";

    public void clickLogin(){
        clickAndWaitOnElement(LOGIN_BUTTON);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickAgreeButton(){
        clickAndWaitOnElement(AGREE_OK_BUTTON);
    }

    public void inputAndSubmitLoginCredentials(){
        setTextToElementByXpath(PHONE_NUMBER_EDIT_BOX, "84041283451");
        setTextToElementByXpath(PIN_EDIT_BOX, "131212");
        clickAndWaitOnElement(LOGIN_BUTTON);
    }

    public void selectAndInputOtp(){
        clickAndWaitOnElement(SMS_OTP_OPTION);
        clickAndWaitOnElement(OTP_FIRST_IMG);
        String[] otpArray = ("4567").split("");
        for(String key : otpArray){
            pressAndroidNumericKey(key);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        swipeScreenBottomToTop();
        swipeScreenBottomToTop();
    }


}

