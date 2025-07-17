package helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utility {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public static File getJSONSchemaFile(String JSONFile){
        return new File("src/test/resources/JSONSchema/"+JSONFile);
    }

    public static String generateRandomEmail() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "-_.";
        String email = "";
        String temp = RandomStringUtils.randomAlphanumeric(10);
        email = temp + "@testdata.com";
        return email;
    }

    public static void startDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--headless");
        options.addArguments("--no-sanbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static String getAlert(long timeoutInSeconds,String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
//        System.out.println("Alert message: " + alertText);
        Assertions.assertThat(alertText).isEqualTo(message);
        alert.accept();
        return alertText;
    }

    public void getAlertAddChart(long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public static void quitDriver() {
        driver.quit();
    }

    public static void getEvidance() {

        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String fileName = "screenshot_" + timestamp + ".png";
            File targetFile = new File("screenshots/HomePage/" + fileName);
            targetFile.getParentFile().mkdirs();
            FileUtils.copyFile(screenshot, targetFile);

            System.out.println("Screenshot saved to: " + targetFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
