package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/VerifyPagesOpen.feature"},
        glue = {"stepdefs"},
        plugin = {"pretty",
                "json:test-output/cucumber-reports/cucumber.json",
                "html:test-output/cucumber-reports/cucumberReport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        tags = "@pricingPageTest"
        // alternatif usage for all ->> @homePageTest or @platformPageTest or @pricingPageTest or @joinPageTest
        // alternatif usage for all ->> @smokeTest
)
public class Runner extends AbstractTestNGCucumberTests {


}
