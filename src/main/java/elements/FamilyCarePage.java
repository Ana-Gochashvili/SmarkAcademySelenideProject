package elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class FamilyCarePage {
    protected SelenideElement
            childrenCosmetics = $(byAttribute("for", "სათამაშოები")).$(".checkbox__mark"),
            childrenCosmeticsCheckbox = $(byName("სათამაშოები")),
            selectFilterButton = $(byText("არჩევა")),
            title = $(".category__title"),
            numberOfItemValue = $x("//*[@id=\"app\"]/div[2]/div/div/div[3]/div[3]/div[1]/div[2]/ul/li[1]/div/button"),
            orderBy = $x("//*[@id=\"app\"]/div[2]/div/div/div[3]/div[3]/div[1]/div[2]/ul/li[2]/div/button");

    protected ElementsCollection dropdownButtons = $$(".dropdown__button-arrow"),
            numberOfItem = $$(".dropdown__item");
}
