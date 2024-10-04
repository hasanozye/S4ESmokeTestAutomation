package utils;

import driver.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    private static final String ENTER = "\n";

    /**
     * takescreenshots
     */
    public static void takesScreenShot() {
        takeScreenShot("screenshot");
    }

    /**
     * @param fileName file name of the screensShot
     */
    public static void takeScreenShot(String fileName) {
        fileName = fileName + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss")); // şuanki zamanı çekip dynamic oldu
        String filePath = "screenShot/" + fileName + ".png"; // dynamic isim
        TakesScreenshot scrShot = ((TakesScreenshot) Driver.getDriver()); // kameraman kamerası
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE); // ram'e kaydetti ctrl+c
        File destFile = new File(filePath); // Hardware yolu
        try {
            FileHandler.copy(srcFile, destFile); // kopyala ramden hardware'e
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
