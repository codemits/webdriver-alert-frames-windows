package com.tadigital.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertHandler {
    private static WebDriver driver;

    public AlertHandler() {
        // Initialize the WebDriver instance
        driver = new FirefoxDriver();
    }

    public void launchApplication(String url) {
        driver.get(url);
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void sendTextToAlert(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
    }

    public void closeApplication() {
        driver.quit();
    }

    public static void main(String[] args) {
        // Create an instance of AlertHandler
        AlertHandler alertHandler = new AlertHandler();

        // Launch the application
        alertHandler.launchApplication("https://the-internet.herokuapp.com/javascript_alerts");

        // Simple Alert
        // Example: accepting an alert
        driver.findElement(By.xpath("//div[@class='example']//button[text()='Click for JS Alert']"))
                .click();
        alertHandler.acceptAlert();

        // Confirmation Alert
        // Example: retrieving alert text
        driver.findElement(By.xpath("//div[@class='example']//button[text()='Click for JS Confirm']"))
                .click();
        String alertText = alertHandler.getAlertText();
        System.out.println("Alert Text: " + alertText);
        alertHandler.dismissAlert();

        // Prompt Alert
        // Example: sending text to an alert
        driver.findElement(By.xpath("//div[@class='example']//button[text()='Click for JS Prompt']"))
                .click();
        alertHandler.sendTextToAlert("Hello, Automation Tester");
        alertHandler.acceptAlert();

        // Close the application and clean up resources
        alertHandler.closeApplication();
    }
}

