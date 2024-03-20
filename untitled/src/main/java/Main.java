import org.springframework.*;

public class Main {

    MainScenario tests = new MainScenario();

    public void run() {

        tests.logIn();
        tests.goToDocuments();
        tests.logOut();
    }
}
