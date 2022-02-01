package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;

public class ProductSteps extends BaseSteps{

    @Step
    public void addProductToCart() {
        productPage.clickAddToCartButton();
    }

    @Step
    public void clickViewCart() {
        productPage.clickViewCartButton();
    }

}

