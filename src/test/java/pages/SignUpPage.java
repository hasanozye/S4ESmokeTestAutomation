package pages;

import org.apache.poi.ss.formula.functions.Na;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends BaseTest {

    public SignUpPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    public WebElement emailField;
    @FindBy(name = "password")
    public WebElement passwordField;
    @FindBy(name = "password_again")
    public WebElement passwordAgainField;
    @FindBy(id = "industry-select")
    public WebElement industrySelectDropdown;
    @FindBy(xpath = "//li[@data-value='IT']")
    public WebElement industryDropdownITField;
    @FindBy(id = "position-select")
    public WebElement positionSelectDropdown;
    @FindBy(xpath = "//li[@data-value='Engineer']")
    public WebElement positionDropdownEngineerField;
    @FindBy(id = "register-is-term-check")
    public WebElement ToSCheckBox;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement createAccountButton;
    @FindBy(xpath = "//p[text()='Confirmation Required']")
    public WebElement confirmationRequiredText;

    public void fillInTheSignUpForm() {
        String randomEmail = faker.internet().emailAddress();
        String randomPassword = validPasswordGenerate();

        sendKeys(emailField, randomEmail);
        sendKeys(passwordField, randomPassword);
        sendKeys(passwordAgainField, randomPassword);

        click(industrySelectDropdown);
        waitForVisibility(industryDropdownITField);
        click(industryDropdownITField);
        waitForVisibility(positionSelectDropdown);
        click(positionSelectDropdown);
        waitForVisibility(positionDropdownEngineerField);
        click(positionDropdownEngineerField);
        click(ToSCheckBox);
    }

    public void submitForm() {
        click(createAccountButton);
    }

    public void checkVisibilityOfConfirmationText() {
        waitForVisibility(confirmationRequiredText);
    }
    public String validPasswordGenerate(){
        String upperCase = faker.letterify("?").toUpperCase();  // Tek büyük harf
        String lowerCase = faker.letterify("?").toLowerCase();  // Tek küçük harf
        String digit = faker.numerify("#");  // Tek rakam

        String remainingChars = faker.lorem().characters(5);

        String validPassword = upperCase + lowerCase + digit + remainingChars;
        return validPassword;
    }


}
