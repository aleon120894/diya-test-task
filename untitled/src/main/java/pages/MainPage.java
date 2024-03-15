package pages;

import org.openqa.selenium.By;

public class MainPage {

    AppiumDriver driver = new AppiumDriver(
            // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
            new URL("http://127.0.0.1:4723"));


    private WebElement hello;
    private WebElement news;
    private WebElement qrCode;
    private WebElement documents;

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

    public void setHello() {
        hello = driver.findElement(By.ByClassName("hello"));
    }

    public void setNews() {

        news = driver.findElement(By.ByClassName("news"));
    }

    public void setQrCode() {

        qrCode = driver.findElement(By.ByClassName("qr"));
    }

    public void setDocuments() {

        documents = driver.findElement(By.ByClassName("documents"));
    }


    public void watchNews() {

        news.click();
    }

    public void watchDocuments() {
        documents.click();
    }

}
