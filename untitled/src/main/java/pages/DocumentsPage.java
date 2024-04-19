package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DocumentsPage {

    public MobileElement LoginPage(WebDriver driver) {PageFactory.initElements(new AppiumFieldDecorator(driver), this); }

    @AndroidFindBy(id = "passport")
    @iOSFindBy(xpath = "//XCUIElementTypeTextField[@name='passport']")
    private MobileElement passport;

    @AndroidFindBy(id = "foreign_passport")
    @iOSFindBy(xpath = "//XCUIElementTypeSecureTextField[@name='foreign_passport']")
    private MobileElement foreignPassport;

    @AndroidFindBy(id = "certificate")
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name='certificate']")
    private MobileElement certificate;


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
