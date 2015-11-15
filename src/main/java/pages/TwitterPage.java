package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by katyon08 on 15.11.2015.
 */
public class TwitterPage extends AbstractPage {

    public static final String PATH = "https://twitter.com/who_to_follow/suggestions";

    @FindBy();
    private WebElement item;

    @FindBy(xpath = "")
    private WebElement followButton;


}

