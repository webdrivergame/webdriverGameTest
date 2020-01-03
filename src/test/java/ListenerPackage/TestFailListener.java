package ListenerPackage;

import SeleniumMethod.WebDriverUtil;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestFailListener extends TestListenerAdapter {
    private WebDriverUtil GetDriver;


    //private WebDriverUtil GetDriver;

    @Override
    public void onTestFailure(ITestResult result) {
        screenshot();
    }

    @Attachment(value = "screen shot",type = "image/png")
    public byte[]  screenshot(){
        byte[] screenshotAs = ((TakesScreenshot)GetDriver.driver).getScreenshotAs(OutputType.BYTES);
        return screenshotAs;
    }

}