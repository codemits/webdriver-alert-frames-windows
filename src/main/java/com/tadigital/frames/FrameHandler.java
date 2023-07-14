package com.tadigital.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameHandler {
    private WebDriver driver;

    public FrameHandler() {
        // Initialize the WebDriver instance
        driver = new FirefoxDriver();
    }

    public void switchToFrameById(String frameId) {
        driver.switchTo().frame(frameId);
    }

    public void switchToFrameByIndex(int frameIndex) {
        driver.switchTo().frame(frameIndex);
    }

    public void switchToFrameByElement(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void performFrameOperations() {
        /*//1. Switch to the first level frame by ID
        switchToFrameById("mce_0_ifr");
        System.out.println(driver.findElement(By.id("tinymce")).getText());*/

        /*// 2. Switch to the second level frame by index
        switchToFrameByIndex(0);
        System.out.println(driver.findElement(By.id("tinymce")).getText());*/

        /*// 3. Need 1/2 first - Switch back to the default frame
        switchToDefaultContent();
        System.out.println(driver.findElement(By.xpath("//div[@class='example']//h3"))
                .getText());*/

        //4. Switch back to the Nested frames
        int countOfTheFrames = driver.findElements(By.tagName("frame")).size();
        System.out.println("Number of Frames:" + countOfTheFrames);
    }

    public void closeBrowser() {
        driver.quit();
    }

    public static void main(String[] args) {
        // Create an instance of FrameHandler
        FrameHandler frameHandler = new FrameHandler();

        /*// 1. Launch the application for iframe
        frameHandler.driver.get("https://the-internet.herokuapp.com/iframe");*/
        // 2. Launch the application for nested iframes
        frameHandler.driver.get("https://the-internet.herokuapp.com/nested_frames");

        // Perform frame operations
        frameHandler.performFrameOperations();

        // Close the browser
        frameHandler.closeBrowser();
    }
}
