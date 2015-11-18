package seleniumTests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.PromoPage;
import pages.TwitterLoginPage;
import pages.TwitterPage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TwitterTest extends AbstractTest {
    //    @BeforeTest
    public void before() {
    }

    @Test
    public void submitTen() throws InterruptedException {
        getWebDriver().navigate().to(TwitterLoginPage.PATH);
//        Thread.sleep(10000);
        TwitterLoginPage.getLogin().sendKeys("hello");
        TwitterLoginPage.getPassword().sendKeys("world");
        TwitterLoginPage.getSubmit().click();
        getWebDriver().navigate().to(TwitterPage.PATH);
        for (WebElement item : TwitterPage.getItems()) {
            item.click();
        }
    }

}
