package com.lambdatest.appium.sample;

import static java.text.MessageFormat.format;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import com.lambdatest.appium.sample.enums.Environment;
import com.lambdatest.appium.sample.utils.Swipe;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;

// 1.
public class BaseTest<D extends AppiumDriver<MobileElement>> {
    // 2.
    protected static final String LT_KEY  = System.getenv ("LT_ACCESS_KEY");
    protected static final String LT_USER = System.getenv ("LT_USERNAME");

    // 3.
    protected D driver;
    protected AppiumDriverLocalService service;
    protected Swipe<D> swipe;
    protected WebDriverWait wait;

    // 4.
    @AfterTest (alwaysRun = true)
    public void tearDown (final ITestContext context) {

        if (Environment.valueOf (context.getCurrentXmlTest ()
                .getParameter ("environment")) == Environment.CLOUD) {
            final var status = (context.getFailedTests ()
                    .size () > 0) ? "failed" : "passed";
            this.driver.executeScript (format ("lambda-status={0}", status));
        }

        this.driver.quit ();

        if (this.service != null && this.service.isRunning ()) {
            this.service.stop ();
        }
    }

    // 5.
    protected Capabilities getOptions (final Environment environment, final String platform, final String deviceName,
                                       final String version, final String appKey) {
        final var app = environment == Environment.CLOUD
                ? System.getenv (appKey)
                : System.getProperty ("user.dir") + appKey;
        final DesiredCapabilities capabilities = new DesiredCapabilities ();
        capabilities.setCapability (CapabilityType.PLATFORM_NAME, platform);
        capabilities.setCapability (MobileCapabilityType.PLATFORM_VERSION, version);
        capabilities.setCapability (MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability (MobileCapabilityType.APP, app);
        if (environment == Environment.CLOUD) {
            setCapabilitiesForCloud (capabilities, platform);
        } else {
            if (platform.equalsIgnoreCase ("Android")) {
                setCapabilitiesForLocalAndroid (capabilities, deviceName);
            }
        }
        return capabilities;
    }

    // 6.
    protected URL getUrl (final Environment environment) throws MalformedURLException {

        if (environment == Environment.CLOUD) {
            return new URL (format ("https://{0}:{1}@mobile-hub.lambdatest.com/wd/hub", LT_USER, LT_KEY));
        }

        if (this.service != null && this.service.isRunning ()) {
            return this.service.getUrl ();
        }

        return new URL ("http://localhost:4723/wd/hub");
    }

    // 7.
    protected void startServer (final Environment environment, final boolean isAutomatic) {
        if (!isAutomatic || environment == Environment.CLOUD) {
            return;
        }

        final AppiumServiceBuilder builder = new AppiumServiceBuilder ();

        builder.withIPAddress ("127.0.0.1")
                .usingPort (4723)
                .withAppiumJS (
                        new File ("/path/to/.nvm/versions/node/v16.15.0/lib/node_modules/appium/build/lib/main.js"))
                .withLogFile (new File (System.getProperty ("user.dir") + "/logs/appium.log"))
                .withArgument (GeneralServerFlag.LOG_LEVEL, "info")
                .withArgument (GeneralServerFlag.SESSION_OVERRIDE);

        this.service = AppiumDriverLocalService.buildService (builder);
        this.service.start ();
    }

    private void setCapabilitiesForCloud (final DesiredCapabilities capabilities, final Object platform) {
        capabilities.setCapability ("project", "LambdaTest project");
        capabilities.setCapability ("build", format ("TestNG {0} Sample Build", platform));
        capabilities.setCapability ("name", format ("{0} Test Case", platform));
        capabilities.setCapability ("console", true);
        capabilities.setCapability ("network", true);
        capabilities.setCapability ("visual", true);
        capabilities.setCapability ("video", true);
        capabilities.setCapability ("terminal", true);
        capabilities.setCapability ("devicelog", true);
        capabilities.setCapability ("isRealMobile", true);
    }

    private void setCapabilitiesForLocalAndroid (final DesiredCapabilities capabilities, final String deviceName) {
        capabilities.setCapability (AndroidMobileCapabilityType.AVD, deviceName);
        capabilities.setCapability (MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
    }
}
