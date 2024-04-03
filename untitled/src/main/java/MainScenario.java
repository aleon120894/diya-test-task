import com.google.common.annotations.VisibleForTesting;
import org.springframework.util.Assert;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import pages.DocumentsPage;
import pages.LoginPage;
import pages.MainPage;
import users.InvalidUser;
import users.ValidUser;

public class MainScenario {

    @BeforeTest
    public void setUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "your_app_package");
        caps.setCapability("appActivity", "your_app_activity");

        URL appiumServerURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(appiumServerURL, caps);
    }

    @Test
    public void logIn() {

        LoginPage page = new LoginPage();
        ValidUser user = new ValidUser();
        MainPage main = new MainPage();

        page.autorize(user.getPassword());
        Assert.hasText(main.getDocuments(), "Documents");
    }

    @Test
    public void goToDocuments(){

        MainPage page = new MainPage();
        DocumentsPage documents = new DocumentsPage();

        page.watchDocuments();
        Assert.hasText(documents.getDocument(), "Documents");
    }

    @Test
    public void iterateDocuments() {

        DocumentsPage page = new DocumentsPage();

        page.iterateDocuments();
        Assert.hasText(page.getDocument(), "Document");
    }

    @Test
    public void logOut() {

        MainPage page = new MainPage();

//        page.logOut();
        Assert.hasText(page, "login");
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
