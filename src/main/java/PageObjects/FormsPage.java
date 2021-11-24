package PageObjects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class FormsPage extends BasePage{
    private ElementsCollection leftPanel = $$(By.className("left-pannel"));
    private SelenideElement practiceFormButton = $$(By.className("text")).findBy(Condition.text("Practice Form"));

    public FormsPage(){
        leftPanel.should(CollectionCondition.sizeGreaterThan(0));
    }
    public PracticeFormPage goToPracticeFormPage(){
        practiceFormButton.shouldBe(Condition.visible).click();
        return new PracticeFormPage();
    }
}
