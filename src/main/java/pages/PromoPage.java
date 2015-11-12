package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by katyon08 on 12.11.2015.
 */
public class PromoPage extends AbstractPage {

    public final static String PATH = "https://pechkin-mail.ru/promo/";

    private final static String headerTitleCSS = "html > head[lang='ru'] > title";
    private final static String headerTitleXPath = "/html/head[@lang='ru']/title[1]";
    private final static String logoXPath = "//img[@src='images/logo-sign.png']";
    private final static String descriptionMetaXPath = "/html/head[@lang='ru']/meta[@name='description']";

    @FindBy(css = headerTitleCSS)
    private WebElement headerTitle;

    @FindBy(xpath = logoXPath)
    private WebElement logo;

    @FindBy(xpath = descriptionMetaXPath)
    private WebElement descriptionMeta;

    public String getHeaderTitle() {
        return headerTitle.getText();
    }

    public WebElement getLogo() {
        return logo;
    }

    public String getDescriptionMetaContent() {
        return descriptionMeta.getAttribute("content");
    }

}
