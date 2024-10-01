package stepdefs;

import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.SignUpPage;

public class SignUpStepDefs {

    WebDriver driver;
    SignUpPage signUpPage;

    public SignUpStepDefs() {
        driver = Driver.getDriver();
        signUpPage = new SignUpPage();
    }

    @And("I fill out the signup form with valid data")
    public void iFillOutTheSignupFormWithValidData() {
        signUpPage.fillInTheSignUpForm();
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        signUpPage.submitForm();
    }

    @Then("I should see the Confirmation Required page")
    public void iShouldSeeTheConfirmationRequiredPage() {
        signUpPage.checkVisibilityOfConfirmationText();
    }
}
