package seleniumTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Pechkin.PromoPage;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class PromoPageSmokeTest extends seleniumTests.AbstractTest {

    private static final String expectedHeaderTitleText = "Сервис рассылки email, аналог программы для рассылки писем по email - Pechkin-mail.ru";

    private static final String expectedHeaderTextTitleFailure = "Actual Header Title text doesn't equal expected Header text\n";

    private static final String expectedLogoFailure = "Expected logo not found\n";

    private static final String expectedDescriptionMetaContent = "Сервис почтовых рассылок Печкин-mail позволят быстро настроить массовую рассылку, оформить красиво письмо и эффективно разослать Вашим клиентам, минуя спам-фильтр. Есть бесплатная версия!";

    private static final String expectedDescriptionMetaContentFailure = "Expected description meta content not found\n";

    @BeforeTest
    public void before() {
        goToPage(PromoPage.PATH);
    }

    @Test(suiteName = "Smoke Test", testName = "Test 1; Header testing;")
    public void smokeTest1() {
        PromoPage promoPage = PromoPage.initPage(PromoPage.class);
        assertEquals(expectedHeaderTextTitleFailure, expectedHeaderTitleText,
                getWebDriver().
                        getDriver().
                        getTitle().toString());
    }

    @Test(suiteName = "Smoke Test", testName = "Test 2; Logo testing;")
    public void smokeTest2() {
        PromoPage promoPage = PromoPage.initPage(PromoPage.class);
        assertFalse((promoPage.getLogo() == null),
                expectedLogoFailure);
    }

    @Test(suiteName = "Smoke Test", testName = "Test 3; Description meta test;")
    public void smokeTest3() {
        PromoPage promoPage = PromoPage.initPage(PromoPage.class);
        assertFalse(promoPage.getDescriptionMetaContent() == expectedDescriptionMetaContent,
                expectedDescriptionMetaContentFailure);
    }

}
