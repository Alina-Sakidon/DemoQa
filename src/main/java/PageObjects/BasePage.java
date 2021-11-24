package PageObjects;


import Conponents.Helper.Colors;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.Color;


public  abstract class BasePage {

    protected <T> T setValue(SelenideElement element, String text, T instance) {
        element.clear();
        element.sendKeys(text);
        return instance;
    }


    protected boolean isElementRed(SelenideElement element, String cssValue){
        return Color.fromString(element.shouldBe(Condition.visible).getCssValue(cssValue)).asHex().equals(Colors.redColor);
    }
}