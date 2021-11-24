package PageObjects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class MainPage extends BasePage{
    private SelenideElement homeBody = $(".home-body");
    private ElementsCollection listOfCards = $$x("//div[@class=\"card mt-4 top-card\"]");

    public MainPage(){
        homeBody.shouldBe(Condition.exist);};

    @Step("Open Forms Page")
    public FormsPage goToFormsPage(){
        listOfCards.shouldBe(CollectionCondition.sizeGreaterThan(0)).find(Condition.text("Forms")).click();
        return new FormsPage();
    }
}

