package stepdefs;

import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.PricingPage;

public class PricingPageSteps {

    PricingPage pricingPage;
    WebDriver driver;

    public PricingPageSteps() {
        driver = Driver.getDriver();
        pricingPage = new PricingPage();
    }

    @And("I should see the pricing plans displayed")
    public void iShouldSeeThePricingPlansDisplayed() {
        pricingPage.verifyPricingPlansDisplayed();
    }

    @Then("the plan prices should update accordingly")
    public void thePlanPricesShouldUpdateAccordingly() {
        pricingPage.verifyPlanPriceUpdatedAccordingly();
    }

    @When("I switch to Yearly payment option")
    public void iSwitchToYearlyPaymentOption() {

    }

    @Then("the plan prices should reflect the yearly discount")
    public void thePlanPricesShouldReflectTheYearlyDiscount() {
    }

    @When("I move the slider to {int} websites or IP addresses")
    public void iMoveTheSliderToWebsitesOrIPAddresses(int numberOfWebsites) {
        pricingPage.moveSliderToSpecificWebsiteNumber(numberOfWebsites);


    }
}
