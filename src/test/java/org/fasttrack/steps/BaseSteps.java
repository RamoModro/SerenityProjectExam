package org.fasttrack.steps;

import net.bytebuddy.utility.RandomString;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrack.pages.HomePage;
import org.fasttrack.pages.MyAccountPage;
import org.fasttrack.utils.EnvConstants;

public class BaseSteps extends ScenarioSteps {

    public HomePage homePage;
    public MyAccountPage myAccountPage;
    RandomString randomString = new RandomString();
    String random = randomString.nextString();

    @Step
    public void navigateToHomePage() {
        getDriver().get(EnvConstants.BASE_URL);
    }

}
