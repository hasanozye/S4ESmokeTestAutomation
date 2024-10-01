package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PlatformPage extends BaseTest {

    public PlatformPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//a[@href='https://app.s4e.io/sign-up'])[1]")
    public WebElement firstStartOneWeekTrialButton;
    @FindBy(xpath = "//h2[text()='Platform Features']")
    public WebElement platformFeaturesText;
    @FindBy(xpath = "//h2[text()='More than a tool']")
    public WebElement moreThanATool;


    public void verifyElementsOnThePage() {
        waitForVisibility(firstStartOneWeekTrialButton);
        waitForVisibility(platformFeaturesText);
        waitForVisibility(moreThanATool);
        scrollIntoElement(platformFeaturesText);
        scrollIntoElement(moreThanATool);
        scrollIntoElement(firstStartOneWeekTrialButton);
        Assert.assertTrue(firstStartOneWeekTrialButton.isDisplayed());
    }


}
