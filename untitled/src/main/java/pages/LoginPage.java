package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.util.Assert;

public class LoginPage {

    AppiumDriver driver = new AppiumDriver(
            new URL("http://127.0.0.1:4723"));

    private WebElement passwordField;
    private WebElement warningMessage;
    private WebElement bankIdField;

    public WebElement getPasswordField() {

        return this.passwordField;
    }

    public WebElement getWarningMessage() {

        return this.warningMessage;
    }

    public WebElement getBankIdField() {
        return this.bankIdField;
    }

    public void setPasswordField() {

        this.passwordField = driver.findElement(By.ByClassName("password"));
    }

    public void setWarningMessage() {

        this.warningMessage = driver.findElement(By.ByClassName("warning"));
    }

    public void setBankIdField() {
        this.bankIdField = driver.findElement(By.ByClassName("bank-id"));
    }

    public void autorize(String keys) {

        passwordField.sendKeys(keys);
        Assert.hasText(passwordField, keys);
    }

    public void autorizationWithBankId(String bankId) {

        bankIdField.sendKeys(bankId);
        Assert.hasText(bankIdField, bankId);
    }
}
