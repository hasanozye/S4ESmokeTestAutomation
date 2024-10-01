package stepdefs;

import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import readers.property.PropertyReader;

public class HomePageSteps {

    HomePage homePage;
    WebDriver driver;
    String baseUrl = PropertyReader.read().getProperty("baseUrl");

    public HomePageSteps() {
        driver = Driver.getDriver();
        homePage = new HomePage();
    }

    @Given("I am on the Home page")
    public void iAmOnTheHomePage() {
        driver.get(this.baseUrl);
    }

    @When("I navigate to the {string} page")
    public void iNavigateToThePage(String pageName) {
        homePage.navigateToPage(pageName);
    }

    @And("the page title should be {string}")
    public void thePageTitleShouldBe(String expectedPageTitle) {
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
    }

    @And("the page URL should be {string}")
    public void thePageURLShouldBe(String expectedPageUrl) {
        String actualPageURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedPageUrl, actualPageURL);
    }

    @Then("I should see the Home page features displayed")
    public void iShouldSeeTheHomePageFeaturesDisplayed() {
        homePage.verifySeePlatformButtonIsDisplayed();
        homePage.verifyPlanWizardButtonIsDisplayed();
        homePage.verifyProtectYourServicesTextIsDisplayed();
    }
}
