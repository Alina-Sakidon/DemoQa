package PageObjects;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public  abstract class BasePage {
    public SelenideElement pageTitle = $(".main-header");

        protected <T> T setValue(SelenideElement element, String text, T instance) {
            element.clear();
            element.sendKeys(text);
            return instance;
        }

    protected void clickButton(SelenideElement button) {
        button.shouldBe(Condition.visible).shouldBe(Condition.enabled).click();
    }
}