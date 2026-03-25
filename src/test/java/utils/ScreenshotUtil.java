package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ScreenshotUtil {

    public static void capture(WebDriver driver, String testName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            Path destination = Paths.get(
              System.getProperty("user.dir"),
              "screenshots",
              testName + "_" + timestamp + ".png"
            );

            Files.createDirectories(destination.getParent());

            Files.copy(
                    src.toPath(),
                    destination,
                    StandardCopyOption.REPLACE_EXISTING
            );
        } catch (Exception e) {
            System.out.println("Error to save a screenshot: " + e.getMessage());
        }
    }
}
