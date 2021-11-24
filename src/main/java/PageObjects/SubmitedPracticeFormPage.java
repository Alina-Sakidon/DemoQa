package PageObjects;

import Conponents.*;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.*;

public class SubmitedPracticeFormPage extends BasePage{
    private SelenideElement pageWrapper = $(".modal-content");
    private SelenideElement pageTitle = pageWrapper.$("#example-modal-sizes-title-lg");
    private SelenideElement table= $x("//tbody");
    private ElementsCollection tableRows = $$(By.tagName("tr"));

    public SubmitedPracticeFormPage(){
        pageWrapper.shouldBe(Condition.exist);
        pageTitle.shouldHave(Condition.matchText("Thanks for submitting the form"));
    }
    private String getLabelTextFromTable(String labelText){
        var firstRow = tableRows.stream().filter(j-> j.text().contains(labelText)).findFirst().get();

        return firstRow.lastChild().getText();
    }
    public User getStudentInfo(){

        String studentName = getLabelTextFromTable("Student Name");
        String[] splitStr = studentName.split("\\s+");
        String studentFirstName = splitStr[0];
        String studentLastName = splitStr[1];

        String studentGender = getLabelTextFromTable("Gender");

        String studentMobile =getLabelTextFromTable("Mobile");
        String studentCountryCode = studentMobile.substring(0,2);
        String studentOperatorCode = studentMobile.substring(2,5);
        String studentAbonentNumber = studentMobile.substring(5);

        User student = new User(new FullName(studentFirstName,studentLastName), new PhoneNumber(studentCountryCode,studentOperatorCode,
                studentAbonentNumber),new Gender(GenderType.valueOf(studentGender.toUpperCase())));
        return student;
    }
}
