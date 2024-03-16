package pages;

import org.openqa.selenium.By;
import org.springframework.util.Assert;

public class MainPage {

    AppiumDriver driver = new AppiumDriver(
            // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
            new URL("http://127.0.0.1:4723"));


    private WebElement hello;
    private WebElement news;
    private WebElement qrCode;
    private WebElement documents;

    private WebElement logOutButton;

    public WebElement getHello() {
        return hello;
    }

    public WebElement getNews() {
        return news;
    }

    public WebElement getQrCode() {
        return qrCode;
    }

    public WebElement getDocuments() {
        return documents;
    }

    public WebElement getLogOutButton() {
        return logOutButton;
    }

    public void setHello() {
        hello = driver.findElement(By.ByClassName("hello"));
    }

    public void setNews() {

        this.news = driver.findElement(By.ByClassName("news"));
    }

    public void setQrCode() {

        this.qrCode = driver.findElement(By.ByClassName("qr"));
    }

    public void setDocuments() {

        this.documents = driver.findElement(By.ByClassName("documents"));
    }

    public void setLogOutButton() {
        this.logOutButton = driver.findElement(By.ByClassName("logout"))
    }


    public void watchNews() {

        news.click();
        Assert.hasText(documents, "documents");
    }

    public void watchDocuments() {

        documents.click();
        Assert.hasText(documents, "Documents");
    }

    public void logOut() {

        logOutButton.click();
        Assert.hasText(logOutButton, "log in");
    }

}
