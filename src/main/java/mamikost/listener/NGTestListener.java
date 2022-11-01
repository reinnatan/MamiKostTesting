package mamikost.listener;

import mamikost.Utils.MailNotificationUtils;

import mamikost.Utils.ReportUpdateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import javax.mail.MessagingException;
import java.io.IOException;

public class NGTestListener implements ITestListener {

    @Autowired
    MailNotificationUtils mailNotif ;//= new MailNotificationUtils();


    @Override
    public void onStart(ITestContext context) {
        System.out.println("Start Testing");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Finished Testing");
        try {
            //mailNotif.sendGmailEmailReport();
            ReportUpdateUtils.updateReportAllureServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Testing Success");

    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Testing Running");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Testing Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Testing Failed Within Percentage");
    }


    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Testing Failed");
    }

}
