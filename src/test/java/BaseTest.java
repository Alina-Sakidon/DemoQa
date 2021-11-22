import PageObjects.MainPage;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeMethod
    public void beforeMethod(){
        closeWebDriver();
        Configuration.startMaximized = true;
    }

    public MainPage openUrl() {
        open("https://demoqa.com/");
        return new MainPage();
    }
}
