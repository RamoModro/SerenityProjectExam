package org.fasttrack.features;

import org.junit.Test;

public class CartTest extends BaseTest {

    @Test
    public void checkProductIsAddedToCart() {
        loginSteps.navigateToHomePage();
        searchSteps.executeSearch("Cap");
        productSteps.addProductToCart();
        productSteps.clickViewCart();
        cartSteps.checkProductIsInCart("Cap");
    }

    @Test
    public void checkModifyProductQuantityInCart() {
        loginSteps.navigateToHomePage();
        searchSteps.executeSearch("Cap");
        productSteps.addProductToCart();
        productSteps.clickViewCart();
        cartSteps.changeProductQuantity("5");
        cartSteps.checkProductQuantityIsUpdated(5);
    }

    @Test
    public void checkCartProductSubtotal() {
        loginSteps.navigateToHomePage();
        searchSteps.executeSearch("Polo");
        productSteps.addProductToCart();
        searchSteps.executeSearch("Cap");
        productSteps.addProductToCart();
        productSteps.clickViewCart();
        cartSteps.changeProductQuantity("3");
        cartSteps.cartProductSubtotalCalculation();
        cartSteps.verifyProductSubtotalCalculation();
    }

    @Test
    public void checkRemoveItemFromCart() {
        loginSteps.navigateToHomePage();
        searchSteps.executeSearch("Polo");
        productSteps.addProductToCart();
        searchSteps.executeSearch("Cap");
        productSteps.addProductToCart();
        productSteps.clickViewCart();
        cartSteps.removeFirstItemFromCart();
        cartSteps.waitForTextToDisappear("Polo");
        cartSteps.checkProductWasRemovedFromCart("Polo");
    }

    @Test
    public void checkRemoveItemFromCartUndo() {
        loginSteps.navigateToHomePage();
        searchSteps.executeSearch("Polo");
        productSteps.addProductToCart();
        searchSteps.executeSearch("Cap");
        productSteps.addProductToCart();
        productSteps.clickViewCart();
        cartSteps.removeFirstItemFromCart();
        cartSteps.waitForTextToDisappear("Polo");
        cartSteps.undoRemoveItemFromCart();
        cartSteps.waitForTextToAppear("Polo");
        cartSteps.checkProductIsInCart("Polo");
    }

    @Test
    public void verifyCheckoutPageIsDisplayed() {
        loginSteps.navigateToHomePage();
        searchSteps.executeSearch("Polo");
        productSteps.addProductToCart();
        productSteps.clickViewCart();
        cartSteps.clickCheckoutButton();
        checkoutSteps.isCheckoutPageDisplayed();
    }

    @Test
    public void checkCouponCodeIsDisplayedInCart(){
        loginSteps.navigateToHomePage();
        searchSteps.executeSearch("Polo");
        productSteps.addProductToCart();
        productSteps.clickViewCart();
        cartSteps.useCouponCode("fixed15");
        cartSteps.verifyCouponCodeIsDisplayedInCartTotals("FIXED15");
    }

    @Test
    public void checkCartTotalWithCouponCode(){
        loginSteps.navigateToHomePage();
        searchSteps.executeSearch("Polo");
        productSteps.addProductToCart();
        productSteps.clickViewCart();
        cartSteps.useCouponCode("fixed15");
        cartSteps.cartTotalCalculation();
        cartSteps.verifyCartTotalCalculationWithDiscount();
    }
}
