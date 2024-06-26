import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.DocumentsPage;
import pages.ServicesPage;

public class MainPage {


    public MainPage(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "banner")
    @iOSFindBy(xpath = "//XCUIElementTypeSecureTextField[@name='banner']")
    private MobileElement banner;

    @AndroidFindBy(id = "hello_banner")
    @iOSFindBy(xpath = "//XCUIElementTypeSecureTextField[@name='hello_banner']")
    private MobileElement hello;

    @AndroidFindBy(id = "documents")
    @iOSFindBy(xpath = "//XCUIElementTypeSecureTextField[@name='documents']")
    private MobileElement documents;

    @AndroidFindBy(id = "services")
    @iOSFindBy(xpath = "//XCUIElementTypeSecureTextField[@name='services']")
    private MobileElement services;

    @AndroidFindBy(id="log_out")
    @iOSFindBy(xpath="//XCUIElementTypeSecureTextField[@name='log_out']")
    private MobileElement logOutBtn;

    public void goToDocuments() {
        DocumentsPage documentsPage = new DocumentsPage();
        documents.click();
        Assert.hasText(documentsPage.documents.getText, "DOCUMENTS");
    }

    public void goToServices() {
        ServicesPage page = new ServicesPage();
        services.click();
        page.checkBanner("SERVICES");
    }

    public void logOut() {
        logOutBtn.click();
    }
}

