package pages;

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
        hello = driver.findElement();
    }

    public void setNews() {
        news = driver.findElement();
    }

    public void setQrCode() {
        qrCode = driver.findElement();
    }

    public void setDocuments() {
        documents = driver.findElement();
    }


    public void watchNews() {
        news.click();
    }

}
