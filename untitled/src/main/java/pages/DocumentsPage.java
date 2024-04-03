package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DocumentsPage {
    AppiumDriver driver = new AppiumDriver();

    private MobileElement document;
    private MobileElement documents;

    public MobileElement getDocument() {

        return document;
    }

    public void setDocument() {
        this.document = driver.findElement(By.ByClassName("document"));
    }

    public MobileElement getDocuments() {
        return documents;
    }

    public void setDocuments() {
        this.documents = driver.findElements(By.ByClassName("document[i]"));
    }

    public void iterateDocuments() {

        WebElement documentName = driver.findElement(By.className("name"));

        for (MobileElement doc; documents;) {

            doc.click();
            Assert.assertEquals(documentName, doc);
            doc.swipe();
        };
    }
}
