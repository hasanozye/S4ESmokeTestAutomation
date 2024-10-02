package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PricingPage extends BaseTest {

    public PricingPage() {
        PageFactory.initElements(driver, this);
    }

    int sliderIndex;

    @FindBy(xpath = "//span[text()='EVERYONE']/ancestor::div[@itemtype='http://schema.org/Offer']")
    public WebElement freePlan;

    @FindBy(xpath = "//span[text()='Expert']/ancestor::div[@itemtype='http://schema.org/Offer']")
    public WebElement expertPlan;

    @FindBy(xpath = "//span[text()='Elite']/ancestor::div[@itemtype='http://schema.org/Offer']")
    public WebElement elitePlan;

    @FindBy(xpath = "//span[text()='ENTERPRISE']/ancestor::div[@itemtype='http://schema.org/Offer']")
    public WebElement enterprisePlan;

    @FindBy(xpath = "//span[text()='Elite']/ancestor::div[@itemtype='http://schema.org/Offer']/descendant::h2[@itemprop='price']")
    public WebElement elitePlanPrice;


    public void verifyPricingPlansDisplayed() {
        try {
            freePlan = wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(freePlan)));
            Assert.assertTrue(freePlan.isDisplayed(), "Free plan not displayed");

            expertPlan = wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(expertPlan)));
            Assert.assertTrue(expertPlan.isDisplayed(), "Expert plan not displayed");

            elitePlan = wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(elitePlan)));
            Assert.assertTrue(elitePlan.isDisplayed(), "Elite plan not displayed");

            enterprisePlan = wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(enterprisePlan)));
            Assert.assertTrue(enterprisePlan.isDisplayed(), "Enterprise plan not displayed");
        } catch (StaleElementReferenceException e) {
            System.out.println("Stale Element Reference Exception: " + e.getMessage());
        }
    }

    public void moveSliderToSpecificWebsiteNumber(int number) {
        this.sliderIndex = number - 1;
        WebElement sliderDot = driver.findElement(By.xpath("//span[@data-index='" + sliderIndex + "']"));
        sliderDot.click();
        sliderIndex = 0;
    }

    public void verifyPlanPriceUpdatedAccordingly() {
        String priceText = elitePlanPrice.getText();

        if (sliderIndex == 4) {
            Assert.assertTrue(priceText.contains("269"), "Elite plan fiyati 5 websitesi için güncellenmedi");
        } else if (sliderIndex == 9) {
            Assert.assertTrue(priceText.contains("519"), "Elite plan fiyati 10 websitesi için güncellenmedi");

        }


    }


}
