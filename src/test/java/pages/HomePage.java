package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.*;

public class HomePage extends BaseTest {

    public HomePage() {
        super(); // olmasada olur, olsada olur, olur olur...
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='css-1h4d3qm']/child::a")
    public WebElement seePlatformButton;

    @FindBy(xpath = "//div[@class='css-u8j0an']/child::button")
    public WebElement planWizard;

    @FindBy(tagName = "h1")
    public WebElement protectYourServicesText;

    @FindBy(xpath = "//nav/descendant::a[@href='/platform']")
    public WebElement navBarPlatform;

    @FindBy(xpath = "//nav/descendant::a[@href='/pricing']")
    public WebElement navBarPricing;

    @FindBy(xpath = "//div[@class='css-vy5kqm']/descendant::button[text()='Join']")
    public WebElement navBarJoinButton;

    public void verifySeePlatformButtonIsDisplayed() {
        assertTrue(seePlatformButton.isDisplayed(), "See platform button is not displayed");
    }

    public void verifyPlanWizardButtonIsDisplayed() {
        assertTrue(planWizard.isDisplayed(), "Plan wizard button is not displayed");
    }

    public void verifyProtectYourServicesTextIsDisplayed() {
        assertTrue(protectYourServicesText.isDisplayed(), "Protect your services text is not displayed");
    }

    public void navigateToPage(String pageName) {

        switch (pageName) {
            case "Pricing" -> click(navBarPricing);
            case "Platform" -> click(navBarPlatform);
            case "Join" -> click(navBarJoinButton);
            default -> throw new IllegalArgumentException("Geçersiz sayfa bu ->> " + pageName);
        }
    }


}
