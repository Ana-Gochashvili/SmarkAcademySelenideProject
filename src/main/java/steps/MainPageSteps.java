package steps;

import com.codeborne.selenide.SelenideElement;
import elements.MainPage;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;

public class MainPageSteps extends MainPage {

    @Step("Returns the number of banners")
    public int getBannersNumber() {
        return banners.size();
    }

    @Step("Returns the background color of banners")
    public String getBannersBackgroundColor(SelenideElement element) {
        return element.getCssValue("background-color");
    }

    @Step("Returns Pharmacy banner")
    public SelenideElement getPharmacyBanner() {
        return banners.filterBy(text("აფთიაქი")).first();
    }

    @Step("Returns FamilyCare banner")
    public SelenideElement getFamilyCareBanner() {
        return banners.filterBy(text("ოჯახზე ზრუნვა")).first();
    }

    @Step("Returns Beauty banner")
    public SelenideElement getBeautyBanner() {
        return banners.filterBy(text("სილამაზე")).first();
    }

    @Step("Clicks basket button")
    public void goToBasket() {
        basket.click();
    }

    public void checkBasketButton() {
        basket.shouldBe(visible, clickable);
    }

    @Step("Clicks Beauty banner")
    public BeautyPageSteps goToBeautyPage() {
        banners.filterBy(text("სილამაზე")).get(0)
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();

        return new BeautyPageSteps();
    }

    @Step("Clicks Family Care banner")
    public FamilyCarePageSteps goToFamilyCarePage() {
        banners.filterBy(text("ოჯახზე ზრუნვა")).get(0)
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();

        return new FamilyCarePageSteps();
    }


}
