package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.example.app:id/usernameField")
    @iOSFindBy(xpath = "//XCUIElementTypeTextField[@name='username']")
    private MobileElement usernameField;

    @AndroidFindBy(id = "passwordField")
    @iOSFindBy(xpath = "//XCUIElementTypeSecureTextField[@name='password']")
    private MobileElement passwordField;

    @AndroidFindBy(id = "com.example.app:id/loginButton")
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name='login']")
    private MobileElement loginButton;


    public void logIn(String login, String password) {

        MainPage main = new MainPage();
        usernameField.sendKeys(login);
        passwordField.sendKeys(password);

        loginButton.click();
        Assert.hasText(main.documents.getText, "Documents");
    }
}
