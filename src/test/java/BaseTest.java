
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    @BeforeMethod
    public void before(){
        Configuration.startMaximized = true;
        open("https://demoqa.com/");
    }
    @AfterMethod(alwaysRun = true)
    public void checkResult(ITestResult result) {
        if (result.getStatus() != ITestResult.SUCCESS) {
            saveScreenshot(screenshot(OutputType.BYTES));
        }
        Selenide.closeWebDriver();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
