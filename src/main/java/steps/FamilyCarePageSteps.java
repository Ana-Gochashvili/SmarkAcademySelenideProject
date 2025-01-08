package steps;

import elements.FamilyCarePage;
import io.qameta.allure.Step;

import java.time.Duration;

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
        dropdownButtons.get(0)
                .shouldBe(clickable)
                .click();
        return this;
    }

    @Step("Select Number Of Item On Page Button")
    public void selectNumberOfItemOnPage() {
        numberOfItem.find(attribute("value", "40"))
                .shouldBe(clickable, Duration.ofSeconds(30))
                .click();
    }

    @Step("Returns Number Of Item On Page")
    public String getNumberOfItemOnPage() {
        return numberOfItemValue.getText();
    }

    @Step("Clicks Order Items By Choice Button")
    public FamilyCarePageSteps clickOrderItemsByChoiceButton() {
        dropdownButtons.get(1)
                .shouldBe(clickable)
                .click();
        return this;
    }

    @Step("Selects Order Items By Choice Button")
    public void selectOrderItemsByChoiceButton() {
        numberOfItem.find(attribute("value", "price_DESC"))
                .shouldBe(visible)
                .click();
    }

    @Step("Returns order by text")
    public String getOrderItemsByText() {
        return orderBy.getText();
    }
}
