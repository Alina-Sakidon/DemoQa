import Conponents.*;
import PageObjects.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Case1 extends BaseTest {

    @Test
    public void submitPracticeFormWithReqFields() {
        User user = new User(new FullName("Alina","Sakidon"),new PhoneNumber("38","099","44877"),
                new Gender(GenderType.FEMALE));
        User actualStudent = new MainPage().goToFormsPage()
                .goToPracticeFormPage().fillReqFields(user).submitForm().getStudentInfo();
        Assert.assertEquals(actualStudent,user);
    }

}
