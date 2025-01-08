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

        familyCarePageSteps.clickOrderItemsByChoiceButton().selectOrderItemsByChoiceButton();
        softAssert.assertEquals(familyCarePageSteps.getOrderItemsByText(), "ფასი კლებადობით", "Incorrect text!");
        softAssert.assertAll();
    }
}
