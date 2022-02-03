package org.fasttrack.features;

import net.bytebuddy.utility.RandomString;
import org.fasttrack.utils.Constants;
import org.junit.Test;

public class RegisterTest extends BaseTest {

    RandomString randomString = new RandomString();
    String random = randomString.nextString();

    @Test
    public void registerNewUserTest() {
        registerSteps.goToRegistration();
        registerSteps.enterCredentials(random + "@email.com", Constants.USER_PASS);
        registerSteps.clickRegisterButton();
        registerSteps.checkUserIsLoggedInOrRegistered(random);
    }

    @Test
    public void checkUserIsInAdminUserList() {
        loginSteps.navigateToAdminHomePage();
        loginSteps.performAdminLogin(Constants.ADMIN_EMAIL, Constants.ADMIN_PASS);
        adminSteps.openUsersPage();
        adminSteps.searchUserInAdminUsersPage(Constants.USER_NAME);
        adminSteps.verifyTextInBodyList(Constants.USER_NAME);
    }
}
