import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.util.Assert;
import pages.DocumentsPage;

public class MainPage {


    public MainPage(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "banner")
    @iOSFindBy(xpath = "banner")
    private MobileElement banner;

    @AndroidFindBy(id = "hello_banner")
    @iOSFindBy(xpath = "//XCUIElementTypeSecureTextField[@name='hello_banner']")
    private MobileElement hello;

    @AndroidFindBy(id = "documents")
    @iOSFindBy(xpath = "//XCUIElementTypeSecureTextField[@name='documents']")
    private MobileElement documents;

    @AndroidFindBy(id="logOut")
    @iOSFindBy(xpath="//XCUIElementTypeSecureTextField[@name='logOut']")
    private MobileElement logOutBtn;

    public void goToDocuments() {

        DocumentsPage documentsPage = new DocumentsPage();
        documents.click();
        Assert.hasText(documentsPage.documents.getText, "Documents");
    }

    public void logOut() {
        logOutBtn.click();
    }
}

