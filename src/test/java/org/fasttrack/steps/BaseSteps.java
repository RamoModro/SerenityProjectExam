package org.fasttrack.steps;

import net.bytebuddy.utility.RandomString;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrack.pages.*;
import org.fasttrack.utils.Constants;

public class BaseSteps extends ScenarioSteps {

    public HomePage homePage;
    public MyAccountPage myAccountPage;
    public SearchResultsPage searchResultsPage;
    public ProductPage productPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public LoginPage loginPage;
    public HomePageAdmin homePageAdmin;
    public AdminOrdersPage adminOrdersPage;
    public AdminCouponsPage adminCouponsPage;
    public AdminUsersPage adminUsersPage;

    RandomString randomString = new RandomString();
    String random = randomString.nextString();

    @Step
    public void navigateToHomePage() {
        getDriver().get(Constants.BASE_URL);
    }

    @Step
    public void navigateToAdminHomePage(){
        getDriver().get(Constants.BASE_ADMIN_URL);
    }
}
