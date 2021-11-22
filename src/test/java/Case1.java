import Conponents.*;
import PageObjects.PracticeFormPage;
import org.testng.annotations.Test;

public class Case1 extends BaseTest {
    @Test
    public void SubmitFormWithReqFields() throws InterruptedException {
        User user = new User(new FullName("Alina","Sakidon"),new PhoneNumber("38","099","44877"),
                new Gender(GenderType.FEMALE));
        PracticeFormPage practiceFormPage = openUrl().goToFormsPage()
                .goToPracticeFormPage().fillReqFields(user).submitForm();
        System.out.println(user.getFullName().toString());
    }
}
