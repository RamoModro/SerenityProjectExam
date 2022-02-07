package org.fasttrack.features;

import org.fasttrack.utils.Constants;
import org.junit.Test;

public class CheckoutTest extends BaseTest{

    @Test
    public void checkOrderConfirmationPageIsDisplayed() {
        loginSteps.navigateToHomePage();
        loginSteps.doLogin(Constants.USER_EMAIL, Constants.USER_PASS);
        searchSteps.executeSearch("Cap");
        productSteps.addProductToCart();
        productSteps.clickViewCart();
        cartSteps.clickCheckoutButton();
        checkoutSteps.insertBillingDetails( "Ramona", "Modrogan", "Strada Rebreanu3", "Cluj-Napoca","400234","076655778");
        checkoutSteps.clickPlaceOrder();
        checkoutSteps.isOrderConfirmationPageDisplayed();
    }
}
