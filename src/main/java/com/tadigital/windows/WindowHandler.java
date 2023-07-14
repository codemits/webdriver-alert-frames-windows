package com.tadigital.windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WindowHandler {
    private WebDriver driver;

    public WindowHandler() {
        // Initialize the WebDriver instance
        driver = new FirefoxDriver();
    }

    public void openNewWindow(String url) {
        driver.get(url);
    }

    public void switchToWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    public void closeCurrentWindow() {
        driver.close();
    }

    public void switchToTab(String tabHandle) {
        driver.switchTo().window(tabHandle);
    }

    public void performWindowOperations() {
        // Open a new window
        openNewWindow("https://the-internet.herokuapp.com/windows");

        // Store the main window handle
        String mainWindowHandle = driver.getWindowHandle();

        // Click on the link to open a new window
        driver.findElement(By.cssSelector("a[href*='new']")).click();

        // Switch to the new window
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Perform operations in the new window
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.example h3")));
        System.out.println("New Window Text: " + element.getText());


        // Close the current window
        closeCurrentWindow();

        // Switch back to the main window
        driver.switchTo().window(mainWindowHandle);

        // Perform operations in the main window
        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.example h3")));
        System.out.println("Main Window Text: " + element2.getText());
    }

    public void closeBrowser() {
        driver.quit();
    }

    public static void main(String[] args) {
        // Create an instance of WindowHandler
        WindowHandler windowHandler = new WindowHandler();

        // Perform window operations
        windowHandler.performWindowOperations();

        // Close the browser
        windowHandler.closeBrowser();
    }
}
