package org.fasttrack.features;

import org.junit.Test;

public class CartTest extends BaseTest{

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
    public void checkCartProductSubtotal(){
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
    public void checkRemoveItemFromCart(){
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
    public void checkRemoveItemFromCartUndo(){
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
}
