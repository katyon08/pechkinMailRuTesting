package drivers;

import TOR.TOROperator;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class BrowserDriverCloser {

    private BrowserDriverCloser() {
    }

    public static void close(BrowserDriver browserDriver) throws BrowserNotFoundException, NotImplementedException {
        if (browserDriver.getBrowser() == Browser.FIREFOX) {
            browserDriver.getDriver().close();
            browserDriver.getDriver().quit();
        } else if (browserDriver.getBrowser() == Browser.OPERA) {
            throw new NotImplementedException();
        } else if (browserDriver.getBrowser() == Browser.CHROME) {
            throw new NotImplementedException();
        } else if (browserDriver.getBrowser() == Browser.BUNDLE) {
            browserDriver.getDriver().close();
            TOROperator.killFirefox();
        } else throw new BrowserNotFoundException();
    }
}
