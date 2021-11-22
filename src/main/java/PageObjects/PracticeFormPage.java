package PageObjects;

import Conponents.User;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage extends BasePage{
    private SelenideElement practiseFormWrapper = $(".practice-form-wrapper");
    private SelenideElement inputFirstName = practiseFormWrapper.$(By.id("firstName"));
    private SelenideElement inputLastName = practiseFormWrapper.$(By.id("lastName"));
    private SelenideElement inputMobilePhone = practiseFormWrapper.$(By.id("userNumber"));
    private SelenideElement genderRadioMale = $x("//label[@for=\"gender-radio-1\"]");
    private SelenideElement genderRadioFemale = $x("//label[@for=\"gender-radio-2\"]");
    private SelenideElement genderRadioOther = $x("//label[@for=\"gender-radio-3\"]");
    private SelenideElement submitButton = $(By.id("submit"));

    public PracticeFormPage(){
        practiseFormWrapper.shouldBe(Condition.exist);
    }

    public PracticeFormPage setFirstName(User user){
        return setValue(inputFirstName,user.getFullName().getFirstName(),this);
    }
    public PracticeFormPage setLastName(User user){
       return setValue(inputLastName,user.getFullName().getLastName(),this);
    }
    public  PracticeFormPage setGender(User user){
        switch (user.getGender().getGenderType()){
            case MALE:genderRadioMale.shouldBe(Condition.matchText("Male")).shouldBe(Condition.enabled).click();
        break;
            case FEMALE:genderRadioFemale.shouldBe(Condition.matchText("Female")).shouldBe(Condition.enabled).click();
            break;
            case OTHER:genderRadioFemale.shouldBe(Condition.matchText("Other")).shouldBe(Condition.enabled).click();
                break;
            default:break;
        }
        return this;
    }
    public PracticeFormPage setPhoneNumber(User user){
        return setValue(inputMobilePhone, user.getPhoneNumber().getCountryCode()+user.getPhoneNumber().getOperatorCode()+user.getPhoneNumber().getAbonentNumber(),this);
    }

    public PracticeFormPage submitForm(){
        submitButton.scrollIntoView(true).click();
        return new PracticeFormPage();
    }


    public PracticeFormPage fillReqFields(User user){
        setFirstName(user).setLastName(user).setGender(user).setPhoneNumber(user);
        return this;
    }

}
