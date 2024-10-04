package pages;

import com.github.javafaker.Faker;
import driver.Driver;
import io.cucumber.java.en_lol.WEN;
import io.cucumber.java.en_old.Ac;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Faker faker;


    public BaseTest() {
        driver = Driver.getDriver();
        wait = Driver.getWait();
        faker = new Faker();
    }

    public void click(WebElement element) {
        wait.until(webDriver -> {
            try {

                element.click();
                return true;

            } catch (Exception e) {
                try {

                    new Actions(webDriver)
                            .moveToElement(element)
                            .click()
                            .perform();
                    return true;

                } catch (Exception exception) {
                    try {

                        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click()", element);
                        return true;

                    } catch (Exception e1) {
                        return false;
                    }
                }
            }
        });
    }

    public void sendKeys(WebElement element, CharSequence... text) {

        wait.until(webDriver -> {
            try {
                element.clear();
                element.sendKeys(text);
                return true;
            } catch (Exception e) {
                try {
                    element.clear();
                    new Actions(webDriver)
                            .moveToElement(element)
                            .sendKeys(text)
                            .perform();
                    return true;
                } catch (Exception e2) {
                    try {
                        ((JavascriptExecutor) webDriver).executeScript("arguments[0].value()'" + Arrays.toString(text) + "'", element);
                        return true;
                    } catch (Exception e3) {
                        return false;
                    }
                }
            }
        });
    }

    public void selectByVisibleText(WebElement element, String visibleTextMsg) {
        waitForVisibility(element);
        Select select = new Select(element);
        select.selectByVisibleText(visibleTextMsg);
    }

    public void scrollIntoElement(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickability(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void sleep(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }


}
