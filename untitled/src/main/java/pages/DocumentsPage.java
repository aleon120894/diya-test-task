package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.util.Assert;

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
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name='certificate']")
    private MobileElement certicficate;


    public void checkPassport() {
        passport.click();
        Assert.hasText(passport.getText(), "Passport");
    }

    public void checkForeignPassport() {
        foreignPassport.click();
        Assert.hasText(foreignPassport.getText(), "Foreign Passport");
    }

    public void checkCertificate() {
        certicficate.click();
        Assert.hasText(certicficate.getText(), "Certificate");
    }
}
