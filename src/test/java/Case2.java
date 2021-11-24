import PageObjects.MainPage;
import PageObjects.PracticeFormPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Case2 extends BaseTest{
    @Test
    public void submitEmptyPracticeForm() throws InterruptedException {
        PracticeFormPage practiceFormPage = new MainPage()
                .goToFormsPage()
                .goToPracticeFormPage()
                .submitFormWitEmptyFields();
        Thread.sleep(1000);
        Assert.assertTrue(practiceFormPage.isFirstNameRequired());
        Assert.assertTrue(practiceFormPage.isLastNameRequired());
        Assert.assertTrue(practiceFormPage.isGenderRequired());
    }
}