package stepdefs;

import driver.Driver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.PlatformPage;

public class PlatformPageSteps {

    PlatformPage platformPage;
    WebDriver driver;

    public PlatformPageSteps() {
        driver = Driver.getDriver();
        platformPage = new PlatformPage();
    }

    @Then("I should see the Platform page elements displayed")
    public void iShouldSeeThePlatformPageElementsDisplayed() {
        platformPage.verifyElementsOnThePage();

    }
}
