package PageObjects;

import Conponents.User;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @Step ("Set student's firstname")
    public PracticeFormPage setFirstName(User user){
        return setValue(inputFirstName,user.getFullName().getFirstName(),this);
    }
    @Step ("Set student's lastname")
    public PracticeFormPage setLastName(User user){
       return setValue(inputLastName,user.getFullName().getLastName(),this);
    }
    @Step ("Set student's gender")
    public  PracticeFormPage setGender(User user){
        switch (user.getGender().getGenderType()){
            case MALE:
                genderRadioMale.shouldBe(Condition.matchText("Male")).shouldBe(Condition.enabled).click();
                break;
            case FEMALE:
                genderRadioFemale.shouldBe(Condition.matchText("Female")).shouldBe(Condition.enabled).click();
                break;
            case OTHER:
                genderRadioOther.shouldBe(Condition.matchText("Other")).shouldBe(Condition.enabled).click();
                break;
            default:break;
        }
        return this;
    }
    @Step ("Set student's phone number")
    public PracticeFormPage setPhoneNumber(User user){
        return setValue(inputMobilePhone, user.getPhoneNumber().getCountryCode()+user.getPhoneNumber().getOperatorCode()
                +user.getPhoneNumber().getAbonentNumber(),this);
    }

    @Step ("Scroll down and submit form")
    public SubmitedPracticeFormPage submitForm(){
        submitButton.scrollIntoView(true).click();
        return new SubmitedPracticeFormPage();
    }

    @Step ("Scroll down, submit empty practice form, scroll up")
    public PracticeFormPage submitFormWitEmptyFields(){
        submitButton.scrollIntoView(true).click();
        inputFirstName.scrollIntoView(false);
        return new PracticeFormPage();
    }
    @Step ("Set required fields of practice form")
    public PracticeFormPage fillReqFields(User user){
        setFirstName(user).setLastName(user).setGender(user).setPhoneNumber(user);
        return this;
    }
    @Step ("Verify is input of the firstname required")
    public boolean isFirstNameRequired(){
        return isElementRed(inputFirstName,"border-color");
    }
    @Step ("Verify is input of the lastname required")
    public  boolean isLastNameRequired(){
        return isElementRed(inputLastName,"border-color");
    }

    @Step ("Verify is gender required")
    public boolean isGenderRequired(){
       return isElementRed(genderRadioFemale,"color")&& isElementRed(genderRadioMale,"color") && isElementRed(genderRadioOther,"color");
    }
    public boolean isMobilePhoneRequired(){
        return isElementRed(inputMobilePhone,"border-color");
    }

}
