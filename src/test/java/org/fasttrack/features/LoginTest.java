package org.fasttrack.features;

import org.fasttrack.utils.Constants;
import org.junit.Test;

public class LoginTest extends BaseTest{

    @Test
    public void loginWithValidEmailTest(){
        loginSteps.goToLogin();
        loginSteps.enterCredentials(Constants.USER_EMAIL,Constants.USER_PASS);
        loginSteps.clickLoginButton();
        loginSteps.checkUserIsLoggedIn(Constants.USER_NAME);
    }

    @Test
    public void loginWithValidUserNameTest(){
        loginSteps.goToLogin();
        loginSteps.enterCredentials(Constants.USER_NAME,Constants.USER_PASS);
        loginSteps.clickLoginButton();
        loginSteps.checkUserIsLoggedIn(Constants.USER_NAME);
    }

    @Test
    public void loginWithInValidEmailTest(){
        loginSteps.goToLogin();
        loginSteps.enterCredentials("sdfds.fsfd@email.com", Constants.USER_PASS);
        loginSteps.clickLoginButton();
        loginSteps.checkUserIsLoggedIn(Constants.USER_NAME);
    }

    @Test
    public void checkLogoutLink(){
        loginSteps.goToLogin();
        loginSteps.enterCredentials(Constants.USER_EMAIL,Constants.USER_PASS);
        loginSteps.clickLoginButton();
        loginSteps.clickLogOutLink();
        loginSteps.checkLoggedOut();
    }
}
