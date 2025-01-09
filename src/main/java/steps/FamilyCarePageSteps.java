package steps;

import elements.FamilyCarePage;
import io.qameta.allure.Step;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;

public class FamilyCarePageSteps extends FamilyCarePage {
    @Step("Return page title")
    public String getPageTitle() {
        return title.should(be(visible), Duration.ofSeconds(20))
                .getText();
    }

    @Step("Select category checkbox")
    public void selectCategoryCheckbox() {
        childrenCosmetics.click();
    }

    @Step("Check category checkbox")
    public boolean checkCategoryCheckbox() {
        return childrenCosmeticsCheckbox.isSelected();
    }

    @Step("Return select filter button")
    public boolean checkSelectFilterButton() {
        return selectFilterButton.is(enabled);
    }

    @Step("Clicks select filter button")
    public void clickSelectFilterButton() {
        selectFilterButton.shouldBe(enabled, visible, clickable)
                .click();
    }

    @Step("Clicks Number Of Item On Page Button")
    public FamilyCarePageSteps clickNumberOfItemOnPageButton() {
        dropdownButtons.get(0).scrollTo()
                .shouldBe(clickable)
                .click();
        return this;
    }

    @Step("Select Number Of Item On Page Button")
    public void selectNumberOfItemOnPage() {
        numberOfItem.find(attribute("value", "40"))
                .shouldBe(clickable, Duration.ofMinutes(1))
                .click();
    }

    @Step("Returns Number Of Item On Page")
    public String getNumberOfItemOnPage() {
        return numberOfItemValue.getText();
    }

    @Step("Clicks Order Items By Choice Button")
    public FamilyCarePageSteps clickOrderItemsByChoiceButton() {
        dropdownButtons.get(1).scrollTo()
                .shouldBe(clickable)
                .click();
        return this;
    }

    @Step("Selects Order Items By Price ASC")
    public void selectOrderItemsByPriceASC() {
        numberOfItem.find(attribute("value", "price_ASC"))
                .shouldBe(enabled, Duration.ofMinutes(1))
                .click();
    }

    @Step("Returns order by text")
    public String getOrderItemsByText() {
        return orderBy.getText();
    }

    @Step("Return Filtered Product Size")
    public int getFilteredProductSize() {
        return products.shouldHave(sizeGreaterThanOrEqual(40), Duration.ofMinutes(1))
                .size();
    }

    @Step("Return Filtered Product Prices")
    public ArrayList<Double> getFilteredProductPrices() {
        return products.shouldHave(sizeGreaterThanOrEqual(40), Duration.ofMinutes(1))
                .stream()
                .map(el -> {
                    String price = el.$(".product__price").scrollTo().getText();
                    return Double.parseDouble(price.substring(0, price.length() - 1));
                })
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Step("Return Filtered Products Minimum Price")
    public double getFilteredMinimumPrice(List<Double> arrayList) {
        double minNumber = arrayList.get(0);
        for (double myNumber : arrayList) {
            if (myNumber < minNumber)
                minNumber = myNumber;
        }
        return minNumber;
    }

    @Step("Return Filtered Products Maximum Price")
    public double getFilteredMaximumPrice(List<Double> arrayList) {
        double minNumber = arrayList.get(0);
        for (double myNumber : arrayList) {
            if (myNumber > minNumber)
                minNumber = myNumber;
        }
        return minNumber;
    }
}
