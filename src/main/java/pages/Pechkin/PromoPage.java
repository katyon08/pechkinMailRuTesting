package pages.Pechkin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class PromoPage extends AbstractPage {

    public final static String PATH = "https://pechkin-mail.ru/promo/";

    private final static String headerTitleCSS = "html > head[lang='ru'] > title"; //#marker1#

    private final static String headerTitleXPath = "/html/head[@lang='ru']/title[1]"; //#marker1#

    private final static String logoXPath = "//img[@src='images/logo-sign.png']";

    private final static String descriptionMetaXPath = "/html/head[@lang='ru']/meta[@name='description']";

    @FindBy(xpath = headerTitleXPath)
    private WebElement headerTitle;

    @FindBy(xpath = logoXPath)
    private WebElement logo;

    @FindBy(xpath = descriptionMetaXPath)
    private WebElement descriptionMeta;

    public String getHeaderTitle() { //#marker2#
        return headerTitle.getText();
    }

    public WebElement getLogo() {
        return logo;
    }

    public String getDescriptionMetaContent() {
        return descriptionMeta.getAttribute("content");
    }

}
