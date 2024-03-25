
class Main {

    MainScenario scenario = new MainScenario();

    public static void main(String[] args) {

        scenario.setDriver();
        scenario.logIn();
        scenario.goToDocuments();
        scenario.logOut();
    }

}
