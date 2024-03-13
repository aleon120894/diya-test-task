package tests;

import io.appium.java_client.AppiumDriver;

public class Elements{

    AppiumDriver driver = new AppiumDriver();

    WebElement loginField = driver.findElement();
    WebElement passwordField = driver.findElement();
    WebElement submitButton = driver.findElement();

}
