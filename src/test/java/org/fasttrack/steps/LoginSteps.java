package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrack.utils.Constants;
import org.junit.Assert;

public class LoginSteps extends BaseSteps{

    @Step
    public void goToLogin() {
        homePage.clickMyAccountButton();
    }

    @Step
    public void enterCredentials(String email, String pass){
        homePage.setUsernameField(email);
        homePage.setLoginPasswordField(pass);
    }

    @Step
    public void clickLoginButton(){
        homePage.clickLoginButton();
    }

    @Step
    public void checkUserIsLoggedIn(String userName){
        myAccountPage.checkUserLoggedIn(userName);
    }

    @Step
    public void checkNotLoggedIn(){
        loginPage.checkInvalidCredentialsMessage();
    }

    @Step
    public void clickLogOutLink(){
        myAccountPage.clickLogOut();
    }

    @Step
    public void checkLoggedOut(){
        Assert.assertTrue("Logout not performed",homePage.isLoggedOut());
    }

    @Step
    public void doLogin(String user, String pass){
        goToLogin();
        enterCredentials(user,pass);
        clickLoginButton();
    }

    @Step
    public void performAdminLogin(String user, String pass){
        loginPage.setLoginUserNameOrEmailAddressField(user);
        loginPage.setLoginPasswordField(pass);
        loginPage.clickLoginButton();
    }
}
