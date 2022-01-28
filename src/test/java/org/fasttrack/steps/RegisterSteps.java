package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class RegisterSteps extends BaseSteps {

    @Step
    public void goToRegistration() {
        homePage.clickMyAccountButton();
    }

    @Step
    public void enterCredentials(String email, String pass) {
        homePage.setEmailField(random + "email");
        homePage.setPasswordField("Fasttrack123@");
    }
    @Step
    public void clickRegisterButton(){
        homePage.clickRegisterButton();
    }

}

