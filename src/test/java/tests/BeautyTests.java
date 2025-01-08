package tests;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import steps.BeautyPageSteps;
import utils.BaseAuth;

public class BeautyTests extends BaseAuth {
    protected BeautyPageSteps beautyPageSteps;

    @BeforeMethod(description = "Opens Beauty page")
    public void goToCosmeticsAndHygieneProducts() {
        beautyPageSteps = mainPageSteps.goToBeautyPage();
    }

    @Test(description = "Checks filter on Beauty page")
    public void checkBeautyPageDetails() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(beautyPageSteps.getPageTitle(), "კოსმეტიკა და ჰიგიენის საშუალებები", "Incorrect Title!");
        softAssert.assertFalse(beautyPageSteps.checkSelectFilterButton(), "Select button should be disabled!");

        beautyPageSteps.clickSliderRoundButton()
                .checkSliderRoundButton();
        beautyPageSteps.selectCategoryCheckbox();

        softAssert.assertTrue(beautyPageSteps.checkCategoryCheckbox(), "Category Checkbox should be checked!");

        beautyPageSteps.inputMinPrice(50)
                .inputMaxPrice(70);

        softAssert.assertTrue(beautyPageSteps.checkSelectFilterButton(), "Select button should be enabled!");

        beautyPageSteps.clickSelectFilterButton();
        beautyPageSteps.checkAllDiscountedProduct();
        beautyPageSteps.checkClearFilterButton();
        beautyPageSteps.clickClearFilterButton();

        softAssert.assertFalse(beautyPageSteps.checkSelectFilterButton(), "Select button should be deactivated!");
        softAssert.assertFalse(beautyPageSteps.checkCategoryCheckbox(), "Category Checkbox should be unchecked!");
        softAssert.assertAll();
    }
}
