package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Element locators using @AndroidFindBy and @iOSFindBy annotations
    @AndroidFindBy(id = "com.example.app:id/usernameField")
    @iOSFindBy(xpath = "//XCUIElementTypeTextField[@name='username']")
    private MobileElement usernameField;

    @AndroidFindBy(id = "passwordField")
    @iOSFindBy(xpath = "//XCUIElementTypeSecureTextField[@name='password']")
    private MobileElement passwordField;

    @AndroidFindBy(id = "com.example.app:id/loginButton")
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Login']")
    private MobileElement loginButton;

    // Methods to interact with the elements
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
