package pages.YOPmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class YOPMailMainPage extends AbstractPage {
    public static final String PATH = "http://www.yopmail.com/en/";

    private final static String addressXpath = "//*[@id='login']";

    private static String confirmLink;

    private final static String inBoxIframeXpath = "//*[@id='ifinbox']";

    private final static String emailFrameXpath = "//*[@id='ifmail']";

    private final static String submitButtonXpath = "/html/body/center/div/div/div[3]/table[3]/tbody/tr/td[1]/table/tbody/tr[3]/td/div[1]/form/table/tbody/tr[1]/td[3]/input";

    private final static String lastEmailXPath = "//div[@class = 'm'][1]";

    private final static String confirmButtonXpath = "/html/body/div/div[3]/div[2]/center/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr/td/a";

    @FindBy(xpath = addressXpath)
    private static WebElement address;

    @FindBy(xpath = submitButtonXpath)
    private static WebElement submitButton;

    public static WebElement getAddress() {
        return address;
    }

    public static WebElement getSubmitButton() {
        return submitButton;
    }

    public static void initialLastEmail() {
        getBrowserDriver().
                getDriver().
                switchTo().
                frame(
                        getBrowserDriver().
                                getDriver().
                                findElement(
                                        By.
                                                xpath(inBoxIframeXpath)));
        getBrowserDriver().
                getDriver().
                findElement(
                        By.xpath(lastEmailXPath)).
                click();
        getBrowserDriver().
                getDriver().
                switchTo().
                defaultContent();
    }

    public static void accessConfirmation() {
        getBrowserDriver().
                getDriver().
                switchTo().
                frame(
                        getBrowserDriver().
                                getDriver().
                                findElement(
                                        By.xpath(emailFrameXpath)));
        confirmLink =
                getBrowserDriver().
                        getDriver().
                        findElement(
                                By.xpath(confirmButtonXpath)).getAttribute("href");
        getBrowserDriver().
                getDriver().
                switchTo().
                defaultContent();
        getBrowserDriver().
                getDriver().
                navigate().to(confirmLink);
    }
}
