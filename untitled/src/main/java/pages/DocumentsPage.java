package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DocumentsPage {

    public MobileElement LoginPage(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.example.app:id/passport")
    @iOSFindBy(xpath = "//XCUIElementTypeTextField[@name='passport']")
    private MobileElement passport;

    @AndroidFindBy(id = "foreignPassport")
    @iOSFindBy(xpath = "//XCUIElementTypeSecureTextField[@name='foreignPassport']")
    private MobileElement foreignPassport;

    @AndroidFindBy(id = "com.example.app:id/certificate")
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Certificate']")
    private MobileElement certicficate;

    // Methods to interact with the elements

    public void checkPassport() {
        //
    }

    public void checkForeignPassport() {
        //
    }

    public void checkCertificate() {
        //
    }
}
