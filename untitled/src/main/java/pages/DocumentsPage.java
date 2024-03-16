package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class DocumentsPage {
    AppiumDriver driver = new AppiumDriver();

    private WebElement document;

    public WebElement getDocument() {
        return document;
    }

    public void setDocument() {
        this.document = driver.findElement(By.ByClassName("document"));
    }
}
