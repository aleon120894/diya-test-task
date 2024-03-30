package utils


class BasePage {

    protected Appium driver;

    public AppiumDriver getDriver() {
        return this.driver;
    }

    public void setDriver() {
        this.driver = new AppiumDriver();
    }
}