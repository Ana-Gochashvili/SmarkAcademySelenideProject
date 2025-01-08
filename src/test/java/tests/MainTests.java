package tests;

import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BaseAuth;

public class MainTests extends BaseAuth {
    @Test(description = "Check main page details")
    public void checkMainPageDetails() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(mainPageSteps.getBannersNumber(), 3, "Incorrect size!");

        SelenideElement pharmacy = mainPageSteps.getPharmacyBanner();
        softAssert.assertTrue(mainPageSteps.getBannersBackgroundColor(pharmacy).equals("rgba(101, 163, 48, 1)"), "Incorrect 'pharmacy' banner color!");

        SelenideElement familyCare = mainPageSteps.getFamilyCareBanner();
        softAssert.assertTrue(mainPageSteps.getBannersBackgroundColor(familyCare).equals("rgba(231, 179, 0, 1)"), "Incorrect 'family care' banner color!");

        SelenideElement beauty = mainPageSteps.getBeautyBanner();
        softAssert.assertTrue(mainPageSteps.getBannersBackgroundColor(beauty).equals("rgba(198, 1, 127, 1)"), "Incorrect 'beauty' banner color!");

        mainPageSteps.checkBasketButton();
        mainPageSteps.goToBasket();

        authorizationPopUpSteps.checkAuthorizationPopUpTitle();
        softAssert.assertAll();
    }
}
