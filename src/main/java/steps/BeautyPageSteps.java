package steps;

import static com.codeborne.selenide.Selenide.sleep;
import elements.BeautyPage;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;


public class BeautyPageSteps extends BeautyPage {
    @Step("Return page title")
    public String getPageTitle() {
        return title.should(be(visible), Duration.ofSeconds(20))
                .getText();
    }

    @Step("Click slider button")
    public BeautyPageSteps clickSliderRoundButton() {
        sliderRoundButton.click();
        return this;
    }

    @Step("Check slider rounded button")
    public void checkSliderRoundButton() {
        sliderRoundButtonCheckbox.should(be(checked));
    }

    @Step("Select category checkbox")
    public void selectCategoryCheckbox() {
        yaeCareCategory.click();
    }

    @Step("Check category checkbox")
    public boolean checkCategoryCheckbox() {
        return yaeCareCategoryCheckbox.isSelected();
    }

    @Step("Input minimum price")
    public BeautyPageSteps inputMinPrice(double price) {
        minPrice.setValue(String.valueOf(price));
        return this;
    }

    @Step("Input maximum price")
    public void inputMaxPrice(double price) {
        maxAPrice.setValue(String.valueOf(price));
    }

    @Step("Return select filter button")
    public boolean checkSelectFilterButton() {
        return selectFilterButton.is(enabled);
    }

    @Step("Clicks select filter button")
    public void clickSelectFilterButton() {
        selectFilterButton.click();
    }

    @Step("Checks All Discounted Products")
    public void checkAllDiscountedProduct() {
        sleep(5000);

        //   products.shouldHave(sizeGreaterThanOrEqual(1), Duration.ofSeconds(50));

        products.forEach(el -> {
            String label = el.$(".product__discount-label").getText();
            Assert.assertTrue(label.matches("-\\d+%"),
                    "Incorrect discount label format: " + label);
        });
    }

    @Step("Checks Clear Filter Button")
    public void checkClearFilterButton() {
        clearFilterButton.shouldBe(visible, enabled, clickable);
    }

    @Step("Clicks Clear Filter Button")
    public void clickClearFilterButton() {
        clearFilterButton.click();
    }


}
