package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TwitterPage extends AbstractPage {

    public static final String PATH = "https://twitter.com/who_to_follow/suggestions";


    @FindBy(xpath = "//[@class = 'user-actions-follow-button js-follow-btn follow-button btn']")
    private static List<WebElement> items;

    public static List<WebElement> getItems() {
        return items;
    }


}

