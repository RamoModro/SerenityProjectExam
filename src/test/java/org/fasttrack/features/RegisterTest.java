package org.fasttrack.features;

import net.bytebuddy.utility.RandomString;
import org.fasttrack.utils.Constants;
import org.junit.Test;

public class RegisterTest extends BaseTest {

    RandomString randomString = new RandomString();
    String random = randomString.nextString();

    @Test
    public void registerNewUser(){
    registerSteps.goToRegistration();
    registerSteps.enterCredentials(random+"email", Constants.USER_PASS);
    registerSteps.clickRegisterButton();
    }
}
