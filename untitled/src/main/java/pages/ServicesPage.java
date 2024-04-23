package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.util.Assert;

public class ServicesPage {

    public ServicesPage(WebDriver driver) { PageFactory.initElements(new AppiumFieldDecorator(driver), this); }

    @AndroidFindBy(id = "banner")
    @iOSFindBy(xpath = "//XCUIElementTypeTextField[@name='banner']")
    private MobileElement banner;

    public void checkBanner(String bannerName) {
        banner.click();
        Assert.hasText(banner, bannerName);
    }
}
