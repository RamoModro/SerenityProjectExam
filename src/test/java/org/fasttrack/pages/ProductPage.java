package org.fasttrack.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductPage extends BasePage {

    @FindBy(className = "single_add_to_cart_button")
    private WebElementFacade addToCartButton;

    @FindBy(css = "[class*='wc-forward']")
    public WebElementFacade viewCartButton;

    public void clickAddToCartButton(){
        clickOn(addToCartButton);
    }

    public void clickViewCartButton(){
        clickOn(viewCartButton);
    }
}


