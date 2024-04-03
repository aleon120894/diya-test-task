import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    // Constructor
    public MainPage(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Element locators using @AndroidFindBy and @iOSFindBy annotations
    @AndroidFindBy(id = "banner")
    @iOSFindBy(xpath = "banner")
    private MobileElement banner;

    @AndroidFindBy(id = "hello")
    @iOSFindBy(xpath = "//XCUIElementTypeSecureTextField[@name='hello']")
    private MobileElement hello;
}

