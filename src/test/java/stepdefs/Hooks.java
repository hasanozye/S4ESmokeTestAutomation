package stepdefs;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import readers.property.PropertyReader;

public class Hooks {

    @After
    public void tearDown() {
        if (Driver.getDriver() != null) {
            Driver.quitDriver();
        }
    }

    @AfterStep
    public void afterStepSS(Scenario scenario) {
        boolean scrShot = PropertyReader.read().getProperty("takescreenshot").equalsIgnoreCase("true");
        String takeScrOn = PropertyReader.read().getProperty("takescreenshot.on");
        if (scrShot) {
            if (takeScrOn.equalsIgnoreCase("fail")) {
                if (scenario.isFailed()) {
                    byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", scenario.getName());
                }
            } else {
                byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        }
    }


}
