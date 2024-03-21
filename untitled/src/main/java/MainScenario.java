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

    @BeforeClass
    public void setDriver() {
        BaseOptions options = new BaseOptions()

                .setPlatformName("AndroidAppDiia")
                .setAutomationName("appiumdriver")

                .amend("mycapability1", "capvalue1")
                .amend("mycapability2", "capvalue2");
        AppiumDriver driver = new AppiumDriver(
                // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
                new URL("http://127.0.0.1:4723"), options
        );
    }

    @Test
    public void logIn() {

        LoginPage page = new LoginPage();
        ValidUser user = new ValidUser();

        page.autorize(user.getPassword());
        Assert.assertEquals();
    }

    @Test
    public void goToDocuments(){
        MainPage page = new MainPage();

        page.watchDocuments();
        Assert.assertEquals();
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

        page.logOut();
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

    @AdterClass
    public void quit() {
        driver.quit();
    }
}
