package edu.bitm;

import java.nio.file.Path;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertHandlingTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private String pageUrl;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Keep the browser visible so the execution can be demonstrated in screenshots.
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        pageUrl = Path.of("src", "test", "resources", "alerts-demo.html")
                .toAbsolutePath().toUri().toString();
        driver.get(pageUrl);
    }

    @Test(description = "TC01: Accept a JavaScript alert and verify its message")
    public void shouldAcceptAlertAndVerifyMessage() {
        driver.findElement(By.id("showAlert")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), "This is a JavaScript alert!");
        alert.accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),
                "Alert accepted.");
    }

    @Test(description = "TC02: Accept a JavaScript confirmation")
    public void shouldAcceptConfirmation() {
        driver.findElement(By.id("showConfirm")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), "Do you want to continue?");
        alert.accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),
                "You clicked OK.");
    }

    @Test(description = "TC03: Dismiss a JavaScript confirmation")
    public void shouldDismissConfirmation() {
        driver.findElement(By.id("showConfirm")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),
                "You clicked Cancel.");
    }

    @Test(description = "TC04: Enter text in a JavaScript prompt and accept")
    public void shouldSubmitPromptText() {
        driver.findElement(By.id("showPrompt")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), "Enter your name:");
        alert.sendKeys("Student 6");
        alert.accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),
                "Hello, Student 6!");
    }

    @Test(description = "TC05: Cancel a JavaScript prompt")
    public void shouldCancelPrompt() {
        driver.findElement(By.id("showPrompt")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),
                "Prompt cancelled.");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
