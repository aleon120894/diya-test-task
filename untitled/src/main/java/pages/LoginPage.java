package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.util.Assert;

public class LoginPage {

    AppiumDriver driver = new AppiumDriver(
            // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
            new URL("http://127.0.0.1:4723"));

    private WebElement passwordField;
    private WebElement warningMessage;

    public WebElement getPasswordField() {

        return this.passwordField;
    }

    public WebElement getWarningMessage() {
        return this.warningMessage;
    }

    public void setPasswordField() {

        this.passwordField = driver.findElement(By.ByClassName("password"));
    }

    public void setWarningMessage() {
        this.warningMessage = driver.findElement(By.ByClassName("warning"))
    }


    public void autorize(String keys) {

        passwordField.sendKeys(keys);
        Assert.hasText(passwordField, keys);
    }
}
