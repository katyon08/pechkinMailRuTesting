package seleniumTests;

import org.testng.annotations.BeforeTest;
import pages.PromoPage;

/**
 * Created by katyon08 on 15.11.2015.
 */
public class TwitterTest extends AbstractTest {
    @BeforeTest
    public void before() {
        getWebDriver().navigate().to(TwitterPage.PATH);
    }

}
