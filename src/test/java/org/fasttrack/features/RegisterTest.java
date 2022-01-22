package org.fasttrack.features;

import net.bytebuddy.utility.RandomString;
import org.junit.Test;

public class RegisterTest extends BaseTest {

    RandomString randomString = new RandomString();
    String random = randomString.nextString();

    @Test
    public void registerNewUser(){
    registerSteps.clickLoginButton();
    registerSteps.enterCredentials();
    registerSteps.clickRegisterButton();
    registerSteps.checkNewUserIsLoggedIn(random);
    }
}
