package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import steps.FamilyCarePageSteps;
import utils.BaseAuth;


public class FamilyCareTests extends BaseAuth {
    protected FamilyCarePageSteps familyCarePageSteps;

    @BeforeMethod(description = "Opens family Care page")
    public void goToCosmeticsAndHygieneProducts() {
        familyCarePageSteps = mainPageSteps.goToFamilyCarePage();
    }

    @Test(description = "Checks filter on Beauty page")
    public void checkBeautyPageDetails() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(familyCarePageSteps.getPageTitle(), "დედა და ბავშვი", "Incorrect Title!");
        familyCarePageSteps.selectCategoryCheckbox();

        softAssert.assertTrue(familyCarePageSteps.checkCategoryCheckbox(), "Category Checkbox should be checked!");
        softAssert.assertTrue(familyCarePageSteps.checkSelectFilterButton(), "Select button should be enabled!");

        familyCarePageSteps.clickSelectFilterButton();
        familyCarePageSteps.clickNumberOfItemOnPageButton().selectNumberOfItemOnPage();
        softAssert.assertEquals(familyCarePageSteps.getNumberOfItemOnPage(), "40", "Incorrect number!");

        familyCarePageSteps.clickOrderItemsByChoiceButton().selectOrderItemsByPriceASC();
        softAssert.assertEquals(familyCarePageSteps.getOrderItemsByText(), "ფასი ზრდადობით", "Incorrect text!");
        softAssert.assertEquals(familyCarePageSteps.getFilteredProductSize(), 40, "Incorrect size!");
        softAssert.assertEquals(familyCarePageSteps.getFilteredProductPrices().get(0), familyCarePageSteps.getFilteredMinimumPrice(familyCarePageSteps.getFilteredProductPrices()), "First filtered product should have minimum price!");

        softAssert.assertEquals(familyCarePageSteps.getFilteredProductPrices().get(familyCarePageSteps.getFilteredProductPrices().size() - 1),
                familyCarePageSteps.getFilteredMaximumPrice(familyCarePageSteps.getFilteredProductPrices()), "Last filtered product should have maximum price!");
        softAssert.assertAll();
    }
}
