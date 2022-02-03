package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class CheckoutSteps extends BaseSteps{

    @Step
    public void isCheckoutPageDisplayed() {
        Assert.assertTrue("User is not redirected to Checkout Page", checkoutPage.isUserInCheckoutPage());
    }

    String orderNumberValue;

    public String getOrderNumberValue(){
        return orderNumberValue;
    }

    @Step
    public void insertBillingDetails(String firstName, String lastName, String address, String name, String value, String number){
        checkoutPage.setFirstNameField(firstName);
        checkoutPage.setLastNameField(lastName);
        checkoutPage.setStreetName(address);
        checkoutPage.setCityField(name);
        checkoutPage.setPostcode(value);
        checkoutPage.setPhoneField(number);
    }

    @Step
    public void clickPlaceOrder(){
        checkoutPage.clickProceedOrderButton();
        checkoutPage.waitForTextToAppear("ORDER RECEIVED");
        checkoutPage.getOrderNumber();
    }

    @Step
    public void isOrderConfirmationPageDisplayed() {
        Assert.assertTrue("User is not redirected to Checkout - Order Confirmation Page", checkoutPage.isUserInOrderConfirmationPage());
    }
}
