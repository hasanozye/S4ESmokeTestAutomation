package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static driver.DriverFactory.*;

public class Driver {

    protected static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    protected static ThreadLocal<WebDriverWait> waits = new ThreadLocal<>();


    public static WebDriver getDriver() {
        return getDriver(Browsers.CHROME);
    }

    public static WebDriver getDriver(Browsers browser) {

        if (drivers.get() == null) {

            switch (browser) {

                case EDGE -> {
                    drivers.set(createEdge());
                }
                case FIREFOX -> {
                    drivers.set(createFirefox());
                }
                default -> {
                    drivers.set(createChrome());
                }

            }
        }

        waits.set(new WebDriverWait(drivers.get(), Duration.ofSeconds(10)));
        return drivers.get();

    }

    public static WebDriverWait getWait() {
        return waits.get();
    }

    public static void quitDriver() {
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.set(null);
        }
    }


}
