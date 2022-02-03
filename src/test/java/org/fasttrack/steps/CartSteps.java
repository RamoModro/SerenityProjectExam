package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class CartSteps extends BaseSteps {

    @Step
    public void clickAddProductToCart() {
        productPage.clickAddToCartButton();
    }

    @Step
    public void checkProductIsInCart(String productName) {
        Assert.assertTrue("The product was not added to the cart", cartPage.isProductInCart(productName));
    }

    @Step
    public void changeProductQuantity(String quantity) {
        cartPage.typeInQuantity(quantity);
        cartPage.updateCart();
    }

    @Step
    public void checkProductQuantityIsUpdated(Integer newQuantity) {
        cartPage.getProductQuantity();
        Assert.assertTrue("The product quantity was not changed", cartPage.checkProductQuantityIsUpdatedInCart(newQuantity));
    }

    @Step
    public void cartProductSubtotalCalculation() {
        cartPage.getFirstProductPrice();
        cartPage.getProductQuantity();
        cartPage.getCartProductsSubtotals();
        cartPage.calculateCartFirstLineSubtotal();
    }

    @Step
    public void verifyProductSubtotalCalculation(){
        Assert.assertTrue("The subtotal is not correct",cartPage.verifyCartFirstLineSubtotal());
    }

    @Step
    public void removeFirstItemFromCart(){
        cartPage.removeItemFromCart();
    }

    @Step
    public void waitForTextToDisappear(String text){
        cartPage.waitForTextToDisappearFromCart(text);
    }

    @Step
    public void checkProductWasRemovedFromCart(String removedProductName){
        Assert.assertTrue("The product was not removed from the cart",cartPage.checkProductWasRemovedFromCart(removedProductName));
    }

    @Step
    public void undoRemoveItemFromCart(){
        cartPage.undoRemoveItemFromCart();
    }

    @Step
    public void waitForTextToAppear(String text){
        cartPage.waitForTextToAppearInCart(text);
    }

    @Step
    public void clickCheckoutButton(){
        cartPage.clickOnCheckoutButton();
    }

    @Step
    public void useCouponCode(String couponCode){
        cartPage.enterCouponCode(couponCode);
        cartPage.clickApplyCouponButton();
    }

    @Step
    public void verifyCouponCodeIsDisplayedInCartTotals(String couponCode){
        Assert.assertTrue("The discount amount is not visible in cart",cartPage.verifyCouponCodeIsDisplayedInCartTotals(couponCode));
    }

    @Step
    public void cartTotalCalculation(){
        cartPage.getCartSubtotal();
        cartPage.getCartDiscountValue();
        cartPage.getCartTotalValue();
    }

    @Step
    public void verifyCartTotalCalculationWithDiscount(){
        Assert.assertTrue("The total after coupon code applied is not calculated correct",cartPage.verifyCartTotalCalculationWithDiscount());
    }
}
