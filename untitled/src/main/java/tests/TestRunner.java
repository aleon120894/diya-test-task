package tests;

public class TestRunner {
    BaseOptions options = new BaseOptions()
            .setPlatformName("myplatform")
            .setAutomationName("mydriver")
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
