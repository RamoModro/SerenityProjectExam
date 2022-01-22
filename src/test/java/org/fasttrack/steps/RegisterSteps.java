package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class RegisterSteps extends BaseSteps {

    @Step
    public void clickLoginButton() {
        homePage.clickLoginButton();
    }

    @Step
    public void enterCredentials() {
        homePage.setEmailField(random + "email");
        homePage.setPasswordField("Fasttrack123@");
    }

    @Step
    public void clickRegisterButton() {
        homePage.clickRegisterButton();
    }

    @Step
    public void checkNewUserIsLoggedIn(String userName){
        myAccountPage.checkUserLoggedInText(userName);
    }
}

