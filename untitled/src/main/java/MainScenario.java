import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import java.net.MalformedURLException;
import java.net.URL;

import pages.DocumentsPage;
import pages.LoginPage;
import users.InvalidUser;
import users.ValidUser;

public class MainScenario {

    WebDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "package");
        caps.setCapability("appActivity", "activity");

        URL appiumServerURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(appiumServerURL, caps);
    }

    @Test
    public void logIn() {

        LoginPage page = new LoginPage();
        ValidUser user = new ValidUser();

        MainPage main = new MainPage();
        page.logIn(user.getPassword());
    }

    @Test
    public void goToDocuments(){
        MainPage page = new MainPage();
        page.goToDocuments();
    }

    @Test
    public void iterateDocuments() {

        DocumentsPage page = new DocumentsPage();
        page.checkPassport();

        page.checkForeignPassport();
        page.checkCertificate();
    }

    @Test
    public void logOut() {
        MainPage page = new MainPage();
        page.logOut();
    }

    @Test
    public void logInInvalidUser() {

        InvalidUser user = new InvalidUser();
        LoginPage page = new LoginPage();

        page.autorize(user.getPassword());
        Assert.hasText("Invalid Password", page.getWarningMessage());
    }

    @Test
    public void logInWithBankId() {

        ValidUser user = new ValidUser();
        LoginPage page = new LoginPage();
        MainPage main = new MainPage();

        page.autorizationWithBankId(user.getBankId());
        Assert.hasText(main.getHello(), "Hello");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
