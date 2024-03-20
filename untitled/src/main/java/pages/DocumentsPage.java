package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.springframework.util.Assert;

public class DocumentsPage {
    AppiumDriver driver = new AppiumDriver();

    private WebElement document;
    private WebElements documents;

    public WebElement getDocument() {

        return document;
    }

    public void setDocument() {
        this.document = driver.findElement(By.ByClassName("document"));
    }

    public WebElements getDocuments() {
        return documents;
    }

    public void setDocuments() {
        this.documents = driver.findElements(By.ByClassName("document[i]"));
    }

    public void iterateDocuments(String documentName) {

        for (WebElement doc,  in documents) {
            doc.click();
            Assert.hasText(d, documentName);
        }
    }
}
