package elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class MainPage {
    protected final  ElementsCollection banners = $$(".banner");
    protected final SelenideElement basket = $(byText("კალათა"));
}
