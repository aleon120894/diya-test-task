import  org.testng.*;

class Main {

    MainScenario scenario = new MainScenario();

    public static void main(String[] args) {

        @Override
        public TestRunner newTestRunner(ISuite suite, XmlTest test,
                Collection<IInvokedMethodListener> listeners, List<IClassListener> classListeners,
                Map<Class<? extends IDataProviderListener>,IDataProviderListener> dataProviderListeners) {
            TestRunner testRunner;
            if (target instanceof ITestRunnerFactory2) {
                testRunner = ((ITestRunnerFactory2)target).newTestRunner(suite, test, listeners, classListeners, dataProviderListeners);
            } else {
                testRunner = target.newTestRunner(suite, test, listeners, classListeners);
            }
            testRunner.addListener(new TextReporter(testRunner.getName(), TestRunner.getVerbose()));

            for (ITestListener itl : failureGenerators) {
                testRunner.addListener(itl);
            }
            
            return testRunner;
        }
    };

}
