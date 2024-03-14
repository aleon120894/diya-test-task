package pages;

public class LoginPage {

    AppiumDriver driver = new AppiumDriver(
            // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
            new URL("http://127.0.0.1:4723"));

    private WebElement passwordField;

    public WebElement getPasswordField() {
        return passwordField;
    }

    public void setPasswordField() {
        this.passwordField = driver.findElement();
    }


    public void autorize(String keys) {
        passwordField.sendKeys(keys);
    }
}
