package steps;

import elements.AuthorizationPopUp;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;

public class AuthorizationPopUpSteps extends AuthorizationPopUp {

    @Step("Check authorization pop up title")
    public void checkAuthorizationPopUpTitle(){
        popupTitle.shouldHave(text("ავტორიზაცია"));
    }
}
