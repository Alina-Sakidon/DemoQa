import Conponents.*;
import PageObjects.PracticeFormPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Cases extends BaseTest {
    @Test
    public void submitPracticeFormWithReqFields() {
        User user = new User(new FullName("Alina","Sakidon"),new PhoneNumber("38","099","44877"),
                new Gender(GenderType.FEMALE));
        User actualStudent = openUrl().goToFormsPage()
                .goToPracticeFormPage().fillReqFields(user).submitForm().getStudentInfo();
        Assert.assertEquals(actualStudent,user);
    }

    @Test
    public void submitEmptyPracticeForm() {
        PracticeFormPage practiceFormPage = openUrl()
                .goToFormsPage()
                .goToPracticeFormPage()
                .submitFormWitEmptyFields();
        Assert.assertTrue(practiceFormPage.isFirstNameRequired());
        Assert.assertTrue(practiceFormPage.isLastNameRequired());
        Assert.assertTrue(practiceFormPage.isGenderRequired());
    }
}
