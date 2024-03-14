import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MainPage;

public class MainScenario {

    @Test
    public void logIn() {
        //
        LoginPage page = new LoginPage();
        page.autorize('0325');
        Assert.assertEquals();
    }
}
