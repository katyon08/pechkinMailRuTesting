package drivers;

import TOR.TOROperator;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class BrowserDriverCloser {

    private BrowserDriverCloser() {
    }

    public static void close(BrowserDriver browserDriver) throws BrowserNotFoundException, NotImplementedException {
        if (browserDriver.browser == Browser.FIREFOX) {
            browserDriver.driver.close();
        } else if (browserDriver.browser == Browser.OPERA) {
            throw new NotImplementedException();
        } else if (browserDriver.browser == Browser.CHROME) {
            throw new NotImplementedException();
        } else if (browserDriver.browser == Browser.BUNDLE) {
            browserDriver.driver.close();
            TOROperator.killFirefox();
        } else throw new BrowserNotFoundException();
    }
}
