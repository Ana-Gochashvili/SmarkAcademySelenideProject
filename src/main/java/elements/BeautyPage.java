package elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class BeautyPage {
    protected SelenideElement
            title = $(".category__title"),
            sliderRoundButton = $(".slider"),
            sliderRoundButtonCheckbox = $x("//label[@class='switch']/input[@type='checkbox']"),
            selectFilterButton = $(byText("არჩევა")),
            yaeCareCategory = $(byAttribute("for","თვალის მოვლა")).$(".checkbox__mark"),
            yaeCareCategoryCheckbox = $(byName("თვალის მოვლა")),
            minPrice = $("#priceMin"),
            maxAPrice = $("#priceMax"),
            clearFilterButton = $x("//button[contains(@class,'category__filter-button')]");


    protected ElementsCollection
            products = $$(".product");

}
