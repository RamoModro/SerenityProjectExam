package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage{

    @FindBy(css = "[class*='cart-item'] .product-name")
    private List<WebElementFacade> cartProductNames;

    @FindBy(css = ".quantity input")
    private WebElementFacade productQuantityInputField;

    @FindBy(css = "button[name='update_cart']")
    private WebElementFacade updateCartButton;

    @FindBy(css = "[class*='cart-item'] [class*='product-quantity']")
    private WebElementFacade productQuantityField;

    @FindBy(css = "[class*='cart-item'] .product-price")
    private WebElementFacade cartFirstProductPrice;

    @FindBy(css = "[class*='cart-item'] .product-subtotal")
    private List<WebElementFacade> cartProductSubtotal;

    @FindBy(css = "[class*='cart-item'] .product-remove a")
    private WebElementFacade removeFromCartButton;

    @FindBy(css = ".woocommerce-cart-form")
    private WebElementFacade cartContainer;

    @FindBy(css = ".restore-item")
    private WebElementFacade undoRemoveItemFromCartLink;

    @FindBy(css = ".checkout-button")
    private WebElementFacade checkoutButton;

    @FindBy(id = "coupon_code")
    private WebElementFacade couponCodeField;

    @FindBy(css = "[name='apply_coupon']")
    private WebElementFacade applyCouponButton;

    @FindBy(css = ".cart_totals")
    private WebElementFacade cartTotalsContainer;

    @FindBy(css = ".cart-subtotal td")
    private WebElementFacade cartSubtotal;

    @FindBy(css = ".order-total td")
    private WebElementFacade cartTotal;

    @FindBy(css = ".cart-discount td")
    private WebElementFacade cartDiscount;

    public boolean isProductInCart(String productName) {
        for (WebElementFacade element : cartProductNames) {
            if (element.getText().contains(productName)) {
                return true;
            }
        }
        return false;
    }

    public void typeInQuantity(String quantity) {
        typeInto(productQuantityInputField, quantity);
    }

    public void updateCart() {
        clickOn(updateCartButton);
        waitABit(3000);
    }

    private Integer productQuantity;
    public Integer getProductQuantity() {
        productQuantity = productQuantity.valueOf(productQuantityInputField.getAttribute("value"));
        return productQuantity;
    }

    public boolean checkProductQuantityIsUpdatedInCart(Integer newQuantity) {
        return getProductQuantity().equals(newQuantity);
    }

    private Integer cartFirstProductPriceValue;
    public void getFirstProductPrice() {
        cartFirstProductPriceValue = Integer.parseInt(cartFirstProductPrice.getText().replace("lei", "").replace(".", ""));
    }

    private Integer productSubtotal;
    List<Integer> cartProductsSubtotalValues = new ArrayList<>();
    public List<Integer> getCartProductsSubtotals() {
        for (WebElementFacade element : cartProductSubtotal) {
            productSubtotal = Integer.parseInt(element.getText().replace("lei", "").replace(".", ""));
            cartProductsSubtotalValues.add(productSubtotal);
        }
        return cartProductsSubtotalValues;
    }

    private Integer lineSubtotal;
    public void calculateCartFirstLineSubtotal() {
        lineSubtotal = cartFirstProductPriceValue * productQuantity;
    }

    public boolean verifyCartFirstLineSubtotal() {
        return (lineSubtotal.equals(getCartProductsSubtotals().get(0)));
    }

    public void removeItemFromCart() {
        clickOn(removeFromCartButton);
    }

    public void waitForTextToDisappearFromCart(String text) {
        waitForTextToDisappear(cartContainer, text);
    }

    public boolean checkProductWasRemovedFromCart(String removedProductName) {
        for (WebElementFacade element : cartProductNames) {
            return !element.getText().contains(removedProductName);
        }
        return false;
    }

    public void undoRemoveItemFromCart() {
        clickOn(undoRemoveItemFromCartLink);
    }

    public void waitForTextToAppearInCart(String text) {
        waitForTextToAppear(cartContainer, text);
    }

    public void clickOnCheckoutButton(){
        clickOn(checkoutButton);
    }

    public void enterCouponCode(String couponCode) {
        typeInto(couponCodeField, couponCode);
    }

    public void clickApplyCouponButton(){
        clickOn(applyCouponButton);
    }

    public boolean verifyCouponCodeIsDisplayedInCartTotals(String couponCode) {
        return cartTotalsContainer.containsText(couponCode);
    }

    private Integer cartSubtotalValue;
    public void getCartSubtotal() {
        cartSubtotalValue = Integer.parseInt(cartSubtotal.getText().replace("lei", "").replace(".", ""));
    }

    private Integer cartDiscountValue;
    public void getCartDiscountValue(){
        cartDiscountValue = cartDiscountValue.valueOf(cartDiscount.getText().replaceAll("[^0-9]",""));
    }

    private Integer cartTotalValue;
    public void getCartTotalValue(){
        cartTotalValue = Integer.parseInt(cartTotal.getText().replace("lei","").replace(".", ""));
    }

    private Integer calculatedCartTotal;
    public boolean verifyCartTotalCalculationWithDiscount(){
        calculatedCartTotal = cartSubtotalValue - cartDiscountValue;
        return calculatedCartTotal.equals(cartTotalValue);
    }

}
