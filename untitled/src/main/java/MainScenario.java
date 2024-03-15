import com.google.common.annotations.VisibleForTesting;
import org.springframework.util.Assert;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import pages.LoginPage;
import pages.MainPage;

public class MainScenario {

    @BeforeClass
    public void setDriver() {
        BaseOptions options = new BaseOptions()

                .setPlatformName("AndroidApp")
                .setAutomationName("appiumdriver")

                .amend("mycapability1", "capvalue1")
                .amend("mycapability2", "capvalue2");
        AppiumDriver driver = new AppiumDriver(
                // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
                new URL("http://127.0.0.1:4723"), options
        );
        try {
            WebElement el = driver.findElement(AppiumBy.className, "myClass");
            el.click();
            driver.getPageSource();
        } finally {
            driver.quit();
        }
    }

    @Test
    public void logIn() {

        LoginPage page = new LoginPage();
        page.autorize('0325');
        Assert.assertEquals();
    }

    @Test
    public void goToDocuments(){
        MainPage page = new MainPage();

        page.watchDocuments();
        Assert.assertEquals();
    }
}
